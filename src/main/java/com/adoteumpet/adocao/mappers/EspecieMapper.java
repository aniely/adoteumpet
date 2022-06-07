package com.adoteumpet.adocao.mappers;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;


import com.adoteumpet.adocao.dtos.EspecieDTO;
import com.adoteumpet.adocao.entities.Especie;

@Mapper(componentModel="spring")
public interface EspecieMapper {
	
	@Mapping(target="id", ignore=true) 
	@BeanMapping(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, 
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public Especie toEntity(EspecieDTO dto, @MappingTarget Especie entity);
	
	public EspecieDTO toDTO(Especie entity);

    public List<EspecieDTO> toDTOList(List<Especie> entity);
}
