package com.innowave.mahaulb.repository.inventory.repo;

import java.util.List;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvSupplier;

public interface UtilRepo {
	
	public List<TmCmLookupDet> getByULBId(Integer ulbid);
	
	public TmCmLookupDet resolveById(Integer id);
	
	public TmInvSupplier resolveById(Long id);
	
	public List<TmInvSupplier> getSuppliersBy(Integer ulbid);
	
	public TmUlb resolveUlb(int ulbId) ;

}
