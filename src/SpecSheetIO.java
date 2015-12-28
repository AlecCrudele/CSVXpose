import java.io.File;

public class SpecSheetIO {

	private String dir;
	private Serializer saver;
	private Deserializer loader;

	public SpecSheetIO() {
		this.dir = System.getProperty("user.dir") + "/sheets/";
		this.saver = new Serializer();
		this.loader = new Deserializer();
		// Creates new directory if not exists
		File dir = new File("sheets");
		dir.mkdir();
	}

	public void save(SpecSheet sheet, String fileName) {
		saver.saveSpecSheet(sheet, dir + fileName + ".spec");
	}

	public SpecSheet load(String fileName) {
		return (SpecSheet) loader.loadSpecSheet(dir + fileName);
	}

	public String getDir() {
		return dir;
	}
}
