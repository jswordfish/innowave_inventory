package com.innowave.mahaulb.repository.treecensus.dao.master;
// Generated Sep 7, 2017 3:47:24 PM by Hibernate Tools 5.2.3.Final

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
 
import com.innowave.mahaulb.common.dao.TmCmLookupDet;

 
 
 
/**
 * TmTreeMasterMas 
 */
@Entity
@Table(name = "tm_tree_master_mas", schema = "treecensus")
//@Where( clause = "status = 1" )
public class TmTreeMasterMas implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int treemasId;
	private TmCmLookupDet ttLookupDet;
	private int ulbId;
	private String treemasDescEn;
	private String treemasDescMh;
	private int status;
	private int createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private Character deviceFrom;
	
	/*@Transient
	private String strStatus;
	
	
	public String getStrStatus() {
		return strStatus;
	}

	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}*/

	public TmTreeMasterMas() {
	}

	public TmTreeMasterMas(int treemasId, String treemasDescEn, String treemasDescMh, int status) {
		super();
		this.treemasId = treemasId;
		this.treemasDescEn = treemasDescEn;
		this.treemasDescMh = treemasDescMh;
		this.status = status;
	}

	public TmTreeMasterMas(int treemasId, int ulbId, String treemasDescEn, String treemasDescMh, int status,
			int createdBy) {
		this.treemasId = treemasId;
		this.ulbId = ulbId;
		this.treemasDescEn = treemasDescEn;
		this.treemasDescMh = treemasDescMh;
		this.status = status;
		this.createdBy = createdBy;
	}

	public TmTreeMasterMas(int treemasId, TmCmLookupDet ttLookupDet, int ulbId, String treemasDescEn,
			String treemasDescMh, int status, int createdBy, Date createdDate, Integer updatedBy, Date updatedDate,
			String macId, String ipAddress, Character deviceFrom) {
		this.treemasId = treemasId;
		this.ttLookupDet = ttLookupDet;
		this.ulbId = ulbId;
		this.treemasDescEn = treemasDescEn;
		this.treemasDescMh = treemasDescMh;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
	}

	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="treecensus.treemas_id_seq", name="treemas_id_seq")
	@GeneratedValue(generator="treemas_id_seq", strategy=GenerationType.SEQUENCE)
	@Id
	 
//	@GenericGenerator(name="treemasId" , strategy="increment")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "treemas_id", unique = true, nullable = false)
	public int getTreemasId() {
		return this.treemasId;
	}

	public void setTreemasId(int treemasId) {
		this.treemasId = treemasId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lookup_det_id")
	public TmCmLookupDet getTtLookupDet() {
		return this.ttLookupDet;
	}
	 

	public void setTtLookupDet(TmCmLookupDet ttLookupDet) {
		this.ttLookupDet = ttLookupDet;
	}

	@Column(name = "ulb_id", nullable = false)
	public int getUlbId() {
		return this.ulbId;
	}

	public void setUlbId(int ulbId) {
		this.ulbId = ulbId;
	}

	@Column(name = "treemas_desc_en", nullable = false, length = 200)
	public String getTreemasDescEn() {
		return this.treemasDescEn;
	}

	public void setTreemasDescEn(String treemasDescEn) {
		this.treemasDescEn = treemasDescEn;
	}

	@Column(name = "treemas_desc_mh", nullable = false, length = 200)
	public String getTreemasDescMh() {
		return this.treemasDescMh;
	}

	public void setTreemasDescMh(String treemasDescMh) {
		this.treemasDescMh = treemasDescMh;
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
