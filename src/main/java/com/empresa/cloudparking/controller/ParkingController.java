package com.empresa.cloudparking.controller;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.cloudparking.dto.ParkingDTO;
import com.empresa.cloudparking.mapper.ParkingMapper;
import com.empresa.cloudparking.model.Parking;
import com.empresa.cloudparking.service.ParkingService;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;
    @Autowired
    private ParkingMapper parkingMapper;
    
    @GetMapping
    public ResponseEntity <List<ParkingDTO>> findAll(){

      List<Parking> parkingList = parkingService.findAll();
      List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
      return ResponseEntity.ok(result);
    }
}
