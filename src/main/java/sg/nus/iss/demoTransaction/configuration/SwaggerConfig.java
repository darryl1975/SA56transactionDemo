package sg.nus.iss.demoTransaction.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

// References
// https://riptutorial.com/swagger/example/25118/setup-springfox-using-swagger-ui-in-spring-boot

@Configuration
// @EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				// .paths(PathSelectors.any())
				.paths(PathSelectors.regex("/.*"))
				// .paths(Predicates.not(PathSelectors.regex("/error.*")))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Money Transfer API with Swagger")
				.description("A demo about money transfer api")
				.termsOfServiceUrl("http://www.moneytransfer.com")
				.license("Copyright © MoneyTransferAPI")
				.version("1.0")
				.build();
	}
}
