package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
			
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Book");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "123456", "987456321");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "123456", "123456789");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:05Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-23T20:24:07Z"), OrderStatus.WAITING_PAYMENT, u2);	
		Order o3 = new Order(null, Instant.parse("2019-12-12T11:03:09Z"), OrderStatus.WAITING_PAYMENT, u1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
		
}
