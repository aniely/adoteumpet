package com.adoteumpet.adocao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adoteumpet.adocao.dtos.CidadeDTO;
import com.adoteumpet.adocao.services.CidadeService;

@RestController
@RequestMapping("/cidades")
 
public class CidadeController {

	@Autowired
	private CidadeService service;

	@GetMapping
	public ResponseEntity<List<CidadeDTO>> retornaCidades() {
		System.out.println(service.buscarCidades());
		return ResponseEntity.ok().body(service.buscarCidades());
		
	}

}
