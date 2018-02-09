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
 * TtInvMrnDet  
 */
@Entity
@Table(name = "tt_inv_mrn_det", schema = "inventory")
public class TtInvMrnDet implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8245130875660441263L;
	private long mrnDetId;
	private TmCmLookupDet tmCmLookupDet;
	private TmUlb tmUlb;
	private TmInvMaterial tmInvMaterial;
	private TtInvMrn ttInvMrn;
	private String mrnNo;
	private Date mrnDate;
	private String poNo;
	private Date poDate;
	private String materialName;
	private BigDecimal poQty;
	private BigDecimal recdQty;
	private BigDecimal unitRate;
	private BigDecimal amount;
	private Long lotNo;
	private String serialNo;
	private String batchNo;
	private Date mfgDate;
	private Date expiryDate;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;

	public TtInvMrnDet() {
	}

	public TtInvMrnDet(long mrnDetId, TmUlb tmUlb, TmInvMaterial tmInvMaterial, TtInvMrn ttInvMrn, String mrnNo,
			Date mrnDate, String materialName, Date createdDate) {
		this.mrnDetId = mrnDetId;
		this.tmUlb = tmUlb;
		this.tmInvMaterial = tmInvMaterial;
		this.ttInvMrn = ttInvMrn;
		this.mrnNo = mrnNo;
		this.mrnDate = mrnDate;
		this.materialName = materialName;
		this.createdDate = createdDate;
	}

	public TtInvMrnDet(long mrnDetId, TmCmLookupDet tmCmLookupDet, TmUlb tmUlb, TmInvMaterial tmInvMaterial,
			TtInvMrn ttInvMrn, String mrnNo, Date mrnDate, String poNo, Date poDate, String materialName,
			BigDecimal poQty, BigDecimal recdQty, BigDecimal unitRate, BigDecimal amount, Long lotNo, String serialNo,
			String batchNo, Date mfgDate, Date expiryDate, Integer createdBy, Date createdDate, Integer updatedBy,
			Date updatedDate, String macId, String ipAddress, String deviceFrom) {
		this.mrnDetId = mrnDetId;
		this.tmCmLookupDet = tmCmLookupDet;
		this.tmUlb = tmUlb;
		this.tmInvMaterial = tmInvMaterial;
		this.ttInvMrn = ttInvMrn;
		this.mrnNo = mrnNo;
		this.mrnDate = mrnDate;
		this.poNo = poNo;
		this.poDate = poDate;
		this.materialName = materialName;
		this.poQty = poQty;
		this.recdQty = recdQty;
		this.unitRate = unitRate;
		this.amount = amount;
		this.lotNo = lotNo;
		this.serialNo = serialNo;
		this.batchNo = batchNo;
		this.mfgDate = mfgDate;
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

	@Column(name = "mrn_det_id", unique = true, nullable = false)
	public long getMrnDetId() {
		return this.mrnDetId;
	}

	public void setMrnDetId(long mrnDetId) {
		this.mrnDetId = mrnDetId;
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
	@JoinColumn(name = "mrn_id", nullable = false)
	public TtInvMrn getTtInvMrn() {
		return this.ttInvMrn;
	}

	public void setTtInvMrn(TtInvMrn ttInvMrn) {
		this.ttInvMrn = ttInvMrn;
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

	@Column(name = "po_no", length = 20)
	public String getPoNo() {
		return this.poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "po_date", length = 13)
	public Date getPoDate() {
		return this.poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	@Column(name = "material_name", nullable = false, length = 200)
	public String getMaterialName() {
		return this.materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	@Column(name = "po_qty", precision = 12, scale = 3)
	public BigDecimal getPoQty() {
		return this.poQty;
	}

	public void setPoQty(BigDecimal poQty) {
		this.poQty = poQty;
	}

	@Column(name = "recd_qty", precision = 12, scale = 3)
	public BigDecimal getRecdQty() {
		return this.recdQty;
	}

	public void setRecdQty(BigDecimal recdQty) {
		this.recdQty = recdQty;
	}

	@Column(name = "unit_rate", precision = 12)
	public BigDecimal getUnitRate() {
		return this.unitRate;
	}

	public void setUnitRate(BigDecimal unitRate) {
		this.unitRate = unitRate;
	}

	@Column(name = "amount", precision = 12)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name = "lot_no")
	public Long getLotNo() {
		return this.lotNo;
	}

	public void setLotNo(Long lotNo) {
		this.lotNo = lotNo;
	}

	@Column(name = "serial_no", length = 30)
	public String getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	@Column(name = "batch_no", length = 30)
	public String getBatchNo() {
		return this.batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "mfg_date", length = 13)
	public Date getMfgDate() {
		return this.mfgDate;
	}

	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
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
