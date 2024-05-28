package com.souza.projeto.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.souza.projeto.entities.Category;
import com.souza.projeto.entities.Order;
import com.souza.projeto.entities.OrderItem;
import com.souza.projeto.entities.Payment;
import com.souza.projeto.entities.Product;
import com.souza.projeto.entities.User;
import com.souza.projeto.entities.enums.OrderStatus;
import com.souza.projeto.repositories.CategoryRepository;
import com.souza.projeto.repositories.OrderItemRepository;
import com.souza.projeto.repositories.OrderRepository;
import com.souza.projeto.repositories.ProductRepository;
import com.souza.projeto.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository UserRepository;
	@Autowired
	private OrderRepository OrderRepository;
	@Autowired
	private CategoryRepository CategoryRepository;
	@Autowired
	private ProductRepository ProductRepository;
	@Autowired
	private OrderItemRepository OrderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Computadores e Acessórios");
		Category cat2 = new Category(null, "Componentes");
		Category cat3 = new Category(null, "Periféricos");
		Category cat4 = new Category(null, "Software");
		Category cat5 = new Category(null, "Gaming");
		Category cat6 = new Category(null, "Hardware");
		
		Product p1 = new Product(null, "Notebook Gamer", "Notebook Gamer Lenovo i5-11300H NVIDIA® GeForce® GTX1650 4GB GDDR6 8GB 512 SSD Tela Full HD 15.6\" Windows 11 ", 3000.5, "");
		Product p2 = new Product(null, "Desktop All-in-One", "Computador integrado com monitor, ideal para economizar espaço.", 2190.0, "");
		//Product p3 = new Product(null, "Macbook Pro", "Apple notebook MacBook Air (de 13 polegadas, Processador M1 da Apple com CPU 8‑core e GPU 7‑core, 8 GB RAM,.", 4000.0, "https://www.dropbox.com/scl/fi/yyvj90bgxdrkh7735fqn1/mac.jpg?rlkey=hoigwe9x8voq10kcqappwv0bn&st=03uqkoq2&dl=0");
		Product p4 = new Product(null, "SSD Externo", "HD SSD 1TB Sandisk SDSSDA-1T00-G26", 170.0, "");
		Product p5 = new Product(null, "Pen Drive USB 3.0", "Sandisk Ultra Shift Usb 3.0 Flash Drive 128Gb.", 100.99, "");
		Product p6 = new Product(null, "Antivírus", "Avast Premium Security", 19.99, "");
		Product p7 = new Product(null, "Cadeira Gamer", "Xtreme Gamers, Cadeira Cinesis Giratória Reclinável Altura Ajustável Preta.", 729.99, "");
		Product p8 = new Product(null, "Headset Surround 7.1", "HEADSET GAMER HYPERX CLOUD STINGER 2.", 190.99, "");
		Product p9 = new Product(null, "Gamepad", "Controle DualSense - Branco.", 380.99, "");
		
		
		CategoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6));
		ProductRepository.saveAll(Arrays.asList(p1,p2,p4,p5,p6,p7,p8,p9));
		
		
		p1.getCategories().add(cat1);
		p1.getCategories().add(cat5);
		p2.getCategories().add(cat1);
		//p3.getCategories().add(cat1);
		p4.getCategories().add(cat6);
		p5.getCategories().add(cat1);
		p5.getCategories().add(cat2);
		p6.getCategories().add(cat4);
		p7.getCategories().add(cat2);
		p8.getCategories().add(cat5);
		p8.getCategories().add(cat3);
		p9.getCategories().add(cat3);
		
		
		ProductRepository.saveAll(Arrays.asList(p1,p2,p4,p5,p6,p7,p8,p9));
		
		User u1 = new User(null, "Miguel Arthur", "Miguel@gmail.com", "(38) 92424-4723", "123456");
		User u2 = new User(null, "Heitor Benjamin", "Heitor@gmail.com", "(32) 93897-6242", "123456");
		User u3 = new User(null, "Enzo Gabriel", "Enzo@gmail.com", "(32) 92605-8588", "123456");
		User u4 = new User(null, "João Lucca", "Joao@gmail.com", "(33) 92865-7784", "123456");
		User u5 = new User(null, "Levi", "Levi@gmail.com", "(37) 93127-2577", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u1);
		
		UserRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5));
		OrderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		//OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		//OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		OrderItemRepository.saveAll(Arrays.asList(oi1,oi4));
		
		Payment pay1 = new Payment(null,Instant.parse("2019-06-20T21:53:07Z"),o1);
		o1.setPayment(pay1);
		OrderRepository.save(o1);
		
	}
	
	

}

