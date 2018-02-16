package com.innowave.mahaulb.web.inventory.controller.forms;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.innowave.mahaulb.repository.inventory.dao.trans.TtInvRateContract;

public class InventoryPriceMasterDTO {
	
	String supplierId;
	
	String rateTypeId;
	
	String supplierName;
	
	String rateType;
	
	Date agreementStartDate;
	
	Date agreementEndDate;
	
	String rateContractQuotNo;
	
	String agreementNo;
	
	Date agreementStartDateSearchScreen;
	Date agreementEndDateSearchScreen;
	
	List<TtInvRateContract > rates = new ArrayList<>();

	TtInvRateContract current = new TtInvRateContract();

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getRateTypeId() {
		return rateTypeId;
	}

	public void setRateTypeId(String rateTypeId) {
		this.rateTypeId = rateTypeId;
	}

	public Date getAgreementStartDate() {
		return agreementStartDate;
	}

	public void setAgreementStartDate(Date agreementStartDate) {
		this.agreementStartDate = agreementStartDate;
	}

	public Date getAgreementEndDate() {
		return agreementEndDate;
	}

	public void setAgreementEndDate(Date agreementEndDate) {
		this.agreementEndDate = agreementEndDate;
	}

	public List<TtInvRateContract> getRates() {
		return rates;
	}

	public void setRates(List<TtInvRateContract> rates) {
		this.rates = rates;
	}

	public TtInvRateContract getCurrent() {
		return current;
	}

	public void setCurrent(TtInvRateContract current) {
		this.current = current;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getRateType() {
		return rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public String getRateContractQuotNo() {
		return rateContractQuotNo;
	}

	public void setRateContractQuotNo(String rateContractQuotNo) {
		this.rateContractQuotNo = rateContractQuotNo;
	}

	public String getAgreementNo() {
		return agreementNo;
	}

	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	}

	public Date getAgreementStartDateSearchScreen() {
		return agreementStartDateSearchScreen;
	}

	public void setAgreementStartDateSearchScreen(Date agreementStartDateSearchScreen) {
		this.agreementStartDateSearchScreen = agreementStartDateSearchScreen;
	}

	public Date getAgreementEndDateSearchScreen() {
		return agreementEndDateSearchScreen;
	}

	public void setAgreementEndDateSearchScreen(Date agreementEndDateSearchScreen) {
		this.agreementEndDateSearchScreen = agreementEndDateSearchScreen;
	}
	
	

}
