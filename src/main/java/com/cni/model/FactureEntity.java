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
@Table(name = "facture")
public class FactureEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	    private Integer id;
	    
	    @Column(name = "identity", nullable = false)
	    private String identity;
	    
	    @Column(name = "montant", nullable = false)
	    private BigDecimal montant;
	    
	    private String refFacture;
	    
	    @ManyToOne
		@JoinColumn(name = "contrat_id", nullable = false)
		private ContratEntity contrat;
	    
	    public FactureEntity() {
	  
	    }
	 
	    public FactureEntity(String identity, BigDecimal montant) {
	         this.identity = identity;
	         this.montant = montant;
	        
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
	    public ContratEntity getcontrat() {
			return contrat;
		}

		public void setContrat(ContratEntity contrat) {
			this.contrat = contrat;
		}

		public String getRefFacture() {
			return refFacture;
		}

		public void setRefFacture(String refFacture) {
			this.refFacture = refFacture;
		}
	   
		

}
	