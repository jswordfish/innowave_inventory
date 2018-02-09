package com.innowave.mahaulb.repository.inventory.repo;

import java.util.List;

import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialTypeStoreMapping;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;

public interface MaterialTypeStoreMappingRepository {
	
	public void saveOrUpdate(TmInvMaterialTypeStoreMapping mapping);
	
	public TmInvMaterialTypeStoreMapping findMapping(String storeCode, String materialTypeCode, Integer ulbId);
	
	public List<TmInvStore> getAllStores(Integer ulbId);
	
	public List<TmInvMaterialTypeStoreMapping> getMappings(String storeCode, Integer ulbId);
	
	public List<TmInvStore> getAllStoresForDepartment(Integer ulbId, Integer depId);
	
	public List<TmInvStore> getAllMaterialStoreList(Integer ulbId,Long storeId, Integer depId);
	
	public TmInvStore getStoreById(Long storeId);
	
	public int removeTmInvMaterialTypeStoreMapping(TmInvMaterialTypeStoreMapping mapping);

}
