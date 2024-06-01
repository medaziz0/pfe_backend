package com.cni.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cni.converter.AOConverter;
import com.cni.converter.ContratConverter;
import com.cni.model.AOEntity;
import com.cni.model.AoDto;
import com.cni.model.ContratDto;
import com.cni.model.ContratEntity;
import com.cni.repository.AORepository;
import com.cni.repository.ContratRepository;
import com.cni.service.ContratService;

@CrossOrigin("*")
@RestController

public class ContratController {

	
	@Autowired
	ContratService contratService;
	@Autowired
	ContratRepository contratRepository;
	@Autowired
	AORepository appelOffreRepository;
	@Autowired
	ContratConverter converter;
	
	@GetMapping("/get-all-contrat")
	public List<ContratDto> getAllContrat() {
		List<ContratEntity> getAllContrat = contratService.getAllContrat();
		return converter.entityToDto(getAllContrat);
	}

	@GetMapping("/get-contrat/{id}")
	public ContratDto getContratbyId(@PathVariable(value = "id") Integer IdContrat)
	{
		ContratEntity contratEntity = contratService.getContratbyId(IdContrat);
		return converter.entityToDto(contratEntity);
	}

	@PostMapping("/create-contrat/{id}")
	public ContratDto createContrat(@RequestBody ContratDto contrat) {
		ContratEntity contratEntity = contratService.createContrat(contrat);
		return converter.entityToDto(contratEntity);

	}

	@PutMapping("/update-contrat")
	public ResponseEntity<ContratDto> updateContrat(@RequestBody ContratDto contratDetails) {
	    ContratEntity updatedContratEntity = contratService.updateContrat(converter.dtoToEntity(contratDetails));
	    return ResponseEntity.ok(converter.entityToDto(updatedContratEntity));
	}

	@DeleteMapping("/delete-contrat/{id}")
	public ResponseEntity<Boolean> deleteContrat(@PathVariable(value = "id") Integer IdContrat) {
	    boolean deletionStatus = contratService.deleteContrat(IdContrat);
	    return ResponseEntity.ok(deletionStatus);
	}

}
