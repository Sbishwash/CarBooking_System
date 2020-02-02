package herald.binaya.car.booking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import herald.binaya.car.booking.entities.ECar;
import herald.binaya.car.booking.entities.EBookings;

@Repository
public class BookingsDaoImpl implements BookingsDao {

	@PersistenceContext
	private EntityManager manager;
	
	
	public boolean saveBooking(EBookings bookings) {
		try {
			manager.persist(bookings);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public List<EBookings> getAllBookings() {

		Query q =manager.createQuery("SELECT c FROM EBookings c");
		List<EBookings> dd= q.getResultList();
		return dd;
	}

}
