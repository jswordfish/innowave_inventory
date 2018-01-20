package com.innowave.mahaulb.web.treecensus.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.innowave.mahaulb.common.service.beans.UserBean;
import com.innowave.mahaulb.common.service.utils.beans.FilesBean;
import com.innowave.mahaulb.portal.utils.StringHelperUtils;
import com.innowave.mahaulb.service.treecensus.bean.CitizenSurveyRequest;
import com.innowave.mahaulb.service.treecensus.bean.SurveyRequestBean;
import com.innowave.mahaulb.service.treecensus.service.TreeLocationServ;
import com.innowave.mahaulb.service.treecensus.service.TreecensusServ;

@Controller
@RequestMapping("/treecensus")
public class ApplicationController {
	@Autowired
	private Environment env;
	
	@Autowired
	HttpSession httpsession;
	
	@Autowired
	TreecensusServ treecensusServ;
	
	@Autowired
	TreeLocationServ treeLocationServ;
	
	@Autowired
	private MessageSource messageSource; 
	private String customMessage = null;
	private final String prefixURL = "treecensus/applications/";
	private final String prefixServiceURL = "common/maha-dma/";
	
	public UserBean getSessionUser()
	{
		return  (UserBean) httpsession.getAttribute("userBeanObj");
		
	}
	
	@RequestMapping(value = "/application/surveyReq", method = RequestMethod.POST)
	public ModelAndView treecensusServiceRequestSave(Locale locale, ModelMap model,
			@ModelAttribute("surveyrequest") SurveyRequestBean surveyRequestBean) {
		int ulbId=getSessionUser().getUlbId();	
		model.addAttribute("ulbId", ulbId); 
		model.addAttribute("surveyrequest", new SurveyRequestBean());	
		surveyRequestBean.setUlbCode(getSessionUser().getUlbCode());
		surveyRequestBean.setUlbId(getSessionUser().getUlbId());
		surveyRequestBean.setCreatedBy(getSessionUser().getUserId());
		surveyRequestBean.setCreatedDate(new Date());
		surveyRequestBean.setSurveyDate(new Date());
		try {
			String srnId = treecensusServ.saveSurvyData(surveyRequestBean);
			//treecensusServ.saveLocationData(surveyRequestBean, serviceId);
			customMessage = messageSource.getMessage("lable.common.sucess.added.param", null, locale);
			String finalMessage =  customMessage.replace("{srnID}", srnId);
			model.addAttribute("message",finalMessage);
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("message",messageSource.getMessage("lable.common.fail.add", null, locale));
		}
		String jasonFile =  env.getProperty("google.map.key");
		model.addAttribute("key",jasonFile);
		return new ModelAndView(prefixURL + "application-surveyrequest", model, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/citizen/surveyReq", method = RequestMethod.POST)
	public ModelAndView treecensusCitizenRequestSave(Locale locale, ModelMap model,
			@ModelAttribute("applicationBean") CitizenSurveyRequest applicationBean,
			@ModelAttribute("filesBean") @Valid FilesBean fileBean, BindingResult binding) {
			String serviceId = null;
			applicationBean.setCreatedBy(1);
			applicationBean.setCreatedDate(new Date());
			applicationBean.setSurveyDate(new Date());
			try {
				serviceId = treecensusServ.saveCitizenData(applicationBean, fileBean);
				customMessage = messageSource.getMessage("lable.common.sucess.added.param", null, locale);
				String finalMessage =  customMessage.replace("{srnID}", serviceId);
				model.addAttribute("message",finalMessage);
			}catch(Exception e) {
				e.printStackTrace();
				model.addAttribute("message",messageSource.getMessage("lable.common.fail.add", null, locale));
			}
			System.out.println("Hello from Application Controller.");
			String jasonFile =  env.getProperty("google.map.key");
			model.addAttribute("key",jasonFile);
			model.addAttribute("applicationBean", new CitizenSurveyRequest());
			model.addAttribute("filesBean", new FilesBean());
			return new ModelAndView(prefixServiceURL+"tree-survey-application", model, HttpStatus.OK);
	}
}
