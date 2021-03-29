package com.ControleDeEstoque.drinkMoviment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ControleDeEstoque.model.entity.drink_moviment.DrinkMoviment;

public interface DrinkMovimentRepository extends JpaRepository<DrinkMoviment, Long> {

}
