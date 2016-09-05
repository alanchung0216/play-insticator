package util;

//import com.avaje.ebean.Model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import models.Contracter;
import models.Employee;
import models.Fulltime;
import models.Intern;
import models.Parttime;
//import models.Person;


public class TO_JSON {

// create employee JSON file
	
    public String toJSON(List<Employee> employees) {	
    	JSONArray list = new JSONArray();
    	for (int i=0; i < employees.size(); i++){
    		JSONObject obj = new JSONObject();
    		Employee employee = employees.get(i);
    		JSON_Util cp = new JSON_Util();
            if (employee instanceof Fulltime){
	           	 Fulltime ft = (Fulltime) employee;
	           	 list.add(cp.copyFulltime(ft));
            } else if (employee instanceof Parttime){
	           	 Parttime pt = (Parttime) employee;
	           	 list.add(cp.copyParttime(pt));
            } else if (employee instanceof Intern) {
	           	 Intern it = (Intern) employee;
	           	 list.add(cp.copyIntern(it));
            } else if (employee instanceof Contracter) {
	           	 Contracter ct = (Contracter) employee;
	           	 list.add(cp.copyContracter(ct));
            } else {
            	 list.add(cp.copyEmployee(employee));
            }     		
    	}
		//FileWriter file = new FileWriter("employees.json");
		//file.write(list.toJSONString());
		//file.flush();
		//file.close();
		System.out.println(list.toJSONString());
		return list.toJSONString();
	
    }
    /*
    public String toJSON1(List<Person> employees) {	
    	JSONArray list = new JSONArray();
    	for (int i=0; i < employees.size(); i++){
    		JSONObject obj = new JSONObject();
    		Person employee = employees.get(i);
    		JSON_Util cp = new JSON_Util();
    		list.add(cp.copyPerson(employee));
    	}
		System.out.println(list.toJSONString());
		return list.toJSONString();
    }
    */
}