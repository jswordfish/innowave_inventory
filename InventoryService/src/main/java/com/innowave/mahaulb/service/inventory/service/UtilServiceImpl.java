package com.innowave.mahaulb.service.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvSupplier;
import com.innowave.mahaulb.repository.inventory.repo.UtilRepo;
@Service
public class UtilServiceImpl implements UtilService{
	
	@Autowired
	UtilRepo utilRepo;

	@Override
	public List<TmCmLookupDet> getByULBId(Integer ulbid) {
		// TODO Auto-generated method stub
	return utilRepo.getByULBId(ulbid);
	}
	
	public List<TmInvSupplier> getSuppliersBy(Integer ulbid){
		return utilRepo.getSuppliersBy(ulbid);
	}

	@Override
	public TmCmLookupDet resolveById(Integer id) {
		// TODO Auto-generated method stub
		return utilRepo.resolveById(id);
	}

	@Override
	public TmInvSupplier resolveById(Long id) {
		// TODO Auto-generated method stub
		return utilRepo.resolveById(id);
	}

}
