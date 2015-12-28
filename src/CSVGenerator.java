import java.io.File;

public class CSVGenerator {

	private SpecSheetIO packager;
	private String dir;
	private SpecSheet single;

	public CSVGenerator() {
		this.packager = new SpecSheetIO();
		this.dir = packager.getDir();
	}
	
	public CSVGenerator(SpecSheet sheet)
	{
		this.packager = new SpecSheetIO();
		this.dir = packager.getDir();
		this.single = sheet;
	}

	public boolean go(String inFilePath) {
		File sheetDir = new File(dir);
		if (!sheetDir.exists()) {
			System.out.println("No SpecSheet folder has been created yet! Please use the SpecSheet Mapper before generating CSV Files.");
			return false;
		}
		File[] directoryListing = sheetDir.listFiles();
		if (directoryListing.length != 0) {
			long start = System.currentTimeMillis();
			for (File child : directoryListing) {
				SpecSheet current = packager.load(child.getName());
				HDSXPos hds = new HDSXPos(current, inFilePath, current.getSheetName() + ".csv");
				hds.generate();
			}
			long end = System.currentTimeMillis();
			System.out.println(
					"All Operations Completed. Check SQL folder for formatted CSV Files. Total time to complete: " + ((double) (((end - start) / 1000)) / 60)
							+ " minutes");
			return true;
		} else {
			System.out.println("No SpecSheet saves in \"sheets\" folder! Please use the SpecSheet Mapper before generating CSV Files.");
			return false;
		}
	}
	
	public boolean generateIndividual(String inFilePath)
	{
		if(single == null)
		{
			System.out.println("No SpecSheet Selected.");
			return false;
		}
		long start = System.currentTimeMillis();
		HDSXPos hds = new HDSXPos(single, inFilePath, single.getSheetName() + ".csv");
		hds.generate();
		long end = System.currentTimeMillis();
		System.out.println(
				"All Operations Completed. Check SQL folder for formatted CSV Files. Total time to complete: " + ((double) (((end - start) / 1000)) / 60)
						+ " minutes");
		return true;
	}
}
