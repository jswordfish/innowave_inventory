package com.innowave.mahaulb.repository.treecensus.dao.master;
// Generated Sep 14, 2017 3:47:24 PM  

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tm_tree_name_master", schema = "treecensus")
//@Where( clause = "status = 1" )
public class TmTreeNameMaster implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int treenameId;
	//private TtLookupDet ttLookupDet;
	private int ulbId;
	private String treeSciNameEn;
	private String treeSciNameRg;
	private String treeVerNameEn;
	private String treeVerNameRg;
	private String treeComNameEn;
	private String treeComNameRg;
	private String treeFamNameEn;
	private String treeFamNameRg;
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
	
	private Integer lookupDetAesthetic;
	private Integer lookupDetCultural;
	private Integer lookupDetEcological;
	private Integer lookupDetEconomical;
	private int status;
	private int createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private Character deviceFrom;
	
	

	public TmTreeNameMaster() {
	}
	
	public TmTreeNameMaster(int treenameId) {
		this.treenameId = treenameId;
	}

	public TmTreeNameMaster(int treenameId, int ulbId, String treeVerNameEn, String treeVerNameRg, int status, String treeSciNameEn, String treeSciNameRg, String treeFamNameEn, String treeFamNameRg, String treeComNameEn, String treeComNameRg,
			int createdBy) {
		this.treenameId = treenameId;
		this.ulbId = ulbId;
		this.treeVerNameEn = treeVerNameEn;
		this.treeVerNameRg = treeVerNameRg;
		this.status = status;
		this.createdBy = createdBy;
	}

	public TmTreeNameMaster(int treenameId,int ulbId, String treeVerNameEn,
			String treeVerNameRg,String treeSciNameEn,String treeSciNameRg,String treeFamNameEn,String treeFamNameRg,String treeComNameEn,String treeComNameRg,
			int lookupDetIdTsm,  int lookupDetIdLsm, int lookupDetIdBsm, int lookupDetIdTms, int lookupDetIdCom, int lookupDetIdFnm, int lookupDetIdFrm,
			int lookupDetIdOdm, int lookupDetIdSma, int lookupDetIdTst, int lookupDetIdLcm, int status, int createdBy, Date createdDate, Integer updatedBy,
			Date updatedDate, String macId, String ipAddress, Character deviceFrom) {
		this.treenameId = treenameId;
		//this.ttLookupDet = ttLookupDet;
		this.ulbId = ulbId;
		this.treeVerNameEn = treeVerNameEn;
		this.treeVerNameRg = treeVerNameRg;
		this.treeSciNameEn = treeSciNameEn;
		this.treeSciNameRg = treeSciNameRg;
		this.treeFamNameEn = treeFamNameEn;
		this.treeFamNameRg = treeFamNameRg;
		this.treeComNameEn = treeComNameEn;
		this.treeComNameRg = treeComNameRg;
		this.treemasIdTsm = lookupDetIdTsm;
		this.treemasIdLsm = lookupDetIdLsm;
		this.treemasIdBsm = lookupDetIdBsm;
		this.treemasIdTms = lookupDetIdTms;
		this.treemasIdCom = lookupDetIdCom;
		this.treemasIdFnm = lookupDetIdFnm;
		this.treemasIdFrm = lookupDetIdFrm;
		this.treemasIdOdm = lookupDetIdOdm;
		this.treemasIdSma = lookupDetIdSma;
		this.treemasIdTst = lookupDetIdTst;
		this.treemasIdLcm = lookupDetIdLcm;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
	}

	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="treecensus.treename_id_seq", name="treename_id_seq")
	@GeneratedValue(generator="treename_id_seq", strategy=GenerationType.SEQUENCE)
	@Id
	 
//	@GenericGenerator(name="treemasId" , strategy="increment")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "treename_id", unique = true, nullable = false)
	public int getTreenameId() {
		return this.treenameId;
	}

	public void setTreenameId(int treenameId) {
		this.treenameId = treenameId;
	}

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lookup_det_id")
	public TtLookupDet getTtLookupDet() {
		return this.ttLookupDet;
	}
	 

	public void setTtLookupDet(TtLookupDet ttLookupDet) {
		this.ttLookupDet = ttLookupDet;
	}*/

	@Column(name = "ulb_id", nullable = false)
	public int getUlbId() {
		return this.ulbId;
	}

	public void setUlbId(int ulbId) {
		this.ulbId = ulbId;
	}

	/*@Column(name = "treemas_desc_en", nullable = false, length = 200)
	public String getTreemasDescEn() {
		return this.treemasDescEn;
	}*/

	@Column(name = "tree_ver_name_en", nullable = false, length = 200)
	public String getTreeVerNameEn() {
		return treeVerNameEn;
	}

	public void setTreeVerNameEn(String treeVerNameEn) {
		this.treeVerNameEn = treeVerNameEn;
	}

	@Column(name = "tree_ver_name_Rg", nullable = false, length = 200)
	public String getTreeVerNameRg() {
		return treeVerNameRg;
	}

	public void setTreeVerNameRg(String treeVerNameRg) {
		this.treeVerNameRg = treeVerNameRg;
	}
	@Column(name = "tree_sci_name_en", nullable = false, length = 200)
	public String getTreeSciNameEn() {
		return treeSciNameEn;
	}

	public void setTreeSciNameEn(String treeSciNameEn) {
		this.treeSciNameEn = treeSciNameEn;
	}

	@Column(name = "tree_sci_name_Rg", nullable = false, length = 200)
	public String getTreeSciNameRg() {
		return treeSciNameRg;
	}

	public void setTreeSciNameRg(String treeSciNameRg) {
		this.treeSciNameRg = treeSciNameRg;
	}
	@Column(name = "tree_fam_name_en", nullable = false, length = 200)
	public String getTreeFamNameEn() {
		return treeFamNameEn;
	}

	public void setTreeFamNameEn(String treeFamNameEn) {
		this.treeFamNameEn = treeFamNameEn;
	}
	@Column(name = "tree_fam_name_Rg", nullable = false, length = 200)
	public String getTreeFamNameRg() {
		return treeFamNameRg;
	}

	public void setTreeFamNameRg(String treeFamNameRg) {
		this.treeFamNameRg = treeFamNameRg;
	}
	@Column(name = "tree_com_name_en", nullable = false, length = 200)
	public String getTreeComNameEn() {
		return treeComNameEn;
	}

	public void setTreeComNameEn(String treeComNameEn) {
		this.treeComNameEn = treeComNameEn;
	}

	@Column(name = "tree_com_name_Rg", length = 200)
	public String getTreeComNameRg() {
		return treeComNameRg;
	}

	public void setTreeComNameRg(String treeComNameRg) {
		this.treeComNameRg = treeComNameRg;
	}

	@Column(name = "tree_code", length = 50)
	public String getTreeCode() {
		return treeCode;
	}

	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}

	@Column(name = "treemas_id_tsm")
	public Integer getTreemasIdTsm() {
		return treemasIdTsm;
	}

	public void setTreemasIdTsm(Integer treemasIdTsm) {
		this.treemasIdTsm = treemasIdTsm;
	}

	@Column(name = "treemas_id_lsm")
	public Integer getTreemasIdLsm() {
		return treemasIdLsm;
	}

	public void setTreemasIdLsm(Integer treemasIdLsm) {
		this.treemasIdLsm = treemasIdLsm;
	}

	@Column(name = "treemas_id_bsm")
	public Integer getTreemasIdBsm() {
		return treemasIdBsm;
	}

	public void setTreemasIdBsm(Integer treemasIdBsm) {
		this.treemasIdBsm = treemasIdBsm;
	}

	@Column(name = "treemas_id_tms")
	public Integer getTreemasIdTms() {
		return treemasIdTms;
	}

	public void setTreemasIdTms(Integer treemasIdTms) {
		this.treemasIdTms = treemasIdTms;
	}

	@Column(name = "treemas_id_lcm")
	public Integer getTreemasIdLcm() {
		return treemasIdLcm;
	}

	public void setTreemasIdLcm(Integer treemasIdLcm) {
		this.treemasIdLcm = treemasIdLcm;
	}

	@Column(name = "treemas_id_com")
	public Integer getTreemasIdCom() {
		return treemasIdCom;
	}

	public void setTreemasIdCom(Integer treemasIdCom) {
		this.treemasIdCom = treemasIdCom;
	}

	@Column(name = "treemas_id_fnm")
	public Integer getTreemasIdFnm() {
		return treemasIdFnm;
	}

	public void setTreemasIdFnm(Integer treemasIdFnm) {
		this.treemasIdFnm = treemasIdFnm;
	}

	@Column(name = "treemas_id_frm")
	public Integer getTreemasIdFrm() {
		return treemasIdFrm;
	}

	public void setTreemasIdFrm(Integer treemasIdFrm) {
		this.treemasIdFrm = treemasIdFrm;
	}

	@Column(name = "treemas_id_odm")
	public Integer getTreemasIdOdm() {
		return treemasIdOdm;
	}

	public void setTreemasIdOdm(Integer treemasIdOdm) {
		this.treemasIdOdm = treemasIdOdm;
	}

	@Column(name = "treemas_id_sma")
	public Integer getTreemasIdSma() {
		return treemasIdSma;
	}

	public void setTreemasIdSma(Integer treemasIdSma) {
		this.treemasIdSma = treemasIdSma;
	}

	@Column(name = "treemas_id_tst")
	public Integer getTreemasIdTst() {
		return treemasIdTst;
	}

	public void setTreemasIdTst(Integer treemasIdTst) {
		this.treemasIdTst = treemasIdTst;
	}
	
	@Column(name = "lookup_det_id_tua")
	public Integer getLookupDetAesthetic() {
		return lookupDetAesthetic;
	}

	public void setLookupDetAesthetic(Integer lookupDetAesthetic) {
		this.lookupDetAesthetic = lookupDetAesthetic;
	}

	@Column(name = "lookup_det_id_auc")
	public Integer getLookupDetCultural() {
		return lookupDetCultural;
	}

	public void setLookupDetCultural(Integer lookupDetCultural) {
		this.lookupDetCultural = lookupDetCultural;
	}

	@Column(name = "lookup_det_id_tue")
	public Integer getLookupDetEcological() {
		return lookupDetEcological;
	}

	public void setLookupDetEcological(Integer lookupDetEcological) {
		this.lookupDetEcological = lookupDetEcological;
	}

	@Column(name = "lookup_det_id_tuc")
	public Integer getLookupDetEconomical() {
		return lookupDetEconomical;
	}

	public void setLookupDetEconomical(Integer lookupDetEconomical) {
		this.lookupDetEconomical = lookupDetEconomical;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
