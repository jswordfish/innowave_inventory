package com.innowave.mahaulb.service.treecensus.dto.reports;

import java.io.Serializable;

public class ReportFilterDto  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	String fromDate;
	String toDate;
	String surveyNm;
	String surveyDt;
	String treeSpecies;
	String treeFamily;
	String treeWard;
	String treeZone;
	String societyNm;
	String mseb_ctcNo;
	String propOwnerNo;
	String treeScientificNm; 
	String treeVernacularNm;
	String treeCommonNm;
	String locationNm;
	String treeLocation;
	String treeCity;
	int treeCityNm;
	String schemeName;
	int finYear;
	private int ulbId;
	private int lookupDetIdTsm;
	private int treespeciesId;
	private int treenameId;
	private int vernaId;
	private int treeCommonId;
	private int treeFamilyId;
	private int scientificId;
	private int aprtName;
	private int locationId;
	private int treeWardId;
	private int schemeNum;
	
	
	public String getLocationNm() {
		return locationNm;
	}
	public void setLocationNm(String locationNm) {
		this.locationNm = locationNm;
	}
	public int getTreeCityNm() {
		return treeCityNm;
	}
	public void setTreeCityNm(int treeCityNm) {
		this.treeCityNm = treeCityNm;
	}
	public int getTreeWardId() {
		return treeWardId;
	}
	public void setTreeWardId(int treeWardId) {
		this.treeWardId = treeWardId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public int getAprtName() {
		return aprtName;
	}
	public void setAprtName(int aprtName) {
		this.aprtName = aprtName;
	}
	public int getScientificId() {
		return scientificId;
	}
	public void setScientificId(int scientificId) {
		this.scientificId = scientificId;
	}
	public int getTreeFamilyId() {
		return treeFamilyId;
	}
	public void setTreeFamilyId(int treeFamilyId) {
		this.treeFamilyId = treeFamilyId;
	}
	public int getTreeCommonId() {
		return treeCommonId;
	}
	public void setTreeCommonId(int treeCommonId) {
		this.treeCommonId = treeCommonId;
	}
	
	public int getVernaId() {
		return vernaId;
	}
	public void setVernaId(int vernaId) {
		this.vernaId = vernaId;
	}
	
	public int getTreenameId() {
		return treenameId;
	}
	public void setTreenameId(int treenameId) {
		this.treenameId = treenameId;
	}
	public int getTreespeciesId() {
		return treespeciesId;
	}
	public void setTreespeciesId(int treespeciesId) {
		this.treespeciesId = treespeciesId;
	}
	
	public int getLookupDetIdTsm() {
		return lookupDetIdTsm;
	}
	public void setLookupDetIdTsm(int lookupDetIdTsm) {
		this.lookupDetIdTsm = lookupDetIdTsm;
	}
	
	public int getUlbId() {
		return ulbId;
	}
	public void setUlbId(int ulbId) {
		this.ulbId = ulbId;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getSurveyNm() {
		return surveyNm;
	}
	public void setSurveyNm(String surveyNm) {
		this.surveyNm = surveyNm;
	}
	public String getSurveyDt() {
		return surveyDt;
	}
	public void setSurveyDt(String surveyDt) {
		this.surveyDt = surveyDt;
	}
	public String getTreeSpecies() {
		return treeSpecies;
	}
	public void setTreeSpecies(String treeSpecies) {
		this.treeSpecies = treeSpecies;
	}
	public String getTreeFamily() {
		return treeFamily;
	}
	public void setTreeFamily(String treeFamily) {
		this.treeFamily = treeFamily;
	}
	public String getTreeWard() {
		return treeWard;
	}
	public void setTreeWard(String treeWard) {
		this.treeWard = treeWard;
	}
	public String getTreeZone() {
		return treeZone;
	}
	public void setTreeZone(String treeZone) {
		this.treeZone = treeZone;
	}
	public String getSocietyNm() {
		return societyNm;
	}
	public void setSocietyNm(String societyNm) {
		this.societyNm = societyNm;
	}
	public String getMseb_ctcNo() {
		return mseb_ctcNo;
	}
	public void setMseb_ctcNo(String mseb_ctcNo) {
		this.mseb_ctcNo = mseb_ctcNo;
	}
	public String getPropOwnerNo() {
		return propOwnerNo;
	}
	public void setPropOwnerNo(String propOwnerNo) {
		this.propOwnerNo = propOwnerNo;
	}
	public String getTreeScientificNm() {
		return treeScientificNm;
	}
	public void setTreeScientificNm(String treeScientificNm) {
		this.treeScientificNm = treeScientificNm;
	}
	public String getTreeVernacularNm() {
		return treeVernacularNm;
	}
	public void setTreeVernacularNm(String treeVernacularNm) {
		this.treeVernacularNm = treeVernacularNm;
	}
	public String getTreeCommonNm() {
		return treeCommonNm;
	}
	public void setTreeCommonNm(String treeCommonNm) {
		this.treeCommonNm = treeCommonNm;
	}
	
	public String getTreeLocation() {
		return treeLocation;
	}
	public void setTreeLocation(String treeLocation) {
		this.treeLocation = treeLocation;
	}
	public String getTreeCity() {
		return treeCity;
	}
	public void setTreeCity(String treeCity) {
		this.treeCity = treeCity;
	}
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	public int getSchemeNum() {
		return schemeNum;
	}
	public void setSchemeNum(int schemeNum) {
		this.schemeNum = schemeNum;
	}
	public int getFinYear() {
		return finYear;
	}
	public void setFinYear(int finYear) {
		this.finYear = finYear;
	}
}
