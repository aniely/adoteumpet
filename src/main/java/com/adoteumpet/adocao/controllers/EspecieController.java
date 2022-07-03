package com.adoteumpet.adocao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adoteumpet.adocao.dtos.EspecieDTO;
import com.adoteumpet.adocao.services.EspecieService;

@RestController
@RequestMapping("/especies")
 
public class EspecieController {

	@Autowired
	private EspecieService service;

	@GetMapping
	public ResponseEntity<List<EspecieDTO>> retornaEspecies() {
		return ResponseEntity.ok().body(service.buscarEspecies());
	}

}
