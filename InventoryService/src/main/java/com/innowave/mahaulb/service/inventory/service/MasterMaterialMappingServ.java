package com.innowave.mahaulb.service.inventory.service;

import java.util.List;

import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialTypeStoreMapping;

public interface MasterMaterialMappingServ {

	public int add(TmInvMaterialTypeStoreMapping tmInvMaterialTypeStoreMappingSave);
	public void edit(TmInvMaterialTypeStoreMapping tmInvMaterialTypeStoreMappingUpdate);
	public List<TmInvMaterialTypeStoreMapping> getInventoryMaterialTypeStoreMappingList(TmUlb tmUlb);
	public void search(String  getMaterialTypeStoreMapId);
}
