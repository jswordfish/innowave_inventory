package com.innowave.mahaulb.web.treecensus.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.dao.TmCmLookupDetHierarchical;
import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.common.dao.master.TmCmLocation;
import com.innowave.mahaulb.common.service.beans.UserBean;
import com.innowave.mahaulb.common.service.utils.JasperReportService;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;
import com.innowave.mahaulb.service.treecensus.dto.reports.DiversityCountBean;
import com.innowave.mahaulb.service.treecensus.dto.reports.DiversityCountReport;
import com.innowave.mahaulb.service.treecensus.dto.reports.ReportFilterDto;
import com.innowave.mahaulb.service.treecensus.service.TreecensusServ;
import com.innowave.mahaulb.service.treecensus.service.repots.DiversityCountServ;
import com.innowave.mahaulb.web.treecensus.helper.DiversityCountHelper;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/treecensus/reports")
public class DiversityCountReportController {

	@Autowired
	private Environment env;
	@Autowired
	private JasperReportService jasperReportService;
	@Autowired
	HttpSession httpsession;
	@Autowired
	DiversityCountServ diversityCountServ;
	@Autowired
	TreecensusServ treeServ;
	
	public static final Logger logger = LoggerFactory.getLogger(DiversityCountReportController.class);
	JasperPrint jasperPrint;
	
	public UserBean getSessionUser()
	{
		return  (UserBean) httpsession.getAttribute("userBeanObj");
	}
	
	@RequestMapping(value = "/reportdiversityoftrees", method = { RequestMethod.GET, RequestMethod.POST })
	public String diversityCountReport(Model model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, @ModelAttribute("reportDiversityCount") ReportFilterDto reportFilterBean) {
		jasperPrint = null;

		System.out.println("getLocationId::: " + reportFilterBean.getLocationId());
		try {
			List<Object[]> diversityCountData = diversityCountServ.getDiversityCountData(new TtTreeSurveyDetails(), new TmCmLookupDet(), getSessionUser().getUlbId(),
					reportFilterBean.getFromDate(), reportFilterBean.getToDate(), reportFilterBean.getTreespeciesId(), reportFilterBean.getLocationId(), 
					reportFilterBean.getTreeCityNm(), reportFilterBean.getTreeWard(), reportFilterBean.getTreeZone());

			TmUlb uldData = diversityCountServ.getUlbName(getSessionUser().getUlbId());
			String ulbCity = diversityCountServ.getUlbCity(uldData.getLookupDetHierIdCity());
			DiversityCountHelper reptHelper = new DiversityCountHelper();
			List<DiversityCountBean> rptList =  reptHelper.getReportLstObj(diversityCountData);
			System.out.println(" rptList "+rptList.size());
			
			DiversityCountReport diversityCount = new DiversityCountReport();
			diversityCount.setDiversityCount(rptList);
			
			HashMap<String, Object> reportParams = new HashMap<String, Object>();
			reportParams.put("SUBREPORT_DIR", env.getProperty("jasper.report.path").concat("/treecensus/")); //.concat("treeregsubone.jasper")
			
			reportParams.put("ULB_NM", uldData.getUlbNameEn().toUpperCase());
			reportParams.put("REP_NM", "Diversity of Trees Report".toUpperCase());
			reportParams.put("FR_DT",reportFilterBean.getFromDate());
			reportParams.put("TO_DT", reportFilterBean.getToDate());
			reportFilterBean.setTreeCity(Integer.toString(uldData.getLookupDetHierIdCity()));
			if (reportFilterBean.getTreeLocation().length() != 0)
				reportParams.put("CWZL", "Location: " + reportFilterBean.getTreeLocation());
			else if (reportFilterBean.getTreeCity().length() != 0)
				reportParams.put("CWZL",  "City: " +ulbCity);
			else if (!reportFilterBean.getTreeWard().equals(""))
				reportParams.put("CWZL",  "Ward: " +reportFilterBean.getTreeWard());
			else if (!reportFilterBean.getTreeZone().equals(""))
				reportParams.put("CWZL",  "Zone: " +reportFilterBean.getTreeZone());
			
			List<DiversityCountReport> reportObj = new ArrayList<DiversityCountReport>();
			reportObj.add(diversityCount);
			System.out.println(reportObj.size()+  " Rpws ");
			JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(reportObj);
			JasperReport jasperFile = jasperReportService.getJasperFile("treecensus","diversityOfTrees");
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFile,reportParams,jrbean); //jrbean //new JREmptyDataSource()
			
			jasperReportService.generateReportPDF(response,  jasperPrint);
			//CWZL
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/locationData",  headers = "Accept=application/json", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public @ResponseBody Map<Integer, String> locationDataDtl(Locale locale,ModelMap model, HttpServletRequest req){
		int ulbIdAuto=Integer.parseInt(req.getParameter("ulbIdAuto"));
		String searchString = req.getParameter("searchString");
		List<TmCmLocation>  tmCmlookuplist = treeServ.getLocationDataListServ(searchString,ulbIdAuto);
		Map<Integer, String> prefixDtlList = new HashMap<Integer, String>();
		
		for(TmCmLocation tmCmlookupdet : tmCmlookuplist){
			prefixDtlList.put(tmCmlookupdet.getLocationId(), tmCmlookupdet.getLocationDescription());
		}
		return prefixDtlList;
    }
	
	@RequestMapping(value = "/wardData",  headers = "Accept=application/json", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public @ResponseBody Map<Integer, String> wardDataDtl(Locale locale,ModelMap model, HttpServletRequest req){
		int ulbIdAuto=Integer.parseInt(req.getParameter("ulbIdAuto"));
		String searchString = req.getParameter("searchString");
		List<TmCmLookupDetHierarchical>  tmCmlookuplist = treeServ.getLookupHierWordListServ(searchString, ulbIdAuto);
		Map<Integer, String> prefixDtlList = new HashMap<Integer, String>();
		for(TmCmLookupDetHierarchical tmCmlookupdet : tmCmlookuplist){
			prefixDtlList.put(tmCmlookupdet.getLookupDetHierId(), tmCmlookupdet.getLookupDetHierDescEn());
		}
		return prefixDtlList;
	}
}
