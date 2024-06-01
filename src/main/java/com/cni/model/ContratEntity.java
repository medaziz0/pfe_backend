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
@Table(name = "contrat")
public class ContratEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "identity", nullable = false)
	private String identity;

	@Column(name = "montant", nullable = false)
	private BigDecimal montant;

	private String referenceContrat;

	@ManyToOne
	@JoinColumn(name = "appel_Offre_id", nullable = false)
	private AOEntity appelOffre;

	public ContratEntity() {

	}

	public ContratEntity(String identity, BigDecimal montant, Integer OffreId,String referenceContrat) {
		this.identity = identity;
		this.montant = montant;
		this.referenceContrat = referenceContrat;

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

	public AOEntity getappelOffre() {
		return appelOffre;
	}

	public void setappelOffre(AOEntity appelOffre) {
		this.appelOffre = appelOffre;
	}

	
	@Override
	public String toString() {
		return "ContratEntity [id=" + id + ", identity=" + identity + ", montant=" + montant + ", referenceContrat="
				+ referenceContrat + ", appelOffre=" + appelOffre + ", getId()=" + getId() + ", getidentity()="
				+ getidentity() + ", getmontant()=" + getmontant() + ", getappelOffre()=" + getappelOffre()
				+ ", getRefContrat()=" + getReferenceContrat() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public String getReferenceContrat() {
		return referenceContrat;
	}

	public void setReferenceContrat(String refContrat) {
		referenceContrat = refContrat;
	}
}