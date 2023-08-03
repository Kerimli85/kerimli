package az.developia.marketshopelmir.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.marketshopelmir.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	  List<Order> findByOrderDateBetween(LocalDate startDate, LocalDate endDate);
}
