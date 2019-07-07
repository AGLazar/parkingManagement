package com.sda.parkingManagement.controller;

import com.sda.parkingManagement.model.ParkingSpace;
import com.sda.parkingManagement.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/parkingSpaces")
public class ParkingSpaceController {

    public ParkingSpaceService parkingSpaceService;

    @Autowired
    public ParkingSpaceController(ParkingSpaceService parkingSpaceService) {
        this.parkingSpaceService = parkingSpaceService;
    }

    @GetMapping
    public List<ParkingSpace> getAllParkingSpaces() {
        return parkingSpaceService.getAll();
    }

    @PutMapping(value ="/{id}")
    public ParkingSpace updateParkingSpace(@RequestBody ParkingSpace parkingSpace, @PathVariable Long id) {
        if (id != parkingSpace.getId()) {
            throw new RuntimeException("Id s do not match");
        }
        return parkingSpaceService.update(parkingSpace);
    }
}
