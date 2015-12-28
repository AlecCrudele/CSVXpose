import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;

public class SpecSheet implements Serializable {

	private static final long serialVersionUID = 6618469841127325812L;
	private ArrayList<RowRecord> records;
	private HashMap<Integer, RowRecord> map;
	private HashSet<RowRecord> set;
	private int fileWidth;
	private String name;
	private String section;

	public SpecSheet(String section, String name) {
		this.records = new ArrayList<RowRecord>();
		this.map = new HashMap<Integer, RowRecord>();
		this.set = new HashSet<RowRecord>();
		this.name = name;
		this.section = section;
	}

	public void addRecord(RowRecord record, int mapIndex) {
		record.setMapIndex(mapIndex);
		records.add(record);
		map.put(mapIndex, record);
		set.add(record);
		fileWidth++;
	}

	public void addRecord(RowRecord record) {
		
		int index = 1;
		if (map.size() > 0) {
			for (int keys : map.keySet()) {
				if (keys >= index) {
					index = keys;
				}
			}
			index++;
		}
		record.setMapIndex(index);
		records.add(record);
		map.put(index, record);
		set.add(record);
		fileWidth++;
	}

	public boolean findRecordMatch(RowRecord record) {
		for (RowRecord rr : records) {
			if (record.equals(rr)) {
				return true;
			}
		}
		return false;
	}

	public boolean removeRecord(String header) {
		boolean found = false;
		int foundIndex = 0;
		int i = 0;
		for (RowRecord rr : records) {
			if (rr.getHeader().equals(header)) {
				found = true;
				foundIndex = i;
			}
			i++;
		}
		if (found == true) {
			records.remove(foundIndex);
			map = new HashMap<Integer, RowRecord>();
			set = new HashSet<RowRecord>();
			i = 1;
			for (RowRecord rr : records) {
				map.put(i, rr);
				i++;
				set.add(rr);
			}
			fileWidth--;
		}
		return found;
	}

	public ArrayList<RowRecord> getRecords() {
		return records;
	}

	public HashMap<Integer, RowRecord> getMap() {
		return map;
	}

	public HashSet<RowRecord> getHashSet() {
		return set;
	}

	public int getFileWidth() {
		return fileWidth;
	}

	public String getSheetName() {
		return name;
	}

	public String getSheetSection() {
		return section;
	}

	public boolean replaceRecord(RowRecord rec) {
		RowRecord old = null;
		for (RowRecord rr : records) {
			if (rec.getHeader().toLowerCase().equals(rr.getHeader())) {
				old = rr;
				rr = rec;
			}
		}
		if (old != null) {
			set.remove(old);
			set.add(rec);
			for (int keys : map.keySet()) {
				if (map.get(keys).equals(old)) {
					map.put(keys, rec);
					return true;
				}
			}
		}
		return false;
	}

	public RowRecord getRecord(String recordName) {
		for (RowRecord rr : records) {
			if (recordName.toLowerCase().equals(rr.getHeader().toLowerCase())) {
				return rr;
			}
		}
		throw new NoSuchElementException();
	}
}
