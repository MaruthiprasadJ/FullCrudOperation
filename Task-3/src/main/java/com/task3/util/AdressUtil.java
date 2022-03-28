package com.task3.util;

import com.task3.DO.Adress;
import com.task3.DTO.AdressDTO;

public class AdressUtil {
	
	public static Adress convertAdressDTOtoDO(AdressDTO adressDTO) {
		Adress adress = new Adress();
		adress.setId(adressDTO.getId());
		adress.setAdressType(adressDTO.getAdressType());
		adress.setArea(adressDTO.getArea());
		adress.setDistrict(adressDTO.getDistrict());
		adress.setState(adressDTO.getState());
		adress.setEmployee(adressDTO.getEmployee());
		return adress;
	}
	
	public static AdressDTO convertAdressDOtoDTO(Adress adress) {
		AdressDTO adressDTO = new AdressDTO();
		adressDTO.setId(adress.getId());
		adressDTO.setAdressType(adressDTO.getAdressType());
		adressDTO.setArea(adress.getArea());
		adressDTO.setDistrict(adress.getDistrict());
		adressDTO.setState(adress.getState());
		adressDTO.setEmployee(adress.getEmployee());
		return adressDTO;
	}

}
