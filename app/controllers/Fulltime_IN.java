package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.HibernateException; 
import org.hibernate.cfg.Configuration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.hibernate.Session; 
import org.hibernate.Transaction;


//import com.avaje.ebean.Model;


import models.Employee;
import models.Fulltime;
//import models.Person;
import play.*;
import play.data.Form;
import play.data.FormFactory;
//import play.data.Form;
import play.mvc.*;
import services.DataAccess;
import util.TO_JSON;
import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * and get data from request
 */

public class Fulltime_IN extends Controller{


    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
	
    public Result index(String fname, String lname, long salary, long vacation) {

        Employee ft = new Fulltime(fname,lname,salary, vacation);
        DataAccess da = new DataAccess();
        int empId = da.addEmployee(ft);
        Employee emp = da.getEmployee(empId);
        List<Employee> employee = new ArrayList();
        employee.add(emp);
        TO_JSON js = new TO_JSON();
        System.out.println(" Fulltime saved "+empId);        
        return ok(js.toJSON(employee));
    }
    

}
    
