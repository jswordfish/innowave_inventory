package com.innowave.mahaulb.web.treecensus.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.service.LookupDetServ;
import com.innowave.mahaulb.common.service.beans.UserBean;
import com.innowave.mahaulb.portal.utils.DateTimeZoneHelper;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeMasterMas;
import com.innowave.mahaulb.service.treecensus.dto.master.TreeMasterMasForm;
import com.innowave.mahaulb.service.treecensus.master.treemastermas.TreeMasterMasServ;
import com.innowave.mahaulb.web.common.TreeCensusCommon; 
 

@Controller
@RequestMapping("/master")
public class TreeMasterMasController {

	private final String prefixURL = "treecensus/masters";
			
	@Autowired
	TreeMasterMasServ treeMasterMasServ;
	
	@Autowired
	LookupDetServ lookupDetServ;
	
	@Autowired
	private MessageSource messageSource; 
	@Autowired
	private HttpSession httpSession;
	
	
	public UserBean getSessionUser() {
		// Session session = sessionFactory.getCurrentSession();
		return (UserBean) httpSession.getAttribute("userBeanObj");

	}
	
	
	@RequestMapping(value = "/treespecies/add", method = RequestMethod.POST)
    //public ModelAndView add(@ModelAttribute("treespacies") @Valid TmTreeMasterMas tmTreeMasterMas,Locale locale,ModelMap model){
	public ModelAndView add(@ModelAttribute("treespacies") TmTreeMasterMas tmTreeMasterMas,Locale locale,ModelMap model){
		 
		TmCmLookupDet ttLookupDetObj = lookupDetServ.getLookupDet(TreeCensusCommon.LOOKUPTREESPICE);
		
		tmTreeMasterMas.setTtLookupDet(ttLookupDetObj);
		tmTreeMasterMas.setCreatedBy(1);
		tmTreeMasterMas.setCreatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
		//tmTreeMasterMas.setIpAddress(webUtils.getClientIp());
		int id = treeMasterMasServ.save(tmTreeMasterMas);
		return new ModelAndView("masters/view-treespecies",model,HttpStatus.OK);
    }
	
	@RequestMapping(value = "/treespecies/search", method = RequestMethod.POST)
	public ModelAndView search(@ModelAttribute("treespacies") TmTreeMasterMas tmTreeMasterMas,Locale locale,ModelMap model){
		 
		List<TmTreeMasterMas> detailsLst = new ArrayList<TmTreeMasterMas>();
		TmCmLookupDet ttLookupDetObj = lookupDetServ.getLookupDetId(TreeCensusCommon.LOOKUPTREESPICE);
		tmTreeMasterMas.setTtLookupDet(ttLookupDetObj);
		detailsLst = treeMasterMasServ.getTreeMasterMasList(tmTreeMasterMas);
	 
		model.addAttribute("treespaciesList", detailsLst);
		
		return new ModelAndView("masters/view-treespecies",model,HttpStatus.OK);
    }
	
	@RequestMapping(value = "/treespecies/action/{actionVal}", method = RequestMethod.POST)
	/*public ModelAndView treeSpeciesAction(@ModelAttribute("treespacies") TmTreeMasterMas tmTreeMasterMas,
											@ModelAttribute("searchbean") SearchParamBean searchParamBean,
											Locale locale,
											@PathVariable String actionVal,ModelMap model){*/
	public ModelAndView treeSpeciesAction(@ModelAttribute("treespacies") TreeMasterMasForm treeMasterMasForm,
				Locale locale,HttpSession session,
				@PathVariable String actionVal,ModelMap model){	
	 	 	 
		//System.out.println("SEARCH "+searchParamBean.getTreespecies()); 
		//System.out.println("strStatus  "+tmTreeMasterMas.getStrStatus());
		TmTreeMasterMas tmTreeMasterMas = treeMasterMasForm.getTmTreeMasterMas();
		UserBean userBeanObj = (UserBean)session.getAttribute("userBeanObj");
		List<TmTreeMasterMas> detailsLst = new ArrayList<TmTreeMasterMas>();
		
		 if(actionVal.equals("delete")) {
			try{
				try {
					if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
						tmTreeMasterMas.setStatus(1);
					}else {
						tmTreeMasterMas.setStatus(0);
					}
				}catch(NullPointerException n) {
					tmTreeMasterMas.setStatus(0);
				}
			tmTreeMasterMas.setUpdatedBy(userBeanObj.getUserId());
			tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
			treeMasterMasServ.delete(tmTreeMasterMas);
			model.put("message",messageSource.getMessage("lable.common.sucess.deleted", null, locale));
			model.put("msgtype","success");
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREESPICE,treeMasterMasForm.getSearchKey());
			
			}catch(Exception e) {
				model.put("message",messageSource.getMessage("lable.common.fail.delete", null, locale));
				model.put("msgtype","error");
			}
		}else if(actionVal.equals("search")) {
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREESPICE,treeMasterMasForm.getSearchKey());
			
	 	}else if(actionVal.equals("add")) {
	 		try {
	 			TmCmLookupDet ttLookupDetObj = lookupDetServ.getLookupDet(TreeCensusCommon.LOOKUPTREESPICE);
		 		try {
					if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
						tmTreeMasterMas.setStatus(1);
					}else {
						tmTreeMasterMas.setStatus(0);
					}
				}catch(NullPointerException n) {
					tmTreeMasterMas.setStatus(0);
				}
				tmTreeMasterMas.setTtLookupDet(ttLookupDetObj);
				tmTreeMasterMas.setUlbId(userBeanObj.getUlbId());
				tmTreeMasterMas.setCreatedBy(userBeanObj.getUserId());
				tmTreeMasterMas.setCreatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
				//tmTreeMasterMas.setIpAddress(webUtils.getClientIp());
				int id = treeMasterMasServ.save(tmTreeMasterMas);
				model.put("message",messageSource.getMessage("lable.common.sucess.added", null, locale));
				model.put("msgtype","success");
				detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREESPICE,treeMasterMasForm.getSearchKey());
	 		}catch(Exception e) {
	 			e.printStackTrace();
				model.put("message",messageSource.getMessage("lable.common.fail.add", null, locale));
				model.put("msgtype","error");
			}
		}else if(actionVal.equals("update")) {
			try {
				try {
					if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
						tmTreeMasterMas.setStatus(1);
					}else {
						tmTreeMasterMas.setStatus(0);
					}
				}catch(NullPointerException n) {
					tmTreeMasterMas.setStatus(0);
				}
				tmTreeMasterMas.setCreatedBy(userBeanObj.getUserId());
				tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
				treeMasterMasServ.update(tmTreeMasterMas);
				
				model.put("message",messageSource.getMessage("lable.common.sucess.updated", null, locale));
				model.put("msgtype","success");
				detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREESPICE,treeMasterMasForm.getSearchKey());
			}catch(Exception e) {
				model.put("message",messageSource.getMessage("lable.common.fail.update", null, locale));
				model.put("msgtype","error");
			}
		}
		model.addAttribute("treespacies",treeMasterMasForm);
		//model.addAttribute("searchbean", searchParamBean);
		model.addAttribute("treespaciesList", detailsLst);
		
		return new ModelAndView(prefixURL+"/view-treespecies",model,HttpStatus.OK);
    }
	
	private List<TmTreeMasterMas> getSearchList(String strLookup,String searchKey) {
		List<TmTreeMasterMas> detailsLst = new ArrayList<TmTreeMasterMas>();
		if(searchKey != null && !searchKey.isEmpty()) {
			TmTreeMasterMas tmTreeMasterMas = new TmTreeMasterMas();
			TmCmLookupDet tmCmLookupDet=new TmCmLookupDet();
			tmCmLookupDet.setLookupDetValue(strLookup);
			System.out.println("lookupdetvalue"+strLookup);
			tmTreeMasterMas.setTreemasDescEn(searchKey.trim());
			tmTreeMasterMas.setTreemasDescMh(searchKey.trim());
			tmTreeMasterMas.setTtLookupDet(tmCmLookupDet);
			System.out.println(tmCmLookupDet.getLookupDetValue());
			tmTreeMasterMas.setUlbId(getSessionUser().getUlbId());
			detailsLst = treeMasterMasServ.getTreeMasterMasList(tmTreeMasterMas);
			System.out.println("list size"+detailsLst.size());
		}
		return detailsLst;
	}
	
/*-------------------------------------------------------------For Bark Shape Master----------------------------------------------------------------------------------*/
	
	
	@RequestMapping(value = "/barkshape/action/{actionVal}", method = RequestMethod.POST)
	
	public ModelAndView barkShapeAction(@ModelAttribute("barkshape") TreeMasterMasForm treeMasterMasForm,Locale locale,HttpSession session,
			@PathVariable String actionVal,ModelMap model){	
		
		TmTreeMasterMas tmTreeMasterMas = treeMasterMasForm.getTmTreeMasterMas();
		UserBean userBeanObj = (UserBean)session.getAttribute("userBeanObj");
		List<TmTreeMasterMas> detailsLst = new ArrayList<TmTreeMasterMas>();
		
		 if(actionVal.equals("delete")) {
			try{
				try {
					if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
						tmTreeMasterMas.setStatus(1);
					}else {
						tmTreeMasterMas.setStatus(0);
					}
				}catch(NullPointerException n) {
					tmTreeMasterMas.setStatus(0);
				}
			tmTreeMasterMas.setUpdatedBy(userBeanObj.getUserId());
			tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
			treeMasterMasServ.delete(tmTreeMasterMas);
			model.put("message",messageSource.getMessage("lable.common.sucess.deleted", null, locale));
			model.put("msgtype","success");
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEBARKSHAPE,treeMasterMasForm.getSearchKey());
			
			}catch(Exception e) {
				model.put("message",messageSource.getMessage("lable.common.fail.delete", null, locale));
				model.put("msgtype","error");
			}
		}else if(actionVal.equals("search")) {
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEBARKSHAPE,treeMasterMasForm.getSearchKey());
			
	 	}else if(actionVal.equals("add")) {
	 		try {
	 			TmCmLookupDet ttLookupDetObj = lookupDetServ.getLookupDet(TreeCensusCommon.LOOKUPTREEBARKSHAPE);
				
				System.out.println(" treeMasterMasForm.getStatus()  "+treeMasterMasForm.getStatus());
				try {
					if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
						tmTreeMasterMas.setStatus(1);
					}else {
						tmTreeMasterMas.setStatus(0);
					}
				}catch(NullPointerException n) {
					tmTreeMasterMas.setStatus(0);
				}
				tmTreeMasterMas.setTtLookupDet(ttLookupDetObj);
				tmTreeMasterMas.setUlbId(userBeanObj.getUlbId());
				tmTreeMasterMas.setCreatedBy(userBeanObj.getUserId());
				tmTreeMasterMas.setCreatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
				int id = treeMasterMasServ.save(tmTreeMasterMas);
				model.put("message",messageSource.getMessage("lable.common.sucess.added", null, locale));
				model.put("msgtype","success");
				detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEBARKSHAPE,treeMasterMasForm.getSearchKey());
	 		}catch(Exception e) {
	 			e.printStackTrace();
				model.put("message",messageSource.getMessage("lable.common.fail.add", null, locale));
				model.put("msgtype","error");
			}
		}else if(actionVal.equals("update")) {
			try {
				try {
					if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
						tmTreeMasterMas.setStatus(1);
					}else {
						tmTreeMasterMas.setStatus(0);
					}
				}catch(NullPointerException n) {
					tmTreeMasterMas.setStatus(0);
				}
			tmTreeMasterMas.setUpdatedBy(userBeanObj.getUserId());
				tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
				treeMasterMasServ.update(tmTreeMasterMas);
				
				model.put("message",messageSource.getMessage("lable.common.sucess.updated", null, locale));
				model.put("msgtype","success");
				detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEBARKSHAPE,treeMasterMasForm.getSearchKey());
			}catch(Exception e) {
				model.put("message",messageSource.getMessage("lable.common.fail.update", null, locale));
				model.put("msgtype","error");
			}
		}
		model.addAttribute("barkshape",treeMasterMasForm);
		model.addAttribute("barkshapeList", detailsLst);
		
		return new ModelAndView(prefixURL+"/view-barkshape",model,HttpStatus.OK);
    }
	
	
/*----------------------------------------------------Leaf Shape Master------------------------------------------------------------------------------------------------*/
	
	
	
@RequestMapping(value = "/leafshape/action/{actionVal}", method = RequestMethod.POST)

public ModelAndView leafShapeAction(@ModelAttribute("leafshape") TreeMasterMasForm treeMasterMasForm,Locale locale,HttpSession session,@PathVariable String actionVal,ModelMap model){	
		
		TmTreeMasterMas tmTreeMasterMas = treeMasterMasForm.getTmTreeMasterMas();
		UserBean userBeanObj = (UserBean)session.getAttribute("userBeanObj");
		List<TmTreeMasterMas> detailsLst = new ArrayList<TmTreeMasterMas>();
		
		 if(actionVal.equals("delete")) {
			try{
				try {
					if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
						tmTreeMasterMas.setStatus(1);
					}else {
						tmTreeMasterMas.setStatus(0);
					}
				}catch(NullPointerException n) {
					tmTreeMasterMas.setStatus(0);
				}
			tmTreeMasterMas.setUpdatedBy(userBeanObj.getUserId());
			tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
			treeMasterMasServ.delete(tmTreeMasterMas);
			model.put("message",messageSource.getMessage("lable.common.sucess.deleted", null, locale));
			model.put("msgtype","success");
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREELEAFSHAPE,treeMasterMasForm.getSearchKey());
			
			}catch(Exception e) {
				model.put("message",messageSource.getMessage("lable.common.fail.delete", null, locale));
				model.put("msgtype","error");
			}
		}else if(actionVal.equals("search")) {
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREELEAFSHAPE,treeMasterMasForm.getSearchKey());
			
	 	}else if(actionVal.equals("add")) {
	 		try {
	 			TmCmLookupDet ttLookupDetObj = lookupDetServ.getLookupDet(TreeCensusCommon.LOOKUPTREELEAFSHAPE);
				try {
					if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
						tmTreeMasterMas.setStatus(1);
					}else {
						tmTreeMasterMas.setStatus(0);
					}
				}catch(NullPointerException n) {
					tmTreeMasterMas.setStatus(0);
				}
				tmTreeMasterMas.setTtLookupDet(ttLookupDetObj);
				tmTreeMasterMas.setUlbId(userBeanObj.getUlbId());
				tmTreeMasterMas.setCreatedBy(userBeanObj.getUserId());
				tmTreeMasterMas.setCreatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
				int id = treeMasterMasServ.save(tmTreeMasterMas);
				model.put("message",messageSource.getMessage("lable.common.sucess.added", null, locale));
				model.put("msgtype","success");
				detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREELEAFSHAPE,treeMasterMasForm.getSearchKey());
	 		}catch(Exception e) {
	 			e.printStackTrace();
				model.put("message",messageSource.getMessage("lable.common.fail.add", null, locale));
				model.put("msgtype","error");
			}
		}else if(actionVal.equals("update")) {
			try {
				try {
					if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
						tmTreeMasterMas.setStatus(1);
					}else {
						tmTreeMasterMas.setStatus(0);
					}
				}catch(NullPointerException n) {
					tmTreeMasterMas.setStatus(0);
				}
			tmTreeMasterMas.setUpdatedBy(userBeanObj.getUserId());
			tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
				treeMasterMasServ.update(tmTreeMasterMas);
				
				model.put("message",messageSource.getMessage("lable.common.sucess.updated", null, locale));
				model.put("msgtype","success");
				detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREELEAFSHAPE,treeMasterMasForm.getSearchKey());
			}catch(Exception e) {
				model.put("message",messageSource.getMessage("lable.common.fail.update", null, locale));
				model.put("msgtype","error");
			}
		}
		model.addAttribute("leafshape",treeMasterMasForm);
		model.addAttribute("leafshapeList", detailsLst);
		
		return new ModelAndView(prefixURL+"/view-leafshape",model,HttpStatus.OK);
    }
	
	
/*--------------------------------------------------Leaf Colour Master---------------------------------------------------------------------------------------------*/
	
	
	@RequestMapping(value = "/leafcolour/action/{actionVal}", method = RequestMethod.POST)
	public ModelAndView leafColourAction(@ModelAttribute("leafcolour") TreeMasterMasForm treeMasterMasForm,Locale locale,HttpSession session,@PathVariable String actionVal,ModelMap model){	
		
		TmTreeMasterMas tmTreeMasterMas = treeMasterMasForm.getTmTreeMasterMas();
		UserBean userBeanObj = (UserBean)session.getAttribute("userBeanObj");
		List<TmTreeMasterMas> detailsLst = new ArrayList<TmTreeMasterMas>();
		
		 if(actionVal.equals("delete")) {
			try{
				try {
					if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
						tmTreeMasterMas.setStatus(1);
					}else {
						tmTreeMasterMas.setStatus(0);
					}
				}catch(NullPointerException n) {
					tmTreeMasterMas.setStatus(0);
				}
			tmTreeMasterMas.setUpdatedBy(userBeanObj.getUserId());
			tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
			treeMasterMasServ.delete(tmTreeMasterMas);
			model.put("message",messageSource.getMessage("lable.common.sucess.deleted", null, locale));
			model.put("msgtype","success");
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREELEAFCOLOUR,treeMasterMasForm.getSearchKey());
			
			}catch(Exception e) {
				model.put("message",messageSource.getMessage("lable.common.fail.delete", null, locale));
				model.put("msgtype","error");
			}
		}else if(actionVal.equals("search")) {
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREELEAFCOLOUR,treeMasterMasForm.getSearchKey());
			
	 	}else if(actionVal.equals("add")) {
	 		try {
	 			TmCmLookupDet ttLookupDetObj = lookupDetServ.getLookupDet(TreeCensusCommon.LOOKUPTREELEAFCOLOUR);
				try {
					if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
						tmTreeMasterMas.setStatus(1);
					}else {
						tmTreeMasterMas.setStatus(0);
					}
				}catch(NullPointerException n) {
					tmTreeMasterMas.setStatus(0);
				}
				tmTreeMasterMas.setTtLookupDet(ttLookupDetObj);
				tmTreeMasterMas.setUlbId(userBeanObj.getUlbId());
				tmTreeMasterMas.setCreatedBy(userBeanObj.getUserId());
				tmTreeMasterMas.setCreatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
				int id = treeMasterMasServ.save(tmTreeMasterMas);
				model.put("message",messageSource.getMessage("lable.common.sucess.added", null, locale));
				model.put("msgtype","success");
				detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREELEAFCOLOUR,treeMasterMasForm.getSearchKey());
	 		}catch(Exception e) {
	 			e.printStackTrace();
				model.put("message",messageSource.getMessage("lable.common.fail.add", null, locale));
				model.put("msgtype","error");
			}
		}else if(actionVal.equals("update")) {
			try {
				try {
					if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
						tmTreeMasterMas.setStatus(1);
					}else {
						tmTreeMasterMas.setStatus(0);
					}
				}catch(NullPointerException n) {
					tmTreeMasterMas.setStatus(0);
				}
			tmTreeMasterMas.setUpdatedBy(userBeanObj.getUserId());
			tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
				treeMasterMasServ.update(tmTreeMasterMas);
				
				model.put("message",messageSource.getMessage("lable.common.sucess.updated", null, locale));
				model.put("msgtype","success");
				detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREELEAFCOLOUR,treeMasterMasForm.getSearchKey());
			}catch(Exception e) {
				model.put("message",messageSource.getMessage("lable.common.fail.update", null, locale));
				model.put("msgtype","error");
			}
		}
		model.addAttribute("leafcolour",treeMasterMasForm);
		model.addAttribute("leafcolourList", detailsLst);
		
		return new ModelAndView(prefixURL+"/view-leafcolor",model,HttpStatus.OK);
    }
	
	/*-----------------------------------------------------------------Texture Master------------------------------------------------------------------------------------*/
	
	
@RequestMapping(value = "/texturemst/action/{actionVal}", method = RequestMethod.POST)
	
	public ModelAndView texturemstAction(@ModelAttribute("texturemst") TreeMasterMasForm treeMasterMasForm,HttpSession session,Locale locale, @PathVariable String actionVal,ModelMap model){	
		
		TmTreeMasterMas tmTreeMasterMas = treeMasterMasForm.getTmTreeMasterMas();
		UserBean userBeanObj = (UserBean)session.getAttribute("userBeanObj");
		List<TmTreeMasterMas> detailsLst = new ArrayList<TmTreeMasterMas>();
		
		if(actionVal.equals("delete")) {
			try{
				try {
					if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
						tmTreeMasterMas.setStatus(1);
					}else {
						tmTreeMasterMas.setStatus(0);
					}
				}catch(NullPointerException n) {
					tmTreeMasterMas.setStatus(0);
				}
			tmTreeMasterMas.setUpdatedBy(userBeanObj.getUserId());
			tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
			treeMasterMasServ.delete(tmTreeMasterMas);
			model.put("message",messageSource.getMessage("lable.common.sucess.deleted", null, locale));
			model.put("msgtype","success");
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREETEXTURE,treeMasterMasForm.getSearchKey());
			
			}catch(Exception e) {
				model.put("message",messageSource.getMessage("lable.common.fail.delete", null, locale));
				model.put("msgtype","error");
			}
		}else if(actionVal.equals("search")) {
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREETEXTURE,treeMasterMasForm.getSearchKey());
			
	 	}else if(actionVal.equals("add")) {
	 		try {
	 			TmCmLookupDet ttLookupDetObj = lookupDetServ.getLookupDet(TreeCensusCommon.LOOKUPTREETEXTURE);
				try {
					if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
						tmTreeMasterMas.setStatus(1);
					}else {
						tmTreeMasterMas.setStatus(0);
					}
				}catch(NullPointerException n) {
					tmTreeMasterMas.setStatus(0);
				}
				tmTreeMasterMas.setUlbId(userBeanObj.getUlbId());
				tmTreeMasterMas.setTtLookupDet(ttLookupDetObj);
				tmTreeMasterMas.setCreatedBy(userBeanObj.getUserId());
				tmTreeMasterMas.setCreatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
				int id = treeMasterMasServ.save(tmTreeMasterMas);
				model.put("message",messageSource.getMessage("lable.common.sucess.added", null, locale));
				model.put("msgtype","success");
				detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREETEXTURE,treeMasterMasForm.getSearchKey());
	 		}catch(Exception e) {
	 			e.printStackTrace();
				model.put("message",messageSource.getMessage("lable.common.fail.add", null, locale));
				model.put("msgtype","error");
			}
		}else if(actionVal.equals("update")) {
			try {
				try {
					if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
						tmTreeMasterMas.setStatus(1);
					}else {
						tmTreeMasterMas.setStatus(0);
					}
				}catch(NullPointerException n) {
					tmTreeMasterMas.setStatus(0);
				}
			tmTreeMasterMas.setUpdatedBy(userBeanObj.getUserId());
			tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
				treeMasterMasServ.update(tmTreeMasterMas);
				
				model.put("message",messageSource.getMessage("lable.common.sucess.updated", null, locale));
				model.put("msgtype","success");
				detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREETEXTURE,treeMasterMasForm.getSearchKey());
			}catch(Exception e) {
				model.put("message",messageSource.getMessage("lable.common.fail.update", null, locale));
				model.put("msgtype","error");
			}
		}
		model.addAttribute("texturemst",treeMasterMasForm);
		model.addAttribute("texturemstList", detailsLst);
		
		return new ModelAndView(prefixURL+"/view-texture",model,HttpStatus.OK);
		
}
/*---------------------------------------------------------------Flower Name-----------------------------------------------------------------------------------------*/


@RequestMapping(value = "/flowername/action/{actionVal}", method = RequestMethod.POST)

public ModelAndView flowernameAction(@ModelAttribute("flowername") TreeMasterMasForm treeMasterMasForm,HttpSession session,Locale locale, @PathVariable String actionVal,ModelMap model){	
	
	
	TmTreeMasterMas tmTreeMasterMas = treeMasterMasForm.getTmTreeMasterMas();
	UserBean userBeanObj = (UserBean)session.getAttribute("userBeanObj");
	List<TmTreeMasterMas> detailsLst = new ArrayList<TmTreeMasterMas>();
	
	if(actionVal.equals("delete")) {
		try{
			try {
				if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
					tmTreeMasterMas.setStatus(1);
				}else {
					tmTreeMasterMas.setStatus(0);
				}
			}catch(NullPointerException n) {
				tmTreeMasterMas.setStatus(0);
			}
		tmTreeMasterMas.setUpdatedBy(userBeanObj.getUserId());
		tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
		treeMasterMasServ.delete(tmTreeMasterMas);
		model.put("message",messageSource.getMessage("lable.common.sucess.deleted", null, locale));
		model.put("msgtype","success");
		detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEFLOWERNAME,treeMasterMasForm.getSearchKey());
		
		}catch(Exception e) {
			model.put("message",messageSource.getMessage("lable.common.fail.delete", null, locale));
			model.put("msgtype","error");
		}
	}else if(actionVal.equals("search")) {
		detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEFLOWERNAME,treeMasterMasForm.getSearchKey());
		
 	}else if(actionVal.equals("add")) {
 		try {
 			TmCmLookupDet ttLookupDetObj = lookupDetServ.getLookupDet(TreeCensusCommon.LOOKUPTREEFLOWERNAME);
			try {
				if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
					tmTreeMasterMas.setStatus(1);
				}else {
					tmTreeMasterMas.setStatus(0);
				}
			}catch(NullPointerException n) {
				tmTreeMasterMas.setStatus(0);
			}
			tmTreeMasterMas.setUlbId(userBeanObj.getUlbId());
			tmTreeMasterMas.setTtLookupDet(ttLookupDetObj);
			tmTreeMasterMas.setCreatedBy(userBeanObj.getUserId());
			tmTreeMasterMas.setCreatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
			int id = treeMasterMasServ.save(tmTreeMasterMas);
			model.put("message",messageSource.getMessage("lable.common.sucess.added", null, locale));
			model.put("msgtype","success");
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEFLOWERNAME,treeMasterMasForm.getSearchKey());
 		}catch(Exception e) {
 			e.printStackTrace();
			model.put("message",messageSource.getMessage("lable.common.fail.add", null, locale));
			model.put("msgtype","error");
		}
	}else if(actionVal.equals("update")) {
		try {
			try {
				if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
					tmTreeMasterMas.setStatus(1);
				}else {
					tmTreeMasterMas.setStatus(0);
				}
			}catch(NullPointerException n) {
				tmTreeMasterMas.setStatus(0);
			}
		tmTreeMasterMas.setUpdatedBy(userBeanObj.getUserId());
		tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
			treeMasterMasServ.update(tmTreeMasterMas);
			
			model.put("message",messageSource.getMessage("lable.common.sucess.updated", null, locale));
			model.put("msgtype","success");
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEFLOWERNAME,treeMasterMasForm.getSearchKey());
		}catch(Exception e) {
			model.put("message",messageSource.getMessage("lable.common.fail.update", null, locale));
			model.put("msgtype","error");
		}
	}
	model.addAttribute("flowername",treeMasterMasForm);
	model.addAttribute("flowernameList", detailsLst);
	
	return new ModelAndView(prefixURL+"/view-flowername",model,HttpStatus.OK);
	
}
/*-----------------------------------------------------------Flower Colour Master ----------------------------------------------------------------------------------*/


@RequestMapping(value = "/flowercolor/action/{actionVal}", method = RequestMethod.POST)

public ModelAndView flowercolorAction(@ModelAttribute("flowercolor") TreeMasterMasForm treeMasterMasForm,HttpSession session,Locale locale, @PathVariable String actionVal,ModelMap model){	
	
	
	TmTreeMasterMas tmTreeMasterMas = treeMasterMasForm.getTmTreeMasterMas();
	UserBean userBeanObj = (UserBean)session.getAttribute("userBeanObj");
	List<TmTreeMasterMas> detailsLst = new ArrayList<TmTreeMasterMas>();
	
	if(actionVal.equals("delete")) {
		try{
			try {
				if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
					tmTreeMasterMas.setStatus(1);
				}else {
					tmTreeMasterMas.setStatus(0);
				}
			}catch(NullPointerException n) {
				tmTreeMasterMas.setStatus(0);
			}
		tmTreeMasterMas.setUpdatedBy(userBeanObj.getUserId());
		tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
		treeMasterMasServ.delete(tmTreeMasterMas);
		model.put("message",messageSource.getMessage("lable.common.sucess.deleted", null, locale));
		model.put("msgtype","success");
		detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEFLOWERCOLOUR,treeMasterMasForm.getSearchKey());
		
		}catch(Exception e) {
			model.put("message",messageSource.getMessage("lable.common.fail.delete", null, locale));
			model.put("msgtype","error");
		}
	}else if(actionVal.equals("search")) {
		detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEFLOWERCOLOUR,treeMasterMasForm.getSearchKey());
		
 	}else if(actionVal.equals("add")) {
 		try {
 			TmCmLookupDet ttLookupDetObj = lookupDetServ.getLookupDet(TreeCensusCommon.LOOKUPTREEFLOWERCOLOUR);
			
			System.out.println(" treeMasterMasForm.getStatus()  "+treeMasterMasForm.getStatus());
			try {
				if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
					tmTreeMasterMas.setStatus(1);
				}else {
					tmTreeMasterMas.setStatus(0);
				}
			}catch(NullPointerException n) {
				tmTreeMasterMas.setStatus(0);
			}
			tmTreeMasterMas.setUlbId(userBeanObj.getUlbId());
			tmTreeMasterMas.setTtLookupDet(ttLookupDetObj);
			tmTreeMasterMas.setCreatedBy(userBeanObj.getUserId());
			tmTreeMasterMas.setCreatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
			int id = treeMasterMasServ.save(tmTreeMasterMas);
			model.put("message",messageSource.getMessage("lable.common.sucess.added", null, locale));
			model.put("msgtype","success");
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEFLOWERCOLOUR,treeMasterMasForm.getSearchKey());
 		}catch(Exception e) {
 			e.printStackTrace();
			model.put("message",messageSource.getMessage("lable.common.fail.add", null, locale));
			model.put("msgtype","error");
		}
	}else if(actionVal.equals("update")) {
		try {
			try {
				if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
					tmTreeMasterMas.setStatus(1);
				}else {
					tmTreeMasterMas.setStatus(0);
				}
			}catch(NullPointerException n) {
				tmTreeMasterMas.setStatus(0);
			}
			tmTreeMasterMas.setUpdatedBy(userBeanObj.getUserId());
			tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
			treeMasterMasServ.update(tmTreeMasterMas);
			
			model.put("message",messageSource.getMessage("lable.common.sucess.updated", null, locale));
			model.put("msgtype","success");
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEFLOWERCOLOUR,treeMasterMasForm.getSearchKey());
		}catch(Exception e) {
			model.put("message",messageSource.getMessage("lable.common.fail.update", null, locale));
			model.put("msgtype","error");
		}
	}
	model.addAttribute("flowercolor",treeMasterMasForm);
	model.addAttribute("flowercolorList", detailsLst);
	
	return new ModelAndView(prefixURL+"/view-flowercolor",model,HttpStatus.OK);
	
}
/*--------------------------------------------------------------------Fruit Name-------------------------------------------------------------------------------------*/


@RequestMapping(value = "/fruitname/action/{actionVal}", method = RequestMethod.POST)

public ModelAndView fruitnameAction(@ModelAttribute("fruitname") TreeMasterMasForm treeMasterMasForm,Locale locale,HttpSession session, @PathVariable String actionVal,ModelMap model){	
	
	
	TmTreeMasterMas tmTreeMasterMas = treeMasterMasForm.getTmTreeMasterMas();
	UserBean userBeanObj = (UserBean)session.getAttribute("userBeanObj");
	List<TmTreeMasterMas> detailsLst = new ArrayList<TmTreeMasterMas>();
	
	if(actionVal.equals("delete")) {
		try{
			
			try {
				if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
					tmTreeMasterMas.setStatus(1);
				}else {
					tmTreeMasterMas.setStatus(0);
				}
			}catch(NullPointerException n) {
				tmTreeMasterMas.setStatus(0);
			}
		tmTreeMasterMas.setUpdatedBy(userBeanObj.getUserId());
		tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
		treeMasterMasServ.delete(tmTreeMasterMas);
		model.put("message",messageSource.getMessage("lable.common.sucess.deleted", null, locale));
		model.put("msgtype","success");
		detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEFRUITNAME,treeMasterMasForm.getSearchKey());
		
		}catch(Exception e) {
			model.put("message",messageSource.getMessage("lable.common.fail.delete", null, locale));
			model.put("msgtype","error");
		}
	}else if(actionVal.equals("search")) {
		detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEFRUITNAME,treeMasterMasForm.getSearchKey());
		
 	}else if(actionVal.equals("add")) {
 		try {
 			TmCmLookupDet ttLookupDetObj = lookupDetServ.getLookupDet(TreeCensusCommon.LOOKUPTREEFRUITNAME);
			
			try {
				if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
					tmTreeMasterMas.setStatus(1);
				}else {
					tmTreeMasterMas.setStatus(0);
				}
			}catch(NullPointerException n) {
				tmTreeMasterMas.setStatus(0);
			}
			tmTreeMasterMas.setUlbId(userBeanObj.getUlbId());
			tmTreeMasterMas.setTtLookupDet(ttLookupDetObj);
			tmTreeMasterMas.setCreatedBy(userBeanObj.getUserId());
			tmTreeMasterMas.setCreatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
			int id = treeMasterMasServ.save(tmTreeMasterMas);
			model.put("message",messageSource.getMessage("lable.common.sucess.added", null, locale));
			model.put("msgtype","success");
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEFRUITNAME,treeMasterMasForm.getSearchKey());
 		}catch(Exception e) {
 			e.printStackTrace();
			model.put("message",messageSource.getMessage("lable.common.fail.add", null, locale));
			model.put("msgtype","error");
		}
	}else if(actionVal.equals("update")) {
		try {
			try {
				if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
					tmTreeMasterMas.setStatus(1);
				}else {
					tmTreeMasterMas.setStatus(0);
				}
			}catch(NullPointerException n) {
				tmTreeMasterMas.setStatus(0);
			}
			tmTreeMasterMas.setUpdatedBy(userBeanObj.getUserId());
			tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
			treeMasterMasServ.update(tmTreeMasterMas);
			
			model.put("message",messageSource.getMessage("lable.common.sucess.updated", null, locale));
			model.put("msgtype","success");
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEFRUITNAME,treeMasterMasForm.getSearchKey());
		}catch(Exception e) {
			model.put("message",messageSource.getMessage("lable.common.fail.update", null, locale));
			model.put("msgtype","error");
		}
	}
	model.addAttribute("fruitname",treeMasterMasForm);
	model.addAttribute("fruitnameList", detailsLst);
	
	return new ModelAndView(prefixURL+"/view-fruitname",model,HttpStatus.OK);
	
}
/*---------------------------------------------------------Shape Master-----------------------------------------------------------------------------------------*/





@RequestMapping(value = "/fruitshape/action/{actionVal}", method = RequestMethod.POST)

public ModelAndView fruitshapeAction(@ModelAttribute("fruitshape") TreeMasterMasForm treeMasterMasForm,Locale locale,HttpSession session,@PathVariable String actionVal,ModelMap model){	
	
	
	TmTreeMasterMas tmTreeMasterMas = treeMasterMasForm.getTmTreeMasterMas();
	UserBean userBeanObj = (UserBean)session.getAttribute("userBeanObj");
	List<TmTreeMasterMas> detailsLst = new ArrayList<TmTreeMasterMas>();
	
	if(actionVal.equals("delete")) {
		try{
		System.out.println("DELETE  "+tmTreeMasterMas.getTreemasId());
		
		try {
			if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
				tmTreeMasterMas.setStatus(1);
			}else {
				tmTreeMasterMas.setStatus(0);
			}
		}catch(NullPointerException n) {
			tmTreeMasterMas.setStatus(0);
		}
		
		tmTreeMasterMas.setUpdatedBy(userBeanObj.getUserId());
		tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
		
		treeMasterMasServ.delete(tmTreeMasterMas);
		model.put("message",messageSource.getMessage("lable.common.sucess.deleted", null, locale));
		model.put("msgtype","success");
		detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREESHAPE,treeMasterMasForm.getSearchKey());
		
		}catch(Exception e) {
			model.put("message",messageSource.getMessage("lable.common.fail.delete", null, locale));
			model.put("msgtype","error");
		}
	}else if(actionVal.equals("search")) {
		detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREESHAPE,treeMasterMasForm.getSearchKey());
		
 	}else if(actionVal.equals("add")) {
 		try {
 			TmCmLookupDet ttLookupDetObj = lookupDetServ.getLookupDet(TreeCensusCommon.LOOKUPTREESHAPE);
			
			System.out.println(" treeMasterMasForm.getStatus()  "+treeMasterMasForm.getStatus());
			try {
				if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
					tmTreeMasterMas.setStatus(1);
				}else {
					tmTreeMasterMas.setStatus(0);
				}
			}catch(NullPointerException n) {
				tmTreeMasterMas.setStatus(0);
			}
			tmTreeMasterMas.setUlbId(userBeanObj.getUlbId());
			tmTreeMasterMas.setTtLookupDet(ttLookupDetObj);
			tmTreeMasterMas.setUpdatedBy(userBeanObj.getUserId());
			tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
			
			int id = treeMasterMasServ.save(tmTreeMasterMas);
			model.put("message",messageSource.getMessage("lable.common.sucess.added", null, locale));
			model.put("msgtype","success");
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREESHAPE,treeMasterMasForm.getSearchKey());
 		}catch(Exception e) {
 			e.printStackTrace();
			model.put("message",messageSource.getMessage("lable.common.fail.add", null, locale));
			model.put("msgtype","error");
		}
	}else if(actionVal.equals("update")) {
		try {
			
			try {
				if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
					tmTreeMasterMas.setStatus(1);
				}else {
					tmTreeMasterMas.setStatus(0);
				}
			}catch(NullPointerException n) {
				tmTreeMasterMas.setStatus(0);
			}
			tmTreeMasterMas.setUpdatedBy(userBeanObj.getUserId());
			tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
			
			treeMasterMasServ.update(tmTreeMasterMas);
			
			model.put("message",messageSource.getMessage("lable.common.sucess.updated", null, locale));
			model.put("msgtype","success");
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREESHAPE,treeMasterMasForm.getSearchKey());
		}catch(Exception e) {
			model.put("message",messageSource.getMessage("lable.common.fail.update", null, locale));
			model.put("msgtype","error");
		}
	}
	model.addAttribute("fruitshape",treeMasterMasForm);
	model.addAttribute("fruitshapeList", detailsLst);
	
	return new ModelAndView(prefixURL+"/view-fruitshape",model,HttpStatus.OK);
	
}

/*---------------------------------------------------------------Odour Master------------------------------------------------------------------------------------------------*/





@RequestMapping(value = "/odour/action/{actionVal}", method = RequestMethod.POST)

public ModelAndView odourAction(@ModelAttribute("odour") TreeMasterMasForm treeMasterMasForm,Locale locale, HttpSession session,@PathVariable String actionVal,ModelMap model){	
	
	
	TmTreeMasterMas tmTreeMasterMas = treeMasterMasForm.getTmTreeMasterMas();
	UserBean userBeanObj = (UserBean)session.getAttribute("userBeanObj");
	List<TmTreeMasterMas> detailsLst = new ArrayList<TmTreeMasterMas>();
	
	if(actionVal.equals("delete")) {
		try{
		try {
			if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
				tmTreeMasterMas.setStatus(1);
			}else {
				tmTreeMasterMas.setStatus(0);
			}
		}catch(NullPointerException n) {
			tmTreeMasterMas.setStatus(0);
		}
		tmTreeMasterMas.setUpdatedBy(userBeanObj.getUserId());
		tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
		
		treeMasterMasServ.delete(tmTreeMasterMas);
		model.put("message",messageSource.getMessage("lable.common.sucess.deleted", null, locale));
		model.put("msgtype","success");
		detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEODOUR,treeMasterMasForm.getSearchKey());
		
		}catch(Exception e) {
			model.put("message",messageSource.getMessage("lable.common.fail.delete", null, locale));
			model.put("msgtype","error");
		}
	}else if(actionVal.equals("search")) {
		detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEODOUR,treeMasterMasForm.getSearchKey());
		
 	}else if(actionVal.equals("add")) {
 		try {
 			TmCmLookupDet ttLookupDetObj = lookupDetServ.getLookupDet(TreeCensusCommon.LOOKUPTREEODOUR);
			
			System.out.println(" treeMasterMasForm.getStatus()  "+treeMasterMasForm.getStatus());
			try {
				if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
					tmTreeMasterMas.setStatus(1);
				}else {
					tmTreeMasterMas.setStatus(0);
				}
			}catch(NullPointerException n) {
				tmTreeMasterMas.setStatus(0);
			}
			tmTreeMasterMas.setUlbId(userBeanObj.getUlbId());
			tmTreeMasterMas.setTtLookupDet(ttLookupDetObj);
			tmTreeMasterMas.setCreatedBy(userBeanObj.getUserId());
			tmTreeMasterMas.setCreatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
			int id = treeMasterMasServ.save(tmTreeMasterMas);
			model.put("message",messageSource.getMessage("lable.common.sucess.added", null, locale));
			model.put("msgtype","success");
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEODOUR,treeMasterMasForm.getSearchKey());
 		}catch(Exception e) {
 			e.printStackTrace();
			model.put("message",messageSource.getMessage("lable.common.fail.add", null, locale));
			model.put("msgtype","error");
		}
	}else if(actionVal.equals("update")) {
		try {
			try {
				if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
					tmTreeMasterMas.setStatus(1);
				}else {
					tmTreeMasterMas.setStatus(0);
				}
			}catch(NullPointerException n) {
				tmTreeMasterMas.setStatus(0);
			}
			tmTreeMasterMas.setUpdatedBy(userBeanObj.getUserId());
			tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
			treeMasterMasServ.update(tmTreeMasterMas);
			
			model.put("message",messageSource.getMessage("lable.common.sucess.updated", null, locale));
			model.put("msgtype","success");
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEODOUR,treeMasterMasForm.getSearchKey());
		}catch(Exception e) {
			model.put("message",messageSource.getMessage("lable.common.fail.update", null, locale));
			model.put("msgtype","error");
		}
	}
	model.addAttribute("odour",treeMasterMasForm);
	model.addAttribute("odourList", detailsLst);
	
	return new ModelAndView(prefixURL+"/view-odour",model,HttpStatus.OK);
	
}

/*----------------------------------------------------------------------------------------------------Tree Status Master--------------------------------------------------------------------------------------------------------------------------------------------------*/







@RequestMapping(value = "/treestatus/action/{actionVal}", method = RequestMethod.POST)

public ModelAndView treestatusAction(
		@ModelAttribute("treestatus") TreeMasterMasForm treeMasterMasForm,
		Locale locale, HttpSession session,
		@PathVariable String actionVal,ModelMap model){	
	
	UserBean userBeanObj = (UserBean)session.getAttribute("userBeanObj");
	TmTreeMasterMas tmTreeMasterMas = treeMasterMasForm.getTmTreeMasterMas();
	
	List<TmTreeMasterMas> detailsLst = new ArrayList<TmTreeMasterMas>();
	
	if(actionVal.equals("delete")) {
		try{
		treeMasterMasServ.delete(tmTreeMasterMas);
		model.put("message",messageSource.getMessage("lable.common.sucess.deleted", null, locale));
		model.put("msgtype","success");
		detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEESTATUS,treeMasterMasForm.getSearchKey());
		
		}catch(Exception e) {
			model.put("message",messageSource.getMessage("lable.common.fail.delete", null, locale));
			model.put("msgtype","error");
		}
	}else if(actionVal.equals("search")) {
		detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEESTATUS,treeMasterMasForm.getSearchKey());
		
 	}else if(actionVal.equals("add")) {
 		try {
 			TmCmLookupDet ttLookupDetObj = lookupDetServ.getLookupDet(TreeCensusCommon.LOOKUPTREEESTATUS);
			try {
				if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
					tmTreeMasterMas.setStatus(1);
				}else {
					tmTreeMasterMas.setStatus(0);
				}
			}catch(NullPointerException n) {
				tmTreeMasterMas.setStatus(0);
			}
			tmTreeMasterMas.setUlbId(userBeanObj.getUlbId());
			tmTreeMasterMas.setTtLookupDet(ttLookupDetObj);
			tmTreeMasterMas.setCreatedBy(userBeanObj.getUserId());
			tmTreeMasterMas.setCreatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
			int id = treeMasterMasServ.save(tmTreeMasterMas);
			model.put("message",messageSource.getMessage("lable.common.sucess.added", null, locale));
			model.put("msgtype","success");
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEESTATUS,treeMasterMasForm.getSearchKey());
 		}catch(Exception e) {
 			e.printStackTrace();
			model.put("message",messageSource.getMessage("lable.common.fail.add", null, locale));
			model.put("msgtype","error");
		}
	}else if(actionVal.equals("update")) {
		try {
			
			try {
				if(treeMasterMasForm.getStatus() != null && treeMasterMasForm.getStatus().equals("1")) {
					tmTreeMasterMas.setStatus(1);
				}else {
					tmTreeMasterMas.setStatus(0);
				}
			}catch(NullPointerException n) {
				tmTreeMasterMas.setStatus(0);
			}
			tmTreeMasterMas.setUpdatedBy(userBeanObj.getUserId());
			tmTreeMasterMas.setUpdatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
			treeMasterMasServ.update(tmTreeMasterMas);
			
			model.put("message",messageSource.getMessage("lable.common.sucess.updated", null, locale));
			model.put("msgtype","success");
			detailsLst =  getSearchList(TreeCensusCommon.LOOKUPTREEESTATUS,treeMasterMasForm.getSearchKey());
		}catch(Exception e) {
			model.put("message",messageSource.getMessage("lable.common.fail.update", null, locale));
			model.put("msgtype","error");
		}
	}
	model.addAttribute("treestatus",treeMasterMasForm);
	model.addAttribute("treestatusList", detailsLst);
	
	return new ModelAndView(prefixURL+"/view-treestatus",model,HttpStatus.OK);
	
}
}
