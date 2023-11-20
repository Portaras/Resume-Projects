package in.pws.service;

import java.util.List;

import in.pws.model.Customer;

public interface ICustomerService {

	public List<Customer> getAllCustomer();
	public Boolean saveCustomer(Customer customer);
	public Customer getCustomerById(Integer customerId);
	public Boolean removeCustomerById(Integer customerId);



}