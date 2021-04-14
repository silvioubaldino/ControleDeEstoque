package com.ControleDeEstoque.drinkType.controller;

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

import com.ControleDeEstoque.drinkType.service.DrinkTypeService;
import com.ControleDeEstoque.model.entity.drink_type.DrinkType;
import com.google.gson.Gson;

@Controller
@RequestMapping("/drinkType")
public class DrinkTypeController {

	@Autowired
	DrinkTypeService drinkTypeService;
	
	@GetMapping
	public ResponseEntity<String> findAll() {
	    String json = new Gson().toJson(drinkTypeService.findAll());	    
		return ResponseEntity.status(HttpStatus.OK).body(json);
	}
	
	@GetMapping("/{idDrinkType}")
	public ResponseEntity<String> findById(@PathVariable Long idDrinkType){
		String json = new Gson().toJson(drinkTypeService.findById(idDrinkType));
		
		return ResponseEntity.status(HttpStatus.OK).body(json);
	}
	
	@GetMapping("/name/{drinkType}")
	public ResponseEntity<String> findByName(@PathVariable String drinkType){
		String json = new Gson().toJson(drinkTypeService.findByName(drinkType));
		
		return ResponseEntity.status(HttpStatus.OK).body(json);
	}
	
	@PostMapping
	public ResponseEntity<DrinkType> save (@RequestBody DrinkType drinkType){
		return ResponseEntity.status(HttpStatus.OK).body(drinkTypeService.save(drinkType));
	}
	
	@DeleteMapping("/{idDrinkType}")
	public ResponseEntity<DrinkType> delete (@PathVariable Long idDrinkType) {
		return ResponseEntity.status(HttpStatus.OK).body(drinkTypeService.delete(idDrinkType));
	}
}
