package com.innowave.mahaulb.web.treecensus.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.innowave.mahaulb.common.dao.TmCmApartment;
import com.innowave.mahaulb.common.dao.TmCmLocality;
import com.innowave.mahaulb.common.dao.TmCmLookupDetHierarchical;
import com.innowave.mahaulb.common.dao.TmCmRoad;
import com.innowave.mahaulb.common.dao.master.TmCmLocation;
import com.innowave.mahaulb.service.treecensus.service.TreecensusServ;

@RestController
@RequestMapping("/treecensus/rest")
public class TreecensusRestController 
{
	public static final Logger logger = LoggerFactory.getLogger(TreecensusRestController.class);

	@Autowired
	TreecensusServ treeServ;
	
	@RequestMapping(value = "/locationData",  headers = "Accept=application/json", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public @ResponseBody Map<Integer, String> locationDataDtl(Locale locale,ModelMap model, HttpServletRequest req){
		int ulbIdAuto=Integer.parseInt(req.getParameter("ulbIdAuto"));
		String searchString = req.getParameter("searchString");
		List<TmCmLocation>  tmCmlookuplist = treeServ.getLocationDataListServ(searchString,ulbIdAuto);
		Map<Integer, String> prefixDtlList = new HashMap<Integer, String>();
		
		for(TmCmLocation tmCmlookupdet : tmCmlookuplist){
			prefixDtlList.put(tmCmlookupdet.getLocationId(), tmCmlookupdet.getLocationDescription());
		}
		return prefixDtlList;
    }
	
	@RequestMapping(value = "/apartmentData",  headers = "Accept=application/json", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public @ResponseBody Map<Integer, String> aprtmentDataDtl(Locale locale,ModelMap model, HttpServletRequest req){
		int ulbIdAuto=Integer.parseInt(req.getParameter("ulbIdAuto"));
		String searchString = req.getParameter("searchString");
		List<TmCmApartment>  tmCmlookuplist = treeServ.getApartmentDataServ(searchString,ulbIdAuto);
		Map<Integer, String> prefixDtlList = new HashMap<Integer, String>();
		
		for(TmCmApartment tmCmlookupdet : tmCmlookuplist){
			prefixDtlList.put(tmCmlookupdet.getApartmentId(), tmCmlookupdet.getApartmentDescription());
		}
		return prefixDtlList;
    }
	
	@RequestMapping(value = "/roadData",  headers = "Accept=application/json", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public @ResponseBody Map<Integer, String> roadDataDtl(Locale locale,ModelMap model, HttpServletRequest req){
		int ulbIdAuto=Integer.parseInt(req.getParameter("ulbIdAuto"));
		String searchString = req.getParameter("searchString");
		List<TmCmRoad>  tmCmlookuplist = treeServ.getRoadDataListServ(searchString, ulbIdAuto);
		Map<Integer, String> prefixDtlList = new HashMap<Integer, String>();
		
		for(TmCmRoad tmCmlookupdet : tmCmlookuplist){
			prefixDtlList.put(tmCmlookupdet.getRoadId(), tmCmlookupdet.getRoadDescription());
		}
		return prefixDtlList;
    }
	
	@RequestMapping(value = "/localityData",  headers = "Accept=application/json", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public @ResponseBody Map<Integer, String> localityDataDtl(Locale locale,ModelMap model, HttpServletRequest req){
		int ulbIdAuto=Integer.parseInt(req.getParameter("ulbIdAuto"));
		String searchString = req.getParameter("searchString");
		List<TmCmLocality>  tmCmlookuplist = treeServ.getLocalityDataListServ(searchString,ulbIdAuto);
		Map<Integer, String> prefixDtlList = new HashMap<Integer, String>();
		
		for(TmCmLocality tmCmlookupdet : tmCmlookuplist){
			prefixDtlList.put(tmCmlookupdet.getLocalityId(), tmCmlookupdet.getLocalityDescription());
		}
		return prefixDtlList;
    }
	
	
	@RequestMapping(value = "/wardData",  headers = "Accept=application/json", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public @ResponseBody Map<Integer, String> wardDataDtl(Locale locale,ModelMap model, HttpServletRequest req){
		int ulbIdAuto=Integer.parseInt(req.getParameter("ulbIdAuto"));
		String searchString = req.getParameter("searchString");
		List<TmCmLookupDetHierarchical>  tmCmlookuplist = treeServ.getLookupHierWordListServ(searchString, ulbIdAuto);
		Map<Integer, String> prefixDtlList = new HashMap<Integer, String>();
		for(TmCmLookupDetHierarchical tmCmlookupdet : tmCmlookuplist){
			prefixDtlList.put(tmCmlookupdet.getLookupDetHierId(), tmCmlookupdet.getLookupDetHierDescEn());
		}
		return prefixDtlList;
	}

	@RequestMapping(value = "/zoneData",  headers = "Accept=application/json", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public @ResponseBody Map<Integer, String> zoneDataDtl(Locale locale,ModelMap model, HttpServletRequest req){
		int ulbIdAuto=Integer.parseInt(req.getParameter("ulbIdAuto"));
		String searchString = req.getParameter("searchString");
		List<TmCmLookupDetHierarchical>  tmCmlookuplist = treeServ.getLookupHierZoneListServ(searchString, ulbIdAuto);
		Map<Integer, String> prefixDtlList = new HashMap<Integer, String>();
		for(TmCmLookupDetHierarchical tmCmlookupdet : tmCmlookuplist){
			prefixDtlList.put(tmCmlookupdet.getLookupDetHierId(), tmCmlookupdet.getLookupDetHierDescEn());
		}
		return prefixDtlList;
	}

}
