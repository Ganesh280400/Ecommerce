package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "prod")
public class Prod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_id")
	private Integer id;
	@Column(name = "prod_category")
	private String prodCategory;
	private String ProdName;
	private String ProdDescription;
	private double prodPrice;
	private double ProdCost;

	@Column(name = "current_stock")
	private int currentStock;

	@Column(name = "reord_level")
	private int reordLevel;

	@Column(name = "reord_qty")
	private int reordQty;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}

	public String getProdName() {
		return ProdName;
	}

	public void setProdName(String prodName) {
		ProdName = prodName;
	}

	public String getProdDescription() {
		return ProdDescription;
	}

	public void setProdDescription(String prodDescription) {
		ProdDescription = prodDescription;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public double getProdCost() {
		return ProdCost;
	}

	public void setProdCost(double prodCost) {
		ProdCost = prodCost;
	}

	public int getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}

	public int getReordLevel() {
		return reordLevel;
	}

	public void setReordLevel(int reordLevel) {
		this.reordLevel = reordLevel;
	}

	public int getReordQty() {
		return reordQty;
	}

	public void setReordQty(int reordQty) {
		this.reordQty = reordQty;
	}

}
