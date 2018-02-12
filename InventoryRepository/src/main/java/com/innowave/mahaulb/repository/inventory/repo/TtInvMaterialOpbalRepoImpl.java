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

import com.innowave.mahaulb.common.dao.TmCmFinancialMas;
import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.common.repository.TmULBRepo;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterial;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialType;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialTypeStoreMapping;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;
import com.innowave.mahaulb.repository.inventory.dao.trans.TtInvMaterialOpbal;
@Repository
@Transactional
public class TtInvMaterialOpbalRepoImpl implements TtInvMaterialOpbalRepo{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	TmULBRepo ulbRepo;
	
	public TtInvMaterialOpbal getTtInvMaterialOpbal(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TtInvMaterialOpbal> query = builder.createQuery(TtInvMaterialOpbal.class);
		Root<TtInvMaterialOpbal> root = query.from(TtInvMaterialOpbal.class);
		
		
	
			Predicate where = builder.conjunction();
			where = builder.equal(root.get("matOpbalId"),id);
		
			query = query.where(where);
			String wry = query.toString();
		
		Query<TtInvMaterialOpbal> queryObj=currentSession.createQuery(query);
		return queryObj.uniqueResult();
	}
	
	public TtInvMaterialOpbal getTtInvMaterialOpbal(int ubId, long materialId, long storeId, int finId) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TtInvMaterialOpbal> query = builder.createQuery(TtInvMaterialOpbal.class);
		Root<TtInvMaterialOpbal> root = query.from(TtInvMaterialOpbal.class);
		
		
	
			Predicate where = builder.conjunction();
			where = builder.equal(root.get("tmInvMaterial").get("materialId"),materialId);
			where  = builder.and(where, builder.equal(root.get("tmUlb").get("ulbId"), ubId));
			where  = builder.and(where, builder.equal(root.get("tmInvStore").get("storeId"), storeId));
			where  = builder.and(where, builder.equal(root.get("tmCmFinancialMas").get("finId"), finId));
			query = query.where(where);
			String wry = query.toString();
		
		Query<TtInvMaterialOpbal> queryObj=currentSession.createQuery(query);
		return queryObj.uniqueResult();
	}
	
	public TmInvStore resolveStore(Long storeId) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmInvStore> query = builder.createQuery(TmInvStore.class);
		Root<TmInvStore> root = query.from(TmInvStore.class);
			Predicate where = builder.conjunction();
			where = builder.equal(root.get("storeId"),storeId);
			query = query.where(where);
			String wry = query.toString();
		
		Query<TmInvStore> queryObj=currentSession.createQuery(query);
		
		return queryObj.uniqueResult();
	}
	
	public TmInvMaterial resolveMaterial(Long materialId) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmInvMaterial> query = builder.createQuery(TmInvMaterial.class);
		Root<TmInvMaterial> root = query.from(TmInvMaterial.class);
			Predicate where = builder.conjunction();
			where = builder.equal(root.get("materialId"),materialId);
			query = query.where(where);
					
		Query<TmInvMaterial> queryObj=currentSession.createQuery(query);
		
		return queryObj.uniqueResult();
	}
	
	public TmCmFinancialMas resolveTmCmFinancialMas(Integer finId) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmCmFinancialMas> query = builder.createQuery(TmCmFinancialMas.class);
		Root<TmCmFinancialMas> root = query.from(TmCmFinancialMas.class);
			Predicate where = builder.conjunction();
			where = builder.equal(root.get("finId"),finId);
			query = query.where(where);
					
		Query<TmCmFinancialMas> queryObj=currentSession.createQuery(query);
		
		return queryObj.uniqueResult();
	}
	
	
	
	public TtInvMaterialOpbal saveOrUpdate(TtInvMaterialOpbal invMaterialOpbal) {
		
		TmInvStore store = resolveStore(invMaterialOpbal.getTmInvStore().getStoreId());
		TmUlb ulb = ulbRepo.getULBbyId(invMaterialOpbal.getTmUlb().getUlbId());
		TmInvMaterial material = resolveMaterial(invMaterialOpbal.getTmInvMaterial().getMaterialId());
		TmCmFinancialMas financialMas = resolveTmCmFinancialMas(invMaterialOpbal.getTmCmFinancialMas().getFinId());
		invMaterialOpbal.setTmInvStore(store);
		invMaterialOpbal.setStoreName(store.getStoreName());
		invMaterialOpbal.setStoreCode(store.getStoreCode());
		invMaterialOpbal.setTmUlb(ulb);
		invMaterialOpbal.setTmCmFinancialMas(financialMas);
		invMaterialOpbal.setTmInvMaterial(material);
		invMaterialOpbal.setMaterialName(material.getMaterialName());
		TtInvMaterialOpbal invMaterialOpbal2 = getTtInvMaterialOpbal(invMaterialOpbal.getTmUlb().getUlbId(), invMaterialOpbal.getTmInvMaterial().getMaterialId(), invMaterialOpbal.getTmInvStore().getStoreId(), invMaterialOpbal.getTmCmFinancialMas().getFinId());
			if(invMaterialOpbal2 == null) {
				//create
				invMaterialOpbal.setCreatedDate(new Date());
				sessionFactory.getCurrentSession().save(invMaterialOpbal);
				return invMaterialOpbal;
			}
			else {
				//update
				invMaterialOpbal.setUpdatedDate(new Date());
				ModelMapper modelMapper = new ModelMapper();
				invMaterialOpbal.setMatOpbalId(invMaterialOpbal2.getMatOpbalId());
				modelMapper.map(invMaterialOpbal, invMaterialOpbal2);
				sessionFactory.getCurrentSession().merge(invMaterialOpbal2);
				return invMaterialOpbal2;
			}
		
	}
	
	public List<TmCmFinancialMas> getTmCmFinancialMas(){
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmCmFinancialMas> query = builder.createQuery(TmCmFinancialMas.class);
		Root<TmCmFinancialMas> root = query.from(TmCmFinancialMas.class);
		Predicate where = builder.conjunction();
		where = builder.equal(root.get("status"),1);//active status...make it constant later
		query = query.where(where);
				
	Query<TmCmFinancialMas> queryObj=currentSession.createQuery(query);
	return queryObj.getResultList();
	}
	
	public List<TmInvMaterial> getMaterialsByULB(Integer ulbId){
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmInvMaterial> query = builder.createQuery(TmInvMaterial.class);
		Root<TmInvMaterial> root = query.from(TmInvMaterial.class);
		Predicate where = builder.conjunction();
		where =  builder.equal(root.get("tmUlb").get("ulbId"), ulbId);
		query = query.where(where);
				
	Query<TmInvMaterial> queryObj=currentSession.createQuery(query);
	return queryObj.getResultList();
	}
	
	public List<TmInvMaterial> getMaterialsByULBAndStore(Integer ulbId, long storeId){
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmInvMaterial> query = builder.createQuery(TmInvMaterial.class);
		Root<TmInvMaterial> root = query.from(TmInvMaterial.class);
		Predicate where = builder.conjunction();
		where =  builder.equal(root.get("tmUlb").get("ulbId"), ulbId);
		where  = builder.and(where, builder.equal(root.get("tmInvStore").get("storeId"), storeId));
		query = query.where(where);
				
	Query<TmInvMaterial> queryObj=currentSession.createQuery(query);
	return queryObj.getResultList();
	}
	
	public List<TtInvMaterialOpbal> getTtInvMaterialOpbalForMaterialAndStore(long materialId, long storeId){
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TtInvMaterialOpbal> query = builder.createQuery(TtInvMaterialOpbal.class);
		Root<TtInvMaterialOpbal> root = query.from(TtInvMaterialOpbal.class);
		Predicate where = builder.conjunction();
		where =  builder.equal(root.get("tmInvMaterial").get("materialId"), materialId);
		where  = builder.and(where, builder.equal(root.get("tmInvStore").get("storeId"), storeId));
		query = query.where(where);
				
	Query<TtInvMaterialOpbal> queryObj=currentSession.createQuery(query);
	return queryObj.getResultList();
	}
	
	public void deleteOpBalById(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaDelete<TtInvMaterialOpbal> query = builder.createCriteriaDelete(TtInvMaterialOpbal.class);
		Root e = query.from(TtInvMaterialOpbal.class);
		query.where(builder.equal(e.get("matOpbalId"), id));
		currentSession.createQuery(query).executeUpdate();
	}
}
