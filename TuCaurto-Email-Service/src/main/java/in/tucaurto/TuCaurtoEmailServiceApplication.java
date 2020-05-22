package in.tucaurto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TuCaurtoEmailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuCaurtoEmailServiceApplication.class, args);
	}

}
