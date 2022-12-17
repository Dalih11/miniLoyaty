package com.miniLoyaty.miniLoyaltyStudi.Controller;

import com.miniLoyaty.miniLoyaltyStudi.Dtos.ResponseDataDto;
import com.miniLoyaty.miniLoyaltyStudi.Dtos.UserDto;
import com.miniLoyaty.miniLoyaltyStudi.Dtos.VoucherDto;
import com.miniLoyaty.miniLoyaltyStudi.Entity.User;
import com.miniLoyaty.miniLoyaltyStudi.Entity.Voucher;
import com.miniLoyaty.miniLoyaltyStudi.Service.VoucherService;
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
@RequestMapping("/api/voucher")
public class VoucherController {
    @Autowired
    private VoucherService voucherService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/voucher")
    public ResponseEntity<ResponseDataDto<Voucher>> create(@Valid @RequestBody VoucherDto voucherDto, Errors errors){
        ResponseDataDto<Voucher> responseDataDto = new ResponseDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseDataDto.getMessages().add(error.getDefaultMessage());
            }
            responseDataDto.setStatus(false);
            responseDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDataDto);
        }

        Voucher voucher = modelMapper.map(voucherDto, Voucher.class);

        responseDataDto.setStatus(true);
        responseDataDto.setPayload(voucherService.save(voucher));
        return ResponseEntity.ok(responseDataDto);
    }

    @GetMapping
    public List<Voucher> findAll(){
        return voucherService.findAll();
    }

    @GetMapping("/{id}")
    public Voucher findOne(@PathVariable("id") Long idVoucher){
        return voucherService.findOne(idVoucher);
    }

    @PutMapping("/voucher")
    public ResponseEntity<ResponseDataDto<Voucher>> update(@Valid @RequestBody VoucherDto voucherDto, Errors errors){
        ResponseDataDto<Voucher> responseDataDto = new ResponseDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseDataDto.getMessages().add(error.getDefaultMessage());
            }
            responseDataDto.setStatus(false);
            responseDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDataDto);
        }

        Voucher voucher = modelMapper.map(voucherDto, Voucher.class);

        responseDataDto.setStatus(true);
        responseDataDto.setPayload(voucherService.save(voucher));
        return ResponseEntity.ok(responseDataDto);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id")Long idVoucher){
        voucherService.removeOne(idVoucher);
    }
}
