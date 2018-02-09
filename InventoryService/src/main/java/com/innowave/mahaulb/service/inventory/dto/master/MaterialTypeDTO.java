package com.innowave.mahaulb.service.inventory.dto.master;

import java.sql.Timestamp;

public class MaterialTypeDTO implements java.io.Serializable{

	private Integer ulb;
	private Long materialTypeId;

	public Long getMaterialTypeId() {
		return materialTypeId;
	}

	public void setMaterialTypeId(Long materialTypeId) {
		this.materialTypeId = materialTypeId;
	}

	private Integer serial;

	public Integer getSerial() {
		return serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	private String materialTypCode;
	private String materialTypeName;

	public MaterialTypeDTO getParentMaterialType() {
		return parentMaterialType;
	}

	public void setParentMaterialType(MaterialTypeDTO parentMaterialType) {
		this.parentMaterialType = parentMaterialType;
	}

	private String materialTypeDesc;
	private String parentTypeYN;
	private MaterialTypeDTO parentMaterialType;;
	private Integer parentMatetrialTypId;
	private String status;
	private String createdBy;
	private String updatedBy;
	private Timestamp createdDate;
	private Timestamp updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;

	public Integer getUlb() {
		return ulb;
	}

	public void setUlb(Integer ulb) {
		this.ulb = ulb;
	}

	public String getMaterialTypCode() {
		return materialTypCode;
	}

	public void setMaterialTypCode(String materialTypCode) {
		this.materialTypCode = materialTypCode;
	}

	public String getMaterialTypeName() {
		return materialTypeName;
	}

	public void setMaterialTypeName(String materialTypeName) {
		this.materialTypeName = materialTypeName;
	}

	public String getMaterialTypeDesc() {
		return materialTypeDesc;
	}

	public void setMaterialTypeDesc(String materialTypeDesc) {
		this.materialTypeDesc = materialTypeDesc;
	}

	public String getParentTypeYN() {
		return parentTypeYN;
	}

	public void setParentTypeYN(String parentTypeYN) {
		this.parentTypeYN = parentTypeYN;
	}

	public Integer getParentMatetrialTypId() {
		return parentMatetrialTypId;
	}

	public void setParentMatetrialTypId(Integer parentMatetrialTypId) {
		this.parentMatetrialTypId = parentMatetrialTypId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getMacId() {
		return macId;
	}

	public void setMacId(String macId) {
		this.macId = macId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getDeviceFrom() {
		return deviceFrom;
	}

	public void setDeviceFrom(String deviceFrom) {
		this.deviceFrom = deviceFrom;
	}

}
