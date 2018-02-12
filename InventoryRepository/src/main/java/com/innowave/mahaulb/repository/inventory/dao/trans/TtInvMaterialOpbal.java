package com.innowave.mahaulb.repository.inventory.dao.trans;
// Generated Jan 31, 2018 2:32:46 PM 

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.innowave.mahaulb.common.dao.TmCmFinancialMas;
import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterial;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;

/**
 * TtInvMaterialOpbal
 */
@Entity
@Table(name = "tt_inv_material_opbal", schema = "inventory")
public class TtInvMaterialOpbal implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2621281582121459184L;
	private long matOpbalId;
	
	
	private TmCmFinancialMas tmCmFinancialMas;
	private TmUlb tmUlb;
	private TmInvMaterial tmInvMaterial;
	private TmInvStore tmInvStore;
	private String materialName;
	private String storeCode;
	private String storeName;
	private BigDecimal openQty;
	private Date openQtyAsondate;
	private BigDecimal openRate;
	private Long lotNo;
	private Date expiryDate;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;

	public TtInvMaterialOpbal() {
	}

	public TtInvMaterialOpbal(long matOpbalId, TmCmFinancialMas tmCmFinancialMas, TmUlb tmUlb,
			TmInvMaterial tmInvMaterial, TmInvStore tmInvStore, String materialName, String storeCode, String storeName,
			Date createdDate) {
		this.matOpbalId = matOpbalId;
		this.tmCmFinancialMas = tmCmFinancialMas;
		this.tmUlb = tmUlb;
		this.tmInvMaterial = tmInvMaterial;
		this.tmInvStore = tmInvStore;
		this.materialName = materialName;
		this.storeCode = storeCode;
		this.storeName = storeName;
		this.createdDate = createdDate;
	}

	public TtInvMaterialOpbal(long matOpbalId, TmCmFinancialMas tmCmFinancialMas, TmUlb tmUlb,
			TmInvMaterial tmInvMaterial, TmInvStore tmInvStore, String materialName, String storeCode, String storeName,
			BigDecimal openQty, Date openQtyAsondate, BigDecimal openRate, Long lotNo, Date expiryDate,
			Integer createdBy, Date createdDate, Integer updatedBy, Date updatedDate, String macId, String ipAddress,
			String deviceFrom) {
		this.matOpbalId = matOpbalId;
		this.tmCmFinancialMas = tmCmFinancialMas;
		this.tmUlb = tmUlb;
		this.tmInvMaterial = tmInvMaterial;
		this.tmInvStore = tmInvStore;
		this.materialName = materialName;
		this.storeCode = storeCode;
		this.storeName = storeName;
		this.openQty = openQty;
		this.openQtyAsondate = openQtyAsondate;
		this.openRate = openRate;
		this.lotNo = lotNo;
		this.expiryDate = expiryDate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="inventory.sq_inv_mat_opbal_id")
	@SequenceGenerator(name="inventory.sq_inv_mat_opbal_id", sequenceName = "inventory.sq_inv_mat_opbal_id", allocationSize = 1)
	@Column(name = "mat_opbal_id", unique = true, nullable = false)
	public long getMatOpbalId() {
		return this.matOpbalId;
	}

	public void setMatOpbalId(long matOpbalId) {
		this.matOpbalId = matOpbalId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fin_id", nullable = false)
	public TmCmFinancialMas getTmCmFinancialMas() {
		return this.tmCmFinancialMas;
	}

	public void setTmCmFinancialMas(TmCmFinancialMas tmCmFinancialMas) {
		this.tmCmFinancialMas = tmCmFinancialMas;
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

	@Column(name = "store_name", nullable = false, length = 200)
	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	@Column(name = "open_qty", precision = 12, scale = 3)
	public BigDecimal getOpenQty() {
		return this.openQty;
	}

	public void setOpenQty(BigDecimal openQty) {
		this.openQty = openQty;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "open_qty_asondate", length = 13)
	public Date getOpenQtyAsondate() {
		return this.openQtyAsondate;
	}

	public void setOpenQtyAsondate(Date openQtyAsondate) {
		this.openQtyAsondate = openQtyAsondate;
	}

	@Column(name = "open_rate", precision = 12)
	public BigDecimal getOpenRate() {
		return this.openRate;
	}

	public void setOpenRate(BigDecimal openRate) {
		this.openRate = openRate;
	}

	@Column(name = "lot_no")
	public Long getLotNo() {
		return this.lotNo;
	}

	public void setLotNo(Long lotNo) {
		this.lotNo = lotNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "expiry_date", length = 13)
	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
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
