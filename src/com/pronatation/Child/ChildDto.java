package com.pronatation.Child;

public class ChildDto {
	
	private String child_firstname;
    private String child_lastname;
    private String child_bdate;
    
    public ChildDto(String child_firstname, String child_lastname, String child_bdate) {
        this.setChild_firstname(child_firstname);
        this.setChild_lastname(child_lastname);
        this.setChild_bdate(child_bdate);

     }

	public String getChild_firstname() {
		return child_firstname;
	}

	public void setChild_firstname(String child_firstname) {
		this.child_firstname = child_firstname;
	}

	public String getChild_lastname() {
		return child_lastname;
	}

	public void setChild_lastname(String child_lastname) {
		this.child_lastname = child_lastname;
	}

	public String getChild_bdate() {
		return child_bdate;
	}

	public void setChild_bdate(String child_bdate) {
		this.child_bdate = child_bdate;
	}
    
}
