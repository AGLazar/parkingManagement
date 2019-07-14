package com.sda.parkingManagement.repository;

import com.sda.parkingManagement.model.ParkingSpace;
import com.sda.parkingManagement.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Subscription findByCode(String code);
}
