package com.task3.DO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "adress")
public class Adress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private long id;
	
	@Column(name ="adressType")
	private String adressType;
	
	@Column(name="area")
	private String area;
	
	@Column(name="district")
	private String district;
	
	@Column(name="state")
	private String state;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	private Employee employee;

}
