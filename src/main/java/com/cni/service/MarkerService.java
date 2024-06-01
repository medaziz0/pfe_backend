package com.cni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cni.model.Marker;
import com.cni.repository.MarkerRepository;

@Service
public class MarkerService {
	
	@Autowired
	private MarkerRepository markerRepository;

	public Marker getMarkerByProjectId(Integer project_id) {
		return markerRepository.findByProjectId(project_id);
	}
}
