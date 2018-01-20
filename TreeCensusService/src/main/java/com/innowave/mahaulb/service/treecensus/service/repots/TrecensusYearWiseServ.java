package com.innowave.mahaulb.service.treecensus.service.repots;

import java.util.List;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;

public interface TrecensusYearWiseServ {
	public List<Object[]> getYearlyTreecensusData(TtTreeSurveyDetails ttTreeSurveyDetails, TmCmLookupDet tmCmLookupDet, int ulbIdAuto,
			String frDate, String toDate, int treeSpecies, String TreeFamily);
	public TmUlb getUlbName(int ulbIdAuto);

}
