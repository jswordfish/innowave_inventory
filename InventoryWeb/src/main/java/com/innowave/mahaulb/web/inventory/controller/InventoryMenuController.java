package com.innowave.mahaulb.web.inventory.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.innowave.mahaulb.common.dao.master.TmCmDepartment;
import com.innowave.mahaulb.common.dao.master.TmUsers;
import com.innowave.mahaulb.common.repository.TmCmDepartmentRepo;
import com.innowave.mahaulb.common.repository.TmUlbMasterRepo;
import com.innowave.mahaulb.common.repository.TmUsersRepo;
import com.innowave.mahaulb.common.service.beans.UserBean;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialType;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;
import com.innowave.mahaulb.repository.inventory.repo.MaterialTypeRepo;
import com.innowave.mahaulb.repository.inventory.repo.MaterialTypeStoreMappingRepository;
import com.innowave.mahaulb.service.inventory.dto.master.InventoryMasterMaterialTypeForm;
import com.innowave.mahaulb.service.inventory.dto.master.InventoryMaterialMappingForm;
import com.innowave.mahaulb.service.inventory.dto.master.MaterialStoreForm;
import com.innowave.mahaulb.service.inventory.dto.master.SearchMaterialType;
import com.innowave.mahaulb.service.inventory.service.MasterMaterialStoreServ;
import com.innowave.mahaulb.service.inventory.service.MasterMaterialTypeServ;

@Controller
@PropertySource("classpath:application.properties")
@RequestMapping("/inventory")
@Scope("session")
public class InventoryMenuController {

	public static final Logger logger = LoggerFactory
			.getLogger(InventoryMenuController.class);

	private final String prefixURL = "inventory/masters";

	@Autowired
	private Environment env;

	@Autowired
	private MaterialTypeRepo materialTypeRepository;

	@Autowired
	MasterMaterialTypeServ masterMaterialTypServ;

	@Autowired
	private MessageSource messageSource;

	Map<Integer, String> treeScientificNameDtlList = null;

	@Autowired
	HttpSession httpsession;

	@Autowired
	TmUlbMasterRepo ulbMasterRepo;

	@Autowired
	TmUsersRepo tmUsersRepo;

	@Autowired
	TmCmDepartmentRepo depRepo;

	@Autowired
	MasterMaterialStoreServ masterMaterialStoreServ;

	@Autowired
	private MaterialTypeStoreMappingRepository mappingRepository;

	public UserBean getSessionUser() {

		return (UserBean) httpsession.getAttribute("userBeanObj");
	}

	@RequestMapping(value = "/viewmaterialmapping", method = RequestMethod.GET)
	public String viewMaterialMapping(Locale locale, ModelMap model,
			HttpServletRequest req) {
		int ulbId = getSessionUser().getUlbId();
		model.addAttribute("ulbId", ulbId);

		InventoryMaterialMappingForm form = (InventoryMaterialMappingForm) req
				.getSession().getAttribute("invForm");
		if (form != null) {
			model.addAttribute("materialMappingForm", form);
		} else {
			model.addAttribute("materialMappingForm",
					new InventoryMaterialMappingForm());
		}

		// model.addAttribute("treeCensusDetail", ttTreeCensusDetails);

		List<TmCmDepartment> deps = materialTypeRepository
				.getAllDepartments(ulbId);

		List<TmInvStore> stores = mappingRepository.getAllStores(ulbId);

		// req.setAttribute("departments", deps);
		// req.setAttribute("stores", stores);
		model.addAttribute("departments", deps);
		model.addAttribute("stores", stores);

		//return prefixURL + "/master-search-materialmapping";
		/**
		 *@TODO - Remove this method from here as all methods here uses the global prefix except this one.
		 */
		return "inventory"+ "/master-search-materialmapping";
	}

	@RequestMapping(value = "/addmaterialtype", method = RequestMethod.GET)
	public ModelAndView displayAddMaterial(Locale locale, ModelMap model) {
		model.addAttribute("addmaterialtype",
				new InventoryMasterMaterialTypeForm());
		model.addAttribute("ulbId", getSessionUser().getUlbId());
		// to fetch the list of existed material type where parent type is "Y"
		List<TmInvMaterialType> materialTypeList = getMaterialTypeList();
		model.addAttribute("materialtypelist", materialTypeList);

		return new ModelAndView(prefixURL + "/master-add-materialtype");
	}

	@RequestMapping(value = "/addstore", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String addStore(Locale locale, ModelMap model, HttpServletRequest req) {
		MaterialStoreForm materialStoreForm = new MaterialStoreForm();
		int ulbId = getSessionUser().getUlbId();
		List<TmUsers> usersList = masterMaterialStoreServ.getUserList(ulbId);
		List<TmCmDepartment> cmDepartments = masterMaterialStoreServ
				.getAllDepartments(ulbId);
		materialStoreForm.setCmDepartments(cmDepartments);
		materialStoreForm.setTmUsers(usersList);
		model.addAttribute("ulbId", ulbId);
		model.addAttribute("storeForm", materialStoreForm);
		model.addAttribute("cmDepartments", cmDepartments);
		model.addAttribute("usersList", usersList);

		return prefixURL + "/master-add-store";
	}

	@RequestMapping(value = "/searchstore", method = RequestMethod.GET)
	public ModelAndView searchStore(Locale locale, ModelMap model,
			HttpServletRequest req) {
		int ulbId = getSessionUser().getUlbId();
		MaterialStoreForm materialform = (MaterialStoreForm) req.getSession()
				.getAttribute("materialstoreform");
		MaterialStoreForm materialStoreForm = new MaterialStoreForm();
		if (materialform != null) {
			model.addAttribute("storeForm", materialform);
		} else {
			model.addAttribute("storeForm", new MaterialStoreForm());
		}
		List<TmInvStore> invStores = masterMaterialStoreServ
				.getAllMaterialStores(ulbId);
		List<TmCmDepartment> cmDepartments = masterMaterialStoreServ
				.getAllDepartments(ulbId);
		materialStoreForm.setCmDepartments(cmDepartments);
		materialStoreForm.setInvStores(invStores);
		model.addAttribute("ulbId", ulbId);
		model.addAttribute("departments", cmDepartments);
		model.addAttribute("stores", invStores);
		return new ModelAndView(prefixURL + "/master-search-store", "command",
				model);
	}

	@RequestMapping(value = "/searchmaterialtype", method = RequestMethod.GET)
	public ModelAndView searchMaterialTyp(Locale locale, ModelMap model) {
		List<TmInvMaterialType> materialTypeList = materialTypeRepository
				.findTmInvMaterialTypesByULB(getSessionUser().getUlbId());
		Set<TmInvMaterialType> tmInvMaterialTypes = new HashSet<TmInvMaterialType>(
				0);
		SearchMaterialType searchMaterialType = new SearchMaterialType();
		searchMaterialType.setMaterialTypList(materialTypeList);
		searchMaterialType.setParentMaterialTypList(tmInvMaterialTypes);
		model.addAttribute("searchmaterialtyp", searchMaterialType);
		model.addAttribute("materiallist", materialTypeList);
		model.addAttribute("parentmaterialtyp", tmInvMaterialTypes);
		model.addAttribute("ulbId", getSessionUser().getUlbId());
		return new ModelAndView(prefixURL + "/master-search-materialtype",
				"command", model);
	}

	@RequestMapping(value = "/materialType/list", method = RequestMethod.GET)
	public List<TmInvMaterialType> materialTypeList() {
		List<TmInvMaterialType> detailsLst = new ArrayList<TmInvMaterialType>();
		detailsLst = getMaterialTypeList();
		return detailsLst;
	}

	private List<TmInvMaterialType> getMaterialTypeList() {
		List<TmInvMaterialType> detailsLst = new ArrayList<TmInvMaterialType>();
		detailsLst = masterMaterialTypServ.getMaterialTypeList(getSessionUser()
				.getUlbId(), "Y");
		return detailsLst;
	}
}
