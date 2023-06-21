package com.boteking.boteking;

import com.boteking.boteking.entities.Product;
import com.boteking.boteking.repositories.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Log4j2
public class BoteKingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoteKingApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        return args -> {
            log.info("preloading {}", productRepository.save(Product.builder()
                    .id(1)
                    .name("Coca-Cola").price(7.50)
                    .quantity(10)
                    .cost(5.50)
					.build()));
			log.info("preloading {}", productRepository.save(Product.builder()
					.id(2)
					.name("Brahma 300ml").price(5.5)
					.quantity(10)
					.cost(3.50)
					.build()));
			log.info("preloading {}", productRepository.save(Product.builder()
					.id(3)
					.name("Brahma 1000ml").price(12.50)
					.quantity(10)
					.cost(7.50)
					.build()));
			log.info("preloading {}", productRepository.save(Product.builder()
					.id(4)
					.name("Brahma 600ml").price(9.50)
					.quantity(10)
					.cost(5.50)
					.build()));
			log.info("preloading {}", productRepository.save(Product.builder()
					.id(5)
					.name("Imperio 300ml").price(6.50)
					.quantity(10)
					.cost(5.50)
					.build()));
			log.info("preloading {}", productRepository.save(Product.builder()
					.id(6)
					.name("Heineken 1000ml").price(13.50)
					.quantity(10)
					.cost(9.50)
					.build()));
        };
    }
}


