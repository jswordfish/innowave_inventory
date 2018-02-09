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

/**
 * TtInvDisposalDet  
 */
@Entity
@Table(name = "tt_inv_disposal_det", schema = "inventory")
public class TtInvDisposalDet implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2407455633370576779L;
	private long disposalDetId;
	private TmUlb tmUlb;
	private TmInvMaterial tmInvMaterial;
	private TtInvDisposal ttInvDisposal;
	private long lotNo;
	private BigDecimal balQty;
	private BigDecimal unitRate;
	private BigDecimal value;
	private BigDecimal disposedQty;
	private BigDecimal disposedValue;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;

	public TtInvDisposalDet() {
	}

	public TtInvDisposalDet(long disposalDetId, TmUlb tmUlb, TmInvMaterial tmInvMaterial, TtInvDisposal ttInvDisposal,
			long lotNo, Date createdDate) {
		this.disposalDetId = disposalDetId;
		this.tmUlb = tmUlb;
		this.tmInvMaterial = tmInvMaterial;
		this.ttInvDisposal = ttInvDisposal;
		this.lotNo = lotNo;
		this.createdDate = createdDate;
	}

	public TtInvDisposalDet(long disposalDetId, TmUlb tmUlb, TmInvMaterial tmInvMaterial, TtInvDisposal ttInvDisposal,
			long lotNo, BigDecimal balQty, BigDecimal unitRate, BigDecimal value, BigDecimal disposedQty,
			BigDecimal disposedValue, Integer createdBy, Date createdDate, Integer updatedBy, Date updatedDate,
			String macId, String ipAddress, String deviceFrom) {
		this.disposalDetId = disposalDetId;
		this.tmUlb = tmUlb;
		this.tmInvMaterial = tmInvMaterial;
		this.ttInvDisposal = ttInvDisposal;
		this.lotNo = lotNo;
		this.balQty = balQty;
		this.unitRate = unitRate;
		this.value = value;
		this.disposedQty = disposedQty;
		this.disposedValue = disposedValue;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
	}

	@Id

	@Column(name = "disposal_det_id", unique = true, nullable = false)
	public long getDisposalDetId() {
		return this.disposalDetId;
	}

	public void setDisposalDetId(long disposalDetId) {
		this.disposalDetId = disposalDetId;
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
	@JoinColumn(name = "disposal_id", nullable = false)
	public TtInvDisposal getTtInvDisposal() {
		return this.ttInvDisposal;
	}

	public void setTtInvDisposal(TtInvDisposal ttInvDisposal) {
		this.ttInvDisposal = ttInvDisposal;
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

	@Column(name = "value", precision = 12)
	public BigDecimal getValue() {
		return this.value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Column(name = "disposed_qty", precision = 12, scale = 3)
	public BigDecimal getDisposedQty() {
		return this.disposedQty;
	}

	public void setDisposedQty(BigDecimal disposedQty) {
		this.disposedQty = disposedQty;
	}

	@Column(name = "disposed_value", precision = 12)
	public BigDecimal getDisposedValue() {
		return this.disposedValue;
	}

	public void setDisposedValue(BigDecimal disposedValue) {
		this.disposedValue = disposedValue;
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
