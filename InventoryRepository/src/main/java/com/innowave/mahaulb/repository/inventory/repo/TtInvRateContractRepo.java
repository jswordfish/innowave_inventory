package com.innowave.mahaulb.repository.inventory.repo;

import java.util.Date;
import java.util.List;

import com.innowave.mahaulb.repository.inventory.dao.trans.TtInvRateContract;

public interface TtInvRateContractRepo {
	
	public TtInvRateContract getById(Long id);
	
	public void saveOrUpdate(TtInvRateContract contractRepo);
	
	public List<TtInvRateContract> fetchBy(Long supplierId, Long rateTypeId, Date aStartDate, Date aEndDate);
	
	public int  removeTtInvRateContract(Long id);

}
