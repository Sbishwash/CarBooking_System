package herald.binaya.car.booking.services.exceptions;

public class UserAlreadyPresentException extends Exception {
	
	/**
	 * Custom exception when user is already present
	 * @param message
	 */
	public  UserAlreadyPresentException(String message) {
        super(message);
    }

}
