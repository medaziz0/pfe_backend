package com.cni.model;

import java.math.BigDecimal;

public class AoDto {

	private Integer id;

	private String identity;

	private BigDecimal montant;
	
	private Integer projetId;

	private String referenceAO;
//	private String refProjet;

	
	
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



//	public String getRefProjet() {
//		return refProjet;
//	}
//
//
//
//	public void setRefProjet(String refProjet) {
//		this.refProjet = refProjet;
//	}

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}
	

	public Integer getProjetId() {
		return projetId;
	}



	public void setProjetId(Integer projetId) {
		this.projetId = projetId;
	}



	public String getreferenceAO() {
		return referenceAO;
	}



	public void setreferenceAO(String RefAO) {
		this.referenceAO = RefAO;
	}

}