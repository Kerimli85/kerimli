package az.kerimli.accessoryshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.kerimli.accessoryshopping.model.ProductModel;
import az.kerimli.accessoryshopping.repository.ProductRepo;
import az.kerimli.accessoryshopping.service.ProductService;

@RestController
@RequestMapping(path = "/products")
@CrossOrigin(origins = "*")
public class ProductRestController {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private ProductService productService;

	// create
	@PostMapping
	public ProductModel save(@RequestBody ProductModel productModel) {
		return productService.saveProduct(productModel);
	}

	// read
	@GetMapping
	public List<ProductModel> findAll() {
		return productRepo.findAll();
	}
	
	// update
	@PutMapping
	public ProductModel update(@RequestBody ProductModel productModel) {
			return productService.updateProduct(productModel);
		
	}
	
	// delete
	@DeleteMapping(path = "/{id}")
	public void deleteById(@PathVariable Integer id) {
		productRepo.deleteById(id);
	}
	
}
