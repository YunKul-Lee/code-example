package com.jake.sqs;

import com.jake.sqs.publish.Publisher;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class SpringBootAwsSqsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAwsSqsApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(Publisher publisher) {
		return args -> {
			Thread.sleep(3000);

			for(int i = 0; i < 10; i++) {
				publisher.publishMessage(String.valueOf(i));
			}
		};
	}
}
