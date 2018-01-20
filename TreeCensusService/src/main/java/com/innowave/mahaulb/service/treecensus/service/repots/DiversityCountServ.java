package com.innowave.mahaulb.service.treecensus.service.repots;

import java.util.List;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;

public interface DiversityCountServ {

	TmUlb getUlbName(int ulbId);

	List<Object[]> getDiversityCountData(TtTreeSurveyDetails ttTreeSurveyDetails, TmCmLookupDet tmCmLookupDet,
			int ulbId, String fromDate, String toDate, int treespeciesId, int locationId, int treeCity,
			String treeWard, String treeZone);
	
	public String getUlbCity(Integer lookupDetHierIdCity);
}
