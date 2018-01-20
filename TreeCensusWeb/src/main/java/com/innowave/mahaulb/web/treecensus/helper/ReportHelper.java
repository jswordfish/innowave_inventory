package com.innowave.mahaulb.web.treecensus.helper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.service.LookupDetServ;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeMasterMas;
import com.innowave.mahaulb.service.treecensus.dto.reports.registerDataListOneBean;
import com.innowave.mahaulb.service.treecensus.dto.reports.registerDataListTwoBean;

public class ReportHelper {
	
	TmCmLookupDet tmCmLookupDet = new TmCmLookupDet();
	Map<Integer,TmCmLookupDet> map = new HashMap<Integer,TmCmLookupDet>();
	LookupDetServ lookupDetServ;
	
	public ReportHelper(LookupDetServ lookupDetServ) {
		this.lookupDetServ=lookupDetServ;
	}

	private Map<Integer,TmCmLookupDet> setLookupMap(List<TmCmLookupDet> lookupLst){
		 Map<Integer,TmCmLookupDet> map = new HashMap<Integer,TmCmLookupDet>();
		 lookupLst.forEach(tmCmLookupDet->{
			 map.put(tmCmLookupDet.getLookupDetId(), tmCmLookupDet);
			 System.out.println(tmCmLookupDet.getLookupDetId());
		 });	
		
		 return map;
	 }

	private Map<Integer,TmTreeMasterMas> setLookupMasMap(List<TmTreeMasterMas> lookupLst){
		 Map<Integer,TmTreeMasterMas> map = new HashMap<Integer,TmTreeMasterMas>();
		 lookupLst.forEach(tmTreeMasterMas->{
			 map.put(tmTreeMasterMas.getTreemasId(), tmTreeMasterMas);
			 System.out.println(tmTreeMasterMas.getTreemasId());
		 });	
		
		 return map;
	 }
	
	public List<registerDataListOneBean> getReportOneLstObj( List<Object[]>  ttTreeSurveyReportData) throws ParseException {
		List<registerDataListOneBean> lstrOneData = new ArrayList<registerDataListOneBean>();
//		map = setLookupMap(lookupDetServ.getLookupDetListFromPrefix("TRM"));
		for (Iterator<Object[]> it = ttTreeSurveyReportData.iterator(); it.hasNext();) {
			registerDataListOneBean rOneData = new registerDataListOneBean();
			Object[] obj =   it.next();	
			 /*Survey Number*/
			String surveyNo, ownerAddress;
			try {
				surveyNo = (String)obj[0].toString();
			}catch(NullPointerException n) {
				surveyNo = "";
			}
			String surveyDate = (String)obj[1].toString(); /*Survey Date*/
			String ownerName = (String)obj[2].toString(); /*Owner Name*/
			String apartmentComplex = (String)obj[3].toString(); /*Society Name*/
			try {
				ownerAddress = (String)obj[4].toString(); /*Owner Address*/
			} catch (NullPointerException n) {
				ownerAddress = "";
			}
			String msebCtcNo = (String)obj[5].toString(); /*MSEB CTC NO*/
			String treeSpecies = (String)obj[6].toString();// + "\n" + (String)obj[7].toString(); /*Tree Species*/
			String treeSciNameEn = (String)obj[8].toString();// + "\n" + (String)obj[9].toString(); /*Scintific Name*/
			String treeVerNameEn = (String)obj[10].toString();// + "\n" + (String)obj[11].toString(); /*Family Name*/
			String treeComNameEn = (String)obj[12].toString();// + "\n" + (String)obj[13].toString(); /*Comman Name*/
			String Bsm_treemasDescEn = (String)obj[14].toString();// + "\n" + (String)obj[15].toString(); /*Bark Shape Master*/
			String Lsm_treemasDescEn = (String)obj[16].toString();// + "\n" + (String)obj[17].toString(); /*Leaf Shape Master*/
			String Lcm_treemasDescEn = (String)obj[18].toString();// + "\n" + (String)obj[19].toString();/*Leaf Colour Master*/
			String Tms_treemasDescEn = (String)obj[20].toString();// + "\n" + (String)obj[21].toString();/*Texture Master*/

			rOneData.setSurveyNm(surveyNo);
			rOneData.setSurveyDt(surveyDate);
			rOneData.setPropOwnerNm(ownerName);
			rOneData.setSocietyNm(apartmentComplex);
			rOneData.setSocietyAddr(ownerAddress);
			rOneData.setMsebCtcNo(msebCtcNo);
			rOneData.setTreeSpecies(treeSpecies);
			rOneData.setTreeScientificNm(treeSciNameEn);
			rOneData.setTreeVernacularNm(treeVerNameEn);
			rOneData.setTreeCommonNm(treeComNameEn);
			rOneData.setBarkShape(Bsm_treemasDescEn);
			rOneData.setLeafShape(Lsm_treemasDescEn);
			rOneData.setLeafColor(Lcm_treemasDescEn);
			rOneData.setTexture(Tms_treemasDescEn);
			lstrOneData.add(rOneData);
		}
		
		return lstrOneData;
	}
	
	public List<registerDataListTwoBean> getReportTwoLstObj(List<Object[]>  ttTreeSurveyReportData) throws ParseException {
		List<registerDataListTwoBean> lstrTwoData = new ArrayList<registerDataListTwoBean>();
		for (Iterator<Object[]> it = ttTreeSurveyReportData.iterator(); it.hasNext();) {
			registerDataListTwoBean rTwoData = new registerDataListTwoBean();
			Object[] obj =   it.next();	
			String treeSize, treeHeight,treeApproxAge, girthAtBreastHieght,canopyWidth;
			String flowerColor  = (String)obj[22].toString();// + "\n" + (String)obj[23].toString(); /*Flower Color*/
			String fruitColor = (String)obj[24].toString();// + "\n" + (String)obj[25].toString(); /*Fruit Color*/
			String treeShape = (String)obj[26].toString();// + "\n" + (String)obj[27].toString(); /*Tree Shape */
			try {
				treeSize = (String)obj[28].toString();
			} catch (NullPointerException n) {
				treeSize = "";
			}
			try {
				treeHeight = (String)obj[29].toString();
			} catch (NullPointerException n) {
				treeHeight = "";
			}
			try {
				treeApproxAge = (String)obj[30].toString();
			} catch (NullPointerException n) {
				treeApproxAge = "";
			}
			String odour = (String)obj[31].toString();// + "\n" + (String)obj[32].toString(); /*Odour*/
			String treeStatus =  (String)obj[33].toString();// + "\n" + (String)obj[34].toString(); /*Tree Status*/
			String treeFamily = (String)obj[35].toString();// + "\n" + (String)obj[36].toString(); /*Tree Family*/
			try {
				girthAtBreastHieght = (String)obj[37].toString();
			} catch(NullPointerException n) {
				girthAtBreastHieght = "";
			}
			try {
				canopyWidth = (String)obj[38].toString();
			}catch (NullPointerException n) {
				canopyWidth = "";
			}
			String colorMst = (String)obj[39].toString();// + "\n" + (String)obj[40].toString(); /*Tree Family*/
			rTwoData.setFlowerColor(flowerColor);
			rTwoData.setFruitColor(fruitColor);
			rTwoData.setTreeShape(treeShape);
			rTwoData.setTreeSize(treeSize);
			rTwoData.setTreeHeight(treeHeight);
			rTwoData.setTreeApproxAge(treeApproxAge);
			rTwoData.setOdour(odour);
			rTwoData.setTreeStatus(treeStatus);
			rTwoData.setTreeFamily(treeFamily);
			rTwoData.setGirthAtBreastHieght(girthAtBreastHieght);
			rTwoData.setCanopyWidth(canopyWidth);
			lstrTwoData.add(rTwoData);
		}
		return lstrTwoData;
	}
}
