package com.innowave.mahaulb.web.treecensus.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.innowave.mahaulb.common.dao.master.TmCmLocation;
import com.innowave.mahaulb.common.service.beans.UserBean;
import com.innowave.mahaulb.portal.utils.DateTimeZoneHelper;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeMasterMas;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeNameMaster;
import com.innowave.mahaulb.repository.treecensus.dao.master.TreeCensusRestDto;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;
import com.innowave.mahaulb.service.treecensus.bean.SurveyRequestBean;
import com.innowave.mahaulb.service.treecensus.bean.TreeSurveyDetailsBean;
import com.innowave.mahaulb.service.treecensus.bean.TtTreeSurveyDetailsBean;
import com.innowave.mahaulb.service.treecensus.dto.SurveyApplicationInspectionDTO;
import com.innowave.mahaulb.service.treecensus.dto.TreeNameSearchDto;
import com.innowave.mahaulb.service.treecensus.dto.master.TreeMasterMasForm;
import com.innowave.mahaulb.service.treecensus.dto.reports.ReportFilterDto;
//import com.innowave.mahaulb.service.treecensus.dto.reports.ReportFilterDto;
import com.innowave.mahaulb.service.treecensus.master.treemastermas.TreeMasterMasServ;
import com.innowave.mahaulb.service.treecensus.service.TreeCensusSurvyAppInspctrService;

 
@Controller
@PropertySource("classpath:application.properties")
@RequestMapping("/treecensus")
public class TreeMenuController {
	
	public static final Logger logger = LoggerFactory.getLogger(TreeMenuController.class);
	
	@Autowired
	private Environment env;
	
	
	@Autowired
	TreeMasterMasServ treeMasterMasServ;
	
	@Autowired
	private MessageSource messageSource; 
	
	Map<Integer, String> treeScientificNameDtlList=null;
	
	@Autowired
	HttpSession httpsession;
	
	@Autowired
	TreeCensusSurvyAppInspctrService treeCensusSurvyAppInspctrService;

	public UserBean getSessionUser()
	{
		return  (UserBean) httpsession.getAttribute("userBeanObj");
		
	}
	
	private final String prefixURL = "treecensus/masters";
	private final String prefixURLApp = "treecensus/applications";
	private final String prefixURLRep = "treecensus/reports";
	
	
	@RequestMapping(value = "/viewtreename", method = RequestMethod.GET)
    public String viewTreeName(Locale locale,ModelMap model){
		model.addAttribute("treename", new TreeMasterMasForm() );
		model.addAttribute("treenamesearch", new TreeNameSearchDto() );
		model.addAttribute("ulbId",getSessionUser().getUlbId());
	    return prefixURL+"/view-treename";
    }
	
	@RequestMapping(value = "/viewtreespacies", method = RequestMethod.GET)
    public ModelAndView  viewTreeSpacies(Locale locale,ModelMap model){
		
		model.addAttribute("treespacies", new TreeMasterMasForm());
		return new ModelAndView(prefixURL+"/view-treespecies","command",model);  
    }
	
	@RequestMapping(value = "/viewbarkshape", method = RequestMethod.GET)
    public ModelAndView viewBarkShape(Locale locale,ModelMap model){
		model.addAttribute("barkshape", new TreeMasterMasForm());
	    return new ModelAndView(prefixURL+"/view-barkshape","command",model);
    }
	
	@RequestMapping(value = "/viewleafshape", method = RequestMethod.GET)
    public ModelAndView viewLeafShape(Locale locale,ModelMap model){
		model.addAttribute("leafshape", new TreeMasterMasForm());
	    return new ModelAndView(prefixURL+"/view-leafshape","command",model);
    }
	
	
	@RequestMapping(value = "/viewleafcolor", method = RequestMethod.GET)
    public ModelAndView viewLeafColor(Locale locale,ModelMap model){
		model.addAttribute("leafcolour",new TreeMasterMasForm());
	    return new ModelAndView(prefixURL+"/view-leafcolor","command",model);
    }
	
	@RequestMapping(value = "/viewtexture", method = RequestMethod.GET)
    public ModelAndView viewTexture(Locale locale,ModelMap model){
		model.addAttribute("texturemst",new TreeMasterMasForm());
	    return new ModelAndView(prefixURL+"/view-texture","command",model);
    }
	
	@RequestMapping(value = "/viewflowername", method = RequestMethod.GET)
    public ModelAndView viewFlowername(Locale locale,ModelMap model){
		model.addAttribute("flowername", new TreeMasterMasForm());
	    return new ModelAndView(prefixURL+"/view-flowername","command",model);
    }
	
	@RequestMapping(value = "/viewflowercolor", method = RequestMethod.GET)
    public ModelAndView viewFlowercolor(Locale locale,ModelMap model){
		model.addAttribute("flowercolor", new TreeMasterMasForm());
	    return new ModelAndView(prefixURL+"/view-flowercolor","command",model);
    }
	
	@RequestMapping(value = "/viewfruitname", method = RequestMethod.GET)
    public ModelAndView viewFruitname(Locale locale,ModelMap model){
		
		model.addAttribute("fruitname", new TreeMasterMasForm());
	    return new ModelAndView(prefixURL+"/view-fruitname","command",model);
    }
	
	@RequestMapping(value = "/viewfruitshape", method = RequestMethod.GET)
    public ModelAndView viewFruitshape(Locale locale,ModelMap model){
		model.addAttribute("fruitshape", new TreeMasterMasForm());
	    return new ModelAndView(prefixURL+"/view-fruitshape","command",model);
    }
	
	@RequestMapping(value = "/viewodour", method = RequestMethod.GET)
    public ModelAndView viewOdour(Locale locale,ModelMap model){
		model.addAttribute("odour", new TreeMasterMasForm());
	    return new ModelAndView(prefixURL+"/view-odour","command",model);
    }
	

	@RequestMapping(value = "/viewtreestatus", method = RequestMethod.GET)
    public ModelAndView viewTreeStatus(Locale locale,ModelMap model){
		model.addAttribute("treestatus", new TreeMasterMasForm());
	    return new ModelAndView(prefixURL+"/view-treestatus","command",model);
    }
	
	@RequestMapping(value = "/viewauthority", method = RequestMethod.GET)
    public String viewAuthority(Locale locale,ModelMap model){
	    return "masters/view-authority";
    }
	
	@RequestMapping(value = "/viewpenalty", method = RequestMethod.GET)
    public String viewPenalty(Locale locale,ModelMap model){
	    return "masters/view-penalty";
    }
	
	
	@RequestMapping(value = "/viewtreemaster", method = RequestMethod.GET)
    public String viewTreeMaster(Locale locale,ModelMap model,HttpServletRequest req){
		int ulbId=getSessionUser().getUlbId();	
		model.addAttribute("ulbId", ulbId);
		TreeCensusRestDto  ttTreeCensusDetails  = new TreeCensusRestDto();	
		model.addAttribute("treeCensusDetail", ttTreeCensusDetails);
	
		
		//TreeCensusCommDto  treeCensusCommDto  =treeCensusRestServ.getRestTreeDetailsServ();
		/*String treeNameType = req.getParameter("treeNameType");
		String searchString = req.getParameter("searchString");
		Set<TmTreeNameMaster>  treeCensusDtlList = treeMasterMasServ.getTreeNameDetailsServ(treeNameType, searchString);
		treeScientificNameDtlList = new HashMap<Integer, String>();
		
		for(TmTreeNameMaster treeNAmeDtl : treeCensusDtlList){
			treeScientificNameDtlList.put(treeNAmeDtl.getTreenameId(),treeNAmeDtl.getTreeVerNameEn());
		}
		model.addAttribute("treeCensusDetail", new TreeCensusRestDto());
		model.addAttribute("treeScientificNameDtlList", treeScientificNameDtlList);*/
	    return prefixURL+"/view-treemaster";
    }
	
	@RequestMapping(value = "/treeCensusPrefixDtl", headers = "Accept=application/json", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public @ResponseBody Map<Integer, String> treeCensusPrefixDtl(Locale locale,ModelMap model, HttpServletRequest req){
		//int ulbIdAuto=Integer.parseInt(req.getParameter("ulbIdAuto"));
		int ulbIdAuto=getSessionUser().getUlbId();	
		String prefix = req.getParameter("prefixName");
		String searchString = req.getParameter("searchString");
		List<TmTreeMasterMas>  tmTreeMasterMasList = treeMasterMasServ.getMasterDataListServ(prefix, searchString, ulbIdAuto);
		Map<Integer, String> prefixDtlList = new HashMap<Integer, String>();
		
		for(TmTreeMasterMas treeMas : tmTreeMasterMasList){
			prefixDtlList.put(treeMas.getTreemasId(), treeMas.getTreemasDescEn());
		}
		return prefixDtlList;
    }
	
	@RequestMapping(value = "/savetreemasterData", method = RequestMethod.POST)
    public String viewTreeMaster(@RequestBody TreeSurveyDetailsBean treeSurveyDetailsBean,
    		Locale locale,HttpSession session,ModelMap model){
		
		UserBean userBeanObj = (UserBean)session.getAttribute("userBeanObj");
		
		try {
			treeSurveyDetailsBean.setUlbId(userBeanObj.getUlbId());
			treeSurveyDetailsBean.setCreatedBy(userBeanObj.getUserId());
			treeSurveyDetailsBean.setCreatedDate(DateTimeZoneHelper.getCurrentSysTimestamp());
		treeMasterMasServ.saveTreeMasterDetailsServ(treeSurveyDetailsBean);
			//model.addAttribute("message",messageSource.getMessage("lable.common.sucess.added", null, locale));
		}catch(Exception e) {
			//model.addAttribute("message",messageSource.getMessage("lable.common.fail.add", null, locale));
		}
		//model.addAttribute("treeCensusDetail", new TreeCensusRestDto());
	    return "Saved"/* prefixURL+"/view-treemaster"*/;
    }
		@RequestMapping(value = "/applicationsurveyreq", method = RequestMethod.GET)
    public String applicationSurveyReq(Locale locale,ModelMap model){	
		int ulbId=getSessionUser().getUlbId();	
		model.addAttribute("ulbId", ulbId);
		//System.out.println("getSessionUser ::: " + ulbId);
		SurveyRequestBean surveyRequestBean = new SurveyRequestBean();
		model.addAttribute("surveyrequest", surveyRequestBean );
		TmCmLocation locationBean = new TmCmLocation();
		String jasonFile =  env.getProperty("google.map.key");
		model.addAttribute("key",jasonFile);
		model.addAttribute("loactionmaster", locationBean );
		return prefixURLApp+"/application-surveyrequest";		
    }
	
	@RequestMapping(value = "/applicationsurvey", method = RequestMethod.GET)
    public String applicationSurvey(Locale locale,ModelMap model){
	    return "applications/application-survey";
    }
	
	@RequestMapping(value = "/applicationsurveyinspector", method = RequestMethod.GET)
    public String applicationSurveyInspector(Locale locale,ModelMap model){
		TtTreeSurveyDetailsBean  ttTreeSurveyDetails  = new TtTreeSurveyDetailsBean();	
		model.addAttribute("treeCensusDetail", ttTreeSurveyDetails);
		model.addAttribute("ulbId",getSessionUser().getUlbId());
		String jasonFile =  env.getProperty("google.map.key");
		model.addAttribute("key",jasonFile);
	    return prefixURLApp+"/application-surveyinspector";
    }
	
	@RequestMapping(value = "/applicationsurveydataentry", method = RequestMethod.GET)
    public String applicationSurveyDetailsDataEntry(Locale locale,ModelMap model){
		/*TtTreeSurveyDetails  ttTreeSurveyDetails  = new TtTreeSurveyDetails();*/	
		TtTreeSurveyDetailsBean ttTreeSurveyDetails = new TtTreeSurveyDetailsBean();
		model.addAttribute("treeCensusDetail", ttTreeSurveyDetails);
		String jasonFile =  env.getProperty("google.map.key");
		model.addAttribute("key",jasonFile);
		
	    return prefixURLApp+"/application-surveydataentry";
    }
	
	
	@RequestMapping(value = "/treeCensusTreeNameDtl", headers = "Accept=application/json", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public @ResponseBody Set<TmTreeNameMaster> treeCensusVernaDtl(Locale locale,ModelMap model, HttpServletRequest req){
		String treeNameType = req.getParameter("treeNameType");
		String searchString = req.getParameter("searchString");
		Set<TmTreeNameMaster>  treeCensusDtlList = treeMasterMasServ.getTreeNameDetailsServ(treeNameType, searchString);
		Set<TmTreeNameMaster>  finalTreeCensusDtlList = new HashSet<TmTreeNameMaster>();
		
		for(TmTreeNameMaster treeNAmeDtl : treeCensusDtlList){
			if(treeNameType.equalsIgnoreCase("vernacular")){
				finalTreeCensusDtlList.add(treeNAmeDtl);
			}
			if(treeNameType.equalsIgnoreCase("scientific")){
				finalTreeCensusDtlList.add(treeNAmeDtl);
			}
			if(treeNameType.equalsIgnoreCase("treecommon")){
				finalTreeCensusDtlList.add(treeNAmeDtl);
			}
			if(treeNameType.equalsIgnoreCase("treefamily")){
				finalTreeCensusDtlList.add(treeNAmeDtl);
			}
		}
		return finalTreeCensusDtlList;
    }
	
	@RequestMapping(value = "/applicationsurveyinspectorSave", method = RequestMethod.POST)
    public String applicationsurveyinspectorSave(@ModelAttribute("treeCensusDetail") TtTreeSurveyDetailsBean  ttTreeSurveyDetails, BindingResult bindingResult, Locale locale,ModelMap model){
		
		ttTreeSurveyDetails.setUlbId(getSessionUser().getUlbId());
		ttTreeSurveyDetails.setCreatedBy(getSessionUser().getUserId());
		ttTreeSurveyDetails.setCreatedDate(DateTimeZoneHelper.getSysDate());
		treeMasterMasServ.saveApplicationSurveyInspector(ttTreeSurveyDetails);
		TtTreeSurveyDetailsBean  ttTreeSurveyDetail  = new TtTreeSurveyDetailsBean();		
		model.put("message",messageSource.getMessage("lable.common.sucess.added", null, locale));
		model.put("msgtype","success");		
		model.addAttribute("treeCensusDetail", ttTreeSurveyDetail);
		String jasonFile =  env.getProperty("google.map.key");
		model.addAttribute("key",jasonFile);
	    return prefixURLApp+"/application-surveyinspector";
    }
	
	public void setTreeScientificNameDtlList(Map<Integer, String> treeScientificNameDtlList){
		this.treeScientificNameDtlList = treeScientificNameDtlList;
	}
	
	public Map<Integer, String> getTreeScientificNameDtlList(){
		return this.treeScientificNameDtlList;
	}
	
	/*Reports Added on 08-11-2017 Brijesh Soni*/
	//reporttreecensusreg
	@RequestMapping(value = "/reporttreecensusreg", method = RequestMethod.GET)
    public ModelAndView reportRegister(Locale locale,ModelMap model){
		ReportFilterDto reportFilter = new ReportFilterDto();
		reportFilter.setUlbId(getSessionUser().getUlbId());
		model.addAttribute("registerReport", reportFilter);
		model.addAttribute("ulbId", getSessionUser().getUlbId());
	    return new ModelAndView(prefixURLRep+"/report-treecensusregister", model);
    }
	
	//reportnumoftrees
	@RequestMapping(value = "/reportnumoftrees", method = RequestMethod.GET)
    public ModelAndView reportNumberOfTree(Locale locale,ModelMap model){
		ReportFilterDto reportFilter = new ReportFilterDto();
		reportFilter.setUlbId(getSessionUser().getUlbId());
		model.addAttribute("ulbId", getSessionUser().getUlbId());
		model.addAttribute("reportTreeCount", reportFilter);
	    return new ModelAndView(prefixURLRep+"/report-numberoftrees", model);
    }
	
	//reportdiversityoftrees
	@RequestMapping(value = "/reportdiversityoftrees", method = RequestMethod.GET)
    public ModelAndView reportDiversityTrees(Locale locale,ModelMap model){
		ReportFilterDto reportFilter = new ReportFilterDto();
		reportFilter.setUlbId(getSessionUser().getUlbId());
		model.addAttribute("ulbId", getSessionUser().getUlbId());
		model.addAttribute("reportDiversityCount", reportFilter);
	    return new ModelAndView(prefixURLRep+"/report-diversityoftrees", model);
    }
	
	//reportyearwise
	@RequestMapping(value = "/reportyearwise", method = RequestMethod.GET)
    public ModelAndView reportYearWise(Locale locale,ModelMap model){
		ReportFilterDto reportFilter = new ReportFilterDto();
		reportFilter.setUlbId(getSessionUser().getUlbId());
		model.addAttribute("ulbId", getSessionUser().getUlbId());
		model.addAttribute("reportYearwise", reportFilter);
	    return new ModelAndView(prefixURLRep+"/report-yearwisetreecensus", model);
    }
	/*End Treecensus Reports*/
  
	//SRN ID Function Made By Surya
	
	/*@RequestMapping(value = "/request/{srnid}", method = { RequestMethod.GET, RequestMethod.POST },
			produces = "application/json;charset=UTF-8")
	public ResponseEntity<String> mahadmaGraphsService3(Locale locale,Model model, HttpServletRequest request, HttpServletResponse response,
			@PathVariable String srnid) {
	
		try {
			long srnID=Long.parseLong(srnid);
	        Integer ulbId=getSessionUser().getUlbId();
			String resJson = "";
			Object[] list = treeCensusSurvyAppInspctrService.getServiceRequestDetails(srnID,ulbId);
			
			//resJson = list.toString();
			
			Gson gson = new Gson();
			
			resJson = gson.toJson(list);
			
			return ResponseEntity.ok(resJson);
		} catch (Exception e) {
			logger.error("SEARCH PROPERTY ", e);
			return ResponseEntity.ok(e.getMessage());
		}
	}*/
	
	
	//SRN ID Function Made By Surya
	
	
	
  @RequestMapping(value = "/request/{srnid}", method = { RequestMethod.GET, RequestMethod.POST })
  public ModelAndView treenameAction(Locale locale,HttpSession session, @ModelAttribute("treeCensusDetail") TtTreeSurveyDetails tTreeSurveyDetails,
			HttpServletRequest request,@PathVariable String srnid,ModelMap model){	
	        long srnID=Long.parseLong(srnid);
	        Integer ulbId=getSessionUser().getUlbId();
	        ArrayList<Object[]> arList = treeCensusSurvyAppInspctrService.getServiceRequestDetails(srnID,ulbId);
	        System.out.println(arList.size());
	        ModelAndView modelAndView  = new ModelAndView("treecensus/applications/application-surveyinspector",model);
	        System.out.println("lkh");
	       System.out.println(arList.get(0).length);
	      
	       
	       Object[] list = arList.get(0);
	      Object[] objects = arList.get(1);
	      System.out.println(objects.length);
	      System.out.println(objects[0]);
	     
	      
			Long srnId = (Long) list[0];
			String applicantName = (String) list[1];
			String applicantMobile = (String) list[2];
			String applicantEmail = (String) list[3];
			String applicantUid = (String) list[4];
			String applicantAddress = (String) list[5];
			String organisationName = (String) list[6];
		    String organisationAddress = (String) list[7];
			String location = (String) list[8];
			String apartmentComplex = (String) list[9];
			String road = (String) list[10];
			String locality = (String) list[11];
			String longitude = (String) list[12];
			String latitude = (String) list[13];
	     	String ward = (String) objects[0];
			String zone = (String) objects[1];

			modelAndView.addObject("srnId", srnId);
			 int i = 0,
		     spaceCount = 0;
			 String[] name;
			 name =applicantName.split(" ");
System.out.println(name.length);
				     /* while( i < applicantName.length() ){
				        if( applicantName.charAt(i) == ' ' ) {
				            spaceCount++;
				        }
				        i++;
				
				    
				      }*/  
				    
                if(name.length==1){
                	
                	modelAndView.addObject("fName", name[0]);
                	System.out.println(name[0]);
                }else
				if(name.length==2){
					modelAndView.addObject("fName", name[0]);
					modelAndView.addObject("lName", name[1]);
					System.out.println(name[0]);
					System.out.println(name[1]);
				}else
				if(name.length>2){
					modelAndView.addObject("fName", name[0]);
					modelAndView.addObject("mName", name[1]);
					modelAndView.addObject("lName", name[2]);
					System.out.println(name[0]);
					System.out.println(name[1]);
					System.out.println(name[2]);
				}     

				      

			modelAndView.addObject("applicantMobile", applicantMobile);
			modelAndView.addObject("applicantEmail", applicantEmail);
			modelAndView.addObject("applicantUid", applicantUid);
			modelAndView.addObject("applicantAddress", applicantAddress);
			modelAndView.addObject("organisationName", organisationName);
			modelAndView.addObject("organisationAddress", organisationAddress);
		    modelAndView.addObject("location", location);
			modelAndView.addObject("apartmentComplex", apartmentComplex);
			modelAndView.addObject("road", road);
			modelAndView.addObject("locality", locality);
			modelAndView.addObject("longitude", longitude);
			modelAndView.addObject("latitude", latitude);
			modelAndView.addObject("ward", ward);
			modelAndView.addObject("zone", zone);
			String jasonFile =  env.getProperty("google.map.key");
			modelAndView.addObject("key",jasonFile);
	       return modelAndView;
  }
  
//(mahesh)update
	@RequestMapping(value = "/updateTreecensusInspectionData", headers = "Accept=application/json", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public ResponseEntity<String> updateTreecensusInspectionData(@RequestHeader HttpHeaders headers,
			@RequestBody SurveyApplicationInspectionDTO surveyApplicationInspectionDTO,HttpSession session, UriComponentsBuilder ucBuilder) {

		try {
			String resJson = "";
			resJson = treeCensusSurvyAppInspctrService.updateTreecensusInspectionData(surveyApplicationInspectionDTO);
			return ResponseEntity.ok(resJson);
		} catch (Exception e) {
			logger.error("controller", e);
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/getWard", headers = "Accept=application/json", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<String> getWard(@RequestHeader HttpHeaders headers,
			HttpSession session, UriComponentsBuilder ucBuilder) {

		try {
			String resJson = "";
			resJson = treeMasterMasServ.getlookupDetData(getSessionUser().getUlbId(),"AWZ");
			return ResponseEntity.ok(resJson);
		} catch (Exception e) {
			logger.error("controller", e);
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/getReasonForSurvey", headers = "Accept=application/json", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<String> getReasonForSurvey(@RequestHeader HttpHeaders headers,
			HttpSession session, UriComponentsBuilder ucBuilder) {

		try {
			String resJson = "";
			resJson = treeMasterMasServ.getlookupDetData(getSessionUser().getUlbId(),"RSU");
			return ResponseEntity.ok(resJson);
		} catch (Exception e) {
			logger.error("controller", e);
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/getOwnershipOfLand", headers = "Accept=application/json", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<String> getOwnershipOfLand(@RequestHeader HttpHeaders headers,
			HttpSession session, UriComponentsBuilder ucBuilder) {

		try {
			String resJson = "";
			resJson = treeMasterMasServ.getlookupDetData(getSessionUser().getUlbId(),"OLT");
			return ResponseEntity.ok(resJson);
		} catch (Exception e) {
			logger.error("controller", e);
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	
	@RequestMapping(value = "/getAestheticData", headers = "Accept=application/json", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<String> getAestheticData(@RequestHeader HttpHeaders headers,
			HttpSession session, UriComponentsBuilder ucBuilder) {

		try {
			String resJson = "";
			resJson = treeMasterMasServ.getlookupDetData(getSessionUser().getUlbId(),"TUA");
			return ResponseEntity.ok(resJson);
		} catch (Exception e) {
			logger.error("controller", e);
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
  
	@RequestMapping(value = "/getCulturalData", headers = "Accept=application/json", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<String> getCulturalData(@RequestHeader HttpHeaders headers,
			HttpSession session, UriComponentsBuilder ucBuilder) {

		try {
			String resJson = "";
			resJson = treeMasterMasServ.getlookupDetData(getSessionUser().getUlbId(),"AUC");
			return ResponseEntity.ok(resJson);
		} catch (Exception e) {
			logger.error("controller", e);
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/getEcologicalData", headers = "Accept=application/json", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<String> getEcologicalData(@RequestHeader HttpHeaders headers,
			HttpSession session, UriComponentsBuilder ucBuilder) {

		try {
			String resJson = "";
			resJson = treeMasterMasServ.getlookupDetData(getSessionUser().getUlbId(),"TUE");
			return ResponseEntity.ok(resJson);
		} catch (Exception e) {
			logger.error("controller", e);
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/getEconomicData", headers = "Accept=application/json", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<String> getEconomicData(@RequestHeader HttpHeaders headers,
			HttpSession session, UriComponentsBuilder ucBuilder) {

		try {
			String resJson = "";
			resJson = treeMasterMasServ.getlookupDetData(getSessionUser().getUlbId(),"TUC");
			return ResponseEntity.ok(resJson);
		} catch (Exception e) {
			logger.error("controller", e);
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	
	@RequestMapping(value = "/getDataBySrnNumber", headers = "Accept=application/json", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public @ResponseBody Set<TtTreeSurveyDetails> getDataBySrnNumber(Locale locale,ModelMap model, HttpServletRequest req){
		String treeNameType = req.getParameter("numberType");
		String searchString = req.getParameter("searchString");
		Set<TtTreeSurveyDetails>  treeCensusDtlList = treeMasterMasServ.getDataBySrnNumber(treeNameType, searchString);
		Set<TtTreeSurveyDetails>  finalTreeCensusDtlList = new HashSet<TtTreeSurveyDetails>();
		
		for(TtTreeSurveyDetails treeNAmeDtl : treeCensusDtlList){
			if(treeNAmeDtl != null){
				if(treeNameType.equalsIgnoreCase("srn")){
					finalTreeCensusDtlList.add(treeNAmeDtl);
				}
				if(treeNameType.equalsIgnoreCase("treeid")){
					finalTreeCensusDtlList.add(treeNAmeDtl);
				}
			}
		}
		return finalTreeCensusDtlList;
    }
	
	
}
