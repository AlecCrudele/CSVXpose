import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serializer {

	public void saveSpecSheet(SpecSheet saveSheet, String fileLoc) {
		try {
			FileOutputStream fout = new FileOutputStream(fileLoc);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(saveSheet);
			oos.close();
			System.out.println(saveSheet.getSheetSection() + "." + saveSheet.getSheetName() + " was written to file successfully.");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
