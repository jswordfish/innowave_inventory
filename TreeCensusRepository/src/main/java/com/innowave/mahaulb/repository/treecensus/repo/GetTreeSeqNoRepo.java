package com.innowave.mahaulb.repository.treecensus.repo;

import java.text.ParseException;
import java.util.Date;

public interface GetTreeSeqNoRepo {
	
	public int getModId(String code);
	
	public String getUlbShortsCode(int ulbId);
	
	//For Financial
	
	public Date getFromFinancialDate(Date fDt);
	public Date getFinancialDate(Date fDt);
	
	//For Financial
	
	//For Calendar
	
	public Date getCurrentYear() throws ParseException;
	
	//For Calendar
	
	public String getServShortCode(int serId);
	
	public String getAutoConnectionLoiNo(int modId, int ulbId,String tabName,String fldName, char year,Date userDefDt) throws ParseException;
	
	
}
