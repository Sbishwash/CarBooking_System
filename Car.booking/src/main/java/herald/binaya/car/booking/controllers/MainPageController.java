package herald.binaya.car.booking.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import herald.binaya.car.booking.dao.UserDao;
import herald.binaya.car.booking.domain.Car;
import herald.binaya.car.booking.domain.Order;
import herald.binaya.car.booking.domain.User;
import herald.binaya.car.booking.services.UserService;
import herald.binaya.car.booking.services.exceptions.UserAlreadyPresentException;

@Controller
@RequestMapping(value="/")
public class MainPageController {
	
	@Autowired
	private UserService userserviceimpl;
	
	
	/**
	 * 
	 * @param principal
	 * @return return username as a common model attribute for all pages 
	 */
	@ModelAttribute("username")
	  String getUserName(Principal principal) {
		if(principal!=null)
			return principal.getName();
		else
			return null;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String getHomePage(Model model,HttpServletRequest request){
	
		//get current items in cart through session
		List<Integer> allitems=(List<Integer>)request.getSession().getAttribute("cartitems");
				
		if(allitems==null)
			model.addAttribute("totalcarditems",0);
		else
			model.addAttribute("totalcarditems",allitems.size());
		
		//get all cars to be shown in home page 
		model.addAttribute("allcars",userserviceimpl.getAllCars());
		
		//show index.jsp page
		return "index";
	
	}
	
	@RequestMapping(value = "login",method=RequestMethod.GET)
	public String getLoginPage(Model model) {
		
		return "login";
		
	}
	
	@RequestMapping(value = "register",method=RequestMethod.GET)
	public String getRegisterPage(Model model) {
		
		//send a new domain object
		model.addAttribute("user",new User());
		return "register";
		
	}
	

	@RequestMapping(method=RequestMethod.POST, value={"register"})
	public String insertNewCustomer(@ModelAttribute("user") @Valid User newuser,
			BindingResult bindingResult){
		
		//validate the form data
		if(bindingResult.hasErrors()) {
			return "register";
		}
		
		try {
			boolean result=userserviceimpl.registerUser(newuser);
			if (result)
				return "redirect:register?message=Registration is successful";	
			else
				return "redirect:register?message=Unknown problem occured! Please contact administrator";	
			
		} catch (UserAlreadyPresentException e) {
			bindingResult.rejectValue("username", "username", e.getMessage()); 
			return "register";
		}	
	}
	
	@RequestMapping(value = "addtocard",method=RequestMethod.GET)
	public String addToCart(Model model,@RequestParam(required=true) Integer pid,HttpServletRequest request) {
		
		//get current items in cart through session
		List<Integer> allitems=(List<Integer>)request.getSession().getAttribute("cartitems");
		
		//if session was not created yet create one
		if(allitems==null) {
			allitems = new ArrayList<Integer>();
			allitems.add(pid);
			request.getSession().setAttribute("cartitems",allitems);
		}
		
		//check if item was already added to cart
		if(!allitems.contains(pid))
			allitems.add(pid);
		
		return "redirect:/";
		
	}

	@RequestMapping(value = "confirmorder",method=RequestMethod.GET)
	public String confirmOrder(Model model,HttpServletRequest request) {
		
		//get current items in cart through session
		List<Integer> allitems=(List<Integer>)request.getSession().getAttribute("cartitems");
		if(allitems==null || allitems.size()==0) {
			return "redirect:/?message=There are no cars in the shopping card";
		}
		
		List<Car> allItemsInCart = userserviceimpl.getAllCarsInCart(allitems);
		
		Order order = new Order();
		order.setOrderCars(allItemsInCart);
		model.addAttribute("allorders",order);
		
		return "confirmorder";
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value={"confirmorder"})
	public String processOrder(@ModelAttribute("allorders") Order order,Principal principal,HttpServletRequest request) {
		
		boolean result=userserviceimpl.confirmPurchase(order,principal.getName());
		
		if(result) {
			request.getSession().removeAttribute("cartitems");	
			return "redirect:/?message=Order was successfully placed. Thank you";
			
		}else {
			return "redirect:/?message=There was some problem processing your order.Please contact administrator";
			
		}
		
	}
	
	@RequestMapping(value = "clearcart",method=RequestMethod.GET)
	public String clearCart(Model model,HttpServletRequest request) {
		
		//remove cart attribute
		request.getSession().removeAttribute("cartitems");	
		return "redirect:/";
		
	}
	
	@RequestMapping(value = "logout/success",method=RequestMethod.GET)
	public String logoutSuccess(Model model) {
		
		//remove cart attribute
		
		return "redirect:/?message=Logout Successful";
		
	}
	
	@RequestMapping(value = "login/failure",method=RequestMethod.GET)
	public String loginFailure(Model model) {
		
		//remove cart attribute
		
		return "redirect:/?message=Unable to login.Please check your username and password";
		
	}

}
