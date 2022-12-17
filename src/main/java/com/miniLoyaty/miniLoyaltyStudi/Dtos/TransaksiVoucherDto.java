package com.miniLoyaty.miniLoyaltyStudi.Dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TransaksiVoucherDto {
    private Long idtV;
    private Long idUser;
    private Long idVoucher;
}
