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
import com.innowave.mahaulb.service.treecensus.dto.reports.YearWiseDataBean;
import com.innowave.mahaulb.service.treecensus.dto.reports.YearWiseReport;
import com.innowave.mahaulb.service.treecensus.service.repots.TrecensusYearWiseServ;
import com.innowave.mahaulb.web.treecensus.helper.YearlyReportHelper;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/treecensus/reports")
public class YearWiseReportController {
	@Autowired
	private Environment env;
	@Autowired
	private JasperReportService jasperReportService;
	@Autowired
	HttpSession httpsession;
	@Autowired
	TrecensusYearWiseServ trecensusYearWiseServ;
	
	public static final Logger logger = LoggerFactory.getLogger(YearWiseReportController.class);
	JasperPrint jasperPrint;
	
	public UserBean getSessionUser()
	{
		return  (UserBean) httpsession.getAttribute("userBeanObj");
	}
	
	@RequestMapping(value = "/reportyearwise", method = { RequestMethod.GET, RequestMethod.POST })
	public String yearWiseReport(Model model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, @ModelAttribute("reportYearwise") ReportFilterDto reportFilterBean) {
		jasperPrint = null;
		try {
			List<Object[]> yearlyData = trecensusYearWiseServ.getYearlyTreecensusData(new TtTreeSurveyDetails(), new TmCmLookupDet(), getSessionUser().getUlbId(),
					reportFilterBean.getFromDate(), reportFilterBean.getToDate(), reportFilterBean.getTreespeciesId(), reportFilterBean.getTreeFamily());
			
			TmUlb uldData = trecensusYearWiseServ.getUlbName(getSessionUser().getUlbId());
			YearlyReportHelper reptHelper = new YearlyReportHelper();
			List<YearWiseDataBean> rptList =  reptHelper.getReportLstObj(yearlyData);
			System.out.println(" rptList "+rptList.size());
			
			YearWiseReport yearWiseData = new YearWiseReport();
			yearWiseData.setYearWiseData(rptList);
			
			HashMap<String, Object> reportParams = new HashMap<String, Object>();
			reportParams.put("SUBREPORT_DIR", env.getProperty("jasper.report.path").concat("/treecensus/")); //.concat("treeregsubone.jasper")
			
			reportParams.put("ULB_NM", uldData.getUlbNameEn().toUpperCase());
			reportParams.put("REP_NM", "Year Wise Comparison of Tree Census".toUpperCase());
			reportParams.put("FR_DT",reportFilterBean.getFromDate());
			reportParams.put("TO_DT", reportFilterBean.getToDate());
	
			List<YearWiseReport> reportObj = new ArrayList<YearWiseReport>();
			reportObj.add(yearWiseData);
			System.out.println(reportObj.size()+  " Rpws ");
			JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(reportObj);
			JasperReport jasperFile = jasperReportService.getJasperFile("treecensus","yearWiseComparison");
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFile,reportParams,jrbean); //jrbean //new JREmptyDataSource()
			
			jasperReportService.generateReportPDF(response,  jasperPrint);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
