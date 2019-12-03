package com.test.nisum.service;

import java.util.List;

import com.test.nisum.dto.UsuarioDTO;
import com.test.nisum.exception.BusinessException;

public interface UsuarioService {
	
	boolean addUsuario(UsuarioDTO user) throws BusinessException;
	UsuarioDTO getUsuarioByEmail(String email) throws BusinessException;
	List<UsuarioDTO> getAllUsuarios() throws BusinessException;
	
}
