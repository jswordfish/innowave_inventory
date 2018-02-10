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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.common.dao.master.TmCmDepartment;
import com.innowave.mahaulb.common.repository.TmCmDepartmentRepo;
import com.innowave.mahaulb.common.repository.TmUlbMasterRepo;
import com.innowave.mahaulb.common.service.beans.UserBean;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialType;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialTypeStoreMapping;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;
import com.innowave.mahaulb.repository.inventory.repo.MaterialTypeRepo;
import com.innowave.mahaulb.repository.inventory.repo.MaterialTypeStoreMappingRepository;
import com.innowave.mahaulb.service.inventory.dto.master.InventoryMaterialMappingForm;
import com.innowave.mahaulb.service.inventory.dto.master.MaterialTypeMappingDTO;

@Controller
@RequestMapping("/inventory")
public class MasterMaterialTypeMappingController {

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
	
	

	private String departmentSelected;

	private String storeSelected;

	private final String prefixURL = "inventory";

	public UserBean getSessionUser() {
		// Session session = sessionFactory.getCurrentSession();
		return (UserBean) httpSession.getAttribute("userBeanObj");
	}

	@RequestMapping(value = "/fetchmaterialmapping", method = RequestMethod.GET, params = "fetchmaterialmapping")
    public String getMaterialMapping(Locale locale,ModelMap model,HttpServletRequest req){
		int ulbId=getSessionUser().getUlbId();	
		model.addAttribute("ulbId", ulbId);
		String dep = req.getParameter("department");
		String store = req.getParameter("store");
		
		
		InventoryMaterialMappingForm form = new InventoryMaterialMappingForm();
		form.setDepartment(dep);
		form.setStore(store);
		model.addAttribute("materialMappingForm", form);
		
		List<MaterialTypeMappingDTO> dtos = fetchMappings(store, ulbId, dep);
		form.setMappingDTOs(dtos);
		//for()
	
		//model.addAttribute("treeCensusDetail", ttTreeCensusDetails);
		
		List<TmCmDepartment> deps = materialTypeRepository.getAllDepartments(ulbId);
		
		List<TmInvStore> stores = mappingRepository.getAllStores(ulbId);
		
		//req.setAttribute("departments", deps);
		//req.setAttribute("stores", stores);
		model.addAttribute("departments", deps);
		model.addAttribute("stores", stores);
		model.addAttribute("dtos", dtos);
		
		req.getSession().setAttribute("invForm", form);
	    return prefixURL+"/master-search-materialmapping";
    }
	
	
	private List<MaterialTypeMappingDTO> fetchMappings(String store, Integer ulbId, String dep){
		List<TmInvMaterialTypeStoreMapping> mappings = mappingRepository.getMappings(store, ulbId);
		
		List<MaterialTypeMappingDTO> dtos = new ArrayList<>();
		int count = 0;
		for(TmInvMaterialTypeStoreMapping mapping : mappings) {
			MaterialTypeMappingDTO dto = new MaterialTypeMappingDTO();
			dto.setSerial(count+1);
			dto.setActive((mapping.getStatus()!= null && mapping.getStatus()==1)?true:false);
			TmCmDepartment department = depRepo.getDepartmentById(Integer.parseInt(dep));
			dto.setDepName(department.getDepNameEn());
			dto.setDepId(department.getDepId());
			dto.setMaterialTypeName(mapping.getTmInvMaterialType().getMaterialTypeName());
			dto.setMaterialTypeCode(mapping.getTmInvMaterialType().getMaterialTypeCode());
			dto.setMaterialTypeId(mapping.getTmInvMaterialType().getMaterialTypeId());
			dto.setMaterialTypeStoreMapId(mapping.getMaterialTypeStoreMapId());
			TmInvStore store2 = mappingRepository.getStoreById(Long.parseLong(store));
			dto.setStoreName(store2.getStoreName());
			dto.setStoreId(store2.getStoreId());
			dto.setAccountCode("Account Code NA");
			
			//dto.setm
			
			dtos.add(dto);
		}
	return dtos;
	}

	@RequestMapping(value = "/fetchmaterialmapping", method = RequestMethod.GET, params = "resetmaterialmapping")
    public String resetmaterialmapping(Locale locale,ModelMap model,HttpServletRequest req){
		int ulbId=getSessionUser().getUlbId();	
		model.addAttribute("ulbId", ulbId);
		
		model.addAttribute("materialMappingForm", new InventoryMaterialMappingForm());
		
	
		//model.addAttribute("treeCensusDetail", ttTreeCensusDetails);
		
		List<TmCmDepartment> deps = materialTypeRepository.getAllDepartments(ulbId);
		
		List<TmInvStore> stores = mappingRepository.getAllStores(ulbId);
		
		
		//req.setAttribute("departments", deps);
		//req.setAttribute("stores", stores);
		model.addAttribute("departments", deps);
		model.addAttribute("stores", stores);
		
		
	    return prefixURL+"/master-search-materialmapping";
    }
	
	@RequestMapping(value = "/getstoresfordep", method = RequestMethod.GET)
    public String getStoresForDep(Locale locale,ModelMap model,HttpServletRequest req){
		int ulbId=getSessionUser().getUlbId();	
		model.addAttribute("ulbId", ulbId);
		model.addAttribute("materialMappingForm", new InventoryMaterialMappingForm());
		String depid = req.getParameter("depId");
		
		InventoryMaterialMappingForm form = new InventoryMaterialMappingForm();
		form.setDepartment(depid);
		//form.setStore(store);
		model.addAttribute("materialMappingForm", form);
	
		//model.addAttribute("treeCensusDetail", ttTreeCensusDetails);
		
		List<TmCmDepartment> deps = materialTypeRepository.getAllDepartments(ulbId);
		
		List<TmInvStore> stores = mappingRepository.getAllStoresForDepartment(ulbId, Integer.parseInt(depid));
		
		
		//req.setAttribute("departments", deps);
		//req.setAttribute("stores", stores);
		model.addAttribute("departments", deps);
		model.addAttribute("stores", stores);
		
		
	    return prefixURL+"/master-search-materialmapping";
    }

	@RequestMapping(value = "/fetchmaterialmapping", method = RequestMethod.GET, params="addmaterialtypemapping")
    public String viewMaterialMappingAdd(Locale locale,ModelMap model,HttpServletRequest req){
		int ulbId=getSessionUser().getUlbId();	
		model.addAttribute("ulbId", ulbId);
		String dep = req.getParameter("department");
		String store = req.getParameter("store");
		
		if(dep == null || store == null || dep.trim().length() == 0 || store.trim().length() == 0) {
			return "";
		}
		
		try {
			Long.parseLong(dep);
			Long.parseLong(store);
		}
		catch(NumberFormatException e) {
			return delegate(locale, model, req);
		}
		
		InventoryMaterialMappingForm form = (InventoryMaterialMappingForm) req.getSession().getAttribute("invForm");
			if(form == null) {
				form = new InventoryMaterialMappingForm();
				
			}
			form.setStore(store);
			form.setDepartment(dep);
			MaterialTypeMappingDTO current = new MaterialTypeMappingDTO();
			TmCmDepartment department = depRepo.getDepartmentById(Integer.parseInt(dep));
			current.setDepName(department.getDepNameEn());
			TmInvStore store2 = mappingRepository.getStoreById(Long.parseLong(store));
			current.setStoreName(store2.getStoreName());
			current.setStoreId(store2.getStoreId());
			current.setAccountCode("Account Code NA");
			form.setCurrentMappingDTO(current);
			
		//model.addAttribute("treeCensusDetail", ttTreeCensusDetails);
	
		List<TmInvMaterialType> mTypes = materialTypeRepository.findTmInvMaterialTypesByULB(ulbId);
		model.addAttribute("mTypes", mTypes);
		model.addAttribute("invForm", form);
		model.addAttribute("editMaping", false);
		req.getSession().setAttribute("invForm", form);
	    return prefixURL+"/master-add-materialmapping";
    }
	
	
	private String delegate(Locale locale,ModelMap model,HttpServletRequest req) {
		int ulbId=getSessionUser().getUlbId();	
		model.addAttribute("ulbId", ulbId);
		
		InventoryMaterialMappingForm form = (InventoryMaterialMappingForm) req.getSession().getAttribute("invForm");
			if(form != null) {
				model.addAttribute("materialMappingForm", form);
			}
			else {
				model.addAttribute("materialMappingForm", new InventoryMaterialMappingForm());
			}
		
	
		//model.addAttribute("treeCensusDetail", ttTreeCensusDetails);
		
		List<TmCmDepartment> deps = materialTypeRepository.getAllDepartments(ulbId);
		
		List<TmInvStore> stores = mappingRepository.getAllStores(ulbId);
		
		
		//req.setAttribute("departments", deps);
		//req.setAttribute("stores", stores);
		model.addAttribute("departments", deps);
		model.addAttribute("stores", stores);
		
		
	    return prefixURL+"/master-search-materialmapping";
	}

	@RequestMapping(value = "/editmaterialmapping", method = RequestMethod.GET)
    public String editmaterialmapping(Locale locale,ModelMap model,HttpServletRequest req){
		int ulbId=getSessionUser().getUlbId();	
		model.addAttribute("ulbId", ulbId);
		Long materialTypeStoreMapId = Long.parseLong(req.getParameter("materialTypeStoreMapId"));
		InventoryMaterialMappingForm form = (InventoryMaterialMappingForm) req.getSession().getAttribute("invForm");
			List<MaterialTypeMappingDTO> dtos = form.getMappingDTOs();
			MaterialTypeMappingDTO current = null;
			for(MaterialTypeMappingDTO dto : dtos) {
				if(dto.getMaterialTypeStoreMapId() == materialTypeStoreMapId) {
					current = dto;
					break;
				}
			}
			
			form.setCurrentMappingDTO(current);
		model.addAttribute("invForm", form);
		model.addAttribute("editMaping", true);
	
		List<TmInvMaterialType> mTypes = materialTypeRepository.findTmInvMaterialTypesByULB(ulbId);
		model.addAttribute("mTypes", mTypes);
	    return prefixURL+"/master-add-materialmapping";
    }
	
	@RequestMapping(value = "/deletematerialmapping", method = RequestMethod.GET)
    public String deletematerialmapping(Locale locale,ModelMap model,HttpServletRequest req){
		int ulbId=getSessionUser().getUlbId();	
		model.addAttribute("ulbId", ulbId);
		Long materialTypeStoreMapId = Long.parseLong(req.getParameter("materialTypeStoreMapId"));
		InventoryMaterialMappingForm form = (InventoryMaterialMappingForm) req.getSession().getAttribute("invForm");
			
		model.addAttribute("invForm", form);
		model.addAttribute("editMaping", true);
		TmInvMaterialTypeStoreMapping mapping = new TmInvMaterialTypeStoreMapping();
		mapping.setMaterialTypeStoreMapId(materialTypeStoreMapId);
		int rem = mappingRepository.removeTmInvMaterialTypeStoreMapping(mapping);
		//List<TmInvMaterialType> mTypes = materialTypeRepository.r
		List<MaterialTypeMappingDTO> dtos = fetchMappings(form.getStore(), ulbId,form.getDepartment());
		form.setMappingDTOs(dtos);
		
		model.addAttribute("materialMappingForm", form);
		
		model.addAttribute("dtos", dtos);
	   // return prefixURL+"/view-materialmappingsearch";
		//return new InventoryMenuController().viewMaterialMapping(locale, model, req);
		return delegate(locale, model, req);
	
	}

	@RequestMapping(value = "/savemapping", method = RequestMethod.POST)
    public String saveMaterialmapping(Locale locale,ModelMap model,HttpServletRequest req){
		int ulbId=getSessionUser().getUlbId();	
		model.addAttribute("ulbId", ulbId);
		
		String materialTypeId = req.getParameter("currentMappingDTO.materialTypeId");
		String active =req.getParameter("currentMappingDTO.active");
		
		
		
		
		InventoryMaterialMappingForm form = (InventoryMaterialMappingForm) req.getSession().getAttribute("invForm");
		MaterialTypeMappingDTO mappingDTO = form.getCurrentMappingDTO();
			if(materialTypeId == null) {
				materialTypeId = mappingDTO.getMaterialTypeId()+"";
			}
		
		mappingDTO.setMaterialTypeId(Long.parseLong(materialTypeId));
		
		TmInvMaterialTypeStoreMapping mapping = new TmInvMaterialTypeStoreMapping();
		mapping.setUpdatedBy(getSessionUser().getUserId());
		//mapping.setMaterialTypeStoreMapId(2);
		
		TmInvStore store1 = mappingRepository.getStoreById(mappingDTO.getStoreId());
		mapping.setTmInvStore(store1);
		
		
		TmUlb ulb = ulbMasterRepo.getTmULB(ulbId);
		TmInvMaterialType materialType = materialTypeRepository.getById(Long.parseLong(materialTypeId));
	
		materialType.setTmUlb(ulb);
		mapping.setTmInvMaterialType(materialType);
		
		mapping.setTmUlb(ulb);
		
		mapping.setAccountCode(0l);
		mapping.setStatus((active!=null && active.equals("true"))?1:0);
		
		mappingRepository.saveOrUpdate(mapping);
		List<MaterialTypeMappingDTO> dtos = fetchMappings(""+mapping.getTmInvStore().getStoreId(), ulbId,form.getDepartment());
//		boolean present = false;
//		for(MaterialTypeMappingDTO dto : form.getMappingDTOs()) {
//			if(dto.getMaterialTypeId().equals(mappingDTO.getMaterialTypeId()) && dto.getStoreCode().equals(mappingDTO.getStoreCode())){
//				present = true;
//				break;
//			}
//		}
//		
//		if(!present) {
//			form.getMappingDTOs().add(mappingDTO);
//		}
		form.setMappingDTOs(dtos);
			
		model.addAttribute("materialMappingForm", form);
		
		model.addAttribute("dtos", dtos);
	   // return prefixURL+"/view-materialmappingsearch";
		//return new InventoryMenuController().viewMaterialMapping(locale, model, req);
		return delegate(locale, model, req);
    }
	
	
	// viewstore
	/*@RequestMapping(value = "/viewstore", method = RequestMethod.GET)
	public String viewStore(Locale locale, ModelMap model,
			HttpServletRequest req) {
		int ulbId = getSessionUser().getUlbId();
		model.addAttribute("ulbId", ulbId);

		// model.addAttribute("treeCensusDetail", ttTreeCensusDetails);

		return prefixURL + "/view-store";
	}*/

	

	public String getDepartmentSelected() {
		return departmentSelected;
	}

	public void setDepartmentSelected(String departmentSelected) {
		this.departmentSelected = departmentSelected;
	}

	public String getStoreSelected() {
		return storeSelected;
	}

	public void setStoreSelected(String storeSelected) {
		this.storeSelected = storeSelected;
	}
}
