package com.task3.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.task3.DO.Employee;
import com.task3.DTO.AdressDTO;
import com.task3.DTO.EmployeeDTO;
import com.task3.DTO.ResultDTO;
import com.task3.repository.EmployeeRepository;
import com.task3.service.AdressService;
import com.task3.service.EmployeeService;
import com.task3.util.EmployeeUtil;
@Service
public class EmployeeServiceImpl extends EmployeeUtil implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AdressService adressService;
	

	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
//		ResultDTO resultDTO = new ResultDTO();
		Employee emp = employeeRepository.save(convertEmployeeDTOtoDO(employeeDTO));
		
		List<AdressDTO> adressDTOs = new ArrayList<>();
		employeeDTO.getAdressDTO().stream().forEach(adress -> {
			AdressDTO add = new AdressDTO();
			add.setId(adress.getId());
			add.setAdressType(adress.getAdressType());
			add.setArea(adress.getArea());
			add.setDistrict(adress.getDistrict());
			add.setState(adress.getState());
			add.setEmployee(emp);
			
			AdressDTO saveAdressDTO = adressService.saveAdress(add);                                              
			adressDTOs.add(saveAdressDTO);
		});
		//resultDTO.setCode("code");
		EmployeeDTO edto = convertDOtoEmployeeDTO(emp);
//		resultDTO.setMessage("Employee Details has been saved");
//		resultDTO.setData(edto);
		return edto;
	}
	
	@Override
	public EmployeeDTO getEmployeeById(long id) {
//		ResultDTO resultDTO = new ResultDTO();
		Employee emp = employeeRepository.findById(id).get();
		//resultDTO.setCode("code");
//		resultDTO.setMessage("Employee Details has been got by id");
//		resultDTO.setData(emp);
		EmployeeDTO empdto = convertDOtoEmployeeDTO(emp);
		return empdto;
	}

	@Override
	public List<Employee> getAllEmployees() {
//		ResultDTO resultDTO = new ResultDTO();
		List<Employee> findall = employeeRepository.findAll();
//      resultDTO.setCode("code");
//		resultDTO.setMessage("We got All the Employees");
//		resultDTO.setData(list);
		return findall;
	}

	@Override
	public ResultDTO deleteEmployeeById(long id) {
		ResultDTO resultDTO = new ResultDTO();
//		resultDTO.setData(id);
		if(employeeRepository.existsById(id)) {
		    employeeRepository.deleteById(id); 
		    resultDTO.setMessage("Employee has been deleted from the table");
		}
		else {
			resultDTO.setMessage("Employee Id is doesnot exist");
		}
		resultDTO.setData(id);
		return resultDTO;
	}

	@Override
	public String updteStatusById(long id, String status) {
		employeeRepository.updateStatusById(id,status);
		return "employee status has been updated sucessful";
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
		Employee employee = employeeRepository.save(convertEmployeeDTOtoDO(employeeDTO));
		
		List<AdressDTO> adressDTOs = new ArrayList<>();
		employeeDTO.getAdressDTO().stream().forEach(adress -> {
			AdressDTO add = new AdressDTO();
			add.setId(adress.getId());
			add.setAdressType(adress.getAdressType());
			add.setArea(adress.getArea());
			add.setDistrict(adress.getDistrict());
			add.setState(adress.getState());
			add.setEmployee(employee);
			
			AdressDTO saveAdressDTO = adressService.saveAdress(add);                                              
			adressDTOs.add(saveAdressDTO);
		});
		EmployeeDTO empdto = convertDOtoEmployeeDTO(employee);
		return empdto;
	}                   
     
	@Override
	public ResultDTO fetchDetailerByFilter(int pageNumber, int pageSize, String filter) {
		ResultDTO resultDTO = new ResultDTO();
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Employee> page = employeeRepository.findByFilter(filter,pageable);
		List<Employee> list = new ArrayList<>();
		for(Employee employee : page) {
			list.add(employee);
		}
		resultDTO.setMessage("employee has been fetched by filter");
		resultDTO.setData(list);
		return resultDTO;
	}
	
	public ResultDTO fetchingEmployee(int pageNumber,int pazeSize,String filter) {
		ResultDTO resultDTO = new ResultDTO();
		Pageable pageable = PageRequest.of(pageNumber, pazeSize);
		Page<Employee> page = employeeRepository.findByFilter(filter, pageable);
		List<Employee> list = new ArrayList<>();
		for(Employee employee : page) {
			list.add(employee);
		}
		resultDTO.setMessage("employee has been fetch by filter");
		resultDTO.setData(list);
		return resultDTO;
		
	}

//	@Override
//	public ResultDTO fetchMappedDetailerByFilter(int pageNumber, int pageSize, String filter) {
//		ResultDTO resultDTO = new ResultDTO();
//		Pageable pageable = PageRequest.of(pageNumber, pageSize);
//		Page<Employee> page = employeeRepository.findByFilter(pageable, filter);
//		List<Employee> list = new ArrayList<>();
//		for(Employee employee : page) {
//			list.add(employee);
//		}
//		resultDTO.setMessage("employee has been fetched by filter");
//		resultDTO.setData(list);
//		return resultDTO;
//	}
	
	
}
