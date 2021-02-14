package YUhacks2;


import java.io.FileWriter;
import java.io.IOException;
import org.json.*;

public class Converter {

	public Converter(String jsonFilePath, String excelFilePath) {
		this.makeFile(jsonFilePath, excelFilePath);
		System.out.println("PRINTED");	
	}
	public static void main(String[] args) {	
	}

	public  void makeFile(String jsonFilePath, String excelFilePath) {
		ExcelReader jsonFile = new ExcelReader(excelFilePath);
		org.json.JSONArray jArray = jsonFile.getArray();
		try {
			
			FileWriter file = new FileWriter(jsonFilePath);
			file.write(jArray.toString());
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
