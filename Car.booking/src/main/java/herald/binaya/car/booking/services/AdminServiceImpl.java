package herald.binaya.car.booking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import herald.binaya.car.booking.dao.CarDao;
import herald.binaya.car.booking.dao.BrandDao;
import herald.binaya.car.booking.dao.BookingsDao;
import herald.binaya.car.booking.domain.Car;
import herald.binaya.car.booking.domain.Brand;
import herald.binaya.car.booking.domain.Bookings;
import herald.binaya.car.booking.entities.ECar;
import herald.binaya.car.booking.entities.EBrand;
import herald.binaya.car.booking.entities.EBookings;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	BrandDao branddaoimpl; // inject all dao objects
	
	@Autowired
	CarDao cardaoimpl;
	
	@Autowired
	BookingsDao bookingsdaoimpl;
	
	public List<Brand> getAllBrands() {
		
		List<EBrand> allbrandsfromdb = branddaoimpl.getAllBrands();
		//change entity objects to domain objects
		List<Brand> brandstoreturn= new ArrayList();
		for(EBrand bran:allbrandsfromdb) {
			Brand c = new Brand();
			c.setId(bran.getBrandid());
			c.setName(bran.getBrandname());
			brandstoreturn.add(c);
		}
		
		return brandstoreturn;
	}

	public boolean addNewBrand(Brand brand) {
		
		EBrand ebran = new EBrand();
		ebran.setBrandname(brand.getName());
		
		return branddaoimpl.saveBrand(ebran);
	}

	public boolean addNewCar(Car car) {
		
		//first we need to get brand entity to be added as foreign key for this car entity object
		EBrand brand = branddaoimpl.getBrandById(car.getBrandid()); 
		
		ECar dbcar = new ECar();
		dbcar.setBrand(brand);
		dbcar.setImageurl(car.getImageUrl());
		dbcar.setManufacturer(car.getManufacturer());
		dbcar.setPrice(car.getPrice());
		dbcar.setCarname(car.getName());
		dbcar.setStock(car.getStock());
		
		boolean databaseaddresult = cardaoimpl.saveCar(dbcar);
		return databaseaddresult;
		
	}

	public List<Bookings> getAllBookings() {
		
		List<EBookings> allbookingsindb=bookingsdaoimpl.getAllBookings();
		List<Bookings> allbookings = new ArrayList();
		
		for(EBookings bookings:allbookingsindb) {
			
			Bookings aa = new Bookings();
			aa.setId(bookings.getBookingsid());
			aa.setDate(bookings.getBookingsdate());
			aa.setCarname(bookings.getCar().getCarname());
			aa.setQuantity(bookings.getQuantity());
			aa.setUsername(bookings.getUser().getUsername());
			allbookings.add(aa);
			
		}
		
		return allbookings;
		
	}

}
