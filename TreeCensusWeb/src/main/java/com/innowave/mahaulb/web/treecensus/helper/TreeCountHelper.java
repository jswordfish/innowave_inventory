package com.innowave.mahaulb.web.treecensus.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.innowave.mahaulb.service.treecensus.dto.reports.TreeCountBean;

public class TreeCountHelper {

	public List<TreeCountBean> getReportLstObj(List<Object[]> treeCountData) {
		List<TreeCountBean> lstrData = new ArrayList<TreeCountBean>();
		System.out.println("treeCountData :::: " + treeCountData.size());
		for (Iterator<Object[]> it = treeCountData.iterator(); it.hasNext();) {
			TreeCountBean treeCountBeanData = new TreeCountBean();
			Object[] obj =   it.next();	
			String treeFamily = (String)obj[0];
			String treeFamilyMh = (String)obj[1];
			String treeSpecies = (String)obj[2];
			String treeSpeciesMh = (String)obj[3];
			String treeStatus = (String)obj[4];
			String treeCnt = (String)obj[5].toString();
			
			treeCountBeanData.setTreeFamily(" " + treeFamily.trim() + "\n" + " " + treeFamilyMh.trim());
			treeCountBeanData.setTreeSpecies(" " + treeSpecies.trim() + "\n" +" " +  treeSpeciesMh.trim());
			treeCountBeanData.setTreeStatus(" " + treeStatus);
			treeCountBeanData.setCnt(treeCnt +" ");
			lstrData.add(treeCountBeanData );
		}
		return lstrData;
	}

}
