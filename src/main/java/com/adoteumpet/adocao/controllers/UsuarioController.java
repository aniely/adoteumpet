package com.adoteumpet.adocao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adoteumpet.adocao.dtos.UsuarioDTO;
import com.adoteumpet.adocao.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
 
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioDTO> criar(@RequestBody UsuarioDTO usuario) {
		return ResponseEntity.ok().body(service.criar(usuario));
	}
	
 


}
