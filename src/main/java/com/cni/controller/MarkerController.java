package com.cni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cni.model.Marker;
import com.cni.service.MarkerService;

@CrossOrigin("*")
@RestController
@RequestMapping("/marker")
public class MarkerController {

	@Autowired
	MarkerService markerService;
	
	@GetMapping("/findByProjectId/{id}")
	public Marker getMarkerByProjectId(@PathVariable("id") Integer project_id) {
		return markerService.getMarkerByProjectId(project_id);
	}
	
}
