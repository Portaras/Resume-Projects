package in.pws.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pws.dao.ICustomerRepo;
import in.pws.exception.CustomerException;
import in.pws.model.Customer;

@Service("service")
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepo repo;

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> listOfCustomer = repo.findAll();
		System.out.println("LIST OF CUSTOMERS" + listOfCustomer);
		listOfCustomer.sort((t1, t2) -> t1.getCname().compareTo(t2.getCname()));

		return listOfCustomer;
	}

	@SuppressWarnings("null")
	@Override
	public String saveCustomer(Customer customer) {
		if (customer != null) {
			customer = repo.save(customer);
			return "Details Saved Successfully with id : " + customer.getCid();
		} else {

			throw new CustomerException("Customr Details Not Found with ID" + customer.getCid());
		}
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		Optional<Customer> optional = repo.findById(customerId);
		if (optional.isPresent())
			return optional.get();
		else
			throw new CustomerException("Customr Details Not Found with ID" + customerId);

	}

	@Override
	public String removeCustomerById(Integer customerId) {
		Optional<Customer> optional = repo.findById(customerId);

		if (optional.isPresent()) {
			repo.deleteById(customerId);
			return "Customer Details Deleted with id : " + optional.get().getCid();
		} else {
			throw new CustomerException("Customr Details Not Found with ID" + customerId);
		}
	}

}
