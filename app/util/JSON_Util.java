package util;

import org.json.simple.JSONObject;

import models.Contracter;
import models.Employee;
import models.Fulltime;
import models.Intern;
import models.Parttime;
//import models.Person;

public class JSON_Util {
/*
	JSONObject copyPerson(Person p){
		JSONObject obj = new JSONObject();
		obj.put("id", p.getId());
		obj.put("name", p.getName());		
		return obj;		
	}
	*/
	JSONObject copyEmployee(Employee emp){
		JSONObject obj = new JSONObject();
		obj.put("type", "emp");
		obj.put("id", emp.getId());
		obj.put("fname", emp.getFirstName());
		obj.put("lname", emp.getLastName());		
		return obj;		
	}
	
	JSONObject copyFulltime(Fulltime ft){
	    JSONObject obj = new JSONObject();
		obj.put("type", "fulltime");
		obj.put("id", ft.getId());
		obj.put("fname", ft.getFirstName());
		obj.put("lname", ft.getLastName());
		obj.put("salary", ft.getSalary());		
		obj.put("vacation", ft.getVacation());
		return obj;		
	}
	
	JSONObject copyParttime(Parttime pt){
	    JSONObject obj = new JSONObject();
		obj.put("type", "parttime");
		obj.put("id", pt.getId());
		obj.put("fname", pt.getFirstName());
		obj.put("lname", pt.getLastName());
		obj.put("salary", pt.getSalary());		
		obj.put("workhours", pt.getWorkhours());
		return obj;				
	}
	JSONObject copyIntern(Intern it){
	    JSONObject obj = new JSONObject();
		obj.put("type", "intern");
		obj.put("id", it.getId());
		obj.put("fname", it.getFirstName());
		obj.put("lname", it.getLastName());
		obj.put("wage", it.getWage());		
		return obj;
	}
	JSONObject copyContracter(Contracter ct){
	    JSONObject obj = new JSONObject();
		obj.put("type", "contracter");
		obj.put("id", ct.getId());
		obj.put("fname", ct.getFirstName());
		obj.put("lname", ct.getLastName());
		obj.put("wage", ct.getWage());		
		obj.put("overtimehours", ct.getOvertimehours());
		return obj;		
	}
}