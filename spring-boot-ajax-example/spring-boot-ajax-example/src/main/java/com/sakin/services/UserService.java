package com.sakin.services;

import org.springframework.stereotype.Service;

import com.sakin.model.User;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

	private List<User> users;

	// Love Java 8
	public List<User> findByUserNameOrEmail(String username) {

		List<User> result = users.stream().filter(x -> x.getUsername().equalsIgnoreCase(username))
				.collect(Collectors.toList());

		return result;

	}

	// Init some users for testing
	@PostConstruct
	private void iniDataForTesting() {

		users = new ArrayList<User>();

		User user1 = new User("ramazan", "123123", "rmzn@mail.com");
		User user2 = new User("sabri", "232323", "zabri@mail.com");
		User user3 = new User("kerim", "321312", "kero@mail.com");

		users.add(user1);
		users.add(user2);
		users.add(user3);

	}

}
