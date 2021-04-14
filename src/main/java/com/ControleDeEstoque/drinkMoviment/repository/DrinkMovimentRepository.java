package com.ControleDeEstoque.drinkMoviment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ControleDeEstoque.model.entity.drink.Drink;
import com.ControleDeEstoque.model.entity.drink_moviment.DrinkMoviment;
import com.ControleDeEstoque.model.entity.section.Section;

public interface DrinkMovimentRepository extends JpaRepository<DrinkMoviment, Long> {

	List<DrinkMoviment> findByDrink(Drink drink);

	DrinkMoviment findOneByDrink(Drink drink);
		
	List<DrinkMoviment> findBySection(Section section);
	
}
