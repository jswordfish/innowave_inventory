package com.innowave.mahaulb.web.inventory.controller.forms;

import java.io.Serializable;
import java.util.List;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.service.inventory.dto.master.InvMaterialSupplierDTO;

public class InvMaterialSupplierForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<TmCmLookupDet> suppliersTyp;
	public String selectedSupplier;
	public List<InvMaterialSupplierDTO> supplierlist;
	
	public List<InvMaterialSupplierDTO> getSupplierlist() {
		return supplierlist;
	}
	public void setSupplierlist(List<InvMaterialSupplierDTO> supplierlist) {
		this.supplierlist = supplierlist;
	}
	public List<TmCmLookupDet> getSuppliersTyp() {
		return suppliersTyp;
	}
	public void setSuppliersTyp(List<TmCmLookupDet> suppliersTyp) {
		this.suppliersTyp = suppliersTyp;
	}
	public String getSelectedSUpplier() {
		return selectedSupplier;
	}
	public void setSelectedSUpplier(String selectedSupplier) {
		this.selectedSupplier = selectedSupplier;
	}
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getParentSupplierCode() {
		return parentSupplierCode;
	}
	public void setParentSupplierCode(String parentSupplierCode) {
		this.parentSupplierCode = parentSupplierCode;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String supplierCode;
	public String parentSupplierCode;
	public String supplierName;
	public String supplierAddress;
	public String contactPerson;
	public String contactNumber;
	public String email;
	public String website;
	public String tinNo;
	public String panNo;
	public String cstNo;
	public String uatNo;
	public String gstNo;
	public String bankName;
	public String ifsc;
	public String bankAcc;
	public String getSelectedSupplier() {
		return selectedSupplier;
	}
	public void setSelectedSupplier(String selectedSupplier) {
		this.selectedSupplier = selectedSupplier;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getTinNo() {
		return tinNo;
	}
	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getCstNo() {
		return cstNo;
	}
	public void setCstNo(String cstNo) {
		this.cstNo = cstNo;
	}
	public String getUatNo() {
		return uatNo;
	}
	public void setUatNo(String uatNo) {
		this.uatNo = uatNo;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getBankAcc() {
		return bankAcc;
	}
	public void setBankAcc(String bankAcc) {
		this.bankAcc = bankAcc;
	}
	
	
	

}
