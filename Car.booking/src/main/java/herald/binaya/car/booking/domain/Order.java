package herald.binaya.car.booking.domain;

import java.util.List;

public class Order {
	
	private List<Car> orderCars;

	public List<Car> getOrderCars() {
		return orderCars;
	}

	public void setOrderCars(List<Car> orderCars) {
		this.orderCars = orderCars;
	}

}
