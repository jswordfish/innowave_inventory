package com.innowave.mahaulb.web.treecensus.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.innowave.mahaulb.service.treecensus.dto.reports.DiversityCountBean;

public class DiversityCountHelper {

	public List<DiversityCountBean> getReportLstObj(List<Object[]> diversityCountData) {
		List<DiversityCountBean> lstrData = new ArrayList<DiversityCountBean>();
		System.out.println("diversityCountData :::: " + diversityCountData.size());
		for (Iterator<Object[]> it = diversityCountData.iterator(); it.hasNext();) {
			DiversityCountBean diversityBeanData = new DiversityCountBean();
			Object[] obj =   it.next();	
			String treeFamily = (String)obj[0];
			String treeFamilyMh = (String)obj[1];
			String treeSpecies = (String)obj[2];
			String treeSpeciesMh = (String)obj[3];
			String treeCnt = (String)obj[4].toString();
			
			diversityBeanData.setTreeFamily(" " + treeFamily.trim() + "\n" + " " + treeFamilyMh.trim());
			diversityBeanData.setTreeSpecies(" " + treeSpecies.trim() + "\n" +" " +  treeSpeciesMh.trim());
			diversityBeanData.setCnt(treeCnt +" ");
			lstrData.add(diversityBeanData);
		}
		return lstrData;
	}

}
