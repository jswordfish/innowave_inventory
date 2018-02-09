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

import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterial;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;

/**
 * TtInvMaterialCardex  
 */
@Entity
@Table(name = "tt_inv_material_cardex", schema = "inventory")
public class TtInvMaterialCardex implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7718744662727124980L;
	private long matCardexId;
	private TmUlb tmUlb;
	private TmInvMaterial tmInvMaterial;
	private TmInvStore tmInvStore;
	private String materialName;
	private String storeCode;
	private BigDecimal openQty;
	private Date openDate;
	private BigDecimal openRate;
	private BigDecimal drQty;
	private BigDecimal crQty;
	private BigDecimal closingBal;
	private Date closingDate;
	private BigDecimal bookedQty;
	private BigDecimal rejectedQty;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;

	public TtInvMaterialCardex() {
	}

	public TtInvMaterialCardex(long matCardexId, TmUlb tmUlb, TmInvMaterial tmInvMaterial, TmInvStore tmInvStore,
			String materialName, String storeCode, Date createdDate) {
		this.matCardexId = matCardexId;
		this.tmUlb = tmUlb;
		this.tmInvMaterial = tmInvMaterial;
		this.tmInvStore = tmInvStore;
		this.materialName = materialName;
		this.storeCode = storeCode;
		this.createdDate = createdDate;
	}

	public TtInvMaterialCardex(long matCardexId, TmUlb tmUlb, TmInvMaterial tmInvMaterial, TmInvStore tmInvStore,
			String materialName, String storeCode, BigDecimal openQty, Date openDate, BigDecimal openRate,
			BigDecimal drQty, BigDecimal crQty, BigDecimal closingBal, Date closingDate, BigDecimal bookedQty,
			BigDecimal rejectedQty, Integer createdBy, Date createdDate, Integer updatedBy, Date updatedDate,
			String macId, String ipAddress, String deviceFrom) {
		this.matCardexId = matCardexId;
		this.tmUlb = tmUlb;
		this.tmInvMaterial = tmInvMaterial;
		this.tmInvStore = tmInvStore;
		this.materialName = materialName;
		this.storeCode = storeCode;
		this.openQty = openQty;
		this.openDate = openDate;
		this.openRate = openRate;
		this.drQty = drQty;
		this.crQty = crQty;
		this.closingBal = closingBal;
		this.closingDate = closingDate;
		this.bookedQty = bookedQty;
		this.rejectedQty = rejectedQty;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
	}

	@Id

	@Column(name = "mat_cardex_id", unique = true, nullable = false)
	public long getMatCardexId() {
		return this.matCardexId;
	}

	public void setMatCardexId(long matCardexId) {
		this.matCardexId = matCardexId;
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
	@JoinColumn(name = "store_id", nullable = false)
	public TmInvStore getTmInvStore() {
		return this.tmInvStore;
	}

	public void setTmInvStore(TmInvStore tmInvStore) {
		this.tmInvStore = tmInvStore;
	}

	@Column(name = "material_name", nullable = false, length = 200)
	public String getMaterialName() {
		return this.materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	@Column(name = "store_code", nullable = false, length = 20)
	public String getStoreCode() {
		return this.storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	@Column(name = "open_qty", precision = 12, scale = 3)
	public BigDecimal getOpenQty() {
		return this.openQty;
	}

	public void setOpenQty(BigDecimal openQty) {
		this.openQty = openQty;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "open_date", length = 13)
	public Date getOpenDate() {
		return this.openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	@Column(name = "open_rate", precision = 12)
	public BigDecimal getOpenRate() {
		return this.openRate;
	}

	public void setOpenRate(BigDecimal openRate) {
		this.openRate = openRate;
	}

	@Column(name = "dr_qty", precision = 12, scale = 3)
	public BigDecimal getDrQty() {
		return this.drQty;
	}

	public void setDrQty(BigDecimal drQty) {
		this.drQty = drQty;
	}

	@Column(name = "cr_qty", precision = 12, scale = 3)
	public BigDecimal getCrQty() {
		return this.crQty;
	}

	public void setCrQty(BigDecimal crQty) {
		this.crQty = crQty;
	}

	@Column(name = "closing_bal", precision = 12, scale = 3)
	public BigDecimal getClosingBal() {
		return this.closingBal;
	}

	public void setClosingBal(BigDecimal closingBal) {
		this.closingBal = closingBal;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "closing_date", length = 13)
	public Date getClosingDate() {
		return this.closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	@Column(name = "booked_qty", precision = 12, scale = 3)
	public BigDecimal getBookedQty() {
		return this.bookedQty;
	}

	public void setBookedQty(BigDecimal bookedQty) {
		this.bookedQty = bookedQty;
	}

	@Column(name = "rejected_qty", precision = 12, scale = 3)
	public BigDecimal getRejectedQty() {
		return this.rejectedQty;
	}

	public void setRejectedQty(BigDecimal rejectedQty) {
		this.rejectedQty = rejectedQty;
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
