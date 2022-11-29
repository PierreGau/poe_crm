package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private Client client;
	
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



	public Order(Client client, String typePretsa, String designation, int nbDays, float unitPrice, boolean state) {
		this.client = client;
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



	public int getId() {
		return id;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public void setId(int id) {
		this.id = id;
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
				client, typePretsa, designation, nbDays, unitPrice, state);
	}
	
	
	
}
