//package in.pws.consumerForRestController;
//
//
//import java.util.Map;
//
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//@Component
//public class ConsumerRunnerGetOperationUsingExchange implements CommandLineRunner {
//
//	@Override
//	public void run(String... args) throws Exception {
//			System.out.println("GET OPERATION USING EXCHANGE");
//			RestTemplate template1 = new RestTemplate();
//;			String uri="http://localhost:9999/restcrm/api/customer/getCustomer/{id}";
//			template1.exchange(uri, null, null, null, null);
////			System.out.println("BODY : " +entity.getBody() +" : "+ entity.getStatusCode() +" : " + entity.getStatusCode().value() + entity.getHeaders());
//			
//	}
//
//}
