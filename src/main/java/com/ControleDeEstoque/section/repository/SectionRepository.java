package com.ControleDeEstoque.section.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ControleDeEstoque.model.entity.inventory.Inventory;
import com.ControleDeEstoque.model.entity.section.Section;

public interface SectionRepository extends JpaRepository<Section, Long>{

	List<Section> findSectionByInventory(Inventory inventory);
}
