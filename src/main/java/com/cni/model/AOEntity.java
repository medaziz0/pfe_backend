package com.cni.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "AppelOffre")



public class AOEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "identity", nullable = false)
	private String identity;

	@Column(name = "montant", nullable = false)
	private BigDecimal montant;
	
	
	private String RefAO;
	
	
	@ManyToOne
    @JoinColumn(name = "projet_id", nullable = false)
    private ProjetEntity projet;
	
	public AOEntity(String identity, BigDecimal montant, Integer pId, ProjetEntity projet,String RefAO) {
		super();
		this.identity = identity;
		this.montant = montant;		
		this.projet = projet;
		this.RefAO = RefAO;
	}

	public AOEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	public String getidentity() {
		return identity;
	}

	public void setidentity(String identity) {
		this.identity = identity;
	}

	public BigDecimal getmontant() {
		return montant;
	}

	public void setmontant(BigDecimal montant) {
		this.montant = montant;
	}
	

	public ProjetEntity getProjet() {
		return projet;
	}



	public void setProjet(ProjetEntity projet) {
		this.projet = projet;
	}

	public String getRefAO() {
		return RefAO;
	}

	public void setRefAO(String RefAO) {
		this.RefAO = RefAO;
	}

	@Override
	public String toString() {
		return "AOEntity [id=" + id + ", identity=" + identity + ", montant=" + montant + ", RefAO=" + RefAO
				+ ", projet=" + projet + ", getId()=" + getId() + ", getidentity()=" + getidentity() + ", getmontant()="
				+ getmontant() + ", getProjet()=" + getProjet() + ", getRefAO()=" + getRefAO() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	



	



}