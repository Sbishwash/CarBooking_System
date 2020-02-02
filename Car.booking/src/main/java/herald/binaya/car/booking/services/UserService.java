package herald.binaya.car.booking.services;

import herald.binaya.car.booking.domain.*;
import herald.binaya.car.booking.services.exceptions.UserAlreadyPresentException;

import java.util.List;

public interface UserService {
	
	public boolean registerUser(User user) throws UserAlreadyPresentException;
	public List<Car> getAllCars();
	public List<Car> getAllCarsInCart(List<Integer> ids);
	public boolean confirmPurchase(Order order,String username);

}
