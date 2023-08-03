package az.developia.marketshopelmir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.developia.marketshopelmir.model.Product;
import az.developia.marketshopelmir.repository.ProductRepository;
import az.developia.marketshopelmir.service.ProductService;

@RestController
@RequestMapping(path = "/products")
@CrossOrigin(origins = "*")
public class ProductRestController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;

	// create
	@PostMapping
	public Product save(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	// read
	@GetMapping
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	// update
	@PutMapping
	public Product update(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

	// delete
	@DeleteMapping(path = "/{id}")
	public void deleteById(@PathVariable Integer id) {
		productRepository.deleteById(id);

	}

	// search
	@GetMapping("/search")
	public ResponseEntity<List<Product>> searchProducts(@RequestParam String q) {
		List<Product> products = productService.searchProducts(q);
		return ResponseEntity.ok(products);
	}

	

}