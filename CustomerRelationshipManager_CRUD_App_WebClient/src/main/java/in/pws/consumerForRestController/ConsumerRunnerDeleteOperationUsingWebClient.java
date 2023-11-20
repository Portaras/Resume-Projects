//package in.pws.consumerForRestController;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.client.WebClient;
//
//@Component
//public class ConsumerRunnerDeleteOperationUsingWebClient implements CommandLineRunner {
//	int i=3;
//	@Override
//	public void run(String... args) throws Exception {
//
//		
//		System.out.println("DELETE OPERATION USING WEB CLIENT");
//			
//		WebClient webClient = WebClient.create();
//		String uri = "http://localhost:9999/restcrm/api/customer/deleteForm/{id}";
//		String status = webClient.delete().uri(uri, i++).retrieve().bodyToMono(String.class).block();
//		System.out.println(status);
//		
//
//
//	}
//
//}
