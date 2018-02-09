package com.innowave.mahaulb.repository.inventory.dao.trans;
// Generated Jan 31, 2018 2:32:46 PM  

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
 * TtInvRateContract  
 */
@Entity
@Table(name = "tt_inv_rate_contract", schema = "inventory")
public class TtInvRateContract implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1113830798956278020L;
	private long rateContractId;
	private TmCmLookupDet tmCmLookupDet;
	private TmUlb tmUlb;
	private TmInvSupplier tmInvSupplier;
	private String rateContractQuotNo;
	private Date rateContractQuotDate;
	private String agreementNo;
	private Date agreementDate;
	private Date agreementStartDate;
	private Date agreementEndDate;
	private int status;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;
	private Set<TtInvRateContractDet> ttInvRateContractDets = new HashSet<TtInvRateContractDet>(0);

	public TtInvRateContract() {
	}

	public TtInvRateContract(long rateContractId, TmCmLookupDet tmCmLookupDet, TmUlb tmUlb, TmInvSupplier tmInvSupplier,
			String rateContractQuotNo, Date rateContractQuotDate, String agreementNo, Date agreementDate,
			Date agreementStartDate, Date agreementEndDate, int status, Date createdDate) {
		this.rateContractId = rateContractId;
		this.tmCmLookupDet = tmCmLookupDet;
		this.tmUlb = tmUlb;
		this.tmInvSupplier = tmInvSupplier;
		this.rateContractQuotNo = rateContractQuotNo;
		this.rateContractQuotDate = rateContractQuotDate;
		this.agreementNo = agreementNo;
		this.agreementDate = agreementDate;
		this.agreementStartDate = agreementStartDate;
		this.agreementEndDate = agreementEndDate;
		this.status = status;
		this.createdDate = createdDate;
	}

	public TtInvRateContract(long rateContractId, TmCmLookupDet tmCmLookupDet, TmUlb tmUlb, TmInvSupplier tmInvSupplier,
			String rateContractQuotNo, Date rateContractQuotDate, String agreementNo, Date agreementDate,
			Date agreementStartDate, Date agreementEndDate, int status, Integer createdBy, Date createdDate,
			Integer updatedBy, Date updatedDate, String macId, String ipAddress, String deviceFrom,
			Set<TtInvRateContractDet> ttInvRateContractDets) {
		this.rateContractId = rateContractId;
		this.tmCmLookupDet = tmCmLookupDet;
		this.tmUlb = tmUlb;
		this.tmInvSupplier = tmInvSupplier;
		this.rateContractQuotNo = rateContractQuotNo;
		this.rateContractQuotDate = rateContractQuotDate;
		this.agreementNo = agreementNo;
		this.agreementDate = agreementDate;
		this.agreementStartDate = agreementStartDate;
		this.agreementEndDate = agreementEndDate;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
		this.ttInvRateContractDets = ttInvRateContractDets;
	}

	@Id

	@Column(name = "rate_contract_id", unique = true, nullable = false)
	public long getRateContractId() {
		return this.rateContractId;
	}

	public void setRateContractId(long rateContractId) {
		this.rateContractId = rateContractId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lookup_det_id_rate_type", nullable = false)
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
	@JoinColumn(name = "supplier_id", nullable = false)
	public TmInvSupplier getTmInvSupplier() {
		return this.tmInvSupplier;
	}

	public void setTmInvSupplier(TmInvSupplier tmInvSupplier) {
		this.tmInvSupplier = tmInvSupplier;
	}

	@Column(name = "rate_contract_quot_no", nullable = false, length = 50)
	public String getRateContractQuotNo() {
		return this.rateContractQuotNo;
	}

	public void setRateContractQuotNo(String rateContractQuotNo) {
		this.rateContractQuotNo = rateContractQuotNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "rate_contract_quot_date", nullable = false, length = 13)
	public Date getRateContractQuotDate() {
		return this.rateContractQuotDate;
	}

	public void setRateContractQuotDate(Date rateContractQuotDate) {
		this.rateContractQuotDate = rateContractQuotDate;
	}

	@Column(name = "agreement_no", nullable = false, length = 50)
	public String getAgreementNo() {
		return this.agreementNo;
	}

	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "agreement_date", nullable = false, length = 13)
	public Date getAgreementDate() {
		return this.agreementDate;
	}

	public void setAgreementDate(Date agreementDate) {
		this.agreementDate = agreementDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "agreement_start_date", nullable = false, length = 13)
	public Date getAgreementStartDate() {
		return this.agreementStartDate;
	}

	public void setAgreementStartDate(Date agreementStartDate) {
		this.agreementStartDate = agreementStartDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "agreement_end_date", nullable = false, length = 13)
	public Date getAgreementEndDate() {
		return this.agreementEndDate;
	}

	public void setAgreementEndDate(Date agreementEndDate) {
		this.agreementEndDate = agreementEndDate;
	}

	@Column(name = "status", nullable = false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ttInvRateContract")
	public Set<TtInvRateContractDet> getTtInvRateContractDets() {
		return this.ttInvRateContractDets;
	}

	public void setTtInvRateContractDets(Set<TtInvRateContractDet> ttInvRateContractDets) {
		this.ttInvRateContractDets = ttInvRateContractDets;
	}

}
