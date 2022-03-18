package com.erp.product.entity;

import com.erp.enums.Color;
import com.erp.enums.Size;
import com.erp.product_type.entity.ProductType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "product_pk_productType", foreignKey = @ForeignKey(name = "product_pk_productType"))
	@NotNull
	private ProductType productType;

	@Column(unique = true)
	@NotNull
	private String name;

	private String code;

	@Enumerated
	private Color color;

	@Enumerated
	private Size size;
}
