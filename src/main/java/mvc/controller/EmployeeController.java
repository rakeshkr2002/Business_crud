package mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import mvc.dto.Employee;
import mvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping({"/","/home"})
		public String loadHome() {
			 return "home.jsp";
		}
	
	@GetMapping("/add")
	public String loadAd() {
		return "add.jsp";
	}
	
	@PostMapping("/add")
	public String add(Employee employee,ModelMap map) {
		return service.add(employee, map);
	}
	
	@GetMapping("/remove")
	public String remove(Employee employee,ModelMap map) {
		return service.remove(employee, map);
	}
	
	@GetMapping("/fetch")
	public String fetch(ModelMap map) {
		return service.fetch(map);
	}
	
}
