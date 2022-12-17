package com.miniLoyaty.miniLoyaltyStudi.Dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class ResponseDataDto<T> {
    private boolean status;
    private List<String> messages = new ArrayList<>();
    private T payload;
}
