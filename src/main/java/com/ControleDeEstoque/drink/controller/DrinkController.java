package com.ControleDeEstoque.drink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ControleDeEstoque.drink.service.DrinkService;
import com.ControleDeEstoque.model.DTO.DrinkDTO;
import com.ControleDeEstoque.model.entity.drink.Drink;
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
	
	@GetMapping("/name/{drinkName}")
	public ResponseEntity<String> findByName (@PathVariable String drinkName){
		String json = new Gson().toJson(drinkService.findByName(drinkName));

	    return ResponseEntity.status(HttpStatus.OK).body(json);
	}
	
	@GetMapping("/drinkType/{idDrinkType}")
	public ResponseEntity<String> findByDrinkType (@PathVariable Long idDrinkType){
		String json = new Gson().toJson(drinkService.findByDrinkType(idDrinkType));
		
		return ResponseEntity.status(HttpStatus.OK).body(json);
	}
	
	@PostMapping
	public ResponseEntity<Drink> saveDrink (@RequestBody DrinkDTO drinkDTO){
		Drink savedDrink = drinkService.saveDrink(drinkDTO); 
		if (savedDrink != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(savedDrink);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(savedDrink);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseEntity<String>> deleteDrink (@PathVariable Long id) {
		drinkService.deleteDrink(id);
		return ResponseEntity.status(HttpStatus.OK).body(findById(id));
	}
}
