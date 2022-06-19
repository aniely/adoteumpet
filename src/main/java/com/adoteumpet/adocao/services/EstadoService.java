package com.adoteumpet.adocao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adoteumpet.adocao.mappers.EstadoMapper;
import com.adoteumpet.adocao.repositories.EstadoRepository;

@Service
public class EstadoService  {

	private EstadoMapper mapper;
	private EstadoRepository repository;


	@Autowired
	public EstadoService(EstadoRepository repository,EstadoMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
 

}
