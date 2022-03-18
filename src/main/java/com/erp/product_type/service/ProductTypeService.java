package com.erp.product_type.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.product_type.exception.ProductTypeException;
import com.erp.product_type.repository.ProductTypeRepository;
import com.erp.product_type.entity.ProductType;

@Service
public class ProductTypeService {

	@Autowired
	ProductTypeRepository productTypeRepository;
	
	public List<ProductType> findAll(){
		return productTypeRepository.findAll();
	}
	
	public ProductType findById(Long id) {
		return productTypeRepository.findById(id).orElseThrow(ProductTypeException::new);
	}
	
	public List<ProductType> findByName (String productType) {
		return productTypeRepository.findByProductTypeContainingIgnoreCase(productType);
	}
	
	public ProductType save (ProductType productType) {
		return productTypeRepository.save(productType);
	}
	
	public ProductType delete (Long id) {
		ProductType productType = findById(id);
		productTypeRepository.delete(findById(id));
		return productType;
	}
}
