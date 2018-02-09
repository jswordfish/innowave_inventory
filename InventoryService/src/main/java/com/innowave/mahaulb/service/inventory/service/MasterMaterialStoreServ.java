package com.innowave.mahaulb.service.inventory.service;

import java.util.List;

import com.innowave.mahaulb.common.dao.master.TmCmDepartment;
import com.innowave.mahaulb.common.dao.master.TmUsers;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;

public interface MasterMaterialStoreServ {

	public List<TmCmDepartment> getAllDepartments(Integer ulbId);
	
	public List<TmInvStore> getAllMaterialStores(Integer ulbId);
	
	public List<TmInvStore> getAllMaterialStoresByIds(Integer ulbId,Long storeId,Integer deptId );
	
	public List<TmUsers> getUserList(int ulbId);
	
	public void saveOrUpdate(TmInvStore invStore);
	
	public int removeStoreById(TmInvStore invStore);
	
}
