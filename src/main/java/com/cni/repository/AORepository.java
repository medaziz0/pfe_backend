package com.cni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cni.model.AOEntity;

@Repository
public interface AORepository extends JpaRepository<AOEntity, Integer> {

    List<AOEntity> findByProjetId(Integer projetId);

}