package az.developia.marketshopelmir.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.marketshopelmir.model.Order;
import az.developia.marketshopelmir.model.OrderItem;
import az.developia.marketshopelmir.model.Product;
import az.developia.marketshopelmir.model.SellRequest;
import az.developia.marketshopelmir.repository.OrderRepository;
import az.developia.marketshopelmir.repository.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;

	public Order sell(List<SellRequest> sellRequests) {
			
		List<OrderItem> orderItems = new ArrayList<>();
		Double totalPrice = 0.0;
		for (SellRequest sellRequest : sellRequests) {
			Product product = productRepository.findByBarcode(sellRequest.getBarcode());
			if (product == null) {
				throw new RuntimeException("Product not found with barcode: " + sellRequest.getBarcode());
			}
			if (product.getQuantity() < sellRequest.getQuantity()) {
				throw new RuntimeException(
						"Insufficient quantity for product with barcode: " + sellRequest.getBarcode());
			}

			OrderItem orderItem = new OrderItem();

			orderItem.setQuantity(sellRequest.getQuantity());
			orderItem.setName(product.getName());
			orderItem.setDescription(product.getDescription());
			orderItem.setPrice(product.getPrice());
			orderItems.add(orderItem);
			totalPrice += sellRequest.getQuantity() * product.getPrice();
			product.setQuantity(product.getQuantity() - sellRequest.getQuantity());
			productService.updateProduct(product);

		}
		

		Order order = new Order();
		order.setOrderItems(orderItems);
		order.setTotalPrice(totalPrice);
		orderRepository.save(order);
		return order;
	}
	
	public List<Order> getOrdersBetweenDates(LocalDate startDate, LocalDate endDate) {
        return orderRepository.findByOrderDateBetween(startDate, endDate);
    }
}