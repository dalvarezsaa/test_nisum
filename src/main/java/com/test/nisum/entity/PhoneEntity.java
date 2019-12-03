package com.test.nisum.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.test.nisum.dto.TelefonoDTO;

@Entity
@Table(name = "NISUM_PHONE")
public class PhoneEntity implements Serializable {
	
	private static final long serialVersionUID = -13507260156224697L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_phone")
	private int id_phone;
	
	@Column(name = "numero")
	private int number; 
	
	@Column(name = "city_Code")
	private int citycode; 
	
	@Column(name = "country_Code")
	private int countrycode; 
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "email")
    private UsuarioEntity usuario;
	
	public PhoneEntity() {
		super();
	}
	public PhoneEntity(TelefonoDTO tel) {
		
		this.number = tel.getNumber();
		this.citycode = tel.getCitycode();
		this.countrycode = tel.getCountrycode();
	};

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

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	
	
	

}
