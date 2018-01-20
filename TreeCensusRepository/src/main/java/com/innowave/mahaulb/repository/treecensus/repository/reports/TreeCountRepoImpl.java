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
import com.innowave.mahaulb.common.dao.TmCmLookupDetHierarchical;
import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;

@Repository
@Transactional
public class TreeCountRepoImpl implements TreeCountRepo {
	@Autowired
	private SessionFactory sessionFactory;
	
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

	@Override
	public List<Object[]> getTreeCountDatav(TtTreeSurveyDetails ttTreeSurveyDetails, TmCmLookupDet tmCmLookupDet,
			int ulbIdAuto, String frDate, String toDate, int treeSpecies, int locationId, int treeCity,
			String treeWard, String treeZone) {
		String dateFrom = null, dateTo = null;
		Session session = sessionFactory.getCurrentSession();
		// case when count(tsd.ttServiceRequest) = 0 then count(tn.treeFamNameEn) else count(tsd.ttServiceRequest) end 
		StringBuilder sb = new StringBuilder();  //count(tn.tree_fam_name_en) as cnt
		sb.append(" SELECT tn.treeFamNameEn, tn.treeFamNameRg , ");
		sb.append(" tmm.treemasDescEn, tmm.treemasDescMh, case when tmm.status = 0 then 'Active' else 'Inactive' end as status, ");
		sb.append(" count(tn.treeFamNameEn) as cnt ");
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
		/*		
		if (locationId != 0) {
			sb.append(" and tsd.location = :loc");
		}

		if (treeCity != 0 ) {
			
		}

		if (!treeWard.equals("")) {
			
		}
		if (!treeZone.equals("")) {
			
		}
		*/
		sb.append(" group by tn.treeFamNameEn, tn.treeFamNameRg , tmm.treemasDescEn, tmm.treemasDescMh, case when tmm.status = 0 then 'Active' else 'Inactive' end ");
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
		List<Object[]> lstObj = new ArrayList<Object[]>();
		lstObj = (List<Object[]>) q.list();
		return lstObj;
	}

	@Override
	public String getUlbCity(Integer lookupDetHierIdCity) {
		//TmCmLookupDetHierarchical shortCodeData = new TmCmLookupDetHierarchical();
		String CityName;
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TmCmLookupDetHierarchical> searchQuery = builder.createQuery(TmCmLookupDetHierarchical.class);
        Root<TmCmLookupDetHierarchical> aRoot = searchQuery.from(TmCmLookupDetHierarchical.class);
        searchQuery.select(aRoot).where();
        Predicate where = builder.conjunction();
        where = builder.equal(aRoot.get("lookupDetHierId"),lookupDetHierIdCity);
        searchQuery = searchQuery.where(where);
        Query<TmCmLookupDetHierarchical> q=session.createQuery(searchQuery);
        CityName=q.getSingleResult().getLookupDetHierDescEn() + "\n" + q.getSingleResult().getLookupDetHierDescRg();
        return CityName;
	}

}
