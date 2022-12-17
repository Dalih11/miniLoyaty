package com.miniLoyaty.miniLoyaltyStudi.Controller;

import com.miniLoyaty.miniLoyaltyStudi.Dtos.ResponseDataDto;
import com.miniLoyaty.miniLoyaltyStudi.Entity.TransaksiVoucher;
import com.miniLoyaty.miniLoyaltyStudi.Service.TransaksiVoucherService;
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
@RequestMapping("/api/tv")
public class TransaksiVoucherContoller {
    @Autowired
    private TransaksiVoucherService transaksiVoucherService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/tv")
    public ResponseEntity<ResponseDataDto<TransaksiVoucher>> create(@Valid @RequestBody TransaksiVoucherContoller transaksiVoucherDto, Errors errors){
        ResponseDataDto<TransaksiVoucher> responseDataDto = new ResponseDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseDataDto.getMessages().add(error.getDefaultMessage());
            }
            responseDataDto.setStatus(false);
            responseDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDataDto);
        }

        TransaksiVoucher transaksiVoucher = modelMapper.map(transaksiVoucherDto, TransaksiVoucher.class);

        responseDataDto.setStatus(true);
        responseDataDto.setPayload(transaksiVoucherService.save(transaksiVoucher));
        return ResponseEntity.ok(responseDataDto);
    }

    @GetMapping
    public List<TransaksiVoucher> findAll(){
        return transaksiVoucherService.findAll();
    }

    @GetMapping("/{id}")
    public TransaksiVoucher findOne(@PathVariable("id") Long idtV){
        return transaksiVoucherService.findOne(idtV);
    }

    @PutMapping("/tv")
    public ResponseEntity<ResponseDataDto<TransaksiVoucher>> update(@Valid @RequestBody TransaksiVoucherContoller transaksiVoucherDto, Errors errors){
        ResponseDataDto<TransaksiVoucher> responseDataDto = new ResponseDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseDataDto.getMessages().add(error.getDefaultMessage());
            }
            responseDataDto.setStatus(false);
            responseDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDataDto);
        }

        TransaksiVoucher transaksiVoucher = modelMapper.map(transaksiVoucherDto, TransaksiVoucher.class);

        responseDataDto.setStatus(true);
        responseDataDto.setPayload(transaksiVoucherService.save(transaksiVoucher));
        return ResponseEntity.ok(responseDataDto);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id")Long idtV){
        transaksiVoucherService.removeOne(idtV);
    }

}
