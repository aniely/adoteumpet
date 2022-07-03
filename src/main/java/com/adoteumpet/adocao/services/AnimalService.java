package com.adoteumpet.adocao.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adoteumpet.adocao.dtos.AnimalDTO;
import com.adoteumpet.adocao.dtos.CreateAnimalDTO;
import com.adoteumpet.adocao.entities.Animal;
import com.adoteumpet.adocao.entities.Cidade;
import com.adoteumpet.adocao.entities.Especie;
import com.adoteumpet.adocao.enums.SexoEnum;
import com.adoteumpet.adocao.enums.StatusEnum;
import com.adoteumpet.adocao.mappers.AnimalMapper;
import com.adoteumpet.adocao.mappers.CreateAnimalMapper;
import com.adoteumpet.adocao.repositories.AnimalRepository;
import com.adoteumpet.adocao.repositories.CidadeRepository;
import com.adoteumpet.adocao.repositories.EspecieRepository;
import com.adoteumpet.adocao.repositories.UsuarioRepository;

@Service
public class AnimalService  {

 	private  AnimalMapper mapper;
 	private  CreateAnimalMapper createAnimalMapper;
	private  AnimalRepository repository;
	private  UsuarioRepository usuarioRepository;
	private CidadeRepository cidadeRepository;
	private EspecieRepository especieRepository;


	@Autowired
	public AnimalService(AnimalRepository repository, AnimalMapper mapper, UsuarioRepository usuarioRepository,  CreateAnimalMapper createAnimalMapper, CidadeRepository cidadeRepository, EspecieRepository especieRepository) {
		this.repository = repository;
		this.mapper = mapper;
		this.usuarioRepository = usuarioRepository;
		this.createAnimalMapper = createAnimalMapper;
		this.cidadeRepository = cidadeRepository;
		this.especieRepository = especieRepository;
		
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
