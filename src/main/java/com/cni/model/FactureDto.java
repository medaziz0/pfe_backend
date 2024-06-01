package com.cni.model;

import java.math.BigDecimal;

public class FactureDto {

	private Integer id;
	private String identity;
	private String referenceFacture;

	private BigDecimal montant;
	
	private Integer contratId;
	
	
	

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montantFacture) {
		this.montant = montantFacture;
	}

	public Integer getContratId() {
		return contratId;
	}

	public void setContratId(Integer contratId) {
		this.contratId = contratId;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer idFacture) {
		this.id = idFacture;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getReferenceFacture() {
		return referenceFacture;
	}

	public void setReferenceFacture(String referenceFacture) {
		this.referenceFacture = referenceFacture;
	}






}