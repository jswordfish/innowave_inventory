package com.innowave.mahaulb.service.inventory.dto.master;

import java.io.Serializable;

public class MasterMaterialDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String materialCode;
	public int sequence;
	public String materialOldCode;
	public String materialType;
	public String materialName;
	public long materialId;
	public String getMaterialCode() {
		return materialCode;
	}
	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getMaterialOldCode() {
		return materialOldCode;
	}
	public void setMaterialOldCode(String materialOldCode) {
		this.materialOldCode = materialOldCode;
	}
	public String getMaterialType() {
		return materialType;
	}
	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public long getMaterialId() {
		return materialId;
	}
	public void setMaterialId(long materialId) {
		this.materialId = materialId;
	}
	
	

}
