package com.innowave.mahaulb.web.treecensus.report;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.innowave.mahaulb.common.service.beans.UserBean;
import com.innowave.mahaulb.common.service.utils.JasperReportService;
import com.innowave.mahaulb.service.treecensus.dto.reports.ReportFilterDto;

import net.sf.jasperreports.engine.JasperPrint;

public class SchBeneficiaryReportController {
	@Autowired
	private Environment env;
	@Autowired
	private JasperReportService jasperReportService;
	@Autowired
	HttpSession httpsession;
	
	public static final Logger logger = LoggerFactory.getLogger(SchSumRepController.class);
	JasperPrint jasperPrint;
	
	public UserBean getSessionUser()
	{
		return  (UserBean) httpsession.getAttribute("userBeanObj");
	}
	
	@RequestMapping(value = "/reportschemebeneficiary", method = { RequestMethod.GET, RequestMethod.POST })
	public String diversityCountReport(Model model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, @ModelAttribute("schemeBeneficiary") ReportFilterDto reportFilterBean) {
		return null;
	}

}
