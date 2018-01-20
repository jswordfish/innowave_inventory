package com.innowave.mahaulb.service.treecensus.dto.master;

import java.io.Serializable;

import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeMasterMas;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeNameMaster;
import com.innowave.mahaulb.service.treecensus.dto.TreeNameSearchDto;


public class TreeMasterMasForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TmTreeMasterMas tmTreeMasterMas;
	private TmTreeNameMaster tmTreeNameMaster;
	private TreeNameSearchDto treeNameSearchDto;
	private String status;
	private String searchKey;
	
	
	public TmTreeMasterMas getTmTreeMasterMas() {
		return tmTreeMasterMas;
	}
	public void setTmTreeMasterMas(TmTreeMasterMas tmTreeMasterMas) {
		this.tmTreeMasterMas = tmTreeMasterMas;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public TmTreeNameMaster getTmTreeNameMaster() {
		return tmTreeNameMaster;
	}
	public void setTmTreeNameMaster(TmTreeNameMaster tmTreeNameMaster) {
		this.tmTreeNameMaster = tmTreeNameMaster;
	}
	public TreeNameSearchDto getTreeNameSearchDto() {
		return treeNameSearchDto;
	}
	public void setTreeNameSearchDto(TreeNameSearchDto treeNameSearchDto) {
		this.treeNameSearchDto = treeNameSearchDto;
	}
	
}
