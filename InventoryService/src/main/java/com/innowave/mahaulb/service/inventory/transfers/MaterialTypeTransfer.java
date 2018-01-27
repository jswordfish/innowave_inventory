package com.innowave.mahaulb.service.inventory.transfers;

import java.util.HashSet;
import java.util.Set;

import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialType;
import com.innowave.mahaulb.service.inventory.dto.master.InventoryMasterMaterialTypeForm;

public class MaterialTypeTransfer {

	public TmInvMaterialType createMaterialType(InventoryMasterMaterialTypeForm inventoryMasterMaterialTypeForm)
	{
		TmInvMaterialType invMaterialType= new TmInvMaterialType();
		Set<TmInvMaterialType> invMaterialTypes= new HashSet<TmInvMaterialType>();
		invMaterialType.setMaterialTypeCode(inventoryMasterMaterialTypeForm.getMaterialTypeCode());
		invMaterialType.setMaterialTypeName(inventoryMasterMaterialTypeForm.getMaterialTypeName());
		invMaterialType.setMaterialTypeDesc(inventoryMasterMaterialTypeForm.getMaterialDesc());
		if(inventoryMasterMaterialTypeForm.isParentType())
		{
			invMaterialType.setStatus(1);	
		}
		else
		{
			invMaterialType.setStatus(0);	
		}
		//Set<String> parentMaterialTypeName=(Set<String>) inventoryMasterMaterialTypeForm.getParentMaterialName();
		
		return invMaterialType;
		
	}
}
 