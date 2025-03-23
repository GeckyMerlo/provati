package it.polimi.tiw.beans;

public class PersonBean {
	private int ID;
	private String firstname;
	private String lastname;
	private String city;

	public PersonBean() {
		ID = 0;
		firstname = "";
		lastname = "";
		city = "";
	}
	
	public PersonBean(int id, String fn, String ls, String ct) {
		ID = id;
		firstname = fn;
		lastname = fn;
		city = ct;
	}

	public int getID() {
		return ID;
	}

	public void setID(int personID) {
		this.ID = personID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String first) {
		this.firstname = first;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String last) {
		this.lastname = last;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
