package com.innowave.mahaulb.web.inventory.controller.forms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.innowave.mahaulb.repository.inventory.dao.trans.TtInvScrap;

public class DisposalOfScrapDTO implements Serializable{
	
	String disposalNo;
	
	Long storeId;
	
	String storeName;
	
	String disposalFormDate;
	
	String disposalToDate;
	
	Boolean status;
	
	List<TtInvScrap> scraps = new ArrayList<>();
	
	String disposalRemark;
	
	String disposedByUserId;
	
	TtInvScrap current;

	public String getDisposalNo() {
		return disposalNo;
	}

	public void setDisposalNo(String disposalNo) {
		this.disposalNo = disposalNo;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getDisposalFormDate() {
		return disposalFormDate;
	}

	public void setDisposalFormDate(String disposalFormDate) {
		this.disposalFormDate = disposalFormDate;
	}

	public String getDisposalToDate() {
		return disposalToDate;
	}

	public void setDisposalToDate(String disposalToDate) {
		this.disposalToDate = disposalToDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<TtInvScrap> getScraps() {
		return scraps;
	}

	public void setScraps(List<TtInvScrap> scraps) {
		this.scraps = scraps;
	}

	public TtInvScrap getCurrent() {
		return current;
	}

	public void setCurrent(TtInvScrap current) {
		this.current = current;
	}

	public String getDisposalRemark() {
		return disposalRemark;
	}

	public void setDisposalRemark(String disposalRemark) {
		this.disposalRemark = disposalRemark;
	}

	public String getDisposedByUserId() {
		return disposedByUserId;
	}

	public void setDisposedByUserId(String disposedByUserId) {
		this.disposedByUserId = disposedByUserId;
	}
	
	

}
