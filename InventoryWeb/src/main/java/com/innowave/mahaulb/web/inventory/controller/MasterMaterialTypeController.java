package com.innowave.mahaulb.web.inventory.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.innowave.mahaulb.common.service.beans.UserBean;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialType;
import com.innowave.mahaulb.service.inventory.dto.master.InventoryMasterMaterialTypeForm;
import com.innowave.mahaulb.service.inventory.service.MasterMaterialTypeServ;

@Controller
@RequestMapping("/materialmaster")
public class MasterMaterialTypeController {

	private final String prefixURLMaterialMaster = "inventory/materialmaster";
	
	
	@Autowired
	MasterMaterialTypeServ masterMaterialTypServ;

	
	@Autowired
	private MessageSource messageSource; 
	@Autowired
	private HttpSession httpSession;
	
	public UserBean getSessionUser() {
		// Session session = sessionFactory.getCurrentSession();
		return (UserBean) httpSession.getAttribute("userBeanObj");
	}
	
	
	@RequestMapping(value = "/materialType/add", method = RequestMethod.POST)
	public ModelAndView addMaterialType(@ModelAttribute("addmaterialtype") InventoryMasterMaterialTypeForm inventoryMasterMaterialTypeForm,
			Locale locale,HttpSession session, 
			HttpServletRequest request,ModelMap model)
			{
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
				return null;
		
			}
	
	@RequestMapping(value = "/materialType/list", method = RequestMethod.POST)
	public List<TmInvMaterialType> materialTypeList(@ModelAttribute("addmaterialtype") TmInvMaterialType TmInvMaterialType,
			Locale locale,HttpSession session, 
			HttpServletRequest request)
			{
		List<TmInvMaterialType> detailsLst = new ArrayList<TmInvMaterialType>();
		UserBean userBeanObj = (UserBean)session.getAttribute("userBeanObj");
		detailsLst = getMaterialTypeList(TmInvMaterialType);
		//model.addAttribute("invmaterialTypList",detailsLst);
		return detailsLst;
		
			}

	private List<TmInvMaterialType> getMaterialTypeList(TmInvMaterialType invMaterialType)
	{
		List<TmInvMaterialType> detailsLst = new ArrayList<TmInvMaterialType>();
		detailsLst=masterMaterialTypServ.getMaterialTypeList(invMaterialType);
		return detailsLst;
	}
}
