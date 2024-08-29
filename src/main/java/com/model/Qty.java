package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "qty")
public class Qty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer qtyId;

	@ManyToOne
	@JoinColumn(name = "prod_id")
	private Prod prod;

	Integer qty;

	public Integer getQtyId() {
		return qtyId;
	}

	public void setQtyId(Integer qtyId) {
		this.qtyId = qtyId;
	}

	public Prod getProd() {
		return prod;
	}

	public void setProd(Prod prod) {
		this.prod = prod;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer Qty) {
		this.qty = Qty;
	}

}
