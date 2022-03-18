package com.erp.inventory_products.entity;

import com.erp.inventory.entity.Inventory;
import com.erp.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class InventoryProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@ManyToOne
	@JoinColumn(name = "inventoryProduct_fk_inventory", foreignKey = @ForeignKey(name = "inventoryProduct_fk_inventory"))
	private Inventory inventory;

	@ManyToOne
	@JoinColumn(name = "inventoryProduct_fk_product", foreignKey = @ForeignKey(name = "inventoryProduct_fk_product"))
	private Product product;

	private int amount;
}
