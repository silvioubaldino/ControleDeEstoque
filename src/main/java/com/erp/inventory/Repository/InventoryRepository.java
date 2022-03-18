package com.erp.inventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.inventory.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
