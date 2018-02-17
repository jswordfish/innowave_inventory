package com.innowave.mahaulb.service.inventory.service;

import java.util.List;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.dao.TmCmLookupDetHierarchical;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterial;

public interface MasterMaterialServ {

	public List<TmInvMaterial> getMaterialTypList(Long materialtyp,Integer ulbId,String materialCode);
	public TmInvMaterial getMaterialbyId(Integer materialId,Integer ulbId);
	public List<TmCmLookupDetHierarchical> getBaseUom(Integer ulbId);
	public TmCmLookupDetHierarchical getBaseUom(Integer ulbId,Integer id);
	public List<TmCmLookupDet> getinvTypes(Integer ulbId);
	public int removeMaterial(TmInvMaterial invMaterial);
	public TmCmLookupDet getById(Integer id);
	public void saveOrUpdate(TmInvMaterial invMaterial);
}
