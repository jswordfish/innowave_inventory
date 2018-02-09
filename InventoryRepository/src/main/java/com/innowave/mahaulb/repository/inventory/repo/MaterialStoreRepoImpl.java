package com.innowave.mahaulb.repository.inventory.repo;

import java.util.ArrayList;
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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innowave.mahaulb.common.dao.master.TmUsers;
import com.innowave.mahaulb.common.repository.TmUsersRepo;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialTypeStoreMapping;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;

@Repository
@Transactional
public class MaterialStoreRepoImpl implements MaterialStoreRepo{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Autowired
	TmUsersRepo userRepo;
	

	@Override
	public void saveOrUpdate(TmInvStore invStore) {
		TmInvStore invStoreExisted=findTmInvStore(invStore,invStore.getTmUlb().getUlbId());
		if( invStoreExisted == null) {
			//create
			sessionFactory.getCurrentSession().save(invStore);
			
		}
		else {
			//update
			Mapper mapper = new DozerBeanMapper();
			mapper.map(invStore, invStoreExisted);
			invStoreExisted.setUpdatedDate(new Date());
			sessionFactory.getCurrentSession().merge(invStoreExisted);
		}
	System.out.println("done");
	}

	@Override
	public TmInvStore findTmInvStore(TmInvStore invStore,Integer ulbId) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<TmInvStore> query = builder.createQuery(TmInvStore.class);
		Root<TmInvStore> root = query.from(TmInvStore.class);
		
		
	
			Predicate where = builder.conjunction();
			where = builder.equal(root.get("storeId"),invStore.getStoreId());
			where  = builder.and(where, builder.equal(root.get("tmUlb").get("ulbId"), ulbId));
			query = query.where(where);
			Query<TmInvStore> queryObj=currentSession.createQuery(query);
		
		return queryObj.uniqueResult();
	}

	@Override
	public List<TmUsers> getUserList(int ulbId) {
		List<TmUsers> tmUsers= new ArrayList<TmUsers>();
		List<Object[]> usersList=userRepo.getUsers(ulbId);
		for (Object[] objects : usersList) {
			TmUsers users= new TmUsers();
			users.setUserId((Integer)objects[0]);
			users.setUserName((String)objects[3]);
			tmUsers.add(users);
		}
		return tmUsers;
	}

	@Override
	public int removeStoreByID(TmInvStore invStore) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaDelete<TmInvStore> query = builder.createCriteriaDelete(TmInvStore.class);
		Root e = query.from(TmInvStore.class);
		query.where(builder.lessThanOrEqualTo(e.get("storeId"), invStore.getStoreId()));
		return currentSession.createQuery(query).executeUpdate();
	}

	


}
