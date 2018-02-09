package  com.innowave.mahaulb.repository.inventory.repo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
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

import com.innowave.mahaulb.common.dao.master.TmCmDepartment;
import com.innowave.mahaulb.common.repository.TmCmDepartmentRepo;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialType;
@Repository
@Transactional
public class MaterialTypeRepoImpl implements MaterialTypeRepo{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	TmCmDepartmentRepo depRepo;
	
	@Override
	public void saveOrUpdate(TmInvMaterialType materialType) {
		materialType.setCreatedDate(new Date());
			TmInvMaterialType invMaterialType = findTmInvMaterialType(materialType.getMaterialTypeId(), materialType.getMaterialTypeCode(), materialType.getTmUlb().getUlbId());
			if( invMaterialType == null) {
				//create
				sessionFactory.getCurrentSession().save(materialType);
			}
			else {
				//update
				Mapper mapper = new DozerBeanMapper();
				mapper.map(materialType, invMaterialType);
				invMaterialType.setUpdatedDate(new Date());
				sessionFactory.getCurrentSession().merge(invMaterialType);
			}
		
		
		
		System.out.println("done");
	}
	
	//this method is for quering to fetch the parent material type list
	@Override
	public List<TmInvMaterialType> getMasterTypeistByUlbAndParentTyp(Integer ulbId,String parentMaterialTypeFlag) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<TmInvMaterialType> query = builder.createQuery(TmInvMaterialType.class);
		Root<TmInvMaterialType> root = query.from(TmInvMaterialType.class);
		Predicate where = builder.conjunction();
		where = builder.equal(root.get("tmUlb").get("ulbId"),ulbId);
		where = builder.and(where, builder.equal(root.get("parentTypeYn"), parentMaterialTypeFlag));
		query = query.where(where);
		query.select(root);
        Query<TmInvMaterialType> q=session.createQuery(query); 
        return q.getResultList();
	}

	@Override
	public TmInvMaterialType findTmInvMaterialType(Long materialTypeId, String materialTypeCode, Integer ulbId) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<TmInvMaterialType> query = builder.createQuery(TmInvMaterialType.class);
		Root<TmInvMaterialType> root = query.from(TmInvMaterialType.class);
		
		
	
			Predicate where = builder.conjunction();
			where = builder.equal(root.get("materialTypeCode"),materialTypeCode);
			where = builder.and(where, builder.equal(root.get("materialTypeId"), materialTypeId));
			where  = builder.and(where, builder.equal(root.get("tmUlb").get("ulbId"), ulbId));
			query = query.where(where);
			String wry = query.toString();
		
		Query<TmInvMaterialType> queryObj=currentSession.createQuery(query);
		
		return queryObj.uniqueResult();
	}

	
	public List<TmCmDepartment> getAllDepartments(Integer ulbId){
		List<Object[]> deps = depRepo.getDeparmentList();
		List<TmCmDepartment> departments = new ArrayList<>();
		for(Object obj[] : deps) {
			TmCmDepartment department = new TmCmDepartment();
			
				department.setDepId((Integer)obj[0]);
				department.setDepCode((String)obj[1]);
				department.setDepNameEn((String)obj[2]);
				department.setDepNameRg((String) obj[3]);
				departments.add(department);
			
		}
		return departments;
	}

	@Override
	public List<TmInvMaterialType> findTmInvMaterialTypesByULB(Integer ulbId) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<TmInvMaterialType> query = builder.createQuery(TmInvMaterialType.class);
		Root<TmInvMaterialType> root = query.from(TmInvMaterialType.class);
			Predicate where = builder.conjunction();
			where  = builder.equal(root.get("tmUlb").get("ulbId"), ulbId);
			query = query.where(where);
		Query<TmInvMaterialType> queryObj=currentSession.createQuery(query);
		return queryObj.getResultList();
	}

	@Override
	public TmInvMaterialType getById(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<TmInvMaterialType> query = builder.createQuery(TmInvMaterialType.class);
		Root<TmInvMaterialType> root = query.from(TmInvMaterialType.class);
		
		
	
			Predicate where = builder.conjunction();
			where = builder.equal(root.get("materialTypeId"),id);
			
			query = query.where(where);
			String wry = query.toString();
		
		Query<TmInvMaterialType> queryObj=currentSession.createQuery(query);
		
		return queryObj.uniqueResult();
	}

	@Override
	public List<TmInvMaterialType> fetchMaterialTypeByParentType(Integer ulbId,
			String materialType, String parentMaterialType) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<TmInvMaterialType> query = builder.createQuery(TmInvMaterialType.class);
		Root<TmInvMaterialType> root = query.from(TmInvMaterialType.class);
			Predicate where = builder.conjunction();
			where  = builder.equal(root.get("tmUlb").get("ulbId"), ulbId);
			where  = builder.and(where,builder.equal(root.get("materialTypeId"), materialType));
			where  = builder.and(where,builder.equal(root.get("parentTypeYn"), parentMaterialType));
			query = query.where(where);
		Query<TmInvMaterialType> queryObj=currentSession.createQuery(query);
		return queryObj.getResultList();
	}
}
