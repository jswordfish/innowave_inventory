package com.innowave.mahaulb.service.treecensus.service;

import java.util.ArrayList;
import java.util.List;

import com.innowave.mahaulb.service.treecensus.dto.SurveyApplicationInspectionDTO;

public interface TreeCensusSurvyAppInspctrService {
	public ArrayList<Object[]> getServiceRequestDetails(Long srnId,Integer ulbId);
	public String updateTreecensusInspectionData(SurveyApplicationInspectionDTO surveyApplicationInspectionDTO);
}