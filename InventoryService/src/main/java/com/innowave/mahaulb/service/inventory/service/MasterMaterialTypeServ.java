package com.innowave.mahaulb.service.inventory.service;

import java.util.List;

import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialType;

public interface MasterMaterialTypeServ {

	public int add(TmInvMaterialType invMaterialType);
	public List<TmInvMaterialType> getMaterialTypeList(TmInvMaterialType invMaterialType);
	
}
