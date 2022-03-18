package com.erp.product.service;

import java.util.List;

import com.erp.product.entity.Product;
import com.erp.product_type.entity.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.product.exception.ProductException;
import com.erp.product.repository.ProductRepository;
import com.erp.product_type.service.ProductTypeService;

@Service
public class ProdutcService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductTypeService productTypeService;
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Product findById(Long idDrink) {
		return productRepository.findById(idDrink).orElseThrow(ProductException::new);
	}
	
	public List<Product> findByName (String name){
		return productRepository.findByNameContainingIgnoreCase(name);
	}
	
	public List<Product> findByDrinkType (Long idDrinkType){
		ProductType productType = productTypeService.findById(idDrinkType);
		return productRepository.findProductByProductType(productType);
	}
	
/*	public Product save (ProductDTO productDTO) {
		Product product = productDTO.mappDrinkDTO(productDTO);
		ProductType productType = drinkTypeService.findById(productDTO.getIdDrinkType());
		product.setProductType(productType);
		return productRepository.save(product);
	}*/
	
	public Product delete (Long idDrink) {
		Product product = findById(idDrink);
		//TODO tratar erro
		productRepository.deleteById(idDrink);
		return product;
	}
}
