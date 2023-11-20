package in.pws.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pws.dao.ICustomerRepo;
import in.pws.model.Customer;

@Service("service")
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepo repo;

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> listOfCustomer = repo.findAll();
		System.out.println("LIST OF CUSTOMERS" + listOfCustomer);
		return listOfCustomer;
	}

	@Override
	public Boolean saveCustomer(Customer customer) {
		if (customer != null) {
			@SuppressWarnings("unused")
			Customer savedCustomer = repo.save(customer);
			return true;
		}
		return false;
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		Optional<Customer> optional = repo.findById(customerId);
		return optional.get();
	}

	@Override
	public Boolean removeCustomerById(Integer customerId) {

		repo.deleteById(customerId);

		return repo.findById(customerId).isPresent();
	}

}
