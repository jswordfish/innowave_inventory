package com.innowave.mahaulb.service.treecensus.dto;

import java.io.Serializable;

public class TreeNameSearchDto implements Serializable

{
	private static final long serialVersionUID = 1L;
	private int ulbId;
	private String verSearch;

	private String sciSearch;

	private String comSearch;

	private String famSearch;

	
	public int getUlbId() {
		return ulbId;
	}

	public void setUlbId(int ulbId) {
		this.ulbId = ulbId;
	}

	public String getVerSearch() {
		return verSearch;
	}

	public void setVerSearch(String verSearch) {
		this.verSearch = verSearch;
	}

	public String getSciSearch() {
		return sciSearch;
	}

	public void setSciSearch(String sciSearch) {
		this.sciSearch = sciSearch;
	}

	public String getComSearch() {
		return comSearch;
	}

	public void setComSearch(String comSearch) {
		this.comSearch = comSearch;
	}

	public String getFamSearch() {
		return famSearch;
	}

	public void setFamSearch(String famSearch) {
		this.famSearch = famSearch;
	}

}
