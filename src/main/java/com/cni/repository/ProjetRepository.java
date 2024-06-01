package com.cni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cni.model.ProjetEntity;

@Repository
public interface ProjetRepository extends JpaRepository<ProjetEntity, Integer> {

}