package com.miniLoyaty.miniLoyaltyStudi.Controller;

import com.miniLoyaty.miniLoyaltyStudi.Dtos.MerchantDto;
import com.miniLoyaty.miniLoyaltyStudi.Dtos.ProductDto;
import com.miniLoyaty.miniLoyaltyStudi.Dtos.ResponseDataDto;
import com.miniLoyaty.miniLoyaltyStudi.Entity.Merchant;
import com.miniLoyaty.miniLoyaltyStudi.Entity.Products;
import com.miniLoyaty.miniLoyaltyStudi.Service.MerchantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/merchant")
public class MerchantController {
    @Autowired
    private MerchantService merchantService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/product")
    public ResponseEntity<ResponseDataDto<Merchant>> create(@Valid @RequestBody MerchantDto merchantDto, Errors errors){
        ResponseDataDto<Merchant> responseDataDto = new ResponseDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseDataDto.getMessages().add(error.getDefaultMessage());
            }
            responseDataDto.setStatus(false);
            responseDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDataDto);
        }

        Merchant merchant = modelMapper.map(merchantDto, Merchant.class);

        responseDataDto.setStatus(true);
        responseDataDto.setPayload(merchantService.save(merchant));
        return ResponseEntity.ok(responseDataDto);
    }

    @GetMapping
    public List<Merchant> findAll(){
        return merchantService.findAll();
    }

    @GetMapping("/{id}")
    public Merchant findOne(@PathVariable("id") Long idMerchant){
        return merchantService.findOne(idMerchant);
    }

    @PutMapping("/merchant")
    public ResponseEntity<ResponseDataDto<Merchant>> update(@Valid @RequestBody MerchantDto merchantDto, Errors errors){
        ResponseDataDto<Merchant> responseDataDto = new ResponseDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseDataDto.getMessages().add(error.getDefaultMessage());
            }
            responseDataDto.setStatus(false);
            responseDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDataDto);
        }

        Merchant merchant = modelMapper.map(merchantDto, Merchant.class);

        responseDataDto.setStatus(true);
        responseDataDto.setPayload(merchantService.save(merchant));
        return ResponseEntity.ok(responseDataDto);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id")Long idMerchant){
        merchantService.removeOne(idMerchant);
    }

}
