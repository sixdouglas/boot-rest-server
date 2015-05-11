package org.douglas.tournament;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

@SpringBootApplication
@EnableJpaRepositories("org.douglas.tournament.controller")
@EntityScan("org.douglas.tournament.domain")
@Import(RepositoryRestMvcConfiguration.class)
@EnableHypermediaSupport(type = { HypermediaType.HAL })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}