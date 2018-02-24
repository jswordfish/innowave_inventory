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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterial;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvStore;
import com.innowave.mahaulb.repository.inventory.dao.trans.TtInvScrap;
@Repository
@Transactional
public class TtInvScrapRepoImpl implements TtInvScrapRepo{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	UtilRepo utilRepo;
	
	@Autowired
	MaterialStoreRepo materialStoreRepo;
	
	@Override
	public List<TtInvScrap> getScraps(Integer ulbId, String disposalNo, Long storeId, Date disposalFromDate, Date disposalToDate,
			Character status) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TtInvScrap> query = builder.createQuery(TtInvScrap.class);
		Root<TtInvScrap> root = query.from(TtInvScrap.class);
		
		Predicate where = builder.conjunction();
			if(disposalNo != null && disposalNo.trim().length() != 0 && storeId != null && ulbId != null) {
				TtInvScrap s = getUnique(storeId, ulbId, disposalNo);
				List<TtInvScrap> ret = new ArrayList<>();
					if(s!= null) {
						ret.add(s);
					}
					
					for(TtInvScrap sc : ret) {
						String name = sc.getTmInvStore().getStoreName();//lazy init prob
						long id = sc.getTmInvStore().getStoreId();
					}
				
				return ret;
			}
		where = builder.greaterThanOrEqualTo(root.get("scrapId"), 0);
			if(disposalNo != null && disposalNo.trim().length() != 0) {
				where = builder.equal(root.get("scrapNo"),disposalNo);
			}
			if(storeId != null) {
				where  = builder.and(where, builder.equal(root.get("tmInvStore").get("storeId"), storeId));
			}
			if(disposalFromDate != null) {
				where  = builder.and(where, builder.equal(root.get("scrapDate"), disposalFromDate));
			}
			if(status != null) {
				where  = builder.and(where, builder.equal(root.get("scrapStatus"), status));
			}
		
		where  = builder.and(where, builder.equal(root.get("tmUlb").get("ulbId"),ulbId));
		query = query.where(where);
		Query<TtInvScrap> qry = currentSession.createQuery(query);
		List<TtInvScrap> scraps = qry.getResultList();
			for(TtInvScrap s : scraps) {
				String name = s.getTmInvStore().getStoreName();//lazy init prob
				long id = s.getTmInvStore().getStoreId();
			}
		return scraps;
	}

	@Override
	public TtInvScrap saveOrUpdate(TtInvScrap scrap) {
		// TODO Auto-generated method stub
		TmUlb tmUlb = utilRepo.resolveUlb(scrap.getTmUlb().getUlbId());
		TmInvStore invStore = materialStoreRepo.findTmInvStore(scrap.getTmInvStore(), tmUlb.getUlbId());
		scrap.setTmUlb(tmUlb);
		scrap.setTmInvStore(invStore);
		
		TtInvScrap scrap2 = getUnique(scrap.getTmInvStore().getStoreId(), tmUlb.getUlbId(), scrap.getScrapNo());
			if(scrap2 == null) {
				//persist
				scrap.setCreatedDate(new Date());
				sessionFactory.getCurrentSession().persist(scrap);
			}
			else {
				//update
				scrap.setScrapId(scrap2.getScrapId());
				scrap.setUpdatedDate(new Date());
				ModelMapper mapper = new ModelMapper();
				mapper.map(scrap, scrap2);
				sessionFactory.getCurrentSession().merge(scrap2);
			}
		return null;
	}
	
	public TtInvScrap getUnique(Long storeId, Integer ulbId, String disposalNo) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TtInvScrap> query = builder.createQuery(TtInvScrap.class);
		Root<TtInvScrap> root = query.from(TtInvScrap.class);
		
		Predicate where = builder.conjunction();
		where = builder.equal(root.get("scrapNo"),disposalNo);
		where  = builder.and(where, builder.equal(root.get("tmUlb").get("ulbId"),ulbId));
		where  = builder.and(where, builder.equal(root.get("tmInvStore").get("storeId"), storeId));
		
		query = query.where(where);
		Query<TtInvScrap> qry = currentSession.createQuery(query);
		return qry.uniqueResult();
	}

	@Override
	public TtInvScrap getUniqueById(Long scrapId) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TtInvScrap> query = builder.createQuery(TtInvScrap.class);
		Root<TtInvScrap> root = query.from(TtInvScrap.class);
		
		Predicate where = builder.conjunction();
		where = builder.equal(root.get("scrapId"),scrapId);
	
		
		query = query.where(where);
		Query<TtInvScrap> qry = currentSession.createQuery(query);
		return qry.uniqueResult();
	}

	@Override
	public void deleteById(Long scrapId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaDelete<TtInvScrap> query = builder.createCriteriaDelete(TtInvScrap.class);
		Root e = query.from(TtInvScrap.class);
		query.where(builder.equal(e.get("scrapId"), scrapId));
		currentSession.createQuery(query).executeUpdate();
	}

}
