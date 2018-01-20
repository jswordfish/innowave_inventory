package com.innowave.mahaulb.service.treecensus.dto.reports;

import java.io.Serializable;

public class YearWiseDataBean implements Serializable {
	private static final long serialVersionUID = 1L;

	String year;
	String treeFamily;
	String treeSpecies;
	String treeStatus;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
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
}
