package mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
//	@GetMapping("/remove")
//	public String remove(Employee employee,ModelMap map) {
//		return service.remove(employee, map);
//	}
	@GetMapping("/remove")
	private String remove(@RequestParam int id,ModelMap map) {
		// TODO Auto-generated method stub
		return service.remove(id, map);
	}
	
	@RequestMapping("/fetch")
	public String fetch(ModelMap map) {
		return service.fetch(map);
	}
	
	
	@GetMapping("/edit")
	public String edit(@RequestParam int id, ModelMap map) {
		return service.edit(id,map);
	}
	@PostMapping("/update")
	public String update(Employee employee,ModelMap map) {
		return service.update(employee, map);
	}
}
