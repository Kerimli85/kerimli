package az.kerimli.accessoryshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.kerimli.accessoryshopping.model.ProductModel;



public interface ProductRepo extends JpaRepository<ProductModel, Integer> {

}
