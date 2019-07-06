package com.sda.parkingManagement.service;

import com.sda.parkingManagement.model.ParkingSpace;
import com.sda.parkingManagement.repository.ParkingSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpaceService {

    @Autowired
    public ParkingSpaceRepository parkingSpaceRepository;

    public ParkingSpace update (ParkingSpace parkingSpace){
        return parkingSpaceRepository.save(parkingSpace);
    }

    public List<ParkingSpace> getAll (){
        return parkingSpaceRepository.findAll();
    }
}
