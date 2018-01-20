package com.innowave.mahaulb.service.treecensus.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.innowave.mahaulb.common.dao.TmCmApartment;
import com.innowave.mahaulb.common.dao.TmCmLocality;
import com.innowave.mahaulb.common.dao.TmCmLookupDetHierarchical;
import com.innowave.mahaulb.common.dao.TmCmRoad;
import com.innowave.mahaulb.common.dao.TmCmServices;
import com.innowave.mahaulb.common.dao.master.TmCmLocation;
import com.innowave.mahaulb.common.dao.trans.TtServiceRequest;
import com.innowave.mahaulb.common.service.ApplicationRequestServ;
import com.innowave.mahaulb.common.service.TmServiceService;
import com.innowave.mahaulb.common.service.utils.FileUploaderService;
import com.innowave.mahaulb.common.service.utils.ScrutinyUtils;
import com.innowave.mahaulb.common.service.utils.beans.FilesBean;
import com.innowave.mahaulb.portal.utils.StringHelperUtils;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;
import com.innowave.mahaulb.repository.treecensus.repo.GetTreeSeqNoRepo;
import com.innowave.mahaulb.repository.treecensus.repository.TreeLocationRepo;
import com.innowave.mahaulb.repository.treecensus.repository.TreecensusRepo;
import com.innowave.mahaulb.service.treecensus.bean.CitizenSurveyRequest;
import com.innowave.mahaulb.service.treecensus.bean.SurveyRequestBean;


@Service("treecensusServ")
public class TreecensusServImpl implements TreecensusServ {
	@Autowired
	TreecensusRepo treecensusrepo;
	
	@Autowired
	TreeLocationRepo locationRepo;

	@Autowired
	ApplicationRequestServ applicationRequestServ;
	
	 @Autowired 
	 FileUploaderService fileUploaderService;
	
	@Autowired
	TmServiceService tmService;
	
	@Autowired
	private HttpSession httpsession;

	@Autowired
	private ScrutinyUtils scrutinyutils;
	
	@Autowired
	GetTreeSeqNoRepo seqNoRepo;
	int modId = -1;
	@Override
	public List<TmCmLocality> getLocalityDataListServ(String searchString, int ulbIdAuto) {
		return treecensusrepo.getLocalityDataListServ(searchString, ulbIdAuto);
	}
	
	@Override
	public List<TmCmLocation> getLocationDataListServ(String searchString, int ulbIdAuto) {
		return treecensusrepo.getLocationDataListServ(searchString, ulbIdAuto);
	}
	
	@Override
	public List<TmCmApartment> getApartmentDataServ(String searchString, int ulbIdAuto) {
		return treecensusrepo.getApartmentDataListServ(searchString, ulbIdAuto);
	}
	
	@Override
	public List<TmCmRoad> getRoadDataListServ(String searchString, int ulbIdAuto) {
		return treecensusrepo.getRoadDataListServ(searchString, ulbIdAuto);
	}
	
	@Override
	public String saveSurvyData(SurveyRequestBean surveyRequestBean) {
		TtServiceRequest obj = new TtServiceRequest();
		TmCmServices objSer = new TmCmServices();
		/*As per changes in SrnNumber from Mode Id so added below function*/
		modId = seqNoRepo.getModId("TRR"); /*ModuleName is TRR*/
		/*As per changes in SrnNumber from Mode Id so added below function*/
		objSer = tmService.getTmCmService("TAS");
		objSer.setServiceId(objSer.getServiceId());
		/*Added New Logic for SRN Number*/
		String preFix = surveyRequestBean.getUlbCode();
		//obj.setSrNumber("MAHA-ULB-"+objSer.getServiceShortCode()+"-"+CommonUtils.getOTP());
		/*As per changes in SrnNumber from Mode Id so added below function*/
		//String srnNumber=applicationRequestServ.getSrnNumber(preFix,surveyRequestBean.getUlbId(),DateTimeZoneHelper.getSysDate());
		String srnNumber=applicationRequestServ.getSrnNumber(preFix,surveyRequestBean.getUlbId(),null,modId);
		//End New SrnNumber generation based on SrnNumber.
		/*Added New Logic for SRN Number*/
		obj.setSrNumber(srnNumber);
		obj.setTmCmServices(objSer);
		obj.setSrDate(new Date());
		obj.setUlbId(surveyRequestBean.getUlbId());
		obj.setApplicationStatus(0);
		obj.setApplicantAddress(surveyRequestBean.getApplicantAddress());
		obj.setApplicantName(surveyRequestBean.getApplicantFirstName().trim()+ " " + surveyRequestBean.getApplicantMiddName().trim()+ "" + surveyRequestBean.getApplicantLastName().trim());
		obj.setApplicantUid(surveyRequestBean.getAadharNo());
		obj.setApplicantMobile(surveyRequestBean.getApplicantMobile());
		obj.setApplicantEmail(surveyRequestBean.getApplicantEmail());
		obj.setOrganisationAddress(surveyRequestBean.getOrganisationAddress());
		obj.setOrganisationName(surveyRequestBean.getOrganisationName());
		applicationRequestServ.saveApplicationData(obj);
		Integer intSrnId = ((Number)obj.getSrnId()).intValue();
		scrutinyutils.scrutinyflow(surveyRequestBean.getUlbId(), objSer.getServiceId(), intSrnId, 0);
		
		saveLocationData(surveyRequestBean, obj.getSrnId());
		
		return srnNumber;
	}

	@Override
	public List<TmCmLookupDetHierarchical> getLookupHierWordListServ(String searchString, int ulbIdAuto) {
		return treecensusrepo.getLookupHierWordListServ(searchString, ulbIdAuto);
	}
	
	@Override
	public int saveLocationData(SurveyRequestBean surveyRequestBean, long serviceId) {
		TtTreeSurveyDetails ttTreeSurveyDetails = new TtTreeSurveyDetails(); 
		TtServiceRequest obj = new TtServiceRequest();
		TmCmApartment aprtment = new TmCmApartment();
		TmCmLocality locality = new TmCmLocality();
		TmCmLocation location = new TmCmLocation();
		TmCmRoad road = new TmCmRoad();
		obj.setSrnId(serviceId);
		aprtment.setApartmentId(surveyRequestBean.getAprtName());
		locality.setLocalityId(surveyRequestBean.getLocalityName());
		location.setLocationId(surveyRequestBean.getLocName());
		road.setRoadId(surveyRequestBean.getRoadName());
		System.out.println("ApartmentID :" + surveyRequestBean.getAprtName());
		ttTreeSurveyDetails.setTmCmApartment(aprtment);
		System.out.println("LocalityId :" + surveyRequestBean.getLocalityName());
		ttTreeSurveyDetails.setTmCmLocality(locality);
		System.out.println("LocationID :" + surveyRequestBean.getLocName());
		ttTreeSurveyDetails.setTmCmLocation(location);
		System.out.println("RoadId :" + surveyRequestBean.getRoadName());
		ttTreeSurveyDetails.setTmCmRoad(road);
		ttTreeSurveyDetails.setLocation(surveyRequestBean.getLocationId());
		ttTreeSurveyDetails.setTtServiceRequest(obj);
		ttTreeSurveyDetails.setApartmentComplex(surveyRequestBean.getApartmentId());
		ttTreeSurveyDetails.setRoad(surveyRequestBean.getRoadId());
		ttTreeSurveyDetails.setLocality(surveyRequestBean.getLocalityId());
		ttTreeSurveyDetails.setLookupDetHierIdAwz1( surveyRequestBean.getWardName());
		if (surveyRequestBean.getZoneName() > 0 ) {
			ttTreeSurveyDetails.setLookupDetHierIdAwz2(surveyRequestBean.getZoneName());
		}
		ttTreeSurveyDetails.setCreatedBy(surveyRequestBean.getCreatedBy());
		ttTreeSurveyDetails.setUlbId(surveyRequestBean.getUlbId());
		ttTreeSurveyDetails.setLatitude(surveyRequestBean.getLatitude());
		ttTreeSurveyDetails.setLongitude(surveyRequestBean.getLongitude());
		ttTreeSurveyDetails.setStatus(0);
		ttTreeSurveyDetails.setSurveyDate(surveyRequestBean.getSurveyDate());
		ttTreeSurveyDetails.setCreatedDate(surveyRequestBean.getCreatedDate());
		locationRepo.saveLocationData(ttTreeSurveyDetails);
		return 0;
	}

	@Override
	public String saveCitizenData(CitizenSurveyRequest applicationBean, FilesBean fileBeans) {
			TtServiceRequest obj = new TtServiceRequest();
			TmCmServices objSer = new TmCmServices();
			TtTreeSurveyDetails ttTreeSurveyDetails = new TtTreeSurveyDetails(); 
			TmCmApartment aprtment = new TmCmApartment();
			TmCmLocality locality = new TmCmLocality();
			TmCmLocation location = new TmCmLocation();
			TmCmRoad road = new TmCmRoad();
			objSer = tmService.getTmCmService("TAS");
			objSer.setServiceId(objSer.getServiceId());
			/*Added New Logic for SRN Number*/
			/*As per changes in SrnNumber from Mode Id so added below function*/
			modId = seqNoRepo.getModId("TRR"); /*ModuleName is TRR*/
			/*As per changes in SrnNumber from Mode Id so added below function*/
			String preFix = "";
			if(applicationBean.getUlbIdDesc() != "")
			{
				String[] a = applicationBean.getUlbIdDesc().split("\\|");;
				applicationBean.setUlbId(Integer.parseInt(a[0]));
				preFix = a[1];
			}
			//obj.setSrNumber("MAHA-ULB-"+objSer.getServiceShortCode()+"-"+CommonUtils.getOTP());
			//String srnNumber=applicationRequestServ.getSrnNumber(preFix,applicationBean.getUlbId(),DateTimeZoneHelper.getSysDate(), modId);
			String srnNumber=applicationRequestServ.getSrnNumber(preFix,applicationBean.getUlbId(),null, modId);
			obj.setSrNumber(srnNumber);
			/*Added New Logic for SRN Number*/
			obj.setTmCmServices(objSer);
			obj.setSrDate(new Date());
			obj.setUlbId(applicationBean.getUlbId());
			obj.setApplicationStatus(0);
			obj.setApplicantAddress(applicationBean.getApplicantAddress());
			obj.setApplicantName(applicationBean.getApplicantFirstName().trim()+ " " + applicationBean.getApplicantMiddName().trim()+ "" + applicationBean.getApplicantLastName().trim());
			obj.setApplicantUid(applicationBean.getAadharNo());
			obj.setApplicantMobile(applicationBean.getApplicantMobile());
			obj.setApplicantEmail(applicationBean.getApplicantEmail());
			obj.setOrganisationAddress(applicationBean.getOrganisationAddress());
			obj.setOrganisationName(applicationBean.getOrganisationName());
			obj.setCreatedDate(applicationBean.getCreatedDate());
			obj.setCreatedBy(1);

			/*Location data*/
			aprtment.setApartmentId(applicationBean.getAprtId());
			locality.setLocalityId(applicationBean.getLocalityId());
			location.setLocationId(applicationBean.getLocId());
			road.setRoadId(applicationBean.getRoadId());	
			ttTreeSurveyDetails.setTmCmApartment(aprtment);
			ttTreeSurveyDetails.setTmCmLocality(locality);
			ttTreeSurveyDetails.setTmCmLocation(location);
			ttTreeSurveyDetails.setTmCmRoad(road);
			ttTreeSurveyDetails.setLocation(applicationBean.getLocName());
			ttTreeSurveyDetails.setTtServiceRequest(obj); System.out.println("Srn_id set poperly....");
			ttTreeSurveyDetails.setApartmentComplex(applicationBean.getAprtName());
			ttTreeSurveyDetails.setRoad(applicationBean.getRoadName());
			ttTreeSurveyDetails.setLocality(applicationBean.getLocalityName());
			ttTreeSurveyDetails.setCreatedBy(applicationBean.getCreatedBy());
			ttTreeSurveyDetails.setUlbId(applicationBean.getUlbId());
			ttTreeSurveyDetails.setLatitude(applicationBean.getLatitude());
			ttTreeSurveyDetails.setLongitude(applicationBean.getLongitude());
			ttTreeSurveyDetails.setStatus(0);
			ttTreeSurveyDetails.setSurveyDate(applicationBean.getSurveyDate());
			ttTreeSurveyDetails.setCreatedDate(applicationBean.getCreatedDate());
			ttTreeSurveyDetails.setLookupDetHierIdAwz1(applicationBean.getWardId());
			if (applicationBean.getZoneId() > 0 ) {
				ttTreeSurveyDetails.setLookupDetHierIdAwz2(applicationBean.getZoneId());
			}
			ttTreeSurveyDetails.setCreatedBy(1);
			long serviceId = applicationRequestServ.saveApplicationData(obj);
			Integer intSrnId = ((Number)serviceId).intValue();
			scrutinyutils.scrutinyflow(applicationBean.getUlbId(), objSer.getServiceId(), intSrnId, 0);
			
			int surveyId = locationRepo.saveLocationData(ttTreeSurveyDetails);
			//httpsession.setAttribute("serviceTblId", surveyId);
			List<MultipartFile> files = fileBeans.getFiles();
			if(files != null && files.size()>0)
			{
				try 
				{			 
					List<String> filePath = fileUploaderService.uploadMultiFiles(fileBeans, applicationBean.getUlbId(),"TAS" ,Integer.parseInt(Long.toString(serviceId)), surveyId);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}		 	
			
			return srnNumber;
	}

	@Override
	public List<TmCmLookupDetHierarchical> getLookupHierZoneListServ(String searchString, int ulbIdAuto) {
		return treecensusrepo.getLookupHierZordListServ(searchString, ulbIdAuto);
	}

	@Override
	public String getTreeLocationData(int ulbId, long srnId) {
		CitizenSurveyRequest citizenSurveyRequest = new CitizenSurveyRequest();
		List<Object[]> obj = locationRepo.getTreeLocationData(ulbId, srnId);
		Object[] obj1 = obj.get(0);
		Object[] obj2 = null;
		Object[] obj3 = null;
		if(obj.size() >1){
			obj2 = obj.get(1);
		}
		if(obj.size() >2){
			obj3 = obj.get(2);
		}
		
		citizenSurveyRequest.setLocName(StringHelperUtils.isNullString(obj1[2]));
		citizenSurveyRequest.setAprtName(StringHelperUtils.isNullString(obj1[3]));
		citizenSurveyRequest.setRoadName(StringHelperUtils.isNullString(obj1[4]));
		citizenSurveyRequest.setLocalityName(StringHelperUtils.isNullString(obj1[5]));
		citizenSurveyRequest.setLatitude(StringHelperUtils.isNullString(obj1[7]));
		citizenSurveyRequest.setLongitude(StringHelperUtils.isNullString(obj1[6]));
		
		if(obj.size() >1){
			citizenSurveyRequest.setWardId(StringHelperUtils.isNullInt(obj1[8]));
			citizenSurveyRequest.setWardName(StringHelperUtils.isNullString(obj2[0]));
		}
		
		if(obj.size() >2){
			citizenSurveyRequest.setZoneId(StringHelperUtils.isNullInt(obj1[9]));
			citizenSurveyRequest.setZoneName(StringHelperUtils.isNullString(obj3[0]));
		}
		
		Gson gson = new Gson();
		String str =gson.toJson(citizenSurveyRequest);
		return str;

	}

}
