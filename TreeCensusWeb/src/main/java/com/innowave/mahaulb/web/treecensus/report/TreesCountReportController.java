package com.innowave.mahaulb.web.treecensus.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.common.service.beans.UserBean;
import com.innowave.mahaulb.common.service.utils.JasperReportService;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;
import com.innowave.mahaulb.service.treecensus.dto.reports.ReportFilterDto;
import com.innowave.mahaulb.service.treecensus.dto.reports.TreeCountBean;
import com.innowave.mahaulb.service.treecensus.dto.reports.TreeCountReport;
import com.innowave.mahaulb.service.treecensus.service.repots.TreeCountServ;
import com.innowave.mahaulb.web.treecensus.helper.TreeCountHelper;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/treecensus/reports")
public class TreesCountReportController {

	@Autowired
	private Environment env;
	@Autowired
	private JasperReportService jasperReportService;
	@Autowired
	HttpSession httpsession;
	@Autowired
	TreeCountServ treeCountServ;
	
	public static final Logger logger = LoggerFactory.getLogger(TreesCountReportController.class);
	JasperPrint jasperPrint;
	
	public UserBean getSessionUser()
	{
		return  (UserBean) httpsession.getAttribute("userBeanObj");
	}
	
	@RequestMapping(value = "/numberoftrees", method = { RequestMethod.GET, RequestMethod.POST })
	public String treesCountReport(Model model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, @ModelAttribute("reportTreeCount") ReportFilterDto reportFilterBean) {
		jasperPrint = null;
		try {
			System.out.println("Species Id :: " + reportFilterBean.getTreespeciesId());
			List<Object[]> treeCountData = treeCountServ.getTreeCountData(new TtTreeSurveyDetails(), new TmCmLookupDet(), getSessionUser().getUlbId(),
					reportFilterBean.getFromDate(), reportFilterBean.getToDate(), reportFilterBean.getTreespeciesId(), reportFilterBean.getLocationId(), 
					reportFilterBean.getTreeCityNm(), reportFilterBean.getTreeWard(), reportFilterBean.getTreeZone());
			
			TmUlb uldData = treeCountServ.getUlbName(getSessionUser().getUlbId());
			String ulbCity = treeCountServ.getUlbCity(uldData.getLookupDetHierIdCity());
			System.out.println("Ulb City Id");
			TreeCountHelper reptHelper = new TreeCountHelper();
			List<TreeCountBean> rptList =  reptHelper.getReportLstObj(treeCountData);
			System.out.println(" rptList "+rptList.size());
			
			TreeCountReport treeCount = new TreeCountReport();
			treeCount.setTreeCount(rptList);
			
			HashMap<String, Object> reportParams = new HashMap<String, Object>();
			reportParams.put("SUBREPORT_DIR", env.getProperty("jasper.report.path").concat("/treecensus/")); //.concat("treeregsubone.jasper")
			
			reportParams.put("ULB_NM", uldData.getUlbNameEn().toUpperCase());
			reportParams.put("REP_NM", "Number of trees".toUpperCase());
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
			
			List<TreeCountReport> reportObj = new ArrayList<TreeCountReport>();
			reportObj.add(treeCount);
			System.out.println(reportObj.size()+  " Rpws ");
			JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(reportObj);
			JasperReport jasperFile = jasperReportService.getJasperFile("treecensus","numberOfTrees");
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFile,reportParams,jrbean); //jrbean //new JREmptyDataSource()
			
			jasperReportService.generateReportPDF(response,  jasperPrint);
			//CWZL
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
