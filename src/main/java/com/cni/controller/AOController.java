package com.cni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cni.converter.AOConverter;
import com.cni.model.AOEntity;
import com.cni.model.AoDto;
import com.cni.repository.AORepository;
import com.cni.repository.ProjetRepository;
import com.cni.service.AOService;

@CrossOrigin("*")
@RestController

public class AOController {

	@Autowired
	AOService aoService;
	@Autowired
	ProjetRepository projetRepository;
	@Autowired
	AORepository appelOffreRepository;
	@Autowired
	AOConverter converter;
	
//	@GetMapping("/get-all-ao")
//	public List<AOEntity> getAllAO() {
//		return aoService.getAllAO();
//		
//	}
	
	@GetMapping("/get-all-ao")
	public List<AoDto> getAllAO() {
		List<AOEntity> getAllAO = aoService.getAllAO();
		return converter.entityToDto(getAllAO);
	}

	@GetMapping("/get-ao/{id}")
	public AoDto getAObyId(@PathVariable(value = "id") Integer IdAO)
	{
		AOEntity aoEntity = aoService.getAObyId(IdAO);
		return converter.entityToDto(aoEntity);
	}

	@PostMapping("/create-ao/{id}")
	public AoDto createAo(@RequestBody AoDto ao) {
		System.out.println("this is RefAO"+ao.getreferenceAO());
		System.out.println("this is Identity"+ao.getIdentity());
		AOEntity aoEntity = aoService.createAO(ao);
		return converter.entityToDto(aoEntity);

	}

	@PutMapping("/update-ao")
	public ResponseEntity<AoDto> updateAO(@RequestBody AoDto aoDetails) {
	    AOEntity updatedAOEntity = aoService.updateAO(converter.dtoToEntity(aoDetails));
	    return ResponseEntity.ok(converter.entityToDto(updatedAOEntity));
	}

	@DeleteMapping("/delete-ao/{id}")
	public ResponseEntity<Boolean> deleteAO(@PathVariable(value = "id") Integer IdAO) {
	    boolean deletionStatus = aoService.deleteAO(IdAO);
	    return ResponseEntity.ok(deletionStatus);
	}

}
