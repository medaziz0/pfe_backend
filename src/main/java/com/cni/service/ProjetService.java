package com.cni.service;

import java.util.List;

import com.cni.model.Marker;
import com.cni.model.ProjetDto;
import com.cni.model.ProjetEntity;
	
public interface ProjetService {

	List<ProjetEntity> getAllProjet();

	ProjetEntity getProjetbyId(Integer IdProjet);

	ProjetEntity createProjet(ProjetEntity projet,Marker marker);

	ProjetEntity updateProjet(ProjetEntity projetDetails);

	boolean deleteProjet(Integer IdProjet);

}
