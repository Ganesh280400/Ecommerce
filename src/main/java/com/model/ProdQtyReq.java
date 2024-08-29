package com.model;

public class ProdQtyReq {
	private Prod prod;
	private Qty qty;

	public ProdQtyReq() {

	}

	public ProdQtyReq(Prod prod, Qty qty) {
		this.setProd(prod);
		this.setQty(qty);
	}

	public Prod getProd() {
		return prod;
	}

	public void setProd(Prod prod) {
		this.prod = prod;
	}

	public Qty getQty() {
		return qty;
	}

	public void setQty(Qty qty) {
		this.qty = qty;
	}

}
