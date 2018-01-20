package com.innowave.mahaulb.service.treecensus.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.innowave.mahaulb.repository.treecensus.repository.TreeCensusSurvyAppInspctrRepo;
import com.innowave.mahaulb.service.treecensus.dto.SurveyApplicationInspectionDTO;
import com.innowave.mahaulb.service.treecensus.helper.TreeCencusHelper;

@Service("treeCensusSurvyAppInspctrService")
public class TreeCensusSurvyAppInspctrServiceImpl implements TreeCensusSurvyAppInspctrService{
    @Autowired
	TreeCensusSurvyAppInspctrRepo  treeCensusSurvyAppInspctrRepo;

    @Override
	public ArrayList<Object[]> getServiceRequestDetails(Long srnId, Integer ulbId) {
		return treeCensusSurvyAppInspctrRepo.getServiceRequestDetails(srnId,ulbId);
	}

	@Override
	public String updateTreecensusInspectionData(SurveyApplicationInspectionDTO surveyApplicationInspectionDTO) {
		TreeCencusHelper treeCencusHelper = new TreeCencusHelper();
		String respObj = treeCensusSurvyAppInspctrRepo.updateTreecensusInspectionData(treeCencusHelper.updateTreecensusInspectionData(surveyApplicationInspectionDTO));
		Gson gson = new Gson();
		return gson.toJson(respObj);
	}
}

