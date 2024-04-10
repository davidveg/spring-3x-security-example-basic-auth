package com.test.vega.code.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "PRICE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private BigDecimal priceValue;

}
