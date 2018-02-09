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
 * TtInvMrnInspDet  
 */
@Entity
@Table(name = "tt_inv_mrn_insp_det", schema = "inventory")
public class TtInvMrnInspDet implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 617017705825804267L;
	private long mrnInspDetId;
	private TmCmLookupDet tmCmLookupDet;
	private TmUlb tmUlb;
	private TmInvMaterial tmInvMaterial;
	private TtInvMrnInsp ttInvMrnInsp;
	private String materialName;
	private BigDecimal recdQty;
	private BigDecimal acceptedQty;
	private BigDecimal rejectedQty;
	private BigDecimal unitRate;
	private BigDecimal amount;
	private String rejectionRemark;
	private String qrCode;
	private Integer inspectionBy;
	private Integer approvedBy;
	private Date approvedDate;
	private String approvalRemark;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;

	public TtInvMrnInspDet() {
	}

	public TtInvMrnInspDet(long mrnInspDetId, TmUlb tmUlb, TmInvMaterial tmInvMaterial, TtInvMrnInsp ttInvMrnInsp,
			String materialName, Date createdDate) {
		this.mrnInspDetId = mrnInspDetId;
		this.tmUlb = tmUlb;
		this.tmInvMaterial = tmInvMaterial;
		this.ttInvMrnInsp = ttInvMrnInsp;
		this.materialName = materialName;
		this.createdDate = createdDate;
	}

	public TtInvMrnInspDet(long mrnInspDetId, TmCmLookupDet tmCmLookupDet, TmUlb tmUlb, TmInvMaterial tmInvMaterial,
			TtInvMrnInsp ttInvMrnInsp, String materialName, BigDecimal recdQty, BigDecimal acceptedQty,
			BigDecimal rejectedQty, BigDecimal unitRate, BigDecimal amount, String rejectionRemark, String qrCode,
			Integer inspectionBy, Integer approvedBy, Date approvedDate, String approvalRemark, Integer createdBy,
			Date createdDate, Integer updatedBy, Date updatedDate, String macId, String ipAddress, String deviceFrom) {
		this.mrnInspDetId = mrnInspDetId;
		this.tmCmLookupDet = tmCmLookupDet;
		this.tmUlb = tmUlb;
		this.tmInvMaterial = tmInvMaterial;
		this.ttInvMrnInsp = ttInvMrnInsp;
		this.materialName = materialName;
		this.recdQty = recdQty;
		this.acceptedQty = acceptedQty;
		this.rejectedQty = rejectedQty;
		this.unitRate = unitRate;
		this.amount = amount;
		this.rejectionRemark = rejectionRemark;
		this.qrCode = qrCode;
		this.inspectionBy = inspectionBy;
		this.approvedBy = approvedBy;
		this.approvedDate = approvedDate;
		this.approvalRemark = approvalRemark;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
	}

	@Id

	@Column(name = "mrn_insp_det_id", unique = true, nullable = false)
	public long getMrnInspDetId() {
		return this.mrnInspDetId;
	}

	public void setMrnInspDetId(long mrnInspDetId) {
		this.mrnInspDetId = mrnInspDetId;
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
	@JoinColumn(name = "mrn_insp_id", nullable = false)
	public TtInvMrnInsp getTtInvMrnInsp() {
		return this.ttInvMrnInsp;
	}

	public void setTtInvMrnInsp(TtInvMrnInsp ttInvMrnInsp) {
		this.ttInvMrnInsp = ttInvMrnInsp;
	}

	@Column(name = "material_name", nullable = false, length = 200)
	public String getMaterialName() {
		return this.materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	@Column(name = "recd_qty", precision = 12, scale = 3)
	public BigDecimal getRecdQty() {
		return this.recdQty;
	}

	public void setRecdQty(BigDecimal recdQty) {
		this.recdQty = recdQty;
	}

	@Column(name = "accepted_qty", precision = 12, scale = 3)
	public BigDecimal getAcceptedQty() {
		return this.acceptedQty;
	}

	public void setAcceptedQty(BigDecimal acceptedQty) {
		this.acceptedQty = acceptedQty;
	}

	@Column(name = "rejected_qty", precision = 12, scale = 3)
	public BigDecimal getRejectedQty() {
		return this.rejectedQty;
	}

	public void setRejectedQty(BigDecimal rejectedQty) {
		this.rejectedQty = rejectedQty;
	}

	@Column(name = "unit_rate", precision = 12)
	public BigDecimal getUnitRate() {
		return this.unitRate;
	}

	public void setUnitRate(BigDecimal unitRate) {
		this.unitRate = unitRate;
	}

	@Column(name = "amount", precision = 12)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name = "rejection_remark", length = 2000)
	public String getRejectionRemark() {
		return this.rejectionRemark;
	}

	public void setRejectionRemark(String rejectionRemark) {
		this.rejectionRemark = rejectionRemark;
	}

	@Column(name = "qr_code", length = 200)
	public String getQrCode() {
		return this.qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	@Column(name = "inspection_by")
	public Integer getInspectionBy() {
		return this.inspectionBy;
	}

	public void setInspectionBy(Integer inspectionBy) {
		this.inspectionBy = inspectionBy;
	}

	@Column(name = "approved_by")
	public Integer getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(Integer approvedBy) {
		this.approvedBy = approvedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "approved_date", length = 13)
	public Date getApprovedDate() {
		return this.approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	@Column(name = "approval_remark", length = 2000)
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

}
