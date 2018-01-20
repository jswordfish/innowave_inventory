package com.innowave.mahaulb.repository.treecensus.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innowave.mahaulb.common.dao.TmCmApartment;
import com.innowave.mahaulb.common.dao.TmCmLocality;
import com.innowave.mahaulb.common.dao.TmCmLookup;
import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.dao.TmCmLookupDetHierarchical;
import com.innowave.mahaulb.common.dao.TmCmRoad;
import com.innowave.mahaulb.common.dao.master.TmCmLocation;

@Repository
@Transactional
public class TreecensusRepoImpl implements TreecensusRepo {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<TmCmLocality> getLocalityDataListServ(String searchString, int ulbIdAuto) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TmCmLocality> searchQuery = builder.createQuery(TmCmLocality.class);
        Root<TmCmLocality> aRoot = searchQuery.from(TmCmLocality.class);
        searchQuery.select(aRoot).where();
        Predicate where = builder.conjunction();
        where = builder.equal(aRoot.get("ulbId"),ulbIdAuto);
        where = builder.and(where, builder.like(builder.lower(aRoot.get("localityDescription")), "%"+searchString.toLowerCase()+"%"));
        searchQuery = searchQuery.where(where);
		Query<TmCmLocality> q=session.createQuery(searchQuery);
        return q.getResultList();
	}

	@Override
	public List<TmCmLocation> getLocationDataListServ(String searchString, int ulbIdAuto) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TmCmLocation> searchQuery = builder.createQuery(TmCmLocation.class);
        Root<TmCmLocation> aRoot = searchQuery.from(TmCmLocation.class);
        searchQuery.select(aRoot).where();
        Predicate where = builder.conjunction();
        where = builder.equal(aRoot.get("ulbId"),ulbIdAuto);
        where = builder.and(where, builder.like(builder.lower(aRoot.get("locationDescription")), "%"+searchString.toLowerCase()+"%"));
        searchQuery = searchQuery.where(where);
		Query<TmCmLocation> q=session.createQuery(searchQuery);
		System.out.println("LocationData :: " + q.getQueryString());
        return q.getResultList();
	}

	@Override
	public List<TmCmApartment> getApartmentDataListServ(String searchString, int ulbIdAuto) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TmCmApartment> searchQuery = builder.createQuery(TmCmApartment.class);
        Root<TmCmApartment> aRoot = searchQuery.from(TmCmApartment.class);
        searchQuery.select(aRoot).where();
        Predicate where = builder.conjunction();
        where = builder.equal(aRoot.get("ulbId"),ulbIdAuto);
        where = builder.and(where, builder.like(builder.lower(aRoot.get("apartmentDescription")), "%"+searchString.toLowerCase()+"%"));
        searchQuery = searchQuery.where(where);
		Query<TmCmApartment> q=session.createQuery(searchQuery);
        return q.getResultList();
	}

	@Override
	public List<TmCmRoad> getRoadDataListServ(String searchString, int ulbIdAuto) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TmCmRoad> searchQuery = builder.createQuery(TmCmRoad.class);
        Root<TmCmRoad> aRoot = searchQuery.from(TmCmRoad.class);
        searchQuery.select(aRoot).where();
        Predicate where = builder.conjunction();
        where = builder.equal(aRoot.get("ulbId"),ulbIdAuto);
         where = builder.and(where, builder.like(builder.lower(aRoot.get("roadDescription")), "%"+searchString.toLowerCase()+"%"));
       searchQuery = searchQuery.where(where);
		Query<TmCmRoad> q=session.createQuery(searchQuery);
        return q.getResultList();
	}

	@Override
	public List<TmCmLookupDetHierarchical> getLookupHierWordListServ(String searchString, int ulbIdAuto) {
		Session session = sessionFactory.getCurrentSession();	 	
		CriteriaBuilder builder = session.getCriteriaBuilder();		
		CriteriaQuery<TmCmLookupDetHierarchical> searchQuery = builder.createQuery(TmCmLookupDetHierarchical.class);

		Root<TmCmLookup> tmlookup = searchQuery.from(TmCmLookup.class);
		Root<TmCmLookupDet> tmlookupdet = searchQuery.from(TmCmLookupDet.class);
		Root<TmCmLookupDetHierarchical> tmlookupdether = searchQuery.from(TmCmLookupDetHierarchical.class);

		searchQuery.multiselect(tmlookupdether.get("lookupDetHierId"),tmlookupdether.get("lookupDetHierDescEn"),tmlookupdether.get("lookupDetHierDescRg"));
		//query.select(query).where();
		Predicate where = builder.conjunction();
		where = builder.equal(tmlookup.get("lookupId"), tmlookupdet.get("tmCmLookup"));
		where = builder.and(where, builder.equal(tmlookupdet.get("lookupDetId"), tmlookupdether.get("tmCmLookupDet")));
		where = builder.and(where, builder.equal(tmlookup.get("lookupCode"), "AWZ"));
		where = builder.and(where, builder.equal(tmlookupdether.get("ulbId"), ulbIdAuto));
		where = builder.and(where, builder.like(builder.lower(tmlookupdether.get("lookupDetHierDescEn")), "%"+searchString.toLowerCase()+"%"),
				builder.or(where, builder.like(builder.lower(tmlookupdether.get("lookupDetHierDescRg")), "%"+searchString.toLowerCase()+"%")));
		searchQuery = searchQuery.where(where);
		Query<TmCmLookupDetHierarchical> q=session.createQuery(searchQuery);
		//String ls = q.getResultList().toString();
		System.out.println("SQL :: " + q.getQueryString());
		return q.getResultList();
		/*
		Session session = sessionFactory.getCurrentSession();	 	
		CriteriaBuilder builder = session.getCriteriaBuilder();		
		CriteriaQuery<TmCmLookupDetHierarchical> searchQuery = builder.createQuery(TmCmLookupDetHierarchical.class);

		Root<TmCmLookup> tmlookup = searchQuery.from(TmCmLookup.class);
		Root<TmCmLookupDet> tmlookupdet = searchQuery.from(TmCmLookupDet.class);
		Root<TmCmLookupDetHierarchical> tmlookupdether = searchQuery.from(TmCmLookupDetHierarchical.class);

		searchQuery.multiselect(tmlookupdether.get("lookupDetHierId"),tmlookupdether.get("lookupDetHierDescEn"),tmlookupdether.get("lookupDetHierDescRg"));
		Predicate where = builder.conjunction();

		where = builder.equal(tmlookup.get("lookupCode"),"AWZ");
		where = builder.and(where, builder.equal(tmlookupdether.get("ulbId"), ulbIdAuto));
		where = builder.and(where, builder.equal(tmlookup.get("lookupId"),tmlookupdet.get("tmCmLookup").get("lookupId")));
		where = builder.and(where, builder.like(builder.lower(tmlookupdether.get("lookupDetHierDescEn")), "%"+searchString.toLowerCase()+"%"));
		where = builder.or(where, builder.like(builder.lower(tmlookupdether.get("lookupDetHierDescRg")), "%"+searchString.toLowerCase()+"%"));
		where = builder.and(where, builder.equal(tmlookupdet.get("lookupDetId"), tmlookupdether.get("tmCmLookupDet").get("lookupDetId")));

		searchQuery = searchQuery.where(where);
		Query<TmCmLookupDetHierarchical> q=session.createQuery(searchQuery);
		//String ls = q.getResultList().toString();
		System.out.println("Query :: " + q.getQueryString());
		return q.getResultList();
		*/
	}

	@Override
	public List<TmCmLookupDetHierarchical> getLookupHierZordListServ(String searchString, int ulbIdAuto) {
		Session session = sessionFactory.getCurrentSession();	 	
		CriteriaBuilder builder = session.getCriteriaBuilder();		
		CriteriaQuery<TmCmLookupDetHierarchical> searchQuery = builder.createQuery(TmCmLookupDetHierarchical.class);

		Root<TmCmLookup> tmlookup = searchQuery.from(TmCmLookup.class);
		Root<TmCmLookupDet> tmlookupdet = searchQuery.from(TmCmLookupDet.class);
		Root<TmCmLookupDetHierarchical> tmlookupdether = searchQuery.from(TmCmLookupDetHierarchical.class);

		searchQuery.multiselect(tmlookupdether.get("lookupDetHierId"),tmlookupdether.get("lookupDetHierDescEn"),tmlookupdether.get("lookupDetHierDescRg"));
		//query.select(query).where();
		Predicate where = builder.conjunction();
		where = builder.equal(tmlookup.get("lookupId"), tmlookupdet.get("tmCmLookup"));
		where = builder.and(where, builder.equal(tmlookupdet.get("lookupDetId"), tmlookupdether.get("tmCmLookupDet")));
		where = builder.and(where, builder.equal(tmlookup.get("lookupCode"), "WWZ"));
		where = builder.and(where, builder.equal(tmlookupdether.get("ulbId"), ulbIdAuto));
		where = builder.and(where, builder.like(builder.lower(tmlookupdether.get("lookupDetHierDescEn")), "%"+searchString.toLowerCase()+"%"),
				builder.or(where, builder.like(builder.lower(tmlookupdether.get("lookupDetHierDescRg")), "%"+searchString.toLowerCase()+"%")));
		searchQuery = searchQuery.where(where);
		Query<TmCmLookupDetHierarchical> q=session.createQuery(searchQuery);
		//String ls = q.getResultList().toString();
		System.out.println("SQL :: " + q.getQueryString());
		return q.getResultList();
		/*Session session = sessionFactory.getCurrentSession();	 	
		CriteriaBuilder builder = session.getCriteriaBuilder();		
		CriteriaQuery<TmCmLookupDetHierarchical> searchQuery = builder.createQuery(TmCmLookupDetHierarchical.class);

		Root<TmCmLookup> tmlookup = searchQuery.from(TmCmLookup.class);
		Root<TmCmLookupDet> tmlookupdet = searchQuery.from(TmCmLookupDet.class);
		Root<TmCmLookupDetHierarchical> tmlookupdether = searchQuery.from(TmCmLookupDetHierarchical.class);

		searchQuery.multiselect(tmlookupdether.get("lookupDetHierId"),tmlookupdether.get("lookupDetHierDescEn"),tmlookupdether.get("lookupDetHierDescRg"));
		//query.select(query).where();
		Predicate where = builder.conjunction();

		where = builder.equal(tmlookup.get("lookupCode"),"WWZ");
		where = builder.and(where, builder.equal(tmlookupdether.get("ulbId"), ulbIdAuto));
		where = builder.and(where, builder.equal(tmlookup.get("lookupId"),tmlookupdet.get("tmCmLookup").get("lookupId")));
		where = builder.and(where, builder.like(builder.lower(tmlookupdether.get("lookupDetHierDescEn")), "%"+searchString.toLowerCase()+"%"));
		where = builder.or(where, builder.like(builder.lower(tmlookupdether.get("lookupDetHierDescRg")), "%"+searchString.toLowerCase()+"%"));
		where = builder.and(where, builder.equal(tmlookupdet.get("lookupDetId"), tmlookupdether.get("tmCmLookupDet").get("lookupDetId")));

		searchQuery = searchQuery.where(where);
		Query<TmCmLookupDetHierarchical> q=session.createQuery(searchQuery);
		//String ls = q.getResultList().toString();
		System.out.println("Query :: " + q.getQueryString());
		return q.getResultList();*/
	}

}
