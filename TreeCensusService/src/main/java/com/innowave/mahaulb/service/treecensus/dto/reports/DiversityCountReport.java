package com.innowave.mahaulb.service.treecensus.dto.reports;

import java.io.Serializable;
import java.util.List;

public class DiversityCountReport implements Serializable{

	private static final long serialVersionUID = 1L;

	List<DiversityCountBean> diversityCount;

	public List<DiversityCountBean> getDiversityCount() {
		return diversityCount;
	}

	public void setDiversityCount(List<DiversityCountBean> diversityCount) {
		this.diversityCount = diversityCount;
	}
	
	
}
