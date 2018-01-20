package com.innowave.mahaulb.repository.inventory.dao.master;
// Generated Jan 17, 2018 4:05:03 PM

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
import com.innowave.mahaulb.common.dao.TmCmLookupDetHierarchical;
import com.innowave.mahaulb.common.dao.TmUlb;

/**
 * TmInvMaterial 
 */
@Entity
@Table(name = "tm_inv_material", schema = "inventory")
public class TmInvMaterial implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -596087237805674062L;
	private long materialId;
	private TmCmLookupDet tmCmLookupDetByLookupDetIdUsageClass;
	private TmCmLookupDet tmCmLookupDetByLookupDetIdInvType;
	private TmCmLookupDetHierarchical tmCmLookupDetHierarchicalByLookupDetIdPurchaseUom;
	private TmCmLookupDetHierarchical tmCmLookupDetHierarchicalByLookupDetIdStockingUom;
	private TmCmLookupDetHierarchical tmCmLookupDetHierarchicalByLookupDetIdBaseUom;
	private TmUlb tmUlb;
	private TmInvMaterialType tmInvMaterialType;
	private String materialCode;
	private String materialName;
	private String materialDesc;
	private Integer expenseAccountCode;
	private BigDecimal minQty;
	private BigDecimal maxQty;
	private BigDecimal reorderLevel;
	private BigDecimal reorderQty;
	private Character shelfLifControlYn;
	private BigDecimal ratePerUnit;
	private Integer status;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;

	public TmInvMaterial() {
	}

	public TmInvMaterial(long materialId, TmUlb tmUlb, TmInvMaterialType tmInvMaterialType, String materialCode,
			String materialName, Date createdDate) {
		this.materialId = materialId;
		this.tmUlb = tmUlb;
		this.tmInvMaterialType = tmInvMaterialType;
		this.materialCode = materialCode;
		this.materialName = materialName;
		this.createdDate = createdDate;
	}

	public TmInvMaterial(long materialId, TmCmLookupDet tmCmLookupDetByLookupDetIdUsageClass,
			TmCmLookupDet tmCmLookupDetByLookupDetIdInvType,
			TmCmLookupDetHierarchical tmCmLookupDetHierarchicalByLookupDetIdPurchaseUom,
			TmCmLookupDetHierarchical tmCmLookupDetHierarchicalByLookupDetIdStockingUom,
			TmCmLookupDetHierarchical tmCmLookupDetHierarchicalByLookupDetIdBaseUom, TmUlb tmUlb,
			TmInvMaterialType tmInvMaterialType, String materialCode, String materialName, String materialDesc,
			Integer expenseAccountCode, BigDecimal minQty, BigDecimal maxQty, BigDecimal reorderLevel,
			BigDecimal reorderQty, Character shelfLifControlYn, BigDecimal ratePerUnit, Integer status,
			Integer createdBy, Date createdDate, Integer updatedBy, Date updatedDate, String macId, String ipAddress,
			String deviceFrom) {
		this.materialId = materialId;
		this.tmCmLookupDetByLookupDetIdUsageClass = tmCmLookupDetByLookupDetIdUsageClass;
		this.tmCmLookupDetByLookupDetIdInvType = tmCmLookupDetByLookupDetIdInvType;
		this.tmCmLookupDetHierarchicalByLookupDetIdPurchaseUom = tmCmLookupDetHierarchicalByLookupDetIdPurchaseUom;
		this.tmCmLookupDetHierarchicalByLookupDetIdStockingUom = tmCmLookupDetHierarchicalByLookupDetIdStockingUom;
		this.tmCmLookupDetHierarchicalByLookupDetIdBaseUom = tmCmLookupDetHierarchicalByLookupDetIdBaseUom;
		this.tmUlb = tmUlb;
		this.tmInvMaterialType = tmInvMaterialType;
		this.materialCode = materialCode;
		this.materialName = materialName;
		this.materialDesc = materialDesc;
		this.expenseAccountCode = expenseAccountCode;
		this.minQty = minQty;
		this.maxQty = maxQty;
		this.reorderLevel = reorderLevel;
		this.reorderQty = reorderQty;
		this.shelfLifControlYn = shelfLifControlYn;
		this.ratePerUnit = ratePerUnit;
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

	@Column(name = "material_id", unique = true, nullable = false)
	public long getMaterialId() {
		return this.materialId;
	}

	public void setMaterialId(long materialId) {
		this.materialId = materialId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lookup_det_id_usage_class")
	public TmCmLookupDet getTmCmLookupDetByLookupDetIdUsageClass() {
		return this.tmCmLookupDetByLookupDetIdUsageClass;
	}

	public void setTmCmLookupDetByLookupDetIdUsageClass(TmCmLookupDet tmCmLookupDetByLookupDetIdUsageClass) {
		this.tmCmLookupDetByLookupDetIdUsageClass = tmCmLookupDetByLookupDetIdUsageClass;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lookup_det_id_inv_type")
	public TmCmLookupDet getTmCmLookupDetByLookupDetIdInvType() {
		return this.tmCmLookupDetByLookupDetIdInvType;
	}

	public void setTmCmLookupDetByLookupDetIdInvType(TmCmLookupDet tmCmLookupDetByLookupDetIdInvType) {
		this.tmCmLookupDetByLookupDetIdInvType = tmCmLookupDetByLookupDetIdInvType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lookup_det_id_purchase_uom")
	public TmCmLookupDetHierarchical getTmCmLookupDetHierarchicalByLookupDetIdPurchaseUom() {
		return this.tmCmLookupDetHierarchicalByLookupDetIdPurchaseUom;
	}

	public void setTmCmLookupDetHierarchicalByLookupDetIdPurchaseUom(
			TmCmLookupDetHierarchical tmCmLookupDetHierarchicalByLookupDetIdPurchaseUom) {
		this.tmCmLookupDetHierarchicalByLookupDetIdPurchaseUom = tmCmLookupDetHierarchicalByLookupDetIdPurchaseUom;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lookup_det_id_stocking_uom")
	public TmCmLookupDetHierarchical getTmCmLookupDetHierarchicalByLookupDetIdStockingUom() {
		return this.tmCmLookupDetHierarchicalByLookupDetIdStockingUom;
	}

	public void setTmCmLookupDetHierarchicalByLookupDetIdStockingUom(
			TmCmLookupDetHierarchical tmCmLookupDetHierarchicalByLookupDetIdStockingUom) {
		this.tmCmLookupDetHierarchicalByLookupDetIdStockingUom = tmCmLookupDetHierarchicalByLookupDetIdStockingUom;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lookup_det_id_base_uom")
	public TmCmLookupDetHierarchical getTmCmLookupDetHierarchicalByLookupDetIdBaseUom() {
		return this.tmCmLookupDetHierarchicalByLookupDetIdBaseUom;
	}

	public void setTmCmLookupDetHierarchicalByLookupDetIdBaseUom(
			TmCmLookupDetHierarchical tmCmLookupDetHierarchicalByLookupDetIdBaseUom) {
		this.tmCmLookupDetHierarchicalByLookupDetIdBaseUom = tmCmLookupDetHierarchicalByLookupDetIdBaseUom;
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
	@JoinColumn(name = "material_type_id", nullable = false)
	public TmInvMaterialType getTmInvMaterialType() {
		return this.tmInvMaterialType;
	}

	public void setTmInvMaterialType(TmInvMaterialType tmInvMaterialType) {
		this.tmInvMaterialType = tmInvMaterialType;
	}

	@Column(name = "material_code", nullable = false, length = 20)
	public String getMaterialCode() {
		return this.materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	@Column(name = "material_name", nullable = false, length = 200)
	public String getMaterialName() {
		return this.materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	@Column(name = "material_desc", length = 1000)
	public String getMaterialDesc() {
		return this.materialDesc;
	}

	public void setMaterialDesc(String materialDesc) {
		this.materialDesc = materialDesc;
	}

	@Column(name = "expense_account_code")
	public Integer getExpenseAccountCode() {
		return this.expenseAccountCode;
	}

	public void setExpenseAccountCode(Integer expenseAccountCode) {
		this.expenseAccountCode = expenseAccountCode;
	}

	@Column(name = "min_qty", precision = 12, scale = 3)
	public BigDecimal getMinQty() {
		return this.minQty;
	}

	public void setMinQty(BigDecimal minQty) {
		this.minQty = minQty;
	}

	@Column(name = "max_qty", precision = 12, scale = 3)
	public BigDecimal getMaxQty() {
		return this.maxQty;
	}

	public void setMaxQty(BigDecimal maxQty) {
		this.maxQty = maxQty;
	}

	@Column(name = "reorder_level", precision = 12, scale = 3)
	public BigDecimal getReorderLevel() {
		return this.reorderLevel;
	}

	public void setReorderLevel(BigDecimal reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	@Column(name = "reorder_qty", precision = 12, scale = 3)
	public BigDecimal getReorderQty() {
		return this.reorderQty;
	}

	public void setReorderQty(BigDecimal reorderQty) {
		this.reorderQty = reorderQty;
	}

	@Column(name = "shelf_lif_control_yn", length = 1)
	public Character getShelfLifControlYn() {
		return this.shelfLifControlYn;
	}

	public void setShelfLifControlYn(Character shelfLifControlYn) {
		this.shelfLifControlYn = shelfLifControlYn;
	}

	@Column(name = "rate_per_unit", precision = 12)
	public BigDecimal getRatePerUnit() {
		return this.ratePerUnit;
	}

	public void setRatePerUnit(BigDecimal ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
