package com.innowave.mahaulb.repository.treecensus.repository.reports;

import java.util.ArrayList;
import java.util.List;

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

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;


@Repository
@Transactional
public class TrecensusYearWiseRepoImpl implements TrecensusYearWiseRepo {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Object[]> getYearlyTreecensusData(TtTreeSurveyDetails ttTreeSurveyDetails, TmCmLookupDet tmCmLookupDet, int ulbIdAuto,
			String frDate, String toDate, int treeSpecies, String treeFamily) {
		String dateFrom = null, dateTo = null;
		Session session = sessionFactory.getCurrentSession();
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT to_char(tsd.surveyDate,'YYYY') as Year, tn.treeFamNameEn, tn.treeFamNameRg , ");
		sb.append(" tmm.treemasDescEn, tmm.treemasDescMh, case when tmm.status = 0 then 'Active' else 'Inactive' end as status"); //to_char(tmm.status, '999') as status
		sb.append(" FROM TtTreeSurveyDetails tsd, TmTreeNameMaster tn,");
		sb.append(" TmTreeMasterMas tmm, TmCmLookupDet ld, TmCmLookup l ");
		sb.append(" WHERE tsd.tmTreeNameMaster =  tn.treenameId ");
		sb.append(" and tmm.ttLookupDet = ld.lookupDetId ");
		sb.append(" and ld.tmCmLookup = l.lookupId ");
		sb.append("	and tsd.treemasIdTsm = tmm.treemasId ");
		sb.append(" and tsd.ulbId = :uId ");
		sb.append(" and date_trunc('day',tsd.surveyDate) between " );
		sb.append(" to_date(:start, 'yyyy-MM-dd') and  to_date(:end, 'yyyy-MM-dd') ");
		//int treeSpecies, 
		if (treeSpecies != 0)
		{
			sb.append(" and tsd.TreemasIdTsm = :tsm");
		}
		//int treeFamily, 
		if (!treeFamily.equals("")) {
			sb.append(" and ( tn.treeFamNameEn = :tnId or tn.treeFamNameRg = :tnId )");
		}
		sb.append(" ORDER BY tsd.treeSurveyId ");
		String sql = sb.toString();
		
		Query q = session.createQuery(sql);
		sb = null;
		
		/*try {
			dateFrom = DateTimeZoneHelper.changeStrDateFormat(frDate, "dd/MM/yyyy", "yyyy-MM-dd");
			dateTo = DateTimeZoneHelper.changeStrDateFormat(toDate, "dd/MM/yyyy", "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
		}*/

		q.setParameter("uId", ulbIdAuto);
		q.setParameter("start", dateFrom);
		q.setParameter("end", dateTo);
		if (treeSpecies != 0)
			q.setParameter("tsm", treeSpecies);
		if (!treeFamily.equals(""))
			q.setParameter("tnId", treeFamily);


		List<Object[]> lstObj = new ArrayList<Object[]>();
		lstObj = (List<Object[]>) q.list();
		return lstObj;
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