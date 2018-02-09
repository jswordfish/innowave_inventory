package com.innowave.mahaulb.repository.inventory.dao.master;
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
import com.innowave.mahaulb.repository.inventory.dao.trans.TtInvMrn;
import com.innowave.mahaulb.repository.inventory.dao.trans.TtInvRateContract;

/**
 * TmInvSupplier  
 */
@Entity
@Table(name = "tm_inv_supplier", schema = "inventory")
public class TmInvSupplier implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4979041695062813842L;
	private long supplierId;
	private TmCmLookupDet tmCmLookupDet;
	private TmUlb tmUlb;
	private TmInvSupplier tmInvSupplier;
	private String supplierCode;
	private String supplierName;
	private String supplierParentCode;
	private String supplierAdderss;
	private String contactPersonName;
	private String contactNo;
	private String emailId;
	private String website;
	private String tinNo;
	private String panNo;
	private String cstNo;
	private String vatNo;
	private String gstNo;
	private String bankName;
	private String bankAccountNo;
	private String bankIfscCode;
	private String micrCode;
	private Integer status;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;
	private Set<TtInvMrn> ttInvMrns = new HashSet<TtInvMrn>(0);
	private Set<TmInvSupplier> tmInvSuppliers = new HashSet<TmInvSupplier>(0);
	private Set<TtInvRateContract> ttInvRateContracts = new HashSet<TtInvRateContract>(0);

	public TmInvSupplier() {
	}

	public TmInvSupplier(long supplierId, TmCmLookupDet tmCmLookupDet, TmUlb tmUlb, String supplierCode,
			String supplierName, String supplierAdderss, Date createdDate) {
		this.supplierId = supplierId;
		this.tmCmLookupDet = tmCmLookupDet;
		this.tmUlb = tmUlb;
		this.supplierCode = supplierCode;
		this.supplierName = supplierName;
		this.supplierAdderss = supplierAdderss;
		this.createdDate = createdDate;
	}

	public TmInvSupplier(long supplierId, TmCmLookupDet tmCmLookupDet, TmUlb tmUlb, TmInvSupplier tmInvSupplier,
			String supplierCode, String supplierName, String supplierParentCode, String supplierAdderss,
			String contactPersonName, String contactNo, String emailId, String website, String tinNo, String panNo,
			String cstNo, String vatNo, String gstNo, String bankName, String bankAccountNo, String bankIfscCode,
			String micrCode, Integer status, Integer createdBy, Date createdDate, Integer updatedBy, Date updatedDate,
			String macId, String ipAddress, String deviceFrom, Set<TtInvMrn> ttInvMrns,
			Set<TmInvSupplier> tmInvSuppliers, Set<TtInvRateContract> ttInvRateContracts) {
		this.supplierId = supplierId;
		this.tmCmLookupDet = tmCmLookupDet;
		this.tmUlb = tmUlb;
		this.tmInvSupplier = tmInvSupplier;
		this.supplierCode = supplierCode;
		this.supplierName = supplierName;
		this.supplierParentCode = supplierParentCode;
		this.supplierAdderss = supplierAdderss;
		this.contactPersonName = contactPersonName;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.website = website;
		this.tinNo = tinNo;
		this.panNo = panNo;
		this.cstNo = cstNo;
		this.vatNo = vatNo;
		this.gstNo = gstNo;
		this.bankName = bankName;
		this.bankAccountNo = bankAccountNo;
		this.bankIfscCode = bankIfscCode;
		this.micrCode = micrCode;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
		this.ttInvMrns = ttInvMrns;
		this.tmInvSuppliers = tmInvSuppliers;
		this.ttInvRateContracts = ttInvRateContracts;
	}

	@Id

	@Column(name = "supplier_id", unique = true, nullable = false)
	public long getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lookup_det_id_supp_type", nullable = false)
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
	@JoinColumn(name = "supplier_parent_id")
	public TmInvSupplier getTmInvSupplier() {
		return this.tmInvSupplier;
	}

	public void setTmInvSupplier(TmInvSupplier tmInvSupplier) {
		this.tmInvSupplier = tmInvSupplier;
	}

	@Column(name = "supplier_code", nullable = false, length = 20)
	public String getSupplierCode() {
		return this.supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	@Column(name = "supplier_name", nullable = false, length = 200)
	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Column(name = "supplier_parent_code", length = 20)
	public String getSupplierParentCode() {
		return this.supplierParentCode;
	}

	public void setSupplierParentCode(String supplierParentCode) {
		this.supplierParentCode = supplierParentCode;
	}

	@Column(name = "supplier_adderss", nullable = false, length = 1000)
	public String getSupplierAdderss() {
		return this.supplierAdderss;
	}

	public void setSupplierAdderss(String supplierAdderss) {
		this.supplierAdderss = supplierAdderss;
	}

	@Column(name = "contact_person_name", length = 200)
	public String getContactPersonName() {
		return this.contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	@Column(name = "contact_no", length = 50)
	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Column(name = "email_id", length = 200)
	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "website", length = 200)
	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Column(name = "tin_no", length = 50)
	public String getTinNo() {
		return this.tinNo;
	}

	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}

	@Column(name = "pan_no", length = 50)
	public String getPanNo() {
		return this.panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	@Column(name = "cst_no", length = 50)
	public String getCstNo() {
		return this.cstNo;
	}

	public void setCstNo(String cstNo) {
		this.cstNo = cstNo;
	}

	@Column(name = "vat_no", length = 50)
	public String getVatNo() {
		return this.vatNo;
	}

	public void setVatNo(String vatNo) {
		this.vatNo = vatNo;
	}

	@Column(name = "gst_no", length = 50)
	public String getGstNo() {
		return this.gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	@Column(name = "bank_name", length = 50)
	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Column(name = "bank_account_no", length = 50)
	public String getBankAccountNo() {
		return this.bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	@Column(name = "bank_ifsc_code", length = 20)
	public String getBankIfscCode() {
		return this.bankIfscCode;
	}

	public void setBankIfscCode(String bankIfscCode) {
		this.bankIfscCode = bankIfscCode;
	}

	@Column(name = "micr_code", length = 20)
	public String getMicrCode() {
		return this.micrCode;
	}

	public void setMicrCode(String micrCode) {
		this.micrCode = micrCode;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tmInvSupplier")
	public Set<TtInvMrn> getTtInvMrns() {
		return this.ttInvMrns;
	}

	public void setTtInvMrns(Set<TtInvMrn> ttInvMrns) {
		this.ttInvMrns = ttInvMrns;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tmInvSupplier")
	public Set<TmInvSupplier> getTmInvSuppliers() {
		return this.tmInvSuppliers;
	}

	public void setTmInvSuppliers(Set<TmInvSupplier> tmInvSuppliers) {
		this.tmInvSuppliers = tmInvSuppliers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tmInvSupplier")
	public Set<TtInvRateContract> getTtInvRateContracts() {
		return this.ttInvRateContracts;
	}

	public void setTtInvRateContracts(Set<TtInvRateContract> ttInvRateContracts) {
		this.ttInvRateContracts = ttInvRateContracts;
	}

}
