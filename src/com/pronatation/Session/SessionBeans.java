package com.pronatation.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SessionBeans {

	private String code;
	private String season;
	private String year;
	private Date sessionFrom;
	private Date sessionTo;

	public SessionBeans() {
	}

	public SessionBeans(String code, String season, String year, String dateFrom, String dateTo) throws ParseException {
		this.code = code;
		this.season = season;
		this.year = year;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.sessionFrom = sdf.parse(dateFrom);
		this.sessionTo = sdf.parse(dateTo);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSessionFrom() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String stringDate = sdf.format(this.sessionFrom);
		return stringDate;
	}

	public void setSessionFrom(String dateFrom) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.sessionFrom = sdf.parse(dateFrom);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getSessionTo() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String stringDate = sdf.format(this.sessionTo);
		return stringDate;
	}

	public void setSessionTo(String dateTo) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.sessionTo = sdf.parse(dateTo);
	}

}
