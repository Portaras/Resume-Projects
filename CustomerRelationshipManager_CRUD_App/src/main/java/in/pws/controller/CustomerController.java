package in.pws.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.pws.model.Customer;
import in.pws.service.ICustomerService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private ICustomerService service;

	@GetMapping("/list")
	public String getAllCustomerDetails(Map<String, Object> model) {
		List<Customer> listOfCustomers = service.getAllCustomer();
		model.put("customerList", listOfCustomers);
		return "list_customer";
	}

	@GetMapping("/getform")
	public String getCustomerAddingForm(Map<String, Object> map) {
		Customer customer = new Customer();
		map.put("customer", customer);
		return "customer_adding_form";
	}

	@PostMapping("/saveform")
	public String saveCustomerAddingForm(Map<String, Object> map, @ModelAttribute Customer customer) {
		System.out.println(customer);
		Boolean StatusSavedCustomer = service.saveCustomer(customer);
		return "redirect:/customer/list";
	}

	@GetMapping("/showEditForm")
	public String getCustomerEditForm(Map<String, Object> map, @RequestParam Integer customerId,
			@ModelAttribute("customer") Customer customer) {
		System.out.println("ABC" + customerId + " " + customer);
		customer = service.getCustomerById(customerId);
		System.out.println("ABC" + customerId + " " + customer);
		map.put("customer", customer);
		return "update_customer_form";
	}

	@PostMapping("/editCustomer")
	public String saveCustomerEditForm(@ModelAttribute("customer") Customer customer) {
		System.out.println("CDE" + customer);

		Boolean StatusSavedCustomer = service.saveCustomer(customer);
		return "redirect:/customer/list";
	}

	@GetMapping("/deleteForm")
	public String removeCustomer(@RequestParam Integer customerId) {
		
		Boolean status = service.removeCustomerById(customerId);
		
		return "redirect:/customer/list";
	}
}
