package com.innowave.mahaulb.repository.inventory.repo;

import java.util.List;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvSupplier;

public interface MasterMaterialSupplierRepo {

	public void saveOrUpdate(TmInvSupplier invSupplier);
	
	public List<TmCmLookupDet> getLookUpByUlb(int ulbId);
	
	public List<TmInvSupplier> getSupplierTypList(TmInvSupplier invSupplier);
	
	public TmInvSupplier getSupplierById(Integer ulbId,Long id);
	
	public int removeStoreByID(TmInvSupplier invSupplier);
	
	public TmInvSupplier getSupplierByCode(TmInvSupplier invSupplier);
	
}
