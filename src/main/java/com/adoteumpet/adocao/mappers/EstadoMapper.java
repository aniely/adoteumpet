package com.adoteumpet.adocao.mappers;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.adoteumpet.adocao.dtos.EstadoDTO;
import com.adoteumpet.adocao.entities.Estado;

@Mapper(componentModel="spring")
public interface EstadoMapper {
	
	@Mapping(target="id", ignore=true) 
	@BeanMapping(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, 
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public Estado toEntity(EstadoDTO dto, @MappingTarget Estado entity);
	
	public EstadoDTO toDTO(Estado entity);

    public List<EstadoDTO> toDTOList(List<Estado> entity);
}
