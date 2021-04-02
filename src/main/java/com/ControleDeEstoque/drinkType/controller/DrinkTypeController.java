package com.ControleDeEstoque.drinkType.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ControleDeEstoque.drinkType.service.DrinkTypeService;

@Controller
@RequestMapping("/drinkType")
public class DrinkTypeController {

	@Autowired
	DrinkTypeService drinkTypeService;
}
