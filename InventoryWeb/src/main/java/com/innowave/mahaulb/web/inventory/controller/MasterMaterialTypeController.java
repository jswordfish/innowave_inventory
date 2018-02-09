package com.innowave.mahaulb.web.inventory.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.common.dao.master.TmCmDepartment;
import com.innowave.mahaulb.common.service.beans.UserBean;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialType;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;
import com.innowave.mahaulb.repository.inventory.repo.MaterialTypeRepo;
import com.innowave.mahaulb.service.inventory.dto.master.InventoryMasterMaterialTypeForm;
import com.innowave.mahaulb.service.inventory.dto.master.InventoryMaterialMappingForm;
import com.innowave.mahaulb.service.inventory.dto.master.MaterialTypeDTO;
import com.innowave.mahaulb.service.inventory.dto.master.SearchMaterialType;
import com.innowave.mahaulb.service.inventory.service.MasterMaterialTypeServ;

@Controller
@RequestMapping("/inventory")
public class MasterMaterialTypeController {

	private final String prefixURL = "inventory/masters";
	
	@Autowired
	MasterMaterialTypeServ masterMaterialTypServ;
	
	
	@Autowired
	private MessageSource messageSource; 
	
	@Autowired
	private MaterialTypeRepo materialTypeRepository;
	
	@Autowired
	private HttpSession httpSession;
	
	public UserBean getSessionUser() {
		// Session session = sessionFactory.getCurrentSession();
		return (UserBean) httpSession.getAttribute("userBeanObj");
	}
	
	
	@RequestMapping(value = "/materialType/add", method = RequestMethod.POST)
	public void addMaterialType(@ModelAttribute("addmaterialtype") InventoryMasterMaterialTypeForm inventoryMasterMaterialTypeForm,
			Locale locale,HttpSession session, 
			HttpServletRequest request,ModelMap model)
			{
		TmInvMaterialType invMaterialType= new TmInvMaterialType();
		TmUlb tmUlb= new TmUlb();
		tmUlb.setUlbId(getSessionUser().getUlbId());
		invMaterialType.setTmUlb(tmUlb);
		invMaterialType.setMaterialTypeCode(inventoryMasterMaterialTypeForm.getMaterialTypeCode());
		invMaterialType.setMaterialTypeName(inventoryMasterMaterialTypeForm.getMaterialTypeName());
		invMaterialType.setMaterialTypeDesc(inventoryMasterMaterialTypeForm.getMaterialDesc());
		invMaterialType.setMacId(getSessionUser().getMacId());
		if(inventoryMasterMaterialTypeForm.isActive())
		{
			invMaterialType.setStatus(1);	
		}
		else
		{
			invMaterialType.setStatus(0);
		}
		if(inventoryMasterMaterialTypeForm.isParentType())
		{
			invMaterialType.setParentTypeYn("Y");
		}
		else
		{
			invMaterialType.setParentTypeYn("N");
		}
		HashMap<Long, String> selectedParentTyp= inventoryMasterMaterialTypeForm.getSelectedParentType();
		Iterator it = selectedParentTyp.entrySet().iterator();
		TmInvMaterialType invMaterialType1=null;
	    while (it.hasNext()) {
	    	invMaterialType1= new TmInvMaterialType();
	        Map.Entry pair = (Map.Entry)it.next();
	        invMaterialType1.setMaterialTypeId(Long.parseLong(pair.getKey().toString()));
	        invMaterialType1.setMaterialTypeName(pair.getValue().toString());
	       break; 
	    }
	    invMaterialType.setTmInvMaterialType(invMaterialType1);
	    invMaterialType.setIpAddress(getSessionUser().getIpAddress());
	    Timestamp ts=new Timestamp(System.currentTimeMillis());  
	    invMaterialType.setCreatedDate(getSessionUser().getCreatedDate());
	    invMaterialType.setCreatedBy(getSessionUser().getCreatedBy());
	    masterMaterialTypServ.saveOrUpdate(invMaterialType);
	    model.put("message",messageSource.getMessage("inserted", null, locale));
		model.put("msgtype","success");
			}
	
	@RequestMapping(value = "/getparentmaterial", method = RequestMethod.GET)
    public String getParentForselectedMaterial(Locale locale,ModelMap model,HttpServletRequest req){
		int ulbId=getSessionUser().getUlbId();	
		model.addAttribute("ulbId", ulbId);
		model.addAttribute("searchmaterialtyp", new InventoryMaterialMappingForm());
		String selectedId = req.getParameter("materialTypeId");
		List<TmInvMaterialType> materialTypeList = materialTypeRepository.findTmInvMaterialTypesByULB(getSessionUser().getUlbId());
		Set<TmInvMaterialType> parentMaterialType=null;
		SearchMaterialType form = new SearchMaterialType();
		for (TmInvMaterialType tmInvMaterialType : materialTypeList) {
			if(tmInvMaterialType.getMaterialTypeId()==(Long.parseLong(selectedId)))
			{
				parentMaterialType=tmInvMaterialType.getTmInvMaterialTypes();
				form.setMaterialTypeId(tmInvMaterialType.getMaterialTypeId());
				form.setMaterialTypeName(tmInvMaterialType.getMaterialTypeName());
				break;
			}
		}
		form.setParentMaterialTypList(parentMaterialType);
		model.addAttribute("materiallist", materialTypeList);
		model.addAttribute("parentmaterialtyp", parentMaterialType);
		model.addAttribute("materialMappingForm", form);
	    return prefixURL+"/master-search-materialtype";
    }

	
	@RequestMapping(value = "/materialType/search", method = RequestMethod.POST)
	public String searchMaterialType(@ModelAttribute("searchmaterialtyp")SearchMaterialType searchMaterialType2 ,Locale locale,HttpSession session, 
			HttpServletRequest request,ModelMap model)
			{
		int ulbId = getSessionUser().getUlbId();
		model.addAttribute("ulbId", ulbId);
		String materialTypeName = request.getParameter("materialTypeName");
		String parentMaterialTyp = request.getParameter("parentMaterialTyp");
		//SearchMaterialType searchMaterialType2= new SearchMaterialType();
		searchMaterialType2.setMaterialTypeName(materialTypeName);
		searchMaterialType2.setParentMaterialTyp(parentMaterialTyp);
		model.addAttribute("searchmaterialtyp", searchMaterialType2);
		List<TmInvMaterialType> parentMaterialTypeList = masterMaterialTypServ.getMaterialTypeByParentType(ulbId, materialTypeName, parentMaterialTyp);
		List<MaterialTypeDTO> materialTypeDTOs = new ArrayList<>();
		int count = 0;
		for (TmInvMaterialType invMaterialType : parentMaterialTypeList) {
			MaterialTypeDTO materialTypeDTO= new MaterialTypeDTO();
			MaterialTypeDTO parentMaterialType= new MaterialTypeDTO();
			materialTypeDTO.setSerial(count+1);
			materialTypeDTO.setMaterialTypeId(invMaterialType.getMaterialTypeId());
			materialTypeDTO.setMaterialTypCode(invMaterialType.getMaterialTypeCode());
			materialTypeDTO.setMaterialTypeName(invMaterialType.getMaterialTypeName());
			materialTypeDTO.setMaterialTypeDesc(invMaterialType.getMaterialTypeDesc());
			parentMaterialType.setMaterialTypCode(invMaterialType.getTmInvMaterialType().getMaterialTypeCode());
			parentMaterialType.setMaterialTypeName(invMaterialType.getTmInvMaterialType().getMaterialTypeName());
			materialTypeDTO.setParentMaterialType(parentMaterialType);
			materialTypeDTOs.add(materialTypeDTO);
		}
		searchMaterialType2.setMaterialTypList(parentMaterialTypeList);
		model.addAttribute("typeDTOs", materialTypeDTOs);
		
		model.addAttribute("parentMaterialTypeList", parentMaterialTypeList);
		request.getSession().setAttribute("searchmaterialtyp", searchMaterialType2);
		return prefixURL + "/master-search-materialtype";
			}
	
	@RequestMapping(value = "/editmaterialType", method = RequestMethod.GET)
	private String editmaterialType(Locale locale, ModelMap model,
			HttpServletRequest req)
	{
		int ulbId = getSessionUser().getUlbId();
		model.addAttribute("ulbId", ulbId);
		Long materialTypeId = Long.parseLong(req
				.getParameter("materialTypeId"));
		SearchMaterialType searchMaterialType=(SearchMaterialType) req
				.getSession().getAttribute("searchmaterialtyp");
		List<MaterialTypeDTO> materialTypList=searchMaterialType.getTypeDTOs();
		MaterialTypeDTO currentMaterialSelected=null;
		for (MaterialTypeDTO dto : materialTypList) {
			if (dto.getMaterialTypeId() == materialTypeId) {
				currentMaterialSelected = dto;
				break;
			}
		}
		searchMaterialType.setMaterialTypeDTO(currentMaterialSelected);
		List<TmInvMaterialType> detailsLst=masterMaterialTypServ.getMaterialTypeList(getSessionUser().getUlbId(),"Y");
		searchMaterialType.setMaterialTypList(detailsLst);
		model.addAttribute("searchmaterialtyp", searchMaterialType);
		model.addAttribute("editMaping", true);
		return prefixURL+"/master-add-materialtype";
		
	}
	
}
