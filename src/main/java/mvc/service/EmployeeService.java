package mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

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
	// the deletion start
	public String remove(Employee employee,ModelMap map) {
		dao.remove(employee);
		map.put("success", "Record deleted success");
		return "home.jsp";
	}
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

}
