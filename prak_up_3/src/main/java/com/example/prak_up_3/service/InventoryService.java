package com.example.prak_up_3.service;


import com.example.prak_up_3.model.InventoryModel;

import java.util.List;

public interface InventoryService {
    List<InventoryModel> findAllInventories();
    InventoryModel createInventory(InventoryModel inventory);
    InventoryModel updateInventory(InventoryModel inventory);
    InventoryModel findInventoryById(Long id);
    void deleteInventory(Long id);
}