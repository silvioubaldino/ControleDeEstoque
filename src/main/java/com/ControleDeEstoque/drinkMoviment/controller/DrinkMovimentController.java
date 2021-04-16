package com.ControleDeEstoque.drinkMoviment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ControleDeEstoque.drinkMoviment.DTO.DrinkMovimentDTO;
import com.ControleDeEstoque.drinkMoviment.exception.DrinkMovimentException;
import com.ControleDeEstoque.drinkMoviment.service.DrinkMovimentService;
import com.ControleDeEstoque.model.entity.drink_moviment.DrinkMoviment;

@RestController
@RequestMapping("/drinkMoviment")
public class DrinkMovimentController {

	@Autowired
	DrinkMovimentService drinkMovimentService;

	@GetMapping
	public List<DrinkMoviment> findAll() {
		List<DrinkMoviment> drinkMovimentList = drinkMovimentService.findAll();
		if(drinkMovimentList.size() == 0) {
			throw new DrinkMovimentException();
		}
		return drinkMovimentList;
	}

	@GetMapping("/{idMov}")
	public DrinkMoviment findById(@PathVariable Long idMov) {
		return drinkMovimentService.findById(idMov);
	}

	@GetMapping("/drink/{idDrink}")
	public List<DrinkMoviment> findByDrink(@PathVariable Long idDrink) {
		List<DrinkMoviment> drinkMovimentList = drinkMovimentService.findByDrink(idDrink);
		if(drinkMovimentList.size() == 0) {
			throw new DrinkMovimentException();
		}
		return drinkMovimentList;
	}

	@GetMapping("/section/{idSection}")
	public List<DrinkMoviment> findBySection(@PathVariable Long idSection) {
		List<DrinkMoviment> drinkMovimentList = drinkMovimentService.findBySection(idSection);
		if(drinkMovimentList.size() == 0) {
			throw new DrinkMovimentException();
		}
		return drinkMovimentList;
	}

	@GetMapping("/drinkType/{idDrinkType}")
	public List<DrinkMoviment> findByDrinkType(@PathVariable Long idDrinkType) {
		List<DrinkMoviment> drinkMovimentList = drinkMovimentService.findByDrinkType(idDrinkType);
		if(drinkMovimentList.size() == 0) {
			throw new DrinkMovimentException();
		}
		return drinkMovimentList;
	}
	
	@PostMapping
	public DrinkMoviment save(@RequestBody DrinkMovimentDTO drinkMovimentDTO) throws Exception {
		return drinkMovimentService.validDrinkMoviment(drinkMovimentDTO);
	}
	
	@DeleteMapping
	public DrinkMoviment deleteById (@RequestBody DrinkMovimentDTO drinkMovimentDTO) throws Exception{
		return drinkMovimentService.deleteByDrink(drinkMovimentDTO);
	}
}
