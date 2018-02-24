package com.innowave.mahaulb.service.inventory.service;

import java.util.List;

import com.innowave.mahaulb.repository.inventory.dao.trans.TtInvScrap;

public interface DisposalOfScrapService {
public List<TtInvScrap> getScraps(Integer ulbId, String disposalNo, Long storeId, java.util.Date disposalFromDate, java.util.Date disposalToDate, Character status);
	
	public TtInvScrap saveOrUpdate(TtInvScrap scrap);
	
	public TtInvScrap getUnique(Long storeId, Integer ulbId, String disposalNo);
	
	public TtInvScrap getUniqueById(Long scrapId);
	
	public void deleteById(Long scrapId);
}
