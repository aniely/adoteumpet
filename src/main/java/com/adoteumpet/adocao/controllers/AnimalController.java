package com.adoteumpet.adocao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adoteumpet.adocao.dtos.AnimalDTO;
import com.adoteumpet.adocao.dtos.CreateAnimalDTO;
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
	
	@GetMapping("/pesquisar")
	public ResponseEntity<List<AnimalDTO>> pesquisarParams(@RequestParam(required = false) Long idEspecie,
			@RequestParam(required = false) Long idCidade,
			@RequestParam(required = false) String sexo) {
		return ResponseEntity.ok().body(service.pesquisarAnimais(idEspecie, idCidade, sexo));
	}

	@PostMapping
	public ResponseEntity<AnimalDTO> cadastrarAnimal(@RequestBody CreateAnimalDTO animal) {
		return ResponseEntity.ok().body(service.cadastrar(animal));
	}
}
