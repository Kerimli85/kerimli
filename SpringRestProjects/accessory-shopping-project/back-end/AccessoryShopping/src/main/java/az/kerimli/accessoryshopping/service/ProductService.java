package az.kerimli.accessoryshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.kerimli.accessoryshopping.model.ProductModel;
import az.kerimli.accessoryshopping.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	public ProductModel saveProduct(ProductModel productModel) {
		return productRepo.save(productModel);
	}

}
