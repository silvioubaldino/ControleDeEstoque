package com.ControleDeEstoque.inventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ControleDeEstoque.model.entity.inventory.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
