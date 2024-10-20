package com.lcwd.user.service.UserService.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.UserService.Exception.UserNotFoundException;
import com.lcwd.user.service.UserService.entity.Hotel;
import com.lcwd.user.service.UserService.entity.Rating;
import com.lcwd.user.service.UserService.entity.User;
import com.lcwd.user.service.UserService.external.services.HotelService;
import com.lcwd.user.service.UserService.repo.Userrepo;

@Service
public class UserServicesImpl implements UserServices {

	private Userrepo userrepo;

	private RestTemplate restTemplate;
	
	private HotelService hotelService;

	private org.slf4j.Logger logger = LoggerFactory.getLogger(UserServicesImpl.class);

	@Autowired
	public UserServicesImpl(Userrepo userrepo, RestTemplate restTemplate, HotelService hotelService) {
		super();
		this.userrepo = userrepo;
		this.restTemplate = restTemplate;
		this.hotelService = hotelService;
	}

	@Override
	public User crateUser(User user) {
		String rendomUserId = UUID.randomUUID().toString();
		user.setId(rendomUserId);
		return userrepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userrepo.findAll();
	}

	@Override
	public User getUserById(String id) {
		User user = userrepo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found in server " + id));
		@SuppressWarnings("unchecked")
		Rating[] userRatings = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/" + user.getId(),
				Rating[].class);
		logger.info("{}", userRatings);
		List<Rating> userRatingList = Arrays.stream(userRatings).toList();
		userRatingList.stream().map(rating -> {
			
//			ResponseEntity<Hotel> hotel = restTemplate
//					.getForEntity("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);
			
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			
			
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());

		user.setRatingList(userRatingList);

		return user;

	}

	@Override
	public User updateUser(String id, User user) {
		return null;
	}

	@Override
	public String deleteUser(String id) {
		return null;
	}

}
