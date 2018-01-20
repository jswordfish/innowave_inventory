package com.innowave.mahaulb.repository.treecensus.repository.reports;

import java.util.List;
import java.util.Map;

import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeNameMaster;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;

public interface TreecensusRegReportRepo {
	public List<Object[]> getSurveyRequestData(TtTreeSurveyDetails ttTreeSurveyDetails, TmTreeNameMaster tmTreeNameMaster,  int ulbIdAuto, String frDate, String toDate, String surveyNm, String surveyDate,
			int treeSpecies, String treeFamily, int ward, int zone, String societyNm, String mseb_ctcNo, String propOwnerNo, String treeScientificNm, String treeVernaNm, String treeCommonNm);
	public Map<Integer, String> getTreeMasterData(String lookupCode);
	public List<TmTreeNameMaster> getTreeMasterName(int ulbIdAuto);
	public TmUlb getUlbName(int ulbIdAuto);
}
