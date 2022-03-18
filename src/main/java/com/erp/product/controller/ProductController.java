package com.erp.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.product.exception.ProductException;
import com.erp.product.service.ProdutcService;
import com.erp.product.entity.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProdutcService produtcService;

	@GetMapping
	public List<Product> findAll() {
		List<Product> productList = produtcService.findAll();
		if (productList.size() == 0) {
			throw new ProductException();
		} else {
			return productList;
		}
	}

	@GetMapping("/{idProduct}")
	public Product findById(@PathVariable Long idProduct) {
		return produtcService.findById(idProduct);
	}

	@GetMapping("/name/{ProductName}")
	public List<Product> findByName(@PathVariable String ProductName) {
		List<Product> productList = produtcService.findByName(ProductName);
		if (productList.size() == 0) {
			throw new ProductException();
		} else {
			return productList;
		}
	}

	@GetMapping("/productType/{idProductType}")
	public List<Product> findByDrinkType(@PathVariable Long idProductType) {
		List<Product> productList = produtcService.findByDrinkType(idProductType);
		if (productList.size() == 0) {
			throw new ProductException();
		} else {
			return productList;
		}
	}

/*	@PostMapping
	public Product save(@RequestBody ProductDTO productDTO) {
		return produtcService.save(productDTO);
	}*/

	@DeleteMapping("/{idProduct}")
	public Product delete(@PathVariable Long idProduct) {
		return produtcService.delete(idProduct);
	}
}
