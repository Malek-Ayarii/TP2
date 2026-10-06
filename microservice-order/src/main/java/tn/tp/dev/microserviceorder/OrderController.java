package tn.tp.dev.microserviceorder;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@GetMapping("/with-customer/{id}")
	public Map<String, Object> getOrderWithCustomer(@PathVariable Long id) {
		Order order = orderRepository.findById(id).orElseThrow();
		Customer customer = restTemplate.getForObject(
				"http://localhost:8082/customers/" + order.getCustomerId(),
				Customer.class);
		return Map.of("order", order, "customer", customer);
	}
}
