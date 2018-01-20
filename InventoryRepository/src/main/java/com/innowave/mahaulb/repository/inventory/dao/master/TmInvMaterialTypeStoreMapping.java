package com.innowave.mahaulb.repository.inventory.dao.master;
// Generated Jan 17, 2018 4:05:03 PM 

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

/**
 * TmInvMaterialTypeStoreMapping
 */
@Entity
@Table(name = "tm_inv_material_type_store_mapping", schema = "inventory")
public class TmInvMaterialTypeStoreMapping implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -497882699301495372L;
	private long materialTypeStoreMapId;
	private TmUlb tmUlb;
	private TmInvMaterialType tmInvMaterialType;
	private TmInvStore tmInvStore;
	private Long accountCode;
	private Integer status;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;

	public TmInvMaterialTypeStoreMapping() {
	}

	public TmInvMaterialTypeStoreMapping(long materialTypeStoreMapId, TmUlb tmUlb, TmInvMaterialType tmInvMaterialType,
			TmInvStore tmInvStore, Date createdDate) {
		this.materialTypeStoreMapId = materialTypeStoreMapId;
		this.tmUlb = tmUlb;
		this.tmInvMaterialType = tmInvMaterialType;
		this.tmInvStore = tmInvStore;
		this.createdDate = createdDate;
	}

	public TmInvMaterialTypeStoreMapping(long materialTypeStoreMapId, TmUlb tmUlb, TmInvMaterialType tmInvMaterialType,
			TmInvStore tmInvStore, Long accountCode, Integer status, Integer createdBy, Date createdDate,
			Integer updatedBy, Date updatedDate, String macId, String ipAddress, String deviceFrom) {
		this.materialTypeStoreMapId = materialTypeStoreMapId;
		this.tmUlb = tmUlb;
		this.tmInvMaterialType = tmInvMaterialType;
		this.tmInvStore = tmInvStore;
		this.accountCode = accountCode;
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

	@Column(name = "material_type_store_map_id", unique = true, nullable = false)
	public long getMaterialTypeStoreMapId() {
		return this.materialTypeStoreMapId;
	}

	public void setMaterialTypeStoreMapId(long materialTypeStoreMapId) {
		this.materialTypeStoreMapId = materialTypeStoreMapId;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id", nullable = false)
	public TmInvStore getTmInvStore() {
		return this.tmInvStore;
	}

	public void setTmInvStore(TmInvStore tmInvStore) {
		this.tmInvStore = tmInvStore;
	}

	@Column(name = "account_code")
	public Long getAccountCode() {
		return this.accountCode;
	}

	public void setAccountCode(Long accountCode) {
		this.accountCode = accountCode;
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
