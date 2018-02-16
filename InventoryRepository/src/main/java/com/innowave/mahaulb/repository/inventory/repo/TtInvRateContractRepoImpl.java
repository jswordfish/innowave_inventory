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
import org.springframework.ui.ModelMap;

import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialTypeStoreMapping;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvSupplier;
import com.innowave.mahaulb.repository.inventory.dao.trans.TtInvRateContract;
@Repository
@Transactional
public class TtInvRateContractRepoImpl implements TtInvRateContractRepo {
	@Autowired
	UtilRepo utilRepo;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public TtInvRateContract getById(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<TtInvRateContract> query = builder.createQuery(TtInvRateContract.class);
		Root<TtInvRateContract> root = query.from(TtInvRateContract.class);
		
		
	
			Predicate where = builder.conjunction();
			where = builder.equal(root.get("rateContractId"),id);
			query = query.where(where);
			String wry = query.toString();
		
		Query<TtInvRateContract> queryObj=currentSession.createQuery(query);
		TtInvRateContract c = queryObj.uniqueResult();
		/**
		 * For preventing lazy init exceptions on these attributes
		 */
		Long suppId = c.getTmInvSupplier().getSupplierId();
		String sName = c.getTmInvSupplier().getSupplierName();
		Integer id1 = c.getTmCmLookupDet().getLookupDetId();
		String cd = c.getTmCmLookupDet().getLookupDetDescEn();
		return c;
	}

	@Override
	public void saveOrUpdate(TtInvRateContract contractRepo) {
		// TODO Auto-generated method stub
		int lookupId = contractRepo.getTmCmLookupDet().getLookupDetId();
		long sid = contractRepo.getTmInvSupplier().getSupplierId();
		int ulbid = contractRepo.getTmUlb().getUlbId();
		TmCmLookupDet det = utilRepo.resolveById(lookupId);
		TmInvSupplier supplier = utilRepo.resolveById(sid);
		TmUlb tmUlb = utilRepo.resolveUlb(ulbid);
		contractRepo.setTmCmLookupDet(det);
		contractRepo.setTmInvSupplier(supplier);
		contractRepo.setTmUlb(tmUlb);
		Session currentSession = sessionFactory.getCurrentSession();
		if(contractRepo.getRateContractId() == 0 || contractRepo.getRateContractId() == -1) {
			//persist
			contractRepo.setRateContractId(0);
			contractRepo.setCreatedDate(new Date());
			currentSession.persist(contractRepo);
		}
		else {
			//update = 
			TtInvRateContract contractRepo2 = getById(contractRepo.getRateContractId());
			ModelMapper mapper = new ModelMapper();
			contractRepo.setRateContractId(contractRepo2.getRateContractId());
			contractRepo.setTtInvRateContractDets(contractRepo2.getTtInvRateContractDets());
			mapper.map(contractRepo, contractRepo2);
			contractRepo2.setUpdatedDate(new Date());
			currentSession.merge(contractRepo2);
			
		}
	}
	
	@Override
	public int  removeTtInvRateContract(Long id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaDelete<TtInvRateContract> query = builder.createCriteriaDelete(TtInvRateContract.class);
		Root e = query.from(TtInvRateContract.class);
		query.where(builder.equal(e.get("rateContractId"), id));
		return currentSession.createQuery(query).executeUpdate();
	}
	 

	@Override
	public List<TtInvRateContract> fetchBy(Long supplierId, Long rateTypeId, Date aStartDate, Date aEndDate) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<TtInvRateContract> query = builder.createQuery(TtInvRateContract.class);
		Root<TtInvRateContract> root = query.from(TtInvRateContract.class);
			Predicate where = builder.conjunction();
			where = builder.equal(root.get("tmInvSupplier").get("supplierId"),supplierId);
			where  = builder.and(where, builder.equal(root.get("tmCmLookupDet").get("lookupDetId"), rateTypeId.intValue()));
			where  = builder.and(where, builder.greaterThan((root.get("agreementStartDate")), aStartDate));
			where  = builder.and(where, builder.lessThanOrEqualTo((root.get("agreementEndDate")), aEndDate));
			query = query.where(where);
		//	query.
			String wry = query.toString();
		
		Query<TtInvRateContract> queryObj=currentSession.createQuery(query);
		String qryString = queryObj.getQueryString();
		List<TtInvRateContract> ret = queryObj.getResultList();
		/**
		 * To prevent lazy init ex.//@TODO look at better ways later n.
		 */
			for(TtInvRateContract c : ret) {
				String s = c.getTmInvSupplier().getSupplierName();
				String d = c.getTmCmLookupDet().getLookupDetDescEn();
				String u = ""+c.getTmUlb().getUlbId();
			}
		return ret;
	}

}
