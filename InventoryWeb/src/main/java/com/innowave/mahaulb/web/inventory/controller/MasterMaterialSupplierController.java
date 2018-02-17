package com.innowave.mahaulb.web.inventory.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.common.dao.master.TmCmDepartment;
import com.innowave.mahaulb.common.service.beans.UserBean;
import com.innowave.mahaulb.portal.utils.DateTimeZoneHelper;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvSupplier;
import com.innowave.mahaulb.service.inventory.dto.master.InvMaterialSupplierDTO;
import com.innowave.mahaulb.service.inventory.dto.master.MaterialStoreForm;
import com.innowave.mahaulb.service.inventory.service.MasterMaterialSupplierServ;
import com.innowave.mahaulb.web.inventory.controller.forms.InvMaterialSupplierForm;


@Controller
@RequestMapping("/inventory")
public class MasterMaterialSupplierController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	MasterMaterialSupplierServ materilaSupplierTypes;
	

	@Autowired
	MasterMaterialSupplierServ masterMaterialSupplierServ;
	
	private final String prefixURL = "inventory/masters";
	
	public UserBean getSessionUser() {
		// Session session = sessionFactory.getCurrentSession();
		return (UserBean) httpSession.getAttribute("userBeanObj");
	}
	
	@RequestMapping(value = "/addsupplier", params ="closesupplier",method = RequestMethod.POST)
	public ModelAndView viewMaterialSupplier(Locale locale, ModelMap model) {
		int ulbId = getSessionUser().getUlbId();
		InvMaterialSupplierForm invMaterialSupplierForm= new InvMaterialSupplierForm();
		List<TmCmLookupDet> cmLookupDets=masterMaterialSupplierServ.getSupplierListByUlb(ulbId);
		invMaterialSupplierForm.setSuppliersTyp(cmLookupDets);
		model.addAttribute("suppliertyp", cmLookupDets);
		model.addAttribute("supplierform", invMaterialSupplierForm);
		model.addAttribute("ulbId", getSessionUser().getUlbId());
		return new ModelAndView(prefixURL + "/master-search-supplier",
				"command", model);
	}

	@RequestMapping(value = "/searchsupplier",params ="searchmaterialSupplier", method = RequestMethod.POST)
	public ModelAndView searchMaterialSupplier(@ModelAttribute("supplierform") InvMaterialSupplierForm invMaterialSupplierForm,Locale locale,HttpSession session,
			HttpServletRequest request,ModelMap model)
			{
		if(invMaterialSupplierForm.getSelectedSUpplier()=="0"|| invMaterialSupplierForm.getSelectedSUpplier().isEmpty()
				&&invMaterialSupplierForm.getSupplierCode()==null || invMaterialSupplierForm.getSupplierCode().isEmpty()
				){
			return viewMaterialSupplier(locale,model);
			// return new ModelAndView(prefixURL+"/master-search-supplier","command",model);
		}
		int ulbId = getSessionUser().getUlbId();
		model.addAttribute("ulbId", ulbId);
		String selectedLookupDept = request.getParameter("selectedSupplier");
		TmInvSupplier invSupplier= new TmInvSupplier();
		TmCmLookupDet cmLookupDet=materilaSupplierTypes.getLookUpById(Integer.parseInt(selectedLookupDept),Integer.valueOf(ulbId));
		invSupplier.setTmCmLookupDet(cmLookupDet);
		invSupplier.setSupplierCode(invMaterialSupplierForm.getSupplierCode());
		invSupplier.setSupplierName(invMaterialSupplierForm.getSupplierName());
		
		invSupplier.setSupplierParentCode(invMaterialSupplierForm.getParentSupplierCode());
		List<TmInvSupplier> suppliers=materilaSupplierTypes.supplierTypList(invSupplier);
		List<InvMaterialSupplierDTO> dtos= new ArrayList<InvMaterialSupplierDTO>();
		InvMaterialSupplierDTO dto=null;
		int count=0;
		for (TmInvSupplier tmInvSupplier : suppliers) {
			dto=new InvMaterialSupplierDTO();
			dto.setSerial(count+1);
			dto.setSupplierId(tmInvSupplier.getSupplierId());
			dto.setSupplierCode(tmInvSupplier.getSupplierCode());
			dto.setSupplierTyp(cmLookupDet.getLookupDetDescEn());
			dto.setSupplierName(tmInvSupplier.getSupplierName());
			if(tmInvSupplier.getTmInvSupplier()!=null)
			{
			dto.setParentSupplierCode(tmInvSupplier.getTmInvSupplier().getSupplierCode());
			}
			dtos.add(dto);
			
		}
		invMaterialSupplierForm.setSupplierlist(dtos);
		model.addAttribute("supplierlist", dtos);
		request.getSession().setAttribute("supplierform", invMaterialSupplierForm);
		model.addAttribute("ulbId", getSessionUser().getUlbId());
		return new ModelAndView(prefixURL + "/master-search-supplier",
				"command", model);
			}
	@RequestMapping(value = "/editmaterialSupplier", method = RequestMethod.GET)
	public ModelAndView editmaterialSupplier(@ModelAttribute("supplierform") InvMaterialSupplierForm invMaterialSupplierForm,Locale locale,HttpSession session, 
			HttpServletRequest request,ModelMap model)
			{
		int ulbId = getSessionUser().getUlbId();
		model.addAttribute("ulbId", ulbId);
		Long materialSupplierId = Long.parseLong(request.getParameter("supplierId"));
		if(invMaterialSupplierForm==null)
		{
			invMaterialSupplierForm= new InvMaterialSupplierForm();
		}
		TmInvSupplier invSupplier=materilaSupplierTypes.getSUpplierById(ulbId, materialSupplierId);
		List<TmCmLookupDet> cmLookupDets=materilaSupplierTypes.getSupplierListByUlb(ulbId);
		invMaterialSupplierForm.setSuppliersTyp(cmLookupDets);
		model.addAttribute("suppliertyp", cmLookupDets);
		invMaterialSupplierForm.setSelectedSupplier(invSupplier.getTmCmLookupDet().getLookupDetDescEn());
		invMaterialSupplierForm.setSupplierCode(invSupplier.getSupplierCode());
		invMaterialSupplierForm.setSupplierName(invSupplier.getSupplierName());
		if(invSupplier.getTmInvSupplier()!=null)
		{
		invMaterialSupplierForm.setParentSupplierCode(invSupplier.getTmInvSupplier().getSupplierCode());
		}
		model.addAttribute("addForm", invMaterialSupplierForm);
		model.addAttribute("ulbId", getSessionUser().getUlbId());
		model.addAttribute("edit", true);
		return new ModelAndView(prefixURL + "/master-add-supplier",
				"command", model);
			}
	
	@RequestMapping(value = "/deletematerialSupplier", method = RequestMethod.GET)
	public ModelAndView deletematerialSupplier(@ModelAttribute("supplierform") InvMaterialSupplierForm invMaterialSupplierForm,Locale locale,HttpSession session, 
			HttpServletRequest request,ModelMap model)
			{
		
		try{
		int ulbId = getSessionUser().getUlbId();
		model.addAttribute("ulbId", ulbId);
		Long materialSupplierId = Long.parseLong(request.getParameter("supplierId"));
		TmInvSupplier invSupplier= new TmInvSupplier();
		invSupplier.setSupplierId(materialSupplierId);
		int rem= materilaSupplierTypes.removeStoreByID(invSupplier);
		TmCmLookupDet cmLookupDet=materilaSupplierTypes.getLookUpById(materialSupplierId.intValue(),Integer.valueOf(ulbId));
		invSupplier.setTmCmLookupDet(cmLookupDet);
		invSupplier.setSupplierCode(invMaterialSupplierForm.getSupplierCode());
		invSupplier.setSupplierName(invMaterialSupplierForm.getSupplierName());
		invSupplier.setSupplierParentCode(invMaterialSupplierForm.getParentSupplierCode());
		List<TmInvSupplier> suppliers=materilaSupplierTypes.supplierTypList(invSupplier);
		List<InvMaterialSupplierDTO> dtos= new ArrayList<InvMaterialSupplierDTO>();
		InvMaterialSupplierDTO dto=null;
		int count=0;
		for (TmInvSupplier tmInvSupplier : suppliers) {
			dto=new InvMaterialSupplierDTO();
			dto.setSerial(count+1);
			dto.setSupplierId(tmInvSupplier.getSupplierId());
			dto.setSupplierCode(tmInvSupplier.getSupplierCode());
			dto.setSupplierTyp(cmLookupDet.getLookupDetDescEn());
			dto.setSupplierName(tmInvSupplier.getSupplierName());
			if(tmInvSupplier.getTmInvSupplier()!=null)
			{
			dto.setParentSupplierCode(tmInvSupplier.getTmInvSupplier().getSupplierCode());
			}
			dtos.add(dto);
			
		}
		model.addAttribute("supplierlist", dtos);
		request.getSession().setAttribute("supplierform", invMaterialSupplierForm);
		model.addAttribute("ulbId", getSessionUser().getUlbId());
		model.put("message",messageSource.getMessage("lable.common.sucess.deleted", null, locale));
		model.put("msgtype","success");
		return new ModelAndView(prefixURL + "/master-search-supplier",
				"command", model);
		}catch(Exception e)
		{
			e.printStackTrace();
 			model.put("message",messageSource.getMessage("lable.common.fail.delete", null, locale));
			model.put("msgtype","error");
		}
		return null;
			}
	
	@RequestMapping(value = "/searchsupplier", params ="resetSupplier",method = RequestMethod.POST)
	public ModelAndView resetMaterialSupplier(Locale locale, ModelMap model, HttpServletRequest req) {
		int ulbId = getSessionUser().getUlbId();
		InvMaterialSupplierForm invMaterialSupplierForm= new InvMaterialSupplierForm();
		List<TmCmLookupDet> cmLookupDets=materilaSupplierTypes.getSupplierListByUlb(ulbId);
		invMaterialSupplierForm.setSuppliersTyp(cmLookupDets);
		model.addAttribute("suppliertyp", cmLookupDets);
		model.addAttribute("supplierform", invMaterialSupplierForm);
		model.addAttribute("ulbId", getSessionUser().getUlbId());
		return new ModelAndView(prefixURL + "/master-search-supplier",
				"command", model);
	}
	
	@RequestMapping(value = "/addsupplier", params="resetsupplier",method = RequestMethod.POST)
	public ModelAndView resetSupplierAdd(Locale locale, ModelMap model, HttpServletRequest req) {
		int ulbId = getSessionUser().getUlbId();
		InvMaterialSupplierForm invMaterialSupplierForm= new InvMaterialSupplierForm();
		List<TmCmLookupDet> cmLookupDets=materilaSupplierTypes.getSupplierListByUlb(ulbId);
		invMaterialSupplierForm.setSuppliersTyp(cmLookupDets);
		model.addAttribute("suppliertyp", cmLookupDets);
		model.addAttribute("addForm", invMaterialSupplierForm);
		model.addAttribute("ulbId", getSessionUser().getUlbId());
		return new ModelAndView(prefixURL + "/master-add-supplier",
				"command", model);
	}
	
	@RequestMapping(value = "/searchsupplier", params ="addsupplierdetails",method = RequestMethod.POST)
	public ModelAndView addMaterialSupplier(Locale locale, ModelMap model, HttpServletRequest req) {
		int ulbId = getSessionUser().getUlbId();
		InvMaterialSupplierForm invMaterialSupplierForm= new InvMaterialSupplierForm();
		List<TmCmLookupDet> cmLookupDets=materilaSupplierTypes.getSupplierListByUlb(ulbId);
		invMaterialSupplierForm.setSuppliersTyp(cmLookupDets);
		model.addAttribute("suppliertyp", cmLookupDets);
		model.addAttribute("addForm", invMaterialSupplierForm);
		model.addAttribute("ulbId", getSessionUser().getUlbId());
		return new ModelAndView(prefixURL + "/master-add-supplier",
				"command", model);
	}
	
	@RequestMapping(value = "/addsupplier",params="savematerialsupplierDetails", method = RequestMethod.POST)
	public ModelAndView savematerialSupplier(@ModelAttribute("addForm") InvMaterialSupplierForm invMaterialSupplierForm,Locale locale,HttpSession session,
			HttpServletRequest request,ModelMap model)
			{
		try{
			if(invMaterialSupplierForm.getSupplierCode()==null || invMaterialSupplierForm.getSupplierCode().isEmpty() &&
					invMaterialSupplierForm.getSelectedSupplier()==null ||	invMaterialSupplierForm.getSelectedSupplier().isEmpty() &&
					invMaterialSupplierForm.getSupplierName()==null ||invMaterialSupplierForm.getSupplierName().isEmpty())
			{
				return addMaterialSupplier(locale,model,request);
			}
			String ipAddress = request.getHeader("X-FORWARDED-FOR");
			int ulbId = getSessionUser().getUlbId();
			model.addAttribute("ulbId", ulbId);
			TmUlb tmUlb= new TmUlb();
			tmUlb.setUlbId(ulbId);
			String selectedLookupDept = request.getParameter("selectedSupplier");
		//	String selectedParentCode= request.getParameter("parentSupplierCode");
			TmInvSupplier invSupplier= new TmInvSupplier();
			TmCmLookupDet cmLookupDet=materilaSupplierTypes.getLookUpById(Integer.parseInt(selectedLookupDept),Integer.valueOf(ulbId));
			invSupplier.setTmCmLookupDet(cmLookupDet);
			invSupplier.setSupplierCode(invMaterialSupplierForm.getSupplierCode());
			invSupplier.setSupplierName(invMaterialSupplierForm.getSupplierName());
			invSupplier.setSupplierParentCode(invMaterialSupplierForm.getParentSupplierCode());
			invSupplier.setSupplierAdderss(invMaterialSupplierForm.getSupplierAddress());
			invSupplier.setContactPersonName(invMaterialSupplierForm.getContactPerson());
			invSupplier.setContactNo(invMaterialSupplierForm.getContactNumber());
			invSupplier.setEmailId(invMaterialSupplierForm.getEmail());
			invSupplier.setWebsite(invMaterialSupplierForm.getWebsite());
			invSupplier.setTinNo(invMaterialSupplierForm.getTinNo());
			invSupplier.setPanNo(invMaterialSupplierForm.getPanNo());
			invSupplier.setCstNo(invMaterialSupplierForm.getCstNo());
			invSupplier.setGstNo(invMaterialSupplierForm.getGstNo());
			invSupplier.setVatNo(invMaterialSupplierForm.getUatNo());
			invSupplier.setBankName(invMaterialSupplierForm.getBankName());
			invSupplier.setBankIfscCode(invMaterialSupplierForm.getIfsc());
			invSupplier.setBankAccountNo(invMaterialSupplierForm.getBankAcc());
			invSupplier.setCreatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
			invSupplier.setIpAddress(ipAddress);
			invSupplier.setTtInvMrns(null);
			invSupplier.setTtInvRateContracts(null);
			invSupplier.setTmInvSuppliers(null);
			invSupplier.setTmUlb(tmUlb);
			TmInvSupplier parentSupplier=null;
			if(invMaterialSupplierForm.getParentSupplierCode()!=null && !invMaterialSupplierForm.getParentSupplierCode().isEmpty())
			{
			parentSupplier= new TmInvSupplier();
			parentSupplier.setSupplierCode(invMaterialSupplierForm.getParentSupplierCode());
			parentSupplier=materilaSupplierTypes.getSupplierByCode(parentSupplier);
			parentSupplier.setTmUlb(tmUlb);
			invSupplier.setTmInvSupplier(parentSupplier);
			}
			materilaSupplierTypes.saveOrUpdate(invSupplier);
			model.put("message",messageSource.getMessage("lable.common.sucess.added", null, locale));
			model.put("msgtype","success");
			return addMaterialSupplier(locale,model,request);
		}catch(Exception e)
		{
			e.printStackTrace();
 			model.put("message",messageSource.getMessage("lable.common.fail.add", null, locale));
			model.put("msgtype","error");
			
		}
		return null;
			}
	
}

