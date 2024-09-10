package com.example.prak_up_3.controller;

import com.example.prak_up_3.model.InventoryModel;
import com.example.prak_up_3.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/inventories")
public class InventoryApiController {
    private final InventoryService inventoryService;

    public InventoryApiController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public List<InventoryModel> getAllInventories() {
        return inventoryService.findAllInventories();
    }

    @PostMapping
    public InventoryModel createInventory(@RequestBody InventoryModel inventory) {
        return inventoryService.createInventory(inventory);
    }

    @PutMapping("/{id}")
    public InventoryModel updateInventory(@PathVariable Long id, @RequestBody InventoryModel inventory) {
        inventory.setId(id);
        return inventoryService.updateInventory(inventory);
    }

    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
    }
}
