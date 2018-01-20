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

import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.common.service.LookupDetServ;
import com.innowave.mahaulb.common.service.beans.UserBean;
import com.innowave.mahaulb.common.service.utils.JasperReportService;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeNameMaster;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;
import com.innowave.mahaulb.service.treecensus.dto.reports.ReportFilterDto;
import com.innowave.mahaulb.service.treecensus.dto.reports.SurveyRegisterReport;
import com.innowave.mahaulb.service.treecensus.dto.reports.registerDataListOneBean;
import com.innowave.mahaulb.service.treecensus.dto.reports.registerDataListTwoBean;
import com.innowave.mahaulb.service.treecensus.service.repots.TrecensusRegRepoServ;
import com.innowave.mahaulb.web.treecensus.helper.ReportHelper;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/treecensus/reports")
public class TreeCensusRegisterReportController {
	@Autowired
	private Environment env;
	@Autowired
	private JasperReportService jasperReportService;
	@Autowired
	HttpSession httpsession;
	@Autowired
	TrecensusRegRepoServ trecensusRegRepoServ;

	
	@Autowired
	LookupDetServ lookupDetServ;

	public static final Logger logger = LoggerFactory.getLogger(TreeCensusRegisterReportController.class);
	JasperPrint jasperPrint;

	public UserBean getSessionUser()
	{
		return  (UserBean) httpsession.getAttribute("userBeanObj");
		
	}
	
	@RequestMapping(value = "/reporttreecensusreg", method = { RequestMethod.GET, RequestMethod.POST })
	public String treeSueveyRegi(Model model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, @ModelAttribute("registerReport") ReportFilterDto reportFilterBean) {
		jasperPrint = null;
		String surveyDate = null;

		try {
			//Map<Integer, String> lookupData = trecensusRegRepoServ.getTreeMasterData("TRM");

			
			//System.out.println(" ****** "+ lookupData.size() +" ****** ");
			List<Object[]>  ttTreeSurveyReportData = trecensusRegRepoServ.getSurveyRequestData(new TtTreeSurveyDetails(), new TmTreeNameMaster(), getSessionUser().getUlbId(), 
					reportFilterBean.getFromDate(), reportFilterBean.getToDate(), reportFilterBean.getSurveyNm(), reportFilterBean.getSurveyDt(), 
					reportFilterBean.getTreespeciesId(), reportFilterBean.getTreeFamily(), 0, 0, reportFilterBean.getSocietyNm(), reportFilterBean.getMseb_ctcNo(),
					reportFilterBean.getPropOwnerNo(), reportFilterBean.getTreeScientificNm(), reportFilterBean.getTreeVernacularNm(), reportFilterBean.getTreeCommonNm());
			TmUlb uldData = trecensusRegRepoServ.getUlbName(getSessionUser().getUlbId());
			ReportHelper reptHelper = new ReportHelper(lookupDetServ);
			List<registerDataListOneBean> rpt1List =  reptHelper.getReportOneLstObj(ttTreeSurveyReportData);
			System.out.println(" rpt1List "+rpt1List.size());
			
			List<registerDataListTwoBean> rpt2List =  reptHelper.getReportTwoLstObj(ttTreeSurveyReportData);
			System.out.println(" rpt2List "+rpt2List.size());
			
			SurveyRegisterReport reportData = new SurveyRegisterReport();
			
			reportData.setListOne(rpt1List);
			reportData.setListTwo(rpt2List);
			
			HashMap<String, Object> reportParams = new HashMap<String, Object>();
			reportParams.put("SUBREPORT_DIR", env.getProperty("jasper.report.path").concat("/treecensus/")); //.concat("treeregsubone.jasper")
			
			reportParams.put("ULB_NM", uldData.getUlbNameEn().toUpperCase());
			reportParams.put("REP_NM", "Tree Census Register".toUpperCase());
			reportParams.put("FR_DT",reportFilterBean.getFromDate());
			reportParams.put("TO_DT", reportFilterBean.getToDate());
			
			List<SurveyRegisterReport> reportObj = new ArrayList<SurveyRegisterReport>();
			reportObj.add(reportData);
			System.out.println(reportObj.size()+  " Rpws ");
			JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(reportObj);
			JasperReport jasperFile = jasperReportService.getJasperFile("treecensus","mainReport");
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFile,reportParams,jrbean); //jrbean //new JREmptyDataSource()
			
			jasperReportService.generateReportPDF(response,  jasperPrint);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
