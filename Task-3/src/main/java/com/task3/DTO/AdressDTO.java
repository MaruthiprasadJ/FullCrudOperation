package com.task3.DTO;

import java.io.Serializable;

import com.task3.DO.Employee;

import lombok.Data;

@Data
public class AdressDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private long id;
	
	private String adressType;
	
	private String area;
	
	private String district;
	
	private String state;
	
	private Employee employee;

}
