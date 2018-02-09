package com.innowave.mahaulb.service.inventory.dto.master;

public class MaterialTypeMappingDTO implements java.io.Serializable {
	
	Integer serial;
	
	String storeName;
	
	String storeCode;
	
	long storeId;
	
	String depName;
	
	int depId;
	
	String accountCode;
	
	String materialTypeName;
	
	String materialTypeCode;
	
	Long materialTypeStoreMapId;
	
	Long materialTypeId;
	
	Boolean active;

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getMaterialTypeName() {
		return materialTypeName;
	}

	public void setMaterialTypeName(String materialTypeName) {
		this.materialTypeName = materialTypeName;
	}

	public Long getMaterialTypeStoreMapId() {
		return materialTypeStoreMapId;
	}

	public void setMaterialTypeStoreMapId(Long materialTypeStoreMapId) {
		this.materialTypeStoreMapId = materialTypeStoreMapId;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Integer getSerial() {
		return serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	public Long getMaterialTypeId() {
		return materialTypeId;
	}

	public void setMaterialTypeId(Long materialTypeId) {
		this.materialTypeId = materialTypeId;
	}

	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getMaterialTypeCode() {
		return materialTypeCode;
	}

	public void setMaterialTypeCode(String materialTypeCode) {
		this.materialTypeCode = materialTypeCode;
	}
	
	@Override
	public int hashCode() {
		return (getMaterialTypeCode() +"-"+getStoreCode()).hashCode();
	}

}
