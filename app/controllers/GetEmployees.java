package controllers;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import models.Employee;
import models.Fulltime;
import play.*;
import play.mvc.*;
import services.DataAccess;
import util.TO_JSON;
import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * and get data from request
 */

public class GetEmployees extends Controller{

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
	
    public Result index() {

        DataAccess da = new DataAccess();                
        List<Employee> employee = da.listEmployees();;
        TO_JSON js = new TO_JSON();
        return ok(js.toJSON(employee));
    }
}
    
