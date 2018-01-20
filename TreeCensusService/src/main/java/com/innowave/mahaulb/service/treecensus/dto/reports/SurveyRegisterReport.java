package com.innowave.mahaulb.service.treecensus.dto.reports;

import java.io.Serializable;
import java.util.List;

public class SurveyRegisterReport implements Serializable{
	private static final long serialVersionUID = 1L;
	
	List<registerDataListOneBean> listOne;
	List<registerDataListTwoBean> listTwo;
	public List<registerDataListOneBean> getListOne() {
		return listOne;
	}
	public void setListOne(List<registerDataListOneBean> rOneData) {
		this.listOne = rOneData;
	}
	public List<registerDataListTwoBean> getListTwo() {
		return listTwo;
	}
	public void setListTwo(List<registerDataListTwoBean> listTwo) {
		this.listTwo = listTwo;
	}
	
	
}
