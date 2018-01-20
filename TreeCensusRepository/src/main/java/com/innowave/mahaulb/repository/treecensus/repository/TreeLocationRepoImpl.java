package com.innowave.mahaulb.repository.treecensus.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.innowave.mahaulb.common.dao.TmCmApartment;
import com.innowave.mahaulb.common.dao.TmCmLocality;
import com.innowave.mahaulb.common.dao.TmCmRoad;
import com.innowave.mahaulb.common.dao.master.TmCmLocation;
import com.innowave.mahaulb.common.dao.master.TmCmScrutinyLevelDet;
import com.innowave.mahaulb.common.dao.trans.TtServiceRequest;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;

@Repository
@Transactional
public class TreeLocationRepoImpl implements TreeLocationRepo {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int saveLocationData(TtTreeSurveyDetails ttTreeSurveyDetails) {
		System.out.println("Inside TreeLocationRepoImpl");
		Session session = sessionFactory.getCurrentSession();
		int l=(int) session.save(ttTreeSurveyDetails);
		return  l;
	}

	@Override
	public ArrayList<Object[]> getTreeLocationData(int ulbId, long srnId) {

		System.out.println("repo");
		ArrayList<Object[]> arraylist=new ArrayList<>();
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
		Root<TtServiceRequest> root = query.from(TtServiceRequest.class);
		Root<TtTreeSurveyDetails> root1 = query.from(TtTreeSurveyDetails.class);
		Root<TmCmLocation> location = query.from(TmCmLocation.class);
		Root<TmCmLocality> locality = query.from(TmCmLocality.class);
		Root<TmCmRoad> road = query.from(TmCmRoad.class);
		Root<TmCmApartment> apartment = query.from(TmCmApartment.class);
		query.multiselect(root.get("srnId"),root.get("applicantName"),location.get("locationName"),apartment.get("apartmentName"),road.get("roadName"),locality.get("localityName")
				,root1.get("longitude"),root1.get("latitude"),root1.get("lookupDetHierIdAwz1"),root1.get("lookupDetHierIdAwz2"));
		Predicate where = builder.conjunction();
		where = builder.equal(root.get("ulbId"),ulbId);
		where = builder.and(where,builder.equal(root.get("srnId"),srnId));
		where = builder.and(where,builder.equal(root.get("srnId"),root1.get("ttServiceRequest").get("srnId")));
		
	    if(location.get("locationId")!=null && root1.get("tmCmLocation").get("locationId")!=null){	
     		where = builder.and(where,builder.equal(location.get("locationId"),root1.get("tmCmLocation").get("locationId")));
	    }
	    if(apartment.get("apartmentId")!=null && root1.get("tmCmApartment").get("apartmentId")!=null){	
		  where = builder.and(where,builder.equal(apartment.get("apartmentId"),root1.get("tmCmApartment").get("apartmentId")));
	    }
	    if(road.get("roadId")!=null && root1.get("tmCmRoad").get("roadId")!=null){	
		  where = builder.and(where,builder.equal(road.get("roadId"),root1.get("tmCmRoad").get("roadId")));
	    }
	    if(locality.get("localityId")!=null && root1.get("tmCmLocality").get("localityId")!=null){	
		  where = builder.and(where,builder.equal(locality.get("localityId"),root1.get("tmCmLocality").get("localityId")));
	    }
		query = query.where(where);
        Query<Object[]> q = session.createQuery(query); 
        Object[] list=q.setMaxResults(1).uniqueResult();
        System.out.println("queryyh"+q.getQueryString());
        System.out.println(list.length);
        arraylist.add(list);
        System.out.println("queryyh"+q.getQueryString());
        try{
        	System.out.println("print");
        	Object arr[]=new Object[2];
        	if (list != null && list.length >0){
        		if(Integer.parseInt(list[8].toString()) != 0 && list[8] != null){
        		
        	   	 String queryy5 ="select lookup_det_hier_desc_en " +
        					"  from commanconfig.tm_cm_lookup_det_hierarchical where lookup_det_hier_id = "+list[8];	
        	   	   
        	        Query builderr5 = session.createNativeQuery(queryy5);
        	        Object uniqueResult = builderr5.uniqueResult();
        	        arr[0]=uniqueResult;
        	        arraylist.add(arr);	
        		}
        		
        		if(Integer.parseInt(list[9].toString()) != 0 && list[9] != null){
        	       String queryy6 ="select lookup_det_hier_desc_en " +
        	   				"  from commanconfig.tm_cm_lookup_det_hierarchical where lookup_det_hier_id = '"+list[9]+"' ";
        		 	
        		 	Query builderr6 = session.createNativeQuery(queryy6);
        		 	 Object uniqueResult2 = builderr6.uniqueResult();
        		 	 arr[1]=uniqueResult2;
        		 	arraylist.add(arr);	
        		}
        	       }
        	
        }finally{
        	  return arraylist;
        }
       
	}
	

}
