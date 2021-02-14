package YUhacks2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	String path = "";

	public ExcelReader(String excelFilePath) {
		path = excelFilePath;
	}

	public JSONArray getArray() {
		JSONArray JsonArray = this.makeArray();
		return JsonArray;
	}

	private JSONArray makeArray() {

		ArrayList<String> data;
		ArrayList<String> header = new ArrayList<String>();
		int i = -1;
		JSONArray JsonArray = new JSONArray(); // MY Json Array

		try {
			File file = new File(path); // creating a new instace of a file
			FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file
			// creating Workbook instance that refers to .xlsx file

			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
			Iterator<Row> itr2 = sheet.iterator();
			Iterator<Row> itr = sheet.iterator(); // iterating over excel file

			while (itr.hasNext()) {
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column

				JSONObject obj1 = new JSONObject();
				JSONObject obj = new JSONObject(); // Creating a NEw json Object
				data = new ArrayList<String>();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING: // field that represents string cell type

						String value = cell.getStringCellValue();
						data.add(value);

						if (JsonArray.length() == 0) {
							header.add(value);
						} else {
							obj.put(header.get(i), value);
						}
						break;

					case Cell.CELL_TYPE_NUMERIC: // field that represents number cell type
						String inum = String.valueOf((int) (cell.getNumericCellValue()));
						data.add(inum);
						if (JsonArray.length() == 0) {
							header.add(cell.getStringCellValue());
						} else {
							obj.put(header.get(i), inum);
						}

						break;
					default:
					}
					i++;
				}
				// JsonArray.
				String CompanyName = file.getName();
                CompanyName = CompanyName.substring(0,(CompanyName.length()-5));
				obj1 = new JSONObject(); // Creating a NEw json Object
				obj1.put(CompanyName, obj);
				JsonArray.put(obj1);
				if (obj.isEmpty() && (JsonArray.length() > 1)) {
					JsonArray.remove(JsonArray.length() - 1);
				}

				i = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonArray.remove(0);

		return JsonArray;

	}
}