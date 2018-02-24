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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.common.repository.TmCmDepartmentRepo;
import com.innowave.mahaulb.common.repository.TmUlbMasterRepo;
import com.innowave.mahaulb.common.service.TmULBService;
import com.innowave.mahaulb.common.service.beans.UserBean;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;
import com.innowave.mahaulb.repository.inventory.dao.trans.TtInvScrap;
import com.innowave.mahaulb.repository.inventory.repo.MaterialTypeRepo;
import com.innowave.mahaulb.repository.inventory.repo.MaterialTypeStoreMappingRepository;
import com.innowave.mahaulb.repository.inventory.repo.TtInvScrapRepo;
import com.innowave.mahaulb.service.inventory.service.MasterMaterialStoreServ;
import com.innowave.mahaulb.web.inventory.controller.forms.DisposalOfScrapDTO;

@Controller
@RequestMapping("/inventory/transactions")
public class InventoryScrapController {
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private HttpSession httpSession;



	
	@Autowired
	private TmULBService ulbService;
	
	@Autowired
	private MasterMaterialStoreServ storeServ;
	
	@Autowired
	TtInvScrapRepo scrapRepo;


	private final String prefixURL = "inventory/transactions";

	public UserBean getSessionUser() {
		// Session session = sessionFactory.getCurrentSession();
		return (UserBean) httpSession.getAttribute("userBeanObj");
	}

	@RequestMapping(value = "/viewscrap", method = RequestMethod.GET)
    public String viewdisposalofscrap(Locale locale,ModelMap model,HttpServletRequest req){
		int ulbId=getSessionUser().getUlbId();	
		List<TmInvStore> stores = storeServ.getAllMaterialStores(ulbId);
		model.addAttribute("stores", stores);
		DisposalOfScrapDTO disposalOfScrapDTO = new DisposalOfScrapDTO();
		model.addAttribute("disposalOfScrapDTO", disposalOfScrapDTO);
		req.getSession().setAttribute("disposalOfScrapDTO", disposalOfScrapDTO);
	    return prefixURL+"/master-search-scrap-material";
    }
	
	@RequestMapping(value = "/adddisposalofscrap", method = RequestMethod.GET)
    public String adddisposalofscrap(Locale locale,ModelMap model,HttpServletRequest req){
		int ulbId=getSessionUser().getUlbId();	
		List<TmInvStore> stores = storeServ.getAllMaterialStores(ulbId);
		model.addAttribute("stores", stores);
		DisposalOfScrapDTO disposalOfScrapDTO = new DisposalOfScrapDTO();
		
		disposalOfScrapDTO.setCurrent(new TtInvScrap());
		int userId = getSessionUser().getUserId();
		disposalOfScrapDTO.getCurrent().setCreatedBy(userId);
		//disposalOfScrapDTO.getCurrent().setCreatedByUser(getSessionUser().getUserName());
		model.addAttribute("disposalOfScrapDTO", disposalOfScrapDTO);
		req.getSession().setAttribute("disposalOfScrapDTO", disposalOfScrapDTO);
	    return prefixURL+"/master-add-scrap-material";
    }
	@RequestMapping(value = "/seachdisposalofscrap", method = RequestMethod.GET)
    public String seachdisposalofscrap(Locale locale,ModelMap model,HttpServletRequest req){
		
		int ulbId=getSessionUser().getUlbId();	
		DisposalOfScrapDTO disposalOfScrapDTO = (DisposalOfScrapDTO) model.get("disposalOfScrapDTO");
		if(disposalOfScrapDTO == null) {
			disposalOfScrapDTO = (DisposalOfScrapDTO) req.getSession().getAttribute("disposalOfScrapDTO");
		}
		String disposalNo = req.getParameter("disposalNo");
		String store = req.getParameter("storeId");
		String disposalFormDate = req.getParameter("fromdisposalddate");
		String st = req.getParameter("status");
		Date disDate = null;
			if(disposalFormDate != null) {
				disDate = convertDate(disposalFormDate);
				disposalOfScrapDTO.setDisposalFormDate(disposalFormDate);
			}
		Long storeid = null;
		if(store != null && store.trim().length() != 0){
			storeid = Long.parseLong(store);
		}
		disposalOfScrapDTO.setStoreId(storeid);
		disposalOfScrapDTO.setDisposalNo(disposalNo);
		disposalOfScrapDTO.setStatus(Boolean.valueOf(st));
		
		
				if((disposalNo == null || disposalNo.trim().length()==0) && storeid == null && disDate == null ) {
					model.put("message","Select Values and then Search");
					model.put("msgtype","info");
				    return viewdisposalofscrap(locale, model, req);
				}
				
				List<TmInvStore> stores = storeServ.getAllMaterialStores(ulbId);
				model.addAttribute("stores", stores);
				char s = 'N';
					if(disposalOfScrapDTO.getStatus()) {
						s = 'Y';
					}
				
		List<TtInvScrap> scraps = scrapRepo.getScraps(ulbId, disposalNo, storeid,disDate , null, s);
		model.addAttribute("disposalOfScrapDTO", disposalOfScrapDTO);
		req.getSession().setAttribute("disposalOfScrapDTO", disposalOfScrapDTO);
		model.addAttribute("scraps", scraps);
		req.setAttribute("scraps", scraps);
	    return prefixURL+"/master-search-scrap-material";
    }
	
	private Date convertDate(String date) {
		try {
			String format = "yyyy-MM-dd";
			DateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
	}
	
	private String convertDateToString(Date date) {
		String format = "yyyy-MM-dd";
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
		//opbalRepo.
	}
	//
	@RequestMapping(value = "/savedisposalofscrap", method = RequestMethod.GET)
	public String savedisposalofscrap(Locale locale,ModelMap model,HttpServletRequest req){
		
		int ulbId=getSessionUser().getUlbId();	
		DisposalOfScrapDTO disposalOfScrapDTO = (DisposalOfScrapDTO) model.get("disposalOfScrapDTO");
		if(disposalOfScrapDTO == null) {
			disposalOfScrapDTO = (DisposalOfScrapDTO) req.getSession().getAttribute("disposalOfScrapDTO");
		}
		String disposalNo = req.getParameter("current.scrapNo");
		String store = req.getParameter("storeId");
		String disposalFormDate = req.getParameter("fromdisposalddate");
		String st = req.getParameter("status");
		
		String remarks = req.getParameter("current.scrapRemarks");
		String createdBy = req.getParameter("current.createdBy");
		
		
		Date disDate = null;
			if(disposalFormDate != null) {
				disDate = convertDate(disposalFormDate);
				disposalOfScrapDTO.setDisposalFormDate(disposalFormDate);
			}
		Long storeid = null;
		if(store != null){
			storeid = Long.parseLong(store);
		}
		disposalOfScrapDTO.setStoreId(storeid);
		disposalOfScrapDTO.setDisposalNo(disposalNo);
		disposalOfScrapDTO.setStatus(Boolean.valueOf(st));
		disposalOfScrapDTO.setDisposalRemark(remarks);
		disposalOfScrapDTO.setDisposedByUserId(createdBy);
		
		
		List<TmInvStore> stores = storeServ.getAllMaterialStores(ulbId);
		model.addAttribute("stores", stores);
		
		TtInvScrap scrap = 	convertDtoToEntity(disposalOfScrapDTO, ulbId);
		scrapRepo.saveOrUpdate(scrap);
			char c = 'N';
			
			if(disposalOfScrapDTO.getStatus()) {
				c = 'Y';
			}
		List<TtInvScrap> scraps = scrapRepo.getScraps(ulbId, disposalNo, storeid,disDate , null, c);
		model.addAttribute("disposalOfScrapDTO", disposalOfScrapDTO);
		req.getSession().setAttribute("disposalOfScrapDTO", disposalOfScrapDTO);
		model.addAttribute("scraps", scraps);
		req.setAttribute("scraps", scraps);
	    return prefixURL+"/master-search-scrap-material";
    }
	
	@RequestMapping(value = "/editdisposalofscrap", method = RequestMethod.GET)
	public String editdisposalofscrap(Locale locale,ModelMap model,HttpServletRequest req){
		
		int ulbId=getSessionUser().getUlbId();	
		String scrap = req.getParameter("scrapId");
		//scrapRepo.g
		DisposalOfScrapDTO disposalOfScrapDTO = new DisposalOfScrapDTO();
		TtInvScrap sc = scrapRepo.getUniqueById(Long.parseLong(scrap));
		disposalOfScrapDTO.setStoreId(sc.getTmInvStore().getStoreId());
		disposalOfScrapDTO.setDisposalFormDate(convertDateToString(sc.getScrapDate()));
		disposalOfScrapDTO.setDisposalNo(sc.getScrapNo());
			if(sc.getScrapStatus() == 'Y') {
				disposalOfScrapDTO.setStatus(true);
			}
			else {
				disposalOfScrapDTO.setStatus(false);
			}
		
		disposalOfScrapDTO.setDisposalRemark(sc.getScrapRemarks());
		disposalOfScrapDTO.setDisposedByUserId(""+sc.getCreatedBy());
		disposalOfScrapDTO.setCurrent(sc);
		List<TmInvStore> stores = storeServ.getAllMaterialStores(ulbId);
		model.addAttribute("stores", stores);
		model.addAttribute("disposalOfScrapDTO", disposalOfScrapDTO);
		req.getSession().setAttribute("disposalOfScrapDTO", disposalOfScrapDTO);
	
	    return prefixURL+"/master-add-scrap-material";
    }
	
	@RequestMapping(value = "/deletedisposalofscrap", method = RequestMethod.GET)
	public String deletedisposalofscrap(Locale locale,ModelMap model,HttpServletRequest req){
		
		int ulbId=getSessionUser().getUlbId();	
		String scrap = req.getParameter("scrapId");
		scrapRepo.deleteById(Long.parseLong(scrap));
		model.put("message","Deletion of Scrap with id "+scrap+" successful");
		model.put("msgtype","success");
	    return viewdisposalofscrap(locale, model, req);
    }
	
	
	
	private TtInvScrap convertDtoToEntity(DisposalOfScrapDTO disposalOfScrapDTO, Integer ulbId) {
		TtInvScrap invScrap = new TtInvScrap();
		invScrap.setScrapRemarks(disposalOfScrapDTO.getDisposalRemark());
		invScrap.setCreatedBy(Integer.parseInt(disposalOfScrapDTO.getDisposedByUserId()));
		TmInvStore invStore = new TmInvStore();
		
		invScrap.setScrapDate(convertDate(disposalOfScrapDTO.getDisposalFormDate()));
		
		invStore.setStoreId(disposalOfScrapDTO.getStoreId());
		TmUlb tmUlb = new TmUlb(ulbId);
		invStore.setTmUlb(tmUlb);
		invScrap.setTmInvStore(invStore);
		
		invScrap.setScrapNo(disposalOfScrapDTO.getDisposalNo());
		char c = 'N';
		if(disposalOfScrapDTO.getStatus()) {
			c = 'Y';
		}
		invScrap.setScrapStatus(c);
		invScrap.setTmUlb(tmUlb);
			if(disposalOfScrapDTO.getCurrent() != null && disposalOfScrapDTO.getCurrent().getCreatedDate() != null) {
				invScrap.setCreatedDate(disposalOfScrapDTO.getCurrent().getCreatedDate());
			}
		return invScrap;
		
		//invStore.setu
	}
	
}
