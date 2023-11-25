package az.kerimli.accessoryshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.kerimli.accessoryshopping.model.ProductModel;


@Repository
public interface ProductRepo extends JpaRepository<ProductModel, Integer> {

}
