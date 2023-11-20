//package in.pws.consumerForRestController;
//
//import java.util.Map;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//@Component
//public class ConsumerRunnerGetOperation implements CommandLineRunner {
//
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("GET OPERATION");
//		RestTemplate template = new RestTemplate();
//		String uri = "http://localhost:9999/restcrm/api/customer/getCustomer/{id}";
//		ResponseEntity<String> entity = template.getForEntity(uri, String.class, Map.of("id", 3));
//		System.out.println("BODY : " + entity.getBody() + " : " + entity.getStatusCode() + " : "
//				+ entity.getStatusCode().value() + entity.getHeaders());
//
//	}
//
//}
