/**
 * 
 */
package YUhacks2;
// import java.util.*;

/**
 * @author Denni
 *
 */
public class User {
	private final Company company;
	// private final String userName;
	private final String ID;
	private final String birthday;
	public Survey2 survey;
	
	private User(Company name, String ID, String dob) {// REMOVED String firstLast, -Adit
		this.ID = ID;
		// userName = firstLast;
		company = name; //WHY DIDN�T YOU USE this.company? Using company sets the global variable equal to name, which eventually breaks things since it�s a final var
		birthday = dob; //same thing here
	}
	
	public static User makeUser(Company name,  String ID, String dob) {// REMOVED String firstLast, -Adit
		return new User(name, ID, dob);
	}
	
// 	public static String getInfo() {
// 		Scanner sc = new Scanner(System.in);
// 		System.out.println("Please input the Company you work for");
// 		String company = sc.nextLine();
// 		System.out.println("Please input your employee ID");
// 		String ID = sc.nextLine();
// 		System.out.println("Please input your birthday");
// 		String birthday = sc.nextLine();
// 		return ID;
		
// //		cross-checking with the JSON thingy
// 	}
	
	public String getName() {return company.getIndustryName();} //THIS.company (we�d need to define a method getName for company)
	public String getID() {return ID;} //THIS.ID?
	public String getDate() {return birthday;}
	// public String getUser() { return userName;}
}
