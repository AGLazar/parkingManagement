package com.sda.parkingManagement.repository;

import com.sda.parkingManagement.model.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<ParkingSpace, Long> {
}
