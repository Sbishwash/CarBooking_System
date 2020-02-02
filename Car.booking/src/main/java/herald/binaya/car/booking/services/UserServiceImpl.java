package herald.binaya.car.booking.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import herald.binaya.car.booking.dao.CarDao;
import herald.binaya.car.booking.dao.BookingsDao;
import herald.binaya.car.booking.dao.UserDao;
import herald.binaya.car.booking.domain.Car;
import herald.binaya.car.booking.domain.Order;
import herald.binaya.car.booking.domain.User;
import herald.binaya.car.booking.entities.ECar;
import herald.binaya.car.booking.entities.EBookings;
import herald.binaya.car.booking.entities.EUser;
import herald.binaya.car.booking.services.exceptions.UserAlreadyPresentException;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserDao userdaoimpl;
	
	@Autowired
	private CarDao cardaoimpl;
	
	@Autowired 
	private BookingsDao bookingsdaoimpl;
	
	
	public boolean registerUser(User user) throws UserAlreadyPresentException {
		
		//first check if user already exists
		EUser currentUser = userdaoimpl.getUser(user.getUsername());
		if(currentUser!=null)
			throw new UserAlreadyPresentException("The username is already registered!");
		
		//add new user to db
		EUser dbuser = new EUser();
		
		dbuser.setAddress(user.getAddress());
		dbuser.setEmail(user.getEmail());
		dbuser.setFname(user.getFname());
		dbuser.setLname(user.getLname());
		dbuser.setPhoneno(user.getPhoneno());
		dbuser.setUsername(user.getUsername());
		dbuser.setRole(2);
		dbuser.setStatus(true);
		//use bycrypt for hashing
		String hashedpw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		dbuser.setPassword(hashedpw);
		
		boolean result=userdaoimpl.saveUser(dbuser);
		return result;	
	}


	public List<Car> getAllCars() {
		
		//first we need to get all the cars from database .. for that we need to ask dao layer to do it
		List<ECar> alldbcars = cardaoimpl.getAllCars();
		
		//if no cars were found in db , return null
		if(alldbcars == null || alldbcars.size()==0)
			return null;
		
		//change entity objects to domain objects
		List<Car> allcars = new ArrayList<Car>();
		for(ECar ep:alldbcars) {
			Car p = new Car();
			p.setBrandName(ep.getBrand().getBrandname());
			p.setId(ep.getCarid());
			p.setImageUrl(ep.getImageurl());
			p.setManufacturer(ep.getManufacturer());
			p.setName(ep.getCarname());
			p.setPrice(ep.getPrice());
			allcars.add(p);
		}
		
		return allcars;	
		
	}


	public List<Car> getAllCarsInCart(List<Integer> ids) {
		
		List<Car> allcars = new ArrayList<Car>();
		
		//get all product objects that were added in the cart
		for(Integer i:ids) {
			ECar ep = cardaoimpl.getCarById(i);
			Car p = new Car();
			p.setBrandName(ep.getBrand().getBrandname());
			p.setId(ep.getCarid());
			p.setImageUrl(ep.getImageurl());
			p.setManufacturer(ep.getManufacturer());
			p.setName(ep.getCarname());
			p.setPrice(ep.getPrice());
			allcars.add(p);
		}
		
		return allcars;
		
	}

	public boolean confirmPurchase(Order order,String username) {
		
		//get all ordered products
		List<Car> orderCars = order.getOrderCars();
		//get user who made purchase order
		EUser user = userdaoimpl.getUser(username);
		boolean result=false;
		
		for(Car p:orderCars) {
			
			//first decrease the stock and save in db
			ECar dbcar = cardaoimpl.getCarById(p.getId());
			int newstock = dbcar.getStock()-p.getOrderedQuantity();
			dbcar.setStock(newstock);
			cardaoimpl.saveCar(dbcar);
			
			//create bookings for a product
			EBookings neworder = new EBookings();
			neworder.setCar(dbcar);
			neworder.setQuantity(p.getOrderedQuantity());
			neworder.setBookingsdate(new Date());
			neworder.setUser(user);
			
			//save bookings in db
			result=bookingsdaoimpl.saveBooking(neworder);
			
		}
		
		return result;
		
	}

}
