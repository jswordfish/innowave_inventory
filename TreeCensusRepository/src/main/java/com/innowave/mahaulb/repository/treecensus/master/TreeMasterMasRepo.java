package com.innowave.mahaulb.repository.treecensus.master;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.innowave.mahaulb.common.dao.TmCmLookup;
import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeMasterMas;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeNameMaster;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyUploadList;
 

public interface TreeMasterMasRepo {
	public Serializable save(TmTreeMasterMas tmTreeMasterMas); 
	public void update(TmTreeMasterMas tmTreeMasterMas);
	public List<TmTreeMasterMas> getTreeMasterMasList(TmTreeMasterMas tmTreeMasterMas);
	public void delete(TmTreeMasterMas tmTreeMasterMas);
	public Set<TmTreeMasterMas> getTreeMasterDetails(String lookupCode);
	public <TmTreeMaster> Serializable saveTreeMasterDetailsRepo(TmTreeNameMaster tmTreeNameMaster);
	public Set<TmTreeNameMaster> getTreeNameDetailsServ(String treeNameType, String searchString);
	public List<TmTreeMasterMas> getMasterDataListServ(String prefix,String searchString,int ulbIdAuto);
	public Serializable saveApplicationSurveyInspector(TtTreeSurveyDetails ttTreeSurveyDetails);
	public Serializable saveApplicationSurveyDetails(TtTreeSurveyDetails ttTreeSurveyDetails);
	
	public TmCmLookup getLookupId(String prefix);
	public List<TmCmLookupDet> getLookupDetId(int ulbId, int id);
	
	public void saveImageUrl(TtTreeSurveyUploadList ttTreeSurveyUploadList);
	
	public Set<TtTreeSurveyDetails> getDataBySrnNumber(String treeNameType, String searchString);
	
}
