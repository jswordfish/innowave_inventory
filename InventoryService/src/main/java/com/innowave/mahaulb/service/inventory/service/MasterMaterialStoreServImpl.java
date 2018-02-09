package com.innowave.mahaulb.service.inventory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innowave.mahaulb.common.dao.master.TmCmDepartment;
import com.innowave.mahaulb.common.dao.master.TmUsers;
import com.innowave.mahaulb.common.repository.TmUsersRepo;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;
import com.innowave.mahaulb.repository.inventory.repo.MaterialStoreRepo;
import com.innowave.mahaulb.repository.inventory.repo.MaterialTypeRepo;
import com.innowave.mahaulb.repository.inventory.repo.MaterialTypeStoreMappingRepository;

@Service("MasterMaterialStoreServ")
public class MasterMaterialStoreServImpl implements MasterMaterialStoreServ{

	@Autowired
	MaterialTypeRepo materialTypeRepo;
	
	@Autowired
	TmUsersRepo userRepo;
	
	@Autowired
	MaterialStoreRepo materialStoreRepo;
	
	@Autowired
	MaterialTypeStoreMappingRepository materialTypeStoreMapping;
	
	@Override
	public List<TmCmDepartment> getAllDepartments(Integer ulbId) {
		// TODO Auto-generated method stub
		return materialTypeRepo.getAllDepartments(ulbId);
	}

	@Override
	public void saveOrUpdate(TmInvStore invStore) {
		materialStoreRepo.saveOrUpdate(invStore);
		
	}

	@Override
	public List<TmInvStore> getAllMaterialStores(Integer ulbId) {
		return materialTypeStoreMapping.getAllStores(ulbId);
	}

	@Override
	public List<TmInvStore> getAllMaterialStoresByIds(Integer ulbId,
			Long storeId, Integer deptId) {
		return materialTypeStoreMapping.getAllMaterialStoreList(ulbId, storeId, deptId);
	}

	@Override
	public List<TmUsers> getUserList(int ulbId) {
		return materialStoreRepo.getUserList(ulbId);
	}

	@Override
	public int removeStoreById(TmInvStore invStore) {
		return materialStoreRepo.removeStoreByID(invStore);
	}

}
