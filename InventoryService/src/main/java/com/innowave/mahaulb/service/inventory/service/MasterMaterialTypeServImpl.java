package com.innowave.mahaulb.service.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialType;
import com.innowave.mahaulb.repository.inventory.dao.master.inventory.InventoryRepo;

@Service("MasterMaterialTypeServ")
public class MasterMaterialTypeServImpl implements MasterMaterialTypeServ{

	@Autowired
	private InventoryRepo inventoryRepo;
	@Override
	public int add(TmInvMaterialType invMaterialType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TmInvMaterialType> getMaterialTypeList(
			TmInvMaterialType invMaterialType) {
		return inventoryRepo.getTreeNameMasterList(invMaterialType);
	}

}
