package in.pws.service;

import java.util.List;

import in.pws.model.Customer;

public interface ICustomerService {

	public List<Customer> getAllCustomer();

	public String saveCustomer(Customer customer);

	public Customer getCustomerById(Integer customerId);

	public String removeCustomerById(Integer customerId);


}