package com.adoteumpet.adocao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adoteumpet.adocao.dtos.CidadeDTO;
import com.adoteumpet.adocao.mappers.CidadeMapper;
import com.adoteumpet.adocao.repositories.CidadeRepository;

@Service
public class CidadeService  {

	private CidadeMapper mapper;
	private CidadeRepository repository;


	@Autowired
	public CidadeService(CidadeRepository repository,CidadeMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
 
	public List<CidadeDTO> buscarCidades(){
		return mapper.toDTOList(repository.findAll());
	}
}
