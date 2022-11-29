package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@Column(name="client_id")
	private Long clientId;
	
	@Column(name="type_presta")
	private String typePretsa;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="nb_days")
	private int nbDays;
	
	@Column(name="unit_price")
	private float unitPrice;
	
	@Column(name="state")
	private boolean state;

	
	
	public Order() {
		super();
	}



	public Order(Long clientId, String typePretsa, String designation, int nbDays, float unitPrice, boolean state) {
		super();
		this.clientId = clientId;
		this.typePretsa = typePretsa;
		this.designation = designation;
		this.nbDays = nbDays;
		this.unitPrice = unitPrice;
		this.state = state;
	}



	public Order(String typePretsa, String designation, int nbDays, float unitPrice, boolean state) {
		this.typePretsa = typePretsa;
		this.designation = designation;
		this.nbDays = nbDays;
		this.unitPrice = unitPrice;
		this.state = state;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getClientId() {
		return clientId;
	}



	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}



	public String getTypePretsa() {
		return typePretsa;
	}



	public void setTypePretsa(String typePretsa) {
		this.typePretsa = typePretsa;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public int getNbDays() {
		return nbDays;
	}



	public void setNbDays(int nbDays) {
		this.nbDays = nbDays;
	}



	public float getUnitPrice() {
		return unitPrice;
	}



	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}



	public boolean isState() {
		return state;
	}



	public void setState(boolean state) {
		this.state = state;
	}



	@Override
	public String toString() {
		return String.format(
				"order [id=%s, clientId=%s, typePretsa=%s, designation=%s, nbDays=%s, unitPrice=%s, state=%s]", id,
				clientId, typePretsa, designation, nbDays, unitPrice, state);
	}
	
	
	
}
