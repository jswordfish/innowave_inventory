package com.innowave.mahaulb.repository.treecensus.dao.master;
// Generated Nov 14, 2017 8:11:19 PM  

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

/**
 * TmTreeMaster 
 */
@Entity
@Table(name = "tm_tree_master", schema = "treecensus")
public class TmTreeMaster implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3417555311036938724L;
	private int treeMasterId;
	private TmTreeNameMaster tmTreeNameMaster;
	private int ulbId;
	private String treeCode;
	private Integer treemasIdTsm;
	private Integer treemasIdLsm;
	private Integer treemasIdBsm;
	private Integer treemasIdTms;
	private Integer treemasIdLcm;
	private Integer treemasIdCom;
	private Integer treemasIdFnm;
	private Integer treemasIdFrm;
	private Integer treemasIdOdm;
	private Integer treemasIdSma;
	private Integer treemasIdTst;
	private Integer sizeValue;
	private int status;
	private int createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private Character deviceFrom;

	public TmTreeMaster() {
	}

	public TmTreeMaster(int treeMasterId, int ulbId, int status, int createdBy) {
		this.treeMasterId = treeMasterId;
		this.ulbId = ulbId;
		this.status = status;
		this.createdBy = createdBy;
	}

	public TmTreeMaster(int treeMasterId, TmTreeNameMaster tmTreeNameMaster, int ulbId, String treeCode,
			Integer treemasIdTsm, Integer treemasIdLsm, Integer treemasIdBsm, Integer treemasIdTms,
			Integer treemasIdLcm, Integer treemasIdCom, Integer treemasIdFnm, Integer treemasIdFrm,
			Integer treemasIdOdm, Integer treemasIdSma, Integer treemasIdTst, Integer sizeValue, int status,
			int createdBy, Date createdDate, Integer updatedBy, Date updatedDate, String macId, String ipAddress,
			Character deviceFrom) {
		this.treeMasterId = treeMasterId;
		this.tmTreeNameMaster = tmTreeNameMaster;
		this.ulbId = ulbId;
		this.treeCode = treeCode;
		this.treemasIdTsm = treemasIdTsm;
		this.treemasIdLsm = treemasIdLsm;
		this.treemasIdBsm = treemasIdBsm;
		this.treemasIdTms = treemasIdTms;
		this.treemasIdLcm = treemasIdLcm;
		this.treemasIdCom = treemasIdCom;
		this.treemasIdFnm = treemasIdFnm;
		this.treemasIdFrm = treemasIdFrm;
		this.treemasIdOdm = treemasIdOdm;
		this.treemasIdSma = treemasIdSma;
		this.treemasIdTst = treemasIdTst;
		this.sizeValue = sizeValue;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
	}

	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="treecensus.treename_id_seq", name="treename")
	@GeneratedValue(generator="treename", strategy=GenerationType.SEQUENCE)
	@Id
	
	@Column(name = "tree_master_id", unique = true, nullable = false)
	public int getTreeMasterId() {
		return this.treeMasterId;
	}

	public void setTreeMasterId(int treeMasterId) {
		this.treeMasterId = treeMasterId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "treename_id")
	public TmTreeNameMaster getTmTreeNameMaster() {
		return this.tmTreeNameMaster;
	}

	public void setTmTreeNameMaster(TmTreeNameMaster tmTreeNameMaster) {
		this.tmTreeNameMaster = tmTreeNameMaster;
	}

	@Column(name = "ulb_id", nullable = false)
	public int getUlbId() {
		return this.ulbId;
	}

	public void setUlbId(int ulbId) {
		this.ulbId = ulbId;
	}

	@Column(name = "tree_code", length = 50)
	public String getTreeCode() {
		return this.treeCode;
	}

	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}

	@Column(name = "treemas_id_tsm")
	public Integer getTreemasIdTsm() {
		return this.treemasIdTsm;
	}

	public void setTreemasIdTsm(Integer treemasIdTsm) {
		this.treemasIdTsm = treemasIdTsm;
	}

	@Column(name = "treemas_id_lsm")
	public Integer getTreemasIdLsm() {
		return this.treemasIdLsm;
	}

	public void setTreemasIdLsm(Integer treemasIdLsm) {
		this.treemasIdLsm = treemasIdLsm;
	}

	@Column(name = "treemas_id_bsm")
	public Integer getTreemasIdBsm() {
		return this.treemasIdBsm;
	}

	public void setTreemasIdBsm(Integer treemasIdBsm) {
		this.treemasIdBsm = treemasIdBsm;
	}

	@Column(name = "treemas_id_tms")
	public Integer getTreemasIdTms() {
		return this.treemasIdTms;
	}

	public void setTreemasIdTms(Integer treemasIdTms) {
		this.treemasIdTms = treemasIdTms;
	}

	@Column(name = "treemas_id_lcm")
	public Integer getTreemasIdLcm() {
		return this.treemasIdLcm;
	}

	public void setTreemasIdLcm(Integer treemasIdLcm) {
		this.treemasIdLcm = treemasIdLcm;
	}

	@Column(name = "treemas_id_com")
	public Integer getTreemasIdCom() {
		return this.treemasIdCom;
	}

	public void setTreemasIdCom(Integer treemasIdCom) {
		this.treemasIdCom = treemasIdCom;
	}

	@Column(name = "treemas_id_fnm")
	public Integer getTreemasIdFnm() {
		return this.treemasIdFnm;
	}

	public void setTreemasIdFnm(Integer treemasIdFnm) {
		this.treemasIdFnm = treemasIdFnm;
	}

	@Column(name = "treemas_id_frm")
	public Integer getTreemasIdFrm() {
		return this.treemasIdFrm;
	}

	public void setTreemasIdFrm(Integer treemasIdFrm) {
		this.treemasIdFrm = treemasIdFrm;
	}

	@Column(name = "treemas_id_odm")
	public Integer getTreemasIdOdm() {
		return this.treemasIdOdm;
	}

	public void setTreemasIdOdm(Integer treemasIdOdm) {
		this.treemasIdOdm = treemasIdOdm;
	}

	@Column(name = "treemas_id_sma")
	public Integer getTreemasIdSma() {
		return this.treemasIdSma;
	}

	public void setTreemasIdSma(Integer treemasIdSma) {
		this.treemasIdSma = treemasIdSma;
	}

	@Column(name = "treemas_id_tst")
	public Integer getTreemasIdTst() {
		return this.treemasIdTst;
	}

	public void setTreemasIdTst(Integer treemasIdTst) {
		this.treemasIdTst = treemasIdTst;
	}

	@Column(name = "size_value")
	public Integer getSizeValue() {
		return this.sizeValue;
	}

	public void setSizeValue(Integer sizeValue) {
		this.sizeValue = sizeValue;
	}

	@Column(name = "status", nullable = false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "created_by", nullable = false)
	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", length = 29)
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
	public Character getDeviceFrom() {
		return this.deviceFrom;
	}

	public void setDeviceFrom(Character deviceFrom) {
		this.deviceFrom = deviceFrom;
	}

}
