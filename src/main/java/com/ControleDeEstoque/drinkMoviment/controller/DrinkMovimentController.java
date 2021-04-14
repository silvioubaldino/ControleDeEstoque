package com.ControleDeEstoque.drinkMoviment.controller;

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

import com.ControleDeEstoque.drinkMoviment.DTO.DrinkMovimentDTO;
import com.ControleDeEstoque.drinkMoviment.service.DrinkMovimentService;
import com.ControleDeEstoque.model.entity.drink_moviment.DrinkMoviment;
import com.ControleDeEstoque.model.entity.drink_type.DrinkType;
import com.google.gson.Gson;

@Controller
@RequestMapping("/drinkMoviment")
public class DrinkMovimentController {

	@Autowired
	DrinkMovimentService drinkMovimentService;

	@GetMapping
	public ResponseEntity<String> findAll() {
		String json = new Gson().toJson(drinkMovimentService.findAll());
		return ResponseEntity.status(HttpStatus.OK).body(json);
	}

	@GetMapping("/{idMov}")
	public ResponseEntity<String> findById(@PathVariable Long idMov) {
		try {
			String json = new Gson().toJson(drinkMovimentService.findById(idMov));
			return ResponseEntity.status(HttpStatus.OK).body(json);			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movimentação não cadastrada. (" + e.getMessage() + ")");
		}
	}

	@GetMapping("/drink/{idDrink}")
	public ResponseEntity<String> findByDrink(@PathVariable Long idDrink) {
		try {
			String json = new Gson().toJson(drinkMovimentService.findByInventory(idDrink));
			return ResponseEntity.status(HttpStatus.OK).body(json);			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bebida não cadastrada. (" + e.getMessage() + ")");
		}
	}

	@GetMapping("/section/{idSection}")
	public ResponseEntity<String> findBySection(@PathVariable Long idSection) {
		try {
			String json = new Gson().toJson(drinkMovimentService.findBySection(idSection));
			return ResponseEntity.status(HttpStatus.OK).body(json);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Seção não cadastrada. (" + e.getMessage() + ")");
		}
	}

	@GetMapping("/drinkType/{idDrinkType}")
	public ResponseEntity<String> findByDrinkType(@PathVariable Long idDrinkType) {
		try {
			String json = new Gson().toJson(drinkMovimentService.findByDrinkType(idDrinkType));
			return ResponseEntity.status(HttpStatus.OK).body(json);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de bebida não cadastrado. ("+ e.getMessage() + ")");
		}
	}

	@GetMapping("/sectionsToInsert/{drinkType}/{volumeMov}")
	public ResponseEntity<String> findSectionsToInsert(@PathVariable DrinkType drinkType, @PathVariable Double volumeMov){
		try {
			String json = new Gson().toJson(drinkMovimentService.findSectionsToInsert(drinkType, volumeMov));
			return ResponseEntity.status(HttpStatus.OK).body(json);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@GetMapping("/sectionsToRemove/{drinkType}/{volumeMov}")
	public ResponseEntity<String> findSectionsToRemove(@PathVariable DrinkType drinkType, @PathVariable Double volumeMov){
		try {
			String json = new Gson().toJson(drinkMovimentService.findSectionsToRemove(drinkType, volumeMov));
			return ResponseEntity.status(HttpStatus.OK).body(json);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody DrinkMovimentDTO drinkMovimentDTO) throws Exception {
		try {
			DrinkMoviment savedDrinkMoviment = drinkMovimentService.validDrinkMoviment(drinkMovimentDTO);
			String json = new Gson().toJson(savedDrinkMoviment);
			return ResponseEntity.status(HttpStatus.CREATED).body(json);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteById (@RequestBody DrinkMovimentDTO drinkMovimentDTO) throws Exception{
		try {
			drinkMovimentService.deleteByDrink(drinkMovimentDTO);
			return ResponseEntity.status(HttpStatus.OK).body("Retirada realizada.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
