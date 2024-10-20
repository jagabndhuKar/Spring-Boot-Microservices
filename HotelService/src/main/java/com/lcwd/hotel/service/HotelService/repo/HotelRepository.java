package com.lcwd.hotel.service.HotelService.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.hotel.service.HotelService.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
