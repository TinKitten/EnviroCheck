package YUhacks2;

import java.io.File;
import java.io.FileReader;
import org.json.*;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.io.*;
import java.util.*;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.text.html.HTMLEditorKit.Parser;

import org.json.simple.parser.JSONParser;

public class HUB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to make the world a better place \n type (yes) or (no)");
		String userInput = sc.nextLine();
		
		while (userInput.equals("yes")){
			RunEverything();
		System.out.println("Would you like to make the world a better place \n type (yes) or (no)");//why is this duplicated?
		 userInput = sc.nextLine();
		}

		System.out.println("Have a good day , goodbye");

	

	}
	static private void RunEverything(){
		Scanner sc = new Scanner(System.in);
		// String userInput = sc.nextLine();
		// user enters company

		Boolean verification = false;

		System.out.println("Please enter your company name");
		String companyName = sc.nextLine();
		if ((HUB.DoesCompanyExist(companyName) == true)) { // This will return true if the company exsits
			String jsonFilePath = ("./files/" + companyName + ".xlsx");
			String excelFilePath = ("./files/" + companyName + ".json");

			// Converter C = new Converter(jsonFilePath, excelFilePath);
			Converter C = new Converter(excelFilePath, jsonFilePath);
			//  C.makeFile(jsonFilePath, excelFilePath);

			// survey shits

			verification = VennesaCode(companyName);
		} else {
			System.out.println("This commpany does not exist");
		}
		String averageScore="";
		if (verification) {			 
			// String name, String industry
			Company C = new Company(companyName);
			User user = User.makeUser(C, YUhacks2.input, YUhacks2.bday1);
			Survey2 survey = new Survey2();
			int total = survey.getTotal();
			System.out.println("The result of this survey is "+ total);
			
			averageScore = String.valueOf(survey.total);
			newJson(companyName,YUhacks2.input,averageScore );

		}
		else {
			System.out.println("You were not verfied ");
		} 
		
		// this.newJson(c,averageScore); // This makes 
	}

	static private boolean DoesCompanyExist(String name) {// This will check if the company exisits
		String userInput = name;
		String excelFilePath = "./files/";
		excelFilePath = excelFilePath + userInput + ".xlsx";
		File f = new File(excelFilePath);
		if (f.isFile()) {
			System.out.println("THIS FILE EXISTS: " + excelFilePath);

			return true;
		} else {
			System.out.println("THIS FILE DOESNT EXISTS: " + excelFilePath);
			return false;
		}
	}

	static private Boolean VennesaCode(String companyName) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input your employee ID");
		String ID = sc.nextLine();
		System.out.println("Please input your birthday");
		String birthday = sc.nextLine();

		YUhacks2.comp = companyName;
		YUhacks2.bday1 = birthday;
		YUhacks2.input = ID;
		YUhacks2.bob();
		if (YUhacks2.idCheck && YUhacks2.BDayCheck) {
			return true;
		} else {
			return false;
		}

		// YUhacks2.Boolean1(ID);
		// YUhacks2.Boolean1(birthday);
		// YUhacks2 YU = new YUhacks2(companyName ,ID, birthday);
		// YU.parseEmployeeObject();
		// Boolean IdCheck = YU.Boolean1(ID);
		// System.out.println(IdCheck);
		// Boolean BdayCheck = YU.Boolean2(birthday);
		// System.out.println(BdayCheck); // if ID, birthday is ok

		// if (IdCheck && BdayCheck == true) {
		// System.out.println("Please input your name");
		// String firstLast = sc.nextLine();
		// System.out.println("Please enter an Industry: Restaurants or Retail");
		// String industry = sc.nextLine();

		// Company comp = new Company(company, industry);

		// User John = User.makeUser(comp, firstLast, ID, birthday);
		// John.getDate();

		// } else {
		// System.out.println("NO");
		// }

		// / public static User makeUser(Company name, String ID, String dob) {

		// else // no sc.close();

	}


	static private void newJson(String companyName, String ID, String averageScore) {
		
	 	String pathtemp =("./files/"+companyName+ID+".json"); 
		//  org.json.JSONArray jArray = jsonFile.getArray();
		// JSONObject jsonObject = (JSONObject) jsonObject.get(companyName);
		


		try {
			JSONObject obj=new JSONObject();
			obj.put(ID,averageScore);
			FileWriter file = new FileWriter(pathtemp);
			file.write(obj.toString());
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	// 	ArrayList<String> xyz;
	// 	String path =("/Users/vweed/eclipse-workspace/YUHacks2/files/"+companyName+".json"); 
	// 	String ReadOut;
	// 	String jsonFilePath = ("");
	// 	JSONParser parser = new JSONParser();
	// 	try (FileReader reader = new FileReader(path))
	// 		{
	// 		Object obj = parser.parse(reader);
	// 		//JSONObject jsonObject = (JSONObject) obj;
	// 		JSONObject jsonObject = (JSONObject) jsonObject.get(companyName);
	// 		System.out.println(jsonObject);
			
	// 		xyz = new ArrayList<String>();
			
	// 		JSONArray newOne = (JSONArray) jsonObject.get(companyName);
	// 		Iterator<String> iterator = xyz.iterator();

	// 		while(iterator.hasNext()){
	// 			ReadOut = iterator.next().toString();
	// 		}

	// 		try {
			
	// 			FileWriter file = new FileWriter(jsonFilePath);
	// 			file.write(jArray.toString());
	// 			file.close();
	// 		} catch (IOException e) {
	// 			e.printStackTrace();
	// 		}

	// } catch (FileNotFoundException e) {
	// 	e.printStackTrace();
	// } catch (IOException e) {
	// 	e.printStackTrace();
	// } catch (Exception e) {
	// 	e.printStackTrace();
	// }
		
		
		
	// }

	}
	
}