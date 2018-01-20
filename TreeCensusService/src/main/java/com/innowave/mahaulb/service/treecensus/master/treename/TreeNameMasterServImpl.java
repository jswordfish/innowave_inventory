package com.innowave.mahaulb.service.treecensus.master.treename;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeNameMaster;
import com.innowave.mahaulb.repository.treecensus.master.treename.TreeNameMasterRepo;
import com.innowave.mahaulb.service.treecensus.dto.TreeNameSearchDto;

@Service("treeNameMasterServ")

public class TreeNameMasterServImpl implements TreeNameMasterServ {

	@Autowired
	private TreeNameMasterRepo treeNameMasterRepo;
	
	@Override
	public int save(TmTreeNameMaster tmTreeNameMaster) {
		return (int) treeNameMasterRepo.save(tmTreeNameMaster);
	}

	@Override
	public List<TmTreeNameMaster> getTreeNameMasterList(TreeNameSearchDto treeNameSearchDto) {
		TmTreeNameMaster tmTreeNameMaster = new TmTreeNameMaster();
		tmTreeNameMaster.setTreeComNameEn(treeNameSearchDto.getComSearch().trim());
		tmTreeNameMaster.setTreeFamNameEn(treeNameSearchDto.getFamSearch().trim());
		tmTreeNameMaster.setTreeSciNameEn(treeNameSearchDto.getSciSearch().trim());
		tmTreeNameMaster.setTreeVerNameEn(treeNameSearchDto.getVerSearch().trim());
		tmTreeNameMaster.setUlbId(treeNameSearchDto.getUlbId());
		return treeNameMasterRepo.getTreeNameMasterList(tmTreeNameMaster);
	}

	@Override
	public void updateTreeName(TmTreeNameMaster tmTreeNameMaster) {
		treeNameMasterRepo.updateTreeName(tmTreeNameMaster);
	}

	@Override
	public void deleteTreeName(TmTreeNameMaster tmTreeNameMaster) {
		treeNameMasterRepo.deleteTreeName(tmTreeNameMaster);
		
	}

	@Override
	public String getTreeNameDet(int id) {
		List<Object[]> obj = treeNameMasterRepo.getTreeNameDet(id);
		
		Gson gson = new Gson();
		String str = gson.toJson(obj);
		//return JsonResponseHelper.getJSONResponseString(str);
		return null;
	}

}
