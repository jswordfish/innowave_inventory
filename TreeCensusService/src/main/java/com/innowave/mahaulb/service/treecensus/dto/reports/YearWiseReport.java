package com.innowave.mahaulb.service.treecensus.dto.reports;

import java.io.Serializable;
import java.util.List;

public class YearWiseReport implements Serializable{
	private static final long serialVersionUID = 1L;
	
	List<YearWiseDataBean> yearWiseData;

	public List<YearWiseDataBean> getYearWiseData() {
		return yearWiseData;
	}

	public void setYearWiseData(List<YearWiseDataBean> yearWiseData) {
		this.yearWiseData = yearWiseData;
	}


}
