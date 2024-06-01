package com.cni.model;

import java.math.BigDecimal;

import javax.print.event.PrintJobAttributeEvent;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjetDto {

	private Integer id;

	private String intituly;
	
	private String dateDebut;

	private String dateFin;
	
	private String description;
	
	private BigDecimal cout;
	
	private String lieu;
	
	private String projetRef;
	
	@JsonProperty("lattitude")
	private Long lattitude;
	
	@JsonProperty("longitude")
	private Long longitude;

	public Long getLattitude() {
		return lattitude;
	}

	public void setLattitude(Long lattitude) {
		this.lattitude = lattitude;
	}

	public Long getLongitude() {
		return longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}

	public Integer getId() {
		return id;
	}

	public void setIdprojet(Integer id) {
		this.id = id;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public String getprojetRef() {
		return projetRef;
	}

	public void setprojetRef(String projetRef) {
		this.projetRef = projetRef;
	}

	public String getIntituly() {
		return intituly;
	}

	public void setIntituly(String intituly) {
		this.intituly = intituly;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getCout() {
		return cout;
	}

	public void setCout(BigDecimal cout) {
		this.cout = cout;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}



	

}