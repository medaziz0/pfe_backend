package com.cni.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cni.model.AOEntity;
import com.cni.model.ContratEntity;
import com.cni.model.FactureDto;
import com.cni.model.FactureEntity;
import com.cni.repository.ContratRepository;
import com.cni.repository.FactureRepository;
@Service
public class FactureServiceImpl implements FactureService {
	
	@Autowired
	FactureRepository factureRepository;
	
	@Autowired
	ContratRepository contratRepository;
	
	@Override
	public List<FactureEntity> getAllFacture(){
		List<FactureEntity> allFacturelist = factureRepository.findAll();
		System.out.println("URL Captée");
		return allFacturelist;	
	}
	
	
	@Override
	public FactureEntity getFacturebyId(Integer IdFacture)
	{
		FactureEntity factureEntity = factureRepository.findById(IdFacture).get();		
		return factureEntity;	
	}
	
	
	@Override
	public FactureEntity createFacture(FactureDto facture) {
		ContratEntity contrat = contratRepository.findById(facture.getContratId()).orElseThrow();
		FactureEntity savedFacture = new FactureEntity();
		savedFacture.setidentity(facture.getIdentity());
		savedFacture.setmontant(facture.getMontant());
		savedFacture.setRefFacture(facture.getReferenceFacture());
		savedFacture.setContrat(contrat);
		return factureRepository.save(savedFacture);
	}
	
	
	@Override
	public FactureEntity updateFacture(FactureEntity p) {
		FactureEntity facture = factureRepository.findById(p.getId()).get();

	        
	        facture.setidentity(p.getidentity());
	        facture.setmontant(p.getmontant());	
	        FactureEntity updatedFacture = factureRepository.save(facture);
	        return updatedFacture;
	    }
	
	@Override
    public boolean deleteFacture( Integer IdFacture)
    {
    	boolean response=false;
    	FactureEntity facture = factureRepository.findById(IdFacture).get();

        factureRepository.delete(facture);
      
        response=true;
        return response;
    }


	@Override
	public boolean deleteByContratId(Integer contratId) {
	    List<FactureEntity> factureList = factureRepository.findAll();
	    List<Integer> factureDeleted = factureList.stream()
	        .filter(f -> f.getcontrat().getId().equals(contratId))
	        .map(f -> f.getId())
	        .collect(Collectors.toList());  // Updated to use Collectors.toList()
	    factureRepository.deleteAllById(factureDeleted);
	    return false;
	}
	
	
}
