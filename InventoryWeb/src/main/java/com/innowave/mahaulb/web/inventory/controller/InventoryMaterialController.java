package com.innowave.mahaulb.web.inventory.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.terracotta.offheapstore.buffersource.TimingBufferSource;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.dao.TmCmLookupDetHierarchical;
import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.common.dao.master.TmCmDepartment;
import com.innowave.mahaulb.common.dao.master.TmUsers;
import com.innowave.mahaulb.common.service.beans.UserBean;
import com.innowave.mahaulb.portal.utils.DateTimeZoneHelper;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterial;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialType;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;
import com.innowave.mahaulb.service.inventory.dto.master.MasterMaterialDTO;
import com.innowave.mahaulb.service.inventory.dto.master.MaterialStoreDTO;
import com.innowave.mahaulb.service.inventory.dto.master.MaterialStoreForm;
import com.innowave.mahaulb.service.inventory.service.MasterMaterialServ;
import com.innowave.mahaulb.service.inventory.service.MasterMaterialTypeServ;
import com.innowave.mahaulb.web.inventory.controller.forms.InvMaterialForm;
import com.innowave.mahaulb.web.inventory.controller.forms.InvMaterialSupplierForm;

@Controller
@Scope("session")
@RequestMapping("/inventory")
public class InventoryMaterialController {

	@Autowired
	private MessageSource messageSource; 
	

	@Autowired
	MasterMaterialTypeServ masterMaterialTypServ;
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	MasterMaterialServ materialServ;
	

	
	private final String prefixURL = "inventory/masters";
	
	public UserBean getSessionUser() {
		// Session session = sessionFactory.getCurrentSession();
		return (UserBean) httpSession.getAttribute("userBeanObj");
	}
	
	@RequestMapping(value = "/saveMastermaterial",params="closematerialadd", method = RequestMethod.POST)
	public ModelAndView closeMaterialAdd(Locale locale, ModelMap model) {
		int ulbId = getSessionUser().getUlbId();
		InvMaterialForm invMaterialForm= new InvMaterialForm();
		List<TmInvMaterialType> invMaterialTypes= masterMaterialTypServ.findMaterialTypesByUlb(ulbId);
		invMaterialForm.setInvMaterialTypes(invMaterialTypes);
		model.addAttribute("materialTypes", invMaterialTypes);
		model.addAttribute("materialform", invMaterialForm);
		model.addAttribute("ulbId", getSessionUser().getUlbId());
		return new ModelAndView(prefixURL + "/master-search-material",
				"command", model);
	}
	
	@RequestMapping(value = "/searchmaterial",params ="searchmaterial", method = RequestMethod.POST)
	public ModelAndView searchMaterial(@ModelAttribute("materialform") InvMaterialForm invMaterialForm,Locale locale,HttpSession session,
			HttpServletRequest request,ModelMap model)
			{
			if(invMaterialForm.getMaterialCode()==null || invMaterialForm.getMaterialCode().isEmpty()&&
					invMaterialForm.getSelectedMaterialTyp()==null||invMaterialForm.getSelectedMaterialTyp().isEmpty() &&
					invMaterialForm.getMaterialName()==null||invMaterialForm.getMaterialName().isEmpty()){
				return closeMaterialAdd(locale,model);
				// return new ModelAndView(prefixURL+"/master-search-material","command",model);
				//return new InventoryMenuController().searchStore(locale, model, request);
			}
			int ulbId = getSessionUser().getUlbId();
			model.addAttribute("ulbId", ulbId);
			String materialCode = request.getParameter("materialCode");
			String materialType = request.getParameter("selectedMaterialTyp");
			List<TmInvMaterial> materialList=materialServ.getMaterialTypList(Long.parseLong(materialType),Integer.valueOf(ulbId), materialCode);
			List<MasterMaterialDTO> dtos= new ArrayList<MasterMaterialDTO>();
			List<TmInvMaterialType> invMaterialTypes= masterMaterialTypServ.findMaterialTypesByUlb(ulbId);
			int count=0;
			MasterMaterialDTO dto=null;
					for (TmInvMaterial material : materialList) {
					dto= new MasterMaterialDTO();
					dto.setSequence(count+1);
					dto.setMaterialId(material.getMaterialId());
//					dto.setMaterialCode(material.getMaterialCode());
					dto.setMaterialName(material.getMaterialName());
					dto.setMaterialOldCode(material.getMaterialCode());
					if(material.getTmInvMaterialType()!=null)
					{
					dto.setMaterialType(material.getTmInvMaterialType().getMaterialTypeName());
					}
					dtos.add(dto);
					}
					invMaterialForm.setMaterialList(dtos);
					model.addAttribute("dtos", dtos);
					model.addAttribute("materialTypes", invMaterialTypes);
					model.addAttribute("materialform", invMaterialForm);
					model.addAttribute("ulbId", getSessionUser().getUlbId());
					return new ModelAndView(prefixURL + "/master-search-material",
							"command", model);
			
			}	
	
	@RequestMapping(value = "/editmaterial", method = RequestMethod.GET)
	public String editmaterialStore(@ModelAttribute("materialform") InvMaterialForm invMaterialForm,Locale locale,HttpSession session, 
			HttpServletRequest request,ModelMap model)
			{
		int ulbId = getSessionUser().getUlbId();
		model.addAttribute("ulbId", ulbId);
		String materialId=request.getParameter("materialId");
		TmInvMaterial materialList=materialServ.getMaterialbyId(Integer.parseInt(materialId), ulbId);
		TmInvMaterialType invMaterialType=materialList.getTmInvMaterialType();
		invMaterialForm.setSelectedMaterialTyp(invMaterialType.getMaterialTypeName());
		List<TmInvMaterialType> invMaterialTypes= masterMaterialTypServ.findMaterialTypesByUlb(ulbId);
		invMaterialForm.setInvMaterialTypes(invMaterialTypes);
		List<TmCmLookupDetHierarchical> cmLookupDetHierarchicalsBaseUom=materialServ.getBaseUom(ulbId);
		invMaterialForm.setBaseUoms(cmLookupDetHierarchicalsBaseUom);
		List<TmCmLookupDet> cmLookupDets=new ArrayList<TmCmLookupDet>();
		TmCmLookupDet cmLookupDet=null;
		for (TmCmLookupDetHierarchical tmCmLookupDetHierarchical : cmLookupDetHierarchicalsBaseUom) {
			cmLookupDet= tmCmLookupDetHierarchical.getTmCmLookupDet();
			cmLookupDets.add(cmLookupDet);
		}
		invMaterialForm.setMaterialCode(materialList.getMaterialCode());
		invMaterialForm.setMaterialName(materialList.getMaterialName());
		invMaterialForm.setMaterialDesc(materialList.getMaterialDesc());
		invMaterialForm.setMaterialOldCode(materialList.getMaterialCode());
		TmCmLookupDetHierarchical cmLookupDetHierarchical= materialList.getTmCmLookupDetHierarchicalByLookupDetIdBaseUom();
		invMaterialForm.setBaseUoms(cmLookupDetHierarchicalsBaseUom);
		TmCmLookupDet cmLookupDet2=materialList.getTmCmLookupDetByLookupDetIdInvType();
		invMaterialForm.setInventoryTypes(cmLookupDets);
		invMaterialForm.setUsageList(cmLookupDets);
		invMaterialForm.setPurchaseUoms(cmLookupDetHierarchicalsBaseUom);
		invMaterialForm.setStockUoms(cmLookupDetHierarchicalsBaseUom);
		model.addAttribute("invMaterialTypes",invMaterialTypes);
		model.addAttribute("baseuom", cmLookupDetHierarchicalsBaseUom);
		model.addAttribute("inventoryTypes", cmLookupDets);
		model.addAttribute("purchaseuom", cmLookupDetHierarchicalsBaseUom);
		model.addAttribute("usagelist", cmLookupDets);
		model.addAttribute("stockuom", cmLookupDetHierarchicalsBaseUom);
		model.addAttribute("ulbId", ulbId);
		model.addAttribute("materialaddform", invMaterialForm);
		return prefixURL + "/master-add-material";
		
			}
	
	
	
	@RequestMapping(value = "/deletematerial", method = RequestMethod.GET)
	public ModelAndView deletematerial(@ModelAttribute("materialform") InvMaterialForm invMaterialForm,Locale locale,HttpSession session, 
			HttpServletRequest request,ModelMap model)
			{
		try {
		int ulbId = getSessionUser().getUlbId();
		model.addAttribute("ulbId", ulbId);
		String materialId=request.getParameter("materialId");
		TmInvMaterial invMaterial= new TmInvMaterial();
		invMaterial.setMaterialId(Long.parseLong(materialId));
		TmInvMaterial materialList=materialServ.getMaterialbyId(Integer.parseInt(materialId), ulbId);
		TmInvMaterialType invMaterialType=materialList.getTmInvMaterialType();
		try
		{
		int rem=materialServ.removeMaterial(invMaterial);
		}catch(Exception e)
		{
			model.put("message","Delete the Material Mapping first");
			model.put("msgtype","error");
			return new ModelAndView(prefixURL + "/master-search-material",
					"command", model);
		}
		//String materialList = request.getParameter("materialCode");
		//String materialType = request.getParameter("selectedMaterialTyp");
		List<TmInvMaterial> materialLists=materialServ.getMaterialTypList(invMaterialType.getMaterialTypeId(),Integer.valueOf(ulbId),materialList.getMaterialCode());
		List<MasterMaterialDTO> dtos= new ArrayList<MasterMaterialDTO>();
		List<TmInvMaterialType> invMaterialTypes= masterMaterialTypServ.findMaterialTypesByUlb(ulbId);
		//InvMaterialForm invMaterialForm=new InvMaterialForm();
		int count=0;
		MasterMaterialDTO dto=null;
				for (TmInvMaterial material : materialLists) {
				dto= new MasterMaterialDTO();
				dto.setSequence(count+1);
				dto.setMaterialId(material.getMaterialId());
//				dto.setMaterialCode(material.getMaterialCode());
				dto.setMaterialName(material.getMaterialName());
				dto.setMaterialOldCode(material.getMaterialCode());
				dto.setMaterialType(material.getTmInvMaterialType().getMaterialTypeName());
				dtos.add(dto);
				}
				invMaterialForm.setMaterialList(dtos);
				model.addAttribute("dtos", dtos);
				model.addAttribute("materialTypes", invMaterialTypes);
				model.addAttribute("materialform", invMaterialForm);
				model.addAttribute("ulbId", getSessionUser().getUlbId());
				model.put("message",messageSource.getMessage("lable.common.sucess.deleted", null, locale));
				model.put("msgtype","success");
		}catch(Exception e)
		{
 			model.put("message","Delete the Material Mapping first");
			model.put("msgtype","error");
		}
				return new ModelAndView(prefixURL + "/master-search-material",
						"command", model);
			}
	@RequestMapping(value = "/searchmaterial", params ="addmaterial",method = RequestMethod.POST)
	public String addmaterial(Locale locale, ModelMap model, HttpServletRequest req)
	{
		int ulbId = getSessionUser().getUlbId();
		model.addAttribute("ulbId", ulbId);
		InvMaterialForm invMaterialForm = (InvMaterialForm) req.getSession().getAttribute("materialform");
		if(invMaterialForm==null)
		{
			invMaterialForm=new  InvMaterialForm();
		}
		List<TmInvMaterialType> invMaterialTypes= masterMaterialTypServ.findMaterialTypesByUlb(ulbId);
		invMaterialForm.setInvMaterialTypes(invMaterialTypes);
		List<TmCmLookupDetHierarchical> cmLookupDetHierarchicalsBaseUom=materialServ.getBaseUom(ulbId);
		invMaterialForm.setBaseUoms(cmLookupDetHierarchicalsBaseUom);
		List<TmCmLookupDet> cmLookupDets=new ArrayList<TmCmLookupDet>();
		TmCmLookupDet cmLookupDet=null;
		for (TmCmLookupDetHierarchical tmCmLookupDetHierarchical : cmLookupDetHierarchicalsBaseUom) {
			cmLookupDet= tmCmLookupDetHierarchical.getTmCmLookupDet();
			cmLookupDets.add(cmLookupDet);
		}
		invMaterialForm.setInventoryTypes(cmLookupDets);
		invMaterialForm.setUsageList(cmLookupDets);
		invMaterialForm.setPurchaseUoms(cmLookupDetHierarchicalsBaseUom);
		invMaterialForm.setStockUoms(cmLookupDetHierarchicalsBaseUom);
		model.addAttribute("invMaterialTypes",invMaterialTypes);
		model.addAttribute("baseuom", cmLookupDetHierarchicalsBaseUom);
		model.addAttribute("inventoryTypes", cmLookupDets);
		model.addAttribute("purchaseuom", cmLookupDetHierarchicalsBaseUom);
		model.addAttribute("usagelist", cmLookupDets);
		model.addAttribute("stockuom", cmLookupDetHierarchicalsBaseUom);
		model.addAttribute("ulbId", ulbId);
		model.addAttribute("materialaddform", invMaterialForm);
		return prefixURL + "/master-add-material";
}

@RequestMapping(value = "/searchmaterial", params ="resetmaterial",method = RequestMethod.POST)
public ModelAndView searchMaterial(Locale locale, ModelMap model, HttpServletRequest req) {
	int ulbId = getSessionUser().getUlbId();
	InvMaterialForm invMaterialForm= new InvMaterialForm();
	List<TmInvMaterialType> invMaterialTypes= masterMaterialTypServ.findMaterialTypesByUlb(ulbId);
	invMaterialForm.setInvMaterialTypes(invMaterialTypes);
	model.addAttribute("materialTypes", invMaterialTypes);
	model.addAttribute("materialform", invMaterialForm);
	model.addAttribute("ulbId", getSessionUser().getUlbId());
	return new ModelAndView(prefixURL + "/master-search-material",
			"command", model);

}

@RequestMapping(value = "/saveMastermaterial", params ="resetmaterialadd",method = RequestMethod.POST)
public ModelAndView resetMaterialAdd(Locale locale, ModelMap model, HttpServletRequest req) {
	int ulbId = getSessionUser().getUlbId();
	InvMaterialForm invMaterialForm= new InvMaterialForm();
	List<TmInvMaterialType> invMaterialTypes= masterMaterialTypServ.findMaterialTypesByUlb(ulbId);
	invMaterialForm.setInvMaterialTypes(invMaterialTypes);
	List<TmCmLookupDetHierarchical> cmLookupDetHierarchicalsBaseUom=materialServ.getBaseUom(ulbId);
	invMaterialForm.setBaseUoms(cmLookupDetHierarchicalsBaseUom);
	List<TmCmLookupDet> cmLookupDets=new ArrayList<TmCmLookupDet>();
	TmCmLookupDet cmLookupDet=null;
	for (TmCmLookupDetHierarchical tmCmLookupDetHierarchical : cmLookupDetHierarchicalsBaseUom) {
		cmLookupDet= tmCmLookupDetHierarchical.getTmCmLookupDet();
		cmLookupDets.add(cmLookupDet);
	}
	invMaterialForm.setInventoryTypes(cmLookupDets);
	invMaterialForm.setUsageList(cmLookupDets);
	invMaterialForm.setPurchaseUoms(cmLookupDetHierarchicalsBaseUom);
	invMaterialForm.setStockUoms(cmLookupDetHierarchicalsBaseUom);
	model.addAttribute("ulbId", ulbId);
	model.addAttribute("materialaddform", invMaterialForm);
	return new ModelAndView(prefixURL + "/master-add-material",
			"command", model);

}

@RequestMapping(value = "/saveMastermaterial",params="savematerialadd", method = RequestMethod.POST)
public String saveMaterialAdd(@ModelAttribute("materialaddform") InvMaterialForm materialForm, Locale locale,HttpSession session, 
		HttpServletRequest request,ModelMap model)
		{
	try{
		if(materialForm.getMaterialCode()==null && materialForm.getMaterialCode().isEmpty())
		{
			return addmaterial(locale,model,request);
		}
	String ipAddress = request.getHeader("X-FORWARDED-FOR");
	int ulbId = getSessionUser().getUlbId();
	TmUlb tmUlb= new TmUlb();
	tmUlb.setUlbId(ulbId);
	model.addAttribute("ulbId", ulbId);
	TmInvMaterial invMaterial= new TmInvMaterial();
	invMaterial.setTmUlb(tmUlb);
	String materialTypId=materialForm.getSelectedMaterialTyp();
	TmInvMaterialType invMaterialType=masterMaterialTypServ.getById(Long.parseLong(materialTypId));
	invMaterial.setTmInvMaterialType(invMaterialType);
	invMaterial.setMaterialCode(materialForm.getMaterialCode());
	invMaterial.setMaterialName(materialForm.getMaterialName());
	invMaterial.setMaterialDesc(materialForm.getMaterialDesc());
	String invType=materialForm.getSelectedInvType();
	TmCmLookupDet cmLookupDet=materialServ.getById(Integer.parseInt(invType));
	invMaterial.setTmCmLookupDetByLookupDetIdInvType(cmLookupDet);
	String selectedBaseUom=materialForm.getSelectedUmo();
	TmCmLookupDetHierarchical cmLookupDetHierarchicalForBase=materialServ.getBaseUom(ulbId, Integer.parseInt(selectedBaseUom));
	invMaterial.setTmCmLookupDetHierarchicalByLookupDetIdBaseUom(cmLookupDetHierarchicalForBase);
	String purchaseUom=materialForm.getSelectedPurchaseUom();
	TmCmLookupDetHierarchical cmLookupDetHierarchicalForPurchase=materialServ.getBaseUom(ulbId, Integer.parseInt(purchaseUom));
	invMaterial.setTmCmLookupDetHierarchicalByLookupDetIdPurchaseUom(cmLookupDetHierarchicalForPurchase);
	invMaterial.setExpenseAccountCode(Integer.parseInt(materialForm.getAccCode()));
	String usageId=materialForm.getSelectusage();
	TmCmLookupDet cmLookupDetForUsage=materialServ.getById(Integer.parseInt(usageId));
	invMaterial.setTmCmLookupDetByLookupDetIdUsageClass(cmLookupDetForUsage);
	String stockingUom=materialForm.getSelectedStockUom();
	TmCmLookupDetHierarchical cmLookupDetHierarchicalForStock=materialServ.getBaseUom(ulbId, Integer.parseInt(stockingUom));
	invMaterial.setTmCmLookupDetHierarchicalByLookupDetIdStockingUom(cmLookupDetHierarchicalForStock);
	invMaterial.setMinQty(new BigDecimal(materialForm.getMinQty()));
	invMaterial.setMaxQty(new BigDecimal(materialForm.getMaxQty()));
	invMaterial.setReorderLevel(new BigDecimal(materialForm.getReOrderlvl()));
	invMaterial.setReorderQty(new BigDecimal(materialForm.getReOrderQty()));
	if(materialForm.getSelfLifeControl().equalsIgnoreCase("y"))
	{
		invMaterial.setShelfLifControlYn('Y');
	}
	else
	{
		invMaterial.setShelfLifControlYn('N');
	}
	invMaterial.setRatePerUnit(new BigDecimal(materialForm.getRatePerUnit()));
	invMaterial.setStatus(Integer.parseInt(materialForm.getMaterialStatus()));
	invMaterial.setCreatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
	invMaterial.setIpAddress(ipAddress);
	materialServ.saveOrUpdate(invMaterial);
	model.put("message",messageSource.getMessage("lable.common.sucess.added", null, locale));
	model.put("msgtype","success");
	}
	catch(Exception e)
	{
		e.printStackTrace();
		model.put("message",messageSource.getMessage("lable.common.fail.add", null, locale));
		model.put("msgtype","error");
	}
	return addmaterial(locale,model,request);
	
		}
}