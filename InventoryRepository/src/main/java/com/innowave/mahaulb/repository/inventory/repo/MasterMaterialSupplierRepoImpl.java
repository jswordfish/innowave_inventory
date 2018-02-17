package com.innowave.mahaulb.repository.inventory.repo;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvSupplier;

@Repository
@Transactional
public class MasterMaterialSupplierRepoImpl implements MasterMaterialSupplierRepo{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void saveOrUpdate(TmInvSupplier invSupplier) {
		TmInvSupplier invSupplierExisted=getSupplierByCode(invSupplier.getTmUlb().getUlbId(),invSupplier.getSupplierCode());
		if( invSupplierExisted == null) {
			//create
			sessionFactory.getCurrentSession().save(invSupplier);
			//sessionFactory.getCurrentSession().persist(invSupplier);
		}
		else {
			//update
			ModelMapper mapper = new ModelMapper();
			mapper.map(invSupplier, invSupplierExisted);
			invSupplierExisted.setUpdatedDate(new Date());
			sessionFactory.getCurrentSession().merge(invSupplierExisted);
		}
	System.out.println("done");
	}
		

	@Override
	public List<TmCmLookupDet> getLookUpByUlb(int ulbId) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmCmLookupDet> query = builder.createQuery(TmCmLookupDet.class);
		Root e = query.from(TmCmLookupDet.class);
		query.where(builder.equal(e.get("ulbId"), ulbId));
		return currentSession.createQuery(query).getResultList();
	}

	@Override
	public List<TmInvSupplier> getSupplierTypList(TmInvSupplier invSupplier) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmInvSupplier> query = builder.createQuery(TmInvSupplier.class);
		Root<TmInvSupplier> root = query.from(TmInvSupplier.class);
		
		Predicate where = builder.conjunction();
		where = builder.equal(root.get("tmCmLookupDet").get("lookupDetId"), invSupplier.getTmCmLookupDet().getLookupDetId());
		where  = builder.and(where, builder.equal(root.get("supplierCode"), invSupplier.getSupplierCode()));
		where  = builder.or(where, builder.equal(root.get("supplierParentCode"), invSupplier.getSupplierParentCode()));
		query = query.where(where);
		Query<TmInvSupplier> qry = currentSession.createQuery(query);
		return qry.getResultList();
	}

	@Override
	public TmInvSupplier getSupplierById(Integer ulbId, Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmInvSupplier> query = builder.createQuery(TmInvSupplier.class);
		Root<TmInvSupplier> root = query.from(TmInvSupplier.class);
		Predicate where = builder.conjunction();
		where = builder.equal(root.get("tmUlb").get("ulbId"), ulbId);
		where  = builder.and(where, builder.equal(root.get("supplierId"), id));
		query = query.where(where);
		Query<TmInvSupplier> qry = currentSession.createQuery(query);
		return qry.getSingleResult();
	}
	
	
	private TmInvSupplier getSupplierByCode(Integer ulbId, String supplierCode) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmInvSupplier> query = builder.createQuery(TmInvSupplier.class);
		Root<TmInvSupplier> root = query.from(TmInvSupplier.class);
		Predicate where = builder.conjunction();
		where = builder.equal(root.get("tmUlb").get("ulbId"), ulbId);
		where  = builder.and(where, builder.equal(root.get("supplierCode"), supplierCode));
		query = query.where(where);
		Query<TmInvSupplier> qry = currentSession.createQuery(query);
		return qry.uniqueResult();
	
	}



	@Override
	public int removeStoreByID(TmInvSupplier invSupplier) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaDelete<TmInvSupplier> query = builder.createCriteriaDelete(TmInvSupplier.class);
		Root e = query.from(TmInvSupplier.class);
		query.where(builder.equal(e.get("supplierId"), invSupplier.getSupplierId()));
		return currentSession.createQuery(query).executeUpdate();
	}


	@Override
	public TmInvSupplier getSupplierByCode(TmInvSupplier invSupplier) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmInvSupplier> query = builder.createQuery(TmInvSupplier.class);
		Root<TmInvSupplier> root = query.from(TmInvSupplier.class);
		Predicate where = builder.conjunction();
		where = builder.equal(root.get("supplierCode"), invSupplier.getSupplierCode());
		where  = builder.and(where, builder.equal(root.get("tmUlb").get("ulbId"), invSupplier.getTmUlb().getUlbId()));
		query = query.where(where);
		Query<TmInvSupplier> qry = currentSession.createQuery(query);
		return qry.getSingleResult();
	}

}
