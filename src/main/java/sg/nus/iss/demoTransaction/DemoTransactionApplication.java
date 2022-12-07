package sg.nus.iss.demoTransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

// References
// https://stackoverflow.com/questions/63991872/failed-to-start-bean-documentationpluginsbootstrapper-spring-boot-swagger-impl
// https://dev.to/smartyansh/introduction-to-springfox-48ng

@EnableSwagger2
@SpringBootApplication
public class DemoTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTransactionApplication.class, args);
	}

}
