package com.adoteumpet.adocao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adoteumpet.adocao.dtos.EstadoDTO;
import com.adoteumpet.adocao.services.EstadoService;

@RestController
@RequestMapping("/estados")
 
public class EstadoController {

	@Autowired
	private EstadoService service;

	@GetMapping
	public ResponseEntity<List<EstadoDTO>> retornaEstados() {
		System.out.println(service.buscarEstados());
		return ResponseEntity.ok().body(service.buscarEstados());
		
	}

}
