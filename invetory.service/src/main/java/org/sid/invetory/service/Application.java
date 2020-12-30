package org.sid.invetory.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import lombok.*;

@Entity 
@Data @AllArgsConstructor @NoArgsConstructor @ToString
class Product{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double price;
	public Product(Long id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
}

@RepositoryRestResource
interface ProductRepository extends JpaRepository<Product,Long>{
	
}

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	CommandLineRunner start(ProductRepository productRespository) {
		return args->{
			productRespository.save(new Product(null,"Computer HP 605",6500));
			productRespository.save(new Product(null,"¨Printer Epson 430",500));
			productRespository.save(new Product(null,"Computer Mac Book Pro",12000));
			productRespository.findAll().forEach(System.out::println);
		};
	}

}
