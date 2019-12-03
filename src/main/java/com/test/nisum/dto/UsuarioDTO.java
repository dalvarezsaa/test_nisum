package com.test.nisum.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.test.nisum.entity.PhoneEntity;
import com.test.nisum.entity.UsuarioEntity;

public class UsuarioDTO implements Serializable{
	
	private static final long serialVersionUID = -13507260156224697L;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String token; 
	
	private List<TelefonoDTO> phones;
	
	public UsuarioDTO() {
		super();
	}
	
	public UsuarioDTO(UsuarioEntity ent) {
		this.email = ent.getEmail();
		this.name = ent.getNombre();
		this.password = ent.getPassword();
		this.token = ent.getToken();
		this.phones = new ArrayList<TelefonoDTO>();
		
		for(PhoneEntity phone : ent.getPhones()) {
			TelefonoDTO dto = new TelefonoDTO(phone);
			dto.setEmail(ent.getEmail());
			phones.add(dto);
		}
	}
		
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<TelefonoDTO> getPhones() {
		return phones;
	}

	public void setPhones(List<TelefonoDTO> phones) {
		this.phones = phones;
	}

	

}
