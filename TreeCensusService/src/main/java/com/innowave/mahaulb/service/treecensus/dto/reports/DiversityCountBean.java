package com.innowave.mahaulb.service.treecensus.dto.reports;

import java.io.Serializable;

public class DiversityCountBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String treeFamily;
	String treeSpecies;
	String cnt;
	public String getTreeFamily() {
		return treeFamily;
	}
	public void setTreeFamily(String treeFamily) {
		this.treeFamily = treeFamily;
	}
	public String getTreeSpecies() {
		return treeSpecies;
	}
	public void setTreeSpecies(String treeSpecies) {
		this.treeSpecies = treeSpecies;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	
	
}