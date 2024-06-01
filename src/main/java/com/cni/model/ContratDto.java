package com.cni.model;

import java.math.BigDecimal;

public class ContratDto {

	private Integer id;

	private String identity;

	private BigDecimal montant;
	

    private String referenceContrat;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	private Integer aoId;
	private String refAO;



	public Integer getAoId() {
		return aoId;
	}

	public void setAoId(Integer aoId) {
		this.aoId = aoId;
	}

	public String getRefAO() {
		return refAO;
	}

	public void setRefAO(String refAO) {
		this.refAO = refAO;
	}

	public String getReferenceContrat() {
		return referenceContrat;
	}

	public void setReferenceContrat(String refContrat) {
		referenceContrat = refContrat;
	}

	




}