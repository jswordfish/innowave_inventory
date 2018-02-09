package com.innowave.mahaulb.repository.inventory.dao.trans;
// Generated Feb 7, 2018 2:46:28 PM  

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
 * TtInvPurchaseOrderDet  
 */
@Entity
@Table(name = "tt_inv_purchase_order_det", schema = "inventory")
public class TtInvPurchaseOrderDet implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4168024188560607902L;
	private long purchaseOrderDetId;
	private TmCmLookupDet tmCmLookupDet;
	private TmUlb tmUlb;
	private TmInvMaterial tmInvMaterial;
	private TtInvIndent ttInvIndent;
	private TtInvPurchaseOrder ttInvPurchaseOrder;
	private String indentNo;
	private BigDecimal balQty;
	private BigDecimal orderQty;
	private BigDecimal unitRate;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;

	public TtInvPurchaseOrderDet() {
	}

	public TtInvPurchaseOrderDet(long purchaseOrderDetId, TmUlb tmUlb, TmInvMaterial tmInvMaterial,
			TtInvPurchaseOrder ttInvPurchaseOrder, Date createdDate) {
		this.purchaseOrderDetId = purchaseOrderDetId;
		this.tmUlb = tmUlb;
		this.tmInvMaterial = tmInvMaterial;
		this.ttInvPurchaseOrder = ttInvPurchaseOrder;
		this.createdDate = createdDate;
	}

	public TtInvPurchaseOrderDet(long purchaseOrderDetId, TmCmLookupDet tmCmLookupDet, TmUlb tmUlb,
			TmInvMaterial tmInvMaterial, TtInvIndent ttInvIndent, TtInvPurchaseOrder ttInvPurchaseOrder,
			String indentNo, BigDecimal balQty, BigDecimal orderQty, BigDecimal unitRate, Integer createdBy,
			Date createdDate, Integer updatedBy, Date updatedDate, String macId, String ipAddress, String deviceFrom) {
		this.purchaseOrderDetId = purchaseOrderDetId;
		this.tmCmLookupDet = tmCmLookupDet;
		this.tmUlb = tmUlb;
		this.tmInvMaterial = tmInvMaterial;
		this.ttInvIndent = ttInvIndent;
		this.ttInvPurchaseOrder = ttInvPurchaseOrder;
		this.indentNo = indentNo;
		this.balQty = balQty;
		this.orderQty = orderQty;
		this.unitRate = unitRate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
	}

	@Id

	@Column(name = "purchase_order_det_id", unique = true, nullable = false)
	public long getPurchaseOrderDetId() {
		return this.purchaseOrderDetId;
	}

	public void setPurchaseOrderDetId(long purchaseOrderDetId) {
		this.purchaseOrderDetId = purchaseOrderDetId;
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
	@JoinColumn(name = "indent_id")
	public TtInvIndent getTtInvIndent() {
		return this.ttInvIndent;
	}

	public void setTtInvIndent(TtInvIndent ttInvIndent) {
		this.ttInvIndent = ttInvIndent;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "purchase_order_id", nullable = false)
	public TtInvPurchaseOrder getTtInvPurchaseOrder() {
		return this.ttInvPurchaseOrder;
	}

	public void setTtInvPurchaseOrder(TtInvPurchaseOrder ttInvPurchaseOrder) {
		this.ttInvPurchaseOrder = ttInvPurchaseOrder;
	}

	@Column(name = "indent_no", length = 50)
	public String getIndentNo() {
		return this.indentNo;
	}

	public void setIndentNo(String indentNo) {
		this.indentNo = indentNo;
	}

	@Column(name = "bal_qty", precision = 12, scale = 3)
	public BigDecimal getBalQty() {
		return this.balQty;
	}

	public void setBalQty(BigDecimal balQty) {
		this.balQty = balQty;
	}

	@Column(name = "order_qty", precision = 12, scale = 3)
	public BigDecimal getOrderQty() {
		return this.orderQty;
	}

	public void setOrderQty(BigDecimal orderQty) {
		this.orderQty = orderQty;
	}

	@Column(name = "unit_rate", precision = 12)
	public BigDecimal getUnitRate() {
		return this.unitRate;
	}

	public void setUnitRate(BigDecimal unitRate) {
		this.unitRate = unitRate;
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
