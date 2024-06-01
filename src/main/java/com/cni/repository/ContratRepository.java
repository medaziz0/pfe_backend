package com.cni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cni.model.ContratEntity;

@Repository
public interface ContratRepository extends JpaRepository<ContratEntity, Integer>{

	List<ContratEntity> findByAppelOffreProjetId(Integer IdProjet);
	}