package com.innowave.mahaulb.repository.inventory.dao.trans;
// Generated Jan 31, 2018 2:32:46 PM  

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
import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;

/**
 * TtInvIndent  
 */
@Entity
@Table(name = "tt_inv_indent", schema = "inventory")
public class TtInvIndent implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3837860023025493008L;
	private long indentId;
	private TmCmLookupDet tmCmLookupDetByLookupDetIdIndentStatus;
	private TmCmLookupDet tmCmLookupDetByLookupDetIdApprovalIndentStatus;
	private TmUlb tmUlb;
	private TmInvStore tmInvStore;
	private String indentNo;
	private Date indentDate;
	private String storeCode;
	private Integer raisedBy;
	private String purpose;
	private String remark;
	private Integer approvedBy;
	private Date approvalDate;
	private String approvalRemark;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;
	private Set<TtInvIndentDet> ttInvIndentDets = new HashSet<TtInvIndentDet>(0);
	private Set<TtInvMatIssue> ttInvMatIssues = new HashSet<TtInvMatIssue>(0);

	public TtInvIndent() {
	}

	public TtInvIndent(long indentId, TmUlb tmUlb, TmInvStore tmInvStore, String indentNo, Date indentDate,
			String storeCode, String approvalRemark, Date createdDate) {
		this.indentId = indentId;
		this.tmUlb = tmUlb;
		this.tmInvStore = tmInvStore;
		this.indentNo = indentNo;
		this.indentDate = indentDate;
		this.storeCode = storeCode;
		this.approvalRemark = approvalRemark;
		this.createdDate = createdDate;
	}

	public TtInvIndent(long indentId, TmCmLookupDet tmCmLookupDetByLookupDetIdIndentStatus,
			TmCmLookupDet tmCmLookupDetByLookupDetIdApprovalIndentStatus, TmUlb tmUlb, TmInvStore tmInvStore,
			String indentNo, Date indentDate, String storeCode, Integer raisedBy, String purpose, String remark,
			Integer approvedBy, Date approvalDate, String approvalRemark, Integer createdBy, Date createdDate,
			Integer updatedBy, Date updatedDate, String macId, String ipAddress, String deviceFrom,
			Set<TtInvIndentDet> ttInvIndentDets, Set<TtInvMatIssue> ttInvMatIssues) {
		this.indentId = indentId;
		this.tmCmLookupDetByLookupDetIdIndentStatus = tmCmLookupDetByLookupDetIdIndentStatus;
		this.tmCmLookupDetByLookupDetIdApprovalIndentStatus = tmCmLookupDetByLookupDetIdApprovalIndentStatus;
		this.tmUlb = tmUlb;
		this.tmInvStore = tmInvStore;
		this.indentNo = indentNo;
		this.indentDate = indentDate;
		this.storeCode = storeCode;
		this.raisedBy = raisedBy;
		this.purpose = purpose;
		this.remark = remark;
		this.approvedBy = approvedBy;
		this.approvalDate = approvalDate;
		this.approvalRemark = approvalRemark;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
		this.ttInvIndentDets = ttInvIndentDets;
		this.ttInvMatIssues = ttInvMatIssues;
	}

	@Id

	@Column(name = "indent_id", unique = true, nullable = false)
	public long getIndentId() {
		return this.indentId;
	}

	public void setIndentId(long indentId) {
		this.indentId = indentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lookup_det_id_indent_status")
	public TmCmLookupDet getTmCmLookupDetByLookupDetIdIndentStatus() {
		return this.tmCmLookupDetByLookupDetIdIndentStatus;
	}

	public void setTmCmLookupDetByLookupDetIdIndentStatus(TmCmLookupDet tmCmLookupDetByLookupDetIdIndentStatus) {
		this.tmCmLookupDetByLookupDetIdIndentStatus = tmCmLookupDetByLookupDetIdIndentStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lookup_det_id_approval_indent_status")
	public TmCmLookupDet getTmCmLookupDetByLookupDetIdApprovalIndentStatus() {
		return this.tmCmLookupDetByLookupDetIdApprovalIndentStatus;
	}

	public void setTmCmLookupDetByLookupDetIdApprovalIndentStatus(
			TmCmLookupDet tmCmLookupDetByLookupDetIdApprovalIndentStatus) {
		this.tmCmLookupDetByLookupDetIdApprovalIndentStatus = tmCmLookupDetByLookupDetIdApprovalIndentStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ulb_id", nullable = false)
	public TmUlb getTmUlb() {
		return this.tmUlb;
	}

	public void setTmUlb(TmUlb tmUlb) {
		this.tmUlb = tmUlb;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id", nullable = false)
	public TmInvStore getTmInvStore() {
		return this.tmInvStore;
	}

	public void setTmInvStore(TmInvStore tmInvStore) {
		this.tmInvStore = tmInvStore;
	}

	@Column(name = "indent_no", nullable = false, length = 50)
	public String getIndentNo() {
		return this.indentNo;
	}

	public void setIndentNo(String indentNo) {
		this.indentNo = indentNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "indent_date", nullable = false, length = 13)
	public Date getIndentDate() {
		return this.indentDate;
	}

	public void setIndentDate(Date indentDate) {
		this.indentDate = indentDate;
	}

	@Column(name = "store_code", nullable = false, length = 20)
	public String getStoreCode() {
		return this.storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	@Column(name = "raised_by")
	public Integer getRaisedBy() {
		return this.raisedBy;
	}

	public void setRaisedBy(Integer raisedBy) {
		this.raisedBy = raisedBy;
	}

	@Column(name = "purpose", length = 2000)
	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Column(name = "remark", length = 2000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "approved_by")
	public Integer getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(Integer approvedBy) {
		this.approvedBy = approvedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "approval_date", length = 13)
	public Date getApprovalDate() {
		return this.approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	@Column(name = "approval_remark", nullable = false, length = 2000)
	public String getApprovalRemark() {
		return this.approvalRemark;
	}

	public void setApprovalRemark(String approvalRemark) {
		this.approvalRemark = approvalRemark;
	}

	@Column(name = "created_by")
	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 29)
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
	public String getDeviceFrom() {
		return this.deviceFrom;
	}

	public void setDeviceFrom(String deviceFrom) {
		this.deviceFrom = deviceFrom;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ttInvIndent")
	public Set<TtInvIndentDet> getTtInvIndentDets() {
		return this.ttInvIndentDets;
	}

	public void setTtInvIndentDets(Set<TtInvIndentDet> ttInvIndentDets) {
		this.ttInvIndentDets = ttInvIndentDets;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ttInvIndent")
	public Set<TtInvMatIssue> getTtInvMatIssues() {
		return this.ttInvMatIssues;
	}

	public void setTtInvMatIssues(Set<TtInvMatIssue> ttInvMatIssues) {
		this.ttInvMatIssues = ttInvMatIssues;
	}

}
