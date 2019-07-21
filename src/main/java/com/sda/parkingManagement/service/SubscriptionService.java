package com.sda.parkingManagement.service;


import com.sda.parkingManagement.model.Subscription;
import com.sda.parkingManagement.model.SubscriptionDTO;
import com.sda.parkingManagement.repository.SubscriptionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class SubscriptionService {
    @Autowired
    public SubscriptionRepository subscriptionRepository;

    public SubscriptionDTO createSubscription() {
        Subscription subscription = new Subscription();
        subscription.setCode(generateRandomCode());
        Date date1 = new Date();
        Date date2 = new Date();
        subscription.setStartDate(date1);
        subscription.setEndDate(date2);
        subscriptionRepository.save(subscription);

        SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
        subscriptionDTO.setCode(subscription.getCode());
        subscriptionDTO.setStartDate(subscription.getStartDate());
        subscriptionDTO.setEndDate(subscription.getEndDate());
        return subscriptionDTO;

    }

    public String generateRandomCode(){
        Date date = new Date();
        return "S" + date.getTime();
    }

    public Subscription getSubscriptionById(Long id) {
        Optional<Subscription> subscription = subscriptionRepository.findById(id);
        return subscription.orElse(null);
    }

    public Subscription findSubscriptionByCode(String code) {
        return subscriptionRepository.findByCode(code);
    }

    public long calculatePeriod(Subscription subscription, TimeUnit timeUnit){
        long diffInMin = subscription.getStartDate().getTime()-subscription.getEndDate().getTime();
        return  timeUnit.convert(diffInMin,TimeUnit.HOURS);
    }




}
