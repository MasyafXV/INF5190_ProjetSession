package com.pronatation.Session;

import java.text.ParseException;
import java.util.Calendar;

import com.pronatation.Date.DateDTO;

public class SessionDTO {
	
  private String season;
  private int year;
  private DateDTO sessionFrom;
  private DateDTO sessionTo; 
  
  public SessionDTO() {}
  
  public SessionDTO(String season, int year, String dateFrom, String dateTo) {
	  
	  this.season = season;
	  this.year = year;
	  this.sessionFrom = new DateDTO(dateFrom);
	  this.sessionTo = new DateDTO(dateTo);
  }
  
  public SessionDTO(String season, int year,
		  int dayFrom, int monthFrom, int yearFrom, 
		  int dayTo, int monthTo, int yearTo) {
	  
	  this.season = season;
	  this.year = year;
	  this.sessionFrom = new DateDTO(dayFrom, monthFrom, yearFrom);
	  this.sessionTo = new DateDTO(dayTo, monthTo, yearTo);
  }

  public String getSeason() {
	return season;
  }

  public void setSeason(String season) {
	this.season = season;
  }

  public int getYear() {
	return year;
  }

  public void setYear(int year) {
	this.year = year;
  }
  
  public boolean validateSeason(String season) {
	  
	  if (season.equals("Winter") 
			  || season.equals("Summer") 
			  || season.equals("Autumn")) {
		  return true;
	  }
	  return false;
  }
  
  public boolean validateYear(int year) {
	  
	  int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	  if (year >= currentYear) {
		  return true;
	  }
	  return false;
  }

  public boolean validateSessionDate(
		  int dayFrom, int monthFrom, int yearFrom, 
		  int dayTo, int monthTo, int yearTo) throws ParseException {
	  
	  DateDTO dateFrom = new DateDTO(dayFrom, monthFrom, yearFrom);
	  DateDTO dateTo = new DateDTO(dayTo, monthTo, yearTo);
	  if (dateFrom.compareTo(dateTo) < 0) {
		  return true;
	  }
	  return false;
  }

public String getSessionFrom() {
	return sessionFrom.toString();
}

public void setSessionFrom(int day, int month, int year) {
	this.sessionFrom = new DateDTO(day, month, year);
}

public String getSessionTo() {
	return sessionTo.toString();
}

public void setSessionTo(int day, int month, int year) {
	this.sessionTo = new DateDTO(day, month, year);
}
 
}
