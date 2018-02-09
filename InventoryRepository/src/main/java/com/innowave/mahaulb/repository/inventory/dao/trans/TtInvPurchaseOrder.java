package com.innowave.mahaulb.repository.inventory.dao.trans;
// Generated Feb 7, 2018 2:46:28 PM  

import java.math.BigDecimal;
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
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvSupplier;

/**
 * TtInvPurchaseOrder 
 */
@Entity
@Table(name = "tt_inv_purchase_order", schema = "inventory")
public class TtInvPurchaseOrder implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4390831919667122941L;
	private long purchaseOrderId;
	private TmCmLookupDet tmCmLookupDetByLookupDetIdRateType;
	private TmCmLookupDet tmCmLookupDetByLookupDetIdPoStatus;
	private TmUlb tmUlb;
	private TmInvSupplier tmInvSupplier;
	private String purchaseOrderNo;
	private Date purchaseOrderDate;
	private String supplierName;
	private String deliveryTerms;
	private String paymentTerms;
	private BigDecimal advancePercentage;
	private BigDecimal advanceAmount;
	private String remarks;
	private String refNo;
	private Date refDate;
	private BigDecimal totalValue;
	private Integer approvedBy;
	private Date approvedDate;
	private String approvalRemarks;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;
	private Set<TtInvPurchaseOrderDet> ttInvPurchaseOrderDets = new HashSet<TtInvPurchaseOrderDet>(0);

	public TtInvPurchaseOrder() {
	}

	public TtInvPurchaseOrder(long purchaseOrderId, TmCmLookupDet tmCmLookupDetByLookupDetIdRateType,
			TmCmLookupDet tmCmLookupDetByLookupDetIdPoStatus, TmUlb tmUlb, TmInvSupplier tmInvSupplier,
			String purchaseOrderNo, Date purchaseOrderDate, String supplierName, String refNo, Date refDate,
			Date createdDate) {
		this.purchaseOrderId = purchaseOrderId;
		this.tmCmLookupDetByLookupDetIdRateType = tmCmLookupDetByLookupDetIdRateType;
		this.tmCmLookupDetByLookupDetIdPoStatus = tmCmLookupDetByLookupDetIdPoStatus;
		this.tmUlb = tmUlb;
		this.tmInvSupplier = tmInvSupplier;
		this.purchaseOrderNo = purchaseOrderNo;
		this.purchaseOrderDate = purchaseOrderDate;
		this.supplierName = supplierName;
		this.refNo = refNo;
		this.refDate = refDate;
		this.createdDate = createdDate;
	}

	public TtInvPurchaseOrder(long purchaseOrderId, TmCmLookupDet tmCmLookupDetByLookupDetIdRateType,
			TmCmLookupDet tmCmLookupDetByLookupDetIdPoStatus, TmUlb tmUlb, TmInvSupplier tmInvSupplier,
			String purchaseOrderNo, Date purchaseOrderDate, String supplierName, String deliveryTerms,
			String paymentTerms, BigDecimal advancePercentage, BigDecimal advanceAmount, String remarks, String refNo,
			Date refDate, BigDecimal totalValue, Integer approvedBy, Date approvedDate, String approvalRemarks,
			Integer createdBy, Date createdDate, Integer updatedBy, Date updatedDate, String macId, String ipAddress,
			String deviceFrom, Set<TtInvPurchaseOrderDet> ttInvPurchaseOrderDets) {
		this.purchaseOrderId = purchaseOrderId;
		this.tmCmLookupDetByLookupDetIdRateType = tmCmLookupDetByLookupDetIdRateType;
		this.tmCmLookupDetByLookupDetIdPoStatus = tmCmLookupDetByLookupDetIdPoStatus;
		this.tmUlb = tmUlb;
		this.tmInvSupplier = tmInvSupplier;
		this.purchaseOrderNo = purchaseOrderNo;
		this.purchaseOrderDate = purchaseOrderDate;
		this.supplierName = supplierName;
		this.deliveryTerms = deliveryTerms;
		this.paymentTerms = paymentTerms;
		this.advancePercentage = advancePercentage;
		this.advanceAmount = advanceAmount;
		this.remarks = remarks;
		this.refNo = refNo;
		this.refDate = refDate;
		this.totalValue = totalValue;
		this.approvedBy = approvedBy;
		this.approvedDate = approvedDate;
		this.approvalRemarks = approvalRemarks;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
		this.ttInvPurchaseOrderDets = ttInvPurchaseOrderDets;
	}

	@Id

	@Column(name = "purchase_order_id", unique = true, nullable = false)
	public long getPurchaseOrderId() {
		return this.purchaseOrderId;
	}

	public void setPurchaseOrderId(long purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lookup_det_id_rate_type", nullable = false)
	public TmCmLookupDet getTmCmLookupDetByLookupDetIdRateType() {
		return this.tmCmLookupDetByLookupDetIdRateType;
	}

	public void setTmCmLookupDetByLookupDetIdRateType(TmCmLookupDet tmCmLookupDetByLookupDetIdRateType) {
		this.tmCmLookupDetByLookupDetIdRateType = tmCmLookupDetByLookupDetIdRateType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lookup_det_id_po_status", nullable = false)
	public TmCmLookupDet getTmCmLookupDetByLookupDetIdPoStatus() {
		return this.tmCmLookupDetByLookupDetIdPoStatus;
	}

	public void setTmCmLookupDetByLookupDetIdPoStatus(TmCmLookupDet tmCmLookupDetByLookupDetIdPoStatus) {
		this.tmCmLookupDetByLookupDetIdPoStatus = tmCmLookupDetByLookupDetIdPoStatus;
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
	@JoinColumn(name = "supplier_id", nullable = false)
	public TmInvSupplier getTmInvSupplier() {
		return this.tmInvSupplier;
	}

	public void setTmInvSupplier(TmInvSupplier tmInvSupplier) {
		this.tmInvSupplier = tmInvSupplier;
	}

	@Column(name = "purchase_order_no", nullable = false, length = 50)
	public String getPurchaseOrderNo() {
		return this.purchaseOrderNo;
	}

	public void setPurchaseOrderNo(String purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "purchase_order_date", nullable = false, length = 13)
	public Date getPurchaseOrderDate() {
		return this.purchaseOrderDate;
	}

	public void setPurchaseOrderDate(Date purchaseOrderDate) {
		this.purchaseOrderDate = purchaseOrderDate;
	}

	@Column(name = "supplier_name", nullable = false, length = 200)
	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Column(name = "delivery_terms", length = 2000)
	public String getDeliveryTerms() {
		return this.deliveryTerms;
	}

	public void setDeliveryTerms(String deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
	}

	@Column(name = "payment_terms", length = 2000)
	public String getPaymentTerms() {
		return this.paymentTerms;
	}

	public void setPaymentTerms(String paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	@Column(name = "advance_percentage", precision = 5)
	public BigDecimal getAdvancePercentage() {
		return this.advancePercentage;
	}

	public void setAdvancePercentage(BigDecimal advancePercentage) {
		this.advancePercentage = advancePercentage;
	}

	@Column(name = "advance_amount", precision = 12)
	public BigDecimal getAdvanceAmount() {
		return this.advanceAmount;
	}

	public void setAdvanceAmount(BigDecimal advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	@Column(name = "remarks", length = 2000)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "ref_no", nullable = false, length = 50)
	public String getRefNo() {
		return this.refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ref_date", nullable = false, length = 13)
	public Date getRefDate() {
		return this.refDate;
	}

	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}

	@Column(name = "total_value", precision = 12)
	public BigDecimal getTotalValue() {
		return this.totalValue;
	}

	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
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

	@Column(name = "approval_remarks", length = 2000)
	public String getApprovalRemarks() {
		return this.approvalRemarks;
	}

	public void setApprovalRemarks(String approvalRemarks) {
		this.approvalRemarks = approvalRemarks;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ttInvPurchaseOrder")
	public Set<TtInvPurchaseOrderDet> getTtInvPurchaseOrderDets() {
		return this.ttInvPurchaseOrderDets;
	}

	public void setTtInvPurchaseOrderDets(Set<TtInvPurchaseOrderDet> ttInvPurchaseOrderDets) {
		this.ttInvPurchaseOrderDets = ttInvPurchaseOrderDets;
	}

}
