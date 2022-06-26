package com.adoteumpet.adocao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adoteumpet.adocao.dtos.AnimalDTO;
import com.adoteumpet.adocao.dtos.CreateAnimalDTO;
import com.adoteumpet.adocao.entities.Animal;
import com.adoteumpet.adocao.enums.StatusEnum;
import com.adoteumpet.adocao.mappers.AnimalMapper;
import com.adoteumpet.adocao.mappers.CreateAnimalMapper;
import com.adoteumpet.adocao.repositories.AnimalRepository;
import com.adoteumpet.adocao.repositories.UsuarioRepository;

@Service
public class AnimalService  {

 	private  AnimalMapper mapper;
 	private  CreateAnimalMapper createAnimalMapper;
	private  AnimalRepository repository;
	private  UsuarioRepository usuarioRepository;


	@Autowired
	public AnimalService(AnimalRepository repository, AnimalMapper mapper, UsuarioRepository usuarioRepository,  CreateAnimalMapper createAnimalMapper) {
		this.repository = repository;
		this.mapper = mapper;
		this.usuarioRepository = usuarioRepository;
		this.createAnimalMapper = createAnimalMapper;
	}

	public List<AnimalDTO> buscarAnimaisDisponiveis(){
		return mapper.toDTOList(repository.findByStatus(StatusEnum.Disponível));
	}

	public AnimalDTO cadastrar(CreateAnimalDTO createAnimalDTO) {
		Animal animal = new Animal();
		animal = createAnimalMapper.createToEntity(createAnimalDTO, animal);
		animal.setTutor(usuarioRepository.getById(UsuarioService.authenticated().getId()));
 		animal = repository.save(animal);
		return mapper.toDTO(animal);
	}
	
}
