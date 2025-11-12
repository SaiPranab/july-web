package com.example.methods_of_jpa;

import org.springframework.stereotype.Service;

import com.example.methods_of_jpa.model.Order;
import com.example.methods_of_jpa.repository.OrderRepository;
import com.example.methods_of_jpa.repository.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
  private final ProductRepository productRepository;
  private final OrderRepository orderRepository;

  	@Transactional
	public void placeOrder(String productId, int quantity) {
		var product = productRepository.findById(productId).orElseThrow();

		// reduce stock
		product.setQuantity(product.getQuantity() - quantity);
		productRepository.save(product);

		if(true) throw new RuntimeException();

		// place order
		var order = Order.builder()
									.productId(productId)
									.quantity(quantity)
									.build();
		orderRepository.save(order);
	}
}
