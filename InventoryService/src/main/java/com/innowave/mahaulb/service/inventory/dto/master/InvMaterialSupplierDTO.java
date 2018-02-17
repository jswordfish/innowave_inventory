package com.innowave.mahaulb.service.inventory.dto.master;

import java.io.Serializable;


public class InvMaterialSupplierDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long supplierId;
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public Integer serial;
	public String supplierTyp;
	public String supplierCode;
	public String parentSupplierCode;
	public String supplierName;
	public Integer getSerial() {
		return serial;
	}
	public void setSerial(Integer serial) {
		this.serial = serial;
	}
	public String getSupplierTyp() {
		return supplierTyp;
	}
	public void setSupplierTyp(String supplierTyp) {
		this.supplierTyp = supplierTyp;
	}
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getParentSupplierCode() {
		return parentSupplierCode;
	}
	public void setParentSupplierCode(String parentSupplierCode) {
		this.parentSupplierCode = parentSupplierCode;
	}
	

}
