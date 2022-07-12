package com.adoteumpet.adocao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adoteumpet.adocao.dtos.CidadeDTO;
import com.adoteumpet.adocao.dtos.RacaDTO;
import com.adoteumpet.adocao.services.RacaService;

@RestController
@RequestMapping("/racas")
 
public class RacaController {

	@Autowired
	private RacaService service;

	@GetMapping
	public ResponseEntity<List<RacaDTO>> retornaRacas() {
		System.out.println(service.buscarRacas());
		return ResponseEntity.ok().body(service.buscarRacas());
		
	}	@GetMapping("/pesquisarPorEspecie")
	public ResponseEntity<List<RacaDTO>> retornaRacasPorEspecie(@RequestParam(required = true) Long idEspecie) {
		return ResponseEntity.ok().body(service.buscarRacaPorEspecie(idEspecie));
		
	}

}
