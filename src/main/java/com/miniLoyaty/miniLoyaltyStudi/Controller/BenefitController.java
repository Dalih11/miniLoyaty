package com.miniLoyaty.miniLoyaltyStudi.Controller;

import com.miniLoyaty.miniLoyaltyStudi.Dtos.BenefitDto;
import com.miniLoyaty.miniLoyaltyStudi.Dtos.ResponseDataDto;
import com.miniLoyaty.miniLoyaltyStudi.Entity.Benefit;
import com.miniLoyaty.miniLoyaltyStudi.Service.BenefitService;
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
@RequestMapping("/api/benefit")
public class BenefitController {
    @Autowired
    private BenefitService benefitService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/benefit")
    public ResponseEntity<ResponseDataDto<Benefit>> create(@Valid @RequestBody BenefitDto benefitDto, Errors errors){
        ResponseDataDto<Benefit> responseDataDto = new ResponseDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseDataDto.getMessages().add(error.getDefaultMessage());
            }
            responseDataDto.setStatus(false);
            responseDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDataDto);
        }

        Benefit benefit = modelMapper.map(benefitDto, Benefit.class);

        responseDataDto.setStatus(true);
        responseDataDto.setPayload(benefitService.save(benefit));
        return ResponseEntity.ok(responseDataDto);
    }

    @GetMapping
    public List<Benefit> findAll(){
        return benefitService.findAll();
    }

    @GetMapping("/{id}")
    public Benefit findOne(@PathVariable("id") Long idBenefit){
        return benefitService.findOne(idBenefit);
    }

    @PutMapping("/benefit")
    public ResponseEntity<ResponseDataDto<Benefit>> update(@Valid @RequestBody BenefitDto benefitDto, Errors errors){
        ResponseDataDto<Benefit> responseDataDto = new ResponseDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseDataDto.getMessages().add(error.getDefaultMessage());
            }
            responseDataDto.setStatus(false);
            responseDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDataDto);
        }

        Benefit benefit = modelMapper.map(benefitDto, Benefit.class);

        responseDataDto.setStatus(true);
        responseDataDto.setPayload(benefitService.save(benefit));
        return ResponseEntity.ok(responseDataDto);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id")Long idBenefit){
        benefitService.removeOne(idBenefit);
    }
}
