package es.salesianos.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Company {

	private int ID;
	private String name;
	private Date date;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}
	
	public void setDate(String date) {

		try {
			this.date = sdf.parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String toString() {
		return "Company [Name=" + name + ", Date=" + date + "]";
	}
}
