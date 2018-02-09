package com.innowave.mahaulb.web.inventory.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.common.dao.master.TmCmDepartment;
import com.innowave.mahaulb.common.dao.master.TmUsers;
import com.innowave.mahaulb.common.repository.TmCmDepartmentRepo;
import com.innowave.mahaulb.common.repository.TmUsersRepo;
import com.innowave.mahaulb.common.service.beans.UserBean;
import com.innowave.mahaulb.portal.utils.DateTimeZoneHelper;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;
import com.innowave.mahaulb.repository.inventory.repo.MaterialStoreRepo;
import com.innowave.mahaulb.repository.inventory.repo.MaterialTypeRepo;
import com.innowave.mahaulb.repository.inventory.repo.MaterialTypeStoreMappingRepository;
import com.innowave.mahaulb.service.inventory.dto.master.MaterialStoreDTO;
import com.innowave.mahaulb.service.inventory.dto.master.MaterialStoreForm;
import com.innowave.mahaulb.service.inventory.service.MasterMaterialStoreServ;


@Controller
@Scope("session")
@RequestMapping("/inventory")
public class MasterMaterialStoreController {

	@Autowired
	private MessageSource messageSource; 
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	MasterMaterialStoreServ masterMaterialStoreServ;
	
	@Autowired
	TmCmDepartmentRepo cmDepartmentRepo;
	
	@Autowired
	private MaterialTypeRepo materialTypeRepository;
	
	@Autowired
	private MaterialTypeStoreMappingRepository mappingRepository;
	
	private final String prefixURL = "inventory/masters";
	
	@Autowired
	TmUsersRepo tmUsersRepo;
	
	@Autowired
	MaterialStoreRepo materialStoreRepo;
	
	@ModelAttribute("materialstoreform")
	public MaterialStoreForm construct()
	{
		return new MaterialStoreForm();
	}
	
	public UserBean getSessionUser() {
		// Session session = sessionFactory.getCurrentSession();
		return (UserBean) httpSession.getAttribute("userBeanObj");
	}
	@RequestMapping(value = "/saveMasterStore", method = RequestMethod.POST)
	public String addMaterialStore(@ModelAttribute("materialstoreform") MaterialStoreForm materialStoreForm, Locale locale,HttpSession session, 
			HttpServletRequest request,ModelMap model)
			{
		try{
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		int ulbId = getSessionUser().getUlbId();
		model.addAttribute("ulbId", ulbId);
		String selectedDepartmentId = request.getParameter("selectedDept");
		String selectedUser = request.getParameter("selectedUser");
		//MaterialStoreForm materialStoreForm=(MaterialStoreForm)request.getAttribute("materialstoreform");
		TmCmDepartment cmDepartment=cmDepartmentRepo.getDepartmentById(Integer.parseInt(selectedDepartmentId));
		TmUsers tmUsers= tmUsersRepo.getUserDetails(Integer.parseInt(selectedUser));
		TmInvStore invStore= new TmInvStore();
		TmUlb tmUlb= new TmUlb();
		tmUlb.setUlbId(ulbId);
		invStore.setTmUlb(tmUlb);
		invStore.setStoreCode(materialStoreForm.getStoreCode());
		invStore.setStoreName(materialStoreForm.getStoreName());
		invStore.setStoreDesc(materialStoreForm.getStoreDesc());
		invStore.setDepId(cmDepartment.getDepId());
		if(materialStoreForm.isCentralStore())
		{
			invStore.setCentralStoreYn("Y");
		}
		else
		{
			invStore.setCentralStoreYn("N");
		}
		
		
		invStore.setBillingAdd(materialStoreForm.getBillingAddress());
		invStore.setDeliveryAdd(materialStoreForm.getDeliveryAddress());
		invStore.setStoreIncharge(tmUsers.getUserName());
		invStore.setContactNo1(materialStoreForm.getContact1());
		invStore.setContactNo2(materialStoreForm.getContact2());
		if(materialStoreForm.isActive())
		{
			invStore.setStatus(1);
		}
		else
		{
			invStore.setStatus(0);
		}
		invStore.setCreatedBy(getSessionUser().getCreatedBy());
		invStore.setCreatedDate(DateTimeZoneHelper.getCurrentSysTimestamp()); 
		invStore.setIpAddress(ipAddress);
		invStore.setMacId(getSessionUser().getMacId());
		masterMaterialStoreServ.saveOrUpdate(invStore);
		model.put("message",messageSource.getMessage("lable.common.sucess.added", null, locale));
		model.put("msgtype","success");
		return addStore(locale,model,request);
		}
		catch(Exception e) {
 			e.printStackTrace();
 			model.put("message",messageSource.getMessage("lable.common.fail.add", null, locale));
			model.put("msgtype","error");
		}
		return null;
			}
	@RequestMapping(value = "/search", params ="addmaterial",method = RequestMethod.POST)
	public String addStore(Locale locale, ModelMap model, HttpServletRequest req) {
		int ulbId = getSessionUser().getUlbId();
		model.addAttribute("ulbId", ulbId);
		MaterialStoreForm materialStoreForm= (MaterialStoreForm) req.getSession().getAttribute("materialstoreform");
		if(materialStoreForm==null)
		{
			materialStoreForm= construct();
		}
		List<TmUsers> usersList=masterMaterialStoreServ.getUserList(ulbId);
		List<TmCmDepartment> cmDepartments=masterMaterialStoreServ.getAllDepartments(ulbId);
		materialStoreForm.setCmDepartments(cmDepartments);
		materialStoreForm.setTmUsers(usersList);
		model.addAttribute("ulbId", ulbId);
		model.addAttribute("cmDepartments", cmDepartments);
		model.addAttribute("usersList", usersList);
		model.addAttribute("editMaping", false);
		model.addAttribute("materialstoreform", materialStoreForm);
		req.getSession().setAttribute("materialstoreform", materialStoreForm);
		return prefixURL + "/master-add-store";
	}
	@RequestMapping(value = "/search", params ="resetMaterial",method = RequestMethod.POST)
	public String resetMaterialStore(Locale locale, ModelMap model, HttpServletRequest req) {
		MaterialStoreForm materialStoreForm= new MaterialStoreForm();
		int ulbId = getSessionUser().getUlbId();
		List<TmCmDepartment> deps = materialTypeRepository.getAllDepartments(ulbId);
		List<TmInvStore> stores = mappingRepository.getAllStores(ulbId);
		model.addAttribute("departments", deps);
		model.addAttribute("stores", stores);
		model.addAttribute("ulbId", ulbId);
		model.addAttribute("storeForm", materialStoreForm);
		return prefixURL + "/master-search-store";
	}
	
	@RequestMapping(value = "/saveMasterStore", params ="resetstore",method = RequestMethod.POST)
	public String resetMaterialAdd(Locale locale, ModelMap model, HttpServletRequest req) {
		MaterialStoreForm materialStoreForm= new MaterialStoreForm();
		int ulbId = getSessionUser().getUlbId();
		List<TmUsers> usersList=masterMaterialStoreServ.getUserList(ulbId);
		List<TmCmDepartment> cmDepartments=masterMaterialStoreServ.getAllDepartments(ulbId);
		materialStoreForm.setCmDepartments(cmDepartments);
		materialStoreForm.setTmUsers(usersList);
		List<TmCmDepartment> deps = materialTypeRepository.getAllDepartments(ulbId);
		List<TmInvStore> stores = mappingRepository.getAllStores(ulbId);
		model.addAttribute("departments", deps);
		model.addAttribute("stores", stores);
		model.addAttribute("ulbId", ulbId);
		model.addAttribute("storeForm", materialStoreForm);
		return prefixURL + "/master-search-store";
	}
	
	@RequestMapping(value = "/search",params ="searchmaterial", method = RequestMethod.POST)
	public String searchMaterialStore(@ModelAttribute("storeForm") MaterialStoreForm materialStoreForm,Locale locale,HttpSession session,
			HttpServletRequest request,ModelMap model)
			{
		int ulbId = getSessionUser().getUlbId();
		model.addAttribute("ulbId", ulbId);
		String dep = request.getParameter("selectedDept");
		String store = request.getParameter("selectedInvStore");
	//	MaterialStoreForm materialStoreForm = (MaterialStoreForm) request.getSession().getAttribute("storeForm");
//		MaterialStoreForm materialStoreForm= new MaterialStoreForm();
		materialStoreForm.setSelectedDept(dep);
		materialStoreForm.setSelectedInvStore(store);
		request.getSession().setAttribute("storeForm", materialStoreForm);
//		model.addAttribute("storeForm", materialStoreForm);
		List<TmInvStore> invStores=masterMaterialStoreServ.getAllMaterialStoresByIds(ulbId,Long.parseLong(store),Integer.parseInt(dep));
		TmCmDepartment cmDepartment=cmDepartmentRepo.getDepartmentById(Integer.parseInt(dep));
		List<TmCmDepartment> deps = materialTypeRepository.getAllDepartments(ulbId);
		List<TmInvStore> stores = mappingRepository.getAllStores(ulbId);
		List<MaterialStoreDTO> materialStoreDTO = new ArrayList<MaterialStoreDTO>();
		MaterialStoreDTO dto=null;
		Integer count=0;
		for (TmInvStore tmInvStore : invStores) {
			dto= new MaterialStoreDTO();
			dto.setCentralStore(tmInvStore.getCentralStoreYn());
			dto.setSequence(count+1);
			dto.setDeptName(cmDepartment.getDepNameEn());
			dto.setStoreId(tmInvStore.getStoreId());
			dto.setStoreName(tmInvStore.getStoreName());
			materialStoreDTO.add(dto);	
		}
		materialStoreForm.setInvStores(invStores);
		materialStoreForm.setMaterialStoreDTOs(materialStoreDTO);
		model.addAttribute("departments", deps);
		model.addAttribute("stores", stores);
		model.addAttribute("dtos", materialStoreDTO);
		request.getSession().setAttribute("materialstoreform", materialStoreForm);
		return prefixURL+"/master-search-store";
			}
	@RequestMapping(value = "/editmaterialStore", method = RequestMethod.GET)
	public String editmaterialStore(Locale locale,HttpSession session, 
			HttpServletRequest request,ModelMap model)
			{
		int ulbId = getSessionUser().getUlbId();
		model.addAttribute("ulbId", ulbId);
		Long materialStoreId = Long.parseLong(request.getParameter("storeId"));
		MaterialStoreForm materialStoreForm=(MaterialStoreForm) request
				.getSession().getAttribute("storeForm");
		List<MaterialStoreDTO> invStores=materialStoreForm.getMaterialStoreDTOs();
		MaterialStoreDTO currentSelected=null;
		for (MaterialStoreDTO materialStoreDTO : invStores) {
				if (materialStoreDTO.getStoreId() == materialStoreId) {
					currentSelected = materialStoreDTO;
					break;
				}
		}
		materialStoreForm.setSelectMaterial(currentSelected);
		List<TmUsers> list=new ArrayList<TmUsers>();
		TmUsers tmUser=tmUsersRepo.getEmployeeUser(getSessionUser().getUserName(), ulbId);
		list.add(tmUser);
		List<TmCmDepartment> cmDepartments=masterMaterialStoreServ.getAllDepartments(ulbId);
		materialStoreForm.setCmDepartments(cmDepartments);
		materialStoreForm.setTmUsers(list);
		model.addAttribute("ulbId", ulbId);
		model.addAttribute("storeForm", materialStoreForm);
		return prefixURL + "/master-add-store";
			}
	
	
	
	@RequestMapping(value = "/deletematerialStore", method = RequestMethod.GET)
	public ModelAndView deletematerialStore(Locale locale,HttpSession session, 
			HttpServletRequest request,ModelMap model)
			{
		try{
		int ulbId=getSessionUser().getUlbId();	
		model.addAttribute("ulbId", ulbId);
		Long materialTypeStoreMapId = Long.parseLong(request.getParameter("storeId"));
		Integer deptId=Integer.parseInt(request.getParameter("depId"));
		MaterialStoreForm form = (MaterialStoreForm) request.getSession().getAttribute("storeForm");
			
		model.addAttribute("storeForm", form);
		model.addAttribute("editMaping", true);
		TmInvStore storeIdForDelete = new TmInvStore();
		storeIdForDelete.setStoreId(materialTypeStoreMapId);
		int rem = masterMaterialStoreServ.removeStoreById(storeIdForDelete);
		List<TmInvStore> invStores=masterMaterialStoreServ.getAllMaterialStoresByIds(ulbId,materialTypeStoreMapId,deptId);
		TmCmDepartment cmDepartment=cmDepartmentRepo.getDepartmentById(deptId);
		List<MaterialStoreDTO> materialStoreDTO = new ArrayList<MaterialStoreDTO>();
		MaterialStoreDTO dto=null;
		Integer count=0;
		for (TmInvStore tmInvStore : invStores) {
			dto= new MaterialStoreDTO();
			dto.setCentralStore(tmInvStore.getCentralStoreYn());
			dto.setSequence(count+1);
			dto.setDeptName(cmDepartment.getDepNameEn());
			dto.setStoreId(tmInvStore.getStoreId());
			dto.setStoreName(tmInvStore.getStoreName());
			materialStoreDTO.add(dto);	
		}
		form.setInvStores(invStores);
		form.setMaterialStoreDTOs(materialStoreDTO);
		//List<TmInvMaterialType> mTypes = materialTypeRepository.r
		//List<MaterialTypeMappingDTO> dtos = fetchMappings(form.getStore(), ulbId,form.getDepartment());
		form.setMaterialStoreDTOs(materialStoreDTO);
		
		model.addAttribute("materialMappingForm", form);
		model.put("message",messageSource.getMessage("lable.common.sucess.added", null, locale));
		model.put("msgtype","success");
		model.addAttribute("dtos", materialStoreDTO);
	   // return prefixURL+"/view-materialmappingsearch";
		return new InventoryMenuController().searchStore(locale, model, request);
		}
		catch(Exception e) {
 			e.printStackTrace();
 			model.put("message",messageSource.getMessage("lable.common.fail.add", null, locale));
			model.put("msgtype","error");
		}
		return null;
}
}
