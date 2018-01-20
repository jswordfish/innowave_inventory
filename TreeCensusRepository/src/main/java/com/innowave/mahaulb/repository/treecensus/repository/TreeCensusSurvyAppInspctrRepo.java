package com.innowave.mahaulb.repository.treecensus.repository;

import java.util.ArrayList;
import java.util.List;

import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;

public interface TreeCensusSurvyAppInspctrRepo {
	public ArrayList<Object[]> getServiceRequestDetails(Long srnId,Integer ulbId);
	String updateTreecensusInspectionData(TtTreeSurveyDetails updateTreecensusInspectionData);
}
