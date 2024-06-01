 package com.cni.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "projet")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class ProjetEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "intituly", nullable = false)
	private String intituly;
	
	@Column(name = "dateDebut", nullable = false)
	private String dateDebut;

	@Column(name = "dateFin", nullable = false)
	private String dateFin;
	
	@Column(name = "Description", nullable = false)
	private String Description;
	
	@Column(name = "Cout", nullable = false)
	private BigDecimal Cout;
	
	@Column(name = "Lieu", nullable = false)
	private String Lieu;

	private String projetRef;

	@OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
	private List<AOEntity> appelsOffre;

	public ProjetEntity() {

	}

	public ProjetEntity(String dateDebut, String dateFin, String projetRef,String intituly, List<AOEntity> appelsOffre,String Description,BigDecimal Cout,String Lieu) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.projetRef = projetRef;
		this.intituly = intituly;
		this.Description = Description;
		this.Cout = Cout;
		this.Lieu = Lieu;
		this.appelsOffre = appelsOffre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getIntituly() {
		return intituly;
	}
	public void setIntituly(String intituly) {
		this.intituly = intituly;
	}
	public String getdateDebut() {
		return dateDebut;
	}

	public void setdateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getdateFin() {
		return dateFin;
	}

	public void setdateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public String getProjetRef() {
		return projetRef;
	}

	public void setProjetRef(String projetRef) {
		this.projetRef = projetRef;
	}

	public List<AOEntity> getAppelsOffre() {
		return appelsOffre;
	}

	public void setAppelsOffre(List<AOEntity> appelsOffre) {
		this.appelsOffre = appelsOffre;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public BigDecimal getCout() {
		return Cout;
	}

	public void setCout(BigDecimal cout) {
		Cout = cout;
	}

	public String getLieu() {
		return Lieu;
	}

	public void setLieu(String lieu) {
		Lieu = lieu;
	}

	@Override
	public String toString() {
		return "ProjetEntity [id=" + id + ", intituly=" + intituly + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", Description=" + Description + ", Cout=" + Cout + ", Lieu=" + Lieu + ", projetRef=" + projetRef
				+ ", appelsOffre=" + appelsOffre + ", getId()=" + getId() + ", getIntituly()=" + getIntituly()
				+ ", getdateDebut()=" + getdateDebut() + ", getdateFin()=" + getdateFin() + ", getProjetRef()="
				+ getProjetRef() + ", getAppelsOffre()=" + getAppelsOffre() + ", getDescription()=" + getDescription()
				+ ", getCout()=" + getCout() + ", getLieu()=" + getLieu() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	


}