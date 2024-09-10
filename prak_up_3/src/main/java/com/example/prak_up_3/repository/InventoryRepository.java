package com.example.prak_up_3.repository;

import com.example.prak_up_3.model.InventoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryModel, Long> {
}
