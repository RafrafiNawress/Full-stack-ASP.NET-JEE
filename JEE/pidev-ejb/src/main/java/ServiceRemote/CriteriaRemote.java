  

package ServiceRemote;



import java.util.List;

import javax.ejb.Remote;

import Entities.Criteria;

@Remote
public interface CriteriaRemote {
	public int ajouterCriteria(Criteria criteria);
	public List<Criteria> getAllCriterien();
	
	
	
}