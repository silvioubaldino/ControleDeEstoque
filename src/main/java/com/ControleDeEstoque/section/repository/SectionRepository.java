package com.ControleDeEstoque.section.repository;

import com.ControleDeEstoque.model.entity.inventory.Inventory;
import com.ControleDeEstoque.model.entity.section.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectionRepository extends JpaRepository<Section, Long>{

	List<Section> findSectionByInventory(Inventory inventory);

	List<Section> findSectionByDrinkTypeIdDrinkType(Long idDrinkType);
}
