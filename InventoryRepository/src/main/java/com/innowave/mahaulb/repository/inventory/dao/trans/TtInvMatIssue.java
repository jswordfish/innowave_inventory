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

import com.innowave.mahaulb.common.dao.TmUlb;

/**
 * TtInvMatIssue 
 */
@Entity
@Table(name = "tt_inv_mat_issue", schema = "inventory")
public class TtInvMatIssue implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4101585845774193206L;
	private long matIssueId;
	private TmUlb tmUlb;
	private TtInvIndent ttInvIndent;
	private String issueNo;
	private Date issueDate;
	private String indentNo;
	private Date indentDate;
	private Long depId;
	private Integer indentEmpid;
	private Integer indentEmpDesigId;
	private Integer issuedByEmpid;
	private Integer issuedToEmpid;
	private String remarks;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;
	private Set<TtInvMatIssueDet> ttInvMatIssueDets = new HashSet<TtInvMatIssueDet>(0);

	public TtInvMatIssue() {
	}

	public TtInvMatIssue(long matIssueId, TmUlb tmUlb, TtInvIndent ttInvIndent, String issueNo, Date issueDate,
			String indentNo, Date indentDate, Date createdDate) {
		this.matIssueId = matIssueId;
		this.tmUlb = tmUlb;
		this.ttInvIndent = ttInvIndent;
		this.issueNo = issueNo;
		this.issueDate = issueDate;
		this.indentNo = indentNo;
		this.indentDate = indentDate;
		this.createdDate = createdDate;
	}

	public TtInvMatIssue(long matIssueId, TmUlb tmUlb, TtInvIndent ttInvIndent, String issueNo, Date issueDate,
			String indentNo, Date indentDate, Long depId, Integer indentEmpid, Integer indentEmpDesigId,
			Integer issuedByEmpid, Integer issuedToEmpid, String remarks, Integer createdBy, Date createdDate,
			Integer updatedBy, Date updatedDate, String macId, String ipAddress, String deviceFrom,
			Set<TtInvMatIssueDet> ttInvMatIssueDets) {
		this.matIssueId = matIssueId;
		this.tmUlb = tmUlb;
		this.ttInvIndent = ttInvIndent;
		this.issueNo = issueNo;
		this.issueDate = issueDate;
		this.indentNo = indentNo;
		this.indentDate = indentDate;
		this.depId = depId;
		this.indentEmpid = indentEmpid;
		this.indentEmpDesigId = indentEmpDesigId;
		this.issuedByEmpid = issuedByEmpid;
		this.issuedToEmpid = issuedToEmpid;
		this.remarks = remarks;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
		this.ttInvMatIssueDets = ttInvMatIssueDets;
	}

	@Id

	@Column(name = "mat_issue_id", unique = true, nullable = false)
	public long getMatIssueId() {
		return this.matIssueId;
	}

	public void setMatIssueId(long matIssueId) {
		this.matIssueId = matIssueId;
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
	@JoinColumn(name = "indent_id", nullable = false)
	public TtInvIndent getTtInvIndent() {
		return this.ttInvIndent;
	}

	public void setTtInvIndent(TtInvIndent ttInvIndent) {
		this.ttInvIndent = ttInvIndent;
	}

	@Column(name = "issue_no", nullable = false, length = 50)
	public String getIssueNo() {
		return this.issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "issue_date", nullable = false, length = 13)
	public Date getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
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

	@Column(name = "dep_id")
	public Long getDepId() {
		return this.depId;
	}

	public void setDepId(Long depId) {
		this.depId = depId;
	}

	@Column(name = "indent_empid")
	public Integer getIndentEmpid() {
		return this.indentEmpid;
	}

	public void setIndentEmpid(Integer indentEmpid) {
		this.indentEmpid = indentEmpid;
	}

	@Column(name = "indent_emp_desig_id")
	public Integer getIndentEmpDesigId() {
		return this.indentEmpDesigId;
	}

	public void setIndentEmpDesigId(Integer indentEmpDesigId) {
		this.indentEmpDesigId = indentEmpDesigId;
	}

	@Column(name = "issued_by_empid")
	public Integer getIssuedByEmpid() {
		return this.issuedByEmpid;
	}

	public void setIssuedByEmpid(Integer issuedByEmpid) {
		this.issuedByEmpid = issuedByEmpid;
	}

	@Column(name = "issued_to_empid")
	public Integer getIssuedToEmpid() {
		return this.issuedToEmpid;
	}

	public void setIssuedToEmpid(Integer issuedToEmpid) {
		this.issuedToEmpid = issuedToEmpid;
	}

	@Column(name = "remarks", length = 2000)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ttInvMatIssue")
	public Set<TtInvMatIssueDet> getTtInvMatIssueDets() {
		return this.ttInvMatIssueDets;
	}

	public void setTtInvMatIssueDets(Set<TtInvMatIssueDet> ttInvMatIssueDets) {
		this.ttInvMatIssueDets = ttInvMatIssueDets;
	}

}
