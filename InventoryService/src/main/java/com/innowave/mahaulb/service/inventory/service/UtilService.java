package com.innowave.mahaulb.service.inventory.service;

import java.util.List;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvSupplier;

public interface UtilService {
	
	public List<TmCmLookupDet> getByULBId(Integer ulbid);
	
	public List<TmInvSupplier> getSuppliersBy(Integer ulbid);
	
	public TmCmLookupDet resolveById(Integer id);
	
	public TmInvSupplier resolveById(Long id);

}
