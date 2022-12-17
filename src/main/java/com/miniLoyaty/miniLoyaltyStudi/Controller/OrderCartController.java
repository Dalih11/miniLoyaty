package com.miniLoyaty.miniLoyaltyStudi.Controller;

import com.miniLoyaty.miniLoyaltyStudi.Dtos.OrderCartDto;
import com.miniLoyaty.miniLoyaltyStudi.Dtos.ResponseDataDto;
import com.miniLoyaty.miniLoyaltyStudi.Entity.OrderCart;
import com.miniLoyaty.miniLoyaltyStudi.Service.OrderCartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public class OrderCartController {
    @Autowired
    private OrderCartService orderCartService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/ordercart")
    public ResponseEntity<ResponseDataDto<OrderCart>> update(@Valid @RequestBody OrderCartDto orderCartDto, Errors errors){
        ResponseDataDto<OrderCart> responseDataDto = new ResponseDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseDataDto.getMessages().add(error.getDefaultMessage());
            }
            responseDataDto.setStatus(false);
            responseDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDataDto);
        }

        OrderCart orderCart = modelMapper.map(orderCartDto, OrderCart.class);

        responseDataDto.setStatus(true);
        responseDataDto.setPayload(orderCartService.save(orderCart));
        return ResponseEntity.ok(responseDataDto);
    }

    @GetMapping
    public List<OrderCart> findAll() {
        return orderCartService.findAll();
    }

    @GetMapping("/{id}")
    public OrderCart findOne(@PathVariable("id") Long idOrderCart) {
        return orderCartService.findOne(idOrderCart);
    }
}
