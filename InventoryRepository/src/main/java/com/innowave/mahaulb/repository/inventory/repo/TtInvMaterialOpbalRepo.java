package com.innowave.mahaulb.repository.inventory.repo;

import java.util.List;

import com.innowave.mahaulb.common.dao.TmCmFinancialMas;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterial;
import com.innowave.mahaulb.repository.inventory.dao.trans.TtInvMaterialOpbal;

public interface TtInvMaterialOpbalRepo {

	
	public TtInvMaterialOpbal getTtInvMaterialOpbal(int ubId, long materialId, long storeId, int finId);
	
	public TtInvMaterialOpbal saveOrUpdate(TtInvMaterialOpbal invMaterialOpbal);
	
	public List<TmCmFinancialMas> getTmCmFinancialMas();
	
	public List<TmInvMaterial> getMaterialsByULB(Integer ulbId);
	
	public List<TtInvMaterialOpbal> getTtInvMaterialOpbalForMaterialAndStore(long materialId, long storeId);
	
	public List<TmInvMaterial> getMaterialsByULBAndStore(Integer ulbId, long storeId);
	
	public TmInvMaterial resolveMaterial(Long materialId);
	
	public TmCmFinancialMas resolveTmCmFinancialMas(Integer finId);
	
	public TtInvMaterialOpbal getTtInvMaterialOpbal(long id) ;
	
	public void deleteOpBalById(long id);
}
