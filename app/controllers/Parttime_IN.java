package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONArray;

//import com.avaje.ebean.Model;


import models.Employee;
import models.Parttime;
import play.*;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import services.DataAccess;
import util.TO_JSON;
import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * and get data from request
 */

public class Parttime_IN extends Controller{

	
	private FormFactory formFactory;

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
	
    public Result index(String fname, String lname, long salary, long workhours) {
        //return ok(index.render("Your new application is ready."));

        Parttime pt = new Parttime(fname,lname,salary, workhours);
        DataAccess da = new DataAccess();
        int empId = da.addEmployee(pt);
        Employee emp = da.getEmployee(empId);
        List<Employee> employee = new ArrayList();
        employee.add(emp);        
        TO_JSON js = new TO_JSON();
        System.out.println(" Parttime saved "+empId);
        return ok(js.toJSON(employee));
    }
}
