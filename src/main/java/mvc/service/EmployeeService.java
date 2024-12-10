package mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.dao.EmployeeDao;
import mvc.dto.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;
	
	public String add(Employee employee,ModelMap map) {
		dao.save(employee);
		map.put("success", "Record Added Success");
		return "home.jsp";
	}
	// the deletion start my try
//	public String remove(Employee employee,ModelMap map) {
//		dao.remove(employee);
//		map.put("success", "Record deleted success");
//		return "home.jsp";  
//	}
	// the deletion end
	

	public String fetch(ModelMap map) {
		List<Employee> list =dao.fetchAll();
		if(list.isEmpty()) {
			map.put("failure", "NO Records Found");
			return "home.jsp";
		}else {
			map.put("list", list);
			return "fetch.jsp";
		}
	
	}
	
	public String remove(int id,ModelMap map) {
		Employee employee  = dao.find(id);
		dao.remove(employee);
	map.put("success", "Record deleted success");
	return "fetch";  
}


	public String edit(int id, ModelMap map) {
		Employee employee = dao.find(id);
		map.put("emp", employee);
		return "edit.jsp";
	}


	public String update(Employee employee, ModelMap map) {
		dao.update(employee);
		map.put("success", "Record updated Success");
		return "fetch";
	}

}
