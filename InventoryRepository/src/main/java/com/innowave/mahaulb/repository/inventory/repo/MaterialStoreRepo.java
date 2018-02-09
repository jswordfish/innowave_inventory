package com.innowave.mahaulb.repository.inventory.repo;

import java.util.List;

import com.innowave.mahaulb.common.dao.master.TmUsers;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;

public interface MaterialStoreRepo {

	public void saveOrUpdate(TmInvStore invStore);
	
	public TmInvStore findTmInvStore(TmInvStore invStore,Integer ulbId);
	
	public List<TmUsers> getUserList(int ulbId);
	
	public int removeStoreByID(TmInvStore invStore);
	
	
	
	
	
	
}
