package com.cni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cni.model.FactureEntity;
import com.cni.model.Marker;

@Repository
public interface MarkerRepository extends JpaRepository<Marker, Integer>{
	@Query(value = "SELECT * FROM marker m WHERE m.project_id = ?1", nativeQuery = true)
    Marker findByProjectId(Integer projectId);
}
