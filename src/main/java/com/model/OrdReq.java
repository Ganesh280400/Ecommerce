package com.model;

public class OrdReq {
	private Integer prodId;
    private int ordQty;
    
    public OrdReq() {
	}

	public OrdReq(Integer prodId, int ordQty) {
		this.prodId = prodId;
		this.ordQty = ordQty;
	}
    
	public int getOrdQty() {
		return ordQty;
	}
	public void setOrdQty(int ordQty) {
		this.ordQty = ordQty;
	}
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

}
