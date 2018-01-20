package com.innowave.mahaulb.service.treecensus.service.repots;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeNameMaster;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;
import com.innowave.mahaulb.repository.treecensus.repository.reports.TreecensusRegReportRepo;

@Service("trecensusRegRepoServ")
@Transactional
public class TrecensusRegRepoServImpl implements TrecensusRegRepoServ {
	@Autowired
	TreecensusRegReportRepo trecensusRegReportRepo;
	@Override
	public List<Object[]> getSurveyRequestData(TtTreeSurveyDetails ttTreeSurveyDetails, TmTreeNameMaster tmTreeNameMaster,  int ulbIdAuto, String frDate, String toDate, String surveyNm, String surveyDate,
			int treeSpecies, String treeFamily, int ward, int zone, String societyNm, String mseb_ctcNo, String propOwnerNo, String treeScientificNm, String treeVernaNm, String treeCommonNm) {
		return trecensusRegReportRepo.getSurveyRequestData(ttTreeSurveyDetails,tmTreeNameMaster,ulbIdAuto, frDate, toDate,surveyNm, surveyDate,
				treeSpecies, treeFamily, ward, zone, societyNm, mseb_ctcNo, propOwnerNo, treeScientificNm, treeVernaNm, treeCommonNm);
	}
	
	@Override
	public Map<Integer, String> getTreeMasterData(String lookupCode) {
		return trecensusRegReportRepo.getTreeMasterData(lookupCode);
	}

	@Override
	public List<TmTreeNameMaster> getTreeMasterName(int ulbIdAuto) {
		return trecensusRegReportRepo.getTreeMasterName(ulbIdAuto);
	}

	@Override
	public TmUlb getUlbName(int ulbIdAuto) {
		return trecensusRegReportRepo.getUlbName(ulbIdAuto);
	}
}
