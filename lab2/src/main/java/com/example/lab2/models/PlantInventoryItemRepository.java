package com.example.lab2.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantInventoryItemRepository  extends JpaRepository<PlantInventoryItem, Long> {
    PlantInventoryItem findOneByPlantInfo(PlantInventoryEntry entry);
}