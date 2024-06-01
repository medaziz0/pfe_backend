package com.cni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cni.model.AOEntity;
import com.cni.model.AoDto;
import com.cni.model.ProjetEntity;
import com.cni.repository.AORepository;
import com.cni.repository.ProjetRepository;

@Service
public class AOServiceImpl implements AOService {
	@Autowired
	AORepository AORepository;

	@Autowired
	ProjetRepository projetRepository;
	@Autowired
	ContratService contratService;
	
	@Override
	public List<AOEntity> getAllAO() {
		List<AOEntity> allAOlist = AORepository.findAll();
		return allAOlist;
	}

	@Override
	public AOEntity getAObyId(Integer IdAO) {
		AOEntity AOEntity = AORepository.findById(IdAO).get();
		return AOEntity;
	}

	@Override
	public AOEntity createAO(AoDto AO) {
		ProjetEntity projet = projetRepository.findById(AO.getProjetId()).orElseThrow();
		AOEntity savedAO = new AOEntity();
		savedAO.setidentity(AO.getIdentity());
		savedAO.setmontant(AO.getMontant());
		savedAO.setRefAO(AO.getreferenceAO());
		savedAO.setProjet(projet);
		return AORepository.save(savedAO);
	}

	@Override
	public AOEntity updateAO(AOEntity p) {
		AOEntity AO = AORepository.findById(p.getId()).get();
		AO.setidentity(p.getidentity());
		AO.setmontant(p.getmontant());
		AO.setRefAO(p.getRefAO());
		AOEntity updatedAO = AORepository.save(AO);
		return updatedAO;
	}

	@Override
	public boolean deleteAO(Integer IdAO) {
		System.out.println("here deleted AO"+IdAO);
		boolean response = false;
		AOEntity AO = AORepository.findById(IdAO).get();
		contratService.deleteContratByAO(IdAO);
		AORepository.delete(AO);

		response = true;
		return response;
	}

	@Override
	public boolean deleteByProjet(Integer ProjetId) {
		List<AOEntity> aoList = AORepository.findAll();
		List<AOEntity> AODeleted = aoList.stream().filter(ao->ao.getProjet().getId().equals(ProjetId)).toList();
		AODeleted.stream().forEach(c->this.deleteAO(c.getId()));
		AORepository.deleteAllInBatch(AODeleted);
		return false;
	}

}
