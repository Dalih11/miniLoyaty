package com.miniLoyaty.miniLoyaltyStudi.Controller;


import com.miniLoyaty.miniLoyaltyStudi.Dtos.ResponseDataDto;
import com.miniLoyaty.miniLoyaltyStudi.Dtos.TransaksiDto;
import com.miniLoyaty.miniLoyaltyStudi.Entity.Transaksi;
import com.miniLoyaty.miniLoyaltyStudi.Service.TranskasiService;
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
@RequestMapping("/api/transaksi")
public class TranskasiController {
    @Autowired
    private TranskasiService transkasiService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/transaksi")
    public ResponseEntity<ResponseDataDto<Transaksi>> create(@Valid @RequestBody TransaksiDto transaksiDto, Errors errors){
        ResponseDataDto<Transaksi> responseDataDto = new ResponseDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseDataDto.getMessages().add(error.getDefaultMessage());
            }
            responseDataDto.setStatus(false);
            responseDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDataDto);
        }

        Transaksi transaksi = modelMapper.map(transaksiDto, Transaksi.class);

        responseDataDto.setStatus(true);
        responseDataDto.setPayload(transkasiService.save(transaksi));
        return ResponseEntity.ok(responseDataDto);
    }

    @GetMapping
    public List<Transaksi> findAll(){
        return transkasiService.findAll();
    }

    @GetMapping("/{id}")
    public Transaksi findOne(@PathVariable("id") Long idTransaksi){
        return transkasiService.findOne(idTransaksi);
    }

    @PutMapping("/transaksi")
    public ResponseEntity<ResponseDataDto<Transaksi>> update(@Valid @RequestBody TransaksiDto transaksiDto, Errors errors){
        ResponseDataDto<Transaksi> responseDataDto = new ResponseDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseDataDto.getMessages().add(error.getDefaultMessage());
            }
            responseDataDto.setStatus(false);
            responseDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDataDto);
        }

        Transaksi transaksi = modelMapper.map(transaksiDto, Transaksi.class);

        responseDataDto.setStatus(true);
        responseDataDto.setPayload(transkasiService.save(transaksi));
        return ResponseEntity.ok(responseDataDto);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id")Long idTransaksi){
        transkasiService.removeOne(idTransaksi);
    }

}
