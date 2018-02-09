package com.innowave.mahaulb.repository.inventory.dao.master;
// Generated Jan 17, 2018 4:05:03 PM 
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.innowave.mahaulb.common.dao.TmUlb;

/**
 * TmInvStore
 */
@Entity
@Table(name = "tm_inv_store", schema = "inventory")
public class TmInvStore implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6234690236073560671L;
	private long storeId;
	private TmUlb tmUlb;
	private String storeCode;
	private String storeName;
	private String storeDesc;
	private int depId;
	private String centralStoreYn;
	private String billingAdd;
	private String deliveryAdd;
	private String storeIncharge;
	private String contactNo1;
	private String contactNo2;
	private String emailId;
	private Integer status;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;
	private Set<TmInvMaterialTypeStoreMapping> tmInvMaterialTypeStoreMappings = new HashSet<TmInvMaterialTypeStoreMapping>(
			0);

	public TmInvStore() {
	}

	public TmInvStore(long storeId, TmUlb tmUlb, String storeCode, String storeName, String storeDesc, int depId,
			Date createdDate) {
		this.storeId = storeId;
		this.tmUlb = tmUlb;
		this.storeCode = storeCode;
		this.storeName = storeName;
		this.storeDesc = storeDesc;
		this.depId = depId;
		this.createdDate = createdDate;
	}

	public TmInvStore(long storeId, TmUlb tmUlb, String storeCode, String storeName, String storeDesc, int depId,
			String centralStoreYn, String billingAdd, String deliveryAdd, String storeIncharge, String contactNo1,
			String contactNo2, String emailId, Integer status, Integer createdBy, Date createdDate, Integer updatedBy,
			Date updatedDate, String macId, String ipAddress, String deviceFrom,
			Set<TmInvMaterialTypeStoreMapping> tmInvMaterialTypeStoreMappings) {
		this.storeId = storeId;
		this.tmUlb = tmUlb;
		this.storeCode = storeCode;
		this.storeName = storeName;
		this.storeDesc = storeDesc;
		this.depId = depId;
		this.centralStoreYn = centralStoreYn;
		this.billingAdd = billingAdd;
		this.deliveryAdd = deliveryAdd;
		this.storeIncharge = storeIncharge;
		this.contactNo1 = contactNo1;
		this.contactNo2 = contactNo2;
		this.emailId = emailId;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
		this.tmInvMaterialTypeStoreMappings = tmInvMaterialTypeStoreMappings;
	}
	

	@Id
	@SequenceGenerator(name="sq_inv_store_id", sequenceName = "inventory.sq_inv_store_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sq_inv_store_id")
	@Column(name = "store_id", unique = true, nullable = false)
	public long getStoreId() {
		return this.storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ulb_id", nullable = false)
	public TmUlb getTmUlb() {
		return this.tmUlb;
	}

	public void setTmUlb(TmUlb tmUlb) {
		this.tmUlb = tmUlb;
	}

	@Column(name = "store_code", nullable = false, length = 20)
	public String getStoreCode() {
		return this.storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	@Column(name = "store_name", nullable = false, length = 200)
	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	@Column(name = "store_desc", nullable = false, length = 1000)
	public String getStoreDesc() {
		return this.storeDesc;
	}

	public void setStoreDesc(String storeDesc) {
		this.storeDesc = storeDesc;
	}

	@Column(name = "dep_id", nullable = false)
	public int getDepId() {
		return this.depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	@Column(name = "central_store_yn", length = 1)
	public String getCentralStoreYn() {
		return this.centralStoreYn;
	}

	public void setCentralStoreYn(String centralStoreYn) {
		this.centralStoreYn = centralStoreYn;
	}

	@Column(name = "billing_add", length = 1000)
	public String getBillingAdd() {
		return this.billingAdd;
	}

	public void setBillingAdd(String billingAdd) {
		this.billingAdd = billingAdd;
	}

	@Column(name = "delivery_add", length = 1000)
	public String getDeliveryAdd() {
		return this.deliveryAdd;
	}

	public void setDeliveryAdd(String deliveryAdd) {
		this.deliveryAdd = deliveryAdd;
	}

	@Column(name = "store_incharge", length = 200)
	public String getStoreIncharge() {
		return this.storeIncharge;
	}

	public void setStoreIncharge(String storeIncharge) {
		this.storeIncharge = storeIncharge;
	}

	@Column(name = "contact_no_1", length = 50)
	public String getContactNo1() {
		return this.contactNo1;
	}

	public void setContactNo1(String contactNo1) {
		this.contactNo1 = contactNo1;
	}

	@Column(name = "contact_no_2", length = 50)
	public String getContactNo2() {
		return this.contactNo2;
	}

	public void setContactNo2(String contactNo2) {
		this.contactNo2 = contactNo2;
	}

	@Column(name = "email_id", length = 200)
	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tmInvStore")
	public Set<TmInvMaterialTypeStoreMapping> getTmInvMaterialTypeStoreMappings() {
		return this.tmInvMaterialTypeStoreMappings;
	}

	public void setTmInvMaterialTypeStoreMappings(Set<TmInvMaterialTypeStoreMapping> tmInvMaterialTypeStoreMappings) {
		this.tmInvMaterialTypeStoreMappings = tmInvMaterialTypeStoreMappings;
	}

}
