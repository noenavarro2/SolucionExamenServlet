package es.salesianos.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VideoGame {

	private String title;
	private String recommendedAge;
	private Date launchDate;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
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
	
	public Date getLaunchDate() {
		return launchDate;
	}
	
	public String LaunchDateToString() {
		DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		return formatoFecha.format(this.launchDate);
	}
	
	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}
	
	public void setLaunchDate(String launchDate) {
		try {
			this.launchDate = sdf.parse(launchDate);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
		
}

	


