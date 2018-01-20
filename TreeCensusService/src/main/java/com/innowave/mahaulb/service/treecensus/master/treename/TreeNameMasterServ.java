package com.innowave.mahaulb.service.treecensus.master.treename;

import java.util.List;

import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeNameMaster;
import com.innowave.mahaulb.service.treecensus.dto.TreeNameSearchDto;

public interface TreeNameMasterServ {

	public int save(TmTreeNameMaster tmTreeNameMaster);
	public List<TmTreeNameMaster> getTreeNameMasterList(TreeNameSearchDto treeNameSearchDto);
	public void updateTreeName(TmTreeNameMaster tmTreeNameMaster);
	public void deleteTreeName(TmTreeNameMaster tmTreeNameMaster);
		public String getTreeNameDet(int id);
}
