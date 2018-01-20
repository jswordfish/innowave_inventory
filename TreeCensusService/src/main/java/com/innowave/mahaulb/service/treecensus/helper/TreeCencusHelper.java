package com.innowave.mahaulb.service.treecensus.helper;

import com.innowave.mahaulb.common.dao.trans.TtServiceRequest;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeNameMaster;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;
import com.innowave.mahaulb.service.treecensus.dto.SurveyApplicationInspectionDTO;

public class TreeCencusHelper {

	public TtTreeSurveyDetails updateTreecensusInspectionData(SurveyApplicationInspectionDTO surveyApplicationInspectionDTO) {
		TtTreeSurveyDetails ttTreeSurveyDetails=new TtTreeSurveyDetails();
		TtServiceRequest ttServiceRequest=new TtServiceRequest();
		TmTreeNameMaster tmTreeNameMaster = new TmTreeNameMaster(); 
		ttTreeSurveyDetails.setObservationRemarks(surveyApplicationInspectionDTO.getObservationRemarks());
		ttTreeSurveyDetails.setLatitude(surveyApplicationInspectionDTO.getLatitude());
		ttTreeSurveyDetails.setLongitude(surveyApplicationInspectionDTO.getLongitude());
		if(surveyApplicationInspectionDTO.getLocality() != null){
			ttTreeSurveyDetails.setLocality(surveyApplicationInspectionDTO.getLocality());
		}
		ttTreeSurveyDetails.setBuilding(surveyApplicationInspectionDTO.getBuilding());
		if(surveyApplicationInspectionDTO.getRoad() != null){
			ttTreeSurveyDetails.setRoad(surveyApplicationInspectionDTO.getRoad());
		}
		ttTreeSurveyDetails.setApartmentComplex(surveyApplicationInspectionDTO.getApartmentComplex());
		ttTreeSurveyDetails.setLocation(surveyApplicationInspectionDTO.getLocation());
		ttTreeSurveyDetails.setSurveyDate(surveyApplicationInspectionDTO.getSurveyDate());
		ttTreeSurveyDetails.setGirthAtBreastHieght(surveyApplicationInspectionDTO.getGirthAtBreastHieght());
		ttTreeSurveyDetails.setApproxAge(surveyApplicationInspectionDTO.getApproxAge());
		ttTreeSurveyDetails.setCanopyWidth(surveyApplicationInspectionDTO.getCanopyWidth());
		ttTreeSurveyDetails.setHieght(surveyApplicationInspectionDTO.getHieght());
		ttTreeSurveyDetails.setSizeValue(surveyApplicationInspectionDTO.getSizeValue());
		ttTreeSurveyDetails.setMsebCtcNo(surveyApplicationInspectionDTO.getMsebCtcNo());
		ttServiceRequest.setSrnId(surveyApplicationInspectionDTO.getSrnId());
		ttTreeSurveyDetails.setTtServiceRequest(ttServiceRequest);
		ttTreeSurveyDetails.setTreemasIdBsm(surveyApplicationInspectionDTO.getTreemasIdBsm());
		ttTreeSurveyDetails.setTreemasIdCom(surveyApplicationInspectionDTO.getTreemasIdCom());
		ttTreeSurveyDetails.setTreemasIdFrm(surveyApplicationInspectionDTO.getTreemasIdFrm());
		ttTreeSurveyDetails.setTreemasIdFnm(surveyApplicationInspectionDTO.getTreemasIdFnm());
		ttTreeSurveyDetails.setTreemasIdLcm(surveyApplicationInspectionDTO.getTreemasIdLcm());
		ttTreeSurveyDetails.setTreemasIdLsm(surveyApplicationInspectionDTO.getTreemasIdLsm());
		ttTreeSurveyDetails.setTreemasIdOdm(surveyApplicationInspectionDTO.getTreemasIdOdm());
		ttTreeSurveyDetails.setTreemasIdSma(surveyApplicationInspectionDTO.getTreemasIdSma());
		ttTreeSurveyDetails.setTreemasIdTms(surveyApplicationInspectionDTO.getTreemasIdTms());
		ttTreeSurveyDetails.setTreemasIdTsm(surveyApplicationInspectionDTO.getTreemasIdTsm());
		ttTreeSurveyDetails.setTreemasIdTst(surveyApplicationInspectionDTO.getTreemasIdTst());
		tmTreeNameMaster.setTreenameId(surveyApplicationInspectionDTO.getTreeNameId());
		ttTreeSurveyDetails.setTmTreeNameMaster(tmTreeNameMaster);
		return ttTreeSurveyDetails;
	}

}
