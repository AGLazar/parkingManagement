package com.sda.parkingManagement.service;


import com.sda.parkingManagement.model.Subscription;
import com.sda.parkingManagement.model.SubscriptionDTO;
import com.sda.parkingManagement.repository.SubscriptionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SubscriptionService {
    @Autowired
    public SubscriptionRepository subscriptionRepository;

    public SubscriptionDTO createSubscription() {
        Subscription subscription = new Subscription();
        subscription.setCode(generateRandomCode());
        Date date = new Date();
        subscription.setStartDate(date);
        subscriptionRepository.save(subscription);

        SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
        subscriptionDTO.setCode(subscription.getCode());
        return subscriptionDTO;

    }

    public String generateRandomCode(){
        Date date = new Date();
        return "S" + date.getTime();
    }
}
