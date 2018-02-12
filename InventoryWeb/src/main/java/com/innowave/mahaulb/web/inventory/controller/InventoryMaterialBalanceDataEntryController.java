package com.innowave.mahaulb.web.inventory.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibm.icu.math.BigDecimal;
import com.innowave.mahaulb.common.dao.TmCmFinancialMas;
import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.common.service.beans.UserBean;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterial;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;
import com.innowave.mahaulb.repository.inventory.dao.trans.TtInvMaterialOpbal;
import com.innowave.mahaulb.repository.inventory.repo.MaterialTypeStoreMappingRepository;
import com.innowave.mahaulb.repository.inventory.repo.TtInvMaterialOpbalRepo;
import com.innowave.mahaulb.web.inventory.controller.forms.InventoryMaterialOpBalForm;
import com.innowave.mahaulb.web.inventory.controller.forms.TtInvMaterialOpbalWrapper;

@Controller
@RequestMapping("/inventory/dataentry")
public class InventoryMaterialBalanceDataEntryController {
	
	private final String prefixURL = "inventory/dataentry";
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	MaterialTypeStoreMappingRepository mappingRepository;
	
	@Autowired
	TtInvMaterialOpbalRepo opbalRepo;
	
	public UserBean getSessionUser() {
		// Session session = sessionFactory.getCurrentSession();
		return (UserBean) httpSession.getAttribute("userBeanObj");
	}
	
	
	@RequestMapping(value = "/viewmaterialopeningbalance", method = RequestMethod.GET)
    public String viewmaterialopeningbalance(Locale locale,ModelMap model,HttpServletRequest req){
		int ulbId=getSessionUser().getUlbId();	
		List<TmInvStore> stores = mappingRepository.getAllStores(ulbId);
		//List<TmInvMaterial> materials = opbalRepo.getMaterialsByULB(ulbId);
		List<TmInvMaterial> materials = opbalRepo.getMaterialsByULB(ulbId);
		
		model.addAttribute("stores", stores);
		model.addAttribute("materials", materials);
		InventoryMaterialOpBalForm form = null;
			if(model.get("balForm") == null) {
				form = new InventoryMaterialOpBalForm();
			}
			else {
				form = (InventoryMaterialOpBalForm) model.get("balForm");
			}
		model.addAttribute("balForm", form);
		req.getSession().setAttribute("balForm", form);
	    return prefixURL + "/dataentry-materialopeningbalance-search";
    }
	
	@RequestMapping(value = "/fetchmaterials", method = RequestMethod.GET)
    public String fetchmaterials(Locale locale,ModelMap model,HttpServletRequest req){
		int ulbId=getSessionUser().getUlbId();	
		model.addAttribute("ulbId", ulbId);
		String store = req.getParameter("storeId");
		long storeId = Long.parseLong(store);
		List<TmInvStore> stores = mappingRepository.getAllStores(ulbId);
		List<TmInvMaterial> materials = opbalRepo.getMaterialsByULB(ulbId);
		model.addAttribute("stores", stores);
		model.addAttribute("materials", materials);
		InventoryMaterialOpBalForm form = (InventoryMaterialOpBalForm) model.get("balForm");
		model.addAttribute("balForm", form);
		return prefixURL + "/dataentry-materialopeningbalance-search";
	}
	
	@RequestMapping(value = "/fetchopeningbalances", method = RequestMethod.GET, params = "fetchopeningbalances")
    public String fetchopeningbalances(Locale locale,ModelMap model,HttpServletRequest req){
		int ulbId=getSessionUser().getUlbId();	
		model.addAttribute("ulbId", ulbId);
		String store = req.getParameter("storeId");
		String material = req.getParameter("materialId");
		InventoryMaterialOpBalForm form = new InventoryMaterialOpBalForm();
		req.getSession().setAttribute("balForm", form);
		try {
			long storeId = Long.parseLong(store);
			long materialId = Long.parseLong(material);
			
			List<TtInvMaterialOpbal> balances = opbalRepo.getTtInvMaterialOpbalForMaterialAndStore(materialId, storeId);
			int count = 1;
			List<TtInvMaterialOpbalWrapper> wrappers = new ArrayList<TtInvMaterialOpbalWrapper>();
			for(TtInvMaterialOpbal bal : balances) {
				TtInvMaterialOpbalWrapper wrapper = new TtInvMaterialOpbalWrapper();
				wrapper.setSerial(count);
				wrapper.setMaterialOpbal(bal);
				wrappers.add(wrapper);
				count++;
			}
			form.setBalances(wrappers);
			form.setStoreId(storeId);
			form.setMaterialId(materialId);
			List<TmInvStore> stores = mappingRepository.getAllStores(ulbId);
			List<TmInvMaterial> materials = opbalRepo.getMaterialsByULB(ulbId);
			model.addAttribute("stores", stores);
			model.addAttribute("materials", materials);
			model.addAttribute("balForm", form);
			model.addAttribute("balances", wrappers);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return viewmaterialopeningbalance(locale, model, req);
		}
		
		
	
	    return prefixURL+"/dataentry-materialopeningbalance-search";
    }
	
	@RequestMapping(value = "/fetchopeningbalances", method = RequestMethod.GET, params = "resetopeningbalances")
    public String resetmaterialmapping(Locale locale,ModelMap model,HttpServletRequest req){
		int ulbId=getSessionUser().getUlbId();	
		List<TmInvStore> stores = mappingRepository.getAllStores(ulbId);
		List<TmInvMaterial> materials = opbalRepo.getMaterialsByULB(ulbId);
		
		model.addAttribute("stores", stores);
		model.addAttribute("materials", materials);
		InventoryMaterialOpBalForm form = new InventoryMaterialOpBalForm();
			
		model.addAttribute("balForm", form);
	    return prefixURL + "/dataentry-materialopeningbalance-search";
    }
	
	@RequestMapping(value = "/fetchopeningbalances", method = RequestMethod.GET, params = "addopeningbalance")
    public String addopeningbalance(Locale locale,ModelMap model,HttpServletRequest req){
		int ulbId=getSessionUser().getUlbId();	
		String store = req.getParameter("storeId");
		String material = req.getParameter("materialId");
		//String asondateopening = req.getParameter("asondateopening");
		
		
		InventoryMaterialOpBalForm form;
		try {
			form = (InventoryMaterialOpBalForm) req.getSession().getAttribute("balForm");
			TmInvStore store2 = mappingRepository.getStoreById(Long.parseLong(store));
			form.setCurrent(new TtInvMaterialOpbal());
			form.getCurrent().setStoreCode(store2.getStoreCode());
			form.getCurrent().setStoreName(store2.getStoreName());
			form.getCurrent().setTmInvStore(store2);
			TmInvMaterial material2 = opbalRepo.resolveMaterial(Long.parseLong(material));
			form.getCurrent().setTmInvMaterial(material2);
			form.getCurrent().setMaterialName(material2.getMaterialName());
			//form.getCurrent().setOpenQtyAsondate(convertDate(asondateopening));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return viewmaterialopeningbalance(locale,model,req );
		}
		
		
		List<TmCmFinancialMas> fins = opbalRepo.getTmCmFinancialMas();
	//	form.getCurrent().set
		
		req.getSession().setAttribute("balForm", form);
		model.addAttribute("balForm", form);
		model.addAttribute("fins", fins);
		
	    return prefixURL + "/dataentry-materialopeningbalance-add";
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
	
	@RequestMapping(value = "/savebalform", method = RequestMethod.POST)
	public String savebalform(Locale locale,ModelMap model,HttpServletRequest req) {
		int ulbId=getSessionUser().getUlbId();	
		String asondateopening = req.getParameter("asondateopening");
		String exprydate1 = req.getParameter("exprydate1");
		//String 
		
		
		InventoryMaterialOpBalForm form = (InventoryMaterialOpBalForm) req.getSession().getAttribute("balForm");
		TtInvMaterialOpbal invMaterialOpbal =  form.getCurrent();
		invMaterialOpbal.setOpenQtyAsondate(convertDate(asondateopening));
		invMaterialOpbal.setExpiryDate(convertDate(exprydate1));
		TmCmFinancialMas financialMas = null;
		
		String finyear = req.getParameter("finyear");
			if(finyear != null) {
				Integer finid = Integer.parseInt(finyear);
				financialMas = opbalRepo.resolveTmCmFinancialMas(finid);
				invMaterialOpbal.setTmCmFinancialMas(financialMas);
			}
		
		
//		if(req.getParameter("edit")!= null && req.getParameter("edit").equals("true")) {
//			financialMas = invMaterialOpbal.getTmCmFinancialMas();
//		}
//		else {
//			String finyear = req.getParameter("finyear");
//			Integer finid = Integer.parseInt(finyear);
//			financialMas = opbalRepo.resolveTmCmFinancialMas(finid);
//		}
		
		String oQ = req.getParameter("current.openQty");
		java.math.BigDecimal openQty = new java.math.BigDecimal(oQ);
		
		String lt = req.getParameter("current.lotNo");
		long lot = Long.parseLong(lt);
		
		String oR = req.getParameter("current.openRate");
		java.math.BigDecimal openRate = new java.math.BigDecimal(oR);
		invMaterialOpbal.setOpenQty(openQty);
		invMaterialOpbal.setOpenRate(openRate);
		invMaterialOpbal.setLotNo(lot);
		//invMaterialOpbal.set
		
		
		invMaterialOpbal.setTmUlb(new TmUlb(ulbId));
		opbalRepo.saveOrUpdate(invMaterialOpbal);
		
		form.setStoreId(invMaterialOpbal.getTmInvStore().getStoreId());
		form.setMaterialId(invMaterialOpbal.getTmInvMaterial().getMaterialId());
		model.addAttribute("balForm", form);
		
		List<TmInvStore> stores = mappingRepository.getAllStores(ulbId);
		List<TmInvMaterial> materials = opbalRepo.getMaterialsByULB(ulbId);
		model.addAttribute("stores", stores);
		model.addAttribute("materials", materials);
		List<TtInvMaterialOpbal> bals = opbalRepo.getTtInvMaterialOpbalForMaterialAndStore(form.getMaterialId(), form.getStoreId());
		int count = 1;
		List<TtInvMaterialOpbalWrapper> wrappers = new ArrayList<TtInvMaterialOpbalWrapper>();
		for(TtInvMaterialOpbal bal : bals) {
			TtInvMaterialOpbalWrapper wrapper = new TtInvMaterialOpbalWrapper();
			wrapper.setSerial(count);
			wrapper.setMaterialOpbal(bal);
			wrappers.add(wrapper);
			count++;
		}
		form.setBalances(wrappers);
		model.addAttribute("balances", wrappers);
		return prefixURL + "/dataentry-materialopeningbalance-search";
	}
	
	@RequestMapping(value = "/editmaterialopbal", method = RequestMethod.GET)
    public String editmaterialopbal(Locale locale,ModelMap model,HttpServletRequest req){
		int ulbId=getSessionUser().getUlbId();	
		String matOpbalId = req.getParameter("matOpbalId");
		Long mid = Long.parseLong(matOpbalId);
		String materialName = req.getParameter("matOpbalId");
		TtInvMaterialOpbal opbal =  opbalRepo.getTtInvMaterialOpbal(mid);
		InventoryMaterialOpBalForm form = (InventoryMaterialOpBalForm) req.getSession().getAttribute("balForm");
		form.setCurrent(opbal);
		
		Integer fin = opbal.getTmCmFinancialMas().getFinId();
		form.setFinyear(""+fin);
//		model.addAttribute("fins", fins);
		List<TmCmFinancialMas> fins = opbalRepo.getTmCmFinancialMas();
		//	form.getCurrent().set
			
			req.getSession().setAttribute("balForm", form);
			model.addAttribute("balForm", form);
			model.addAttribute("fins", fins);
			model.addAttribute("finyear", fin);
	    return prefixURL + "/dataentry-materialopeningbalance-add";
	   
    }
	
	@RequestMapping(value = "/deletematerialopbal", method = RequestMethod.GET)
    public String deletematerialopbal(Locale locale,ModelMap model,HttpServletRequest req){
		int ulbId=getSessionUser().getUlbId();	
		String matOpbalId = req.getParameter("matOpbalId");
		Long mid = Long.parseLong(matOpbalId);
		String materialName = req.getParameter("matOpbalId");
		opbalRepo.deleteOpBalById(mid);
	
		InventoryMaterialOpBalForm form = (InventoryMaterialOpBalForm) req.getSession().getAttribute("balForm");

		
		List<TmInvStore> stores = mappingRepository.getAllStores(ulbId);
		List<TmInvMaterial> materials = opbalRepo.getMaterialsByULB(ulbId);
		model.addAttribute("stores", stores);
		model.addAttribute("materials", materials);
		req.getSession().setAttribute("balForm", form);
		model.addAttribute("balForm", form);
		
		List<TtInvMaterialOpbal> bals = opbalRepo.getTtInvMaterialOpbalForMaterialAndStore(form.getMaterialId(), form.getStoreId());
		int count = 1;
		List<TtInvMaterialOpbalWrapper> wrappers = new ArrayList<TtInvMaterialOpbalWrapper>();
		for(TtInvMaterialOpbal bal : bals) {
			TtInvMaterialOpbalWrapper wrapper = new TtInvMaterialOpbalWrapper();
			wrapper.setSerial(count);
			wrapper.setMaterialOpbal(bal);
			wrappers.add(wrapper);
			count++;
		}
		form.setBalances(wrappers);
		model.addAttribute("balances", wrappers);
		
		return prefixURL + "/dataentry-materialopeningbalance-search";
	   
    }

}
