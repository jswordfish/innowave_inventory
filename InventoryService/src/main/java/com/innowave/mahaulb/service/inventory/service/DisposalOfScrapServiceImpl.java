package com.innowave.mahaulb.service.inventory.service;

import java.util.Date;
import java.util.List;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innowave.mahaulb.repository.inventory.dao.trans.TtInvScrap;
import com.innowave.mahaulb.repository.inventory.repo.TtInvScrapRepo;

@Service
public class DisposalOfScrapServiceImpl implements DisposalOfScrapService{
	@Autowired
	TtInvScrapRepo repo;
	
	@Override
	public List<TtInvScrap> getScraps(Integer ulbId, String disposalNo, Long storeId, Date disposalFromDate,
			Date disposalToDate, Character status) {
		return repo.getScraps(ulbId, disposalNo, storeId, disposalFromDate, disposalToDate, status);
	}

	@Override
	public TtInvScrap saveOrUpdate(TtInvScrap scrap) {
		// TODO Auto-generated method stub
		return repo.saveOrUpdate(scrap);
	}

	@Override
	public TtInvScrap getUnique(Long storeId, Integer ulbId, String disposalNo) {
		return repo.getUnique(storeId, ulbId, disposalNo);
	}

	@Override
	public TtInvScrap getUniqueById(Long scrapId) {
		return repo.getUniqueById(scrapId);
	}

	@Override
	public void deleteById(Long scrapId) {
		repo.deleteById(scrapId);
		
	}

}
