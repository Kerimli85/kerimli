package az.developia.marketshopelmir.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import az.developia.marketshopelmir.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE " + "LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR "
			+ "LOWER(p.barcode) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR "
			+ "LOWER(p.price) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR "
			+ "LOWER(p.cost) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR "
			+ "LOWER(p.description) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR "
			+ "LOWER(p.registerDate) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR "
			+ "LOWER(p.updateDate) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR "
			+ "LOWER(p.quantity) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR "
			+ "LOWER(p.percent) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR "
			+ "LOWER(p.registerDate) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
	List<Product> search(@Param("searchTerm") String searchTerm);

	Product findByBarcode(String barcode);
}