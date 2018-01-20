package com.innowave.mahaulb.service.treecensus.dto;

import java.util.Set;

import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeMasterMas;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeNameMaster;

public class TreeCensusCommDto

{
 
	Set<TmTreeMasterMas> treespeciesList;
	Set<TmTreeMasterMas> barkList;
	Set<TmTreeMasterMas> leafShapeList;
	Set<TmTreeMasterMas> leafcolourList;
	Set<TmTreeMasterMas> textureList;
	Set<TmTreeMasterMas> flowernameList;
	Set<TmTreeMasterMas> colorMasterList;
	Set<TmTreeMasterMas> fruitnameList;
	Set<TmTreeMasterMas> shapeList;
	Set<TmTreeMasterMas> odourList;
	Set<TmTreeMasterMas> treestatusList;
	Set<TmTreeNameMaster> tmtreenameList;
	
	public Set<TmTreeMasterMas> getTreespeciesList() {
		return treespeciesList;
	}
	public void setTreespeciesList(Set<TmTreeMasterMas> treespeciesList) {
		this.treespeciesList = treespeciesList;
	}
	public Set<TmTreeMasterMas> getBarkList() {
		return barkList;
	}
	public void setBarkList(Set<TmTreeMasterMas> barkList) {
		this.barkList = barkList;
	}
	public Set<TmTreeMasterMas> getLeafShapeList() {
		return leafShapeList;
	}
	public void setLeafShapeList(Set<TmTreeMasterMas> leafShapeList) {
		this.leafShapeList = leafShapeList;
	}
	public Set<TmTreeMasterMas> getLeafcolourList() {
		return leafcolourList;
	}
	public void setLeafcolourList(Set<TmTreeMasterMas> leafcolourList) {
		this.leafcolourList = leafcolourList;
	}
	public Set<TmTreeMasterMas> getTextureList() {
		return textureList;
	}
	public void setTextureList(Set<TmTreeMasterMas> textureList) {
		this.textureList = textureList;
	}
	public Set<TmTreeMasterMas> getFlowernameList() {
		return flowernameList;
	}
	public void setFlowernameList(Set<TmTreeMasterMas> flowernameList) {
		this.flowernameList = flowernameList;
	}
	public Set<TmTreeMasterMas> getFruitnameList() {
		return fruitnameList;
	}
	public void setFruitnameList(Set<TmTreeMasterMas> fruitnameList) {
		this.fruitnameList = fruitnameList;
	}
	public Set<TmTreeMasterMas> getOdourList() {
		return odourList;
	}
	public void setOdourList(Set<TmTreeMasterMas> odourList) {
		this.odourList = odourList;
	}
	public Set<TmTreeMasterMas> getTreestatusList() {
		return treestatusList;
	}
	public void setTreestatusList(Set<TmTreeMasterMas> treestatusList) {
		this.treestatusList = treestatusList;
	}
	public Set<TmTreeMasterMas> getShapeList() {
		return shapeList;
	}
	public void setShapeList(Set<TmTreeMasterMas> shapeList) {
		this.shapeList = shapeList;
	}
	public Set<TmTreeMasterMas> getColorMasterList() {
		return colorMasterList;
	}
	public void setColorMasterList(Set<TmTreeMasterMas> colorMasterList) {
		this.colorMasterList = colorMasterList;
	}
	public Set<TmTreeNameMaster> getTmtreenameList() {
		return tmtreenameList;
	}
	public void setTmtreenameList(Set<TmTreeNameMaster> tmtreenameList) {
		this.tmtreenameList = tmtreenameList;
	}
	
	
	
	
}
