package com.innowave.mahaulb.web.treecensus.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.innowave.mahaulb.common.service.beans.UserBean;
import com.innowave.mahaulb.portal.utils.DateTimeZoneHelper;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeNameMaster;
import com.innowave.mahaulb.repository.treecensus.dao.master.TreeCensusRestDto;
import com.innowave.mahaulb.service.treecensus.bean.TreeSurveyDetailsBean;
import com.innowave.mahaulb.service.treecensus.dto.TreeNameSearchDto;
import com.innowave.mahaulb.service.treecensus.dto.master.TreeMasterMasForm;
import com.innowave.mahaulb.service.treecensus.master.treename.TreeNameMasterServ;

@Controller
@RequestMapping("/master")
public class TreeNameMasterController {
	
    @Autowired
    TreeNameMasterServ treeNameMasterServ;
	
    private final String prefixURL = "treecensus/masters";
	/*@Autowired
	LookupDetServ lookupDetServ;*/
	
	@Autowired
	private MessageSource messageSource; 
	@Autowired
	private HttpSession httpSession;
	
	public UserBean getSessionUser() {
		// Session session = sessionFactory.getCurrentSession();
		return (UserBean) httpSession.getAttribute("userBeanObj");

	}
	
@RequestMapping(value = "/treename/action/{actionVal}", method = RequestMethod.POST)
	
	public ModelAndView treenameAction(@ModelAttribute("treename") TreeMasterMasForm treeMasterMasForm,
			@ModelAttribute("treenamesearch") TreeNameSearchDto treeNameSearchDto,Locale locale,HttpSession session, 
			HttpServletRequest request,@PathVariable String actionVal,ModelMap model){	
		
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		
		TmTreeNameMaster treeNameMaster = treeMasterMasForm.getTmTreeNameMaster();
		List<TmTreeNameMaster> detailsLst = new ArrayList<TmTreeNameMaster>();
		UserBean userBeanObj = (UserBean)session.getAttribute("userBeanObj");
		 if(actionVal.equals("delete")) {
			try{
				 try
				 {
					if(treeMasterMasForm.getStatus()!= null && treeMasterMasForm.getStatus().equals("1")) {
						treeNameMaster.setStatus(1);
					}else {
						treeNameMaster.setStatus(0);
					}
					
				}catch(NullPointerException n) {
					treeNameMaster.setStatus(0);
				}
				treeNameMaster.setUpdatedBy(userBeanObj.getUserId());
				treeNameMaster.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
					
				treeNameMasterServ.deleteTreeName(treeNameMaster);
				model.put("message",messageSource.getMessage("lable.common.sucess.deleted", null, locale));
				model.put("msgtype","success");;
			detailsLst =  getSearchList(treeMasterMasForm.getTreeNameSearchDto());
			}catch(Exception e) {
				model.put("message",messageSource.getMessage("lable.common.fail.delete", null, locale));
				model.put("msgtype","error");
			}
		}else if(actionVal.equals("search")) {
			
		
			System.out.println("mm");
			System.out.println(getSessionUser().getUlbId());
			treeNameSearchDto.setUlbId(getSessionUser().getUlbId());
			detailsLst =  getSearchList(treeNameSearchDto);
			 /*for(TmTreeNameMaster item:detailsLst){
	           System.out.println("item data :  "+item.getTreeVerNameEn()+"||"+item.getTreeVerNameRg()+"||"+item.getTreeSciNameEn()+"||"+item.getTreeSciNameRg()+"||"+item.getTreeFamNameEn()+"||"+item.getTreeFamNameRg()+"||"+item.getTreeComNameEn()+"||"+item.getTreeComNameRg());
			    }*/
		
	 	}else if(actionVal.equals("add")) {
	 		try {
				 try
				 {
					if(treeMasterMasForm.getStatus()!= null && treeMasterMasForm.getStatus().equals("1")) {
						treeNameMaster.setStatus(1);
					}else {
						treeNameMaster.setStatus(0);
					}
					
				}catch(NullPointerException n) {
					treeNameMaster.setStatus(0);
				}
				 treeNameMaster.setUlbId(userBeanObj.getUlbId());
				treeNameMaster.setCreatedBy(userBeanObj.getUserId());
				treeNameMaster.setIpAddress(ipAddress);
				
				treeNameMaster.setCreatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
				int id = treeNameMasterServ.save(treeNameMaster);
				model.put("message",messageSource.getMessage("lable.common.sucess.added", null, locale));
				model.put("msgtype","success");
				//detailsLst = getSearchList(treeMasterMasForm.getTreeNameSearchDto());
	 		}catch(Exception e) {
	 			e.printStackTrace();
	 			model.put("message",messageSource.getMessage("lable.common.fail.delete", null, locale));
				model.put("msgtype","error");
			}
		}else if(actionVal.equals("update")) {
	
			try {
				 try
				 {
					
					if(treeMasterMasForm.getStatus()!= null && treeMasterMasForm.getStatus().equals("1")) {
						
						treeNameMaster.setStatus(1);
					}else {
						
						treeNameMaster.setStatus(0);
					}
					
				}catch(NullPointerException n) {
					treeNameMaster.setStatus(0);
				}
				treeNameMaster.setUpdatedBy(userBeanObj.getUserId());
				treeNameMaster.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
				treeNameMasterServ.updateTreeName(treeNameMaster);
				
				model.put("message",messageSource.getMessage("lable.common.sucess.updated", null, locale));
				model.put("msgtype","success");
				if(treeMasterMasForm.getTreeNameSearchDto() != null){
				detailsLst = getSearchList(treeMasterMasForm.getTreeNameSearchDto());
				}
			}catch(Exception e) {
			
				model.put("message",messageSource.getMessage("lable.common.fail.update	", null, locale));
				model.put("msgtype","error");
			}
		}
		model.addAttribute("treename",treeMasterMasForm);
		model.addAttribute("treenamesearch",treeNameSearchDto);
		model.addAttribute("treenameList",detailsLst);
		
		return new ModelAndView(prefixURL+"/view-treename",model,HttpStatus.OK);
    }
	
private List<TmTreeNameMaster> getSearchList(TreeNameSearchDto treeNameSearchDto) {
	
	List<TmTreeNameMaster> detailsLst = new ArrayList<TmTreeNameMaster>();
	
	/*if(searchKey != null && !searchKey.isEmpty()) {*/
	//vTtLookupDet ttLookupDetObj = lookupDetServ.getLookupDetId(strLookup);
		/*TmTreeNameMaster.setTreeVerNameEn(searchKey.trim());
		TmTreeNameMaster.setTreeVerNameRg(searchKey.trim());
		TmTreeNameMaster.setTreeFamNameEn(searchKey.trim());
		*/
		//vTmTreeNameMaster.setTtLookupDet(ttLookupDetObj);*/
	    detailsLst = treeNameMasterServ.getTreeNameMasterList(treeNameSearchDto);

	return detailsLst;
}

@RequestMapping(value = "/treeMasDet", headers = "Accept=application/json", 
produces = "application/text;charset=UTF-8", method = RequestMethod.GET)
public ResponseEntity<String> getTreeMasDet(@RequestHeader HttpHeaders headers,@RequestParam("treeId") int id, UriComponentsBuilder ucBuilder) {

	try {
		String resJson = "";
		resJson = treeNameMasterServ.getTreeNameDet(id);
		return ResponseEntity.ok(resJson);
	} catch (Exception e) {
		return null;
	}
	
}


@RequestMapping(value = "/update/tree",headers = "Accept=application/json", 
produces = "application/text;charset=UTF-8", method = RequestMethod.POST)
public String viewTreeMaster(@RequestBody TmTreeNameMaster treeMasterMasForm,
		Locale locale,HttpSession session,ModelMap model){
	
	UserBean userBeanObj = (UserBean)session.getAttribute("userBeanObj");
	
	try {
		
		treeMasterMasForm.setUpdatedBy(userBeanObj.getUserId());
		treeMasterMasForm.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
		treeNameMasterServ.updateTreeName(treeMasterMasForm);
		
		model.put("message",messageSource.getMessage("lable.common.sucess.updated", null, locale));
		model.put("msgtype","success");
		return null /*messageSource.getMessage("lable.common.sucess.updated", null, locale)*/;
	}catch(Exception e) {
		e.printStackTrace();
		//model.put("message",messageSource.getMessage("lable.common.fail.update	", null, locale));
		//model.put("msgtype","error");
		return "fail";
	}
	
}


	}

	
