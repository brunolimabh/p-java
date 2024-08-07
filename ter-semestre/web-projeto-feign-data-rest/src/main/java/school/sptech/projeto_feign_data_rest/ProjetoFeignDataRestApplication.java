package school.sptech.projeto_feign_data_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableFeignClients
public class ProjetoFeignDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoFeignDataRestApplication.class, args);
	}

}
