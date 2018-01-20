package com.innowave.mahaulb.repository.treecensus.dao.master;
// Generated Dec 11, 2017 6:10:52 PM 

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TmTreeRefsequence 
 */
@Entity
@Table(name = "tm_tree_refsequence", schema = "treecensus")
public class TmTreeRefsequence implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8766886068528617168L;
	private long refseqId;
	private Integer modId;
	private String refseqTblName;
	private String refseqFldName;
	private String refseqSeqName;
	private Long refseqStrWith;
	private Long refseqMaxNum;
	private Date refseqStrDate;
	private Date refseqNxtRstDt;
	private Date refseqLstRstDt;
	private Character refseqRstTyp;
	private String refseqPrefix;
	private String refseqSufix;
	private Integer ulbId;
	private Integer status;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private Character deviceFrom;

	public TmTreeRefsequence() {
	}

	public TmTreeRefsequence(long refseqId) {
		this.refseqId = refseqId;
	}

	public TmTreeRefsequence(long refseqId, Integer modId, String refseqTblName, String refseqFldName,
			String refseqSeqName, Long refseqStrWith, Long refseqMaxNum, Date refseqStrDate, Date refseqNxtRstDt,
			Date refseqLstRstDt, Character refseqRstTyp, String refseqPrefix, String refseqSufix, Integer ulbId,
			Integer status, Integer createdBy, Date createdDate, Integer updatedBy, Date updatedDate, String macId,
			String ipAddress, Character deviceFrom) {
		this.refseqId = refseqId;
		this.modId = modId;
		this.refseqTblName = refseqTblName;
		this.refseqFldName = refseqFldName;
		this.refseqSeqName = refseqSeqName;
		this.refseqStrWith = refseqStrWith;
		this.refseqMaxNum = refseqMaxNum;
		this.refseqStrDate = refseqStrDate;
		this.refseqNxtRstDt = refseqNxtRstDt;
		this.refseqLstRstDt = refseqLstRstDt;
		this.refseqRstTyp = refseqRstTyp;
		this.refseqPrefix = refseqPrefix;
		this.refseqSufix = refseqSufix;
		this.ulbId = ulbId;
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

	@Column(name = "refseq_id", unique = true, nullable = false)
	public long getRefseqId() {
		return this.refseqId;
	}

	public void setRefseqId(long refseqId) {
		this.refseqId = refseqId;
	}

	@Column(name = "mod_id")
	public Integer getModId() {
		return this.modId;
	}

	public void setModId(Integer modId) {
		this.modId = modId;
	}

	@Column(name = "refseq_tbl_name", length = 50)
	public String getRefseqTblName() {
		return this.refseqTblName;
	}

	public void setRefseqTblName(String refseqTblName) {
		this.refseqTblName = refseqTblName;
	}

	@Column(name = "refseq_fld_name", length = 50)
	public String getRefseqFldName() {
		return this.refseqFldName;
	}

	public void setRefseqFldName(String refseqFldName) {
		this.refseqFldName = refseqFldName;
	}

	@Column(name = "refseq_seq_name", length = 50)
	public String getRefseqSeqName() {
		return this.refseqSeqName;
	}

	public void setRefseqSeqName(String refseqSeqName) {
		this.refseqSeqName = refseqSeqName;
	}

	@Column(name = "refseq_str_with")
	public Long getRefseqStrWith() {
		return this.refseqStrWith;
	}

	public void setRefseqStrWith(Long refseqStrWith) {
		this.refseqStrWith = refseqStrWith;
	}

	@Column(name = "refseq_max_num")
	public Long getRefseqMaxNum() {
		return this.refseqMaxNum;
	}

	public void setRefseqMaxNum(Long refseqMaxNum) {
		this.refseqMaxNum = refseqMaxNum;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "refseq_str_date", length = 29)
	public Date getRefseqStrDate() {
		return this.refseqStrDate;
	}

	public void setRefseqStrDate(Date refseqStrDate) {
		this.refseqStrDate = refseqStrDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "refseq_nxt_rst_dt", length = 29)
	public Date getRefseqNxtRstDt() {
		return this.refseqNxtRstDt;
	}

	public void setRefseqNxtRstDt(Date refseqNxtRstDt) {
		this.refseqNxtRstDt = refseqNxtRstDt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "refseq_lst_rst_dt", length = 29)
	public Date getRefseqLstRstDt() {
		return this.refseqLstRstDt;
	}

	public void setRefseqLstRstDt(Date refseqLstRstDt) {
		this.refseqLstRstDt = refseqLstRstDt;
	}

	@Column(name = "refseq_rst_typ", length = 1)
	public Character getRefseqRstTyp() {
		return this.refseqRstTyp;
	}

	public void setRefseqRstTyp(Character refseqRstTyp) {
		this.refseqRstTyp = refseqRstTyp;
	}

	@Column(name = "refseq_prefix", length = 50)
	public String getRefseqPrefix() {
		return this.refseqPrefix;
	}

	public void setRefseqPrefix(String refseqPrefix) {
		this.refseqPrefix = refseqPrefix;
	}

	@Column(name = "refseq_sufix", length = 50)
	public String getRefseqSufix() {
		return this.refseqSufix;
	}

	public void setRefseqSufix(String refseqSufix) {
		this.refseqSufix = refseqSufix;
	}

	@Column(name = "ulb_id")
	public Integer getUlbId() {
		return this.ulbId;
	}

	public void setUlbId(Integer ulbId) {
		this.ulbId = ulbId;
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
