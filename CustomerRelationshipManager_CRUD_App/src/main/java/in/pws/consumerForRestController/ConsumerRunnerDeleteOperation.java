package in.pws.consumerForRestController;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumerRunnerDeleteOperation implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("DELETE OPERATION");
		RestTemplate template = new RestTemplate();
		String uri = "http://localhost:9999/restcrm/api/customer/deleteForm/{id}";
		template.delete(uri, 1);

	}

}
