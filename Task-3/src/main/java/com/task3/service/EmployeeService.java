package com.task3.service;
import java.util.List;

import com.task3.DO.Employee;
import com.task3.DTO.EmployeeDTO;
import com.task3.DTO.ResultDTO;

public interface EmployeeService {

	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
	
	public EmployeeDTO getEmployeeById(long id );

	public List<Employee> getAllEmployees();

	public ResultDTO deleteEmployeeById(long id);
	
	public String updteStatusById(long id, String status);
	
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);

	public ResultDTO fetchDetailerByFilter(int pageNumber, int pageSize, String filter);

//	public ResultDTO fetchMappedDetailerByFilter(int pageNumber, int pageSize, String filter);

}
