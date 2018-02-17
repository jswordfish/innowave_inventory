package com.innowave.mahaulb.service.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.dao.TmCmLookupDetHierarchical;
import com.innowave.mahaulb.common.repository.TmCmLookupDetHierarchicalRepo;
import com.innowave.mahaulb.common.repository.TmCmLookupDetRepo;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterial;
import com.innowave.mahaulb.repository.inventory.repo.MasterMaterialRepo;

@Service("MasterMaterialServ")
public class MasterMaterialServImpl implements MasterMaterialServ{

	@Autowired
	MasterMaterialRepo materialRepo;
	
	@Autowired
	TmCmLookupDetHierarchicalRepo lookupDetIdBaseUomRepo;
	
	@Autowired
	TmCmLookupDetRepo tmcmInvTypesRepo;
	

	@Override
	public List<TmInvMaterial> getMaterialTypList(Long materialtyp,
			Integer ulbId, String materialCode) {
		return materialRepo.getMaterialList(materialtyp, ulbId, materialCode);
	}

	@Override
	public TmInvMaterial getMaterialbyId(Integer materialId, Integer ulbId) {
		return materialRepo.getMaterialByiD(materialId, ulbId);
	}

	@Override
	public List<TmCmLookupDetHierarchical> getBaseUom(Integer ulbId) {
		return materialRepo.getLookupDetByUlb(ulbId);
	}

	@Override
	public List<TmCmLookupDet> getinvTypes(Integer ulbId) {
		return null;
	}

	@Override
	public int removeMaterial(TmInvMaterial invMaterial) {
		// TODO Auto-generated method stub
		return materialRepo.removeMateria(invMaterial);
	}

	@Override
	public TmCmLookupDet getById(Integer id) {
		return tmcmInvTypesRepo.getlookUpDetById(id);
	}

	@Override
	public TmCmLookupDetHierarchical getBaseUom(Integer ulbId, Integer id) {
		return lookupDetIdBaseUomRepo.findHierarchicalById(id, ulbId);
	}

	@Override
	public void saveOrUpdate(TmInvMaterial invMaterial) {
		materialRepo.saveOrUpdate(invMaterial);
		
	}

}
