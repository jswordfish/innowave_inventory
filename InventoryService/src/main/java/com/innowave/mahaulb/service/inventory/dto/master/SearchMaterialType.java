package com.innowave.mahaulb.service.inventory.dto.master;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialType;

public class SearchMaterialType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<TmInvMaterialType> materialTypList;
	private Set<TmInvMaterialType> parentMaterialTypList;
	public Set<TmInvMaterialType> getParentMaterialTypList() {
		return parentMaterialTypList;
	}
	public void setParentMaterialTypList(
			Set<TmInvMaterialType> parentMaterialTypList) {
		this.parentMaterialTypList = parentMaterialTypList;
	}
	private MaterialTypeDTO materialTypeDTO;
	private List<MaterialTypeDTO> typeDTOs;
	public MaterialTypeDTO getMaterialTypeDTO() {
		return materialTypeDTO;
	}
	public void setMaterialTypeDTO(MaterialTypeDTO materialTypeDTO) {
		this.materialTypeDTO = materialTypeDTO;
	}
	public List<MaterialTypeDTO> getTypeDTOs() {
		return typeDTOs;
	}
	public void setTypeDTOs(List<MaterialTypeDTO> typeDTOs) {
		this.typeDTOs = typeDTOs;
	}
	private Long materialTypeId;
	private Long parentMaterialTypeId;
	private String materialTypeName;
	private String parentMaterialTyp;
	public Long getMaterialTypeId() {
		return materialTypeId;
	}
	public List<TmInvMaterialType> getMaterialTypList() {
		return materialTypList;
	}
	public void setMaterialTypList(List<TmInvMaterialType> materialTypList) {
		this.materialTypList = materialTypList;
	}
	public void setMaterialTypeId(Long materialTypeId) {
		this.materialTypeId = materialTypeId;
	}
	public Long getParentMaterialTypeId() {
		return parentMaterialTypeId;
	}
	public void setParentMaterialTypeId(Long parentMaterialTypeId) {
		this.parentMaterialTypeId = parentMaterialTypeId;
	}
	public String getMaterialTypeName() {
		return materialTypeName;
	}
	public void setMaterialTypeName(String materialTypeName) {
		this.materialTypeName = materialTypeName;
	}
	public String getParentMaterialTyp() {
		return parentMaterialTyp;
	}
	public void setParentMaterialTyp(String parentMaterialTyp) {
		this.parentMaterialTyp = parentMaterialTyp;
	}
}
