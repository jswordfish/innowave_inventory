package com.innowave.mahaulb.service.inventory.service;

import java.util.List;

import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialType;

public interface MasterMaterialTypeServ {

	public void saveOrUpdate(TmInvMaterialType invMaterialType);
	public List<TmInvMaterialType> getMaterialTypeList(Integer ulbId,String parentFlag);
	public List<TmInvMaterialType> getMaterialTypeByParentType(Integer ulbId,String materialTypId,String parentMaterialTyp);
	public TmInvMaterialType getById(Long materialTypId);
	public int removeById(TmInvMaterialType  invMaterialType);
	public List<TmInvMaterialType> findMaterialTypesByUlb(Integer ulbId);
}
