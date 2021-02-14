package YUhacks2;

import java.util.ArrayList;
import java.util.*;

public class Survey2 {
	public ArrayList<Integer> answers;
	int numberOfQuestions = 0;
	int sum = 0;
	int total = 0;

	String options = "1 - Strongly Agree\n2 - Slightly Agree\n3 - Neither Agree / Disagree\n"
			+ "4 - Slightly Disagree\n5 - Strongly Disagree";

	Scanner sc = new Scanner(System.in); // to receive the input for the scores

	// public static ArrayList<Integer> counter;

	public Survey2() {
		answers = new ArrayList<>();
		makeSurvey();
	}

	public void makeSurvey() {

		System.out.println("Please Select which best describes your Industry"); // prompt to type in the number
		System.out.println("( Retail Clothing - (1) ) (Food Handling - (2) ) ");
		Integer value = sc.nextInt();
		if (value == 1) {
			this.makeSurvey1();
		}

		else if (value == 2) { // skiped groceries
			this.makeSurvey3();
		}
		System.out.println("the total score is: " + total); // PLEASE ADD TOTAL SCORE

	}

	private void makeSurvey1() {// Retail PLEASE ADD MORE QUESTIONS
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Do you think your company uses too much packaging? \n" + options);
		questions.add("Do you think your company uses too much plastic in their products? \n" + options);
		questions.add("Do you think your company does not reuse items as much as they should? \n" + options);
		questions.add(
				"Do you feel that you get compensated fairly for your job relative to other jobs in your industry \n"
						+ options);
		questions.add("How often do you feel that you are doing jobs that you were not hired to do \n" + options);
		questions.add("Do you think your company provides enough reuseable products? \n" + options);
		for (String s : questions) {
			System.out.println(s);
			int q = sc.nextInt();
			while(q > 5 || q < 0){
				System.out.println("Please enter a number from 1-5");
				 q = sc.nextInt();
			}
			answers.add(q);
			total += q;
			numberOfQuestions++;
			}
			
			
			total = total / numberOfQuestions;
		}
		


	/*
	 * private void makeSurvey2() {// Grocery System.out.
	 * println("Do you think your company does not handle food waste as efficiently as they could?"
	 * + options); int q1 = sc.nextInt(); answers.add(q1);
	 * 
	 * System.out.
	 * println("Do you think your company uses too much plastic in  their packaging?"
	 * + options); int q2 = sc.nextInt(); answers.add(q2);
	 * 
	 * System.out.
	 * println("Do you think your company waste more food in transportation than it should?"
	 * + options); int q3 = sc.nextInt(); answers.add(q3);
	 * 
	 * }
	 */

	private void makeSurvey3() {// Food Idustry
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Do you think your company wastes alot of food before closing \n " + options);
		questions.add("Do you think your company puts enough people when needed \n" + options);
		questions.add("How well of a job does your company do at making sure that the food produced is sustainbable\n"
				+ options);
		questions.add("Does your company do a good job on avoiding spoiled food? \n" + options);
		questions.add(
				"Do you feel that you get compensated fairly for your job relative to other jobs in your industry\n "
						+ options);
		questions.add("How often do you feel that you are doing jobs that you were not hired to do \n" + options);
		questions.add("How often does your company compost food? \n" + options);

		for (String s : questions) {
			System.out.println(s);
			int q = sc.nextInt();
			while(q > 5 || q < 0){
				System.out.println("Please enter a number from 1-5");
				 q = sc.nextInt();
			}
			total += q;
			numberOfQuestions++;

		}
		total = total / numberOfQuestions;

	}

	public ArrayList<Integer> getAnswers() {
		return answers;
	}

	public int getTotal() {
		return total;
	}

}
