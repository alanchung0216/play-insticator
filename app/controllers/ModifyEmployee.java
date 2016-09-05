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

public class ModifyEmployee extends Controller{

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
	
    public Result index(int id, long pay) {    	

        DataAccess da = new DataAccess();                
        da.updateEmployee(id, pay);
        Employee emp = da.getEmployee(id);
        List<Employee> employee = new ArrayList();
        employee.add(emp);
        TO_JSON js = new TO_JSON();
        return ok(js.toJSON(employee));
    }    
}
    
