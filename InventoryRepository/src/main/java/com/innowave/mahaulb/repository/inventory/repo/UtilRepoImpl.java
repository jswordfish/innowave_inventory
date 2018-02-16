package com.innowave.mahaulb.repository.inventory.repo;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvSupplier;
@Repository
@Transactional
public class UtilRepoImpl implements UtilRepo {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<TmCmLookupDet> getByULBId(Integer ulbid) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmCmLookupDet> query = builder.createQuery(TmCmLookupDet.class);
		Root<TmCmLookupDet> root = query.from(TmCmLookupDet.class);
		
		
	
			Predicate where = builder.conjunction();
			where = builder.equal(root.get("ulbId"),ulbid);
		
			query = query.where(where);
			String wry = query.toString();
		
		Query<TmCmLookupDet> queryObj=currentSession.createQuery(query);
		return queryObj.getResultList();
	}
	
	public List<TmInvSupplier> getSuppliersBy(Integer ulbid){
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmInvSupplier> query = builder.createQuery(TmInvSupplier.class);
		Root<TmInvSupplier> root = query.from(TmInvSupplier.class);
		
		
	
			Predicate where = builder.conjunction();
			where = builder.equal(root.get("tmUlb").get("ulbId"),ulbid);
		
			query = query.where(where);
			String wry = query.toString();
		
		Query<TmInvSupplier> queryObj=currentSession.createQuery(query);
		return queryObj.getResultList();
	}

	@Override
	public TmCmLookupDet resolveById(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmCmLookupDet> query = builder.createQuery(TmCmLookupDet.class);
		Root<TmCmLookupDet> root = query.from(TmCmLookupDet.class);
		
		
	
			Predicate where = builder.conjunction();
			where = builder.equal(root.get("lookupDetId"),id);
			query = query.where(where);
			String wry = query.toString();
		
		Query<TmCmLookupDet> queryObj=currentSession.createQuery(query);
		
		return queryObj.uniqueResult();
	}

	@Override
	public TmInvSupplier resolveById(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmInvSupplier> query = builder.createQuery(TmInvSupplier.class);
		Root<TmInvSupplier> root = query.from(TmInvSupplier.class);
		
		
	
			Predicate where = builder.conjunction();
			where = builder.equal(root.get("supplierId"),id);
			query = query.where(where);
			String wry = query.toString();
		
		Query<TmInvSupplier> queryObj=currentSession.createQuery(query);
		
		return queryObj.uniqueResult();
	}

	@Override
	public TmUlb resolveUlb(int ulbId) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmUlb> query = builder.createQuery(TmUlb.class);
		Root<TmUlb> root = query.from(TmUlb.class);
		
		
	
			Predicate where = builder.conjunction();
			where = builder.equal(root.get("ulbId"),ulbId);
			query = query.where(where);
			String wry = query.toString();
		
		Query<TmUlb> queryObj=currentSession.createQuery(query);
		
		return queryObj.uniqueResult();
	}

}
