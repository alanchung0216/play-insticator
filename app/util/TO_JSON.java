package util;

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


public class TO_JSON {
	
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
		System.out.println(list.toJSONString());
		return list.toJSONString();
	
    }
}