package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Employee;
import play.mvc.Controller;
import play.mvc.Result;
import services.DataAccess;
import util.TO_JSON;

public class DeleteEmployee extends Controller{
	public Result index(int id) {
        DataAccess da = new DataAccess();
        Employee emp = da.getEmployee(id);        
        da.deleteEmployee(id);
        return ok("employee "+emp.getId()+" deleted");
	}
}
