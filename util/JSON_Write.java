package util;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

//import models.Person;
import models.Contracter;
import models.Employee;
import models.Fulltime;
import models.Intern;
import models.Parttime;


public class JSON_Write {
//     public static void main(String[] args) {

//type | first_name | last_name | salary | vacation | workhours | wage | overtimehours
    	 
// create testing employee JSON file
/*	
    public void writeJSON1(Person person) {	 
	    JSONArray list = new JSONArray();
	    JSONObject obj1 = new JSONObject();
	    JSON_Util cp = new JSON_Util();
	    
	    //Person p = new Person("4","Jerry");
		list.add(cp.copyPerson(person));
    }	
*/
    public void writeJSON() {	 
	    JSONArray list = new JSONArray();
	    JSONObject obj1 = new JSONObject();
	    JSON_Util cp = new JSON_Util();
	    
	    Employee emp = new Employee("Deborah","Kim");
		list.add(cp.copyEmployee(emp));
		
		Fulltime ft = new Fulltime("Johnny","Smith",80000, 15);
		list.add(cp.copyFulltime(ft));
		
		Parttime pt = new Parttime("Tom","Kite",50000,5);
		list.add(cp.copyParttime(pt));
		
		Intern it = new Intern("Lisa","Clark",20);
		list.add(cp.copyIntern(it));
		
		Contracter ct = new Contracter("Doug","Hill",50, 9);
		list.add(cp.copyContracter(ct));	
	
		try {
	
			FileWriter file = new FileWriter("test.json");
			file.write(list.toJSONString());
			file.flush();
			file.close();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		System.out.print(list);
		System.out.println("\n I am  DONE");
	}
}