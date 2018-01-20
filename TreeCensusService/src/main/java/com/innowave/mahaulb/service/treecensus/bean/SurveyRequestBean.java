package com.innowave.mahaulb.service.treecensus.bean;

import java.io.Serializable;
import java.util.Date;

public class SurveyRequestBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5749127490340631481L;
	
	private int serviceId;
	private int ulbId;
	private String ulbCode;
	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public String getUlbCode() {
		return ulbCode;
	}

	public void setUlbCode(String ulbCode) {
		this.ulbCode = ulbCode;
	}

	private String organisationName;
	private String organisationAddress;
	private String applicantUid;
	private Integer lookupDetIdTitle;
	private String applicantFirstName;
	private String applicantMiddName;
	private String applicantLastName;
	private String applicantName;
	private String applicantContactPerson;
	private String applicantAddress;
	private String applicantMobile;
	private String applicantEmail;
	private String aadharNo;
	
	/*Location Details*/
	private String longitude;
	private String latitude;
	private String locationId;
	private int LocName;
	private String apartmentId;
	private int AprtName;
	private String roadId;
	private int RoadName;
	private String localityId;
	private int LocalityName;
	private int createdBy;
	private Date surveyDate;
	private Date createdDate;
	private int zoneName;
	private String zoneId;
	private int wardName;
	private String wardId;

	public Date getSurveyDate() {
		return surveyDate;
	}

	public void setSurveyDate(Date surveyDate) {
		this.surveyDate = surveyDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getAadharNo() {
		return aadharNo;
	}
	
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	private Integer lookupDetIdApplicatType;

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public int getUlbId() {
		return ulbId;
	}

	public void setUlbId(int ulbId) {
		this.ulbId = ulbId;
	}

	public String getOrganisationName() {
		return organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	public String getOrganisationAddress() {
		return organisationAddress;
	}

	public void setOrganisationAddress(String organisationAddress) {
		this.organisationAddress = organisationAddress;
	}

	public String getApplicantUid() {
		return applicantUid;
	}

	public void setApplicantUid(String applicantUid) {
		this.applicantUid = applicantUid;
	}

	public Integer getLookupDetIdTitle() {
		return lookupDetIdTitle;
	}

	public void setLookupDetIdTitle(Integer lookupDetIdTitle) {
		this.lookupDetIdTitle = lookupDetIdTitle;
	}

	public String getApplicantFirstName() {
		return applicantFirstName;
	}

	public void setApplicantFirstName(String applicantFirstName) {
		this.applicantFirstName = applicantFirstName;
	}

	public String getApplicantMiddName() {
		return applicantMiddName;
	}

	public void setApplicantMiddName(String applicantMiddName) {
		this.applicantMiddName = applicantMiddName;
	}

	public String getApplicantLastName() {
		return applicantLastName;
	}

	public void setApplicantLastName(String applicantLastName) {
		this.applicantLastName = applicantLastName;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicantContactPerson() {
		return applicantContactPerson;
	}

	public void setApplicantContactPerson(String applicantContactPerson) {
		this.applicantContactPerson = applicantContactPerson;
	}

	public String getApplicantAddress() {
		return applicantAddress;
	}

	public void setApplicantAddress(String applicantAddress) {
		this.applicantAddress = applicantAddress;
	}

	public String getApplicantMobile() {
		return applicantMobile;
	}

	public void setApplicantMobile(String applicantMobile) {
		this.applicantMobile = applicantMobile;
	}

	public String getApplicantEmail() {
		return applicantEmail;
	}

	public void setApplicantEmail(String applicantEmail) {
		this.applicantEmail = applicantEmail;
	}

	public Integer getLookupDetIdApplicatType() {
		return lookupDetIdApplicatType;
	}

	public void setLookupDetIdApplicatType(Integer lookupDetIdApplicatType) {
		this.lookupDetIdApplicatType = lookupDetIdApplicatType;
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

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public int getLocName() {
		return LocName;
	}

	public void setLocName(int locName) {
		LocName = locName;
	}

	public String getApartmentId() {
		return apartmentId;
	}

	public void setApartmentId(String apartmentId) {
		this.apartmentId = apartmentId;
	}

	public int getAprtName() {
		return AprtName;
	}

	public void setAprtName(int aprtName) {
		AprtName = aprtName;
	}

	public String getRoadId() {
		return roadId;
	}

	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}

	public int getRoadName() {
		return RoadName;
	}

	public void setRoadName(int roadName) {
		RoadName = roadName;
	}

	public String getLocalityId() {
		return localityId;
	}

	public void setLocalityId(String localityId) {
		this.localityId = localityId;
	}

	public int getLocalityName() {
		return LocalityName;
	}

	public void setLocalityName(int localityName) {
		LocalityName = localityName;
	}

	public int getZoneName() {
		return zoneName;
	}

	public void setZoneName(int zoneName) {
		this.zoneName = zoneName;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public int getWardName() {
		return wardName;
	}

	public void setWardName(int wardName) {
		this.wardName = wardName;
	}

	public String getWardId() {
		return wardId;
	}

	public void setWardId(String wardId) {
		this.wardId = wardId;
	}
	/*Location Columns*/	

}
