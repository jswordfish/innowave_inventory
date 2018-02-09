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
 * TtInvRateContractDet 
 */
@Entity
@Table(name = "tt_inv_rate_contract_det", schema = "inventory")
public class TtInvRateContractDet implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5911505626544690865L;
	private long rateContractDetId;
	private TmCmLookupDet tmCmLookupDet;
	private TmUlb tmUlb;
	private TmInvMaterial tmInvMaterial;
	private TtInvRateContract ttInvRateContract;
	private BigDecimal rate;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;

	public TtInvRateContractDet() {
	}

	public TtInvRateContractDet(long rateContractDetId, TmUlb tmUlb, TmInvMaterial tmInvMaterial,
			TtInvRateContract ttInvRateContract, Date createdDate) {
		this.rateContractDetId = rateContractDetId;
		this.tmUlb = tmUlb;
		this.tmInvMaterial = tmInvMaterial;
		this.ttInvRateContract = ttInvRateContract;
		this.createdDate = createdDate;
	}

	public TtInvRateContractDet(long rateContractDetId, TmCmLookupDet tmCmLookupDet, TmUlb tmUlb,
			TmInvMaterial tmInvMaterial, TtInvRateContract ttInvRateContract, BigDecimal rate, Integer createdBy,
			Date createdDate, Integer updatedBy, Date updatedDate, String macId, String ipAddress, String deviceFrom) {
		this.rateContractDetId = rateContractDetId;
		this.tmCmLookupDet = tmCmLookupDet;
		this.tmUlb = tmUlb;
		this.tmInvMaterial = tmInvMaterial;
		this.ttInvRateContract = ttInvRateContract;
		this.rate = rate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
	}

	@Id

	@Column(name = "rate_contract_det_id", unique = true, nullable = false)
	public long getRateContractDetId() {
		return this.rateContractDetId;
	}

	public void setRateContractDetId(long rateContractDetId) {
		this.rateContractDetId = rateContractDetId;
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
	@JoinColumn(name = "rate_contract_id", nullable = false)
	public TtInvRateContract getTtInvRateContract() {
		return this.ttInvRateContract;
	}

	public void setTtInvRateContract(TtInvRateContract ttInvRateContract) {
		this.ttInvRateContract = ttInvRateContract;
	}

	@Column(name = "rate", precision = 12)
	public BigDecimal getRate() {
		return this.rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
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
