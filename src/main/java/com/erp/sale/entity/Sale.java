package com.erp.sale.entity;

import com.erp.client.entity.Client;
import com.erp.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sale")
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany
	@JoinTable(name = "sale_request", foreignKey = @ForeignKey(name = "sale_fk_product"))
	private List<Product> products;

	@ManyToOne
	@JoinColumn(name = "sale_fk_client", foreignKey = @ForeignKey(name = "sale_fk_client"))
	private Client client;

	@CreationTimestamp
	private LocalDateTime purchaseDate;

	private String responsible; //TODO User;
}
