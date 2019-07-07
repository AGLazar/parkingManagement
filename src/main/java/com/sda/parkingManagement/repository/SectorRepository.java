package com.sda.parkingManagement.repository;

import com.sda.parkingManagement.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends JpaRepository<Sector,Long> {
}
