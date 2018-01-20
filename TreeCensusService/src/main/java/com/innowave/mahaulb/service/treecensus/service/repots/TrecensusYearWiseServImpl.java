package com.innowave.mahaulb.service.treecensus.service.repots;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;
import com.innowave.mahaulb.repository.treecensus.repository.reports.TrecensusYearWiseRepo;

@Service("trecensusYearWiseServ")
@Transactional
public class TrecensusYearWiseServImpl implements TrecensusYearWiseServ {

	@Autowired
	TrecensusYearWiseRepo trecensusYearWiseRepo;
	
	@Override
	public List<Object[]> getYearlyTreecensusData(TtTreeSurveyDetails ttTreeSurveyDetails,
			TmCmLookupDet tmCmLookupDet, int ulbIdAuto, String frDate, String toDate, int treeSpecies, String treeFamily) {
		return trecensusYearWiseRepo.getYearlyTreecensusData(ttTreeSurveyDetails, tmCmLookupDet, ulbIdAuto, frDate, toDate, treeSpecies, treeFamily);
	}

	@Override
	public TmUlb getUlbName(int ulbIdAuto) {
		return trecensusYearWiseRepo.getUlbName(ulbIdAuto);
	}
	
}
