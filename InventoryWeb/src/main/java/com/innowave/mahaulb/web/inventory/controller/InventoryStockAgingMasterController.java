package com.innowave.mahaulb.web.inventory.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.innowave.mahaulb.common.dao.master.TmCmDepartment;
import com.innowave.mahaulb.common.repository.TmCmDepartmentRepo;
import com.innowave.mahaulb.common.repository.TmUlbMasterRepo;
import com.innowave.mahaulb.common.service.beans.UserBean;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;
import com.innowave.mahaulb.repository.inventory.repo.MaterialTypeRepo;
import com.innowave.mahaulb.repository.inventory.repo.MaterialTypeStoreMappingRepository;
import com.innowave.mahaulb.service.inventory.dto.master.InventoryMaterialMappingForm;

@Controller
@RequestMapping("/inventory")
public class InventoryStockAgingMasterController {
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private HttpSession httpSession;

	@Autowired
	private MaterialTypeStoreMappingRepository mappingRepository;

	@Autowired
	private MaterialTypeRepo materialTypeRepository;

	@Autowired
	private TmCmDepartmentRepo depRepo;
	
	@Autowired
	private TmUlbMasterRepo ulbMasterRepo;
	
	@Autowired
	HttpSession httpsession;

	private String departmentSelected;

	private String storeSelected;

	private final String prefixURL = "inventory";
	
	public UserBean getSessionUser() {

		return (UserBean) httpsession.getAttribute("userBeanObj");
	}
	
	
	@RequestMapping(value = "/viewstockagingmaster", method = RequestMethod.GET)
	public String viewMaterialMapping(Locale locale, ModelMap model,
			HttpServletRequest req) {
		int ulbId = getSessionUser().getUlbId();
		model.addAttribute("ulbId", ulbId);

	

		return prefixURL + "/master-search-stock-aging-slab-master";
	}
}
