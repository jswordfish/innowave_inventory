package com.innowave.mahaulb.service.treecensus.master.treemastermas;

import java.util.List;
import java.util.Set;

import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeMasterMas;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeNameMaster;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;
import com.innowave.mahaulb.service.treecensus.bean.TreeSurveyDetailsBean;
import com.innowave.mahaulb.service.treecensus.bean.TtTreeSurveyDetailsBean;
 
 
public interface TreeMasterMasServ {
	public int save(TmTreeMasterMas tmTreeMasterMas);
	public void update(TmTreeMasterMas tmTreeMasterMas);
	public List<TmTreeMasterMas> getTreeMasterMasList(TmTreeMasterMas tmTreeMasterMas);
	public void delete(TmTreeMasterMas tmTreeMasterMas);
	public Set<TmTreeMasterMas> getTreeMasterDetails(String prefix);
	 public List<TmTreeMasterMas> getMasterDataListServ(String prefix, String searchString,int ulbIdAuto);
	public int saveTreeMasterDetailsServ(TreeSurveyDetailsBean treeSurveyDetailsBean);
	public Set<TmTreeNameMaster> getTreeNameDetailsServ(String treeNameType, String searchString);
	public int saveApplicationSurveyInspector(TtTreeSurveyDetailsBean ttTreeSurveyDetails);
	public int saveApplicationSurveyDetails(TtTreeSurveyDetailsBean ttTreeSurveyDetails);
	
	public String getlookupDetData(int ulbID,String prefix);
	
	
	public Set<TtTreeSurveyDetails> getDataBySrnNumber(String treeNameType, String searchString);
	
}
