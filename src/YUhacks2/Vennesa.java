package YUhacks2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class YUhacks2{
	static ArrayList<String> IDs = new ArrayList<String>();
	static ArrayList<String> Bdays = new ArrayList<String>();
	
	static String input = ""; // users ID input
	static String bday1 = "";
    static String comp = "";
	
	@SuppressWarnings("unchecked")

	
    public static void bob()
    {
        System.out.println(input+" "+bday1+" "+comp);

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        
        try (FileReader reader = new FileReader("/Users/vweed/eclipse-workspace/YUHacks2/files/ABC.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray employeeList = (JSONArray) obj;
//            System.out.println(employeeList);
             
            //Iterate over employee array.
            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ));
//            System.out.println(IDs);

        // Boolean IdCheck = Boolean1(input);
		// System.out.println(IdCheck);
		// Boolean BdayCheck = Boolean2(bday1);
		// System.out.println(BdayCheck);
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Boolean1(input);
        Boolean2(bday1);
    }
    
	public YUhacks2 (String companyName, String UserInput, String UserDOB){
        input= UserInput;
        bday1= UserDOB;
        comp = companyName;
    }

    public static void parseEmployeeObject(JSONObject employee) 
    {
        // JSONObject employee = new JSONObject();
        // JSONObject employee =YUhacks2.buildJson();
        
        JSONObject employeeObject = (JSONObject) employee.get(comp);// User input exployee.get("user.input")
       
//        System.out.println(employeeObject.size());
         
        String Name = (String) employeeObject.get("Employees Name");    
//        System.out.println(Name);
        
        
        String ID = (String) employeeObject.get("ID");
        IDs.add(ID);
        System.out.println(IDs);
       
         
        String birthday = (String) employeeObject.get("Birthday");
        Bdays.add(birthday);
        System.out.println(Bdays);

    }
    
    public static boolean Boolean1 (String input) {

    	boolean Boolean1 = false;
   	    System.out.print(input);
    		
			if(IDs.contains(input) == true) {
    			Boolean1 = true;
    		}
    		else return Boolean1 = false;
    		System.out.println(Boolean1);
    	return Boolean1;
    }
    
    public static boolean Boolean2 (String bday1) {
    	boolean Boolean2 = false;
   	System.out.print(bday1);
			if(Bdays.contains(bday1) == true) {
    			Boolean2 = true;
    		}
    		else return Boolean2 = false;
            System.out.println(Boolean2);
    	return Boolean2;
    }

    
//    static public JSONObject buildJson(){

//         //JSON parser object to parse read file
//         JSONParser jsonParser = new JSONParser();
        
//         try (FileReader reader = new FileReader("/Users/vweed/eclipse-workspace/YUHacks2/files/ABC.json"))
//         {
//             //Read JSON file
//             Object obj = jsonParser.parse(reader);
 
//             JSONArray employeeList = (JSONArray) obj;
             
//             //Iterate over employee array.
//             employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ));

            
            
//         } catch (FileNotFoundException e ) {
//             e.printStackTrace();
//         } catch (IOException e) {
//             e.printStackTrace();
//         } catch (ParseException e) {
//             e.printStackTrace();
//         }
//     }

    

}
