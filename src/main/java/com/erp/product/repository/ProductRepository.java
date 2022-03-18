package com.erp.product.repository;

import java.util.List;

import com.erp.product.entity.Product;
import com.erp.product_type.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByNameContainingIgnoreCase(String name);
	
	List<Product> findProductByProductType(ProductType productType);
	
}
