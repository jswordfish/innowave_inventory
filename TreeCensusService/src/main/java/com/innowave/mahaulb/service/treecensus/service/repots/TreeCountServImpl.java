package com.innowave.mahaulb.service.treecensus.service.repots;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;
import com.innowave.mahaulb.repository.treecensus.repository.reports.DiversityCountRepo;
import com.innowave.mahaulb.repository.treecensus.repository.reports.TreeCountRepo;

@Service("treeCountServ")
@Transactional
public class TreeCountServImpl implements TreeCountServ {

	@Autowired
	TreeCountRepo treeCountRepo;
	
	@Override
	public TmUlb getUlbName(int ulbId) {
		// TODO Auto-generated method stub
		return treeCountRepo.getUlbName(ulbId);
	}

	@Override
	public List<Object[]> getTreeCountData(TtTreeSurveyDetails ttTreeSurveyDetails, TmCmLookupDet tmCmLookupDet,
			int ulbId, String fromDate, String toDate, int treespeciesId, int locationId, int treeCity,
			String treeWard, String treeZone) {
		// TODO Auto-generated method stub
		return treeCountRepo.getTreeCountDatav(ttTreeSurveyDetails, tmCmLookupDet, ulbId, 
				fromDate, toDate, treespeciesId, locationId, treeCity,
				treeWard, treeZone) ;
	}

	@Override
	public String getUlbCity(Integer lookupDetHierIdCity) {
		return  treeCountRepo.getUlbCity(lookupDetHierIdCity);
	}

}
