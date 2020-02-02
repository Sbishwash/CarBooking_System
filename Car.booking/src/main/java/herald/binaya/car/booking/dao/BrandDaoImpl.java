package herald.binaya.car.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import herald.binaya.car.booking.entities.EBrand;
import herald.binaya.car.booking.entities.EUser;

@Repository
public class BrandDaoImpl implements BrandDao{

	@PersistenceContext
	private EntityManager manager;
	
	public boolean saveBrand(EBrand brand) {
	
		try {
				manager.persist(brand);
				return true;
			}catch (Exception e) {
				return false;
		}
	}

	public List<EBrand> getAllBrands() {
		
		Query q =manager.createQuery("SELECT c FROM EBrand c");
		List<EBrand> dd= q.getResultList();
		return dd;

	}

	public EBrand getBrandById(int id) {
		
		 Query q =manager.createQuery("SELECT c FROM EBrand c WHERE c.brandid = :idss");
		 q.setParameter("idss",id);
		 EBrand u = (EBrand) q.getSingleResult();
		 return u;
	}

}
