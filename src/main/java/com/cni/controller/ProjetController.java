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

import com.cni.converter.ProjetConverter;
import com.cni.model.AoDto;
import com.cni.model.Marker;
import com.cni.model.ProjetDto;
import com.cni.model.ProjetEntity;
import com.cni.repository.ProjetRepository;
import com.cni.service.ProjetService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.core.pattern.Converter;

@CrossOrigin("*")
@RestController

public class ProjetController {

	@Autowired
	ProjetService projetService;

	@Autowired
	ProjetRepository projetRepository;
	
	@Autowired
	ProjetConverter converter;


	@GetMapping("/get-all-Projet")
	public List<ProjetDto> getAllProjet() {
		List<ProjetEntity> getAllProjet = projetService.getAllProjet();
		return converter.entityToDto(getAllProjet);
	}

	@GetMapping("/get-projet/{id}")
	public ProjetDto getProjetbyId(@PathVariable(value = "id") Integer IdProjet)
	{
		ProjetEntity projetEntity = projetService.getProjetbyId(IdProjet);
		return converter.entityToDto(projetEntity);
	}

	@PostMapping("/create-projet")
	public ProjetDto createProjet(@RequestBody JsonNode json) {
		// Instantiate ObjectMapper for JSON parsing
        ObjectMapper mapper = new ObjectMapper();

        // Parse JSON to extract obj and marker fields
        JsonNode objNode = json.get("obj");
        JsonNode markerNode = json.get("marker");

        // Process markerNode as needed, assuming it's a Marker class
        Marker marker = mapper.convertValue(markerNode, Marker.class);
        ProjetDto projetDto = mapper.convertValue(objNode, ProjetDto.class);
		ProjetEntity projetEntity = converter.dtoToEntity(projetDto);
		projetEntity = projetService.createProjet(projetEntity,marker);
		return converter.entityToDto(projetEntity);

	}

	@PutMapping("/update-projet")
	public ResponseEntity<ProjetDto> updateProjet(@RequestBody ProjetDto projetDetails) {
	    ProjetEntity updatedProjetEntity = projetService.updateProjet(converter.dtoToEntity(projetDetails));
	    return ResponseEntity.ok(converter.entityToDto(updatedProjetEntity));
	}

	@DeleteMapping("/delete-projet/{id}")
	public ResponseEntity<Boolean> deleteProjet(@PathVariable(value = "id") Integer IdProjet) {
	    boolean deletionStatus = projetService.deleteProjet(IdProjet);
	    return ResponseEntity.ok(deletionStatus);
	}


}
