package com.innowave.mahaulb.web.inventory.controller.forms;

import com.innowave.mahaulb.repository.inventory.dao.trans.TtInvMaterialOpbal;

public class TtInvMaterialOpbalWrapper {
	TtInvMaterialOpbal materialOpbal;
	
	Integer serial;

	public TtInvMaterialOpbal getMaterialOpbal() {
		return materialOpbal;
	}

	public void setMaterialOpbal(TtInvMaterialOpbal materialOpbal) {
		this.materialOpbal = materialOpbal;
	}

	public Integer getSerial() {
		return serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}
	
	
}
