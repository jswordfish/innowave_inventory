package com.innowave.mahaulb.repository.treecensus.master.treename;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeNameMaster;
 
@Repository
@Transactional
public class TreeNameMasterRepoImpl implements TreeNameMasterRepo {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Serializable save(TmTreeNameMaster tmTreeNameMaster) {
		return sessionFactory.getCurrentSession().save(tmTreeNameMaster);
	}

	@Override
	public List<TmTreeNameMaster> getTreeNameMasterList(TmTreeNameMaster tmTreeNameMaster) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<TmTreeNameMaster> query = builder.createQuery(TmTreeNameMaster.class);
		Root<TmTreeNameMaster> root = query.from(TmTreeNameMaster.class);
		query.multiselect(root.get("treenameId"),root.get("treeVerNameEn"),root.get("treeVerNameRg"),root.get("treeSciNameEn"),root.get("treeSciNameRg"),root.get("treeFamNameEn"),root.get("treeFamNameRg"),root.get("treeComNameEn"),root.get("treeComNameRg"),root.get("status"),root.get("lookupDetAesthetic"),root.get("lookupDetCultural"),root.get("lookupDetEcological"),root.get("lookupDetEconomical"));
		Predicate where = builder.conjunction();
		System.out.println(tmTreeNameMaster.getUlbId());
		where = builder.equal(root.get("ulbId"),tmTreeNameMaster.getUlbId());
		boolean isAnd = false;
		
		if(tmTreeNameMaster.getTreeVerNameEn() != null && ! tmTreeNameMaster.getTreeVerNameEn().isEmpty())
		{
			if(!isAnd)
				where = builder.and(where,builder.like(builder.upper(root.get("treeVerNameEn")), '%'+tmTreeNameMaster.getTreeVerNameEn().trim().toUpperCase()+'%'));
			else
				where = builder.or(where,builder.like(builder.upper(root.get("treeVerNameEn")),'%'+ tmTreeNameMaster.getTreeVerNameEn().trim().toUpperCase()+'%'));
			where = builder.or(where,builder.like(root.get("treeVerNameRg"),'%'+ tmTreeNameMaster.getTreeVerNameEn().trim()+'%'));
			isAnd = true;
        }
		if(tmTreeNameMaster.getTreeSciNameEn()!=null && ! tmTreeNameMaster.getTreeSciNameEn().isEmpty())
		{
			if(!isAnd)
				where = builder.and(where,builder.like(builder.upper(root.get("treeSciNameEn")), '%'+tmTreeNameMaster.getTreeSciNameEn().trim().toUpperCase()+'%'));
			else
				where = builder.or(where,builder.like(builder.upper(root.get("treeSciNameEn")),'%'+ tmTreeNameMaster.getTreeSciNameEn().trim().toUpperCase()+'%'));
			where = builder.or(where,builder.like(root.get("treeSciNameRg"),'%'+ tmTreeNameMaster.getTreeSciNameEn().trim()+'%'));
			isAnd = true;
		}
		 if(tmTreeNameMaster.getTreeFamNameEn()!=null && ! tmTreeNameMaster.getTreeFamNameEn().isEmpty())
		{
			 if(!isAnd)
				 where = builder.and(where,builder.like(builder.upper(root.get("treeFamNameEn")), '%'+tmTreeNameMaster.getTreeFamNameEn().trim().toUpperCase()+'%'));
			 else
				 where = builder.or(where,builder.like(builder.upper(root.get("treeFamNameEn")),'%'+ tmTreeNameMaster.getTreeFamNameEn().trim().toUpperCase()+'%'));
			 where = builder.or(where,builder.like(root.get("treeFamNameRg"),'%'+ tmTreeNameMaster.getTreeFamNameEn().trim()+'%'));
		}
		if(tmTreeNameMaster.getTreeComNameEn()!=null && ! tmTreeNameMaster.getTreeComNameEn().isEmpty())
		{
			 if(!isAnd)
				 where = builder.and(where,builder.like(builder.upper(root.get("treeComNameEn")), '%'+tmTreeNameMaster.getTreeComNameEn().trim().toUpperCase()+'%'));
			 else
				 where = builder.or(where,builder.like(builder.upper(root.get("treeComNameEn")),'%'+ tmTreeNameMaster.getTreeComNameEn().trim().toUpperCase()+'%'));
			 where = builder.or(where,builder.like(root.get("treeComNameRg"), '%'+tmTreeNameMaster.getTreeComNameEn().trim()+'%'));
		}
		query.select(root).where(where);
		
        Query<TmTreeNameMaster> q=session.createQuery(query); 
        System.out.println("queryyh"+q.getQueryString());
        return q.getResultList();
	}

	@Override
	public void updateTreeName(TmTreeNameMaster tmTreeNameMaster) {
		Session session = sessionFactory.getCurrentSession();
		//session.update(tmTreeMasterMas);
		System.out.println(tmTreeNameMaster.getStatus());
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaUpdate<TmTreeNameMaster> criteria = builder.createCriteriaUpdate(TmTreeNameMaster.class);
		Root<TmTreeNameMaster> root = criteria.from(TmTreeNameMaster.class);
		criteria.set(root.get("treeVerNameEn"), tmTreeNameMaster.getTreeVerNameEn());
		criteria.set(root.get("treeVerNameRg"), tmTreeNameMaster.getTreeVerNameRg());
		criteria.set(root.get("treeSciNameEn"), tmTreeNameMaster.getTreeSciNameEn());
		criteria.set(root.get("treeSciNameRg"), tmTreeNameMaster.getTreeSciNameRg());
		criteria.set(root.get("treeComNameEn"), tmTreeNameMaster.getTreeComNameEn());
		criteria.set(root.get("treeComNameRg"), tmTreeNameMaster.getTreeComNameRg());
		criteria.set(root.get("treeFamNameEn"), tmTreeNameMaster.getTreeFamNameEn());
		criteria.set(root.get("treeFamNameRg"), tmTreeNameMaster.getTreeFamNameRg());
		
		criteria.set(root.get("treemasIdTsm"), tmTreeNameMaster.getTreemasIdTsm());
		criteria.set(root.get("treemasIdLsm"), tmTreeNameMaster.getTreemasIdLsm());
		criteria.set(root.get("treemasIdBsm"), tmTreeNameMaster.getTreemasIdBsm());
		criteria.set(root.get("treemasIdTms"), tmTreeNameMaster.getTreemasIdTms());
		criteria.set(root.get("treemasIdLcm"), tmTreeNameMaster.getTreemasIdLcm());
		//criteria.set(root.get("treemasIdCom"), tmTreeNameMaster.getTreeFamNameRg());
		criteria.set(root.get("treemasIdFnm"), tmTreeNameMaster.getTreemasIdFnm());
		criteria.set(root.get("treemasIdFrm"), tmTreeNameMaster.getTreemasIdFrm());
		criteria.set(root.get("treemasIdOdm"), tmTreeNameMaster.getTreemasIdOdm());
		criteria.set(root.get("treemasIdSma"), tmTreeNameMaster.getTreemasIdSma());
		
		criteria.set(root.get("status"), tmTreeNameMaster.getStatus());
		criteria.set(root.get("updatedBy"), tmTreeNameMaster.getUpdatedBy());
		criteria.set(root.get("updatedDate"), tmTreeNameMaster.getUpdatedDate());
		criteria.where(builder.equal(root.get("treenameId"), tmTreeNameMaster.getTreenameId()));
		session.createQuery(criteria).executeUpdate();
		
		
	}
	
	
	
	
	

	@Override
	public void deleteTreeName(TmTreeNameMaster tmTreeNameMaster) 
	{
		
		Session session = sessionFactory.getCurrentSession();
		//session.delete(tmTreeMasterMas);
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaUpdate<TmTreeNameMaster> criteria = builder.createCriteriaUpdate(TmTreeNameMaster.class);
		Root<TmTreeNameMaster> root = criteria.from(TmTreeNameMaster.class);
		criteria.set(root.get("status"),0);
		criteria.where(builder.equal(root.get("treenameId"), tmTreeNameMaster.getTreenameId()));
		session.createQuery(criteria).executeUpdate();
		
		
		
		/*Session session = sessionFactory.getCurrentSession();
		
		session.delete(tmTreeNameMaster);*/
	}

	@Override
	public List<Object[]> getTreeNameDet(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		String query="SELECT b.treemas_id, b.lookup_det_id, b.treemas_desc_en FROM treecensus.tm_tree_name_master a, treecensus.tm_tree_master_mas b "
				+ "where a.treename_id = "+id+" and a.treemas_id_tsm = b.treemas_id "
				+ "union "
				+ "SELECT b.treemas_id, b.lookup_det_id, b.treemas_desc_en FROM treecensus.tm_tree_name_master a, treecensus.tm_tree_master_mas b "
				+ "where a.treename_id = "+id+" and a.treemas_id_lsm = b.treemas_id "
				+ "union "
				+ "SELECT b.treemas_id, b.lookup_det_id, b.treemas_desc_en FROM treecensus.tm_tree_name_master a, treecensus.tm_tree_master_mas b "
				+ "where a.treename_id = "+id+" and a.treemas_id_bsm = b.treemas_id "
				+ "union "
				+ "SELECT b.treemas_id, b.lookup_det_id, b.treemas_desc_en FROM treecensus.tm_tree_name_master a, treecensus.tm_tree_master_mas b "
				+ "where a.treename_id = "+id+" and a.treemas_id_tms = b.treemas_id "
				+ "union "
				+ "SELECT b.treemas_id, b.lookup_det_id, b.treemas_desc_en FROM treecensus.tm_tree_name_master a, treecensus.tm_tree_master_mas b "
				+ "where a.treename_id = "+id+" and a.treemas_id_lcm = b.treemas_id "
				+ "union "
				+ "SELECT b.treemas_id, b.lookup_det_id, b.treemas_desc_en FROM treecensus.tm_tree_name_master a, treecensus.tm_tree_master_mas b "
				+ "where a.treename_id = "+id+" and a.treemas_id_com = b.treemas_id "
				+ "union "
				+ "SELECT b.treemas_id, b.lookup_det_id, b.treemas_desc_en FROM treecensus.tm_tree_name_master a, treecensus.tm_tree_master_mas b "
				+ "where a.treename_id = "+id+" and a.treemas_id_fnm = b.treemas_id "
				+ "union "
				+ "SELECT b.treemas_id, b.lookup_det_id, b.treemas_desc_en FROM treecensus.tm_tree_name_master a, treecensus.tm_tree_master_mas b "
				+ "where a.treename_id = "+id+" and a.treemas_id_frm = b.treemas_id "
				+ "union "
				+ "SELECT b.treemas_id, b.lookup_det_id, b.treemas_desc_en FROM treecensus.tm_tree_name_master a, treecensus.tm_tree_master_mas b "
				+ "where a.treename_id = "+id+" and a.treemas_id_odm = b.treemas_id "
				+ "union "
				+ "SELECT b.treemas_id, b.lookup_det_id, b.treemas_desc_en FROM treecensus.tm_tree_name_master a, treecensus.tm_tree_master_mas b "
				+ "where a.treename_id = "+id+" and a.treemas_id_sma = b.treemas_id "
				+ "union "
				+ "SELECT b.treemas_id, b.lookup_det_id, b.treemas_desc_en FROM treecensus.tm_tree_name_master a, treecensus.tm_tree_master_mas b "
				+ "where a.treename_id = "+id+" and a.treemas_id_tst = b.treemas_id ";
		
		Query builder = session.createNativeQuery(query);
		List<Object[]> list = builder.getResultList();
		
		return list;
	}
}
