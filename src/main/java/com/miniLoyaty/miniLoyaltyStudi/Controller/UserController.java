package com.miniLoyaty.miniLoyaltyStudi.Controller;

import com.miniLoyaty.miniLoyaltyStudi.Dtos.ResponseDataDto;
import com.miniLoyaty.miniLoyaltyStudi.Dtos.UserDto;
import com.miniLoyaty.miniLoyaltyStudi.Entity.User;
import com.miniLoyaty.miniLoyaltyStudi.Service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/user")
    public ResponseEntity<ResponseDataDto<User>> create(@Valid @RequestBody UserDto userDto, Errors errors){
        ResponseDataDto<User> responseDataDto = new ResponseDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseDataDto.getMessages().add(error.getDefaultMessage());
            }
            responseDataDto.setStatus(false);
            responseDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDataDto);
        }

        User user = modelMapper.map(userDto, User.class);

        responseDataDto.setStatus(true);
        responseDataDto.setPayload(userService.save(user));
        return ResponseEntity.ok(responseDataDto);
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable("id") Long idUser){
        return userService.findOne(idUser);
    }

    @PutMapping("/user")
    public ResponseEntity<ResponseDataDto<User>> update(@Valid @RequestBody UserDto userDto, Errors errors){
        ResponseDataDto<User> responseDataDto = new ResponseDataDto<>();
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                responseDataDto.getMessages().add(error.getDefaultMessage());
            }
            responseDataDto.setStatus(false);
            responseDataDto.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDataDto);
        }

        User user = modelMapper.map(userDto, User.class);

        responseDataDto.setStatus(true);
        responseDataDto.setPayload(userService.save(user));
        return ResponseEntity.ok(responseDataDto);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id")Long idUser){
        userService.removeOne(idUser);
    }

}
