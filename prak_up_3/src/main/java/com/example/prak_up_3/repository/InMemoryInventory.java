package com.example.prak_up_3.repository;

import com.example.prak_up_3.model.InventoryModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Repository
public class InMemoryInventory {

    private final List<InventoryModel> INVENTORIES = new ArrayList<>();

    public List<InventoryModel> findAllInventories() {
        return INVENTORIES;
    }

    public InventoryModel findInventoryById(Long id) {
        return INVENTORIES
                .stream()
                .filter(element -> element.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public InventoryModel createInventory(InventoryModel inventory) {
        INVENTORIES.add(inventory);
        return inventory;
    }

    public InventoryModel updateInventory(InventoryModel inventory) {
        var inventoryIndex = IntStream.range(0, INVENTORIES.size())
                .filter(index -> INVENTORIES.get(index).getId().equals(inventory.getId()))
                .findFirst()
                .orElse(-1);
        if (inventoryIndex == -1) {
            return null;
        }
        INVENTORIES.set(inventoryIndex, inventory);
        return inventory;
    }

    public void deleteInventory(Long id) {
        var inventory = findInventoryById(id);
        if (inventory != null) {
            INVENTORIES.remove(inventory);
        }
    }
}
