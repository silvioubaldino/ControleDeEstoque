package com.ControleDeEstoque.drink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ControleDeEstoque.model.entity.drink.Drink;

public interface DrinkRepository extends JpaRepository<Drink, Long> {

}
