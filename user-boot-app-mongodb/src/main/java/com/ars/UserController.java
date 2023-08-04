package com.ars;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	//private final Logger LOG = LoggerFactory.getLogger(getClass());
		@Autowired
		private UserRepository userRepository;
		
		@RequestMapping(value = "/all", method = RequestMethod.GET)
		public List<User> getAllUsers() {
			//LOG.info("Getting all users.");
			System.out.println("Getting all users");
			return userRepository.findAll();
		}
		
		@RequestMapping(value = "/create", method = RequestMethod.POST)
		public User addNewStudent(@RequestBody User user) {
			return userRepository.save(user);
		}
		
		@RequestMapping(value = "/update/{userId}", method = RequestMethod.PUT)
		public User updateUser(@RequestBody User user, @PathVariable String userId) {
			userRepository.findById(userId);
			return userRepository.save(user);
		}
		
		@RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)
		public void deleteUser(@PathVariable String userId) {
			userRepository.findById(userId);
			userRepository.deleteById(userId);		
		}
}