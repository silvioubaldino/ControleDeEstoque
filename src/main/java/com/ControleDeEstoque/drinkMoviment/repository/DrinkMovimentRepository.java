package com.ControleDeEstoque.drinkMoviment.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ControleDeEstoque.drinkMoviment.ennumerator.MovimentType;
import com.ControleDeEstoque.model.entity.drink.Drink;
import com.ControleDeEstoque.model.entity.drink_moviment.DrinkMoviment;
import com.ControleDeEstoque.model.entity.section.Section;

public interface DrinkMovimentRepository extends JpaRepository<DrinkMoviment, Long> {

	List<DrinkMoviment> findAll(Sort sort);
	
	List<DrinkMoviment> findByDrinkIdDrink(Long idDrink);

	List<DrinkMoviment> findByDrinkTypeIdDrinkType(Long idDrinkType);

	List<DrinkMoviment> findByMovimentType(MovimentType movimentType);
		
	List<DrinkMoviment> findBySectionIdSection(Long idSection);
	
}
