package az.developia.marketshopelmir.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import az.developia.marketshopelmir.model.Product;
import az.developia.marketshopelmir.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product saveProduct(Product product) {
		String loginingUser = SecurityContextHolder.getContext().getAuthentication().getName();// cashier
		product.setLoginingUser(loginingUser);
		// updatenin qarsisi alindi
		product.setId(null);

		Double price = product.getPrice();
		Double cost = product.getCost();

		// percent hesaplama;
		// kemiyyete gore faizin tapilmasi create;
		Double percent = (((price - cost) / cost * 100));
		product.setPercent(percent);

		// tarixlerin saxlanmasi create
		LocalDate now = LocalDate.now();
		product.setRegisterDate(now);
		product.setUpdateDate(now);

		return productRepository.save(product);
	}

	public Product updateProduct(Product product) {

		// cashier
		String loginingUser = SecurityContextHolder.getContext().getAuthentication().getName();
		product.setLoginingUser(loginingUser);

		Double price = product.getPrice();
		Double cost = product.getCost();

		// percent hesaplama;
		// kemiyyete gore faizin tapilmasi update;
		Double percent = (((price - cost) / cost * 100));
		product.setPercent(percent);

		// tarixlerin saxlanmasi update
		LocalDate now = LocalDate.now();
		product.setUpdateDate(now);

		return productRepository.save(product);
	}

	public List<Product> searchProducts(String searchTerm) {
		return productRepository.search(searchTerm);
	}
}