package com.example.methods_of_jpa;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.example.methods_of_jpa.model.Order;
import com.example.methods_of_jpa.model.Product;
import com.example.methods_of_jpa.repository.OrderRepository;
import com.example.methods_of_jpa.repository.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class MethodsOfJpaApplication {
	private final ProductRepository productRepository;
	private final OrderRepository orderRepository;
	private final OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(MethodsOfJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return (args) -> {
			var product = Product.builder()
					.productName("Iphone 17 pro max")
					.productBrand("Apple")
					.productPrice(150000.99)
					.build();

			// SAVE
			// var savedProduct = productRepository.save(product);
			// System.out.println("saved product is " + savedProduct);

			// // SAVE ALL
			// var products = getProducts();
			// productRepository.saveAll(products);

			// COUNT
			// var numberOfAvailableProducts = productRepository.count();
			// System.out.println("//////////////////////////////////" +
			// numberOfAvailableProducts);

			// Exists
			// System.out.println("////////////////////// " +
			// productRepository.exists(Example.of(product)));
			// System.out.println(".................... " +
			// productRepository.existsById("f3c93d7d-ed9a-42c1-a541-1460726c89fd"));

			// Delete
			// productRepository.deleteById("f3c93d7d-ed9a-42c1-a541-1460726c89fd");

			// FIND ALL (SELECT) -> for extracting multiple rows
			// var existingProducts = productRepository.findAll();
			// existingProducts.forEach(System.out::println);
			// existingProducts.forEach(p -> System.out.println(p));
			// for (var p : existingProducts) {
			// System.out.println(p);
			// }

			// var sortedProductsByProductName =
			// productRepository.findAll(Sort.by(Direction.DESC, "productName"));
			// sortedProductsByProductName.forEach(System.out::println);

			// var productsByPage = productRepository.findAll(PageRequest.of(0, 6)); //
			// pageNumber (0 - based indexing), pageSize (number of data available in that
			// page)
			// var productsByPage = productRepository.findAll(PageRequest.of(0, 6,
			// Sort.by(Direction.ASC, "productName")));
			// productsByPage.forEach(System.out::println);

			// FIND BY ID (SELECT) -> for extractin a single row
			// var existingProduct =
			// productRepository.findById("f9fbe308-6d07-4aa3-a403-3e1f4dd9c593").orElseThrow();
			// // NoSuchElementException
			// System.out.println("/////////////////////" + existingProduct);

			// UPDATE
			// var optProduct = productRepository.findById("f9fbe308-6d07-4aa3-a403");
			// if(optProduct.isPresent()) {
			// var existingProduct = optProduct.get();
			// existingProduct.setProductPrice(existingProduct.getProductPrice() + 123);
			// productRepository.save(existingProduct);
			// } else {
			// System.out.println("No Product Found");
			// }

			/**
			 * Above emthods are already given by JPA Repository, but if we want to execute
			 * some custom SQL query
			 * - Custom Query Methods (Query methods created by us)
			 * - JPQL (Java Persistence Query Language)
			 * - Native Query or Plain SQL
			 */

			// ====================== Query Methods ================
			// var productByName = productRepository.findByProductName("Iphone 17 pro
			// max").orElseThrow();
			// System.out.println("////////////////////////" + productByName);

			// var productsInRange = productRepository.findAllByProductPriceBetween(2000,
			// 5000);
			// productsInRange.forEach(System.out::println);

			// var productsGreaterThan4002 =
			// productRepository.findAllByProductPriceGreaterThan(4002);
			// productsGreaterThan4002.forEach(System.out::println);

			// var productsGreaterThanEquals4002 =
			// productRepository.findAllByProductPriceGreaterThanEqual(4002);
			// productsGreaterThanEquals4002.forEach(System.out::println);

			// var productsGreaterThanEquals4002Sorted = productRepository
			// .findAllByProductPriceGreaterThanEqual(4002, Sort.by(Direction.DESC,
			// "productPrice"));
			// productsGreaterThanEquals4002Sorted.forEach(System.out::println);

			// var productByPriceAndBrand = productRepository
			// .findByProductPriceAndProductBrand(150000.99, "Apple");
			// System.out.println("//////////////////////// " + productByPriceAndBrand);

			// var productsHavingBrandNull =
			// productRepository.findAllByProductNameIsNotNull();
			// productsHavingBrandNull.forEach(System.out::println);

			// =========================== JPQL =========================
			// var product1 = productRepository.getProduct1(150000.99, "Apple");
			// System.out.println("////////////////////////////" + product1);

			// var product2 = productRepository.getProduct2(150000.99, "Apple");
			// System.out.println("////////////////////////////" + product2);

			// var product3 = productRepository.getProduct3(150000.99, "Apple");
			// System.out.println("////////////////////////////" + product3);

			// var affectedRows = productRepository.updateProduct(250000.99, "Apple");
			// System.out.println("////////////////////////////-> " + affectedRows);

			orderService.placeOrder("35538a31-2997-4941-9ba2-9aac7f490194", 25);
		};
	}

	// @Transactional
	// private void placeOrder(String productId, int quantity) {
	// var product = productRepository.findById(productId).orElseThrow();

	// // reduce stock
	// product.setQuantity(product.getQuantity() - quantity);
	// productRepository.save(product);

	// if(true) throw new RuntimeException();

	// // place order
	// var order = Order.builder()
	// .productId(productId)
	// .quantity(quantity)
	// .build();
	// orderRepository.save(order);
	// }

	private List<Product> getProducts() {
		return IntStream.range(1, 10)
				.mapToObj(i -> {
					return Product.builder()
							.productName("product- " + i)
							.productBrand("brand- " + i)
							.productPrice(1000.50 * i)
							.build();
				})
				.toList();

		// var numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		// return numbers.stream()
		// .map(number -> {
		// return Product.builder()
		// .productName("product- " + number)
		// .productBrand("brand- " + number)
		// .productPrice(1000.50 * number)
		// .build();
		// })
		// .toList();

	}
}
