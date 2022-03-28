package com.task3.service;

import java.util.List;

import com.task3.DO.Adress;
import com.task3.DTO.AdressDTO;
import com.task3.DTO.ResultDTO;

public interface AdressService {
	
	public AdressDTO saveAdress(AdressDTO adressDTO);

	public ResultDTO getAdressById(long id );

	public List<Adress> getAllAdress();

	public ResultDTO deleteAddressById(long id);

}
