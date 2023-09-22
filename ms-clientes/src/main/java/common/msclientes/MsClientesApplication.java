package common.msclientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("common.persistence.repositorys")
@EntityScan("common.persistence.entitys")
public class MsClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsClientesApplication.class, args);
	}

}
