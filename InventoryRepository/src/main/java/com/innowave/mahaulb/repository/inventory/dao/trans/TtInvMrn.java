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
 * TtInvMrn  
 */
@Entity
@Table(name = "tt_inv_mrn", schema = "inventory")
public class TtInvMrn implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 490275981080312492L;
	private long mrnId;
	private TmCmLookupDet tmCmLookupDet;
	private TmUlb tmUlb;
	private TmInvSupplier tmInvSupplier;
	private String mrnNo;
	private Date mrnDate;
	private String supplierBillNo;
	private Date supplierBillDate;
	private String challanNo;
	private Date challanDate;
	private String remark;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;
	private Set<TtInvMrnDet> ttInvMrnDets = new HashSet<TtInvMrnDet>(0);
	private Set<TtInvMrnInsp> ttInvMrnInsps = new HashSet<TtInvMrnInsp>(0);

	public TtInvMrn() {
	}

	public TtInvMrn(long mrnId, TmCmLookupDet tmCmLookupDet, TmUlb tmUlb, TmInvSupplier tmInvSupplier, String mrnNo,
			Date mrnDate, Date createdDate) {
		this.mrnId = mrnId;
		this.tmCmLookupDet = tmCmLookupDet;
		this.tmUlb = tmUlb;
		this.tmInvSupplier = tmInvSupplier;
		this.mrnNo = mrnNo;
		this.mrnDate = mrnDate;
		this.createdDate = createdDate;
	}

	public TtInvMrn(long mrnId, TmCmLookupDet tmCmLookupDet, TmUlb tmUlb, TmInvSupplier tmInvSupplier, String mrnNo,
			Date mrnDate, String supplierBillNo, Date supplierBillDate, String challanNo, Date challanDate,
			String remark, Integer createdBy, Date createdDate, Integer updatedBy, Date updatedDate, String macId,
			String ipAddress, String deviceFrom, Set<TtInvMrnDet> ttInvMrnDets, Set<TtInvMrnInsp> ttInvMrnInsps) {
		this.mrnId = mrnId;
		this.tmCmLookupDet = tmCmLookupDet;
		this.tmUlb = tmUlb;
		this.tmInvSupplier = tmInvSupplier;
		this.mrnNo = mrnNo;
		this.mrnDate = mrnDate;
		this.supplierBillNo = supplierBillNo;
		this.supplierBillDate = supplierBillDate;
		this.challanNo = challanNo;
		this.challanDate = challanDate;
		this.remark = remark;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
		this.ttInvMrnDets = ttInvMrnDets;
		this.ttInvMrnInsps = ttInvMrnInsps;
	}

	@Id

	@Column(name = "mrn_id", unique = true, nullable = false)
	public long getMrnId() {
		return this.mrnId;
	}

	public void setMrnId(long mrnId) {
		this.mrnId = mrnId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lookup_det_id_receipt_type", nullable = false)
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

	@Column(name = "mrn_no", nullable = false, length = 20)
	public String getMrnNo() {
		return this.mrnNo;
	}

	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "mrn_date", nullable = false, length = 13)
	public Date getMrnDate() {
		return this.mrnDate;
	}

	public void setMrnDate(Date mrnDate) {
		this.mrnDate = mrnDate;
	}

	@Column(name = "supplier_bill_no", length = 30)
	public String getSupplierBillNo() {
		return this.supplierBillNo;
	}

	public void setSupplierBillNo(String supplierBillNo) {
		this.supplierBillNo = supplierBillNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "supplier_bill_date", length = 13)
	public Date getSupplierBillDate() {
		return this.supplierBillDate;
	}

	public void setSupplierBillDate(Date supplierBillDate) {
		this.supplierBillDate = supplierBillDate;
	}

	@Column(name = "challan_no", length = 30)
	public String getChallanNo() {
		return this.challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "challan_date", length = 13)
	public Date getChallanDate() {
		return this.challanDate;
	}

	public void setChallanDate(Date challanDate) {
		this.challanDate = challanDate;
	}

	@Column(name = "remark", length = 1000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ttInvMrn")
	public Set<TtInvMrnDet> getTtInvMrnDets() {
		return this.ttInvMrnDets;
	}

	public void setTtInvMrnDets(Set<TtInvMrnDet> ttInvMrnDets) {
		this.ttInvMrnDets = ttInvMrnDets;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ttInvMrn")
	public Set<TtInvMrnInsp> getTtInvMrnInsps() {
		return this.ttInvMrnInsps;
	}

	public void setTtInvMrnInsps(Set<TtInvMrnInsp> ttInvMrnInsps) {
		this.ttInvMrnInsps = ttInvMrnInsps;
	}

}
