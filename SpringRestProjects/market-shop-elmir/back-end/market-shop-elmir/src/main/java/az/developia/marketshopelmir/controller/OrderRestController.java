package az.developia.marketshopelmir.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.developia.marketshopelmir.model.Order;
import az.developia.marketshopelmir.model.SellRequest;
import az.developia.marketshopelmir.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

	@Autowired
	private OrderService orderService;

	@PostMapping(path = "/sell")
	public ResponseEntity<Order> sell(@RequestBody List<SellRequest> sellRequests) {
		Order order = orderService.sell(sellRequests);
		return ResponseEntity.ok(order);
	}

	@GetMapping(path = "/betweenDates")
	public ResponseEntity<List<Order>> getOrdersBetweenDates(@RequestParam("startDate") String startDateStr,
			@RequestParam("endDate") String endDateStr) {
		LocalDate startDate = LocalDate.parse(startDateStr);
		LocalDate endDate = LocalDate.parse(endDateStr);
		List<Order> orders = orderService.getOrdersBetweenDates(startDate, endDate);
		return ResponseEntity.ok(orders);
	}

}
