package com.cni.converter;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cni.model.ContratDto;
import com.cni.model.ContratEntity;
import com.cni.model.FactureDto;
import com.cni.model.FactureEntity;
@Component
public class FactureConverter {

	public FactureDto entityToDto(FactureEntity factureEntity) {
		
		FactureDto dto = new FactureDto();
			dto.setId(factureEntity.getId());
			dto.setMontant(factureEntity.getmontant());
			dto.setIdentity(factureEntity.getidentity());
			dto.setReferenceFacture(factureEntity.getRefFacture());
			dto.setContratId(factureEntity.getcontrat().getId());
				return dto;
		}
	public List<FactureDto> entityToDto(List<FactureEntity> factureEntity) {
	    return factureEntity.stream().map(this::entityToDto).collect(Collectors.toList());
	}

	public FactureEntity dtoToEntity(FactureDto dto) {
		
		FactureEntity entity = new FactureEntity();
		    entity.setId(dto.getId());
		    entity.setidentity(dto.getIdentity());
		    entity.setmontant(dto.getMontant());
		    entity.setRefFacture(dto.getReferenceFacture());
		    return entity;
	}

	public List<FactureEntity> dtoToEntity(List<FactureDto> Listdto) {
	    return Listdto.stream().map(this::dtoToEntity).collect(Collectors.toList());
	}
	
	
}
