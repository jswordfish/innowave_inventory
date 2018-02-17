package com.innowave.mahaulb.web.inventory.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.common.service.beans.UserBean;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvSupplier;
import com.innowave.mahaulb.repository.inventory.dao.trans.TtInvRateContract;
import com.innowave.mahaulb.repository.inventory.repo.TtInvRateContractRepo;
import com.innowave.mahaulb.service.inventory.service.InventoryPriceService;
import com.innowave.mahaulb.service.inventory.service.UtilService;
import com.innowave.mahaulb.web.inventory.controller.forms.InventoryPriceMasterDTO;

@Controller
@RequestMapping("/inventory")
public class InventoryPriceMasterController {
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private HttpSession httpSession;

	
	@Autowired
	HttpSession httpsession;



	private final String prefixURL = "inventory/masters";
	
	@Autowired
	UtilService utilService;
	
//	@Autowired
//	TtInvRateContractRepo contractRepo;
	@Autowired
	InventoryPriceService priceService;
	
	public UserBean getSessionUser() {

		return (UserBean) httpsession.getAttribute("userBeanObj");
	}
	
	
	@RequestMapping(value = "/viewpricemaster", method = RequestMethod.GET)
	public String viewMaterialMapping(Locale locale, ModelMap model,
			HttpServletRequest req) {
		int ulbId = getSessionUser().getUlbId();
		model.addAttribute("ulbId", ulbId);

		InventoryPriceMasterDTO inventoryPriceMasterDTO = new InventoryPriceMasterDTO();
		List<TmInvSupplier> suppliers = utilService.getSuppliersBy(ulbId);
		
		List<TmCmLookupDet> rateTypes = utilService.getByULBId(ulbId);
		
		model.addAttribute("suppliers", suppliers);
		model.addAttribute("rateTypes", rateTypes);
		model.addAttribute("inventoryPriceMasterDTO", inventoryPriceMasterDTO);
		
		req.getSession().setAttribute("inventoryPriceMasterDTO", inventoryPriceMasterDTO);

		return prefixURL + "/master-search-price-list";
	}
	
	@RequestMapping(value = "/searchpricemaster", method = RequestMethod.POST)
	public String searchpricemaster(@ModelAttribute("inventoryPriceMasterDTO") InventoryPriceMasterDTO inventoryPriceMasterDTO,Locale locale, ModelMap model,
			HttpServletRequest req) {
		int ulbId = getSessionUser().getUlbId();
		model.addAttribute("ulbId", ulbId);

		//InventoryPriceMasterDTO inventoryPriceMasterDTO = (InventoryPriceMasterDTO) req.getSession().getAttribute("inventoryPriceMasterDTO");
		try {
			String supplierId = req.getParameter("supplierId");
			String rateTypeId = req.getParameter("rateTypeId");
			String aStartDate = req.getParameter("aStartDate");
			String aEndDate = req.getParameter("aEndDate");
				if(supplierId == null) {
					supplierId = inventoryPriceMasterDTO.getSupplierId();
				}
			Date aS = convertDate(aStartDate);
			Date aE = convertDate(aEndDate);
			inventoryPriceMasterDTO.setAgreementEndDate(aE);
			inventoryPriceMasterDTO.setAgreementStartDate(aS);
			inventoryPriceMasterDTO.setSupplierId(supplierId);
			inventoryPriceMasterDTO.setRateTypeId(rateTypeId);
			List<TtInvRateContract> prices = priceService.fetchBy(Long.parseLong(inventoryPriceMasterDTO.getSupplierId()), Long.parseLong(inventoryPriceMasterDTO.getRateTypeId()), inventoryPriceMasterDTO.getAgreementStartDate(), inventoryPriceMasterDTO.getAgreementEndDate());
			inventoryPriceMasterDTO.setRates(prices);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return viewMaterialMapping(locale, model, req);
		}
		
		List<TmInvSupplier> suppliers = utilService.getSuppliersBy(ulbId);
		
		List<TmCmLookupDet> rateTypes = utilService.getByULBId(ulbId);
		
		model.addAttribute("suppliers", suppliers);
		model.addAttribute("rateTypes", rateTypes);
		model.addAttribute("inventoryPriceMasterDTO", inventoryPriceMasterDTO);
		
		req.getSession().setAttribute("inventoryPriceMasterDTO", inventoryPriceMasterDTO);

		return prefixURL + "/master-search-price-list";
	}
	
	//resetpricemaster
	@RequestMapping(value = "/searchpricemaster", method = RequestMethod.POST, params="resetpricemaster")
	public String resetpricemaster(Locale locale, ModelMap model,
			HttpServletRequest req) {
		return viewMaterialMapping(locale, model, req);
	}
	
	private Date convertDate(String date) {
		try {
			String format = "yyyy-MM-dd";
			DateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	private String convertDateToString(Date date) {
		String format = "yyyy-MM-dd";
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
		//opbalRepo.
	}
	
	//master-add-price-list
	@RequestMapping(value = "/searchpricemaster", method = RequestMethod.POST, params="addpricemaster")
	public String addpricemaster( Locale locale, ModelMap model,
			HttpServletRequest req) {
		try {
			int ulbId = getSessionUser().getUlbId();
			model.addAttribute("ulbId", ulbId);
			String supplierId = req.getParameter("supplierId");
			String rateTypeId = req.getParameter("rateTypeId");
			String aStartDate = req.getParameter("aStartDate");
			String aEndDate = req.getParameter("aEndDate");
			InventoryPriceMasterDTO inventoryPriceMasterDTO = (InventoryPriceMasterDTO) req.getSession().getAttribute("inventoryPriceMasterDTO");
				Date aS = convertDate(aStartDate);
				Date aE = convertDate(aEndDate);
				inventoryPriceMasterDTO.setAgreementEndDate(aE);
				inventoryPriceMasterDTO.setAgreementStartDate(aS);
				inventoryPriceMasterDTO.setSupplierId(supplierId);
				inventoryPriceMasterDTO.setRateTypeId(rateTypeId);
				if(inventoryPriceMasterDTO.getRateTypeId() == null || inventoryPriceMasterDTO.getAgreementEndDate() == null || inventoryPriceMasterDTO.getAgreementStartDate() == null || inventoryPriceMasterDTO.getSupplierId() == null) {
					return resetpricemaster(locale, model, req);
				}
			inventoryPriceMasterDTO.setCurrent(new TtInvRateContract());
			inventoryPriceMasterDTO.getCurrent().setRateContractId(-1);//distinguishes this to be a new-persist object type.
			inventoryPriceMasterDTO.getCurrent().setAgreementStartDate(inventoryPriceMasterDTO.getAgreementStartDate());
			inventoryPriceMasterDTO.getCurrent().setAgreementEndDate(inventoryPriceMasterDTO.getAgreementEndDate());
			
			inventoryPriceMasterDTO.setAgreementStartDateSearchScreen(inventoryPriceMasterDTO.getAgreementStartDate());
			inventoryPriceMasterDTO.setAgreementEndDateSearchScreen(inventoryPriceMasterDTO.getAgreementEndDate());
			
			TmCmLookupDet det = utilService.resolveById(Integer.parseInt(inventoryPriceMasterDTO.getRateTypeId()));
			inventoryPriceMasterDTO.setRateType(det.getLookupDetDescEn());
			
			TmInvSupplier supp = utilService.resolveById(Long.parseLong(inventoryPriceMasterDTO.getSupplierId()));
			inventoryPriceMasterDTO.setSupplierName(supp.getSupplierName());
			model.addAttribute("inventoryPriceMasterDTO", inventoryPriceMasterDTO);
			req.getSession().setAttribute("inventoryPriceMasterDTO", inventoryPriceMasterDTO);
			req.setAttribute("supplierId", inventoryPriceMasterDTO.getSupplierId());
			req.setAttribute("rateTypeId", inventoryPriceMasterDTO.getRateTypeId());
			
			return prefixURL + "/master-add-price-list";
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return resetpricemaster(locale, model, req);
		}
	}
	
	//editRate
	@RequestMapping(value = "/editRate", method = RequestMethod.GET)
	public String editRate( Locale locale, ModelMap model,
			HttpServletRequest req) {
		int ulbId = getSessionUser().getUlbId();
		model.addAttribute("ulbId", ulbId);
		InventoryPriceMasterDTO inventoryPriceMasterDTO = (InventoryPriceMasterDTO) req.getSession().getAttribute("inventoryPriceMasterDTO");
		String rateId = req.getParameter("rateId");
		TtInvRateContract current = priceService.getById(Long.parseLong(rateId));
		
		inventoryPriceMasterDTO.setAgreementStartDateSearchScreen(inventoryPriceMasterDTO.getAgreementStartDate());
		inventoryPriceMasterDTO.setAgreementEndDateSearchScreen(inventoryPriceMasterDTO.getAgreementEndDate());
		
		inventoryPriceMasterDTO.setCurrent(current);
		inventoryPriceMasterDTO.setSupplierId(""+current.getTmInvSupplier().getSupplierId());
		inventoryPriceMasterDTO.setSupplierName(current.getTmInvSupplier().getSupplierName());
		inventoryPriceMasterDTO.setRateType(current.getTmCmLookupDet().getLookupDetDescEn());
		inventoryPriceMasterDTO.setRateTypeId(""+current.getTmCmLookupDet().getLookupDetId());
		inventoryPriceMasterDTO.setAgreementStartDate(current.getAgreementStartDate());
		inventoryPriceMasterDTO.setAgreementEndDate(current.getAgreementEndDate());
		inventoryPriceMasterDTO.setAgreementNo(current.getAgreementNo());
		inventoryPriceMasterDTO.setRateContractQuotNo(current.getRateContractQuotNo());
		req.getSession().setAttribute("inventoryPriceMasterDTO", inventoryPriceMasterDTO);
		model.addAttribute("inventoryPriceMasterDTO", inventoryPriceMasterDTO);
		return prefixURL + "/master-add-price-list";
	}
	
	
	//addpricemaster
	//master-add-price-list
		@RequestMapping(value = "/savePrice", method = RequestMethod.POST)
		public String savePrice( Locale locale, ModelMap model,
				HttpServletRequest req) {
			int ulbId = getSessionUser().getUlbId();
			model.addAttribute("ulbId", ulbId);
			InventoryPriceMasterDTO inventoryPriceMasterDTO = (InventoryPriceMasterDTO) req.getSession().getAttribute("inventoryPriceMasterDTO");
			String supplierId = inventoryPriceMasterDTO.getSupplierId();
			String rateTypeId = inventoryPriceMasterDTO.getRateTypeId();
			TtInvRateContract contract = inventoryPriceMasterDTO.getCurrent();
			String rateContractDate = req.getParameter("rateContractDate");
			String agreementDate = req.getParameter("agreementDate");
			String agreementStartDate = req.getParameter("agreementStartDate");
			String agreementEndDate = req.getParameter("agreementEndDate");
				if(agreementStartDate == null) {
					agreementStartDate = convertDateToString(inventoryPriceMasterDTO.getAgreementStartDate());
				}
				
				if(agreementEndDate == null) {
					agreementEndDate = convertDateToString(inventoryPriceMasterDTO.getAgreementEndDate());
				}
				inventoryPriceMasterDTO.setAgreementStartDate(convertDate(agreementStartDate));
				inventoryPriceMasterDTO.setAgreementEndDate(convertDate(agreementEndDate));
			String suppName =  req.getParameter("supplierName");
			String rateType=req.getParameter("rateType");
			String rateContractQuotNo = req.getParameter("rateContractQuotNo");
			String agreementNo = req.getParameter("agreementNo");
			TmInvSupplier s = new TmInvSupplier();
			s.setSupplierId(Long.parseLong(supplierId));
			contract.setTmInvSupplier(s);
			TmCmLookupDet det = new TmCmLookupDet(Integer.parseInt(rateTypeId));
			contract.setTmCmLookupDet(det);
			contract.setRateContractQuotNo(rateContractQuotNo);
			contract.setAgreementNo(agreementNo);
			
			contract.setRateContractQuotDate(convertDate(rateContractDate));
			contract.setAgreementDate(convertDate(agreementDate));
			contract.setAgreementStartDate(convertDate(agreementStartDate));
			contract.setAgreementEndDate(convertDate(agreementEndDate));
			contract.setStatus(1);//the jsp page had no display for it.

			contract.setTmUlb(new TmUlb(ulbId));

			priceService.saveOrUpdate(contract);
			
			inventoryPriceMasterDTO.setAgreementStartDate(inventoryPriceMasterDTO.getAgreementStartDateSearchScreen());
			inventoryPriceMasterDTO.setAgreementEndDate(inventoryPriceMasterDTO.getAgreementEndDateSearchScreen());
			
			model.addAttribute("inventoryPriceMasterDTO", inventoryPriceMasterDTO);
			List<TmInvSupplier> suppliers = utilService.getSuppliersBy(ulbId);
			
			List<TmCmLookupDet> rateTypes = utilService.getByULBId(ulbId);
			
			model.addAttribute("suppliers", suppliers);
			model.addAttribute("rateTypes", rateTypes);
		
			List<TtInvRateContract> prices = priceService.fetchBy(Long.parseLong(inventoryPriceMasterDTO.getSupplierId()), Long.parseLong(inventoryPriceMasterDTO.getRateTypeId()), inventoryPriceMasterDTO.getAgreementStartDate(), inventoryPriceMasterDTO.getAgreementEndDate());
			inventoryPriceMasterDTO.setRates(prices);
			req.getSession().setAttribute("inventoryPriceMasterDTO", inventoryPriceMasterDTO);

			return prefixURL + "/master-search-price-list";
		}
		
		@RequestMapping(value = "/savePrice", method = RequestMethod.POST, params="closePrice")
		public String closePrice( Locale locale, ModelMap model,
				HttpServletRequest req) {
			int ulbId = getSessionUser().getUlbId();
			model.addAttribute("ulbId", ulbId);
			InventoryPriceMasterDTO inventoryPriceMasterDTO = (InventoryPriceMasterDTO) req.getSession().getAttribute("inventoryPriceMasterDTO");
			model.addAttribute("inventoryPriceMasterDTO", inventoryPriceMasterDTO);
			List<TmInvSupplier> suppliers = utilService.getSuppliersBy(ulbId);
			
			List<TmCmLookupDet> rateTypes = utilService.getByULBId(ulbId);
			
			model.addAttribute("suppliers", suppliers);
			model.addAttribute("rateTypes", rateTypes);
		
			
			req.getSession().setAttribute("inventoryPriceMasterDTO", inventoryPriceMasterDTO);

			return prefixURL + "/master-search-price-list";
		}
		
		@RequestMapping(value = "/deleteRate", method = RequestMethod.GET)
		public String delete(Locale locale, ModelMap model,
				HttpServletRequest req) {
			int ulbId = getSessionUser().getUlbId();
			model.addAttribute("ulbId", ulbId);
			InventoryPriceMasterDTO inventoryPriceMasterDTO = (InventoryPriceMasterDTO) req.getSession().getAttribute("inventoryPriceMasterDTO");
			String rateId = req.getParameter("rateId");
			priceService.removeTtInvRateContract(Long.parseLong(rateId));
			
			List<TtInvRateContract> prices = priceService.fetchBy(Long.parseLong(inventoryPriceMasterDTO.getSupplierId()), Long.parseLong(inventoryPriceMasterDTO.getRateTypeId()), inventoryPriceMasterDTO.getAgreementStartDate(), inventoryPriceMasterDTO.getAgreementEndDate());
			inventoryPriceMasterDTO.setRates(prices);
			req.getSession().setAttribute("inventoryPriceMasterDTO", inventoryPriceMasterDTO);
			model.addAttribute("inventoryPriceMasterDTO", inventoryPriceMasterDTO);

			return prefixURL + "/master-search-price-list";
		}
	
}
