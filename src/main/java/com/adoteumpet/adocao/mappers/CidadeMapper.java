package com.adoteumpet.adocao.mappers;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.adoteumpet.adocao.dtos.CidadeDTO;
import com.adoteumpet.adocao.entities.Cidade;

@Mapper(componentModel="spring")
public interface CidadeMapper {
	
	@Mapping(target="id", ignore=true) 
	@BeanMapping(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, 
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public Cidade toEntity(CidadeDTO dto, @MappingTarget Cidade entity);
	
	public CidadeDTO toDTO(Cidade entity);

    public List<CidadeDTO> toDTOList(List<Cidade> entity);
}
