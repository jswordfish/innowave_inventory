package com.innowave.mahaulb.service.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.repository.TmCmLookupDetRepo;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvSupplier;
import com.innowave.mahaulb.repository.inventory.repo.MasterMaterialSupplierRepo;

@Service("MasterMaterialSupplierServ")
public class MasterMaterialSupplierServImpl implements MasterMaterialSupplierServ{

	@Autowired
	MasterMaterialSupplierRepo masterMaterialSupplierRepo;
	
	@Autowired
	TmCmLookupDetRepo supplierTypRepo;
	
	@Override
	public List<TmCmLookupDet> getSupplierListByUlb(int ulbId) {
		return masterMaterialSupplierRepo.getLookUpByUlb(ulbId);
	}

	@Override
	public TmCmLookupDet getLookUpById(Integer id, Integer ulbId) {
		return supplierTypRepo.getlookUpDetById(id);
	}

	@Override
	public List<TmInvSupplier> supplierTypList(TmInvSupplier invSupplier) {
		return masterMaterialSupplierRepo.getSupplierTypList(invSupplier);
	}

	@Override
	public TmInvSupplier getSUpplierById(Integer ulbId, Long id) {
		return masterMaterialSupplierRepo.getSupplierById(ulbId, id);
	}

	@Override
	public void saveOrUpdate(TmInvSupplier invSupplier) {
		masterMaterialSupplierRepo.saveOrUpdate(invSupplier);
		
	}

	@Override
	public int removeStoreByID(TmInvSupplier invSupplier) {
		return masterMaterialSupplierRepo.removeStoreByID(invSupplier);
	}

	@Override
	public TmInvSupplier getSupplierByCode(TmInvSupplier invSupplier) {
		return masterMaterialSupplierRepo.getSupplierByCode(invSupplier);
	}

}
