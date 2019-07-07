package com.sda.parkingManagement.service;

import com.sda.parkingManagement.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectorService {
    @Autowired
    public SectorRepository sectorRepository;

}
