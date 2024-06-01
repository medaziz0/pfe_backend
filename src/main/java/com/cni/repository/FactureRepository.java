package com.cni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cni.model.ContratEntity;
import com.cni.model.FactureEntity;

@Repository
public interface FactureRepository extends JpaRepository<FactureEntity, Integer>{
	
	List<FactureEntity> findByContratAppelOffreProjetId(Integer IdProjet);

	}