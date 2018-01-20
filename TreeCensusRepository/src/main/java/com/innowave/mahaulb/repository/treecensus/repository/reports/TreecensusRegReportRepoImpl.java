package com.innowave.mahaulb.repository.treecensus.repository.reports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeNameMaster;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;

@Repository
@Transactional
public class TreecensusRegReportRepoImpl implements TreecensusRegReportRepo {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Object[]> getSurveyRequestData(TtTreeSurveyDetails ttTreeSurveyDetails, TmTreeNameMaster tmTreeNameMaster, int ulbIdAuto, String frDate, String toDate, String surveyNm, String surveyDate,
			int treeSpecies, String treeFamily, int ward, int zone, String societyNm, String mseb_ctcNo, String propOwnerNo, String treeScientificNm, String treeVernaNm, String treeCommonNm) {
		String dateFrom = null, dateTo = null, surDate = null;
		Session session = sessionFactory.getCurrentSession();
		
		StringBuilder sb = new StringBuilder();
		sb.append("Select ");
		sb.append(" tsd.surveyNumber, ");
		sb.append(" to_char(date_trunc('day',tsd.surveyDate), 'dd-MM-yyyy') as surveyDate, ");
		sb.append(" tsd.ownerName, ");
		sb.append(" tsd.apartmentComplex, ");
		sb.append(" tsd.ownerAddress, ");
		sb.append(" tsd.msebCtcNo, ");
		sb.append(" Tsm.treemasDescEn, ");
		sb.append(" Tsm.treemasDescMh, ");
		sb.append(" tn.treeSciNameEn, ");
		sb.append(" tn.treeSciNameRg, ");
		sb.append(" tn.treeVerNameEn, ");
		sb.append(" tn.treeVerNameRg, ");
		sb.append(" tn.treeComNameEn, ");
		sb.append(" tn.treeComNameRg, ");
		sb.append(" Bsm.treemasDescEn, ");
		sb.append(" Bsm.treemasDescMh, ");
		sb.append(" Lsm.treemasDescEn, ");
		sb.append(" Lsm.treemasDescMh, ");
		sb.append(" Lcm.treemasDescEn, ");
		sb.append(" Lcm.treemasDescMh, ");
		sb.append(" Tms.treemasDescEn, ");
		sb.append(" Tms.treemasDescMh, ");
		sb.append(" Fnm.treemasDescEn, ");
		sb.append(" Fnm.treemasDescMh, ");
		sb.append(" Frm.treemasDescEn, ");
		sb.append(" Frm.treemasDescMh, ");
		sb.append(" Sma.treemasDescEn, ");
		sb.append(" Sma.treemasDescMh, ");
		sb.append(" tsd.sizeValue, ");
		sb.append(" tsd.hieght, ");
		sb.append(" tsd.approxAge, ");
		sb.append(" Odm.treemasDescEn, ");
		sb.append(" Odm.treemasDescMh, ");
		sb.append(" Tst.treemasDescEn, ");
		sb.append(" Tst.treemasDescMh, ");
		sb.append(" tn.treeFamNameEn, ");
		sb.append(" tn.treeFamNameRg, ");
		sb.append(" tsd.girthAtBreastHieght, ");
		sb.append(" tsd.canopyWidth, ");
		sb.append(" Com.treemasDescEn, ");
		sb.append(" Com.treemasDescMh ");
		sb.append(" from ");
		sb.append(" TtTreeSurveyDetails tsd, ");
		sb.append(" TmTreeMasterMas Tsm, ");
		sb.append(" TmTreeMasterMas Lsm, ");
		sb.append(" TmTreeMasterMas Bsm, ");
		sb.append(" TmTreeMasterMas Tms, ");
		sb.append(" TmTreeMasterMas Lcm, ");
		sb.append(" TmTreeMasterMas Com, ");
		sb.append(" TmTreeMasterMas Fnm, ");
		sb.append(" TmTreeMasterMas Frm, ");
		sb.append(" TmTreeMasterMas Odm, ");
		sb.append(" TmTreeMasterMas Sma, ");
		sb.append(" TmTreeMasterMas Tst, ");
		sb.append(" TmTreeNameMaster tn ");
		sb.append(" where tsd.tmTreeNameMaster = tn.treenameId ");
		sb.append(" and tsd.treemasIdTsm = Tsm.treemasId ");
		sb.append(" and tsd.treemasIdLsm = Lsm.treemasId ");
		sb.append(" and tsd.treemasIdTsm = Tsm.treemasId ");
		sb.append(" and tsd.treemasIdBsm = Bsm.treemasId ");
		sb.append(" and tsd.treemasIdTms = Tms.treemasId ");
		sb.append(" and tsd.treemasIdLcm = Lcm.treemasId ");
		sb.append(" and tsd.treemasIdCom = Com.treemasId ");
		sb.append(" and tsd.treemasIdFnm = Fnm.treemasId ");
		sb.append(" and tsd.treemasIdFrm = Frm.treemasId ");
		sb.append(" and tsd.treemasIdOdm = Odm.treemasId ");
		sb.append(" and tsd.treemasIdSma = Sma.treemasId ");
		sb.append(" and tsd.treemasIdTst = Tst.treemasId ");
		sb.append(" and tsd.ulbId = :uId ");
		sb.append(" and date_trunc('day',tsd.surveyDate) between " );
		sb.append(" to_date(:start, 'YYYY-MM-DD') and  to_date(:end, 'yyyy-MM-dd') ");
		if (!surveyDate.equals("")) {
			sb.append(" or to_date(:surDt, 'YYYY-MM-DD') between " );
			sb.append(" to_date(:start, 'yyyy-MM-dd') and  to_date(:end, 'yyyy-MM-dd') ");
		}
		//surveyNm
		if (surveyNm.length() != 0)
		{
			sb.append(" and tsd.surveyNumber = :tsn");
		}
		//int treeSpecies, 
		if (treeSpecies != 0)
		{
			sb.append(" and tsd.TreemasIdTsm = :tsm");
		}
		//int treeFamily, 
		if (!treeFamily.equals("")) {
			sb.append(" and tn.treeFamNameEn = :tnId");
		}
		//int ward,
		//int zone, 		
		//String societyNm, 
		if (!societyNm.equals("")) {
			sb.append(" and  tsd.apartmentComplex = :sociNm ");
		}
		//String mseb_ctcNo, 
		if (!mseb_ctcNo.equals("")) {
			sb.append(" and  tsd.msebCtcNo = :msebctc ");
		}
		//String propOwnerNo, 
		if (!propOwnerNo.equals("")) {
			sb.append(" and  tsd.ownerName = :propName");
		}
		if (!treeCommonNm.equals("")) {
			sb.append(" and  tn.treeComNameEn = :commNm");
		}
		if (!treeVernaNm.equals("")) {
			sb.append(" and  tn.treeVerNameEn = :verNm");
		}
		if (!treeScientificNm.equals("")) {
			sb.append(" and  tn.treeSciNameEn = :sciNm ");
		}

		String sql = sb.toString();
		
		System.out.println(" >>> SQL <<<< "+sql);
		Query q = session.createQuery(sql);
		sb = null;
		System.out.println("Date From - filter :: " + frDate);
		System.out.println("Date To - filter :: " + toDate);
		/*try {
			dateFrom = DateTimeZoneHelper.changeStrDateFormat(frDate, "dd/MM/yyyy", "yyyy-MM-dd");
			dateTo = DateTimeZoneHelper.changeStrDateFormat(toDate, "dd/MM/yyyy", "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		System.out.println("Date From :: " + dateFrom);
		System.out.println("Date To :: " + dateTo);
		
		q.setParameter("uId", ulbIdAuto);
		q.setParameter("start", dateFrom);
		q.setParameter("end", dateTo);
		if (!surveyDate.equals("")) {
			/*try {
				surDate = DateTimeZoneHelper.changeStrDateFormat(surveyDate, "dd/MM/yyyy", "yyyy-MM-dd");
			} catch (ParseException e) {
				e.printStackTrace();
			}*/
			q.setParameter("surDt", surveyDate);
		}
		if (surveyNm.length() != 0) 
			q.setParameter("tsn", surveyNm);
		if (treeSpecies != 0)
			q.setParameter("tsm", treeSpecies);
		if (!treeFamily.equals(""))
			q.setParameter("tnId", treeFamily);
		if (!societyNm.equals(""))
			q.setParameter("sociNm", societyNm);
		
		if (!propOwnerNo.equals(""))
			q.setParameter("propName", propOwnerNo);
		
		if (!mseb_ctcNo.equals(""))
			q.setParameter("msebctc", mseb_ctcNo);
		
		if (!treeScientificNm.equals(""))
			q.setParameter("sciNm", treeScientificNm);
		
		if (!treeVernaNm.equals(""))
			q.setParameter("verNm", treeVernaNm);
		
		if (!treeCommonNm.equals(""))
			q.setParameter("commNm", treeCommonNm);
		
		List<Object[]> lstObj = new ArrayList<Object[]>();
		lstObj = (List<Object[]>) q.list();
		return lstObj;
	}

	@Override
	public Map<Integer, String> getTreeMasterData(String lookupCode) {
		Session session = sessionFactory.getCurrentSession();
		String HQL_QUERY = "select c.treemasId, c.treemasDescEn, c.treemasDescMh from TmCmLookup a, TmCmLookupDet b, TmTreeMasterMas c where a.lookupId = b.lookupDetId and b.lookupDetId = c.treemasId and c.status = 1 and a.flagStateUlb = 'S' and a.lookupCode = :lukupCd";
		Query q = session.createQuery(HQL_QUERY);
		q.setParameter("lukupCd", lookupCode);
		List<Object[]> data = q.getResultList();
		
		Map<Integer, String> returnMap = new HashMap<Integer, String>();
		for (Iterator it = data.iterator(); it.hasNext();) {
			Object[] v = (Object[]) it.next();
			returnMap.put((Integer) v[0], v[1].toString().concat("|")+v[2].toString());
		}
		return returnMap;
	}
	
	public List<TmTreeNameMaster> getTreeMasterName(int ulbIdAuto) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TmTreeNameMaster> searchQuery = builder.createQuery(TmTreeNameMaster.class);
        Root<TmTreeNameMaster> aRoot = searchQuery.from(TmTreeNameMaster.class);
        searchQuery.select(aRoot).where();
        Predicate where = builder.conjunction();
        where = builder.equal(aRoot.get("ulbId"),ulbIdAuto);
        searchQuery = searchQuery.where(where);
		Query<TmTreeNameMaster> q=session.createQuery(searchQuery);
        return q.getResultList();
	}

	@Override
	public TmUlb getUlbName(int ulbIdAuto) {
		TmUlb shortCodeData = new TmUlb();
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TmUlb> searchQuery = builder.createQuery(TmUlb.class);
        Root<TmUlb> aRoot = searchQuery.from(TmUlb.class);
        searchQuery.select(aRoot).where();
        Predicate where = builder.conjunction();
        where = builder.equal(aRoot.get("ulbId"),ulbIdAuto);
        searchQuery = searchQuery.where(where);
        Query<TmUlb> q=session.createQuery(searchQuery);
        shortCodeData=q.getSingleResult();
        return shortCodeData;
	}
}
