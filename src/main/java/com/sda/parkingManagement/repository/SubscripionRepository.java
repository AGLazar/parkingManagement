package com.sda.parkingManagement.repository;

import com.sda.parkingManagement.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscripionRepository extends JpaRepository<Subscription, Long> {
}