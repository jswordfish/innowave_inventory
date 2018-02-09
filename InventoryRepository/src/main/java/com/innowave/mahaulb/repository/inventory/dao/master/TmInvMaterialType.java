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
 * TmInvMaterialType 
 */
@Entity
@Table(name = "tm_inv_material_type", schema = "inventory")
public class TmInvMaterialType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5102395880800231986L;
	private long materialTypeId;
	private TmUlb tmUlb;
	private TmInvMaterialType tmInvMaterialType;
	private String materialTypeCode;
	private String materialTypeName;
	private String materialTypeDesc;
	private String parentTypeYn;
	private Integer status;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;
	private Set<TmInvMaterial> tmInvMaterials = new HashSet<TmInvMaterial>(0);
	private Set<TmInvMaterialType> tmInvMaterialTypes = new HashSet<TmInvMaterialType>(0);
	private Set<TmInvMaterialTypeStoreMapping> tmInvMaterialTypeStoreMappings = new HashSet<TmInvMaterialTypeStoreMapping>(
			0);

	public TmInvMaterialType() {
	}

	public TmInvMaterialType(long materialTypeId, TmUlb tmUlb, String materialTypeCode, String materialTypeName,
			Date createdDate) {
		this.materialTypeId = materialTypeId;
		this.tmUlb = tmUlb;
		this.materialTypeCode = materialTypeCode;
		this.materialTypeName = materialTypeName;
		this.createdDate = createdDate;
	}

	public TmInvMaterialType(long materialTypeId, TmUlb tmUlb, TmInvMaterialType tmInvMaterialType,
			String materialTypeCode, String materialTypeName, String materialTypeDesc, String parentTypeYn,
			Integer status, Integer createdBy, Date createdDate, Integer updatedBy, Date updatedDate, String macId,
			String ipAddress, String deviceFrom, Set<TmInvMaterial> tmInvMaterials,
			Set<TmInvMaterialType> tmInvMaterialTypes,
			Set<TmInvMaterialTypeStoreMapping> tmInvMaterialTypeStoreMappings) {
		this.materialTypeId = materialTypeId;
		this.tmUlb = tmUlb;
		this.tmInvMaterialType = tmInvMaterialType;
		this.materialTypeCode = materialTypeCode;
		this.materialTypeName = materialTypeName;
		this.materialTypeDesc = materialTypeDesc;
		this.parentTypeYn = parentTypeYn;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
		this.tmInvMaterials = tmInvMaterials;
		this.tmInvMaterialTypes = tmInvMaterialTypes;
		this.tmInvMaterialTypeStoreMappings = tmInvMaterialTypeStoreMappings;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="inventory.sq_inv_material_type_id")
	@SequenceGenerator(name="inventory.sq_inv_material_type_id", sequenceName = "inventory.sq_inv_material_type_id", allocationSize = 1)
	@Column(name = "material_type_id", unique = true, nullable = false)
	public long getMaterialTypeId() {
		return this.materialTypeId;
	}

	public void setMaterialTypeId(long materialTypeId) {
		this.materialTypeId = materialTypeId;
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
	@JoinColumn(name = "parent_material_type_id")
	public TmInvMaterialType getTmInvMaterialType() {
		return this.tmInvMaterialType;
	}

	public void setTmInvMaterialType(TmInvMaterialType tmInvMaterialType) {
		this.tmInvMaterialType = tmInvMaterialType;
	}

	@Column(name = "material_type_code", nullable = false, length = 20)
	public String getMaterialTypeCode() {
		return this.materialTypeCode;
	}

	public void setMaterialTypeCode(String materialTypeCode) {
		this.materialTypeCode = materialTypeCode;
	}

	@Column(name = "material_type_name", nullable = false, length = 200)
	public String getMaterialTypeName() {
		return this.materialTypeName;
	}

	public void setMaterialTypeName(String materialTypeName) {
		this.materialTypeName = materialTypeName;
	}

	@Column(name = "material_type_desc", length = 1000)
	public String getMaterialTypeDesc() {
		return this.materialTypeDesc;
	}

	public void setMaterialTypeDesc(String materialTypeDesc) {
		this.materialTypeDesc = materialTypeDesc;
	}

	@Column(name = "parent_type_yn", length = 1)
	public String getParentTypeYn() {
		return this.parentTypeYn;
	}

	public void setParentTypeYn(String parentTypeYn) {
		this.parentTypeYn = parentTypeYn;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tmInvMaterialType")
	public Set<TmInvMaterial> getTmInvMaterials() {
		return this.tmInvMaterials;
	}

	public void setTmInvMaterials(Set<TmInvMaterial> tmInvMaterials) {
		this.tmInvMaterials = tmInvMaterials;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tmInvMaterialType")
	public Set<TmInvMaterialType> getTmInvMaterialTypes() {
		return this.tmInvMaterialTypes;
	}

	public void setTmInvMaterialTypes(Set<TmInvMaterialType> tmInvMaterialTypes) {
		this.tmInvMaterialTypes = tmInvMaterialTypes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tmInvMaterialType")
	public Set<TmInvMaterialTypeStoreMapping> getTmInvMaterialTypeStoreMappings() {
		return this.tmInvMaterialTypeStoreMappings;
	}

	public void setTmInvMaterialTypeStoreMappings(Set<TmInvMaterialTypeStoreMapping> tmInvMaterialTypeStoreMappings) {
		this.tmInvMaterialTypeStoreMappings = tmInvMaterialTypeStoreMappings;
	}

}
