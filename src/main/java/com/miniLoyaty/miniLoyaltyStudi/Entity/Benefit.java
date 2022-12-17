package com.miniLoyaty.miniLoyaltyStudi.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "benefit")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Benefit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBenefit;
    private Long idRank;
    private BigDecimal discount;
}
