package com.test.nisum.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.test.nisum.entity.PhoneEntity;
import com.test.nisum.entity.UsuarioEntity;

public class TelefonoDTO implements Serializable{
	
	private static final long serialVersionUID = -13507260156224697L;
	
	private int id_phone;
	
	private int number;
	private int citycode;
	private int countrycode;
	private String email;
	
	public TelefonoDTO() {
		super();
	}
	
	public TelefonoDTO(PhoneEntity ent) {
	
		this.number = ent.getNumber();
		this.citycode = ent.getCitycode();
		this.countrycode = ent.getCountrycode();
		
	}
	
	public int getId_phone() {
		return id_phone;
	}
	public void setId_phone(int id_phone) {
		this.id_phone = id_phone;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getCitycode() {
		return citycode;
	}
	public void setCitycode(int citycode) {
		this.citycode = citycode;
	}
	public int getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(int countrycode) {
		this.countrycode = countrycode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
