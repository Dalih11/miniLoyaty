package com.miniLoyaty.miniLoyaltyStudi.Dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class OrderCartDto {
    private Long idProduct;
    private Long idUser;
    private Long qty;
    private Long status;
}
