package com.innowave.mahaulb.service.treecensus.dto.reports;

import java.io.Serializable;
import java.util.Date;

public class registerDataListOneBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int ulbId;
	private String ulbName;
	String surveyNm;
	String surveyDt;
	String propOwnerNm;
	String societyNm;
	String societyAddr;
	String msebCtcNo;
	String treeSpecies;
	String treeScientificNm; 
	String treeVernacularNm;
	String treeCommonNm;
	String barkShape;
	String leafShape;
	String leafColor;
	String texture;
	
	public int getUlbId() {
		return ulbId;
	}
	public void setUlbId(int ulbId) {
		this.ulbId = ulbId;
	}
	public String getUlbName() {
		return ulbName;
	}
	public void setUlbName(String ulbName) {
		this.ulbName = ulbName;
	}
	public String getSurveyNm() {
		return surveyNm;
	}
	public void setSurveyNm(String surveyNm) {
		this.surveyNm = surveyNm;
	}
	public String getSurveyDt() {
		return surveyDt;
	}
	public void setSurveyDt(String surveyDt) {
		this.surveyDt = surveyDt;
	}
	public String getPropOwnerNm() {
		return propOwnerNm;
	}
	public void setPropOwnerNm(String propOwnerNm) {
		this.propOwnerNm = propOwnerNm;
	}
	public String getSocietyNm() {
		return societyNm;
	}
	public void setSocietyNm(String societyNm) {
		this.societyNm = societyNm;
	}
	public String getSocietyAddr() {
		return societyAddr;
	}
	public void setSocietyAddr(String societyAddr) {
		this.societyAddr = societyAddr;
	}
	public String getMsebCtcNo() {
		return msebCtcNo;
	}
	public void setMsebCtcNo(String msebCtcNo) {
		this.msebCtcNo = msebCtcNo;
	}
	public String getTreeSpecies() {
		return treeSpecies;
	}
	public void setTreeSpecies(String treeSpecies) {
		this.treeSpecies = treeSpecies;
	}
	public String getTreeScientificNm() {
		return treeScientificNm;
	}
	public void setTreeScientificNm(String treeScientificNm) {
		this.treeScientificNm = treeScientificNm;
	}
	public String getTreeVernacularNm() {
		return treeVernacularNm;
	}
	public void setTreeVernacularNm(String treeVernacularNm) {
		this.treeVernacularNm = treeVernacularNm;
	}
	public String getTreeCommonNm() {
		return treeCommonNm;
	}
	public void setTreeCommonNm(String treeCommonNm) {
		this.treeCommonNm = treeCommonNm;
	}
	public String getBarkShape() {
		return barkShape;
	}
	public void setBarkShape(String barkShape) {
		this.barkShape = barkShape;
	}
	public String getLeafShape() {
		return leafShape;
	}
	public void setLeafShape(String leafShape) {
		this.leafShape = leafShape;
	}
	public String getLeafColor() {
		return leafColor;
	}
	public void setLeafColor(String leafColor) {
		this.leafColor = leafColor;
	}
	public String getTexture() {
		return texture;
	}
	public void setTexture(String texture) {
		this.texture = texture;
	}
	
	
}
