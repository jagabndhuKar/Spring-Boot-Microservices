package com.lcwd.hotel.service.HotelService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.service.HotelService.entity.Hotel;
import com.lcwd.hotel.service.HotelService.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.service.HotelService.repo.HotelRepository;
@Service
public class HotelServiceImpl implements HotelService{

	 @Autowired
	    private HotelRepository hotelRepository;

	    @Override
	    public Hotel create(Hotel hotel) {
	        String hotelId = UUID.randomUUID().toString();
	        hotel.setId(hotelId);
	        return hotelRepository.save(hotel);
	    }

	    @Override
	    public List<Hotel> getAll() {
	        return hotelRepository.findAll();
	    }

	    @Override
	    public Hotel get(String id) {
	    	System.out.println(id + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found !!"));
	    }
	

}
