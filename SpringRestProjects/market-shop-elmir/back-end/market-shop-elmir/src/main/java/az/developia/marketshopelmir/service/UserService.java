package az.developia.marketshopelmir.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.marketshopelmir.model.AuthorityModel;
import az.developia.marketshopelmir.model.UserModel;
import az.developia.marketshopelmir.repository.AuthorityRepository;
import az.developia.marketshopelmir.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthorityRepository authorityRepository;

	public UserModel addUser(UserModel user) {
		Optional<UserModel> userOptional = userRepository.findById(user.getUsername());
		if (userOptional.isPresent()) {
			user.setUsername("");
			return user;

		} else {

			user.setPassword("{noop}" + user.getPassword());
			user.setEnabled(true);
			UserModel savedUser = userRepository.save(user);

			AuthorityModel authority = new AuthorityModel();
			authority.setUsername(user.getUsername());
			authority.setAuthority("cashier");
			authorityRepository.save(authority);

			return savedUser;

		}
	}
}
