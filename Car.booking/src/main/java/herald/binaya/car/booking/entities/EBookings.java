package herald.binaya.car.booking.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="bookings")
public class EBookings implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer bookingsid;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date bookingsdate;
	
	@JoinColumn(name = "car", referencedColumnName = "carid", nullable = false)
    @ManyToOne(optional = false)
    private ECar car;
	
	@JoinColumn(name = "user", referencedColumnName = "userid", nullable = false)
    @ManyToOne(optional = false)
    private EUser user;
	
	private Integer quantity;
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getBookingsid() {
		return bookingsid;
	}

	public void setBookingsid(Integer bookingsid) {
		this.bookingsid = bookingsid;
	}

	
	public Date getBookingsdate() {
		return bookingsdate;
	}

	public void setBookingsdate(Date bookingsdate) {
		this.bookingsdate = bookingsdate;
	}

	public ECar getCar() {
		return car;
	}

	public void setCar(ECar car) {
		this.car = car;
	}

	public EUser getUser() {
		return user;
	}

	public void setUser(EUser user) {
		this.user = user;
	}
	
	

}
