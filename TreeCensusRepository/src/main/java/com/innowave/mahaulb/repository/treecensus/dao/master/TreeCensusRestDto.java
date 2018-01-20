package com.innowave.mahaulb.repository.treecensus.dao.master;

import java.io.Serializable;
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

@Entity
@Table(name = "tt_tree_master", schema = "treecensus")
public class TreeCensusRestDto implements Serializable 

{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int treemasterId;
	private int ulbId;
	private Character treeCode;
	private TmTreeNameMaster tmTreeNameMaster;
	private int lookupDetIdTsm;
	private int	lookupDetIdLsm;
	private int lookupDetIdBsm;
	private int lookupDetIdTms;
	private int lookupDetIdLcm;
	private int lookupDetIdCom;
	private int lookupDetIdFnm;
	private int lookupDetIdFrm;
	private int lookupDetIdOdm;
	private int lookupDetIdSma;
	private int lookupDetIdTst;
	private Integer sizeValue;
	private int status;
	private int createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private Character macId;
	private Character ipAddress;
	private Character deviceFrom;
	
	public TreeCensusRestDto()
	{
		
		
	}
	
	
	/*public TreeCensusRestDto(int treemasterId, int ulbId, int lookupDetIdTsm,  int lookupDetIdLsm, int lookupDetIdBsm, int lookupDetIdTms, int lookupDetIdCom, int lookupDetIdFnm, int lookupDetIdFrm, int lookupDetIdOdm, int lookupDetIdSma, int lookupDetIdTst, int lookupDetIdLcm, int status,
			int createdBy,Integer sizeValue,Date createdDate,Integer updatedBy,Date updatedDate,Character macId, Character ipAddress,Character deviceFrom) {
		this.treemasterId = treemasterId;
		this.ulbId = ulbId;
		this.lookupDetIdTsm = lookupDetIdTsm;
		this.lookupDetIdLsm = lookupDetIdLsm;
		this.lookupDetIdBsm = lookupDetIdBsm;
		this.lookupDetIdTms = lookupDetIdTms;
		this.lookupDetIdCom = lookupDetIdCom;
		this.lookupDetIdFnm = lookupDetIdFnm;
		this.lookupDetIdFrm = lookupDetIdFrm;
		this.lookupDetIdOdm = lookupDetIdOdm;
		this.lookupDetIdSma = lookupDetIdSma;
		this.lookupDetIdTst = lookupDetIdTst;
		this.lookupDetIdLcm = lookupDetIdLcm;
		this.status = status;
		this.createdBy = createdBy;
		this.sizeValue=sizeValue;
		this.createdDate=createdDate;
		this.updatedBy=updatedBy;
		this.updatedDate=updatedDate;
		this.macId=macId;
		this.ipAddress=ipAddress;
		this.deviceFrom=deviceFrom;
	}
	*/
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="treecensus.tree_master_id_seq", name="tree_master_id_seq")
	@GeneratedValue(generator="tree_master_id_seq", strategy=GenerationType.SEQUENCE)
	@Id
	
	@Column(name = "tree_master_id", unique = true, nullable = false)
	public int getTreemasterId() {
		return treemasterId;
	}
	public void setTreemasterId(int treemasterId) {
		this.treemasterId = treemasterId;
	}
	@Column(name = "ulb_id", nullable = false)
	public int getUlbId() {
		return ulbId;
	}
	public void setUlbId(int ulbId) {
		this.ulbId = ulbId;
	}
	@Column(name = "tree_code", nullable = false)
	public Character getTreeCode() {
		return treeCode;
	}
	public void setTreeCode(Character treeCode) {
		this.treeCode = treeCode;
	}
	
	@Column(name = "lookup_det_id_tsm", nullable = false)
	public int getLookupDetIdTsm() {
		return lookupDetIdTsm;
	}
	public void setLookupDetIdTsm(int lookupDetIdTsm) {
		this.lookupDetIdTsm = lookupDetIdTsm;
	}
	
	@Column(name = "lookup_det_id_lsm", nullable = false)
	public int getLookupDetIdLsm() {
		return lookupDetIdLsm;
	}
	public void setLookupDetIdLsm(int lookupDetIdLsm) {
		this.lookupDetIdLsm = lookupDetIdLsm;
	}
	@Column(name = "lookup_det_id_bsm", nullable = false)
	public int getLookupDetIdBsm() {
		return lookupDetIdBsm;
	}
	public void setLookupDetIdBsm(int lookupDetIdBsm) {
		this.lookupDetIdBsm = lookupDetIdBsm;
	}
	@Column(name = "lookup_det_id_tms", nullable = false)
	public int getLookupDetIdTms() {
		return lookupDetIdTms;
	}
	
	public void setLookupDetIdTms(int lookupDetIdTms) {
		this.lookupDetIdTms = lookupDetIdTms;
	}
	@Column(name = "lookup_det_id_lcm", nullable = false)
	public int getLookupDetIdLcm() {
		return lookupDetIdLcm;
	}
	public void setLookupDetIdLcm(int lookupDetIdLcm) {
		this.lookupDetIdLcm = lookupDetIdLcm;
	}
	@Column(name = "lookup_det_id_com", nullable = false)
	public int getLookupDetIdCom() {
		return lookupDetIdCom;
	}
	public void setLookupDetIdCom(int lookupDetIdCom) {
		this.lookupDetIdCom = lookupDetIdCom;
	}
	@Column(name = "lookup_det_id_fnm", nullable = false)
	public int getLookupDetIdFnm() {
		return lookupDetIdFnm;
	}
	
	public void setLookupDetIdFnm(int lookupDetIdFnm) {
		this.lookupDetIdFnm = lookupDetIdFnm;
	}
	@Column(name = "lookup_det_id_frm", nullable = false)
	public int getLookupDetIdFrm() {
		return lookupDetIdFrm;
	}
	public void setLookupDetIdFrm(int lookupDetIdFrm) {
		this.lookupDetIdFrm = lookupDetIdFrm;
	}
	@Column(name = "lookup_det_id_odm", nullable = false)
	public int getLookupDetIdOdm() {
		return lookupDetIdOdm;
	}
	public void setLookupDetIdOdm(int lookupDetIdOdm) {
		this.lookupDetIdOdm = lookupDetIdOdm;
	}
	@Column(name = "lookup_det_id_sma", nullable = false)
	public int getLookupDetIdSma() {
		return lookupDetIdSma;
	}
	public void setLookupDetIdSma(int lookupDetIdSma) {
		this.lookupDetIdSma = lookupDetIdSma;
	}
	@Column(name = "lookup_det_id_tst", nullable = false)
	public int getLookupDetIdTst() {
		return lookupDetIdTst;
	}
	public void setLookupDetIdTst(int lookupDetIdTst) {
		this.lookupDetIdTst = lookupDetIdTst;
	}
	@Column(name = "size_value", nullable = false)
	public Integer getSizeValue() {
		return sizeValue;
	}
	public void setSizeValue(Integer sizeValue) {
		this.sizeValue = sizeValue;
	}
	@Column(name = "status", nullable = false)
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Column(name = "created_by", nullable = false)
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", length = 29)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Column(name = "updated_by")
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", length = 29)
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Column(name = "mac_id", length = 1)
	public Character getMacId() {
		return macId;
	}
	public void setMacId(Character macId) {
		this.macId = macId;
	}
	@Column(name = "ip_address", length = 1)
	public Character getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(Character ipAddress) {
		this.ipAddress = ipAddress;
	}
	@Column(name = "device_from", length = 1)
	public Character getDeviceFrom() {
		return deviceFrom;
	}
	public void setDeviceFrom(Character deviceFrom) {
		this.deviceFrom = deviceFrom;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "treename_id", nullable = false)
	public TmTreeNameMaster getTmTreeNameMaster() {
		return tmTreeNameMaster;
	}
	
	public void setTmTreeNameMaster(TmTreeNameMaster tmTreeNameMaster)
	{
		this.tmTreeNameMaster = tmTreeNameMaster;
	}
	
}