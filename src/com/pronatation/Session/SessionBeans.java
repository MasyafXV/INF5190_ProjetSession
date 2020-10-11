package com.pronatation.Session;

import java.text.ParseException;
import java.util.Calendar;

import com.pronatation.Date.DateBeans;

public class SessionBeans {
	
  private String season;
  private int year;
  private DateBeans sessionFrom;
  private DateBeans sessionTo; 
  
  public SessionBeans() {}
  
  public SessionBeans(String season, int year, String dateFrom, String dateTo) {
	  
	  this.season = season;
	  this.year = year;
	  this.sessionFrom = new DateBeans(dateFrom);
	  this.sessionTo = new DateBeans(dateTo);
  }
  
  public SessionBeans(String season, int year,
		  int dayFrom, int monthFrom, int yearFrom, 
		  int dayTo, int monthTo, int yearTo) {
	  
	  this.season = season;
	  this.year = year;
	  this.sessionFrom = new DateBeans(dayFrom, monthFrom, yearFrom);
	  this.sessionTo = new DateBeans(dayTo, monthTo, yearTo);
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
  
  public String getSessionFrom() {
	return sessionFrom.toString();
  }

  public void setSessionFrom(String dateFrom) {
	this.sessionFrom = new DateBeans(dateFrom);
  }

  public String getSessionTo() {
	return sessionTo.toString();
  }

  public void setSessionTo(String dateTo) {
	  this.sessionTo = new DateBeans(dateTo);
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
	  
	  DateBeans dateFrom = new DateBeans(dayFrom, monthFrom, yearFrom);
	  DateBeans dateTo = new DateBeans(dayTo, monthTo, yearTo);
	  if (dateFrom.compareTo(dateTo) < 0) {
		  return true;
	  }
	  return false;
  }
 
}

