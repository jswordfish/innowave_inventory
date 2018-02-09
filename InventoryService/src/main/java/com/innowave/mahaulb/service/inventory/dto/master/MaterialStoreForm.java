package com.innowave.mahaulb.service.inventory.dto.master;

import java.io.Serializable;
import java.util.List;

import com.innowave.mahaulb.common.dao.master.TmCmDepartment;
import com.innowave.mahaulb.common.dao.master.TmUsers;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;

public class MaterialStoreForm  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long storeId;
	public long getStoreId() {
		return storeId;
	}
	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}
	private String storeCode;
	public List<MaterialStoreDTO> getMaterialStoreDTOs() {
		return materialStoreDTOs;
	}
	public void setMaterialStoreDTOs(List<MaterialStoreDTO> materialStoreDTOs) {
		this.materialStoreDTOs = materialStoreDTOs;
	}
	public MaterialStoreDTO getSelectMaterial() {
		return selectMaterial;
	}
	public void setSelectMaterial(MaterialStoreDTO selectMaterial) {
		this.selectMaterial = selectMaterial;
	}
	private String storeName;
	private List<TmCmDepartment> cmDepartments;
	private List<MaterialStoreDTO> materialStoreDTOs;
	private MaterialStoreDTO selectMaterial;
	private List<TmInvStore> invStores;
	private String selectedInvStore;
	public List<TmInvStore> getInvStores() {
		return invStores;
	}
	public void setInvStores(List<TmInvStore> invStores) {
		this.invStores = invStores;
	}
	public String getSelectedInvStore() {
		return selectedInvStore;
	}
	public void setSelectedInvStore(String selectedInvStore) {
		this.selectedInvStore = selectedInvStore;
	}
	private String selectedDept;
	private String storeDesc;
	private boolean centralStore;
	public boolean isCentralStore() {
		return centralStore;
	}
	public void setCentralStore(boolean centralStore) {
		this.centralStore = centralStore;
	}
	private String billingAddress;
	private String deliveryAddress;
	private List<TmUsers> tmUsers;
	private String selectedUser;
	private String contact1;
	private String contact2;
	private boolean active;
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public List<TmCmDepartment> getCmDepartments() {
		return cmDepartments;
	}
	public void setCmDepartments(List<TmCmDepartment> cmDepartments) {
		this.cmDepartments = cmDepartments;
	}
	public String getSelectedDept() {
		return selectedDept;
	}
	public void setSelectedDept(String selectedDept) {
		this.selectedDept = selectedDept;
	}
	public String getStoreDesc() {
		return storeDesc;
	}
	public void setStoreDesc(String storeDesc) {
		this.storeDesc = storeDesc;
	}
	
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public List<TmUsers> getTmUsers() {
		return tmUsers;
	}
	public void setTmUsers(List<TmUsers> tmUsers) {
		this.tmUsers = tmUsers;
	}
	public String getSelectedUser() {
		return selectedUser;
	}
	public void setSelectedUser(String selectedUser) {
		this.selectedUser = selectedUser;
	}
	public String getContact1() {
		return contact1;
	}
	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}
	public String getContact2() {
		return contact2;
	}
	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
