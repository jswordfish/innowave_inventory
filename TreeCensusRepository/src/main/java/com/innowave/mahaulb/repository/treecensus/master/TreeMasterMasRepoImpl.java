package com.innowave.mahaulb.repository.treecensus.master;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.innowave.mahaulb.common.dao.TmCmLookup;
import com.innowave.mahaulb.common.dao.TmCmLookupDet;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeMasterMas;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeNameMaster;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyUploadList;

 
@Repository
@Transactional
public class TreeMasterMasRepoImpl implements TreeMasterMasRepo {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Serializable save(TmTreeMasterMas tmTreeMasterMas) {
		
		return sessionFactory.getCurrentSession().save(tmTreeMasterMas);
	}

	
	// Get Data from tm_tree_master_mas Based on English, Marathi and lookup_det_id
	@Override
	public List<TmTreeMasterMas> getTreeMasterMasList(TmTreeMasterMas tmTreeMasterMas) {
		Session session = sessionFactory.getCurrentSession();
	    CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<TmTreeMasterMas> query = builder.createQuery(TmTreeMasterMas.class);
		Root<TmTreeMasterMas> root = query.from(TmTreeMasterMas.class);
		Root<TmCmLookupDet> root1 = query.from(TmCmLookupDet.class);
		Root<TmCmLookup> root2= query.from(TmCmLookup.class);
		query.multiselect(root.get("treemasId"),root.get("treemasDescEn"),root.get("treemasDescMh"),root.get("status"));
	
	
	
	   String lookupDetValue="";
	   String lookupDetValue2 = tmTreeMasterMas.getTtLookupDet().getLookupDetValue();
	   if(lookupDetValue2=="FNM"){
		   lookupDetValue="FNM";
	   }else if(lookupDetValue2=="TSM"){
		   lookupDetValue="TSM";
	   }else if(lookupDetValue2=="BSM"){
		   lookupDetValue="BSM";
	   }else if(lookupDetValue2=="LSM"){
		   lookupDetValue="LSM";
	   }else if(lookupDetValue2=="LCM"){
		   lookupDetValue="LCM";
	   }else if(lookupDetValue2=="BSM"){
		   lookupDetValue="BSM";
	   }else if(lookupDetValue2=="LSM"){
		   lookupDetValue="LSM";
	   }else if(lookupDetValue2=="FRM"){
		   lookupDetValue="FRM";
	   }else if(lookupDetValue2=="SMA"){
		   lookupDetValue="SMA";
	   }else if(lookupDetValue2=="ODM"){
		   lookupDetValue="ODM";
	   }else if(lookupDetValue2=="TST"){
		   lookupDetValue="TST";
	   }
		Predicate Where = builder.conjunction();
	   
	   Where=builder.equal(root.get("ulbId"),tmTreeMasterMas.getUlbId());
	   Where=builder.and(Where, builder.equal(root2.get("lookupCode"),"TRM"));
	   
	   if(!lookupDetValue.isEmpty()){
		   Where=builder.and(Where, builder.equal(root1.get("lookupDetValue"),lookupDetValue));   
	   }
	   
	 Where=builder.and(Where, builder.equal(root1.get("tmCmLookup").get("lookupId"),root2.get("lookupId")));
	   Where=builder.and(Where, builder.equal(root.get("ttLookupDet").get("lookupDetId"),root1.get("lookupDetId")));
	   Where= builder.and(Where,builder.or(builder.like(builder.upper(root.get("treemasDescEn")),'%'+tmTreeMasterMas.getTreemasDescEn().trim().toUpperCase() +'%') ),
				builder.like(builder.upper(root.get("treemasDescMh")),'%'+tmTreeMasterMas.getTreemasDescEn().trim().toUpperCase() +'%'));
		query = query.where(Where);
        Query<TmTreeMasterMas> q=session.createQuery(query); 
      System.out.println(q.getQueryString());
        return q.getResultList();
        
	}
	
	
	@Override
	public void delete(TmTreeMasterMas tmTreeMasterMas) {
		Session session = sessionFactory.getCurrentSession();
		//session.delete(tmTreeMasterMas);
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaUpdate<TmTreeMasterMas> criteria = builder.createCriteriaUpdate(TmTreeMasterMas.class);
		Root<TmTreeMasterMas> root = criteria.from(TmTreeMasterMas.class);
		criteria.set(root.get("status"),0);
		criteria.where(builder.equal(root.get("treemasId"), tmTreeMasterMas.getTreemasId()));
		session.createQuery(criteria).executeUpdate();
	}

	@Override
	public void update(TmTreeMasterMas tmTreeMasterMas) {
		Session session = sessionFactory.getCurrentSession();
		//session.update(tmTreeMasterMas);
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaUpdate<TmTreeMasterMas> criteria = builder.createCriteriaUpdate(TmTreeMasterMas.class);
		Root<TmTreeMasterMas> root = criteria.from(TmTreeMasterMas.class);
		criteria.set(root.get("status"), tmTreeMasterMas.getStatus());
		criteria.set(root.get("treemasDescEn"), tmTreeMasterMas.getTreemasDescEn());
		criteria.set(root.get("treemasDescMh"), tmTreeMasterMas.getTreemasDescMh());
		criteria.set(root.get("updatedBy"), tmTreeMasterMas.getUpdatedBy());
		criteria.set(root.get("updatedDate"), tmTreeMasterMas.getUpdatedDate());
		criteria.where(builder.equal(root.get("treemasId"), tmTreeMasterMas.getTreemasId()));
		session.createQuery(criteria).executeUpdate();
		
	}
	
	@Override
	public Set<TmTreeMasterMas> getTreeMasterDetails(String lookupCode) {
		/*Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(TmCmLookupDet.class).add(Restrictions.eq("lookupDetValue", lookupCode));
		TmCmLookupDet tmCmLookupDet = (TmCmLookupDet) criteria.list().get(0);
		
		Hibernate.initialize(tmCmLookupDet.getTmTreeMasterMasList());
		
		return tmCmLookupDet.getTmTreeMasterMasList();*/
		return null;
	}

	@Override
	public Set<TmTreeNameMaster> getTreeNameDetailsServ(String treeNameType, String searchString) {
		
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(TmTreeNameMaster.class);
		
		if(treeNameType.equalsIgnoreCase("scientific")){
			criteria.add(Restrictions.ilike("treeSciNameEn", "%"+searchString+"%"));
		}
		if(treeNameType.equalsIgnoreCase("vernacular")){
			criteria.add(Restrictions.ilike("treeVerNameEn", "%"+searchString+"%"));
		}
		if(treeNameType.equalsIgnoreCase("treecommon")){
			criteria.add(Restrictions.ilike("treeComNameEn", "%"+searchString+"%"));
		}
		if(treeNameType.equalsIgnoreCase("treefamily")){
			criteria.add(Restrictions.ilike("treeFamNameEn", "%"+searchString+"%"));
		}
		
		@SuppressWarnings("unchecked")
		List<TmTreeNameMaster> tmTreeNameMaster = criteria.list();
		Set<TmTreeNameMaster> tmTreeNameMasterSet=new HashSet<TmTreeNameMaster>(tmTreeNameMaster);
		return tmTreeNameMasterSet;

	}

	@Override
	public Serializable saveApplicationSurveyInspector(TtTreeSurveyDetails ttTreeSurveyDetails) {
		return sessionFactory.getCurrentSession().save(ttTreeSurveyDetails);
	}
	@Override
	public <TmTreeMaster> Serializable saveTreeMasterDetailsRepo(TmTreeNameMaster tmTreeNameMaster) {
		return sessionFactory.getCurrentSession().save(tmTreeNameMaster);
	}
	public Serializable saveApplicationSurveyDetails(TtTreeSurveyDetails ttTreeSurveyDetails) {
		return sessionFactory.getCurrentSession().save(ttTreeSurveyDetails);
	}


	@Override
	public List<TmTreeMasterMas> getMasterDataListServ(String prefix, String searchString, int ulbIdAuto) 
	{
		
		/*select * from commanconfig.tm_cm_lookup_det where lookup_det_value='FNM' and ulb_id=999;
		 * 
		 * 
		 * 
		select * from treecensus.tm_tree_master_mas where lookup_det_id=8
*/
		Session session = sessionFactory.getCurrentSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
        CriteriaQuery<TmTreeMasterMas> searchQuery = builder.createQuery(TmTreeMasterMas.class);
        
        Root<TmTreeMasterMas> aRoot = searchQuery.from(TmTreeMasterMas.class);
        
        Root<TmCmLookupDet> bJoin = searchQuery.from(TmCmLookupDet.class);
        
        Predicate where = builder.conjunction();
        
        searchQuery.select(aRoot).where(builder.equal(bJoin.get("lookupDetValue"), prefix));
        
        where = builder.equal(bJoin.get("ulbId"),999);
        where = builder.and(where, (builder.equal(bJoin.get("lookupDetValue"), prefix)));
        where = builder.and(where, (builder.equal(bJoin.get("lookupDetId"), aRoot.get("ttLookupDet").get("lookupDetId"))));
        
        if(searchString != null && !searchString.equalsIgnoreCase("")){
        where = builder.and(where, builder.like(builder.lower(aRoot.get("treemasDescEn")), "%"+searchString.toLowerCase()+"%"));
        }
        //where = builder.and(where, builder.equal(bJoin.get("ulbId"), ulbIdAuto));
        
       
        
        //where = builder.and(where, builder.equal(aRoot.get("lookupDetId"),bJoin.get("ttLookupDet").get("lookupDetId")));
        
        searchQuery = searchQuery.where(where);
		Query<TmTreeMasterMas> q=session.createQuery(searchQuery);
        return q.getResultList();
        
	}


	@Override
	public TmCmLookup getLookupId(String prefix) {
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<TmCmLookup> query = builder.createQuery(TmCmLookup.class);
		Root<TmCmLookup> root = query.from(TmCmLookup.class);
		
		if(prefix != null && !prefix.isEmpty())
		{
			Predicate where = builder.conjunction();
			where = builder.equal(root.get("lookupCode"),prefix);
			query = query.where(where);
		}
		Query<TmCmLookup> queryObj=session.createQuery(query);
		
		return queryObj.uniqueResult();
	}


	@Override
	public List<TmCmLookupDet> getLookupDetId(int ulbId, int id) {
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<TmCmLookupDet> query = builder.createQuery(TmCmLookupDet.class);
		Root<TmCmLookupDet> root = query.from(TmCmLookupDet.class);
		
		if(id != 0)
		{
			Predicate where = builder.conjunction();
			where = builder.equal(root.get("tmCmLookup").get("lookupId"),id);
			//where = builder.and(where, builder.equal(root.get("ulbId"),ulbId));
			query = query.where(where);
		}
		
		Query<TmCmLookupDet> queryObj=session.createQuery(query);
		List<TmCmLookupDet> list=queryObj.getResultList();
		return list;
	}


	@Override
	public void saveImageUrl(TtTreeSurveyUploadList ttTreeSurveyUploadList) {
		sessionFactory.getCurrentSession().save(ttTreeSurveyUploadList);
		
	}


	@Override
	public Set<TtTreeSurveyDetails> getDataBySrnNumber(String treeNameType, String searchString) {
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<TtTreeSurveyDetails> query = builder.createQuery(TtTreeSurveyDetails.class);
		Root<TtTreeSurveyDetails> root = query.from(TtTreeSurveyDetails.class);
		
		/*String queryforInitiator = "select count(*) as n_count from commanconfig.tm_cm_initiator_group_det t where t.user_id = "+userId+" and t.ulb_id="+ulbId;
		Query builder = session.createNativeQuery(queryforInitiator);*/
		
		query.multiselect(root.get("treeSurveyId"),root.get("surveyDate"),root.get("treemasIdTsm"),root.get("treemasIdLsm"),root.get("treemasIdBsm"),
				root.get("treemasIdTms"),root.get("treemasIdLcm"),root.get("treemasIdCom"),root.get("treemasIdFnm"),root.get("treemasIdFrm"),root.get("treemasIdOdm"),
				root.get("treemasIdSma"),root.get("treemasIdTst"),root.get("sizeValue"),root.get("girthAtBreastHieght"),root.get("hieght"),root.get("approxAge")
				,root.get("canopyWidth"),root.get("msebCtcNo"),root.get("location"),root.get("apartmentComplex"),root.get("road"),root.get("building"),root.get("locality"),
				root.get("observationRemarks"),root.get("surveyNumber"),root.get("treeIdentificationNo"),root.get("longitude"),root.get("latitude"),root.get("tmTreeNameMaster"),
				root.get("lookupDetHierIdAwz1"),root.get("lookupDetHierIdAwz2"));
		
		Predicate where = builder.conjunction();
		
		if(treeNameType.equalsIgnoreCase("srn")){
			where = builder.like(root.get("surveyNumber"),"%"+searchString+"%");
			query = query.where(where);
		}
		
		if(treeNameType.equalsIgnoreCase("treeid")){
			where = builder.like(root.get("treeIdentificationNo"),"%"+searchString+"%");
			query = query.where(where);
		}
		
		Query<TtTreeSurveyDetails> queryObj=session.createQuery(query);
		List<TtTreeSurveyDetails> tmTreeNameMaster = queryObj.getResultList();
		Set<TtTreeSurveyDetails> tmTreeNameMasterSet=new HashSet<TtTreeSurveyDetails>(tmTreeNameMaster);
		return tmTreeNameMasterSet;
	}

}
