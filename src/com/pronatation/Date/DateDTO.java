package com.pronatation.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.*;
import java.util.Date;

public class DateDTO {
	
	String date;			// Format "dd/mm/yyyy"
	
	public DateDTO(int day, int month, int year) {
		this.date = day + "/" + month + "/" + year;
	}
	
	public DateDTO(String date) {
		this.date = date;
	}
	
	public Date getDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date thisDate = sdf.parse(this.date);
		return thisDate;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public boolean isDateValid(String inputDate) {
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		timeFormat = timeFormat.withResolverStyle (ResolverStyle.STRICT);
		try {
		    LocalDate.parse(inputDate, timeFormat);
		    return true;
		} catch ( DateTimeParseException e ) {
		    return false;
		}
	}
	
	public int compareTo(DateDTO other) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date thisDate = sdf.parse(this.date);
		Date otherDate = sdf.parse(other.date);
		return thisDate.compareTo(otherDate);
	}
	
	public String toString() {
		return date;
	}
}
