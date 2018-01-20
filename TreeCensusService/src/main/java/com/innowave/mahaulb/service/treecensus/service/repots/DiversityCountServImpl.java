package com.innowave.mahaulb.service.treecensus.service.repots;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;
import com.innowave.mahaulb.repository.treecensus.repository.reports.DiversityCountRepo;

@Service("diversityCountServ")
@Transactional
public class DiversityCountServImpl implements DiversityCountServ {
	
	@Autowired
	DiversityCountRepo diversityCountRepo;
	
	@Override
	public TmUlb getUlbName(int ulbId) {
		return diversityCountRepo.getUlbName(ulbId);
	}

	@Override
	public List<Object[]> getDiversityCountData(TtTreeSurveyDetails ttTreeSurveyDetails, TmCmLookupDet tmCmLookupDet,
			int ulbId, String fromDate, String toDate, int treespeciesId, int locationId, int treeCity,
			String treeWard, String treeZone) {
		return diversityCountRepo.getDiversityCountData(ttTreeSurveyDetails, tmCmLookupDet,
				ulbId, fromDate, toDate, treespeciesId, locationId, treeCity,
				treeWard, treeZone);
	}

	@Override
	public String getUlbCity(Integer lookupDetHierIdCity) {
		return diversityCountRepo.getUlbCity(lookupDetHierIdCity);
	}

}
