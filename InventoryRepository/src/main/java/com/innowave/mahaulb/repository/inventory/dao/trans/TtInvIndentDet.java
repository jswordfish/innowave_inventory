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
import com.innowave.mahaulb.common.dao.master.TmCmProject;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterial;

/**
 * TtInvIndentDet 
 */
@Entity
@Table(name = "tt_inv_indent_det", schema = "inventory")
public class TtInvIndentDet implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6189243409557261727L;
	private long indentDetId;
	private TmCmLookupDet tmCmLookupDet;
	private TmCmProject tmCmProject;
	private TmUlb tmUlb;
	private TmInvMaterial tmInvMaterial;
	private TtInvIndent ttInvIndent;
	private String materialName;
	private Long assetId;
	private String assetCode;
	private String projectCode;
	private BigDecimal qty;
	private Date expDeliveryDate;
	private BigDecimal amount;
	private BigDecimal balQty;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;

	public TtInvIndentDet() {
	}

	public TtInvIndentDet(long indentDetId, TmUlb tmUlb, TmInvMaterial tmInvMaterial, TtInvIndent ttInvIndent,
			String materialName, Date createdDate) {
		this.indentDetId = indentDetId;
		this.tmUlb = tmUlb;
		this.tmInvMaterial = tmInvMaterial;
		this.ttInvIndent = ttInvIndent;
		this.materialName = materialName;
		this.createdDate = createdDate;
	}

	public TtInvIndentDet(long indentDetId, TmCmLookupDet tmCmLookupDet, TmCmProject tmCmProject, TmUlb tmUlb,
			TmInvMaterial tmInvMaterial, TtInvIndent ttInvIndent, String materialName, Long assetId, String assetCode,
			String projectCode, BigDecimal qty, Date expDeliveryDate, BigDecimal amount, BigDecimal balQty,
			Integer createdBy, Date createdDate, Integer updatedBy, Date updatedDate, String macId, String ipAddress,
			String deviceFrom) {
		this.indentDetId = indentDetId;
		this.tmCmLookupDet = tmCmLookupDet;
		this.tmCmProject = tmCmProject;
		this.tmUlb = tmUlb;
		this.tmInvMaterial = tmInvMaterial;
		this.ttInvIndent = ttInvIndent;
		this.materialName = materialName;
		this.assetId = assetId;
		this.assetCode = assetCode;
		this.projectCode = projectCode;
		this.qty = qty;
		this.expDeliveryDate = expDeliveryDate;
		this.amount = amount;
		this.balQty = balQty;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
	}

	@Id

	@Column(name = "indent_det_id", unique = true, nullable = false)
	public long getIndentDetId() {
		return this.indentDetId;
	}

	public void setIndentDetId(long indentDetId) {
		this.indentDetId = indentDetId;
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
	@JoinColumn(name = "project_id")
	public TmCmProject getTmCmProject() {
		return this.tmCmProject;
	}

	public void setTmCmProject(TmCmProject tmCmProject) {
		this.tmCmProject = tmCmProject;
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
	@JoinColumn(name = "indent_id", nullable = false)
	public TtInvIndent getTtInvIndent() {
		return this.ttInvIndent;
	}

	public void setTtInvIndent(TtInvIndent ttInvIndent) {
		this.ttInvIndent = ttInvIndent;
	}

	@Column(name = "material_name", nullable = false, length = 200)
	public String getMaterialName() {
		return this.materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	@Column(name = "asset_id")
	public Long getAssetId() {
		return this.assetId;
	}

	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}

	@Column(name = "asset_code", length = 20)
	public String getAssetCode() {
		return this.assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	@Column(name = "project_code", length = 20)
	public String getProjectCode() {
		return this.projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	@Column(name = "qty", precision = 12, scale = 3)
	public BigDecimal getQty() {
		return this.qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "exp_delivery_date", length = 13)
	public Date getExpDeliveryDate() {
		return this.expDeliveryDate;
	}

	public void setExpDeliveryDate(Date expDeliveryDate) {
		this.expDeliveryDate = expDeliveryDate;
	}

	@Column(name = "amount", precision = 12)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name = "bal_qty", precision = 12, scale = 3)
	public BigDecimal getBalQty() {
		return this.balQty;
	}

	public void setBalQty(BigDecimal balQty) {
		this.balQty = balQty;
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
