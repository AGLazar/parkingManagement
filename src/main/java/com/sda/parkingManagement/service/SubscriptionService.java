package com.sda.parkingManagement.service;

import com.sda.parkingManagement.repository.SubscripionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
    @Autowired

    public SubscripionRepository subscripionRepository;
}