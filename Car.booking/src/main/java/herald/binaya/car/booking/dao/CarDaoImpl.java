package herald.binaya.car.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import herald.binaya.car.booking.entities.ECar;
import herald.binaya.car.booking.entities.EBrand;

@Repository
public class CarDaoImpl implements CarDao {

	@PersistenceContext
	private EntityManager manager;
	
	public boolean saveCar(ECar car) {
		try {
			manager.persist(car);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public List<ECar> getAllCars() {
		
		Query q =manager.createQuery("SELECT c FROM ECar c");
		List<ECar> dd= q.getResultList();
		return dd;
	}

	public ECar getCarById(int id) {
		
		 Query q =manager.createQuery("SELECT c FROM ECar c WHERE c.carid = :idss");
		 q.setParameter("idss",id);
		 ECar u = (ECar) q.getSingleResult();
		 return u;
	}

}
