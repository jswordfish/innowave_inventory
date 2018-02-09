package com.innowave.mahaulb.service.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialType;
import com.innowave.mahaulb.repository.inventory.repo.MaterialTypeRepo;

@Service("MasterMaterialTypeServ")
public class MasterMaterialTypeServImpl implements MasterMaterialTypeServ{

	@Autowired
	private MaterialTypeRepo inventoryRepo;
	

	@Override
	public List<TmInvMaterialType> getMaterialTypeList(Integer ulbId,String parentFlag) {
		return inventoryRepo.getMasterTypeistByUlbAndParentTyp(ulbId,parentFlag);
	}


	@Override
	public void saveOrUpdate(TmInvMaterialType invMaterialType) {
		inventoryRepo.saveOrUpdate(invMaterialType);
		
	}


	@Override
	public List<TmInvMaterialType> getMaterialTypeByParentType(Integer ulbId,
			String materialTypId, String parentMaterialTyp) {
		return inventoryRepo.fetchMaterialTypeByParentType(ulbId, materialTypId, parentMaterialTyp);
	}




}
