package org.sid.customer.service;

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

import lombok.ToString;

@Entity // montre que cette classe est une entités
@Data @ToString @NoArgsConstructor @AllArgsConstructor//generation des getters et setters aussi des constructeurs
class Customer{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	
	
	
	
}



@RepositoryRestResource //permet l'exposition d'une api rest
interface CustomerRepository extends JpaRepository<Customer,Long>{}


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Bean 
	CommandLineRunner start( CustomerRepository customerRepository) {
		return args ->{
			//ajout de données à la base de données
			customerRepository.save(new Customer(null,"ab1k","ab1k@gmail.com"));
			customerRepository.save(new Customer(null,"ab2k","ab2k@gmail.com"));
			customerRepository.save(new Customer(null,"ab3k","ab3k@gmail.com"));
			customerRepository.save(new Customer(null,"ab4k","ab4k@gmail.com"));
			customerRepository.save(new Customer(null,"ab5k","ab5k@gmail.com"));
			customerRepository.findAll().forEach(System.out::println); //affichage des données en utilisant la méthode toString
		};
	}

}
