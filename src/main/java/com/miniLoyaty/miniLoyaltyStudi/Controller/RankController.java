package com.miniLoyaty.miniLoyaltyStudi.Controller;

import com.miniLoyaty.miniLoyaltyStudi.Dtos.ProductDto;
import com.miniLoyaty.miniLoyaltyStudi.Dtos.RankDto;
import com.miniLoyaty.miniLoyaltyStudi.Dtos.ResponseDataDto;
import com.miniLoyaty.miniLoyaltyStudi.Entity.Products;
import com.miniLoyaty.miniLoyaltyStudi.Entity.Rank;
import com.miniLoyaty.miniLoyaltyStudi.Service.ProductService;
import com.miniLoyaty.miniLoyaltyStudi.Service.RankService;
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
@RequestMapping("/api/rank")
public class RankController {
    @Autowired
    private RankService rankService;


    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/rank")
    public ResponseEntity<ResponseDataDto<Rank>> create(@Valid @RequestBody RankDto rankDto, Errors errors){
        ResponseDataDto<Rank> responseDataDto = new ResponseDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseDataDto.getMessages().add(error.getDefaultMessage());
            }
            responseDataDto.setStatus(false);
            responseDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDataDto);
        }

        Rank rank = modelMapper.map(rankDto, Rank.class);

        responseDataDto.setStatus(true);
        responseDataDto.setPayload(rankService.save(rank));
        return ResponseEntity.ok(responseDataDto);
    }

    @GetMapping
    public List<Rank> findAll(){
        return rankService.findAll();
    }

    @GetMapping("/{id}")
    public Rank findOne(@PathVariable("id") Long idRank){
        return rankService.findOne(idRank);
    }

    @PutMapping("/rank")
    public ResponseEntity<ResponseDataDto<Rank>> update(@Valid @RequestBody RankDto rankDto, Errors errors){
        ResponseDataDto<Rank> responseDataDto = new ResponseDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseDataDto.getMessages().add(error.getDefaultMessage());
            }
            responseDataDto.setStatus(false);
            responseDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDataDto);
        }

        Rank rank = modelMapper.map(rankDto, Rank.class);

        responseDataDto.setStatus(true);
        responseDataDto.setPayload(rankService.save(rank));
        return ResponseEntity.ok(responseDataDto);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id")Long idRank){
        rankService.removeOne(idRank);
    }
}

