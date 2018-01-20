package com.innowave.mahaulb.service.treecensus.master.treemastermas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.innowave.mahaulb.common.dao.TmCmLookup;
import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.service.LookupDetServ;
import com.innowave.mahaulb.common.service.utils.FileDownloadService;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeMasterMas;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeNameMaster;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyUploadList;
import com.innowave.mahaulb.repository.treecensus.master.TreeMasterMasRepo;
import com.innowave.mahaulb.repository.treecensus.repo.GetTreeSeqNoRepo;
import com.innowave.mahaulb.service.treecensus.bean.TreeSurveyDetailsBean;
import com.innowave.mahaulb.service.treecensus.bean.TtTreeSurveyDetailsBean;

 
@Service("treeMasterMasServ")
@Transactional
public class TreeMasterMasServImpl implements TreeMasterMasServ {

	@Autowired
	private TreeMasterMasRepo treeMasterMasRepo;
	
	@Autowired
	LookupDetServ lookupDetServ;
	
	@Autowired
	FileDownloadService fileDownloadService;
	
	@Autowired
	GetTreeSeqNoRepo getTreeSeqNoRepo;
	
	@Override
	public int save(TmTreeMasterMas tmTreeMasterMas) {
		 return (Integer) treeMasterMasRepo.save(tmTreeMasterMas);
	}

	@Override
	public List<TmTreeMasterMas> getTreeMasterMasList(TmTreeMasterMas tmTreeMasterMas) {
		 return treeMasterMasRepo.getTreeMasterMasList(tmTreeMasterMas);
	}

	@Override
	public void delete(TmTreeMasterMas tmTreeMasterMas) {
		treeMasterMasRepo.delete(tmTreeMasterMas);
	}

	@Override
	public void update(TmTreeMasterMas tmTreeMasterMas) {
		treeMasterMasRepo.update(tmTreeMasterMas);
		
	}
		
	@Override
	public Set<TmTreeMasterMas> getTreeMasterDetails(String prefix) {
		return treeMasterMasRepo.getTreeMasterDetails(prefix);
	}

	
	@Override
	public int saveTreeMasterDetailsServ(TreeSurveyDetailsBean treeSurveyDetailsBean)
	{
		TmTreeNameMaster tTNM = new TmTreeNameMaster();
		tTNM.setTreeComNameEn(treeSurveyDetailsBean.getTreeComNameEn());
		tTNM.setUlbId(treeSurveyDetailsBean.getUlbId());
		tTNM.setTreeComNameRg(treeSurveyDetailsBean.getTreeComNameRg());
		tTNM.setTreeFamNameEn(treeSurveyDetailsBean.getTreeFamNameEn());
		tTNM.setTreeFamNameRg(treeSurveyDetailsBean.getTreeFamNameRg());
		tTNM.setTreeSciNameEn(treeSurveyDetailsBean.getTreeSciNameEn());
		tTNM.setTreeSciNameRg(treeSurveyDetailsBean.getTreeSciNameRg());
		tTNM.setTreeVerNameEn(treeSurveyDetailsBean.getTreeVerNameEn());
		tTNM.setTreeVerNameRg(treeSurveyDetailsBean.getTreeVerNameRg());
		
		tTNM.setTreemasIdFnm(treeSurveyDetailsBean.getLookupDetIdFnm());   //Flower
		tTNM.setTreemasIdCom(treeSurveyDetailsBean.getLookupDetIdCom());   //colour
		tTNM.setTreemasIdFrm(treeSurveyDetailsBean.getLookupDetIdFrm());  //fruit
		tTNM.setTreemasIdSma(treeSurveyDetailsBean.getLookupDetIdSma());   //shape
		tTNM.setTreemasIdOdm(treeSurveyDetailsBean.getLookupDetIdOdm());   //odour
		tTNM.setTreemasIdTst(treeSurveyDetailsBean.getLookupDetIdTst());   //tree status
		tTNM.setTreemasIdTsm(treeSurveyDetailsBean.getLookupDetIdTsm());   //tree species master
		tTNM.setTreemasIdBsm(treeSurveyDetailsBean.getLookupDetIdBsm());   // bark
		tTNM.setTreemasIdLsm(treeSurveyDetailsBean.getLookupDetIdLsm());   //leaf shape
		tTNM.setTreemasIdLcm(treeSurveyDetailsBean.getLookupDetIdLcm());  //leaf colour
		tTNM.setTreemasIdTms(treeSurveyDetailsBean.getLookupDetIdTms());  //texture
		
		tTNM.setLookupDetAesthetic(treeSurveyDetailsBean.getLookupDetAesthetic());
		tTNM.setLookupDetCultural(treeSurveyDetailsBean.getLookupDetCultural());
		tTNM.setLookupDetEcological(treeSurveyDetailsBean.getLookupDetEcological());
		tTNM.setLookupDetEconomical(treeSurveyDetailsBean.getLookupDetEconomical());
		tTNM.setStatus(1);
		tTNM.setCreatedBy(treeSurveyDetailsBean.getCreatedBy());
		tTNM.setCreatedDate(treeSurveyDetailsBean.getCreatedDate());
		tTNM.setDeviceFrom(treeSurveyDetailsBean.getDeviceFrom());
		tTNM.setIpAddress(treeSurveyDetailsBean.getIpAddress());
		tTNM.setMacId(treeSurveyDetailsBean.getMacId());
		 
		return (int) treeMasterMasRepo.saveTreeMasterDetailsRepo(tTNM);
	}
	
	
	@Override
	public Set<TmTreeNameMaster> getTreeNameDetailsServ(String treeNameType, String searchString) {
		return treeMasterMasRepo.getTreeNameDetailsServ(treeNameType, searchString);
	}

	@Override
	public int saveApplicationSurveyInspector(TtTreeSurveyDetailsBean ttTreeSurveyDetails) {
		TtTreeSurveyDetails tTSD = new TtTreeSurveyDetails();
		tTSD.setUlbId(ttTreeSurveyDetails.getUlbId());
		tTSD.setTreeSurveyId(ttTreeSurveyDetails.getTreeSurveyId());
		tTSD.setSurveyNumber(ttTreeSurveyDetails.getSurveyNumber());
		tTSD.setSurveyDate(ttTreeSurveyDetails.getSurveyDate());
		tTSD.setTreeIdentificationNo(ttTreeSurveyDetails.getTreeIdentificationNo());
		tTSD.setTmTreeNameMaster(ttTreeSurveyDetails.getTmTreeNameMaster());
		tTSD.setRefNo(ttTreeSurveyDetails.getSeqNO());
		
		tTSD.setTreemasIdCom(ttTreeSurveyDetails.getTreemasIdCom());	//colour
		tTSD.setTreemasIdFrm(ttTreeSurveyDetails.getTreemasIdFrm());	//fruit
		tTSD.setTreemasIdBsm(ttTreeSurveyDetails.getTreemasIdBsm());	//bark
		tTSD.setTreemasIdSma(ttTreeSurveyDetails.getTreemasIdSma());	//shape master
		tTSD.setTreemasIdTst(ttTreeSurveyDetails.getTreemasIdTst());	//tree status
		tTSD.setTreemasIdOdm(ttTreeSurveyDetails.getTreemasIdOdm());	//odour
		tTSD.setTreemasIdFnm(ttTreeSurveyDetails.getTreemasIdFnm());   //flower
		tTSD.setTreemasIdTsm(ttTreeSurveyDetails.getTreemasIdTsm());	//TreeSpecies
		tTSD.setTreemasIdLsm(ttTreeSurveyDetails.getTreemasIdLsm());    //leaf shape
		tTSD.setTreemasIdLcm(ttTreeSurveyDetails.getTreemasIdLcm());    //Leaf colour
		tTSD.setTreemasIdTms(ttTreeSurveyDetails.getTreemasIdTms());    //Texture
		
		tTSD.setGirthAtBreastHieght(ttTreeSurveyDetails.getGirthAtBreastHieght());
		tTSD.setHieght(ttTreeSurveyDetails.getHieght());
		tTSD.setApproxAge(ttTreeSurveyDetails.getApproxAge());
		tTSD.setCanopyWidth(ttTreeSurveyDetails.getCanopyWidth());
		tTSD.setMsebCtcNo(ttTreeSurveyDetails.getMsebCtcNo());
		tTSD.setSizeValue(ttTreeSurveyDetails.getSizeValue());
		tTSD.setLocation(ttTreeSurveyDetails.getLocation());
		tTSD.setApartmentComplex(ttTreeSurveyDetails.getApartmentComplex());
		tTSD.setRoad(ttTreeSurveyDetails.getRoad());
		tTSD.setBuilding(ttTreeSurveyDetails.getBuilding());
		tTSD.setLocality(ttTreeSurveyDetails.getLocality());
		tTSD.setLatitude(ttTreeSurveyDetails.getLatitude());
		tTSD.setLongitude(ttTreeSurveyDetails.getLongitude());
		tTSD.setObservationRemarks(ttTreeSurveyDetails.getObservationRemarks());
		tTSD.setLookupDetIdOlt(ttTreeSurveyDetails.getLookupDetIdOlt());
		tTSD.setLookupDetIdRsu(ttTreeSurveyDetails.getLookupDetIdRsu());
		tTSD.setLookupDetHierIdAwz1(ttTreeSurveyDetails.getLookupDetHierIdAwz1());
		tTSD.setLookupDetHierIdAwz2(ttTreeSurveyDetails.getLookupDetHierIdAwz2());
		
		tTSD.setCreatedBy(ttTreeSurveyDetails.getCreatedBy());
		tTSD.setCreatedDate(ttTreeSurveyDetails.getCreatedDate());
		tTSD.setMacId(ttTreeSurveyDetails.getMacId());
		tTSD.setDeviceFrom(ttTreeSurveyDetails.getDeviceFrom());
		tTSD.setIpAddress(ttTreeSurveyDetails.getIpAddress());
		
		SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
		
		int modId = getTreeSeqNoRepo.getModId("TRR");
		String ulbCode = getTreeSeqNoRepo.getUlbShortsCode(ttTreeSurveyDetails.getUlbId());
		Date fromDate = getTreeSeqNoRepo.getFromFinancialDate(ttTreeSurveyDetails.getCreatedDate());
		Date toDate = getTreeSeqNoRepo.getFinancialDate(ttTreeSurveyDetails.getCreatedDate());
		
		/*String fDt = sm.format(fromDate);
		String tDt = sm.format(toDate);*/
		
		char year = 'F';
		//Date txDt = DateTimeZoneHelper.getSysDate();
		Date txDt=null;
		
		String SeqNo = null;
		String newConnectionNo = null;
		
		try {
			SeqNo = getTreeSeqNoRepo.getAutoConnectionLoiNo(modId, ttTreeSurveyDetails.getUlbId(), "tt_tree_survey_details", "survey_number", year, txDt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String ulbshortCode="";
        if(ulbCode.length()<4)
        {
                ulbshortCode=ulbCode+0;
        }
        else
        {
                ulbshortCode=ulbCode;
        }
        
        SimpleDateFormat frmtDt = new SimpleDateFormat("yy");
        
        String curYr = frmtDt.format(fromDate);
        String futYr = frmtDt.format(toDate);
        
        String sequenceNo = "000000000".substring(SeqNo.toString().length()) + SeqNo;

        newConnectionNo = ulbshortCode+curYr+futYr+sequenceNo;
		tTSD.setSurveyNumber(newConnectionNo);
        ttTreeSurveyDetails.setSurveyNumber(newConnectionNo);
        int a = (int) treeMasterMasRepo.saveApplicationSurveyInspector(tTSD);
		
        String url = null ;
		if(ttTreeSurveyDetails.getFile() != null){
			 url = fileDownloadService.uploadFile(ttTreeSurveyDetails.getFile());
		}
		
		TtTreeSurveyUploadList ttTreeSurveyUploadList = new TtTreeSurveyUploadList();
		ttTreeSurveyUploadList.setTtTreeSurveyDetails(new TtTreeSurveyDetails(a));
		ttTreeSurveyUploadList.setUlbId(ttTreeSurveyDetails.getUlbId());
		if(url != null){
			ttTreeSurveyUploadList.setUploadedDesc(url);
		}
		ttTreeSurveyUploadList.setStatus(1);
		ttTreeSurveyUploadList.setCreatedBy(ttTreeSurveyDetails.getCreatedBy());
		ttTreeSurveyUploadList.setCreatedDate(ttTreeSurveyDetails.getCreatedDate());
		ttTreeSurveyUploadList.setMacId(ttTreeSurveyDetails.getMacId());
		ttTreeSurveyUploadList.setDeviceFrom(ttTreeSurveyDetails.getDeviceFrom());
		ttTreeSurveyUploadList.setIpAddress(ttTreeSurveyDetails.getIpAddress());
		
		treeMasterMasRepo.saveImageUrl(ttTreeSurveyUploadList);
		return a;
		
	}
	
	@Override
	public int saveApplicationSurveyDetails(TtTreeSurveyDetailsBean ttTreeSurveyDetails) {
		
		TtTreeSurveyDetails tTSD = new TtTreeSurveyDetails();
		tTSD.setUlbId(ttTreeSurveyDetails.getUlbId());
		tTSD.setTreeSurveyId(ttTreeSurveyDetails.getTreeSurveyId());
		tTSD.setSurveyNumber(ttTreeSurveyDetails.getSurveyNumber());
		tTSD.setSurveyDate(ttTreeSurveyDetails.getSurveyDate());
		tTSD.setTreeIdentificationNo(ttTreeSurveyDetails.getTreeIdentificationNo());
		tTSD.setTmTreeNameMaster(ttTreeSurveyDetails.getTmTreeNameMaster());
		
		tTSD.setTreemasIdCom(ttTreeSurveyDetails.getTreemasIdCom());	//colour
		tTSD.setTreemasIdFrm(ttTreeSurveyDetails.getTreemasIdFrm());	//fruit
		tTSD.setTreemasIdBsm(ttTreeSurveyDetails.getTreemasIdBsm());	//bark
		tTSD.setTreemasIdSma(ttTreeSurveyDetails.getTreemasIdSma());	//shape master
		tTSD.setTreemasIdTst(ttTreeSurveyDetails.getTreemasIdTst());	//tree status
		tTSD.setTreemasIdOdm(ttTreeSurveyDetails.getTreemasIdOdm());	//odour
		tTSD.setTreemasIdFnm(ttTreeSurveyDetails.getTreemasIdFnm());   //flower
		tTSD.setTreemasIdTsm(ttTreeSurveyDetails.getTreemasIdTsm());	//TreeSpecies
		tTSD.setTreemasIdLsm(ttTreeSurveyDetails.getTreemasIdLsm());    //leaf shape
		tTSD.setTreemasIdLcm(ttTreeSurveyDetails.getTreemasIdLcm());    //Leaf colour
		tTSD.setTreemasIdTms(ttTreeSurveyDetails.getTreemasIdTms());    //Texture
		
		tTSD.setGirthAtBreastHieght(ttTreeSurveyDetails.getGirthAtBreastHieght());
		tTSD.setHieght(ttTreeSurveyDetails.getHieght());
		tTSD.setApproxAge(ttTreeSurveyDetails.getApproxAge());
		tTSD.setCanopyWidth(ttTreeSurveyDetails.getCanopyWidth());
		tTSD.setMsebCtcNo(ttTreeSurveyDetails.getMsebCtcNo());
		tTSD.setSizeValue(ttTreeSurveyDetails.getSizeValue());
		tTSD.setLocation(ttTreeSurveyDetails.getLocation());
		tTSD.setApartmentComplex(ttTreeSurveyDetails.getApartmentComplex());
		tTSD.setRoad(ttTreeSurveyDetails.getRoad());
		tTSD.setBuilding(ttTreeSurveyDetails.getBuilding());
		tTSD.setLocality(ttTreeSurveyDetails.getLocality());
		tTSD.setLatitude(ttTreeSurveyDetails.getLatitude());
		tTSD.setLongitude(ttTreeSurveyDetails.getLongitude());
		tTSD.setObservationRemarks(ttTreeSurveyDetails.getObservationRemarks());
		tTSD.setLookupDetIdOlt(ttTreeSurveyDetails.getLookupDetIdOlt());
		tTSD.setCreatedBy(ttTreeSurveyDetails.getCreatedBy());
		tTSD.setCreatedDate(ttTreeSurveyDetails.getCreatedDate());
		tTSD.setMacId(ttTreeSurveyDetails.getMacId());
		tTSD.setDeviceFrom(ttTreeSurveyDetails.getDeviceFrom());
		tTSD.setIpAddress(ttTreeSurveyDetails.getIpAddress());
		
		int a = (int) treeMasterMasRepo.saveApplicationSurveyDetails(tTSD);
		
		String url = null ;
		if(ttTreeSurveyDetails.getFile() != null){
			 url = fileDownloadService.uploadFile(ttTreeSurveyDetails.getFile());
		}
		
		TtTreeSurveyUploadList ttTreeSurveyUploadList = new TtTreeSurveyUploadList();
		ttTreeSurveyUploadList.setTtTreeSurveyDetails(new TtTreeSurveyDetails(a));
		ttTreeSurveyUploadList.setUlbId(ttTreeSurveyDetails.getUlbId());
		if(url != null){
			ttTreeSurveyUploadList.setUploadedDesc(url);
		}
		ttTreeSurveyUploadList.setStatus(1);
		ttTreeSurveyUploadList.setCreatedBy(ttTreeSurveyDetails.getCreatedBy());
		ttTreeSurveyUploadList.setCreatedDate(ttTreeSurveyDetails.getCreatedDate());
		ttTreeSurveyUploadList.setMacId(ttTreeSurveyDetails.getMacId());
		ttTreeSurveyUploadList.setDeviceFrom(ttTreeSurveyDetails.getDeviceFrom());
		ttTreeSurveyUploadList.setIpAddress(ttTreeSurveyDetails.getIpAddress());
		
		treeMasterMasRepo.saveImageUrl(ttTreeSurveyUploadList);
		return a;
		
	}
	
	@Override
	public List<TmTreeMasterMas> getMasterDataListServ(String prefix, String searchString,int ulbIdAuto) {
		return treeMasterMasRepo.getMasterDataListServ(prefix,searchString,ulbIdAuto);
	}

	@Override
	public String getlookupDetData(int ulbId, String prefix) {
		
		List<TreeSurveyDetailsBean> treeSurveyDetailsBean = new ArrayList<TreeSurveyDetailsBean>();
		
		TmCmLookup tmCmLookup = treeMasterMasRepo.getLookupId(prefix);
		List<TmCmLookupDet> tmCmLookupDet = treeMasterMasRepo.getLookupDetId(ulbId, tmCmLookup.getLookupId());
		
		for(TmCmLookupDet obj : tmCmLookupDet){
			TreeSurveyDetailsBean tSDB = new TreeSurveyDetailsBean();
			tSDB.setLookupDetId(obj.getLookupDetId());
			tSDB.setLookupDetName(obj.getLookupDetDescEn());
			tSDB.setUlbId(obj.getUlbId());
			treeSurveyDetailsBean.add(tSDB);
		}
		
		Gson gson = new Gson();
		String str = gson.toJson(treeSurveyDetailsBean);
		//return JsonResponseHelper.getJSONResponseString(str);
		return null;
	}

	@Override
	public Set<TtTreeSurveyDetails> getDataBySrnNumber(String treeNameType, String searchString) {
		return treeMasterMasRepo.getDataBySrnNumber(treeNameType, searchString);
		
	}
	

}
