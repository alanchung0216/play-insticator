package models;

import models.Employee;

public class Fulltime extends Employee{

	private long salary;
	private long vacation;
	
	public Fulltime() {}
	public Fulltime(String fname, String lname, long salary, long vacation) {
		super(fname,lname);
		this.salary = salary;
		this.vacation = vacation;
	}	
	public long getSalary() {
		   return salary;
	}
	public void setSalary( long salary ) {
		   this.salary = salary;
	}
	public long getVacation() {
		   return vacation;
	}
	public void setVacation( long vacation ) {
		   this.vacation = vacation;
	}	
}
