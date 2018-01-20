package com.innowave.mahaulb.repository.treecensus.master.treename;

import java.io.Serializable;
import java.util.List;

import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeNameMaster;
 
public interface TreeNameMasterRepo {

	public Serializable save(TmTreeNameMaster tmTreeNameMaster);
	public List<TmTreeNameMaster> getTreeNameMasterList(TmTreeNameMaster treeNameSearchDto);
	public void updateTreeName(TmTreeNameMaster tmTreeNameMaster);
	public void deleteTreeName(TmTreeNameMaster tmTreeNameMaster);
	
	public List<Object[]> getTreeNameDet(int id);
}
