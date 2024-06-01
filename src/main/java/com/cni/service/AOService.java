package com.cni.service;

import java.util.List;

import com.cni.model.AOEntity;
import com.cni.model.AoDto;

public interface AOService {

	List<AOEntity> getAllAO();

	AOEntity createAO(AoDto ao);

	AOEntity updateAO(AOEntity aoDetails);

	boolean deleteAO(Integer IdAO);
	
	boolean deleteByProjet(Integer ProjetId);

	AOEntity getAObyId(Integer idAO);

}
