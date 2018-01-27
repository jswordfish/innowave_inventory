package com.innowave.mahaulb.web.inventory.controller;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.innowave.mahaulb.common.service.beans.UserBean;
import com.innowave.mahaulb.service.inventory.dto.master.InventoryMasterMaterialTypeForm;

@Controller
@PropertySource("classpath:application.properties")
@RequestMapping("/inventory")
public class InventoryMenuController {

public static final Logger logger = LoggerFactory.getLogger(InventoryMenuController.class);
	
private final String prefixURLStoreMaster = "inventory/storemaster";
private final String prefixURLMaterialMaster = "inventory/materialmaster";
private final String prefixURLMaterialMappingMaster = "inventory/materialmappingmaster";

	@Autowired
	private Environment env;
	
	
	/*@Autowired
	TreeMasterMasServ treeMasterMasServ;*/
	
	@Autowired
	private MessageSource messageSource; 
	
	Map<Integer, String> treeScientificNameDtlList=null;
	
	@Autowired
	HttpSession httpsession;
	
	/*@Autowired
	TreeCensusSurvyAppInspctrService treeCensusSurvyAppInspctrService;*/

	public UserBean getSessionUser()
	{
		return  (UserBean) httpsession.getAttribute("userBeanObj");
		
	}
	
	@RequestMapping(value = "/addmaterialtype", method = RequestMethod.GET)
    public ModelAndView viewTreeName(Locale locale,ModelMap model){
		model.addAttribute("addmaterialtype", new InventoryMasterMaterialTypeForm() );
		model.addAttribute("ulbId",getSessionUser().getUlbId());

		return new ModelAndView(prefixURLMaterialMaster+"/master-add-materialtype","model",model);
    }
}
