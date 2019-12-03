package com.test.nisum.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.nisum.dto.UsuarioDTO;
import com.test.nisum.exception.BusinessException;
import com.test.nisum.response.GenericResponse;
import com.test.nisum.service.UsuarioService;
import com.test.nisum.utils.ValidadorUtils;

@RestController
@CrossOrigin
public class AdmUsuarioController {
	 private static final String OK = "Proceso OK.";
	 private static final String EXISTE_CORREO = "El correo ya registrado.";
	 private static final String CORREO_INVALIDO = "Formato de correo no válido.";
	 private static final String ERROR_CONTRASEÑA = "Contraseña invalida (Debe contener al menos 2 dígitos, al menos 1 letra mayúscula y al menos 1 letra minúscula";
	 
	 @Autowired
	 private UsuarioService usuarioService;
	 
	 @GetMapping("/listar-usuarios")
	    public ResponseEntity<LinkedHashMap<String, Object>> init() throws BusinessException {
	        ResponseEntity<LinkedHashMap<String, Object>> response = null;
	        LinkedHashMap<String, Object> mapa = new LinkedHashMap<>();
	        mapa.put("listaUsuarios", usuarioService.getAllUsuarios());
	        
	        response = new ResponseEntity<>(mapa, HttpStatus.OK);
	        return response;

	    }
	 
	@PutMapping("/add-usuario")
	    public ResponseEntity<GenericResponse> addUsuario(@RequestBody UsuarioDTO usuario) throws BusinessException {
		
			GenericResponse genericResponse = new GenericResponse();
        	ResponseEntity<GenericResponse> response = null;
        	
        	if(!ValidadorUtils.correoValido(usuario.getEmail())) {
        		genericResponse.setMessage(CORREO_INVALIDO);
        		response = new ResponseEntity<>(genericResponse, HttpStatus.OK);
        	}
        	else if(!ValidadorUtils.passwordValida(usuario.getPassword())){
        		genericResponse.setMessage(ERROR_CONTRASEÑA);
        		response = new ResponseEntity<>(genericResponse, HttpStatus.OK);
        	}
        	else {
	        	UsuarioDTO dto = usuarioService.getUsuarioByEmail(usuario.getEmail());
	        	if(dto == null) {
	        		usuarioService.addUsuario(usuario);
	        		genericResponse.setMessage(OK);
	        		response = new ResponseEntity<>(genericResponse, HttpStatus.OK);
	        	}
	        	else {
	        		genericResponse.setMessage(EXISTE_CORREO);
	        		response = new ResponseEntity<>(genericResponse, HttpStatus.OK);
	        	}
        		
        	}
			return response;

	    }
}
