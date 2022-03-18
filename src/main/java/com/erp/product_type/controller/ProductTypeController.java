package com.erp.product_type.controller;

import java.util.List;

import com.erp.product_type.entity.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.product_type.exception.ProductTypeException;
import com.erp.product_type.service.ProductTypeService;

@RestController
@RequestMapping("/drinkType")
public class ProductTypeController {

	@Autowired
	ProductTypeService productTypeService;
	
	@GetMapping
	public List<ProductType> findAll() {
		List<ProductType> productTypeList = productTypeService.findAll();
		if (productTypeList.size() == 0) {
			throw new ProductTypeException();
		} else {
			return productTypeList;
		}
	}
	
	@GetMapping("/{idProductType}")
	public ProductType findById(@PathVariable Long idProductType){
		return productTypeService.findById(idProductType);
	}
	
	@GetMapping("/name/{productType}")
	public List<ProductType> findByName(@PathVariable String productType){
		List<ProductType> productTypeList = productTypeService.findByName(productType);
		if (productTypeList.size() == 0) {
			throw new ProductTypeException();
		} else {
			return productTypeList;
		}
	}
	
	@PostMapping
	public ProductType save (@RequestBody ProductType productType){
		return productTypeService.save(productType);
	}
	
	@DeleteMapping("/{idProductType}")
	public ProductType delete (@PathVariable Long idProductType) {
		return productTypeService.delete(idProductType);
	}
}
