package com.miniLoyaty.miniLoyaltyStudi.Controller;

import com.miniLoyaty.miniLoyaltyStudi.Dtos.ProductDto;
import com.miniLoyaty.miniLoyaltyStudi.Dtos.ResponseDataDto;
import com.miniLoyaty.miniLoyaltyStudi.Entity.Products;
import com.miniLoyaty.miniLoyaltyStudi.Service.ProductService;
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
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/product")
    public ResponseEntity<ResponseDataDto<Products>> create(@Valid @RequestBody ProductDto productDto, Errors errors){
        ResponseDataDto<Products> responseDataDto = new ResponseDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseDataDto.getMessages().add(error.getDefaultMessage());
            }
            responseDataDto.setStatus(false);
            responseDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDataDto);
        }

        Products products = modelMapper.map(productDto, Products.class);

        responseDataDto.setStatus(true);
        responseDataDto.setPayload(productService.save(products));
        return ResponseEntity.ok(responseDataDto);
    }

    @GetMapping
    public List<Products> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Products findOne(@PathVariable("id") Long idProduct){
        return productService.findOne(idProduct);
    }

    @PutMapping("/product")
    public ResponseEntity<ResponseDataDto<Products>> update(@Valid @RequestBody ProductDto productDto, Errors errors){
        ResponseDataDto<Products> responseDataDto = new ResponseDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseDataDto.getMessages().add(error.getDefaultMessage());
            }
            responseDataDto.setStatus(false);
            responseDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDataDto);
        }

        Products products = modelMapper.map(productDto, Products.class);

        responseDataDto.setStatus(true);
        responseDataDto.setPayload(productService.save(products));
        return ResponseEntity.ok(responseDataDto);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id")Long idProduct){
        productService.removeOne(idProduct);
    }
}
