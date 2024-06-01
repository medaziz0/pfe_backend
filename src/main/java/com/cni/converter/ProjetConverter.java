package com.cni.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cni.model.ProjetDto;
import com.cni.model.ProjetEntity;
@Component
public class ProjetConverter {

    public ProjetDto entityToDto(ProjetEntity projetEntity) {
        ProjetDto dto = new ProjetDto();
        dto.setIdprojet(projetEntity.getId());
        dto.setIntituly(projetEntity.getIntituly());
        dto.setDateDebut(projetEntity.getdateDebut());
        dto.setDateFin(projetEntity.getdateFin());
        dto.setprojetRef(projetEntity.getProjetRef());
        dto.setDescription(projetEntity.getDescription());
        dto.setLieu(projetEntity.getLieu());
        dto.setCout(projetEntity.getCout());
        dto.setLongitude(null);
        dto.setLattitude(null);
        return dto;
    }

    public List<ProjetDto> entityToDto(List<ProjetEntity> projetEntity) {
        return projetEntity.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public ProjetEntity dtoToEntity(ProjetDto dto) {
        ProjetEntity entity = new ProjetEntity();
        entity.setId(dto.getId());
        entity.setIntituly(dto.getIntituly());
        entity.setdateDebut(dto.getDateDebut());
        entity.setdateFin(dto.getDateFin());
        entity.setProjetRef(dto.getprojetRef());
        entity.setDescription(dto.getDescription());
        entity.setCout(dto.getCout());
        entity.setLieu(dto.getLieu());
        return entity;
    }

    public List<ProjetEntity> dtoToEntity(List<ProjetDto> dto) {
        return dto.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
