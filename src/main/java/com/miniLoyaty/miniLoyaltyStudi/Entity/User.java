package com.miniLoyaty.miniLoyaltyStudi.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private Long rankId;
    private BigDecimal points;
    private String nameUser;
    @Column(nullable = false)
    private String phone;
    @Email(message = "format email tidak sesuai")
    private String email;
    @Column(nullable = false)
    private String password;
}
