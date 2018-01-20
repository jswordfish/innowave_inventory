package com.innowave.mahaulb.repository.treecensus.dao.trans;
// Generated Sep 22, 2017 3:57:42 PM  

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TtTreeSurveyUploadList  
 */
@Entity
@Table(name = "tt_tree_survey_upload_list", schema = "treecensus")
public class TtTreeSurveyUploadList implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int treeSurveyUploadId;
	private TtTreeSurveyDetails ttTreeSurveyDetails;
	private int ulbId;
	private String uploadedDesc;
	private Integer status;
	private int createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private Character deviceFrom;

	public TtTreeSurveyUploadList() {
	}

	public TtTreeSurveyUploadList(int treeSurveyUploadId, int ulbId, int createdBy) {
		this.treeSurveyUploadId = treeSurveyUploadId;
		this.ulbId = ulbId;
		this.createdBy = createdBy;
	}

	public TtTreeSurveyUploadList(int treeSurveyUploadId, TtTreeSurveyDetails ttTreeSurveyDetails, int ulbId,
			String uploadedDesc, Integer status, int createdBy, Date createdDate, Integer updatedBy, Date updatedDate,
			String macId, String ipAddress, Character deviceFrom) {
		this.treeSurveyUploadId = treeSurveyUploadId;
		this.ttTreeSurveyDetails = ttTreeSurveyDetails;
		this.ulbId = ulbId;
		this.uploadedDesc = uploadedDesc;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
	}

	@Id

	@Column(name = "tree_survey_upload_id", unique = true, nullable = false)
	public int getTreeSurveyUploadId() {
		return this.treeSurveyUploadId;
	}

	public void setTreeSurveyUploadId(int treeSurveyUploadId) {
		this.treeSurveyUploadId = treeSurveyUploadId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tree_survey_id")
	public TtTreeSurveyDetails getTtTreeSurveyDetails() {
		return this.ttTreeSurveyDetails;
	}

	public void setTtTreeSurveyDetails(TtTreeSurveyDetails ttTreeSurveyDetails) {
		this.ttTreeSurveyDetails = ttTreeSurveyDetails;
	}

	@Column(name = "ulb_id", nullable = false)
	public int getUlbId() {
		return this.ulbId;
	}

	public void setUlbId(int ulbId) {
		this.ulbId = ulbId;
	}

	@Column(name = "uploaded_desc", length = 200)
	public String getUploadedDesc() {
		return this.uploadedDesc;
	}

	public void setUploadedDesc(String uploadedDesc) {
		this.uploadedDesc = uploadedDesc;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

}
