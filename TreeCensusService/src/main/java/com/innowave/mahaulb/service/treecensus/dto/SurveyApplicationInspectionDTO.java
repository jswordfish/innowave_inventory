package com.innowave.mahaulb.service.treecensus.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SurveyApplicationInspectionDTO implements java.io.Serializable {
	private long srnId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm a", with = JsonFormat.Feature.WRITE_DATES_WITH_ZONE_ID)
	private Date surveyDate;
	private Integer treeNameId;
	private Integer sizeValue;
	private Integer girthAtBreastHieght;
	private Integer treemasIdTsm;
	private Integer treemasIdLsm;
	private Integer treemasIdBsm;
	private Integer treemasIdTms;
	private Integer treemasIdLcm;
	private Integer treemasIdCom;
	private Integer treemasIdFnm;
	private Integer treemasIdFrm;
	private Integer treemasIdOdm;
	private Integer treemasIdSma;
	private Integer treemasIdTst;
	private Double hieght;
	private Integer approxAge;
	private Double canopyWidth;
	private String msebCtcNo;
	private String location;
	private String apartmentComplex;
	private String road;
	private String building;
	private String locality;
	private String longitude;
	private String latitude;
	private String observationRemarks;
	private String ownerAadharCard;
	private String ownerName;
	private String ownerAddress;
	private Character approveFlag;
	private String approveRemark;
	private Integer status;
	private int createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private Character deviceFrom;
	private Date approvalDate;
	private String surveyNumber;
	private String treeIdentificationNo;
	private Character portDataFlag;
	private Integer inspectedByUserId;
	private Date inspectedOnDate;
	
	
	
	public Integer getTreeNameId() {
		return treeNameId;
	}
	public void setTreeNameId(Integer treeNameId) {
		this.treeNameId = treeNameId;
	}
	public Integer getTreemasIdTsm() {
		return treemasIdTsm;
	}
	public void setTreemasIdTsm(Integer treemasIdTsm) {
		this.treemasIdTsm = treemasIdTsm;
	}
	public Integer getTreemasIdLsm() {
		return treemasIdLsm;
	}
	public void setTreemasIdLsm(Integer treemasIdLsm) {
		this.treemasIdLsm = treemasIdLsm;
	}
	public Integer getTreemasIdBsm() {
		return treemasIdBsm;
	}
	public void setTreemasIdBsm(Integer treemasIdBsm) {
		this.treemasIdBsm = treemasIdBsm;
	}
	public Integer getTreemasIdTms() {
		return treemasIdTms;
	}
	public void setTreemasIdTms(Integer treemasIdTms) {
		this.treemasIdTms = treemasIdTms;
	}
	public Integer getTreemasIdLcm() {
		return treemasIdLcm;
	}
	public void setTreemasIdLcm(Integer treemasIdLcm) {
		this.treemasIdLcm = treemasIdLcm;
	}
	public Integer getTreemasIdCom() {
		return treemasIdCom;
	}
	public void setTreemasIdCom(Integer treemasIdCom) {
		this.treemasIdCom = treemasIdCom;
	}
	public Integer getTreemasIdFnm() {
		return treemasIdFnm;
	}
	public void setTreemasIdFnm(Integer treemasIdFnm) {
		this.treemasIdFnm = treemasIdFnm;
	}
	public Integer getTreemasIdFrm() {
		return treemasIdFrm;
	}
	public void setTreemasIdFrm(Integer treemasIdFrm) {
		this.treemasIdFrm = treemasIdFrm;
	}
	public Integer getTreemasIdOdm() {
		return treemasIdOdm;
	}
	public void setTreemasIdOdm(Integer treemasIdOdm) {
		this.treemasIdOdm = treemasIdOdm;
	}
	public Integer getTreemasIdSma() {
		return treemasIdSma;
	}
	public void setTreemasIdSma(Integer treemasIdSma) {
		this.treemasIdSma = treemasIdSma;
	}
	public Integer getTreemasIdTst() {
		return treemasIdTst;
	}
	public void setTreemasIdTst(Integer treemasIdTst) {
		this.treemasIdTst = treemasIdTst;
	}
	public SurveyApplicationInspectionDTO() {
		super();
	}
	public long getSrnId() {
		return srnId;
	}
	public void setSrnId(long srnId) {
		this.srnId = srnId;
	}
	public Date getSurveyDate() {
		return surveyDate;
	}
	public void setSurveyDate(Date surveyDate) {
		this.surveyDate = surveyDate;
	}
	public Integer getSizeValue() {
		return sizeValue;
	}
	public void setSizeValue(Integer sizeValue) {
		this.sizeValue = sizeValue;
	}
	public Integer getGirthAtBreastHieght() {
		return girthAtBreastHieght;
	}
	public void setGirthAtBreastHieght(Integer girthAtBreastHieght) {
		this.girthAtBreastHieght = girthAtBreastHieght;
	}
	public Double getHieght() {
		return hieght;
	}
	public void setHieght(Double hieght) {
		this.hieght = hieght;
	}
	public Integer getApproxAge() {
		return approxAge;
	}
	public void setApproxAge(Integer approxAge) {
		this.approxAge = approxAge;
	}
	public Double getCanopyWidth() {
		return canopyWidth;
	}
	public void setCanopyWidth(Double canopyWidth) {
		this.canopyWidth = canopyWidth;
	}
	public String getMsebCtcNo() {
		return msebCtcNo;
	}
	public void setMsebCtcNo(String msebCtcNo) {
		this.msebCtcNo = msebCtcNo;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getApartmentComplex() {
		return apartmentComplex;
	}
	public void setApartmentComplex(String apartmentComplex) {
		this.apartmentComplex = apartmentComplex;
	}
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getObservationRemarks() {
		return observationRemarks;
	}
	public void setObservationRemarks(String observationRemarks) {
		this.observationRemarks = observationRemarks;
	}
	public String getOwnerAadharCard() {
		return ownerAadharCard;
	}
	public void setOwnerAadharCard(String ownerAadharCard) {
		this.ownerAadharCard = ownerAadharCard;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerAddress() {
		return ownerAddress;
	}
	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}
	public Character getApproveFlag() {
		return approveFlag;
	}
	public void setApproveFlag(Character approveFlag) {
		this.approveFlag = approveFlag;
	}
	public String getApproveRemark() {
		return approveRemark;
	}
	public void setApproveRemark(String approveRemark) {
		this.approveRemark = approveRemark;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
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
	public Character getDeviceFrom() {
		return deviceFrom;
	}
	public void setDeviceFrom(Character deviceFrom) {
		this.deviceFrom = deviceFrom;
	}
	public Date getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}
	public String getSurveyNumber() {
		return surveyNumber;
	}
	public void setSurveyNumber(String surveyNumber) {
		this.surveyNumber = surveyNumber;
	}
	public String getTreeIdentificationNo() {
		return treeIdentificationNo;
	}
	public void setTreeIdentificationNo(String treeIdentificationNo) {
		this.treeIdentificationNo = treeIdentificationNo;
	}
	public Character getPortDataFlag() {
		return portDataFlag;
	}
	public void setPortDataFlag(Character portDataFlag) {
		this.portDataFlag = portDataFlag;
	}
	public Integer getInspectedByUserId() {
		return inspectedByUserId;
	}
	public void setInspectedByUserId(Integer inspectedByUserId) {
		this.inspectedByUserId = inspectedByUserId;
	}
	public Date getInspectedOnDate() {
		return inspectedOnDate;
	}
	public void setInspectedOnDate(Date inspectedOnDate) {
		this.inspectedOnDate = inspectedOnDate;
	}
	
	

}
