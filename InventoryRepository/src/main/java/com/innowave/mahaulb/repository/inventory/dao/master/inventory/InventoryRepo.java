package com.innowave.mahaulb.repository.inventory.dao.master.inventory;

import java.util.List;

import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialType;

public interface InventoryRepo {

	public List<TmInvMaterialType> getTreeNameMasterList(TmInvMaterialType treeNameSearchDto);
}
