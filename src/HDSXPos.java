import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.math.NumberUtils;

public class HDSXPos {

	private HashMap<Integer, RowRecord> valuePair; //Map of RowRecords that qualify as matches
	private HashMap<String, ArrayList<RowRecord>> matchMap; //Holds an arraylist of matches for the index of the Report Record Number
	private HashSet<String> reportRecordNumbers; //Used to check if the Report Record Number of the current iteration has been added to the list in O(1)
	private ArrayList<Object[]> outList; //Output list of transposed rows
	private String header; //List of columns in output CSV
	private String inFile; //Directory of input CSV
	private String outFile; //Name of output file
	private String dir; //Directory of output files
	private int fileWidth; //Amount of Columns on the XPosed Sheet
	private static final String NEW_LINE_SEPARATOR = "\n"; //Line separator for CSV Commons

	public HDSXPos(SpecSheet specSheet, String inFile, String outFile) {
		this.valuePair = specSheet.getMap();
		this.reportRecordNumbers = new HashSet<String>();
		this.matchMap = new HashMap<String, ArrayList<RowRecord>>();
		this.outList = new ArrayList<Object[]>();
		this.fileWidth = 1 + specSheet.getFileWidth();
		//Directory Generation
		this.dir = System.getProperty("user.dir") + "/sql/";
		this.inFile = inFile;
		this.outFile = dir + outFile;
		File outDir = new File("sql");
		outDir.mkdir();
	}

	private void writeCSV() {
		FileWriter fileWriter = null;
		CSVPrinter csvFilePrinter = null;
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
		try {
			fileWriter = new FileWriter(outFile);
			csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
			Object[] splitHeader = header.split(";");
			csvFilePrinter.printRecord(splitHeader);
			for (Object[] s : outList) {
				csvFilePrinter.printRecord(s);
			}
		} catch (Exception e) {
			System.out.println("Error in filewriter");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
				e.printStackTrace();

			}
		}
	}

	public boolean recordHasMatch(RowRecord rec) {
		for (RowRecord r : valuePair.values()) {
			if (r.equals(rec)) {
				return true;
			}
			if (r.isChained() && r.getChainOperation().equals("subrow")) {
				int baseRow = Integer.parseInt(r.getRow());
				int lower = baseRow + r.getRangeLower();
				int upper = baseRow + r.getRangeUpper();
				int recRow = Integer.parseInt(rec.getRow());
				if (recRow >= lower && recRow <= upper && rec.getCol().equals(r.getCol()) && rec.getWorksheet().equals(r.getWorksheet())) {
					return true;
				}
			}
		}
		return false;
	}

	public void generate() {
		try {
			header = "rep_rec_num";
			for (int key : valuePair.keySet()) {
				header += ";" + valuePair.get(key).getHeader();
			}
			Reader in = new FileReader(inFile);
			Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
			long start = System.currentTimeMillis();
			System.out.println("Starting match");
			for (CSVRecord record : records) {
				if (recordHasMatch(new RowRecord(record.get(1), record.get(2), record.get(3)))) {
					ArrayList<RowRecord> tempMatches;
					if((tempMatches = matchMap.get(record.get(0))) != null)
					{
						tempMatches.add(new RowRecord(record.get(0), record.get(1), record.get(2), record.get(3), record.get(4)));
					}
					else
					{
						tempMatches = new ArrayList<RowRecord>();
						tempMatches.add(new RowRecord(record.get(0), record.get(1), record.get(2), record.get(3), record.get(4)));
						matchMap.put(record.get(0), tempMatches);
					}
				}
				if (!reportRecordNumbers.contains(record.get(0))) {
					reportRecordNumbers.add(record.get(0));
				}
			}

			for (String repRec : matchMap.keySet()) {
				Object[] row = new Object[fileWidth];
				row[0] = repRec;
				ArrayList<RowRecord> tempMatch;
				if((tempMatch = matchMap.get(repRec)) != null)
				{
				// Check records for matches
				for (RowRecord record : tempMatch) {
						// Check values in hashMap for match
						for (int key : valuePair.keySet()) {
							int valInt = 0;
							double valDouble = 0.00;
							BigInteger valBigInt = null;
							RowRecord mapRecord = valuePair.get(key);
							if (mapRecord.equals(record)) {
								String recordValue = record.getValue();
								if (NumberUtils.isNumber(recordValue)) {
									if (recordValue.contains(".")) {
										valDouble = Double.parseDouble(recordValue);
										row[key] = valDouble;
									} else {
										if(recordValue.length() > 9)
										{
											valBigInt = new BigInteger(recordValue);
											row[key] = valBigInt;
										}
										else
										{
										valInt = Integer.parseInt(recordValue);
										row[key] = valInt;
										}
									}
								} else {
									row[key] = recordValue;
								}
							}
							if (mapRecord.isChained()) {
								// Subrow chaining mostly used for addition of multiple rows under same column for same topic
								// Determines subrow by checking upper and lower bounds of subrow range while comparing to current row value
								if (mapRecord.getChainOperation().equals("subrow")) {
									int baseRow = Integer.parseInt(mapRecord.getRow());
									int lower = baseRow + mapRecord.getRangeLower();
									int upper = baseRow + mapRecord.getRangeUpper();
									int recRow = Integer.parseInt(record.getRow());
									if (recRow >= lower && recRow <= upper && record.getCol().equals(mapRecord.getCol())
											&& record.getWorksheet().equals(mapRecord.getWorksheet())) {
										String recordValue = record.getValue();
										if (row[key] != null) {
											if(row[key] instanceof BigInteger)
											{
												if(valBigInt != null)
												{
												valBigInt.add(new BigInteger(recordValue));
												}
												else
												{
													valBigInt = new BigInteger(recordValue);
												}
												row[key] = ((BigInteger) row[key]).add(valBigInt);
											}
											if (row[key] instanceof Integer) {
												valInt += Integer.parseInt(recordValue);
												row[key] = (Integer) row[key] + valInt;
											} else if (row[key] instanceof Double) {
												valDouble += Double.parseDouble(recordValue);
												row[key] = (Double) row[key] + valDouble;
											}
										} else {
											row[key] = recordValue;
										}
									}
								}
							}
						}
				}
			}
				for(RowRecord rec : valuePair.values())
				{
					int index = rec.getMapIndex();
					if(row[index] == null && rec.isNumeric())
					{
						row[index] = 0;
					}
				}
					for(RowRecord rec : valuePair.values())
					{
						if(rec.isChained() && rec.getChainOperation().equals("total"))
						{
							int[] indices = rec.getTotalIndices();
							double total = 0;
							BigInteger bigTotal = null;
							for(int i = 0; i < indices.length; i++)
							{
								if(row[indices[i]] instanceof Double)
								{
									total += (double) row[indices[i]];
								}
								else if(row[indices[i]] instanceof Integer)
								{
									total += (double) ((Integer)row[indices[i]]).intValue();
								}
								else if(row[indices[i]] instanceof BigInteger)
								{
									if(bigTotal != null)
									{
										bigTotal.add((BigInteger)row[indices[i]]);
									}
									else
									{
										bigTotal = (BigInteger)row[indices[i]];
									}
								}
								
							}
							if(bigTotal == null)
							{
								row[rec.getMapIndex()] = total;
							}
							else if(total == 0 && bigTotal.intValue() > 0)
							{
								row[rec.getMapIndex()] = bigTotal;
							}
							else
							{
								row[rec.getMapIndex()] = bigTotal.add(BigDecimal.valueOf(total).toBigInteger());
							}
							
						}
					}
				outList.add(row);
			}
			writeCSV();
			long end = System.currentTimeMillis();
			System.out.println(outFile + " was created successfully.");
			System.out.println("Time: " + (((double) (end - start)) / 1000) + " seconds");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
