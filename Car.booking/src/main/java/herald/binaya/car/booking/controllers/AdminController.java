package herald.binaya.car.booking.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import herald.binaya.car.booking.domain.Car;
import herald.binaya.car.booking.domain.Brand;
import herald.binaya.car.booking.domain.Bookings;
import herald.binaya.car.booking.domain.User;
import herald.binaya.car.booking.services.AdminService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	/**
	 * This is the Car image upload location, change it as per your choice
	 */
	private final String uploadLocation="E:/imageforW/";
	
	@Autowired
	AdminService adminserviceimpl;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getHomePage(Model model){
	
		return "admin/index";
	
	}
	
	@RequestMapping(value = "brands",method=RequestMethod.GET)
	public String getBrandsPage(Model model){
	
		//add all the current brands as well as new brand object to be bound with a form 
		List<Brand> allbrands = adminserviceimpl.getAllBrands();
		model.addAttribute("allbrans",allbrands);
		Brand brand = new Brand();
		model.addAttribute("bran",brand);
		return "admin/brands";
	
	}
	
	@RequestMapping(method=RequestMethod.POST, value={"brands"})
	public String addNewCustomer(@ModelAttribute("bran") @Valid Brand brand,
			BindingResult bindingResult){
		
		if(bindingResult.hasErrors()) {
			return "admin/brands";
		}
		
		adminserviceimpl.addNewBrand(brand);
		
		return "redirect:/admin/brands?message=New brand is added";	
		
	}
	
	@RequestMapping(value = "cars",method=RequestMethod.GET)
	public String getCarsPage(Model model){
		
		Car car = new Car();
		model.addAttribute("ca",car);
		
		List<Brand> allBrands = adminserviceimpl.getAllBrands();
		model.addAttribute("allbrans",allBrands);
		
		return "admin/cars";
	
	}
	
	@RequestMapping(method=RequestMethod.POST, value={"cars"})
	public String addNewCar(HttpServletRequest servletRequest,@ModelAttribute("ca") @Valid Car car,
			BindingResult bindingResult){
		
		if(bindingResult.hasErrors()) {
			return "admin/cars";
		}
		
		String newname =RandomStringUtils.randomAlphanumeric(5)+car.getImageFile().getOriginalFilename();
		String location = uploadLocation+newname;
		car.setImageUrl(newname);
		
		boolean result =adminserviceimpl.addNewCar(car);
		
		if(result) {
			try {
				car.getImageFile().transferTo(new File(location));
				return "redirect:/admin/cars?message=New Car was added successfully";	

			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "redirect:/admin/cars?message=Car is added but file cannot be moved";	

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "redirect:/admin/cars?message=Car is added but file cannot be moved";	

			}
		}else {
			return "redirect:/admin/cars?message=Not able to add new car";	

		}	
		
	}
	
	@RequestMapping(value = "bookings",method=RequestMethod.GET)
	public String getAllBookings(Model model){
	
		List<Bookings> allbookings = adminserviceimpl.getAllBookings();
		model.addAttribute("allbookings",allbookings);
		return "admin/bookings";
	
	}

}
