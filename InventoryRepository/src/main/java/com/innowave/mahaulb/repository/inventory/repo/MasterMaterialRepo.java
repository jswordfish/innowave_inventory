package com.innowave.mahaulb.repository.inventory.repo;

import java.util.List;

import com.innowave.mahaulb.common.dao.TmCmLookupDetHierarchical;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterial;

public interface MasterMaterialRepo {

	public List<TmInvMaterial> getMaterialList(Long materialTyp,Integer ulbId,String materialCode);
	public TmInvMaterial getMaterialByiD(Integer materialId,Integer ulbId);
	public List<TmCmLookupDetHierarchical> getLookupDetByUlb(Integer ulbId);
	public int  removeMateria(TmInvMaterial invMaterial);
	public void saveOrUpdate(TmInvMaterial invMaterial);
	public TmInvMaterial getMaterialByMaterialCode(String materialCode,Integer ulbId);
	
}
