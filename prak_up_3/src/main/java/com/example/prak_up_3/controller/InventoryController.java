package com.example.prak_up_3.controller;

import com.example.prak_up_3.model.InventoryModel;
import com.example.prak_up_3.model.ToyModel;
import com.example.prak_up_3.service.InventoryService;
import com.example.prak_up_3.service.ToyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InventoryController {

    @Qualifier("toyServiceImpl")
    @Autowired
    private ToyService toyService;

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/inventories")
    public String getAllInventories(Model model) {
        List<InventoryModel> inventories = inventoryService.findAllInventories();
        List<ToyModel> toys = toyService.findAllToys();

        model.addAttribute("inventories", inventories);
        model.addAttribute("toys", toys);
        model.addAttribute("inventory", new InventoryModel());

        return "inventories";
    }

    @PostMapping("/inventories")
    public String addInventory(@Valid @ModelAttribute InventoryModel inventory, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<InventoryModel> inventories = inventoryService.findAllInventories();
            List<ToyModel> toys = toyService.findAllToys();

            model.addAttribute("inventories", inventories);
            model.addAttribute("toys", toys);
            model.addAttribute("inventory", inventory);
            return "inventories";
        }
        inventoryService.createInventory(inventory);
        return "redirect:/inventories";
    }

    @GetMapping("/inventories/edit/{id}")
    public String editInventory(@PathVariable Long id, Model model) {
        InventoryModel inventory = inventoryService.findInventoryById(id);
        List<ToyModel> toys = toyService.findAllToys();

        model.addAttribute("inventory", inventory);
        model.addAttribute("toys", toys);

        return "editInventory";
    }

    @PostMapping("/inventories/update")
    public String updateInventory(@Valid @ModelAttribute InventoryModel inventory, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<InventoryModel> inventories = inventoryService.findAllInventories();
            List<ToyModel> toys = toyService.findAllToys();

            model.addAttribute("inventories", inventories);
            model.addAttribute("toys", toys);
            model.addAttribute("inventory", inventory);

            return "inventories";
        }
        inventoryService.updateInventory(inventory);
        return "redirect:/inventories";
    }

    @GetMapping("/inventories/delete/{id}")
    public String deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
        return "redirect:/inventories";
    }
}
