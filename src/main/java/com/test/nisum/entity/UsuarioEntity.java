package com.test.nisum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.test.nisum.dto.TelefonoDTO;
import com.test.nisum.dto.UsuarioDTO;

@Entity
@Table(name = "NISUM_USUARIO")
public class UsuarioEntity implements Serializable {
	
	private static final long serialVersionUID = -13507260156224697L;
	
	@Column(name = "nombre")
	private String nombre; 
	
	@Id
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "token")
	private String token;
	
	@Column(name = "fecha_creacion")
	private Date  fecha_creacion;
	
	@Column(name = "fecha_modificacion")
	private Date  fecha_modificacion;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<PhoneEntity> phones;
	
	public UsuarioEntity(){
		   super();
		}

	public UsuarioEntity(UsuarioDTO user) {
		
		this.nombre = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.token = user.getToken();
		this.fecha_creacion = null;
		this.fecha_modificacion = null;
		
		this.phones = new ArrayList<PhoneEntity>();
		
		for(TelefonoDTO phone : user.getPhones()) {
			PhoneEntity ent = new PhoneEntity(phone);
			ent.setUsuario(this);
			this.phones.add(ent);
		}
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	public List<PhoneEntity> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneEntity> phones) {
		this.phones = phones;
	}
	
	
	
}
