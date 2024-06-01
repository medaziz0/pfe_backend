package com.cni.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cni.model.AOEntity;
import com.cni.model.AoDto;
import com.cni.model.ContratDto;
import com.cni.model.ContratEntity;

@Component
public class ContratConverter {

public ContratDto entityToDto(ContratEntity contratEntity) {
		
	ContratDto dto = new ContratDto();
		dto.setId(contratEntity.getId());
		dto.setMontant(contratEntity.getmontant());
		dto.setIdentity(contratEntity.getidentity());
		dto.setReferenceContrat(contratEntity.getReferenceContrat());
		dto.setAoId(contratEntity.getappelOffre().getId());
			return dto;
	}
public List<ContratDto> entityToDto(List<ContratEntity> contratEntity) {
    return contratEntity.stream().map(this::entityToDto).collect(Collectors.toList());
}

public ContratEntity dtoToEntity(ContratDto dto) {
	ContratEntity entity = new ContratEntity();
    entity.setId(dto.getId());
    entity.setReferenceContrat(dto.getReferenceContrat());
    entity.setmontant(dto.getMontant());
    entity.setidentity(dto.getIdentity());
    return entity;
}

public List<ContratEntity> dtoToEntity(List<ContratDto> dto) {
    return dto.stream().map(this::dtoToEntity).collect(Collectors.toList());
}
}
