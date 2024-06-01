package com.cni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cni.model.Marker;
import com.cni.model.ProjetEntity;
import com.cni.repository.MarkerRepository;
import com.cni.repository.ProjetRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class ProjetServiceImpl implements ProjetService {
	@Autowired
	ProjetRepository projetRepository;
	
	@Autowired
	AOService aoService;
	
	@Autowired
	MarkerRepository markerRepository;

	@Override
	public List<ProjetEntity> getAllProjet() {
		List<ProjetEntity> allProjetlist = projetRepository.findAll();
		System.out.println("URL Captée");
		return allProjetlist;
	}

	@Override
	public ProjetEntity getProjetbyId(Integer IdProjet) {
		ProjetEntity projetEntity = projetRepository.findById(IdProjet).get();
		return projetEntity;
	}

	@Override
	public ProjetEntity createProjet(ProjetEntity projet,Marker marker) {
		ProjetEntity savedProjet = projetRepository.save(projet);
		marker.setProject_id(savedProjet);
		if(marker.getLat() ==0.0 || marker.getLng() ==0.0)
			return savedProjet;
		markerRepository.save(marker);
		
		return savedProjet;
	}

	@Override
	public ProjetEntity updateProjet(ProjetEntity p) {
		ProjetEntity projet = projetRepository.findById(p.getId()).get();
		projet.setIntituly(p.getIntituly());
		projet.setProjetRef(p.getProjetRef());
		projet.setdateDebut(p.getdateDebut());
		projet.setdateFin(p.getdateFin());
		projet.setDescription(p.getDescription());
		projet.setCout(p.getCout());
		projet.setLieu(p.getLieu());
		ProjetEntity updatedProjet = projetRepository.save(projet);
		return updatedProjet;
	}

	@Override
	public boolean deleteProjet(Integer IdProjet) {
		Marker marker = markerRepository.findByProjectId(IdProjet);
		if(marker!=null) {
			markerRepository.delete(marker);
		}
		boolean response = false;
		java.util.Optional<ProjetEntity> projet = projetRepository.findById(IdProjet);
		if(projet.isPresent()) {
			aoService.deleteByProjet(IdProjet);
			projetRepository.delete(projet.get());
		}
			

		response = true;
		
		
		return response;
	}


}
