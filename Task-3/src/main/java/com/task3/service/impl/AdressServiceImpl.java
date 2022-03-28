package com.task3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task3.DO.Adress;
import com.task3.DTO.AdressDTO;
import com.task3.DTO.ResultDTO;
import com.task3.repository.AdressRepository;
import com.task3.service.AdressService;
import com.task3.util.AdressUtil;

@Service
public class AdressServiceImpl extends AdressUtil implements AdressService{
	
	@Autowired
	private AdressRepository adressRepository;

	@Override
	public AdressDTO saveAdress(AdressDTO adressDTO) {
//		ResultDTO resultDTO = new ResultDTO();
		Adress adress = adressRepository.save(AdressUtil.convertAdressDTOtoDO(adressDTO));
//		resultDTO.setMessage("student has been saved");
//		resultDTO.setData(adress);
		return AdressUtil.convertAdressDOtoDTO(adress);
	}

	@Override
	public ResultDTO getAdressById(long id) {
		ResultDTO resultDTO = new ResultDTO();
		Adress adress = adressRepository.getById(id);
		AdressDTO adto = convertAdressDOtoDTO(adress);
		resultDTO.setMessage("got by id");
		resultDTO.setData(adto);
		return resultDTO;
	}

	@Override
	public List<Adress> getAllAdress() {
		List<Adress> adress = adressRepository.findAll();
		return adress;
	}

	@Override
	public ResultDTO deleteAddressById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}