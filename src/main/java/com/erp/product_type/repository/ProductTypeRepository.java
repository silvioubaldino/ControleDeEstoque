package com.erp.product_type.repository;

import java.util.List;

import com.erp.product_type.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long>{
	
	List<ProductType>findByProductTypeContainingIgnoreCase(String productType);
}
