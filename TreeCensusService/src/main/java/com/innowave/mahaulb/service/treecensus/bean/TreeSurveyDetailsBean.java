package com.innowave.mahaulb.service.treecensus.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeNameMaster;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyUploadList;

public class TreeSurveyDetailsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int treeSurveyId;
	
	private int ulbId;
	private Character flagNewExisting;
	private Date surveyDate;
	private String treeSciNameEn;
	private String treeSciNameRg;
	private String treeVerNameEn;
	private String treeVerNameRg;
	private String treeComNameEn;
	private String treeComNameRg;
	private String treeFamNameEn;
	private String treeFamNameRg;
	private Integer lookupDetIdTsm;
	private Integer lookupDetIdLsm;
	private Integer lookupDetIdBsm;
	private Integer lookupDetIdTms;
	private Integer lookupDetIdLcm;
	private Integer lookupDetIdCom;
	private Integer lookupDetIdFnm;
	private Integer lookupDetIdFrm;
	private Integer lookupDetIdOdm;
	private Integer lookupDetIdSma;
	private Integer lookupDetIdTst;
	private Integer sizeValue;
	private Integer girthAtBreastHieght;
	private Integer hieght;
	private Integer approxAge;
	private Integer canopyWidth;
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
	private Set<TtTreeSurveyUploadList> ttTreeSurveyUploadLists = new HashSet<TtTreeSurveyUploadList>(0);
	
	private int lookupDetId;
	private String lookupDetName;
	private int lookupDetAesthetic;
	private int lookupDetCultural;
	private int lookupDetEcological;
	private int lookupDetEconomical;

	
	public int getTreeSurveyId() {
		return treeSurveyId;
	}
	public void setTreeSurveyId(int treeSurveyId) {
		this.treeSurveyId = treeSurveyId;
	}

	
	public String getTreeSciNameEn() {
		return treeSciNameEn;
	}
	public void setTreeSciNameEn(String treeSciNameEn) {
		this.treeSciNameEn = treeSciNameEn;
	}
	public String getTreeSciNameRg() {
		return treeSciNameRg;
	}
	public void setTreeSciNameRg(String treeSciNameRg) {
		this.treeSciNameRg = treeSciNameRg;
	}
	public String getTreeVerNameEn() {
		return treeVerNameEn;
	}
	public void setTreeVerNameEn(String treeVerNameEn) {
		this.treeVerNameEn = treeVerNameEn;
	}
	public String getTreeVerNameRg() {
		return treeVerNameRg;
	}
	public void setTreeVerNameRg(String treeVerNameRg) {
		this.treeVerNameRg = treeVerNameRg;
	}
	public String getTreeComNameEn() {
		return treeComNameEn;
	}
	public void setTreeComNameEn(String treeComNameEn) {
		this.treeComNameEn = treeComNameEn;
	}
	public String getTreeComNameRg() {
		return treeComNameRg;
	}
	public void setTreeComNameRg(String treeComNameRg) {
		this.treeComNameRg = treeComNameRg;
	}
	public String getTreeFamNameEn() {
		return treeFamNameEn;
	}
	public void setTreeFamNameEn(String treeFamNameEn) {
		this.treeFamNameEn = treeFamNameEn;
	}
	public String getTreeFamNameRg() {
		return treeFamNameRg;
	}
	public void setTreeFamNameRg(String treeFamNameRg) {
		this.treeFamNameRg = treeFamNameRg;
	}
	public int getUlbId() {
		return ulbId;
	}
	public void setUlbId(int ulbId) {
		this.ulbId = ulbId;
	}
	public Character getFlagNewExisting() {
		return flagNewExisting;
	}
	public void setFlagNewExisting(Character flagNewExisting) {
		this.flagNewExisting = flagNewExisting;
	}
	public Date getSurveyDate() {
		return surveyDate;
	}
	public void setSurveyDate(Date surveyDate) {
		this.surveyDate = surveyDate;
	}
	public Integer getLookupDetIdTsm() {
		return lookupDetIdTsm;
	}
	public void setLookupDetIdTsm(Integer lookupDetIdTsm) {
		this.lookupDetIdTsm = lookupDetIdTsm;
	}
	public Integer getLookupDetIdLsm() {
		return lookupDetIdLsm;
	}
	public void setLookupDetIdLsm(Integer lookupDetIdLsm) {
		this.lookupDetIdLsm = lookupDetIdLsm;
	}
	public Integer getLookupDetIdBsm() {
		return lookupDetIdBsm;
	}
	public void setLookupDetIdBsm(Integer lookupDetIdBsm) {
		this.lookupDetIdBsm = lookupDetIdBsm;
	}
	public Integer getLookupDetIdTms() {
		return lookupDetIdTms;
	}
	public void setLookupDetIdTms(Integer lookupDetIdTms) {
		this.lookupDetIdTms = lookupDetIdTms;
	}
	public Integer getLookupDetIdLcm() {
		return lookupDetIdLcm;
	}
	public void setLookupDetIdLcm(Integer lookupDetIdLcm) {
		this.lookupDetIdLcm = lookupDetIdLcm;
	}
	public Integer getLookupDetIdCom() {
		return lookupDetIdCom;
	}
	public void setLookupDetIdCom(Integer lookupDetIdCom) {
		this.lookupDetIdCom = lookupDetIdCom;
	}
	public Integer getLookupDetIdFnm() {
		return lookupDetIdFnm;
	}
	public void setLookupDetIdFnm(Integer lookupDetIdFnm) {
		this.lookupDetIdFnm = lookupDetIdFnm;
	}
	public Integer getLookupDetIdFrm() {
		return lookupDetIdFrm;
	}
	public void setLookupDetIdFrm(Integer lookupDetIdFrm) {
		this.lookupDetIdFrm = lookupDetIdFrm;
	}
	public Integer getLookupDetIdOdm() {
		return lookupDetIdOdm;
	}
	public void setLookupDetIdOdm(Integer lookupDetIdOdm) {
		this.lookupDetIdOdm = lookupDetIdOdm;
	}
	public Integer getLookupDetIdSma() {
		return lookupDetIdSma;
	}
	public void setLookupDetIdSma(Integer lookupDetIdSma) {
		this.lookupDetIdSma = lookupDetIdSma;
	}
	public Integer getLookupDetIdTst() {
		return lookupDetIdTst;
	}
	public void setLookupDetIdTst(Integer lookupDetIdTst) {
		this.lookupDetIdTst = lookupDetIdTst;
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
	public Integer getHieght() {
		return hieght;
	}
	public void setHieght(Integer hieght) {
		this.hieght = hieght;
	}
	public Integer getApproxAge() {
		return approxAge;
	}
	public void setApproxAge(Integer approxAge) {
		this.approxAge = approxAge;
	}
	public Integer getCanopyWidth() {
		return canopyWidth;
	}
	public void setCanopyWidth(Integer canopyWidth) {
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
	public Set<TtTreeSurveyUploadList> getTtTreeSurveyUploadLists() {
		return ttTreeSurveyUploadLists;
	}
	public void setTtTreeSurveyUploadLists(Set<TtTreeSurveyUploadList> ttTreeSurveyUploadLists) {
		this.ttTreeSurveyUploadLists = ttTreeSurveyUploadLists;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getLookupDetId() {
		return lookupDetId;
	}
	public void setLookupDetId(int lookupDetId) {
		this.lookupDetId = lookupDetId;
	}
	public String getLookupDetName() {
		return lookupDetName;
	}
	public void setLookupDetName(String lookupDetName) {
		this.lookupDetName = lookupDetName;
	}
	public int getLookupDetAesthetic() {
		return lookupDetAesthetic;
	}
	public void setLookupDetAesthetic(int lookupDetAesthetic) {
		this.lookupDetAesthetic = lookupDetAesthetic;
	}
	public int getLookupDetCultural() {
		return lookupDetCultural;
	}
	public void setLookupDetCultural(int lookupDetCultural) {
		this.lookupDetCultural = lookupDetCultural;
	}
	public int getLookupDetEcological() {
		return lookupDetEcological;
	}
	public void setLookupDetEcological(int lookupDetEcological) {
		this.lookupDetEcological = lookupDetEcological;
	}
	public int getLookupDetEconomical() {
		return lookupDetEconomical;
	}
	public void setLookupDetEconomical(int lookupDetEconomical) {
		this.lookupDetEconomical = lookupDetEconomical;
	}
	
}
