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
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;

/**
 * TtInvDisposal  
 */
@Entity
@Table(name = "tt_inv_disposal", schema = "inventory")
public class TtInvDisposal implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7249101151938856484L;
	private long disposalId;
	private TmUlb tmUlb;
	private TmInvStore tmInvStore;
	private TtInvScrap ttInvScrap;
	private String disposalNo;
	private Date disposalDate;
	private String handedOverTo;
	private String auctionOrderNo;
	private Date auctionOrdderDate;
	private String disposalRemarks;
	private Character disposalStatus;
	private int dosposedBy;
	private Integer designationId;
	private Integer approvedBy;
	private Date approvedDate;
	private String approvalRemarks;
	private Date rejectionDate;
	private String rejectionRemarks;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private String deviceFrom;
	private Set<TtInvDisposalDet> ttInvDisposalDets = new HashSet<TtInvDisposalDet>(0);

	public TtInvDisposal() {
	}

	public TtInvDisposal(long disposalId, TmUlb tmUlb, TmInvStore tmInvStore, TtInvScrap ttInvScrap, String disposalNo,
			Date disposalDate, String handedOverTo, String auctionOrderNo, Date auctionOrdderDate, int dosposedBy,
			Date createdDate) {
		this.disposalId = disposalId;
		this.tmUlb = tmUlb;
		this.tmInvStore = tmInvStore;
		this.ttInvScrap = ttInvScrap;
		this.disposalNo = disposalNo;
		this.disposalDate = disposalDate;
		this.handedOverTo = handedOverTo;
		this.auctionOrderNo = auctionOrderNo;
		this.auctionOrdderDate = auctionOrdderDate;
		this.dosposedBy = dosposedBy;
		this.createdDate = createdDate;
	}

	public TtInvDisposal(long disposalId, TmUlb tmUlb, TmInvStore tmInvStore, TtInvScrap ttInvScrap, String disposalNo,
			Date disposalDate, String handedOverTo, String auctionOrderNo, Date auctionOrdderDate,
			String disposalRemarks, Character disposalStatus, int dosposedBy, Integer designationId, Integer approvedBy,
			Date approvedDate, String approvalRemarks, Date rejectionDate, String rejectionRemarks, Integer createdBy,
			Date createdDate, Integer updatedBy, Date updatedDate, String macId, String ipAddress, String deviceFrom,
			Set<TtInvDisposalDet> ttInvDisposalDets) {
		this.disposalId = disposalId;
		this.tmUlb = tmUlb;
		this.tmInvStore = tmInvStore;
		this.ttInvScrap = ttInvScrap;
		this.disposalNo = disposalNo;
		this.disposalDate = disposalDate;
		this.handedOverTo = handedOverTo;
		this.auctionOrderNo = auctionOrderNo;
		this.auctionOrdderDate = auctionOrdderDate;
		this.disposalRemarks = disposalRemarks;
		this.disposalStatus = disposalStatus;
		this.dosposedBy = dosposedBy;
		this.designationId = designationId;
		this.approvedBy = approvedBy;
		this.approvedDate = approvedDate;
		this.approvalRemarks = approvalRemarks;
		this.rejectionDate = rejectionDate;
		this.rejectionRemarks = rejectionRemarks;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
		this.ttInvDisposalDets = ttInvDisposalDets;
	}

	@Id

	@Column(name = "disposal_id", unique = true, nullable = false)
	public long getDisposalId() {
		return this.disposalId;
	}

	public void setDisposalId(long disposalId) {
		this.disposalId = disposalId;
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
	@JoinColumn(name = "store_id", nullable = false)
	public TmInvStore getTmInvStore() {
		return this.tmInvStore;
	}

	public void setTmInvStore(TmInvStore tmInvStore) {
		this.tmInvStore = tmInvStore;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "scrap_id", nullable = false)
	public TtInvScrap getTtInvScrap() {
		return this.ttInvScrap;
	}

	public void setTtInvScrap(TtInvScrap ttInvScrap) {
		this.ttInvScrap = ttInvScrap;
	}

	@Column(name = "disposal_no", nullable = false, length = 50)
	public String getDisposalNo() {
		return this.disposalNo;
	}

	public void setDisposalNo(String disposalNo) {
		this.disposalNo = disposalNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "disposal_date", nullable = false, length = 13)
	public Date getDisposalDate() {
		return this.disposalDate;
	}

	public void setDisposalDate(Date disposalDate) {
		this.disposalDate = disposalDate;
	}

	@Column(name = "handed_over_to", nullable = false, length = 200)
	public String getHandedOverTo() {
		return this.handedOverTo;
	}

	public void setHandedOverTo(String handedOverTo) {
		this.handedOverTo = handedOverTo;
	}

	@Column(name = "auction_order_no", nullable = false, length = 50)
	public String getAuctionOrderNo() {
		return this.auctionOrderNo;
	}

	public void setAuctionOrderNo(String auctionOrderNo) {
		this.auctionOrderNo = auctionOrderNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "auction_ordder_date", nullable = false, length = 13)
	public Date getAuctionOrdderDate() {
		return this.auctionOrdderDate;
	}

	public void setAuctionOrdderDate(Date auctionOrdderDate) {
		this.auctionOrdderDate = auctionOrdderDate;
	}

	@Column(name = "disposal_remarks", length = 2000)
	public String getDisposalRemarks() {
		return this.disposalRemarks;
	}

	public void setDisposalRemarks(String disposalRemarks) {
		this.disposalRemarks = disposalRemarks;
	}

	@Column(name = "disposal_status", length = 1)
	public Character getDisposalStatus() {
		return this.disposalStatus;
	}

	public void setDisposalStatus(Character disposalStatus) {
		this.disposalStatus = disposalStatus;
	}

	@Column(name = "dosposed_by", nullable = false)
	public int getDosposedBy() {
		return this.dosposedBy;
	}

	public void setDosposedBy(int dosposedBy) {
		this.dosposedBy = dosposedBy;
	}

	@Column(name = "designation_id")
	public Integer getDesignationId() {
		return this.designationId;
	}

	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
	}

	@Column(name = "approved_by")
	public Integer getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(Integer approvedBy) {
		this.approvedBy = approvedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "approved_date", length = 13)
	public Date getApprovedDate() {
		return this.approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	@Column(name = "approval_remarks", length = 2000)
	public String getApprovalRemarks() {
		return this.approvalRemarks;
	}

	public void setApprovalRemarks(String approvalRemarks) {
		this.approvalRemarks = approvalRemarks;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "rejection_date", length = 13)
	public Date getRejectionDate() {
		return this.rejectionDate;
	}

	public void setRejectionDate(Date rejectionDate) {
		this.rejectionDate = rejectionDate;
	}

	@Column(name = "rejection_remarks", length = 2000)
	public String getRejectionRemarks() {
		return this.rejectionRemarks;
	}

	public void setRejectionRemarks(String rejectionRemarks) {
		this.rejectionRemarks = rejectionRemarks;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ttInvDisposal")
	public Set<TtInvDisposalDet> getTtInvDisposalDets() {
		return this.ttInvDisposalDets;
	}

	public void setTtInvDisposalDets(Set<TtInvDisposalDet> ttInvDisposalDets) {
		this.ttInvDisposalDets = ttInvDisposalDets;
	}

}
