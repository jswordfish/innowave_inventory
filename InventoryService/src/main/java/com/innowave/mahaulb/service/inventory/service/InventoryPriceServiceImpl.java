package com.innowave.mahaulb.service.inventory.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innowave.mahaulb.repository.inventory.dao.trans.TtInvRateContract;
import com.innowave.mahaulb.repository.inventory.repo.TtInvRateContractRepo;
@Service
public class InventoryPriceServiceImpl implements InventoryPriceService {
	@Autowired
	TtInvRateContractRepo repo;
	
	@Override
	public TtInvRateContract getById(Long id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

	@Override
	public void saveOrUpdate(TtInvRateContract contractRepo) {
		// TODO Auto-generated method stub
		repo.saveOrUpdate(contractRepo);
	}

	@Override
	public List<TtInvRateContract> fetchBy(Long supplierId, Long rateTypeId, Date aStartDate, Date aEndDate) {
		// TODO Auto-generated method stub
		return repo.fetchBy(supplierId, rateTypeId, aStartDate, aEndDate);
	}

	@Override
	public int removeTtInvRateContract(Long id) {
		// TODO Auto-generated method stub
		return repo.removeTtInvRateContract(id);
	}

}
