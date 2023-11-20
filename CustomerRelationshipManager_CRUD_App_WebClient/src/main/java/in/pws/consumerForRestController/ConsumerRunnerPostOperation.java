//package in.pws.consumerForRestController;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//@Component
//public class ConsumerRunnerPostOperation implements CommandLineRunner {
//
//	@Override
//	public void run(String... args) throws Exception {
//
//		System.out.println("POST OPERATION");
//
//		RestTemplate template = new RestTemplate();
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//
//		Object json_body = "{\n" + "  \"cid\": 4,\n" + "  \"cname\": \"Ars\",\n" + "  \"caddress\": \"TN\",\n"
//				+ "  \"doj\": \"2023-11-19T03:33:51.933Z\"\n" + "}";
//		HttpEntity<Object> request = new HttpEntity<>(json_body, headers);
//		String uri = "http://localhost:9999/restcrm/api/customer/saveform";
//		ResponseEntity<String> entity = template.postForEntity(uri, request, String.class);
//		System.out.println("BODY : " + entity.getBody() + " : " + entity.getStatusCode() + " : "
//				+ entity.getStatusCode().value() + entity.getHeaders());
//
//	}
//
//}
