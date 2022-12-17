package com.miniLoyaty.miniLoyaltyStudi.Entity;

import com.miniLoyaty.miniLoyaltyStudi.Model.Status;
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
@Table(name ="OrderCart")
public class OrderCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOrderCart;
    private Long idUser;
    private Long idProducts;
    private Long idTransaksi;
    private Status status;
    private Long qty;

}
