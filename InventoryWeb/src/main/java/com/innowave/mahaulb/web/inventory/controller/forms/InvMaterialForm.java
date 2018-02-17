package com.innowave.mahaulb.web.inventory.controller.forms;

import java.io.Serializable;
import java.util.List;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.dao.TmCmLookupDetHierarchical;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialType;
import com.innowave.mahaulb.service.inventory.dto.master.MasterMaterialDTO;

public class InvMaterialForm implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String materialCode;
	public String materialOldCode;
	public List<TmInvMaterialType> invMaterialTypes;
	public String selectedMaterialTyp;
	public String materialName;
	public List<MasterMaterialDTO> materialList;
	public MasterMaterialDTO selectedMaterial;
	public String materialDesc;
	public List<TmCmLookupDetHierarchical> baseUoms;
	public String selectedUmo;
	public List<TmCmLookupDet> inventoryTypes;
	public String selectedInvType;
	public String materialStatus;
	public String ratePerUnit;
	public List<TmCmLookupDetHierarchical> purchaseUoms;
	public String selectedPurchaseUom;
	public String accCode;
	public List<TmCmLookupDet> usageList;
	public String selectusage;
	public List<TmCmLookupDetHierarchical> stockUoms;
	public String selectedStockUom;
	public Integer minQty;
	public Integer maxQty;
	public Integer reOrderlvl;
	public Integer reOrderQty;
	public String selfLifeControl;
	public String getSelfLifeControl() {
		return selfLifeControl;
	}
	public void setSelfLifeControl(String selfLifeControl) {
		this.selfLifeControl = selfLifeControl;
	}
	public String getMaterialDesc() {
		return materialDesc;
	}
	public void setMaterialDesc(String materialDesc) {
		this.materialDesc = materialDesc;
	}
	public List<TmCmLookupDetHierarchical> getBaseUoms() {
		return baseUoms;
	}
	public void setBaseUoms(List<TmCmLookupDetHierarchical> baseUoms) {
		this.baseUoms = baseUoms;
	}
	public String getSelectedUmo() {
		return selectedUmo;
	}
	public void setSelectedUmo(String selectedUmo) {
		this.selectedUmo = selectedUmo;
	}
	public List<TmCmLookupDet> getInventoryTypes() {
		return inventoryTypes;
	}
	public void setInventoryTypes(List<TmCmLookupDet> inventoryTypes) {
		this.inventoryTypes = inventoryTypes;
	}
	public String getSelectedInvType() {
		return selectedInvType;
	}
	public void setSelectedInvType(String selectedInvType) {
		this.selectedInvType = selectedInvType;
	}
	public String getMaterialStatus() {
		return materialStatus;
	}
	public void setMaterialStatus(String materialStatus) {
		this.materialStatus = materialStatus;
	}
	public String getRatePerUnit() {
		return ratePerUnit;
	}
	public void setRatePerUnit(String ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}
	public List<TmCmLookupDetHierarchical> getPurchaseUoms() {
		return purchaseUoms;
	}
	public void setPurchaseUoms(List<TmCmLookupDetHierarchical> purchaseUoms) {
		this.purchaseUoms = purchaseUoms;
	}
	public String getSelectedPurchaseUom() {
		return selectedPurchaseUom;
	}
	public void setSelectedPurchaseUom(String selectedPurchaseUom) {
		this.selectedPurchaseUom = selectedPurchaseUom;
	}
	public String getAccCode() {
		return accCode;
	}
	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}
	public List<TmCmLookupDet> getUsageList() {
		return usageList;
	}
	public void setUsageList(List<TmCmLookupDet> usageList) {
		this.usageList = usageList;
	}
	public String getSelectusage() {
		return selectusage;
	}
	public void setSelectusage(String selectusage) {
		this.selectusage = selectusage;
	}
	public List<TmCmLookupDetHierarchical> getStockUoms() {
		return stockUoms;
	}
	public void setStockUoms(List<TmCmLookupDetHierarchical> stockUoms) {
		this.stockUoms = stockUoms;
	}
	public String getSelectedStockUom() {
		return selectedStockUom;
	}
	public void setSelectedStockUom(String selectedStockUom) {
		this.selectedStockUom = selectedStockUom;
	}
	public Integer getMinQty() {
		return minQty;
	}
	public void setMinQty(Integer minQty) {
		this.minQty = minQty;
	}
	public Integer getMaxQty() {
		return maxQty;
	}
	public void setMaxQty(Integer maxQty) {
		this.maxQty = maxQty;
	}
	public Integer getReOrderlvl() {
		return reOrderlvl;
	}
	public void setReOrderlvl(Integer reOrderlvl) {
		this.reOrderlvl = reOrderlvl;
	}
	public Integer getReOrderQty() {
		return reOrderQty;
	}
	public void setReOrderQty(Integer reOrderQty) {
		this.reOrderQty = reOrderQty;
	}

	
	
	public List<MasterMaterialDTO> getMaterialList() {
		return materialList;
	}
	public void setMaterialList(List<MasterMaterialDTO> materialList) {
		this.materialList = materialList;
	}
	public MasterMaterialDTO getSelectedMaterial() {
		return selectedMaterial;
	}
	public void setSelectedMaterial(MasterMaterialDTO selectedMaterial) {
		this.selectedMaterial = selectedMaterial;
	}
	public String getMaterialCode() {
		return materialCode;
	}
	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}
	public String getMaterialOldCode() {
		return materialOldCode;
	}
	public void setMaterialOldCode(String materialOldCode) {
		this.materialOldCode = materialOldCode;
	}
	public List<TmInvMaterialType> getInvMaterialTypes() {
		return invMaterialTypes;
	}
	public void setInvMaterialTypes(List<TmInvMaterialType> invMaterialTypes) {
		this.invMaterialTypes = invMaterialTypes;
	}
	public String getSelectedMaterialTyp() {
		return selectedMaterialTyp;
	}
	public void setSelectedMaterialTyp(String selectedMaterialTyp) {
		this.selectedMaterialTyp = selectedMaterialTyp;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

}
