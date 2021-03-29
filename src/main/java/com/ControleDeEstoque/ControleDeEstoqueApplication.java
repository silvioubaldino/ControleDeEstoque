package com.ControleDeEstoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ControleDeEstoque.drink.repository.DrinkRepository;
import com.ControleDeEstoque.drinkType.repository.DrinkTypeRepository;
import com.ControleDeEstoque.inventory.Repository.InventoryRepository;
import com.ControleDeEstoque.model.entity.drink.Drink;
import com.ControleDeEstoque.model.entity.drink_type.DrinkType;
import com.ControleDeEstoque.model.entity.inventory.Inventory;
import com.ControleDeEstoque.model.entity.section.Section;
import com.ControleDeEstoque.section.repository.SectionRepository;

@SpringBootApplication
public class ControleDeEstoqueApplication implements CommandLineRunner{

	@Autowired
	InventoryRepository inventoryRepository;
	@Autowired
	SectionRepository sectionRepository;
	@Autowired
	DrinkTypeRepository drinkTypeRepository;
	@Autowired
	DrinkRepository drinkRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ControleDeEstoqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Inventory inventory = new Inventory("Estoque de Bebidas");
		inventoryRepository.save(inventory);	
		
		DrinkType drinkType1 = new DrinkType("Alcoolica");
		DrinkType drinkType2 = new DrinkType("Nao alcoolica");
		
		drinkTypeRepository.save(drinkType1);
		drinkTypeRepository.save(drinkType2);
				
		Section section1 = new Section(inventory, null, 400, 0);
		Section section2 = new Section(inventory, null, 400, 0);
		Section section3 = new Section(inventory, null, 400, 0);
		Section section4 = new Section(inventory, null, 400, 0);
		Section section5 = new Section(inventory, null, 400, 0);
		
		sectionRepository.save(section1);
		sectionRepository.save(section2);
		sectionRepository.save(section3);
		sectionRepository.save(section4);
		sectionRepository.save(section5);
		
		Drink drink1 = new Drink(drinkType1, "Vodka", 0.800);
		Drink drink2 = new Drink(drinkType1, "Rum", 0.800);
		Drink drink3 = new Drink(drinkType2, "Toddynho", 0.200);
		
		drinkRepository.save(drink1);
		drinkRepository.save(drink2);
		drinkRepository.save(drink3);
		
	}

}
