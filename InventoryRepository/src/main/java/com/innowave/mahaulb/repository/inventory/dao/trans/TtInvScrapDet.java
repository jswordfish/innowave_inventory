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
 * TtInvScrapDet  
 */
@Entity
@Table(name = "tt_inv_scrap_det", schema = "inventory")
public class TtInvScrapDet implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3650571519176607427L;
	private long scrapDetId;
	private TmCmLookupDet tmCmLookupDet;
	private TmUlb tmUlb;
	private TmInvMaterial tmInvMaterial;
	private TtInvScrap ttInvScrap;
	private long lotNo;
	private BigDecimal balQty;
	private BigDecimal unitRate;
	private BigDecimal balQtyValue;
	private BigDecimal scrapQty;
	private BigDecimal scrapValue;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;

	public TtInvScrapDet() {
	}

	public TtInvScrapDet(long scrapDetId, TmUlb tmUlb, TmInvMaterial tmInvMaterial, TtInvScrap ttInvScrap, long lotNo,
			Date createdDate) {
		this.scrapDetId = scrapDetId;
		this.tmUlb = tmUlb;
		this.tmInvMaterial = tmInvMaterial;
		this.ttInvScrap = ttInvScrap;
		this.lotNo = lotNo;
		this.createdDate = createdDate;
	}

	public TtInvScrapDet(long scrapDetId, TmCmLookupDet tmCmLookupDet, TmUlb tmUlb, TmInvMaterial tmInvMaterial,
			TtInvScrap ttInvScrap, long lotNo, BigDecimal balQty, BigDecimal unitRate, BigDecimal balQtyValue,
			BigDecimal scrapQty, BigDecimal scrapValue, Integer createdBy, Date createdDate, Integer updatedBy,
			Date updatedDate, String macId, String ipAddress, String deviceFrom) {
		this.scrapDetId = scrapDetId;
		this.tmCmLookupDet = tmCmLookupDet;
		this.tmUlb = tmUlb;
		this.tmInvMaterial = tmInvMaterial;
		this.ttInvScrap = ttInvScrap;
		this.lotNo = lotNo;
		this.balQty = balQty;
		this.unitRate = unitRate;
		this.balQtyValue = balQtyValue;
		this.scrapQty = scrapQty;
		this.scrapValue = scrapValue;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
	}

	@Id

	@Column(name = "scrap_det_id", unique = true, nullable = false)
	public long getScrapDetId() {
		return this.scrapDetId;
	}

	public void setScrapDetId(long scrapDetId) {
		this.scrapDetId = scrapDetId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lookup_det_id_scrap_reason")
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
	@JoinColumn(name = "scrap_id", nullable = false)
	public TtInvScrap getTtInvScrap() {
		return this.ttInvScrap;
	}

	public void setTtInvScrap(TtInvScrap ttInvScrap) {
		this.ttInvScrap = ttInvScrap;
	}

	@Column(name = "lot_no", nullable = false)
	public long getLotNo() {
		return this.lotNo;
	}

	public void setLotNo(long lotNo) {
		this.lotNo = lotNo;
	}

	@Column(name = "bal_qty", precision = 12, scale = 3)
	public BigDecimal getBalQty() {
		return this.balQty;
	}

	public void setBalQty(BigDecimal balQty) {
		this.balQty = balQty;
	}

	@Column(name = "unit_rate", precision = 12)
	public BigDecimal getUnitRate() {
		return this.unitRate;
	}

	public void setUnitRate(BigDecimal unitRate) {
		this.unitRate = unitRate;
	}

	@Column(name = "bal_qty_value", precision = 12)
	public BigDecimal getBalQtyValue() {
		return this.balQtyValue;
	}

	public void setBalQtyValue(BigDecimal balQtyValue) {
		this.balQtyValue = balQtyValue;
	}

	@Column(name = "scrap_qty", precision = 12, scale = 3)
	public BigDecimal getScrapQty() {
		return this.scrapQty;
	}

	public void setScrapQty(BigDecimal scrapQty) {
		this.scrapQty = scrapQty;
	}

	@Column(name = "scrap_value", precision = 12)
	public BigDecimal getScrapValue() {
		return this.scrapValue;
	}

	public void setScrapValue(BigDecimal scrapValue) {
		this.scrapValue = scrapValue;
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
