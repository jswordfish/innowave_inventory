package com.innowave.mahaulb.service.treecensus.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;
import com.innowave.mahaulb.repository.treecensus.repository.TreeLocationRepo;

@Service("treeLocationServ")
@Transactional
public class TreeLocationServImpl implements TreeLocationServ {
	@Autowired
	TreeLocationRepo ttTreeSurveyDetailsRepo;
	@Override
	public long saveLocationData(TtTreeSurveyDetails ttTreeSurveyDetails) {
		// TODO Auto-generated method stub
		return ttTreeSurveyDetailsRepo.saveLocationData(ttTreeSurveyDetails);
	}
}
