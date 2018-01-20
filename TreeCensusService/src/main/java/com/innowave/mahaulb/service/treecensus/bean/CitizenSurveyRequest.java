package com.innowave.mahaulb.service.treecensus.bean;

import java.io.Serializable;
import java.util.Date;

import com.innowave.mahaulb.common.service.beans.ApplicationBean;

public class CitizenSurveyRequest extends ApplicationBean implements Serializable {
	public static final long serialVersionUID = 1L;
	/*Location Details*/
	private String longitude;
	private String latitude;
	private int locId;
	private String locName;
	private int aprtId;
	private String aprtName;
	private int roadId;
	private String roadName;
	/*private String localityId;*/
	private String localityName;
	private int createdBy;
	private Date surveyDate;
	private Date createdDate;
	private String zoneName;
	private int zoneId;
	private String wardName;
	private int wardId;
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
	public int getLocId() {
		return locId;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}
	public String getLocName() {
		return locName;
	}
	public void setLocName(String locName) {
		this.locName = locName;
	}
	public int getAprtId() {
		return aprtId;
	}
	public void setAprtId(int aprtId) {
		this.aprtId = aprtId;
	}
	public String getAprtName() {
		return aprtName;
	}
	public void setAprtName(String aprtName) {
		this.aprtName = aprtName;
	}
	public int getRoadId() {
		return roadId;
	}
	public void setRoadId(int roadId) {
		this.roadId = roadId;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	public String getLocalityName() {
		return localityName;
	}
	public void setLocalityName(String localityName) {
		this.localityName = localityName;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
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
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public int getZoneId() {
		return zoneId;
	}
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}
	public String getWardName() {
		return wardName;
	}
	public void setWardName(String wardName) {
		this.wardName = wardName;
	}
	public int getWardId() {
		return wardId;
	}
	public void setWardId(int wardId) {
		this.wardId = wardId;
	}
	/*Location Columns*/	
}
