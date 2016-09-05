package models;

public class Employee {

	public int id;
	private String firstName; 
	private String lastName;   
	
	public Employee() {}
	public Employee(String fname, String lname) {
	   this.firstName = fname;
	   this.lastName = lname;
	}
	public int getId() {
	   return id;
	}
	public void setId( int id ) {
	   this.id = id;
	}
	public String getFirstName() {
	   return firstName;
	}
	public void setFirstName( String first_name ) {
	   this.firstName = first_name;
	}
	public String getLastName() {
	   return lastName;
	}
	public void setLastName( String last_name ) {
	   this.lastName = last_name;
	}
}
