package com.innowave.mahaulb.service.inventory.service;

import java.util.List;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvSupplier;

public interface MasterMaterialSupplierServ {

	public List<TmCmLookupDet> getSupplierListByUlb(int ulbId);
	
	public TmCmLookupDet getLookUpById(Integer id,Integer ulbId);
	
	public List<TmInvSupplier> supplierTypList(TmInvSupplier invSupplier);
	
	public TmInvSupplier getSUpplierById(Integer ulbId,Long id);
	
	public void saveOrUpdate(TmInvSupplier invSupplier);
	
	public int removeStoreByID(TmInvSupplier invSupplier);
	
	public TmInvSupplier getSupplierByCode(TmInvSupplier invSupplier);
}
