package com.lcwd.hotel.service.HotelService.services;

import java.util.List;

import com.lcwd.hotel.service.HotelService.entity.Hotel;

public interface HotelService {
	 //create

 public Hotel create(Hotel hotel);

    //get all
 public List<Hotel> getAll();

    //get single
 public Hotel get(String id);

}
