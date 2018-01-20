package com.innowave.mahaulb.service.treecensus.dto.reports;

import java.io.Serializable;

public class TreeCountBean implements Serializable{
	private static final long serialVersionUID = 1L;
	String treeFamily;
	String treeSpecies;
	String treeStatus;
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
	public String getTreeStatus() {
		return treeStatus;
	}
	public void setTreeStatus(String treeStatus) {
		this.treeStatus = treeStatus;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	
	
}
