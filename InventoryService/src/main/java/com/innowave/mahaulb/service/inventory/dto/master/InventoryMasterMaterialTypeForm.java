package com.innowave.mahaulb.service.inventory.dto.master;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialType;

public class InventoryMasterMaterialTypeForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String materialTypeCode;
	public HashMap<Long, String> getSelectedParentType() {
		return selectedParentType;
	}

	public void setSelectedParentType(HashMap<Long, String> selectedParentType) {
		this.selectedParentType = selectedParentType;
	}

	private String materialTypeName;
	private String materialDesc;
	private HashMap<Long, String> selectedParentType;
	private boolean isActive;
	private boolean isParentType;
	private int ulbId;

	public String getMaterialTypeCode() {
		return materialTypeCode;
	}

	public void setMaterialTypeCode(String materialTypeCode) {
		this.materialTypeCode = materialTypeCode;
	}

	public String getMaterialTypeName() {
		return materialTypeName;
	}

	public void setMaterialTypeName(String materialTypeName) {
		this.materialTypeName = materialTypeName;
	}

	public String getMaterialDesc() {
		return materialDesc;
	}

	public void setMaterialDesc(String materialDesc) {
		this.materialDesc = materialDesc;
	}

	public boolean isParentType() {
		return isParentType;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setParentType(boolean isParentType) {
		this.isParentType = isParentType;
	}

	public int getUlbId() {
		return ulbId;
	}

	public void setUlbId(int ulbId) {
		this.ulbId = ulbId;
	}

}
