package com.platzi.pizza.persitence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pizza_order")
@Setter
@Getter
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;


    @Column(name = "id_customer", length = 15, nullable = false)
    private String idCustomer;

    @Column(columnDefinition = "DATETIME", nullable = false)
    private Date date;

    @Column(columnDefinition = "DECIMAL(6.2)", nullable = false)
    private Double total;

    @Column(columnDefinition = "CHAR(1)", nullable = false)
    private String method;

    @Column(name = "additional_notes", length = 200)
    private String additionalNotes;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer" , insertable = false, updatable = false)
    @JsonIgnore
    private CustomerEntity customer;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    @OrderBy("price ASC ")
    private List<OrderItemEntity> items;

}
