package com.example.prak_up_3.service;

import com.example.prak_up_3.model.InventoryModel;
import com.example.prak_up_3.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public List<InventoryModel> findAllInventories() {
        return inventoryRepository.findAll();
    }

    @Override
    public InventoryModel createInventory(InventoryModel inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public InventoryModel updateInventory(InventoryModel inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public InventoryModel findInventoryById(Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }
}
