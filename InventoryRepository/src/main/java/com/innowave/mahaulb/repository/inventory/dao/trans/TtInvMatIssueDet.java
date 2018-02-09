package com.innowave.mahaulb.repository.inventory.dao.trans;
// Generated Jan 31, 2018 2:32:46 PM 

import java.math.BigDecimal;
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

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterial;

/**
 * TtInvMatIssueDet  
 */
@Entity
@Table(name = "tt_inv_mat_issue_det", schema = "inventory")
public class TtInvMatIssueDet implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4649557839988395124L;
	private long matIssueDetId;
	private TmCmLookupDet tmCmLookupDet;
	private TmUlb tmUlb;
	private TmInvMaterial tmInvMaterial;
	private TtInvMatIssue ttInvMatIssue;
	private BigDecimal reqQty;
	private BigDecimal balQtyToIssue;
	private BigDecimal issueQty;
	private BigDecimal rate;
	private BigDecimal balQtyAfterIssue;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;

	public TtInvMatIssueDet() {
	}

	public TtInvMatIssueDet(long matIssueDetId, TmUlb tmUlb, TmInvMaterial tmInvMaterial, TtInvMatIssue ttInvMatIssue,
			Date createdDate) {
		this.matIssueDetId = matIssueDetId;
		this.tmUlb = tmUlb;
		this.tmInvMaterial = tmInvMaterial;
		this.ttInvMatIssue = ttInvMatIssue;
		this.createdDate = createdDate;
	}

	public TtInvMatIssueDet(long matIssueDetId, TmCmLookupDet tmCmLookupDet, TmUlb tmUlb, TmInvMaterial tmInvMaterial,
			TtInvMatIssue ttInvMatIssue, BigDecimal reqQty, BigDecimal balQtyToIssue, BigDecimal issueQty,
			BigDecimal rate, BigDecimal balQtyAfterIssue, Integer createdBy, Date createdDate, Integer updatedBy,
			Date updatedDate, String macId, String ipAddress, String deviceFrom) {
		this.matIssueDetId = matIssueDetId;
		this.tmCmLookupDet = tmCmLookupDet;
		this.tmUlb = tmUlb;
		this.tmInvMaterial = tmInvMaterial;
		this.ttInvMatIssue = ttInvMatIssue;
		this.reqQty = reqQty;
		this.balQtyToIssue = balQtyToIssue;
		this.issueQty = issueQty;
		this.rate = rate;
		this.balQtyAfterIssue = balQtyAfterIssue;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
	}

	@Id

	@Column(name = "mat_issue_det_id", unique = true, nullable = false)
	public long getMatIssueDetId() {
		return this.matIssueDetId;
	}

	public void setMatIssueDetId(long matIssueDetId) {
		this.matIssueDetId = matIssueDetId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lookup_det_id_uom")
	public TmCmLookupDet getTmCmLookupDet() {
		return this.tmCmLookupDet;
	}

	public void setTmCmLookupDet(TmCmLookupDet tmCmLookupDet) {
		this.tmCmLookupDet = tmCmLookupDet;
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
	@JoinColumn(name = "material_id", nullable = false)
	public TmInvMaterial getTmInvMaterial() {
		return this.tmInvMaterial;
	}

	public void setTmInvMaterial(TmInvMaterial tmInvMaterial) {
		this.tmInvMaterial = tmInvMaterial;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mat_issue_id", nullable = false)
	public TtInvMatIssue getTtInvMatIssue() {
		return this.ttInvMatIssue;
	}

	public void setTtInvMatIssue(TtInvMatIssue ttInvMatIssue) {
		this.ttInvMatIssue = ttInvMatIssue;
	}

	@Column(name = "req_qty", precision = 12, scale = 3)
	public BigDecimal getReqQty() {
		return this.reqQty;
	}

	public void setReqQty(BigDecimal reqQty) {
		this.reqQty = reqQty;
	}

	@Column(name = "bal_qty_to_issue", precision = 12, scale = 3)
	public BigDecimal getBalQtyToIssue() {
		return this.balQtyToIssue;
	}

	public void setBalQtyToIssue(BigDecimal balQtyToIssue) {
		this.balQtyToIssue = balQtyToIssue;
	}

	@Column(name = "issue_qty", precision = 12, scale = 3)
	public BigDecimal getIssueQty() {
		return this.issueQty;
	}

	public void setIssueQty(BigDecimal issueQty) {
		this.issueQty = issueQty;
	}

	@Column(name = "rate", precision = 12)
	public BigDecimal getRate() {
		return this.rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	@Column(name = "bal_qty_after_issue", precision = 12, scale = 3)
	public BigDecimal getBalQtyAfterIssue() {
		return this.balQtyAfterIssue;
	}

	public void setBalQtyAfterIssue(BigDecimal balQtyAfterIssue) {
		this.balQtyAfterIssue = balQtyAfterIssue;
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

}
