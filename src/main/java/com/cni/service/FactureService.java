package com.cni.service;

import java.util.List;

import com.cni.model.FactureDto;
import com.cni.model.FactureEntity;

public interface FactureService {

	List<FactureEntity> getAllFacture();

	FactureEntity createFacture(FactureDto facture);

	FactureEntity updateFacture(FactureEntity factureDetails);

	boolean deleteFacture(Integer IdFacture);
	
	boolean deleteByContratId(Integer contratId);

	FactureEntity getFacturebyId(Integer idFacture);



		

}
