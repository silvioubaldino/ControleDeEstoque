package com.erp.client.entity;

import com.erp.person.entity.Person;
import com.erp.sale.entity.Sale;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "client")
    private List<Sale> sales = new ArrayList<>();
}
