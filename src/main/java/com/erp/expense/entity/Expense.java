package com.erp.expense.entity;

import com.erp.enums.PaymentOption;
import com.erp.product.entity.Product;
import com.erp.provider.entity.Provider;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Provider provider;

    @ManyToMany
    @JoinTable(name = "expense_request")
    private List<Product> products;

    @CreationTimestamp
    private LocalDateTime dateOrder;

    private LocalDateTime dateDelivery;

    @Enumerated
    private PaymentOption paymentOption;

    private String responsible;

}
