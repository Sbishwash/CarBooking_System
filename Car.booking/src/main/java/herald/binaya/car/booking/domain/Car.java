package herald.binaya.car.booking.domain;

import javax.validation.constraints.Size;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Car {
	
	private int id;
	
	@Size(min=2,max=20,message="Name must be between 2 and 20 characters long.")
	private String name;
	
	private String imageUrl;
	
	private String manufacturer;
	
	private int price;
	
	private int stock;
	
	private int brandid;
	
	private String brandName;
	
	private CommonsMultipartFile imageFile;
	
	private int orderedQuantity;
	
	public int getOrderedQuantity() {
		return orderedQuantity;
	}

	public void setOrderedQuantity(int orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getBrandid() {
		return brandid;
	}

	public void setBrandid(int brandid) {
		this.brandid = brandid;
	}

	public CommonsMultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(CommonsMultipartFile imageFile) {
		this.imageFile = imageFile;
	}
}
