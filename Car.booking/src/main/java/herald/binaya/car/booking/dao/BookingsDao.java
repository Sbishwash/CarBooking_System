package herald.binaya.car.booking.dao;

import java.util.List;

import herald.binaya.car.booking.entities.EBookings;

public interface BookingsDao {
	
	public boolean saveBooking(EBookings bookings);
	public List<EBookings> getAllBookings();
	

}
