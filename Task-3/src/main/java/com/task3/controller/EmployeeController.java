package com.task3.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task3.DO.Employee;
import com.task3.DTO.EmployeeDTO;
import com.task3.DTO.ResultDTO;
import com.task3.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/save")
	private EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return employeeService.saveEmployee(employeeDTO);
	}
	
	@GetMapping("/get/{id}")
	private EmployeeDTO getEmployeeById(@PathVariable long id) {
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping("/getAll")
	private List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@DeleteMapping ("delete/{id}")
	private ResultDTO deleteEmployeeById(@PathVariable long id) {
			return employeeService.deleteEmployeeById(id);
		}
	
	@PutMapping("updatestatus")
	private String updateStatusById(@RequestParam long id,@RequestParam String status) {
		return employeeService.updteStatusById(id, status);
	}
	
	@PutMapping("update/{id}")
	private EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return employeeService.updateEmployee(employeeDTO);
	}
	
	@GetMapping("/filter")
	private ResultDTO fetchDetailerByFilter(@RequestParam(defaultValue = "0") int pageNumber,
	                                        @RequestParam(defaultValue = "10") int pageSize,@RequestParam String filter) {
		return employeeService.fetchDetailerByFilter(pageNumber,pageSize,filter);
	}
	
//	private ResultDTO fetchMappedDetailerByFilter(@RequestParam(defaultValue = "0") int pageNumber,
//			                                      @RequestParam(defaultValue = "5") int pageSize,String filter) {
//		return employeeService.fetchMappedDetailerByFilter(pageNumber,pageSize,filter);
//	}
}
