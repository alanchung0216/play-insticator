package controllers;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;

import models.Employee;
import models.Intern;
import play.*;
import play.mvc.*;
import services.DataAccess;
import util.TO_JSON;
import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * and get data from request
 */

public class Intern_IN extends Controller{

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
	
    public Result index(String fname, String lname, long wage) {

        Intern it = new Intern(fname,lname,wage);
        DataAccess da = new DataAccess();
        int empId = da.addEmployee(it);
        Employee emp = da.getEmployee(empId);        
        List<Employee> employee = new ArrayList();
        employee.add(emp);
        TO_JSON js = new TO_JSON();
        System.out.println(" Intern saved "+empId);
        return ok(js.toJSON(employee));
    }
}
