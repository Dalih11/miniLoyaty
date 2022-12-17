package com.miniLoyaty.miniLoyaltyStudi.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "voucher")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVoucher;
    private Long idMerchant;
    private Long idRank;
    private String nameVoucher;
    private BigDecimal voucherPoint;
}
