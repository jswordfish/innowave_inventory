package com.innowave.mahaulb.service.inventory.dto.master;

import java.util.ArrayList;
import java.util.List;

public class InventoryMaterialMappingForm {

	String department;

	String store;

	List<MaterialTypeMappingDTO> mappingDTOs = new ArrayList<>();

	MaterialTypeMappingDTO currentMappingDTO = new MaterialTypeMappingDTO();

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public List<MaterialTypeMappingDTO> getMappingDTOs() {
		return mappingDTOs;
	}

	public void setMappingDTOs(List<MaterialTypeMappingDTO> mappingDTOs) {
		this.mappingDTOs = mappingDTOs;
	}

	public MaterialTypeMappingDTO getCurrentMappingDTO() {
		return currentMappingDTO;
	}

	public void setCurrentMappingDTO(MaterialTypeMappingDTO currentMappingDTO) {
		this.currentMappingDTO = currentMappingDTO;
	}

}
