package  com.innowave.mahaulb.repository.inventory.repo;

import java.util.List;

import com.innowave.mahaulb.common.dao.master.TmCmDepartment;
import com.innowave.mahaulb.repository.inventory.dao.master.TmInvMaterialType;

public interface MaterialTypeRepo {
	
	public void saveOrUpdate(TmInvMaterialType materialType);
	
	public TmInvMaterialType getById(Long id);
	
	public TmInvMaterialType findTmInvMaterialType(Long materialTypeId, String materialTypeCode, Integer ulbId);
	
	public List<TmCmDepartment> getAllDepartments(Integer ulbId);
	
	
	public List<TmInvMaterialType> findTmInvMaterialTypesByULB(Integer ulbId);
	
	public List<TmInvMaterialType> getMasterTypeistByUlbAndParentTyp(Integer ulbId,String parentMaterialType);
	
	public List<TmInvMaterialType> fetchMaterialTypeByParentType(Integer ulbId,String materialType, String parentMaterialType);
	
	public List<TmInvMaterialType> getParentsList(Integer ulbId,String parentFlag);
	
	public int removeById(TmInvMaterialType invMaterialType);
	

}
