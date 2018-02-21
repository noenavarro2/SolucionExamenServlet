package es.salesianos.model;


public class VideoGame {

	private String title;
	private String recommendedAge;
	private String launchDate;
	private int company;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		
		this.title = title;
	}
	
	public String getRecommendedAge() {
		return recommendedAge;
	}
	
	public void setRecommendedAge(String recommendedAge) {
		this.recommendedAge = recommendedAge;
	}
	
	public String getLaunchDate() {
		return launchDate;
	}
	
	public void setLaunchDate(String launchDate) {
		this.launchDate = launchDate;
	}

	public int getCompany() {
		return company;
	}

	public void setCompany(int company) {
		this.company = company;
	}
		
}

	


