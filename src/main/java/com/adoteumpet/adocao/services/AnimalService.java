package com.adoteumpet.adocao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adoteumpet.adocao.dtos.AnimalDTO;
import com.adoteumpet.adocao.dtos.CreateAnimalDTO;
import com.adoteumpet.adocao.entities.Animal;
import com.adoteumpet.adocao.enums.SexoEnum;
import com.adoteumpet.adocao.enums.StatusEnum;
import com.adoteumpet.adocao.mappers.AnimalMapper;
import com.adoteumpet.adocao.mappers.CreateAnimalMapper;
import com.adoteumpet.adocao.repositories.AnimalRepository;
import com.adoteumpet.adocao.repositories.UsuarioRepository;
import com.adoteumpet.adocao.senders.QueueSender;

@Service
public class AnimalService  {

 	private  AnimalMapper mapper;
 	private  CreateAnimalMapper createAnimalMapper;
	private  AnimalRepository repository;
	private  UsuarioRepository usuarioRepository;
	private QueueSender queueSender;


	@Autowired
	public AnimalService(AnimalRepository repository, AnimalMapper mapper, UsuarioRepository usuarioRepository,  CreateAnimalMapper createAnimalMapper, QueueSender queueSender) {
		this.repository = repository;
		this.mapper = mapper;
		this.usuarioRepository = usuarioRepository;
		this.createAnimalMapper = createAnimalMapper;
		this.queueSender = queueSender; 
	
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

	
	public AnimalDTO adotar(Long idAnimal) {
		Animal animal = repository.findById(idAnimal).get();
		if(animal == null) {
			 throw new Error("Animal não encontrado!");
		}
		animal.setAdotadoPor(usuarioRepository.getById(UsuarioService.authenticated().getId()));
		animal.setStatus(StatusEnum.Em_processo);
 		animal = repository.saveAndFlush(animal);
 		
 		//enviar EMAIL de adoção
 		AnimalDTO animalDto = mapper.toDTO(animal); 
 		queueSender.send(animalDto);
		return animalDto;
	}
	
	public List<AnimalDTO> pesquisarAnimais(Long idEspecie, Long idCidade, String sexo) {
		SexoEnum sexoEnum = sexo != null ? SexoEnum.valueOf(sexo) : null;
	
		List<Animal> animais = repository.findAll();
		if (idCidade != null) 
			animais = animais.stream().filter(a -> a.getCidade().getId() == idCidade).collect(Collectors.toList());
		if (idEspecie != null) 
			animais = animais.stream().filter(a -> a.getRaca().getEspecie().getId() == idEspecie).collect(Collectors.toList());
		if (sexoEnum != null)
			animais = animais.stream().filter(a -> a.getGenero().equals(sexoEnum)).collect(Collectors.toList());
			 	
		return mapper.toDTOList(animais);
	}
	
}
