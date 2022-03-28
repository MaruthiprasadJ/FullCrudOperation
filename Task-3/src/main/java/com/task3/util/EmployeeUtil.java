package com.task3.util;

import com.task3.DO.Employee;
import com.task3.DTO.EmployeeDTO;

public class EmployeeUtil {
	
	public static Employee convertEmployeeDTOtoDO(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		employee.setId(employeeDTO.getId());
		employee.setName(employeeDTO.getName());
		employee.setDesignation(employeeDTO.getDesignation());
		employee.setSalary(employeeDTO.getSalary());
		employee.setAdress(employeeDTO.getAdressDTO());
		return employee;
	}
	
	public static EmployeeDTO convertDOtoEmployeeDTO(Employee employee) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(employee.getId());
		employeeDTO.setName(employee.getName());
		employeeDTO.setDesignation(employee.getDesignation());
		employeeDTO.setSalary(employee.getSalary());
		employeeDTO.setAdressDTO(employee.getAdress());
		return employeeDTO;
	}

}
