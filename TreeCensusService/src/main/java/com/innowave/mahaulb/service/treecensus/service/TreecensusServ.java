package com.innowave.mahaulb.service.treecensus.service;

import java.util.List;

import com.innowave.mahaulb.common.dao.TmCmApartment;
import com.innowave.mahaulb.common.dao.TmCmLocality;
import com.innowave.mahaulb.common.dao.TmCmLookupDetHierarchical;
import com.innowave.mahaulb.common.dao.TmCmRoad;
import com.innowave.mahaulb.common.dao.master.TmCmLocation;
import com.innowave.mahaulb.common.service.utils.beans.FilesBean;
import com.innowave.mahaulb.service.treecensus.bean.CitizenSurveyRequest;
import com.innowave.mahaulb.service.treecensus.bean.SurveyRequestBean;

public interface TreecensusServ 
{
	 public List<TmCmLocation> getLocationDataListServ(String searchString,int ulbIdAuto);
	 public List<TmCmApartment> getApartmentDataServ(String searchString,int ulbIdAuto);
	 public List<TmCmRoad> getRoadDataListServ(String searchString,int ulbIdAuto);
	 public List<TmCmLookupDetHierarchical> getLookupHierWordListServ(String searchString,int ulbIdAuto);
	 public List<TmCmLocality> getLocalityDataListServ(String searchString,int ulbIdAuto);
	public List<TmCmLookupDetHierarchical> getLookupHierZoneListServ(String searchString, int ulbIdAuto);
	 
	 public String saveSurvyData(SurveyRequestBean surveyRequestBean);
	 public int saveLocationData(SurveyRequestBean surveyRequestBean, long serviceId);
	 public String saveCitizenData(CitizenSurveyRequest applicationBean, FilesBean fileBeans);
	 
	 public String getTreeLocationData(int ulbId, long srnId);
}
