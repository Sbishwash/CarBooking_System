package herald.binaya.car.booking.dao;

import java.util.List;

import herald.binaya.car.booking.entities.ECar;

public interface CarDao {
	
	public boolean saveCar(ECar car);
	public List<ECar> getAllCars();
	public ECar getCarById(int id);

}
