package com.innowave.mahaulb.repository.treecensus.repo;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

import com.innowave.mahaulb.common.dao.TmCmFinancialMas;
import com.innowave.mahaulb.common.dao.TmCmModule;
import com.innowave.mahaulb.common.dao.TmCmServices;
import com.innowave.mahaulb.common.dao.TmUlb;
import com.innowave.mahaulb.repository.treecensus.dao.master.TmTreeRefsequence;

@Repository
@Transactional
public class GetTreeSeqNoRepoImpl implements GetTreeSeqNoRepo{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String getAutoConnectionLoiNo(int modId, int ulbId, String tabName, String fldName, char year,Date userDefDt) throws ParseException {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		
		
		int status = 1;
        Long seqNo = null,updatedSeqNo;
        String newConnectionNo = null;
        
        SimpleDateFormat pFinanDt = new SimpleDateFormat("yyyy-MM-dd");
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        
        Date fiDt;
		fiDt = pFinanDt.parse(timeStamp);
		Date finanDt = getFinancialDate(userDefDt);
		Date fDt = getCurrentYear();
		Date fromFinanDt = getFromFinancialDate(userDefDt);
		Date startCurrYear = getStartCurrentYear();
        
		Date startUserDefDate = getStartUserDefCurrentYear(userDefDt);
		Date lastUserDefDate = getLastUserDefCurrentYear(userDefDt);
        //Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<TmTreeRefsequence> query = builder.createQuery(TmTreeRefsequence.class);
        Root<TmTreeRefsequence> root = query.from(TmTreeRefsequence.class);
        
        CriteriaQuery<TmUlb> tmUlbQuery = builder.createQuery(TmUlb.class);                
        Root<TmUlb> tmUlb = tmUlbQuery.from(TmUlb.class);
        
        Predicate where = builder.conjunction();
       if(year == 'F') {
        //query.multiselect(root.get("bankBranchId"),root.get("bankBranch"));
        
        where = builder.equal(root.get("modId"),modId);                
        where = builder.and(where,builder.equal(root.get("ulbId"),ulbId)); 
        where = builder.and(where,builder.equal(root.get("refseqTblName"),tabName));
        where = builder.and(where,builder.equal(root.get("refseqFldName"),fldName));
        where = builder.and(where,builder.equal(root.get("refseqRstTyp"),year));
        where = builder.and(where,builder.equal(root.get("refseqStrDate"),fromFinanDt));
        where = builder.and(where,builder.equal(root.get("refseqNxtRstDt"),finanDt));
       }else if(year == 'Y') {
    	   where = builder.equal(root.get("modId"),modId);                
           where = builder.and(where,builder.equal(root.get("ulbId"),ulbId)); 
    	   where = builder.and(where,builder.equal(root.get("refseqTblName"),tabName));
           where = builder.and(where,builder.equal(root.get("refseqFldName"),fldName));
           where = builder.and(where,builder.equal(root.get("refseqRstTyp"),year));
           where = builder.and(where,builder.equal(root.get("refseqStrDate"),startUserDefDate));
           where = builder.and(where,builder.equal(root.get("refseqNxtRstDt"),lastUserDefDate));
    	   
       }else if(year == 'D') {
    	   where = builder.equal(root.get("modId"),modId);                
           where = builder.and(where,builder.equal(root.get("ulbId"),ulbId)); 
    	   where = builder.and(where,builder.equal(root.get("refseqTblName"),tabName));
           where = builder.and(where,builder.equal(root.get("refseqFldName"),fldName));
           where = builder.and(where,builder.equal(root.get("refseqRstTyp"),year));
           where = builder.and(where,builder.equal(root.get("refseqStrDate"),userDefDt));
           where = builder.and(where,builder.equal(root.get("refseqNxtRstDt"),userDefDt));
    	   
       }else if(year == 'C') {
    	   where = builder.equal(root.get("modId"),modId);                
           where = builder.and(where,builder.equal(root.get("ulbId"),ulbId)); 
    	   where = builder.and(where,builder.equal(root.get("refseqTblName"),tabName));
           where = builder.and(where,builder.equal(root.get("refseqFldName"),fldName));
           where = builder.and(where,builder.equal(root.get("refseqRstTyp"),year));
       }
        //where = builder.and( builder.equal(root.get("status"),status)); 
        
        query = query.where(where);                
        Query<TmTreeRefsequence> queryObj2=session.createQuery(query);
        List<TmTreeRefsequence> list=queryObj2.getResultList();
	    System.out.println("queryyh"+queryObj2.getQueryString());
	    System.out.println(" >>> "+list.size());
		
	    
       
	    if(list.size() == 0)
	    {
       
        if(year == 'F') {
        	
        	TmTreeRefsequence TmTreeRefsequence = new TmTreeRefsequence();
            
            TmTreeRefsequence.setModId(modId);
            TmTreeRefsequence.setUlbId(ulbId);
            TmTreeRefsequence.setRefseqRstTyp(year);
            TmTreeRefsequence.setRefseqStrDate(fromFinanDt);
            TmTreeRefsequence.setRefseqNxtRstDt(finanDt);
            TmTreeRefsequence.setRefseqTblName(tabName);
            TmTreeRefsequence.setRefseqFldName(fldName);
            TmTreeRefsequence.setRefseqStrWith((long) 1);
            TmTreeRefsequence.setRefseqMaxNum((long) 1);
            TmTreeRefsequence.setStatus(status);
            session.save(TmTreeRefsequence);
        	
			boolean comDt = userDefDt.equals(finanDt);
			
			if(comDt == false) {
				Query<TmTreeRefsequence> queryObj=session.createQuery(query);
		        TmTreeRefsequence result = queryObj.uniqueResult();
		        seqNo = result.getRefseqMaxNum();
		        updatedSeqNo = seqNo + 1;
		        result.setRefseqMaxNum(updatedSeqNo);
		        session.update(result);
		        
		        tmUlbQuery.multiselect(tmUlb.get("ulbId"), tmUlb.get("ulbCode")).where(builder.equal(tmUlb.get("ulbId"),ulbId));
		        Query<TmUlb> tmUlbQry =session.createQuery(tmUlbQuery);
		        TmUlb ulbCode = tmUlbQry.uniqueResult();
		        
		        String ulbshortCode="";
		        if(ulbCode.getUlbCode().length()<4)
		        {
		                ulbshortCode=ulbCode.getUlbCode()+0;
		        }
		        else
		        {
		                ulbshortCode=ulbCode.getUlbCode();
		        }
		        
		        newConnectionNo = String.valueOf(seqNo);
		        
		        
			}else {
				Query<TmTreeRefsequence> queryObj=session.createQuery(query);
		        TmTreeRefsequence result = queryObj.uniqueResult();
		        seqNo = result.getRefseqMaxNum();
		        updatedSeqNo = (long) 1;
		        result.setRefseqMaxNum(updatedSeqNo);
		        session.update(result);
		        
		        tmUlbQuery.multiselect(tmUlb.get("ulbId"), tmUlb.get("ulbCode")).where(builder.equal(tmUlb.get("ulbId"),ulbId));
		        Query<TmUlb> tmUlbQry =session.createQuery(tmUlbQuery);
		        TmUlb ulbCode = tmUlbQry.uniqueResult();
		        
		        String ulbshortCode="";
		        if(ulbCode.getUlbCode().length()<4)
		        {
		                ulbshortCode=ulbCode.getUlbCode()+0;
		        }
		        else
		        {
		                ulbshortCode=ulbCode.getUlbCode();
		        }
		        
		        newConnectionNo = String.valueOf(seqNo);
			}
        	
        	//System.out.print(serverDt.before(date2));
        	
        }else if(year == 'Y') {
        	
        	TmTreeRefsequence TmTreeRefsequence = new TmTreeRefsequence();
            
            TmTreeRefsequence.setModId(modId);
            TmTreeRefsequence.setUlbId(ulbId);
            TmTreeRefsequence.setRefseqRstTyp(year);
            TmTreeRefsequence.setRefseqStrDate(startUserDefDate);
            TmTreeRefsequence.setRefseqNxtRstDt(lastUserDefDate);
            TmTreeRefsequence.setRefseqTblName(tabName);
            TmTreeRefsequence.setRefseqFldName(fldName);
            TmTreeRefsequence.setRefseqStrWith((long) 1);
            TmTreeRefsequence.setRefseqMaxNum((long) 1);
            TmTreeRefsequence.setStatus(status);
            session.save(TmTreeRefsequence);
        	
				//Date fDt = getCurrentYear();
				boolean comDt = userDefDt.equals(lastUserDefDate);
				
				if(comDt == false) {
					Query<TmTreeRefsequence> queryObj=session.createQuery(query);
			        TmTreeRefsequence result = queryObj.uniqueResult();
			        seqNo = result.getRefseqMaxNum();
			        updatedSeqNo = seqNo + 1;
			        result.setRefseqMaxNum(updatedSeqNo);
			        session.update(result);
			        
			        tmUlbQuery.multiselect(tmUlb.get("ulbId"), tmUlb.get("ulbCode")).where(builder.equal(tmUlb.get("ulbId"),ulbId));
			        Query<TmUlb> tmUlbQry =session.createQuery(tmUlbQuery);
			        TmUlb ulbCode = tmUlbQry.uniqueResult();
			        
			        String ulbshortCode="";
			        if(ulbCode.getUlbCode().length()<4)
			        {
			                ulbshortCode=ulbCode.getUlbCode()+0;
			        }
			        else
			        {
			                ulbshortCode=ulbCode.getUlbCode();
			        }
			        
			        newConnectionNo = String.valueOf(seqNo);
				}else {
					Query<TmTreeRefsequence> queryObj=session.createQuery(query);
			        TmTreeRefsequence result = queryObj.uniqueResult();
			        //seqNo = result.getRefseqMaxNum();
			        seqNo = (long) 1;
			        updatedSeqNo = (long) 1;
			        result.setRefseqMaxNum(updatedSeqNo);
			        session.update(result);
			        
			        tmUlbQuery.multiselect(tmUlb.get("ulbId"), tmUlb.get("ulbCode")).where(builder.equal(tmUlb.get("ulbId"),ulbId));
			        Query<TmUlb> tmUlbQry =session.createQuery(tmUlbQuery);
			        TmUlb ulbCode = tmUlbQry.uniqueResult();
			        
			        String ulbshortCode="";
			        if(ulbCode.getUlbCode().length()<4)
			        {
			                ulbshortCode=ulbCode.getUlbCode()+0;
			        }
			        else
			        {
			                ulbshortCode=ulbCode.getUlbCode();
			        }
			        
			        newConnectionNo = String.valueOf(seqNo);
				}
				
        	
        }else if(year == 'D') {
        	
        	TmTreeRefsequence TmTreeRefsequence = new TmTreeRefsequence();
            
            TmTreeRefsequence.setModId(modId);
            TmTreeRefsequence.setUlbId(ulbId);
            TmTreeRefsequence.setRefseqRstTyp(year);
            TmTreeRefsequence.setRefseqStrDate(userDefDt);
            TmTreeRefsequence.setRefseqNxtRstDt(userDefDt);
            TmTreeRefsequence.setRefseqTblName(tabName);
            TmTreeRefsequence.setRefseqFldName(fldName);
            TmTreeRefsequence.setRefseqStrWith((long) 1);
            TmTreeRefsequence.setRefseqMaxNum((long) 1);
            TmTreeRefsequence.setStatus(status);
            session.save(TmTreeRefsequence);
        	
        	boolean comDt = userDefDt.equals(userDefDt);
			
			if(comDt == true) {
				Query<TmTreeRefsequence> queryObj=session.createQuery(query);
		        TmTreeRefsequence result = queryObj.uniqueResult();
		        seqNo = result.getRefseqMaxNum();
		        updatedSeqNo = seqNo + 1;
		        result.setRefseqMaxNum(updatedSeqNo);
		        session.update(result);
		        
		        tmUlbQuery.multiselect(tmUlb.get("ulbId"), tmUlb.get("ulbCode")).where(builder.equal(tmUlb.get("ulbId"),ulbId));
		        Query<TmUlb> tmUlbQry =session.createQuery(tmUlbQuery);
		        TmUlb ulbCode = tmUlbQry.uniqueResult();
		        
		        String ulbshortCode="";
		        if(ulbCode.getUlbCode().length()<4)
		        {
		                ulbshortCode=ulbCode.getUlbCode()+0;
		        }
		        else
		        {
		                ulbshortCode=ulbCode.getUlbCode();
		        }
		        
		        newConnectionNo = String.valueOf(seqNo);
			}else {
				Query<TmTreeRefsequence> queryObj=session.createQuery(query);
		        TmTreeRefsequence result = queryObj.uniqueResult();
		        //seqNo = result.getRefseqMaxNum();
		        seqNo = (long) 1;
		        updatedSeqNo = (long) 1;
		        result.setRefseqMaxNum(updatedSeqNo);
		        session.update(result);
		        
		        tmUlbQuery.multiselect(tmUlb.get("ulbId"), tmUlb.get("ulbCode")).where(builder.equal(tmUlb.get("ulbId"),ulbId));
		        Query<TmUlb> tmUlbQry =session.createQuery(tmUlbQuery);
		        TmUlb ulbCode = tmUlbQry.uniqueResult();
		        
		        String ulbshortCode="";
		        if(ulbCode.getUlbCode().length()<4)
		        {
		                ulbshortCode=ulbCode.getUlbCode()+0;
		        }
		        else
		        {
		                ulbshortCode=ulbCode.getUlbCode();
		        }
		        
		        newConnectionNo = String.valueOf(seqNo);
			}
        	
        
        	
        }else if(year == 'M') {
        	
        	TmTreeRefsequence TmTreeRefsequence = new TmTreeRefsequence();
            
            TmTreeRefsequence.setModId(modId);
            TmTreeRefsequence.setUlbId(ulbId);
            TmTreeRefsequence.setRefseqRstTyp(year);
            TmTreeRefsequence.setRefseqStrDate(startCurrYear);
            TmTreeRefsequence.setRefseqNxtRstDt(fDt);
            TmTreeRefsequence.setRefseqTblName(tabName);
            TmTreeRefsequence.setRefseqFldName(fldName);
            TmTreeRefsequence.setRefseqStrWith((long) 1);
            TmTreeRefsequence.setRefseqMaxNum((long) 1);
            TmTreeRefsequence.setStatus(status);
            session.save(TmTreeRefsequence);
        	
        	
        	Date tdT = getCurrentMonth();
        	
        	boolean comDt = userDefDt.equals(tdT);
			
			if(comDt == false) {
				Query<TmTreeRefsequence> queryObj=session.createQuery(query);
		        TmTreeRefsequence result = queryObj.uniqueResult();
		        seqNo = result.getRefseqMaxNum();
		        updatedSeqNo = seqNo + 1;
		        result.setRefseqMaxNum(updatedSeqNo);
		        session.update(result);
		        
		        tmUlbQuery.multiselect(tmUlb.get("ulbId"), tmUlb.get("ulbCode")).where(builder.equal(tmUlb.get("ulbId"),ulbId));
		        Query<TmUlb> tmUlbQry =session.createQuery(tmUlbQuery);
		        TmUlb ulbCode = tmUlbQry.uniqueResult();
		        
		        String ulbshortCode="";
		        if(ulbCode.getUlbCode().length()<4)
		        {
		                ulbshortCode=ulbCode.getUlbCode()+0;
		        }
		        else
		        {
		                ulbshortCode=ulbCode.getUlbCode();
		        }
		        
		        newConnectionNo = String.valueOf(seqNo);
			}else {
				Query<TmTreeRefsequence> queryObj=session.createQuery(query);
		        TmTreeRefsequence result = queryObj.uniqueResult();
		        seqNo = result.getRefseqMaxNum();
		        updatedSeqNo = (long) 1;
		        result.setRefseqMaxNum(updatedSeqNo);
		        session.update(result);
		        
		        tmUlbQuery.multiselect(tmUlb.get("ulbId"), tmUlb.get("ulbCode")).where(builder.equal(tmUlb.get("ulbId"),ulbId));
		        Query<TmUlb> tmUlbQry =session.createQuery(tmUlbQuery);
		        TmUlb ulbCode = tmUlbQry.uniqueResult();
		        
		        String ulbshortCode="";
		        if(ulbCode.getUlbCode().length()<4)
		        {
		                ulbshortCode=ulbCode.getUlbCode()+0;
		        }
		        else
		        {
		                ulbshortCode=ulbCode.getUlbCode();
		        }
		        
		        newConnectionNo = String.valueOf(seqNo);
			}
        	
        
        	
        }else if(year == 'C'){
        	TmTreeRefsequence TmTreeRefsequence = new TmTreeRefsequence();
            
            TmTreeRefsequence.setModId(modId);
            TmTreeRefsequence.setUlbId(ulbId);
            TmTreeRefsequence.setRefseqRstTyp(year);
            TmTreeRefsequence.setRefseqTblName(tabName);
            TmTreeRefsequence.setRefseqFldName(fldName);
            TmTreeRefsequence.setRefseqStrWith((long) 1);
            TmTreeRefsequence.setRefseqMaxNum((long) 1);
            TmTreeRefsequence.setStatus(status);
            session.save(TmTreeRefsequence);
        	
        	Query<TmTreeRefsequence> queryObj=session.createQuery(query);
	        TmTreeRefsequence result = queryObj.uniqueResult();
	        seqNo = result.getRefseqMaxNum();
	        updatedSeqNo = seqNo + 1;
	        result.setRefseqMaxNum(updatedSeqNo);
	        session.update(result);
	        
	        tmUlbQuery.multiselect(tmUlb.get("ulbId"), tmUlb.get("ulbCode")).where(builder.equal(tmUlb.get("ulbId"),ulbId));
	        Query<TmUlb> tmUlbQry =session.createQuery(tmUlbQuery);
	        TmUlb ulbCode = tmUlbQry.uniqueResult();
	        
	        String ulbshortCode="";
	        if(ulbCode.getUlbCode().length()<4)
	        {
	                ulbshortCode=ulbCode.getUlbCode()+0;
	        }
	        else
	        {
	                ulbshortCode=ulbCode.getUlbCode();
	        }
	        
	        newConnectionNo = String.valueOf(seqNo);
        }
        
        
        
	    }else {
	    	

	        
	        if(year == 'F') {
	        	
	        	
				boolean comDt = userDefDt.equals(finanDt);
				
				if(comDt == false) {
					Query<TmTreeRefsequence> queryObj=session.createQuery(query);
			        TmTreeRefsequence result = queryObj.uniqueResult();
			        seqNo = result.getRefseqMaxNum();
			        updatedSeqNo = seqNo + 1;
			        result.setRefseqMaxNum(updatedSeqNo);
			        session.update(result);
			        
			        tmUlbQuery.multiselect(tmUlb.get("ulbId"), tmUlb.get("ulbCode")).where(builder.equal(tmUlb.get("ulbId"),ulbId));
			        Query<TmUlb> tmUlbQry =session.createQuery(tmUlbQuery);
			        TmUlb ulbCode = tmUlbQry.uniqueResult();
			        
			        String ulbshortCode="";
			        if(ulbCode.getUlbCode().length()<4)
			        {
			                ulbshortCode=ulbCode.getUlbCode()+0;
			        }
			        else
			        {
			                ulbshortCode=ulbCode.getUlbCode();
			        }
			        
			        newConnectionNo = String.valueOf(seqNo);
			        
			        
				}else {
					Query<TmTreeRefsequence> queryObj=session.createQuery(query);
			        TmTreeRefsequence result = queryObj.uniqueResult();
			        seqNo = result.getRefseqMaxNum();
			        updatedSeqNo = (long) 1;
			        result.setRefseqMaxNum(updatedSeqNo);
			        session.update(result);
			        
			        tmUlbQuery.multiselect(tmUlb.get("ulbId"), tmUlb.get("ulbCode")).where(builder.equal(tmUlb.get("ulbId"),ulbId));
			        Query<TmUlb> tmUlbQry =session.createQuery(tmUlbQuery);
			        TmUlb ulbCode = tmUlbQry.uniqueResult();
			        
			        String ulbshortCode="";
			        if(ulbCode.getUlbCode().length()<4)
			        {
			                ulbshortCode=ulbCode.getUlbCode()+0;
			        }
			        else
			        {
			                ulbshortCode=ulbCode.getUlbCode();
			        }
			        
			        newConnectionNo = String.valueOf(seqNo);
			        
				}
	        	
	        	//System.out.print(serverDt.before(date2));
	        	
	        }else if(year == 'Y') {
	        	
	        	
					//Date fDt = getCurrentYear();
					boolean comDt = userDefDt.equals(lastUserDefDate);
					
					if(comDt == false) {
						Query<TmTreeRefsequence> queryObj=session.createQuery(query);
				        TmTreeRefsequence result = queryObj.uniqueResult();
				        seqNo = result.getRefseqMaxNum();
				        updatedSeqNo = seqNo + 1;
				        result.setRefseqMaxNum(updatedSeqNo);
				        session.update(result);
				        
				        tmUlbQuery.multiselect(tmUlb.get("ulbId"), tmUlb.get("ulbCode")).where(builder.equal(tmUlb.get("ulbId"),ulbId));
				        Query<TmUlb> tmUlbQry =session.createQuery(tmUlbQuery);
				        TmUlb ulbCode = tmUlbQry.uniqueResult();
				        
				        String ulbshortCode="";
				        if(ulbCode.getUlbCode().length()<4)
				        {
				                ulbshortCode=ulbCode.getUlbCode()+0;
				        }
				        else
				        {
				                ulbshortCode=ulbCode.getUlbCode();
				        }
				        
				        newConnectionNo = String.valueOf(seqNo);
					}else {
						Query<TmTreeRefsequence> queryObj=session.createQuery(query);
				        TmTreeRefsequence result = queryObj.uniqueResult();
				        //seqNo = result.getRefseqMaxNum();
				        seqNo = (long) 1;
				        updatedSeqNo = (long) 1;
				        result.setRefseqMaxNum(updatedSeqNo);
				        session.update(result);
				        
				        tmUlbQuery.multiselect(tmUlb.get("ulbId"), tmUlb.get("ulbCode")).where(builder.equal(tmUlb.get("ulbId"),ulbId));
				        Query<TmUlb> tmUlbQry =session.createQuery(tmUlbQuery);
				        TmUlb ulbCode = tmUlbQry.uniqueResult();
				        
				        String ulbshortCode="";
				        if(ulbCode.getUlbCode().length()<4)
				        {
				                ulbshortCode=ulbCode.getUlbCode()+0;
				        }
				        else
				        {
				                ulbshortCode=ulbCode.getUlbCode();
				        }
				        
				        newConnectionNo = String.valueOf(seqNo);
					}
					
	        	
	        }else if(year == 'D') {
	        	
	        	
	        	boolean comDt = userDefDt.equals(userDefDt);
				
				if(comDt == true) {
					Query<TmTreeRefsequence> queryObj=session.createQuery(query);
			        TmTreeRefsequence result = queryObj.uniqueResult();
			        seqNo = result.getRefseqMaxNum();
			        updatedSeqNo = seqNo + 1;
			        result.setRefseqMaxNum(updatedSeqNo);
			        session.update(result);
			        
			        tmUlbQuery.multiselect(tmUlb.get("ulbId"), tmUlb.get("ulbCode")).where(builder.equal(tmUlb.get("ulbId"),ulbId));
			        Query<TmUlb> tmUlbQry =session.createQuery(tmUlbQuery);
			        TmUlb ulbCode = tmUlbQry.uniqueResult();
			        
			        String ulbshortCode="";
			        if(ulbCode.getUlbCode().length()<4)
			        {
			                ulbshortCode=ulbCode.getUlbCode()+0;
			        }
			        else
			        {
			                ulbshortCode=ulbCode.getUlbCode();
			        }
			        
			        newConnectionNo = String.valueOf(seqNo);
				}else {
					Query<TmTreeRefsequence> queryObj=session.createQuery(query);
			        TmTreeRefsequence result = queryObj.uniqueResult();
			        //seqNo = result.getRefseqMaxNum();
			        seqNo = (long) 1;
			        updatedSeqNo = (long) 1;
			        result.setRefseqMaxNum(updatedSeqNo);
			        session.update(result);
			        
			        tmUlbQuery.multiselect(tmUlb.get("ulbId"), tmUlb.get("ulbCode")).where(builder.equal(tmUlb.get("ulbId"),ulbId));
			        Query<TmUlb> tmUlbQry =session.createQuery(tmUlbQuery);
			        TmUlb ulbCode = tmUlbQry.uniqueResult();
			        
			        String ulbshortCode="";
			        if(ulbCode.getUlbCode().length()<4)
			        {
			                ulbshortCode=ulbCode.getUlbCode()+0;
			        }
			        else
			        {
			                ulbshortCode=ulbCode.getUlbCode();
			        }
			        
			        newConnectionNo = String.valueOf(seqNo);
				}
	        	
	        
	        	
	        }else if(year == 'M') {
	        	
	        	Date tdT = getCurrentMonth();
	        	
	        	boolean comDt = userDefDt.equals(tdT);
				
				if(comDt == false) {
					Query<TmTreeRefsequence> queryObj=session.createQuery(query);
			        TmTreeRefsequence result = queryObj.uniqueResult();
			        seqNo = result.getRefseqMaxNum();
			        updatedSeqNo = seqNo + 1;
			        result.setRefseqMaxNum(updatedSeqNo);
			        session.update(result);
			        
			        tmUlbQuery.multiselect(tmUlb.get("ulbId"), tmUlb.get("ulbCode")).where(builder.equal(tmUlb.get("ulbId"),ulbId));
			        Query<TmUlb> tmUlbQry =session.createQuery(tmUlbQuery);
			        TmUlb ulbCode = tmUlbQry.uniqueResult();
			        
			        String ulbshortCode="";
			        if(ulbCode.getUlbCode().length()<4)
			        {
			                ulbshortCode=ulbCode.getUlbCode()+0;
			        }
			        else
			        {
			                ulbshortCode=ulbCode.getUlbCode();
			        }
			        
			        newConnectionNo = String.valueOf(seqNo);
				}else {
					Query<TmTreeRefsequence> queryObj=session.createQuery(query);
			        TmTreeRefsequence result = queryObj.uniqueResult();
			        seqNo = result.getRefseqMaxNum();
			        updatedSeqNo = (long) 1;
			        result.setRefseqMaxNum(updatedSeqNo);
			        session.update(result);
			        
			        tmUlbQuery.multiselect(tmUlb.get("ulbId"), tmUlb.get("ulbCode")).where(builder.equal(tmUlb.get("ulbId"),ulbId));
			        Query<TmUlb> tmUlbQry =session.createQuery(tmUlbQuery);
			        TmUlb ulbCode = tmUlbQry.uniqueResult();
			        
			        String ulbshortCode="";
			        if(ulbCode.getUlbCode().length()<4)
			        {
			                ulbshortCode=ulbCode.getUlbCode()+0;
			        }
			        else
			        {
			                ulbshortCode=ulbCode.getUlbCode();
			        }
			        
			        newConnectionNo = String.valueOf(seqNo);
				}
	        	
	        
	        	
	        }else if(year == 'C'){
	        	Query<TmTreeRefsequence> queryObj=session.createQuery(query);
		        TmTreeRefsequence result = queryObj.uniqueResult();
		        seqNo = result.getRefseqMaxNum();
		        updatedSeqNo = seqNo + 1;
		        result.setRefseqMaxNum(updatedSeqNo);
		        session.update(result);
		        
		        tmUlbQuery.multiselect(tmUlb.get("ulbId"), tmUlb.get("ulbCode")).where(builder.equal(tmUlb.get("ulbId"),ulbId));
		        Query<TmUlb> tmUlbQry =session.createQuery(tmUlbQuery);
		        TmUlb ulbCode = tmUlbQry.uniqueResult();
		        
		        String ulbshortCode="";
		        if(ulbCode.getUlbCode().length()<4)
		        {
		                ulbshortCode=ulbCode.getUlbCode()+0;
		        }
		        else
		        {
		                ulbshortCode=ulbCode.getUlbCode();
		        }
		        
		        newConnectionNo = String.valueOf(seqNo);
	        }
	        
	        
	    }
        /* Query<TmTreeRefsequence> queryObj=session.createQuery(query);
        TmTreeRefsequence result = queryObj.uniqueResult();
        seqNo = result.getRefseqMaxNum();
        updatedSeqNo = seqNo + 1;
        result.setRefseqMaxNum(updatedSeqNo);
        session.update(result);*/
     
        return newConnectionNo;

	}

	    
	@Override
	public int getModId(String code) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
		Root<TmCmModule> root = query.from(TmCmModule.class);
		query.select(root.get("modId"));
		Predicate where = builder.conjunction();
		where = builder.equal(root.get("modCode"),code);
		
		
		query = query.where(where);
		Query<Object[]> queryObj=session.createQuery(query);
		List<Object[]> list =queryObj.getResultList();
		
		Integer[] arg = (Integer[]) list.toArray(new Integer[list.size()]);
		
		int id = arg[0];
		
		//int id2 = Integer.parseInt(id);
	    
	    return id;
	}

	@Override
	public String getUlbShortsCode(int ulbId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
		Root<TmUlb> root = query.from(TmUlb.class);
		query.select(root.get("ulbCode"));
		Predicate where = builder.conjunction();
		where = builder.equal(root.get("ulbId"),ulbId);
		
		query = query.where(where);
		Query<Object[]> queryObj=session.createQuery(query);
		List<Object[]> list =queryObj.getResultList();
		
		String[] arg = (String[]) list.toArray(new String[list.size()]);
		
		String id = arg[0];
		
		//int id2 = Integer.parseInt(id);
	    
	    return id;
	}

	@Override
	public Date getFromFinancialDate(Date fDt) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
		Root<TmCmFinancialMas> root = query.from(TmCmFinancialMas.class);
		query.select(root.get("fromDate"));
		Predicate where = builder.conjunction();
		
		SimpleDateFormat fmtDt = new SimpleDateFormat("yyyy-MM-dd");
		
		String dt = fmtDt.format(fDt);
		
		where = builder.between(builder.literal(fDt), root.get("fromDate"), root.get("toDate"));
		
		query = query.where(where);
		Query<Object[]> queryObj=session.createQuery(query);
		List<Object[]> list =queryObj.getResultList();
		
		Date[] arg =  list.toArray(new Date[list.size()]);
		
		Date dt2 = arg[0];
		
		//int id2 = Integer.parseInt(id);
	    System.out.println("queryyh"+queryObj.getQueryString());
	    System.out.println(" >>> "+dt2);
		
		return dt2;
	}

	@Override
	public Date getFinancialDate(Date fDt) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
		Root<TmCmFinancialMas> root = query.from(TmCmFinancialMas.class);
		query.select(root.get("toDate"));
		Predicate where = builder.conjunction();
		
		SimpleDateFormat fmtDt = new SimpleDateFormat("yyyy-MM-dd");
		
		String dt = fmtDt.format(fDt);
		
		where = builder.between(builder.literal(fDt), root.get("fromDate"), root.get("toDate"));
		
		query = query.where(where);
		Query<Object[]> queryObj=session.createQuery(query);
		List<Object[]> list =queryObj.getResultList();
		
		Date[] arg =  list.toArray(new Date[list.size()]);
		
		Date dt2 = arg[0];
		
		//int id2 = Integer.parseInt(id);
	    System.out.println("queryyh"+queryObj.getQueryString());
	    System.out.println(" >>> "+dt2);
		
		return dt2;
	}

	@Override
	public Date getCurrentYear() throws ParseException {
		// TODO Auto-generated method stub
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		int monthNumber = 12;
	    String firstDate = "31";
		String month2 = new DateFormatSymbols().getMonths()[monthNumber - 1];
	    int year2 = year;
		String year3 = String.valueOf(year2);
		
		String dtFormat = firstDate+"/"+monthNumber+"/"+year3;
		
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		
		Date txDt = dt.parse(dtFormat);
		
		System.out.println("Date is ----> "+ txDt);
		
		return txDt;
	}

	@Override
	public String getServShortCode(int serId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
		Root<TmCmServices> root = query.from(TmCmServices.class);
		query.select(root.get("serviceShortCode"));
		Predicate where = builder.conjunction();
		where = builder.equal(root.get("serviceId"),serId);
		
		query = query.where(where);
		Query<Object[]> queryObj=session.createQuery(query);
		List<Object[]> list =queryObj.getResultList();
		
		String[] arg = (String[]) list.toArray(new String[list.size()]);
		
		String id = arg[0];
		
		//int id2 = Integer.parseInt(id);
	    
	    return id;
	}

	
	
	public Date getStartCurrentYear() throws ParseException {
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		int monthNumber = 1;
	    String firstDate = "01";
		String month2 = new DateFormatSymbols().getMonths()[monthNumber - 1];
	    int year2 = year;
		String year3 = String.valueOf(year2);
		
		String dtFormat = firstDate+"/"+monthNumber+"/"+year3;
		
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		
		Date txDt = dt.parse(dtFormat);
		
		System.out.println("Date is ----> "+ txDt);
		
		return txDt;
		
	}

	//For Current Year
	
	public Date getCurrentMonth() throws ParseException {
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int monthNo = Calendar.getInstance().get(Calendar.MONTH) + 1;
		
		if(monthNo == 12) {
			year = year + 1;
		}
		
		int futMonth = monthNo - 11;
		String fM = String.valueOf(futMonth);
		String fMPd = "00".substring(fM.toString().length()) + fM;
		
	    String firstDate = "01";
		
		String dtFormat = firstDate+"/"+fMPd+"/"+year;
		
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		
		Date txDt = dt.parse(dtFormat);
		
		System.out.println("Date is ----> "+ txDt);
		
		return txDt;
		
	}
	
	
	//Get Current Year Date on UserDefined Parameter
	
	public Date getStartUserDefCurrentYear(Date userDefDt) throws ParseException {
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		String txDt = dt.format(userDefDt);
		
		String subTxDt = txDt.substring(6, 10);
		
		int monthNumber = 1;
	    String firstDate = "01";
		String month2 = new DateFormatSymbols().getMonths()[monthNumber - 1];
	    int year2 = year;
		String year3 = subTxDt;
		
		String dtFormat = firstDate+"/"+monthNumber+"/"+year3;
		
		
		
		Date txDt2 = dt.parse(dtFormat);
		
		System.out.println("Date is ----> "+ txDt);
		
		return txDt2;
		
	}
	
	public Date getLastUserDefCurrentYear(Date userDefDt) throws ParseException {
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		String txDt = dt.format(userDefDt);
		
		String subTxDt = txDt.substring(6, 10);
		
		int monthNumber = 12;
	    String firstDate = "31";
		String month2 = new DateFormatSymbols().getMonths()[monthNumber - 1];
	    int year2 = year;
		String year3 = subTxDt;
		
		String dtFormat = firstDate+"/"+monthNumber+"/"+year3;
		
		
		
		Date txDt2 = dt.parse(dtFormat);
		
		System.out.println("Date is ----> "+ txDt);
		
		return txDt2;
		
	}
	
	//Get Current Year Date on UserDefined Parameter
	


	
}
