package com.cni.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cni.model.AOEntity;
import com.cni.model.ContratDto;
import com.cni.model.ContratEntity;
import com.cni.model.ProjetEntity;
import com.cni.repository.AORepository;
import com.cni.repository.ContratRepository;
@Service
public class ContratServiceImpl implements ContratService {
	@Autowired
	ContratRepository contratRepository;
	@Autowired
	AORepository AORepository;
	@Autowired
	FactureService factureService;
	
	@Override
	public List<ContratEntity> getAllContrat(){
		List<ContratEntity> allContratlist = contratRepository.findAll();
		System.out.println("URL Captée");
		return allContratlist;	
	}
	
	
	@Override
	public ContratEntity getContratbyId(Integer IdContrat)
	{
		ContratEntity contratEntity = contratRepository.findById(IdContrat).get();		
		return contratEntity;	
	}
	
	
	@Override
	public ContratEntity createContrat(ContratDto contrat) {
		AOEntity ao = AORepository.findById(contrat.getAoId()).orElseThrow();
		ContratEntity savedContrat = new ContratEntity();
		savedContrat.setidentity(contrat.getIdentity());
		savedContrat.setmontant(contrat.getMontant());
		savedContrat.setReferenceContrat(contrat.getReferenceContrat());
		savedContrat.setappelOffre(ao);
		return contratRepository.save(savedContrat);
	}
	
	
	@Override
	public ContratEntity updateContrat(ContratEntity p) {
		ContratEntity contrat = contratRepository.findById(p.getId()).get();

	        contrat.setReferenceContrat(p.getReferenceContrat());
	        contrat.setidentity(p.getidentity());
	        contrat.setmontant(p.getmontant());	
	        ContratEntity updatedContrat = contratRepository.save(contrat);
	        return updatedContrat;
	    }
	
	@Override
    public boolean deleteContrat( Integer IdContrat)
    {
    	boolean response=false;
    	ContratEntity contrat = contratRepository.findById(IdContrat).get();
    	factureService.deleteByContratId(IdContrat);
        contratRepository.delete(contrat);
      
        response=true;
        return response;
    }


	@Override
	public boolean deleteContratByAO(Integer IdAO) {
	    List<ContratEntity> contratList = contratRepository.findAll();
	    List<Integer> contratListDelete = contratList.stream()
	        .filter(c -> c.getappelOffre().getId().equals(IdAO))
	        .map(c -> c.getId())
	        .collect(Collectors .toList());  // Updated to use Collectors.toList()
	    contratListDelete.forEach(c -> factureService.deleteByContratId(c));
	    contratRepository.deleteAllById(contratListDelete);
	    return false;
	}
}
