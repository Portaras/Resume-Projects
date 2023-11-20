package in.pws;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.pws.model.Customer;
import in.pws.service.CustomerServiceImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Customer Releationship Manager", description = "CRUD OPERATION", version = "1.0", contact = @Contact(name = "Portarasu", email = "portarasu@gmail.com", url = "http://localhost:9999/restcrm/", extensions = @Extension(properties = {
		@ExtensionProperty(name = "test", value = "testvalue"
) }))))
public class CustomerRelationshipManagerCrudAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication
				.run(CustomerRelationshipManagerCrudAppApplication.class, args);
		CustomerServiceImpl service = context.getBean(CustomerServiceImpl.class);
		List<Customer> allCustomer = service.getAllCustomer();
		allCustomer.forEach(System.out::println);
	}

}
