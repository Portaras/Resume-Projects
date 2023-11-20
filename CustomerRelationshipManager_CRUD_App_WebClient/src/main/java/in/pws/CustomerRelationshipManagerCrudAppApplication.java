package in.pws;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.pws.model.Customer;
import in.pws.service.CustomerServiceImpl;

@SpringBootApplication
public class CustomerRelationshipManagerCrudAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CustomerRelationshipManagerCrudAppApplication.class, args);
		CustomerServiceImpl service = context.getBean(CustomerServiceImpl.class);
		List<Customer> allCustomer = service.getAllCustomer();
		allCustomer.forEach(System.out::println);
	}

}
