package com.innowave.mahaulb.repository.treecensus.repository;

import java.util.List;

import com.innowave.mahaulb.common.dao.TmCmApartment;
import com.innowave.mahaulb.common.dao.TmCmLocality;
import com.innowave.mahaulb.common.dao.TmCmLookupDetHierarchical;
import com.innowave.mahaulb.common.dao.TmCmRoad;
import com.innowave.mahaulb.common.dao.master.TmCmLocation;

public interface TreecensusRepo {
	public List<TmCmLocality> getLocalityDataListServ(String searchString,int ulbIdAuto);
	public List<TmCmLocation> getLocationDataListServ(String searchString,int ulbIdAuto);
	public List<TmCmApartment> getApartmentDataListServ(String searchString,int ulbIdAuto);
	public List<TmCmRoad> getRoadDataListServ(String searchString,int ulbIdAuto);
	public List<TmCmLookupDetHierarchical> getLookupHierWordListServ(String searchString, int ulbIdAuto);
	public List<TmCmLookupDetHierarchical> getLookupHierZordListServ(String searchString, int ulbIdAuto);
}
