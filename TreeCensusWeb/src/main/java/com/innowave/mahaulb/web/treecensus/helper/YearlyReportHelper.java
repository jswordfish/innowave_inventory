package com.innowave.mahaulb.web.treecensus.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.innowave.mahaulb.service.treecensus.dto.reports.YearWiseDataBean;

public class YearlyReportHelper {
	public List<YearWiseDataBean> getReportLstObj(List<Object[]> yearlyData) {
		List<YearWiseDataBean> lstrData = new ArrayList<YearWiseDataBean>();
		System.out.println("yearlyData :::: " + yearlyData.size());
		for (Iterator<Object[]> it = yearlyData.iterator(); it.hasNext();) {
			YearWiseDataBean yearlyBeanData = new YearWiseDataBean();
			Object[] obj =   it.next();	
			String year = (String)obj[0];
			String treeFamily = (String)obj[1];
			String treeFamilyMh = (String)obj[2];
			String treeSpecies = (String)obj[3];
			String treeSpeciesMh = (String)obj[4];
			String treeStatus = (String)obj[5];
			
			yearlyBeanData.setYear(" " + year);
			yearlyBeanData.setTreeFamily(" " + treeFamily.trim() + "\n" + " " + treeFamilyMh.trim());
			yearlyBeanData.setTreeSpecies(" " + treeSpecies.trim() + "\n" +" " +  treeSpeciesMh.trim());
			yearlyBeanData.setTreeStatus(" " + treeStatus);
			lstrData.add(yearlyBeanData);
		}
		return lstrData;
	}
}
