package com.adoteumpet.adocao.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adoteumpet.adocao.dtos.UsuarioDTO;
import com.adoteumpet.adocao.security.JWTUtil;
import com.adoteumpet.adocao.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
 
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	@Autowired
	private JWTUtil jwtUtil;

	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioDTO> criar(@RequestBody UsuarioDTO dto,  HttpServletResponse res) {
        UsuarioDTO usuario = service.criar(dto);
        String token = jwtUtil.generateToken(usuario.getEmail());
        res.addHeader("Authorization", "Bearer " + token);
		res.addHeader("access-control-expose-headers", "Authorization");
		return ResponseEntity.ok().body(usuario);
	}
	
 


}
