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

public class GetEmployees extends Controller{

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
	
    public Result index() {
        //return ok(index.render("Your new application is ready."));

        DataAccess da = new DataAccess();                
        List<Employee> employee = da.listEmployees();;
        TO_JSON js = new TO_JSON();
        return ok(js.toJSON(employee));
    }
    
    
    //public Integer saveObj(Employee ft) {
	/*
	4. set up Hibernate connection to postgres data base
	and map objects to one employee table which consists
	of employee and subclasses data	
	see detail in hibernate.cfg.xml and Employee.hbm.xml
	 */
    /*
    	Integer employeeID = null;
		try{
			   factory = new Configuration().configure().buildSessionFactory();
			   employeeID = addEmployee(ft);
		}catch (Throwable ex) { 
			   System.err.println("Failed to create sessionFactory object." + ex);
			   throw new ExceptionInInitializerError(ex); 
		}
		return employeeID;
    }
    */
    /* CRUD Method - CREATE an employee in the database */
   /* 
    public Integer addEmployee(Employee employee){   
    
 	  Session session = factory.openSession();
       Transaction tx = null;
       Integer employeeID = null;
       try{
          tx = session.beginTransaction();
          employeeID = (Integer) session.save(employee); 
          tx.commit();
       }catch (HibernateException e) {
          if (tx!=null) tx.rollback();
          e.printStackTrace(); 
       }finally {
          session.close(); 
       }
       return employeeID;
    } 
    */

}
    
