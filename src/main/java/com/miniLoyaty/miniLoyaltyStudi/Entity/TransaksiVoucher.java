package com.miniLoyaty.miniLoyaltyStudi.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "transaksiVoucher")
public class TransaksiVoucher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idtV;
    private Long idUser;
    private Long idVoucher;
}

