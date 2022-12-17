package com.miniLoyaty.miniLoyaltyStudi.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "transkasi")
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTransaksi;
    private Long idUser;
    private BigDecimal jumlah;
    private Long totalTransaksi;
    private BigDecimal point;
}
