package com.innowave.mahaulb.web.treecensus.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innowave.mahaulb.common.service.LookupDetServ;
import com.innowave.mahaulb.common.service.beans.UserBean;
import com.innowave.mahaulb.portal.utils.DateTimeZoneHelper;
import com.innowave.mahaulb.portal.utils.FileReaderHelperUtils;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeNameMaster;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;
import com.innowave.mahaulb.service.treecensus.bean.TreeSurveyDetailsBean;
import com.innowave.mahaulb.service.treecensus.bean.TtTreeSurveyDetailsBean;
import com.innowave.mahaulb.service.treecensus.master.treemastermas.TreeMasterMasServ;

@Controller
@RequestMapping("/application")
public class TreeApplicationsMasController {
	
	private final String prefixURLApp = "treecensus/applications";
	
	@Autowired
	TreeMasterMasServ treeMasterMasServ;
	
	@Autowired
	LookupDetServ lookupDetServ;
	
	@Autowired
	private MessageSource messageSource;

	private Map<Integer, String> treeScientificNameDtlList; 
	
	@RequestMapping(value = "/treeCensusTreeNameDtl", headers = "Accept=application/json", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public @ResponseBody Set<TmTreeNameMaster> treeCensusVernaDtl(Locale locale,ModelMap model, HttpServletRequest req){
		String treeNameType = req.getParameter("treeNameType");
		String searchString = req.getParameter("searchString");
		Set<TmTreeNameMaster>  treeCensusDtlList = treeMasterMasServ.getTreeNameDetailsServ(treeNameType, searchString);
		Set<TmTreeNameMaster>  finalTreeCensusDtlList = new HashSet<TmTreeNameMaster>();
		
		for(TmTreeNameMaster treeNAmeDtl : treeCensusDtlList){
			if(treeNameType.equalsIgnoreCase("vernacular")){
				finalTreeCensusDtlList.add(treeNAmeDtl);
			}
			if(treeNameType.equalsIgnoreCase("scientific")){
				finalTreeCensusDtlList.add(treeNAmeDtl);
			}
			if(treeNameType.equalsIgnoreCase("treecommon")){
				finalTreeCensusDtlList.add(treeNAmeDtl);
			}
			if(treeNameType.equalsIgnoreCase("treefamily")){
				finalTreeCensusDtlList.add(treeNAmeDtl);
			}
		}
		return finalTreeCensusDtlList;
    }
	
	
	@Autowired
	private Environment env;
	
	@RequestMapping(value = "/lookUpDetailsFile", method = { RequestMethod.GET, RequestMethod.POST },
			produces = "application/json;charset=UTF-8")
	public ResponseEntity<String> mahadmaGraphs(Locale locale,Model model, HttpServletRequest request, HttpServletResponse response) {
	
		//if(filename != null && !filename.isEmpty()) {
			String jasonFile =  env.getProperty("json.mahaulb.web.path").concat("/common/lookUpDetails.json");
			 File fileJason = new File(jasonFile);
			 if(fileJason.exists()) {
				try {
					return ResponseEntity.ok(FileReaderHelperUtils.getJASONFileContent(fileJason));
				} catch (IOException e) {
					e.printStackTrace();
					return ResponseEntity.ok("File Not Found");
				}
			 }else {
				 return ResponseEntity.ok("File Not Found");
			 }
		 
		//}else {
			//return ResponseEntity.ok("nodata");
		//}
		
	}
	
	
	@RequestMapping(value = "/applicationsurveyDetailSave", method = RequestMethod.POST)
	
    /*public String applicationsurveyDetailSave(@ModelAttribute("treeCensusDetail") TtTreeSurveyDetails  ttTreeSurveyDetails, Locale locale,ModelMap model,
    		@RequestHeader HttpHeaders headers,
			@RequestBody TtTreeSurveyDetails ttTreeSurveyDetails2,HttpSession session,UriComponentsBuilder ucBuilder)*/
	public String applicationsurveyDetailSave(@ModelAttribute("treeCensusDetail")@Valid TtTreeSurveyDetailsBean  ttTreeSurveyDetails,BindingResult bindingResult,  
			HttpSession session,Locale locale,ModelMap model)
	{
		
		UserBean userBeanObj = (UserBean)session.getAttribute("userBeanObj");
		ttTreeSurveyDetails.setUlbId(userBeanObj.getUlbId());
		ttTreeSurveyDetails.setCreatedBy(userBeanObj.getUserId());
		ttTreeSurveyDetails.setCreatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
		treeMasterMasServ.saveApplicationSurveyDetails(ttTreeSurveyDetails);
		
		TtTreeSurveyDetailsBean  ttTreeSurveyDetail  = new TtTreeSurveyDetailsBean();		
		model.put("message",messageSource.getMessage("lable.common.sucess.added", null, locale));
		model.put("msgtype","success");		
		model.addAttribute("treeCensusDetail", ttTreeSurveyDetail);
		
	    return prefixURLApp+"/application-surveydataentry";
    }
	
	
	public void setTreeScientificNameDtlList(Map<Integer, String> treeScientificNameDtlList){
		this.treeScientificNameDtlList = treeScientificNameDtlList;
	}
	
	public Map<Integer, String> getTreeScientificNameDtlList(){
		return this.treeScientificNameDtlList;
	}

}
