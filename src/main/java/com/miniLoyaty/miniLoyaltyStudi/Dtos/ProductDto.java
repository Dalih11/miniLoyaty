package com.miniLoyaty.miniLoyaltyStudi.Dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ProductDto {
    @Column(nullable = false)
    private String nameProduct;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private String description;
}
