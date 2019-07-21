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

    public SubscriptionDTO createSubscription(SubscriptionDTO subscriptionDTO) {
        Subscription subscription = new Subscription();
        subscription.setCode(generateRandomCode());
        subscription.setEndDate(subscriptionDTO.getEndDate());
        subscription.setStartDate(subscriptionDTO.getStartDate());
        subscriptionRepository.save(subscription);

        SubscriptionDTO result = new SubscriptionDTO();
        result.setCode(subscription.getCode());
        result.setStartDate(subscription.getStartDate());
        result.setEndDate(subscription.getEndDate());
        return result;
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


    public boolean exit(String code) {
        Subscription subscription = subscriptionRepository.findByCode(code);
        if(subscription == null){
            return false;
        }
        if(subscription.getEndDate().before(new Date())){
            return false;
        }
        else return true;
    }


}
