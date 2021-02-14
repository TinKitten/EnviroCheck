package YUhacks2;

import java.util.ArrayList;

public class Company {

	private String companyName;
	private String industry;
	public double ratings;
	public ArrayList<Integer> surveyScores;

	public Company(String name) {
		this.companyName = name;
	}

	public Company(String name, String industry) {
		this.companyName = name;
		this.industry = industry;
	}

	public String getIndustryName() {
		return industry;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setIndustryName(String s) {
		this.industry = s;
	}

	public double getAverage() {
		int size = surveyScores.size();
		double score = 0.0;

		for (int i : surveyScores) {
			score += i;
		}

		double ans = score / size;
		return Math.round(ans * 100.0) / 100.0; // rounded to 2 d.p
	}
}
