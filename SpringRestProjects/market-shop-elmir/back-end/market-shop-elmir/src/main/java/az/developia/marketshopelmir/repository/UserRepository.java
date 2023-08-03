package az.developia.marketshopelmir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.marketshopelmir.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String>{

}
