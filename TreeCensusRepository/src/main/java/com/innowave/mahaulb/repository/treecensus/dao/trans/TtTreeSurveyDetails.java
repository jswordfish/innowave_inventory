package com.innowave.mahaulb.repository.treecensus.dao.trans;
// Generated Sep 22, 2017 3:57:42 PM  

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

import com.innowave.mahaulb.common.dao.TmCmApartment;
import com.innowave.mahaulb.common.dao.TmCmLocality;
import com.innowave.mahaulb.common.dao.TmCmRoad;
import com.innowave.mahaulb.common.dao.master.TmCmLocation;
import com.innowave.mahaulb.common.dao.trans.TtServiceRequest;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeAuthorityMaster;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeNameMaster;

/**
 * TtTreeSurveyDetails  
 */
@Entity
@Table(name = "tt_tree_survey_details", schema = "treecensus")
public class TtTreeSurveyDetails implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int treeSurveyId;
	private TmCmApartment tmCmApartment;
	private TmCmLocality tmCmLocality;
	private TmCmLocation tmCmLocation;
	private TmCmRoad tmCmRoad;
	private TtServiceRequest ttServiceRequest;
	private TmTreeAuthorityMaster tmTreeAuthorityMaster;
	private TmTreeNameMaster tmTreeNameMaster;
	private int ulbId;
	private Character flagNewExisting;
	private Date surveyDate;
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
	private Integer girthAtBreastHieght;
	private Double hieght;
	private Integer approxAge;
	private Double canopyWidth;
	private String msebCtcNo;
	private String location;
	private String apartmentComplex;
	private String road;
	private String building;
	private String locality;
	private String longitude;
	private String latitude;
	private String observationRemarks;
	private String ownerAadharCard;
	private String ownerName;
	private String ownerAddress;
	private Character approveFlag;
	private String approveRemark;
	private Integer status;
	private int createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private Character deviceFrom;
	private Date approvalDate;
	private String surveyNumber;
	private String treeIdentificationNo;
	private Character portDataFlag;
	private Set<TtTreeSurveyUploadList> ttTreeSurveyUploadLists = new HashSet<TtTreeSurveyUploadList>(0);
	private Integer inspectedByUserId;
	private Date inspectedOnDate;
	private Integer lookupDetHierIdAwz1;
	private Integer lookupDetHierIdAwz2;
	private Integer lookupDetIdOlt;
	private Integer lookupDetIdRsu;
	private String refNo;

	public TtTreeSurveyDetails() {
	}

	public TtTreeSurveyDetails(int treeSurveyId) {
		this.treeSurveyId = treeSurveyId;
	}
	
	public TtTreeSurveyDetails(int treeSurveyId, int ulbId, int createdBy) {
		this.treeSurveyId = treeSurveyId;
		this.ulbId = ulbId;
		this.createdBy = createdBy;
	}
	
	public TtTreeSurveyDetails(int treeSurveyId, Date surveyDate, Integer treemasIdTsm, Integer treemasIdLsm, Integer treemasIdBsm, Integer treemasIdTms,
			Integer treemasIdLcm, Integer treemasIdCom, Integer treemasIdFnm, Integer treemasIdFrm, Integer treemasIdOdm, Integer treemasIdSma,
			Integer treemasIdTst, Integer sizeValue, Integer girthAtBreastHieght, Double hieght, Integer approxAge, Double canopyWidth, String msebCtcNo,
			String location, String apartmentComplex, String road, String building, String locality , String observationRemarks, String surveyNumber,
			String treeIdentificationNo, String longitude, String latitude, TmTreeNameMaster tmTreeNameMaster, Integer lookupDetHierIdAwz1, Integer lookupDetHierIdAwz2) {
		this.treeSurveyId = treeSurveyId;
		
		this.surveyDate = surveyDate;
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
		this.girthAtBreastHieght = girthAtBreastHieght;
		this.hieght = hieght;
		this.approxAge = approxAge;
		this.canopyWidth = canopyWidth;
		this.msebCtcNo = msebCtcNo;
		this.location = location;
		this.apartmentComplex = apartmentComplex;
		this.road = road;
		this.building = building;
		this.locality = locality;
		this.longitude = longitude;
		this.latitude = latitude;
		this.observationRemarks = observationRemarks;
		this.surveyNumber = surveyNumber;
		this.treeIdentificationNo = treeIdentificationNo;
		this.tmTreeNameMaster = tmTreeNameMaster;
		this.lookupDetHierIdAwz1 = lookupDetHierIdAwz1;
		this.lookupDetHierIdAwz2 = lookupDetHierIdAwz2;
		
	}

	public TtTreeSurveyDetails(int treeSurveyId, TmCmApartment tmCmApartment, TmCmLocality tmCmLocality,
			TmCmLocation tmCmLocation, TmCmRoad tmCmRoad, TtServiceRequest ttServiceRequest,
			TmTreeAuthorityMaster tmTreeAuthorityMaster, TmTreeNameMaster tmTreeNameMaster, int ulbId,
			Character flagNewExisting, Date surveyDate, Integer treemasIdTsm, Integer treemasIdLsm,
			Integer treemasIdBsm, Integer treemasIdTms, Integer treemasIdLcm, Integer treemasIdCom,
			Integer treemasIdFnm, Integer treemasIdFrm, Integer treemasIdOdm, Integer treemasIdSma,
			Integer treemasIdTst, Integer sizeValue, Integer girthAtBreastHieght, Double hieght, Integer approxAge,
			Double canopyWidth, String msebCtcNo, String location, String apartmentComplex, String road,
			String building, String locality, String longitude, String latitude, String observationRemarks,
			String ownerAadharCard, String ownerName, String ownerAddress, Character approveFlag, String approveRemark,
			Integer status, int createdBy, Date createdDate, Integer updatedBy, Date updatedDate, String macId,
			String ipAddress, Character deviceFrom, Date approvalDate, String surveyNumber, String treeIdentificationNo,
			Character portDataFlag, Date inspectedOnDate, Integer lookupDetHierIdAwz1, Integer lookupDetHierIdAwz2,Set<TtTreeSurveyUploadList> ttTreeSurveyUploadLists) {
		this.treeSurveyId = treeSurveyId;
		this.tmCmApartment = tmCmApartment;
		this.tmCmLocality = tmCmLocality;
		this.tmCmLocation = tmCmLocation;
		this.tmCmRoad = tmCmRoad;
		this.ttServiceRequest = ttServiceRequest;
		this.tmTreeAuthorityMaster = tmTreeAuthorityMaster;
		this.tmTreeNameMaster = tmTreeNameMaster;
		this.ulbId = ulbId;
		this.flagNewExisting = flagNewExisting;
		this.surveyDate = surveyDate;
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
		this.girthAtBreastHieght = girthAtBreastHieght;
		this.hieght = hieght;
		this.approxAge = approxAge;
		this.canopyWidth = canopyWidth;
		this.msebCtcNo = msebCtcNo;
		this.location = location;
		this.apartmentComplex = apartmentComplex;
		this.road = road;
		this.building = building;
		this.locality = locality;
		this.longitude = longitude;
		this.latitude = latitude;
		this.observationRemarks = observationRemarks;
		this.ownerAadharCard = ownerAadharCard;
		this.ownerName = ownerName;
		this.ownerAddress = ownerAddress;
		this.approveFlag = approveFlag;
		this.approveRemark = approveRemark;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
		this.approvalDate = approvalDate;
		this.surveyNumber = surveyNumber;
		this.treeIdentificationNo = treeIdentificationNo;
		this.portDataFlag = portDataFlag;
		this.lookupDetHierIdAwz1 = lookupDetHierIdAwz1;
		this.lookupDetHierIdAwz2 = lookupDetHierIdAwz2;
		this.ttTreeSurveyUploadLists = ttTreeSurveyUploadLists;
	}

	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="treecensus.tree_survey_id_seq", name="tree_survey_id_seq")
	@GeneratedValue(generator="tree_survey_id_seq", strategy=GenerationType.SEQUENCE)
	@Id

	@Column(name = "tree_survey_id", unique = true, nullable = false)
	public int getTreeSurveyId() {
		return this.treeSurveyId;
	}

	public void setTreeSurveyId(int treeSurveyId) {
		this.treeSurveyId = treeSurveyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "apartment_id")
	public TmCmApartment getTmCmApartment() {
		return this.tmCmApartment;
	}

	public void setTmCmApartment(TmCmApartment tmCmApartment) {
		this.tmCmApartment = tmCmApartment;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "locality_id")
	public TmCmLocality getTmCmLocality() {
		return this.tmCmLocality;
	}

	public void setTmCmLocality(TmCmLocality tmCmLocality) {
		this.tmCmLocality = tmCmLocality;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	public TmCmLocation getTmCmLocation() {
		return this.tmCmLocation;
	}

	public void setTmCmLocation(TmCmLocation tmCmLocation) {
		this.tmCmLocation = tmCmLocation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "road_id")
	public TmCmRoad getTmCmRoad() {
		return this.tmCmRoad;
	}

	public void setTmCmRoad(TmCmRoad tmCmRoad) {
		this.tmCmRoad = tmCmRoad;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srn_id")
	public TtServiceRequest getTtServiceRequest() {
		return this.ttServiceRequest;
	}

	public void setTtServiceRequest(TtServiceRequest ttServiceRequest) {
		this.ttServiceRequest = ttServiceRequest;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "authority_id")
	public TmTreeAuthorityMaster getTmTreeAuthorityMaster() {
		return this.tmTreeAuthorityMaster;
	}

	public void setTmTreeAuthorityMaster(TmTreeAuthorityMaster tmTreeAuthorityMaster) {
		this.tmTreeAuthorityMaster = tmTreeAuthorityMaster;
	}

	@ManyToOne(fetch = FetchType.EAGER)
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

	@Column(name = "flag_new_existing", length = 1)
	public Character getFlagNewExisting() {
		return this.flagNewExisting;
	}

	public void setFlagNewExisting(Character flagNewExisting) {
		this.flagNewExisting = flagNewExisting;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "survey_date", length = 29)
	public Date getSurveyDate() {
		return this.surveyDate;
	}

	public void setSurveyDate(Date surveyDate) {
		this.surveyDate = surveyDate;
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

	@Column(name = "girth_at_breast_hieght")
	public Integer getGirthAtBreastHieght() {
		return this.girthAtBreastHieght;
	}

	public void setGirthAtBreastHieght(Integer girthAtBreastHieght) {
		this.girthAtBreastHieght = girthAtBreastHieght;
	}

	@Column(name = "hieght")
	public Double getHieght() {
		return this.hieght;
	}

	public void setHieght(Double hieght) {
		this.hieght = hieght;
	}

	@Column(name = "approx_age")
	public Integer getApproxAge() {
		return this.approxAge;
	}

	public void setApproxAge(Integer approxAge) {
		this.approxAge = approxAge;
	}

	@Column(name = "canopy_width")
	public Double getCanopyWidth() {
		return this.canopyWidth;
	}

	public void setCanopyWidth(Double canopyWidth) {
		this.canopyWidth = canopyWidth;
	}

	@Column(name = "mseb_ctc_no", length = 50)
	public String getMsebCtcNo() {
		return this.msebCtcNo;
	}

	public void setMsebCtcNo(String msebCtcNo) {
		this.msebCtcNo = msebCtcNo;
	}

	@Column(name = "location", length = 50)
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "apartment_complex", length = 50)
	public String getApartmentComplex() {
		return this.apartmentComplex;
	}

	public void setApartmentComplex(String apartmentComplex) {
		this.apartmentComplex = apartmentComplex;
	}

	@Column(name = "road", length = 50)
	public String getRoad() {
		return this.road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	@Column(name = "building", length = 50)
	public String getBuilding() {
		return this.building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	@Column(name = "locality", length = 50)
	public String getLocality() {
		return this.locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	@Column(name = "longitude", length = 50)
	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Column(name = "latitude", length = 50)
	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name = "observation_remarks")
	public String getObservationRemarks() {
		return this.observationRemarks;
	}

	public void setObservationRemarks(String observationRemarks) {
		this.observationRemarks = observationRemarks;
	}

	@Column(name = "owner_aadhar_card", length = 50)
	public String getOwnerAadharCard() {
		return this.ownerAadharCard;
	}

	public void setOwnerAadharCard(String ownerAadharCard) {
		this.ownerAadharCard = ownerAadharCard;
	}

	@Column(name = "owner_name", length = 50)
	public String getOwnerName() {
		return this.ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Column(name = "owner_address")
	public String getOwnerAddress() {
		return this.ownerAddress;
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	@Column(name = "approve_flag", length = 1)
	public Character getApproveFlag() {
		return this.approveFlag;
	}

	public void setApproveFlag(Character approveFlag) {
		this.approveFlag = approveFlag;
	}

	@Column(name = "approve_remark")
	public String getApproveRemark() {
		return this.approveRemark;
	}

	public void setApproveRemark(String approveRemark) {
		this.approveRemark = approveRemark;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "approval_date", length = 29)
	public Date getApprovalDate() {
		return this.approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	@Column(name = "survey_number", length = 50)
	public String getSurveyNumber() {
		return this.surveyNumber;
	}

	public void setSurveyNumber(String surveyNumber) {
		this.surveyNumber = surveyNumber;
	}

	@Column(name = "tree_identification_no", length = 50)
	public String getTreeIdentificationNo() {
		return this.treeIdentificationNo;
	}

	public void setTreeIdentificationNo(String treeIdentificationNo) {
		this.treeIdentificationNo = treeIdentificationNo;
	}

	@Column(name = "port_data_flag", length = 1)
	public Character getPortDataFlag() {
		return this.portDataFlag;
	}

	public void setPortDataFlag(Character portDataFlag) {
		this.portDataFlag = portDataFlag;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ttTreeSurveyDetails")
	public Set<TtTreeSurveyUploadList> getTtTreeSurveyUploadLists() {
		return this.ttTreeSurveyUploadLists;
	}

	public void setTtTreeSurveyUploadLists(Set<TtTreeSurveyUploadList> ttTreeSurveyUploadLists) {
		this.ttTreeSurveyUploadLists = ttTreeSurveyUploadLists;
	}

	@Column(name = "inspected_by_user_id")
	public Integer getInspectedByUserId() {
		return inspectedByUserId;
	}

	public void setInspectedByUserId(Integer inspectedByUserId) {
		this.inspectedByUserId = inspectedByUserId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "inspected_on_date", length = 29)
	public Date getInspectedOnDate() {
		return inspectedOnDate;
	}

	public void setInspectedOnDate(Date inspectedOnDate) {
		this.inspectedOnDate = inspectedOnDate;
	}

	@Column(name = "lookup_det_hier_id_awz1")
	public Integer getLookupDetHierIdAwz1() {
		return this.lookupDetHierIdAwz1;
	}

	public void setLookupDetHierIdAwz1(Integer lookupDetHierIdAwz1) {
		this.lookupDetHierIdAwz1 = lookupDetHierIdAwz1;
	}

	@Column(name = "lookup_det_hier_id_awz2")
	public Integer getLookupDetHierIdAwz2() {
		return this.lookupDetHierIdAwz2;
	}

	public void setLookupDetHierIdAwz2(Integer lookupDetHierIdAwz2) {
		this.lookupDetHierIdAwz2 = lookupDetHierIdAwz2;
	}

	@Column(name = "lookup_det_id_olt")
	public Integer getLookupDetIdOlt() {
		return this.lookupDetIdOlt;
	}

	public void setLookupDetIdOlt(Integer lookupDetIdOlt) {
		this.lookupDetIdOlt = lookupDetIdOlt;
	}
	
	@Column(name = "lookup_det_id_rsu")
	public Integer getLookupDetIdRsu() {
		return this.lookupDetIdRsu;
	}

	public void setLookupDetIdRsu(Integer lookupDetIdRsu) {
		this.lookupDetIdRsu = lookupDetIdRsu;
	}

	@Column(name = "ref_no")
	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}



}
