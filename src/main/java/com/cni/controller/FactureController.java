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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cni.converter.AOConverter;
import com.cni.converter.FactureConverter;
import com.cni.model.AOEntity;
import com.cni.model.AoDto;
import com.cni.model.FactureDto;
import com.cni.model.FactureEntity;
import com.cni.service.FactureService;

@CrossOrigin("*")
@RestController

public class FactureController {

	@Autowired
	FactureService factureService;

	@Autowired
	FactureConverter converter;
	
	@GetMapping("/get-all-facture")
	public List<FactureDto> getAllFacture() {
		List<FactureEntity> getAllFacture = factureService.getAllFacture();
		return converter.entityToDto(getAllFacture);
	}

	@GetMapping("/get-facture/{id}")
	public FactureDto getFacturebyId(@PathVariable(value = "id") Integer IdFacture)
	{
		FactureEntity factureEntity = factureService.getFacturebyId(IdFacture);
		return converter.entityToDto(factureEntity);
	}

	@PostMapping("/create-facture/{id}")
	public FactureDto createFacture(@RequestBody FactureDto facture) {
		FactureEntity factureEntity = factureService.createFacture(facture);
		
		return converter.entityToDto(factureEntity);

	}

	@PutMapping("/update-facture")
	public ResponseEntity<FactureDto> updateFacture(@RequestBody FactureDto factureDetails) {
	    FactureEntity updatedFactureEntity = factureService.updateFacture(converter.dtoToEntity(factureDetails));
	    return ResponseEntity.ok(converter.entityToDto(updatedFactureEntity));
	}

	@DeleteMapping("/delete-facture/{id}")
	public ResponseEntity<Boolean> deleteFacture(@PathVariable(value = "id") Integer IdFacture) {
	    boolean deletionStatus = factureService.deleteFacture(IdFacture);
	    return ResponseEntity.ok(deletionStatus);
	}

}
