package com.innowave.mahaulb.service.treecensus.dto.reports;

import java.util.List;

public class TreeCountReport {
	private static final long serialVersionUID = 1L;

	List<TreeCountBean> treeCount;

	public List<TreeCountBean> getTreeCount() {
		return treeCount;
	}

	public void setTreeCount(List<TreeCountBean> treeCount) {
		this.treeCount = treeCount;
	}
	
}
