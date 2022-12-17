package com.miniLoyaty.miniLoyaltyStudi.Dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserDto {
    private String nameUser;
    private BigDecimal points;
    @Column(nullable = false)
    private String phone;
    @Email(message = "format email tidak sesuai")
    private String email;
    @Column(nullable = false)
    private String password;
}
