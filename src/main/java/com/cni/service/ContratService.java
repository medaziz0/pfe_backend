package com.cni.service;

import java.util.List;

import com.cni.model.ContratDto;
import com.cni.model.ContratEntity;

public interface ContratService {

	List<ContratEntity> getAllContrat();

	ContratEntity createContrat(ContratDto contrat);

	ContratEntity updateContrat(ContratEntity contratDetails);

	boolean deleteContrat(Integer IdContrat);
	
	boolean deleteContratByAO(Integer IdAO);


	ContratEntity getContratbyId(Integer idContrat);



		

}
