package in.pws.controller;

import java.util.List;

import org.eclipse.jdt.internal.compiler.batch.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pws.model.Customer;
import in.pws.service.ICustomerService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {
	@Autowired
	private ICustomerService service;

	@GetMapping("/list")
	@Operation(summary = "Retrive all the customers as list", description = "Listing customers")
	public ResponseEntity<?> getAllCustomerDetails() {
		try {
			List<Customer> listOfCustomers = service.getAllCustomer();

			return new ResponseEntity<List<Customer>>(listOfCustomers, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Error Retieving Data Page", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/saveform")
	@Operation(summary = "Save customer as an object", 
    description= "Save Customer Jason Data")
	
	public ResponseEntity<String> saveCustomerAddingForm(@RequestBody Customer customer) {
		try {
			String saveCustomer = service.saveCustomer(customer);
			return new ResponseEntity<String>(saveCustomer, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/editCustomer")
	public ResponseEntity<String> saveCustomerEditForm(@RequestBody Customer customer) {
		try {
			String status = service.saveCustomer(customer);
			return new ResponseEntity<String>(status, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteForm/{id}")
	public ResponseEntity<String> removeCustomer(@PathVariable Integer id) {
		try {
			String status = service.removeCustomerById(id);
			return new ResponseEntity<String>(status, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}
	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<?> getACustomerById( @PathVariable Integer id) {
		try {
			Customer customer = service.getCustomerById(id);

			return new ResponseEntity<Customer>(customer, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Customer Not Found with ID : " + id, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
