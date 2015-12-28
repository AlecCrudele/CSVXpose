import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserializer {

	public SpecSheet loadSpecSheet(String fileLoc) {

		SpecSheet sheet;

		try {

			FileInputStream fin = new FileInputStream(fileLoc);
			ObjectInputStream ois = new ObjectInputStream(fin);
			sheet = (SpecSheet) ois.readObject();
			ois.close();

			return sheet;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
