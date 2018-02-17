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
import com.innowave.mahaulb.common.dao.TmCmLookupDetHierarchical;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterial;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialTypeStoreMapping;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvSupplier;


@Repository
@Transactional
public class MasterMaterialRepoImpl implements MasterMaterialRepo{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<TmInvMaterial> getMaterialList(Long materialTyp,
			Integer ulbId, String materialCode) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmInvMaterial> query = builder.createQuery(TmInvMaterial.class);
		Root<TmInvMaterial> root = query.from(TmInvMaterial.class);
		
		Predicate where = builder.conjunction();
		where = builder.equal(root.get("tmInvMaterialType").get("materialTypeId"),materialTyp);
		where  = builder.and(where, builder.equal(root.get("tmUlb").get("ulbId"),ulbId));
		where  = builder.and(where, builder.equal(root.get("materialCode"), materialCode));
		query = query.where(where);
		Query<TmInvMaterial> qry = currentSession.createQuery(query);
		return qry.getResultList();
	}

	@Override
	public TmInvMaterial getMaterialByiD(Integer materialId,Integer ulbId) {

		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmInvMaterial> query = builder.createQuery(TmInvMaterial.class);
		Root<TmInvMaterial> root = query.from(TmInvMaterial.class);
		Predicate where = builder.conjunction();
		where = builder.equal(root.get("tmUlb").get("ulbId"), ulbId);
		where  = builder.and(where, builder.equal(root.get("materialId"), materialId));
		query = query.where(where);
		Query<TmInvMaterial> qry = currentSession.createQuery(query);
		return qry.uniqueResult();
	}
	
	@Override
	public TmInvMaterial getMaterialByMaterialCode(String materialCode,Integer ulbId) {

		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmInvMaterial> query = builder.createQuery(TmInvMaterial.class);
		Root<TmInvMaterial> root = query.from(TmInvMaterial.class);
		Predicate where = builder.conjunction();
		where = builder.equal(root.get("tmUlb").get("ulbId"), ulbId);
		where  = builder.and(where, builder.equal(root.get("materialCode"), materialCode));
		query = query.where(where);
		Query<TmInvMaterial> qry = currentSession.createQuery(query);
		return qry.uniqueResult();
	}

	@Override
	public List<TmCmLookupDetHierarchical> getLookupDetByUlb(Integer ulbId) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmCmLookupDetHierarchical> query = builder.createQuery(TmCmLookupDetHierarchical.class);
		Root<TmCmLookupDetHierarchical> root = query.from(TmCmLookupDetHierarchical.class);
		Predicate where = builder.conjunction();
		where = builder.equal(root.get("ulbId"), ulbId);
		query = query.where(where);
		Query<TmCmLookupDetHierarchical> qry = currentSession.createQuery(query);
		return qry.getResultList();
	}

	@Override
	public int removeMateria(TmInvMaterial invMaterial) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaDelete<TmInvMaterial> query = builder.createCriteriaDelete(TmInvMaterial.class);
		Root e = query.from(TmInvMaterial.class);
		query.where(builder.equal(e.get("materialId"), invMaterial.getMaterialId()));
		return currentSession.createQuery(query).executeUpdate();
	}

	@Override
	public void saveOrUpdate(TmInvMaterial invMaterial) {
		TmInvMaterial invmaterialExisted=getMaterialByMaterialCode(invMaterial.getMaterialCode(),invMaterial.getTmUlb().getUlbId());
		if( invmaterialExisted == null) {
			//create
			sessionFactory.getCurrentSession().save(invMaterial);
			
		}
		else {
			//update
			ModelMapper mapper = new ModelMapper();
			mapper.map(invMaterial, invmaterialExisted);
			invmaterialExisted.setUpdatedDate(new Date());
			sessionFactory.getCurrentSession().merge(invmaterialExisted);
		}
	System.out.println("done");
		
	}

}
