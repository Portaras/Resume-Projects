package in.pws.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pws.model.Customer;

public interface ICustomerRepo extends JpaRepository<Customer, Integer> {

}
