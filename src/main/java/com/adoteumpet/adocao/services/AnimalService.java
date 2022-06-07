package com.adoteumpet.adocao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adoteumpet.adocao.dtos.AnimalDTO;
import com.adoteumpet.adocao.enums.StatusEnum;
import com.adoteumpet.adocao.mappers.AnimalMapper;
import com.adoteumpet.adocao.repositories.AnimalRepository;

@Service
public class AnimalService  {

 	private  AnimalMapper mapper;
	private final AnimalRepository repository;


	@Autowired
	public AnimalService(AnimalRepository repository, AnimalMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public List<AnimalDTO> buscarAnimaisDisponiveis(){
		return mapper.toDTOList(repository.findByStatus(StatusEnum.Disponível));
	}
	
}
