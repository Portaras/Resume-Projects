package in.pws.consumerForRestController;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import in.pws.model.Customer;
import reactor.core.publisher.Mono;

@Component
public class ConsumerRunnerPostOperationUsingWebClient implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {


		System.out.println("POST OPERATION USING WEB CLIENT");
		@SuppressWarnings("deprecation")
		Customer customer = new Customer(1, "Ars","Chennai",new Date(123,0,1) );		
		WebClient webClient = WebClient.create();
		String uri = "http://localhost:9999/restcrm/api/customer/saveform";
		String status = webClient.post().
		uri(uri, customer).body( Mono.just(customer), Customer.class).retrieve().bodyToMono(String.class).block();
		System.out.println(status);


	}

}
