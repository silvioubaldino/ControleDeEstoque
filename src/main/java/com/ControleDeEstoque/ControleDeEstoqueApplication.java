package com.ControleDeEstoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ControleDeEstoque.drink.repository.DrinkRepository;
import com.ControleDeEstoque.drinkMoviment.repository.DrinkMovimentRepository;
import com.ControleDeEstoque.drinkType.repository.DrinkTypeRepository;
import com.ControleDeEstoque.inventory.Repository.InventoryRepository;
import com.ControleDeEstoque.model.entity.drink.Drink;
import com.ControleDeEstoque.model.entity.drink_moviment.DrinkMoviment;
import com.ControleDeEstoque.model.entity.drink_type.DrinkType;
import com.ControleDeEstoque.model.entity.inventory.Inventory;
import com.ControleDeEstoque.model.entity.section.Section;
import com.ControleDeEstoque.section.repository.SectionRepository;

@SpringBootApplication
public class ControleDeEstoqueApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(ControleDeEstoqueApplication.class, args);
	}
}
