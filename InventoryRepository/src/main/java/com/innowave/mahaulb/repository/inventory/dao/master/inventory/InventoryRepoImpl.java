package com.innowave.mahaulb.repository.inventory.dao.master.inventory;

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

import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialType;

@Repository
@Transactional
public class InventoryRepoImpl implements InventoryRepo{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<TmInvMaterialType> getTreeNameMasterList(
			TmInvMaterialType treeNameSearchDto) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<TmInvMaterialType> query = builder.createQuery(TmInvMaterialType.class);
		Root<TmInvMaterialType> root = query.from(TmInvMaterialType.class);
		query.multiselect(root.get("materialTypeId"),root.get("materialTypeCode"),root.get("materialTypeName"),root.get("parentTypeYn"),root.get("createdBy"),root.get("createdDate"),root.get("updatedBy"),root.get("updatedDate"),root.get("ipAddress"));
		Predicate where = builder.conjunction();
		System.out.println(treeNameSearchDto.getTmUlb().getUlbId());
		where = builder.equal(root.get("ulbId"),treeNameSearchDto.getTmUlb().getUlbId());
		query.select(root).where(where);
		
        Query<TmInvMaterialType> q=session.createQuery(query); 
        System.out.println("queryyh"+q.getQueryString());
        return q.getResultList();
	}

}
