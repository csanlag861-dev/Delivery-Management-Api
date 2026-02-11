package com.repartos.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.repartos.demo.entities.Distribuidora;
import com.repartos.demo.helpers.SeederDB;
import com.repartos.demo.repositories.ConductorRepository;
import com.repartos.demo.repositories.DistribuidoraRepository;
import com.repartos.demo.repositories.ProductoRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		ConductorRepository condRepo = context.getBean(ConductorRepository.class);
		ProductoRepository prodRepo = context.getBean(ProductoRepository.class);
		DistribuidoraRepository distRepo = context.getBean(DistribuidoraRepository.class);

		new SeederDB(condRepo, prodRepo, distRepo);
	}

}
