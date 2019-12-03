package com.test.nisum.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nisum.dto.UsuarioDTO;
import com.test.nisum.entity.UsuarioEntity;
import com.test.nisum.exception.BusinessException;
import com.test.nisum.repository.UsuarioRepository;
import com.test.nisum.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<UsuarioDTO> getAllUsuarios() throws BusinessException {
		
		List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		usuarioRepository.findAll().forEach(e -> {
			UsuarioDTO dto = new UsuarioDTO(e);
			lista.add(dto);
		});
		
		
		
		return lista;
	}
	
	
	
	
	@Override
	public UsuarioDTO getUsuarioByEmail(String email) throws BusinessException {
		Optional<UsuarioEntity> obj = usuarioRepository.findById(email);
		
		if(obj.isPresent()) {
			UsuarioDTO dto = new UsuarioDTO(obj.get());
			dto.setEmail(email);
			return dto;
		}
		else
			return null;
	}	
	
	
	@Override
	public boolean addUsuario(UsuarioDTO user) throws BusinessException{
		UsuarioEntity userEntity = new UsuarioEntity(user);
		usuarioRepository.save(userEntity);
		return true;
	}
}
