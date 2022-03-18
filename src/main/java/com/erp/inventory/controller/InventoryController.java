package com.erp.inventory.controller;

import com.erp.inventory.DTO.InventoryDTO;
import com.erp.inventory.entity.Inventory;
import com.erp.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<Inventory> findAll() {
        return inventoryService.findAll();
    }

    @PostMapping
    public Inventory save(@RequestBody InventoryDTO inventoryDTO) {
        return inventoryService.save(inventoryDTO);
    }
}
