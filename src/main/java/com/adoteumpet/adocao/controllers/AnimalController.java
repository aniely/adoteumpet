package com.adoteumpet.adocao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adoteumpet.adocao.dtos.AnimalDTO;
import com.adoteumpet.adocao.services.AnimalService;

@RestController
@RequestMapping("/animais")
 
public class AnimalController {

	@Autowired
	private AnimalService service;

	@GetMapping
	public ResponseEntity<List<AnimalDTO>> retornaAnimais() {
		return ResponseEntity.ok().body(service.buscarAnimaisDisponiveis());
	}

}
