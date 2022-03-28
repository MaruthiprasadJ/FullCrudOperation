package com.task3.DTO;

import java.io.Serializable;
import java.util.List;

import com.task3.DO.Adress;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	
	private String name;
	
	private String designation;
	
	private String salary;
	
	private List<Adress> adressDTO;
	
}
