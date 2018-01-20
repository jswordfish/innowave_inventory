package com.innowave.mahaulb.repository.treecensus.repository;

import java.util.ArrayList;

import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;

public interface TreeLocationRepo {
	public int saveLocationData(TtTreeSurveyDetails ttTreeSurveyDetails);
	
	public ArrayList<Object[]> getTreeLocationData(int ulbId, long srnId);
}
