package herald.binaya.car.booking.services;

import java.util.List;

import herald.binaya.car.booking.domain.Car;
import herald.binaya.car.booking.domain.Brand;
import herald.binaya.car.booking.domain.Bookings;

public interface AdminService {
	
	public List<Brand> getAllBrands();
	public boolean addNewBrand(Brand brand);
	public boolean addNewCar(Car car);
	public List<Bookings> getAllBookings();

}
