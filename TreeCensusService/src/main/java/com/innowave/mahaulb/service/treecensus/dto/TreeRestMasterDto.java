package com.innowave.mahaulb.service.treecensus.dto;

import java.io.Serializable;

public class TreeRestMasterDto implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int treemasterId;
	private String description;
	
	
	public int getTreemasterId() {
		return treemasterId;
	}
	public void setTreemasterId(int treemasterId) {
		this.treemasterId = treemasterId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
