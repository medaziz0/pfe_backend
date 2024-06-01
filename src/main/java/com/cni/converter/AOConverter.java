package com.cni.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cni.model.AOEntity;
import com.cni.model.AoDto;

@Component
public class AOConverter {

	public AoDto entityToDto(AOEntity aoEntity) {

		AoDto dto = new AoDto();
		dto.setId(aoEntity.getId());
		dto.setMontant(aoEntity.getmontant());
		dto.setIdentity(aoEntity.getidentity());
		dto.setreferenceAO(aoEntity.getRefAO());
		dto.setProjetId(aoEntity.getProjet().getId());
		return dto;
	}

	public List<AoDto> entityToDto(List<AOEntity> aoEntity) {
		return aoEntity.stream().map(this::entityToDto).collect(Collectors.toList());
	}

	public AOEntity dtoToEntity(AoDto dto) {
		AOEntity entity = new AOEntity();
		entity.setId(dto.getId());
		entity.setidentity(dto.getIdentity());
		entity.setmontant(dto.getMontant());
		entity.setRefAO(dto.getreferenceAO());
		return entity;
	}

	public List<AOEntity> dtoToEntity(List<AoDto> dto) {
		return dto.stream().map(this::dtoToEntity).collect(Collectors.toList());
	}
}
