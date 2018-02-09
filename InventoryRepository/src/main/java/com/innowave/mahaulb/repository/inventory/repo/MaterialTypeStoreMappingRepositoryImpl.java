package com.innowave.mahaulb.repository.inventory.repo;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialType;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialTypeStoreMapping;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;

@Repository
@Transactional
public class MaterialTypeStoreMappingRepositoryImpl implements MaterialTypeStoreMappingRepository{
	@Autowired
	private SessionFactory sessionFactory;
	
	public TmInvStore resolveStore(String storeCode, int ulbId) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmInvStore> query = builder.createQuery(TmInvStore.class);
		Root<TmInvStore> root = query.from(TmInvStore.class);
			Predicate where = builder.conjunction();
			where = builder.equal(root.get("storeCode"),storeCode);
			where  = builder.and(where, builder.equal(root.get("tmUlb").get("ulbId"), ulbId));
			query = query.where(where);
			String wry = query.toString();
		
		Query<TmInvStore> queryObj=currentSession.createQuery(query);
		
		return queryObj.uniqueResult();
	}
	
	@Override
	public int  removeTmInvMaterialTypeStoreMapping(TmInvMaterialTypeStoreMapping mapping) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaDelete<TmInvMaterialTypeStoreMapping> query = builder.createCriteriaDelete(TmInvMaterialTypeStoreMapping.class);
		Root e = query.from(TmInvMaterialTypeStoreMapping.class);
		query.where(builder.lessThanOrEqualTo(e.get("materialTypeStoreMapId"), mapping.getMaterialTypeStoreMapId()));
		return currentSession.createQuery(query).executeUpdate();
	}
	
	
	public TmInvMaterialType resolveMaterialType(String materialTypeCode, int ulbId) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmInvMaterialType> query = builder.createQuery(TmInvMaterialType.class);
		Root<TmInvMaterialType> root = query.from(TmInvMaterialType.class);
		
		
	
			Predicate where = builder.conjunction();
			where = builder.equal(root.get("materialTypeCode"),materialTypeCode);
			where  = builder.and(where, builder.equal(root.get("tmUlb").get("ulbId"), ulbId));
			query = query.where(where);
			String wry = query.toString();
		
		Query<TmInvMaterialType> queryObj=currentSession.createQuery(query);
		
		return queryObj.uniqueResult();
	}
	
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

	@Override
	public void saveOrUpdate(TmInvMaterialTypeStoreMapping mapping) {
		// TODO Auto-generated method stub
		mapping.setTmInvStore(resolveStore(mapping.getTmInvStore().getStoreCode(), mapping.getTmUlb().getUlbId()));
		mapping.setTmInvMaterialType(resolveMaterialType(mapping.getTmInvMaterialType().getMaterialTypeCode(), mapping.getTmUlb().getUlbId()));
		mapping.setTmUlb(resolveUlb(mapping.getTmUlb().getUlbId()));
		
		TmInvMaterialTypeStoreMapping mapping2 = findMappingById(mapping.getTmInvStore().getStoreId(), mapping.getTmInvMaterialType().getMaterialTypeId(), mapping.getTmUlb().getUlbId());
	
		if(mapping2 == null) {
			//persist
			mapping.setCreatedDate(new Date());
			sessionFactory.getCurrentSession().save(mapping);
		}
		else {
			//update
			mapping.setUpdatedDate(new Date());
			Mapper mapper = new DozerBeanMapper();
			mapping.setMaterialTypeStoreMapId(mapping2.getMaterialTypeStoreMapId());
			mapping.setCreatedDate(mapping2.getCreatedDate());
			mapper.map(mapping, mapping2);
			mapping2.setUpdatedDate(new Date());
			sessionFactory.getCurrentSession().merge(mapping2);
		}
	}
	
	
	/**
	 * Use TmInvMaterialTypeStoreMapping findMapping(String storeCode, String materialTypeCode, Integer ulbId)  method later
	 * @param storeid
	 * @param materialTypeId
	 * @param ulbId
	 * @return
	 */
	@Deprecated
	public TmInvMaterialTypeStoreMapping findMappingById(Long storeid, Long materialTypeId, Integer ulbId) {
		Session currentSession = sessionFactory.getCurrentSession();
//		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
//		CriteriaQuery<TmInvMaterialTypeStoreMapping> query = builder.createQuery(TmInvMaterialTypeStoreMapping.class);
//		Root<TmInvMaterialTypeStoreMapping> root = query.from(TmInvMaterialTypeStoreMapping.class);
//		
//		
//	
//			Predicate where = builder.conjunction();
//			where = builder.equal(root.get("tmInvStore").get("storeCode"),storeCode);
//			where = builder.and(where, builder.equal(root.get("tmInvMaterialType").get("materialTypeCode"), materialTypeCode));
//			where  = builder.and(where, builder.equal(root.get("tmUlb").get("ulbId"), ulbId));
//			query = query.where(where);
//			String wry = query.toString();
		/**
		 * The query above results in many joins and is expensive. This is a temp solution till i figure out a better performant solution for this.
		 */
		String nativeQry = "select * from inventory.tm_inv_material_type_store_mapping where store_id = "+storeid+" AND material_type_id = "+materialTypeId+" AND ulb_id="+ulbId;
		
		 SQLQuery query = currentSession.createSQLQuery(nativeQry);
		 query.addEntity(TmInvMaterialTypeStoreMapping.class);
		return (TmInvMaterialTypeStoreMapping) query.uniqueResult();
	}
	
	@Override
	public TmInvMaterialTypeStoreMapping findMapping(String storeCode, String materialTypeCode, Integer ulbId) {
		Session currentSession = sessionFactory.getCurrentSession();
//		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
//		CriteriaQuery<TmInvMaterialTypeStoreMapping> query = builder.createQuery(TmInvMaterialTypeStoreMapping.class);
//		Root<TmInvMaterialTypeStoreMapping> root = query.from(TmInvMaterialTypeStoreMapping.class);
//		
//		
//	
//			Predicate where = builder.conjunction();
//			where = builder.equal(root.get("tmInvStore").get("storeCode"),storeCode);
//			where = builder.and(where, builder.equal(root.get("tmInvMaterialType").get("materialTypeCode"), materialTypeCode));
//			where  = builder.and(where, builder.equal(root.get("tmUlb").get("ulbId"), ulbId));
//			query = query.where(where);
//			String wry = query.toString();
		String nativeQry = "select * from inventory.tm_inv_material_type_store_mapping where store_id = "+storeCode+" AND material_type_id = "+materialTypeCode+" AND ulb_id="+ulbId;
		
		 SQLQuery query = currentSession.createSQLQuery(nativeQry);
		 query.addEntity(TmInvMaterialTypeStoreMapping.class);
		return (TmInvMaterialTypeStoreMapping) query.uniqueResult();
	}
	
	@Override
	public List<TmInvMaterialTypeStoreMapping> getMappings(String storeCode, Integer ulbId) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<TmInvMaterialTypeStoreMapping> query = builder.createQuery(TmInvMaterialTypeStoreMapping.class);
		Root<TmInvMaterialTypeStoreMapping> root = query.from(TmInvMaterialTypeStoreMapping.class);
		
		
	
			Predicate where = builder.conjunction();
			where = builder.equal(root.get("tmInvStore").get("storeId"),storeCode);
			where  = builder.and(where, builder.equal(root.get("tmUlb").get("ulbId"), ulbId));
			query = query.where(where);
		//	query.
			String wry = query.toString();
		
		Query<TmInvMaterialTypeStoreMapping> queryObj=currentSession.createQuery(query);
		String qryString = queryObj.getQueryString();
		List<TmInvMaterialTypeStoreMapping> ret = queryObj.getResultList();
			for(TmInvMaterialTypeStoreMapping map : ret) {
			map.setTmInvMaterialType(map.getTmInvMaterialType());//get rid of lazy init excep or make it eager.
			String name = map.getTmInvMaterialType().getMaterialTypeName();
			map.setTmUlb(map.getTmUlb());
			int uId = map.getTmUlb().getUlbId();
			map.getTmUlb().toString();
			}
		return ret;
	}


	@Override
	public List<TmInvStore> getAllStores(Integer ulbId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmInvStore> query = builder.createQuery(TmInvStore.class);
		Root<TmInvStore> root = query.from(TmInvStore.class);
		
		Predicate where = builder.conjunction();
		where = builder.equal(root.get("tmUlb").get("ulbId"), ulbId);
		query = query.where(where);
		Query<TmInvStore> qry = currentSession.createQuery(query);
		return qry.getResultList();
	}


	@Override
	public List<TmInvStore> getAllStoresForDepartment(Integer ulbId, Integer depId) {
		// TODO Auto-generated method stub
				Session currentSession = sessionFactory.getCurrentSession();
				CriteriaBuilder builder = currentSession.getCriteriaBuilder();
				CriteriaQuery<TmInvStore> query = builder.createQuery(TmInvStore.class);
				Root<TmInvStore> root = query.from(TmInvStore.class);
				
				Predicate where = builder.conjunction();
				where = builder.equal(root.get("tmUlb").get("ulbId"), ulbId);
				where  = builder.and(where, builder.equal(root.get("depId"), depId));
				query = query.where(where);
				Query<TmInvStore> qry = currentSession.createQuery(query);
				return qry.getResultList();
	}
	
	@Override
	public TmInvStore getStoreById(Long storeId) {
		// TODO Auto-generated method stub
				Session currentSession = sessionFactory.getCurrentSession();
				CriteriaBuilder builder = currentSession.getCriteriaBuilder();
				CriteriaQuery<TmInvStore> query = builder.createQuery(TmInvStore.class);
				Root<TmInvStore> root = query.from(TmInvStore.class);
				
				Predicate where = builder.conjunction();
				where = builder.equal(root.get("storeId"), storeId);
				query = query.where(where);
				Query<TmInvStore> qry = currentSession.createQuery(query);
				return qry.getSingleResult();
	}


	@Override
	public List<TmInvStore> getAllMaterialStoreList(Integer ulbId,
			 Long storeId,Integer depId) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TmInvStore> query = builder.createQuery(TmInvStore.class);
		Root<TmInvStore> root = query.from(TmInvStore.class);
		
		Predicate where = builder.conjunction();
		where = builder.equal(root.get("tmUlb").get("ulbId"), ulbId);
		where  = builder.and(where, builder.equal(root.get("depId"), depId));
		where  = builder.and(where, builder.equal(root.get("storeId"), storeId));
		query = query.where(where);
		Query<TmInvStore> qry = currentSession.createQuery(query);
		return qry.getResultList();
	}
	
	
	
	
}
