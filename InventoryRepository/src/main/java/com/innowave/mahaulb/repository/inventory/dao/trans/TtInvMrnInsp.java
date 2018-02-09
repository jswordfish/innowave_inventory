package com.innowave.mahaulb.repository.inventory.dao.trans;
// Generated Jan 31, 2018 2:32:46 PM  

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.innowave.mahaulb.common.dao.TmUlb;

/**
 * TtInvMrnInsp 
 */
@Entity
@Table(name = "tt_inv_mrn_insp", schema = "inventory")
public class TtInvMrnInsp implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1931038509055914495L;
	private long mrnInspId;
	private TmUlb tmUlb;
	private TtInvMrn ttInvMrn;
	private String mrnNo;
	private Date mrnDate;
	private String inspNo;
	private Date inspDate;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;
	private Set<TtInvMrnInspDet> ttInvMrnInspDets = new HashSet<TtInvMrnInspDet>(0);

	public TtInvMrnInsp() {
	}

	public TtInvMrnInsp(long mrnInspId, TmUlb tmUlb, TtInvMrn ttInvMrn, String mrnNo, Date mrnDate, String inspNo,
			Date inspDate, Date createdDate) {
		this.mrnInspId = mrnInspId;
		this.tmUlb = tmUlb;
		this.ttInvMrn = ttInvMrn;
		this.mrnNo = mrnNo;
		this.mrnDate = mrnDate;
		this.inspNo = inspNo;
		this.inspDate = inspDate;
		this.createdDate = createdDate;
	}

	public TtInvMrnInsp(long mrnInspId, TmUlb tmUlb, TtInvMrn ttInvMrn, String mrnNo, Date mrnDate, String inspNo,
			Date inspDate, Integer createdBy, Date createdDate, Integer updatedBy, Date updatedDate, String macId,
			String ipAddress, String deviceFrom, Set<TtInvMrnInspDet> ttInvMrnInspDets) {
		this.mrnInspId = mrnInspId;
		this.tmUlb = tmUlb;
		this.ttInvMrn = ttInvMrn;
		this.mrnNo = mrnNo;
		this.mrnDate = mrnDate;
		this.inspNo = inspNo;
		this.inspDate = inspDate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
		this.ttInvMrnInspDets = ttInvMrnInspDets;
	}

	@Id

	@Column(name = "mrn_insp_id", unique = true, nullable = false)
	public long getMrnInspId() {
		return this.mrnInspId;
	}

	public void setMrnInspId(long mrnInspId) {
		this.mrnInspId = mrnInspId;
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
	@JoinColumn(name = "mrn_id", nullable = false)
	public TtInvMrn getTtInvMrn() {
		return this.ttInvMrn;
	}

	public void setTtInvMrn(TtInvMrn ttInvMrn) {
		this.ttInvMrn = ttInvMrn;
	}

	@Column(name = "mrn_no", nullable = false, length = 50)
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

	@Column(name = "insp_no", nullable = false, length = 50)
	public String getInspNo() {
		return this.inspNo;
	}

	public void setInspNo(String inspNo) {
		this.inspNo = inspNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "insp_date", nullable = false, length = 13)
	public Date getInspDate() {
		return this.inspDate;
	}

	public void setInspDate(Date inspDate) {
		this.inspDate = inspDate;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ttInvMrnInsp")
	public Set<TtInvMrnInspDet> getTtInvMrnInspDets() {
		return this.ttInvMrnInspDets;
	}

	public void setTtInvMrnInspDets(Set<TtInvMrnInspDet> ttInvMrnInspDets) {
		this.ttInvMrnInspDets = ttInvMrnInspDets;
	}

}
