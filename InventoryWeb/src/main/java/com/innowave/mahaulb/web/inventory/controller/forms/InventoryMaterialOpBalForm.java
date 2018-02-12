package com.innowave.mahaulb.web.inventory.controller.forms;

import java.util.ArrayList;
import java.util.List;

import com.innowave.mahaulb.repository.inventory.dao.trans.TtInvMaterialOpbal;

public class InventoryMaterialOpBalForm {
	private Long storeId = -1l;
	 
	private Long materialId = -1l;
	  
	  
	List<TtInvMaterialOpbalWrapper> balances = new ArrayList<>();
	
	TtInvMaterialOpbal current;

	String finyear;

	

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}

	public List<TtInvMaterialOpbalWrapper> getBalances() {
		return balances;
	}

	public void setBalances(List<TtInvMaterialOpbalWrapper> balances) {
		this.balances = balances;
	}

	public TtInvMaterialOpbal getCurrent() {
		return current;
	}

	public void setCurrent(TtInvMaterialOpbal current) {
		this.current = current;
	}

	public String getFinyear() {
		return finyear;
	}

	public void setFinyear(String finyear) {
		this.finyear = finyear;
	}
	  
	  
	  
}
