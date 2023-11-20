package in.pws.consumerForRestController;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import in.pws.model.*;
import reactor.core.Disposable;

@Component
public class ConsumerRunnerGetOperationUsingWebClient implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("GET OPERATION USING WEB CLIENT");
		WebClient webClient = WebClient.create();
		String uri = "http://localhost:9999/restcrm/api/customer/getCustomer/{id}";
		Disposable subscribe = webClient.get().uri(uri, 35).retrieve().bodyToMono(Customer.class).subscribe(response->System.out.println("RESPONSE :"+response));
		System.out.println("At the Method End: "  + subscribe.isDisposed());
	}

}
