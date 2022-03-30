package portal.sessions;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;

@Local
public interface BusinessSBSLLocal {

public Serializable findByPk(Class<? extends Serializable> entity, Serializable pk) throws Exception;
	
	public List<? extends Serializable> findAll(Class<? extends Serializable> entity) throws Exception;;
	
	public Serializable update(Serializable registro) throws Exception;
	
	public Serializable insert(Serializable registro) throws Exception;
	
	public void delete(Serializable registro) throws Exception;

	public List<? extends Serializable> findByProperty(Class<? extends Serializable> entity, String property, Serializable value);

	public Serializable findByPropertyUnique(Class<? extends Serializable> entity, String property, Serializable value);

	public List<Serializable> findByNativeQuery(Class<? extends Serializable> entity,String query, Serializable[] params);
	
	public List<Serializable> findByNativeQuery(String query, Serializable[] params);

	public int yaExiste(String tablas, String condicion);
	
	public List<Serializable> findByNamedQuery(Class<? extends Serializable> entity, String name, Map<String,Serializable> param);

	public Serializable findReference(Class<? extends Serializable> entity, Serializable pk);

	public boolean executeQuery(Class<? extends Serializable> entity, String query, Map<String,Serializable> params);
	
	public Serializable refresh(Class<? extends Serializable> entity, Serializable pk);
	
	public List<? extends Serializable> menuByUser(Class<? extends Serializable> entity,  long usuId);
}
