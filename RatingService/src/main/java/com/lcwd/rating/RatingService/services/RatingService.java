package com.lcwd.rating.RatingService.services;

import java.util.List;

import com.lcwd.rating.RatingService.entities.Rating;

public interface RatingService {
	 //create
    Rating create(Rating rating);


    //get all ratings
   public List<Rating> getRatings();

    //get all by UserId
   public List<Rating> getRatingByUserId(String userId);

    //get all by hotel
   public List<Rating> getRatingByHotelId(String hotelId);
}
