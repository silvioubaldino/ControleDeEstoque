package com.ControleDeEstoque.drink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ControleDeEstoque.drink.service.DrinkService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/drink")
public class DrinkController {

	@Autowired
	DrinkService drinkService;
	
	@GetMapping
	public ResponseEntity<String> findAll() {
	    String json = new Gson().toJson(drinkService.findAll());
	    
		return ResponseEntity.status(HttpStatus.OK).body(json);
	}
	
	@GetMapping("/{idDrink}")
	public ResponseEntity<String> findById(@PathVariable Long idDrink) {
	    String json = new Gson().toJson(drinkService.findById(idDrink));

	    return ResponseEntity.status(HttpStatus.OK).body(json);
	}
}
