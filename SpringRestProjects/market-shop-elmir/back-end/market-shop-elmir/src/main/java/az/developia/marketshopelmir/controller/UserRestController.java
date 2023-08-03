package az.developia.marketshopelmir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.marketshopelmir.model.UserModel;
import az.developia.marketshopelmir.repository.UserRepository;
import az.developia.marketshopelmir.service.UserService;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "*")
public class UserRestController {

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@PostMapping
	public UserModel addUser(@RequestBody UserModel user) {
		return userService.addUser(user);
	}

	@GetMapping
	public List<UserModel> findAll() {
		return userRepository.findAll();
	}
}
