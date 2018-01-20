package com.innowave.mahaulb.repository.treecensus.repository;

import java.util.ArrayList;

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

import com.innowave.mahaulb.common.dao.TmCmApartment;
import com.innowave.mahaulb.common.dao.TmCmLocality;
import com.innowave.mahaulb.common.dao.TmCmRoad;
import com.innowave.mahaulb.common.dao.master.TmCmLocation;
import com.innowave.mahaulb.common.dao.trans.TtServiceRequest;
import com.innowave.mahaulb.repository.treecensus.dao.trans.TtTreeSurveyDetails;

@Repository
@Transactional
public class TreeCensusSurvyAppInspctrRepoImpl implements TreeCensusSurvyAppInspctrRepo {
	@Autowired
	private SessionFactory sessionFactory;
	public ArrayList<Object[]> getServiceRequestDetails(Long srnId,Integer ulbId){
		System.out.println("repo");
		ArrayList<Object[]> arraylist = new ArrayList<>();
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
		Root<TtServiceRequest> root = query.from(TtServiceRequest.class);
		Root<TtTreeSurveyDetails> root1 = query.from(TtTreeSurveyDetails.class);
		Root<TmCmLocation> location = query.from(TmCmLocation.class);
		Root<TmCmLocality> locality = query.from(TmCmLocality.class);
		Root<TmCmRoad> road = query.from(TmCmRoad.class);
		Root<TmCmApartment> apartment = query.from(TmCmApartment.class);
		query.multiselect(root.get("srnId"), root.get("applicantName"), root.get("applicantMobile"),
				root.get("applicantEmail"), root.get("applicantUid"), root.get("applicantAddress"),
				root.get("organisationName"), root.get("organisationAddress"), location.get("locationName"),
				apartment.get("apartmentName"), road.get("roadName"), locality.get("localityName"),
				root1.get("longitude"), root1.get("latitude"), root1.get("lookupDetHierIdAwz1"),
				root1.get("lookupDetHierIdAwz2"));
		Predicate where = builder.conjunction();
		where = builder.equal(root.get("ulbId"), ulbId);
		where = builder.and(where, builder.equal(root.get("srnId"), srnId));
		where = builder.and(where, builder.equal(root.get("srnId"), root1.get("ttServiceRequest").get("srnId")));

		if (location.get("locationId") != null && root1.get("tmCmLocation").get("locationId") != null) {
			where = builder.and(where,
					builder.equal(location.get("locationId"), root1.get("tmCmLocation").get("locationId")));
		}
		if (apartment.get("apartmentId") != null && root1.get("tmCmApartment").get("apartmentId") != null) {
			where = builder.and(where,
					builder.equal(apartment.get("apartmentId"), root1.get("tmCmApartment").get("apartmentId")));
		}
		if (road.get("roadId") != null && root1.get("tmCmRoad").get("roadId") != null) {
			where = builder.and(where, builder.equal(road.get("roadId"), root1.get("tmCmRoad").get("roadId")));
		}
		if (locality.get("localityId") != null && root1.get("tmCmLocality").get("localityId") != null) {
			where = builder.and(where,
					builder.equal(locality.get("localityId"), root1.get("tmCmLocality").get("localityId")));
		}
		query = query.where(where);
		Query<Object[]> q = session.createQuery(query);
		Object[] list = q.setMaxResults(1).uniqueResult();
		System.out.println("queryyh" + q.getQueryString());
		System.out.println(list.length);
		arraylist.add(list);
		System.out.println("queryyh" + q.getQueryString());
		try {
			System.out.println("print");
			Object arr[] = new Object[2];
			if (list != null) {
				String queryy5 = "select lookup_det_hier_desc_en "
						+ "  from commanconfig.tm_cm_lookup_det_hierarchical where lookup_det_hier_id = '" + list[14]
						+ "' ";

				Query builderr5 = session.createNativeQuery(queryy5);
				Object uniqueResult = builderr5.uniqueResult();
				arr[0] = uniqueResult;
				arraylist.add(arr);
			}

			if (list != null) {
				if  (!list[15].equals(null)) {
					String queryy6 = "select lookup_det_hier_desc_en "
							+ "  from commanconfig.tm_cm_lookup_det_hierarchical where lookup_det_hier_id = '" + list[15]
							+ "' ";
					Query builderr6 = session.createNativeQuery(queryy6);
					Object uniqueResult2 = builderr6.uniqueResult();
					arr[1] = uniqueResult2;
					arraylist.add(arr);
				}
			}

		} finally {
			return arraylist;
		}

	}

	@Override
	public String updateTreecensusInspectionData(TtTreeSurveyDetails ttTreeSurveyDetails) {
		Session session = sessionFactory.getCurrentSession();
		String query = "select tree_survey_id " + "  from treecensus.tt_tree_survey_details where srn_id = '"
				+ ttTreeSurveyDetails.getTtServiceRequest().getSrnId() + "' ";
		Query builder = session.createNativeQuery(query);
		Integer tree_survey_id = (Integer) builder.uniqueResult();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		// ttTreeSurveyDetails.getTtServiceRequest().getSrnId()
		TtTreeSurveyDetails load = session.load(TtTreeSurveyDetails.class, tree_survey_id);
		load.setObservationRemarks(ttTreeSurveyDetails.getObservationRemarks());
		load.setLatitude(ttTreeSurveyDetails.getLatitude());
		load.setLongitude(ttTreeSurveyDetails.getLongitude());
		load.setLocality(ttTreeSurveyDetails.getLocality());
		load.setBuilding(ttTreeSurveyDetails.getBuilding());
		load.setRoad(ttTreeSurveyDetails.getRoad());
		load.setApartmentComplex(ttTreeSurveyDetails.getApartmentComplex());
		load.setLocation(ttTreeSurveyDetails.getLocation());
		load.setSurveyDate(ttTreeSurveyDetails.getSurveyDate());
		load.setGirthAtBreastHieght(ttTreeSurveyDetails.getGirthAtBreastHieght());
		load.setApproxAge(ttTreeSurveyDetails.getApproxAge());
		load.setCanopyWidth(ttTreeSurveyDetails.getCanopyWidth());
		load.setHieght(ttTreeSurveyDetails.getHieght());
		load.setSizeValue(ttTreeSurveyDetails.getSizeValue());
		load.setMsebCtcNo(ttTreeSurveyDetails.getMsebCtcNo());
		load.setTreemasIdBsm(ttTreeSurveyDetails.getTreemasIdBsm());
		load.setTreemasIdCom(ttTreeSurveyDetails.getTreemasIdCom());
		load.setTreemasIdFrm(ttTreeSurveyDetails.getTreemasIdFrm());
		load.setTreemasIdFnm(ttTreeSurveyDetails.getTreemasIdFnm());
		load.setTreemasIdLcm(ttTreeSurveyDetails.getTreemasIdLcm());
		load.setTreemasIdLsm(ttTreeSurveyDetails.getTreemasIdLsm());
		load.setTreemasIdOdm(ttTreeSurveyDetails.getTreemasIdOdm());
		load.setTreemasIdSma(ttTreeSurveyDetails.getTreemasIdSma());
		load.setTreemasIdTms(ttTreeSurveyDetails.getTreemasIdTms());
		load.setTreemasIdTsm(ttTreeSurveyDetails.getTreemasIdTsm());
		load.setTreemasIdTst(ttTreeSurveyDetails.getTreemasIdTst());
		return "success";
	}

}