package com.innowave.mahaulb.repository.treecensus.dao.master;
// Generated Nov 14, 2017 12:25:32 PM  

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;

/**
 * TmTreeAuthorityMaster  
 */
@Entity
@Table(name = "tm_tree_authority_master", schema = "treecensus")
public class TmTreeAuthorityMaster implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5790357457083419701L;
	private int authorityId;
	private TmCmLookupDet tmCmLookupDet;
	private int ulbId;
	private Serializable aadharNumber;
	private Serializable authorityName;
	private String presentAddress;
	private Serializable mobileNo;
	private Serializable emailId;
	private Integer authorityStatus;
	private int createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private Character deviceFrom;
	private Set<TtTreeSurveyDetails> ttTreeSurveyDetailses = new HashSet<TtTreeSurveyDetails>(0);

	public TmTreeAuthorityMaster() {
	}

	public TmTreeAuthorityMaster(int authorityId, int ulbId, Serializable aadharNumber, Serializable authorityName,
			int createdBy) {
		this.authorityId = authorityId;
		this.ulbId = ulbId;
		this.aadharNumber = aadharNumber;
		this.authorityName = authorityName;
		this.createdBy = createdBy;
	}

	public TmTreeAuthorityMaster(int authorityId, TmCmLookupDet tmCmLookupDet, int ulbId, Serializable aadharNumber,
			Serializable authorityName, String presentAddress, Serializable mobileNo, Serializable emailId,
			Integer authorityStatus, int createdBy, Date createdDate, Integer updatedBy, Date updatedDate, String macId,
			String ipAddress, Character deviceFrom, Set<TtTreeSurveyDetails> ttTreeSurveyDetailses) {
		this.authorityId = authorityId;
		this.tmCmLookupDet = tmCmLookupDet;
		this.ulbId = ulbId;
		this.aadharNumber = aadharNumber;
		this.authorityName = authorityName;
		this.presentAddress = presentAddress;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.authorityStatus = authorityStatus;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
		this.ttTreeSurveyDetailses = ttTreeSurveyDetailses;
	}

	@Id

	@Column(name = "authority_id", unique = true, nullable = false)
	public int getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lookup_det_id_desig")
	public TmCmLookupDet getTmCmLookupDet() {
		return this.tmCmLookupDet;
	}

	public void setTmCmLookupDet(TmCmLookupDet tmCmLookupDet) {
		this.tmCmLookupDet = tmCmLookupDet;
	}

	@Column(name = "ulb_id", nullable = false)
	public int getUlbId() {
		return this.ulbId;
	}

	public void setUlbId(int ulbId) {
		this.ulbId = ulbId;
	}

	@Column(name = "aadhar_number", nullable = false)
	public Serializable getAadharNumber() {
		return this.aadharNumber;
	}

	public void setAadharNumber(Serializable aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	@Column(name = "authority_name", nullable = false)
	public Serializable getAuthorityName() {
		return this.authorityName;
	}

	public void setAuthorityName(Serializable authorityName) {
		this.authorityName = authorityName;
	}

	@Column(name = "present_address")
	public String getPresentAddress() {
		return this.presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	@Column(name = "mobile_no")
	public Serializable getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(Serializable mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Column(name = "email_id")
	public Serializable getEmailId() {
		return this.emailId;
	}

	public void setEmailId(Serializable emailId) {
		this.emailId = emailId;
	}

	@Column(name = "authority_status")
	public Integer getAuthorityStatus() {
		return this.authorityStatus;
	}

	public void setAuthorityStatus(Integer authorityStatus) {
		this.authorityStatus = authorityStatus;
	}

	@Column(name = "created_by", nullable = false)
	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", length = 29)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "updated_by")
	public Integer getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", length = 29)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "mac_id", length = 50)
	public String getMacId() {
		return this.macId;
	}

	public void setMacId(String macId) {
		this.macId = macId;
	}

	@Column(name = "ip_address", length = 50)
	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Column(name = "device_from", length = 1)
	public Character getDeviceFrom() {
		return this.deviceFrom;
	}

	public void setDeviceFrom(Character deviceFrom) {
		this.deviceFrom = deviceFrom;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tmTreeAuthorityMaster")
	public Set<TtTreeSurveyDetails> getTtTreeSurveyDetailses() {
		return this.ttTreeSurveyDetailses;
	}

	public void setTtTreeSurveyDetailses(Set<TtTreeSurveyDetails> ttTreeSurveyDetailses) {
		this.ttTreeSurveyDetailses = ttTreeSurveyDetailses;
	}

}
