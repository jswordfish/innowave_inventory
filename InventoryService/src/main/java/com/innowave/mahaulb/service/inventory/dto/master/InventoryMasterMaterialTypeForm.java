package com.innowave.mahaulb.service.inventory.dto.master;

import java.io.Serializable;
import java.util.List;

import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialType;

public class InventoryMasterMaterialTypeForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String materialTypeCode;
	private String materialTypeName;
	private String materialDesc;
	private boolean isActive;
	private int  ulbId;
	private List<TmInvMaterialType> parentMaterialType;
	private List<String> parentMaterialTypeName;
	public List<String> getParentMaterialTypeName() {
		return parentMaterialTypeName;
	}

	public void setParentMaterialTypeName(List<String> parentMaterialTypeName) {
		this.parentMaterialTypeName = parentMaterialTypeName;
	}

	private boolean isParentType;

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

	public List<TmInvMaterialType> getParentMaterialType() {
		return parentMaterialType;
	}

	public void setParentMaterialType(List<TmInvMaterialType> parentMaterialType) {
		this.parentMaterialType = parentMaterialType;
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
