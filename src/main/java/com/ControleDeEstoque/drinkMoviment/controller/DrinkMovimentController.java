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

	@GetMapping("/findAllOrderBy/{params}")
	public List<DrinkMoviment> findAll(@PathVariable(required = false) String params) {
		List<DrinkMoviment> drinkMovimentList = drinkMovimentService.findAll(params);
		if(drinkMovimentList.isEmpty()) {
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
		if(drinkMovimentList.isEmpty()) {
			throw new DrinkMovimentException();
		}
		return drinkMovimentList;
	}

	@GetMapping("/section/{idSection}")
	public List<DrinkMoviment> findBySection(@PathVariable Long idSection) {
		List<DrinkMoviment> drinkMovimentList = drinkMovimentService.findBySection(idSection);
		if(drinkMovimentList.isEmpty()) {
			throw new DrinkMovimentException();
		}
		return drinkMovimentList;
	}

	@GetMapping("/drinkType/{idDrinkType}")
	public List<DrinkMoviment> findByDrinkType(@PathVariable Long idDrinkType) {
		List<DrinkMoviment> drinkMovimentList = drinkMovimentService.findByDrinkType(idDrinkType);
		if(drinkMovimentList.isEmpty()) {
			throw new DrinkMovimentException();
		}
		return drinkMovimentList;
	}
	
	@GetMapping("/movimentType/{movimentTypeString}")
	public List<DrinkMoviment> findByMovimentType (@PathVariable String movimentTypeString){
		List<DrinkMoviment> drinkMovimentList = drinkMovimentService.findByMovimentType(movimentTypeString);
		if(drinkMovimentList.isEmpty()) {
			throw new DrinkMovimentException();
		}
		return drinkMovimentList;
	}
	
	@GetMapping("/totalVolByDrinkType/{idDrinkType}")
	public Double getTotalVolByDrinkType (@PathVariable Long idDrinkType) {
		return drinkMovimentService.getTotalVolByDrinkType(idDrinkType);
	}
	
	@PostMapping
	public DrinkMoviment save(@RequestBody DrinkMovimentDTO drinkMovimentDTO) {
		DrinkMoviment drinkMoviment = drinkMovimentService.validDrinkMoviment(drinkMovimentDTO);
		return drinkMovimentService.save(drinkMoviment);
	}
	
	@DeleteMapping
	public DrinkMoviment deleteById (@RequestBody DrinkMovimentDTO drinkMovimentDTO){
		return drinkMovimentService.removeByDrink(drinkMovimentDTO);
	}
}
