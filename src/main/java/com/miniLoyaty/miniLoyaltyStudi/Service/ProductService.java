package com.miniLoyaty.miniLoyaltyStudi.Service;

import com.miniLoyaty.miniLoyaltyStudi.Entity.Products;
import com.miniLoyaty.miniLoyaltyStudi.Entity.User;
import com.miniLoyaty.miniLoyaltyStudi.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Products save(Products products){
        return productRepository.save(products);
    }

    public Products findOne(Long idProduct){
        Optional<Products> products = productRepository.findById(idProduct);
        if(!products.isPresent()){
            return null;
        }
        return products.get();
//       return userRepository.findById(idUser).get();
    }

    public List<Products> findAll(){
        return productRepository.findAll();
    }

    public void removeOne(Long idProduct){
        productRepository.deleteById(idProduct);
    }

    public Products ubahGambar(Long idProduct, String gambar){
        Products products = findOne(idProduct);
        products.setGambar(gambar);
        return productRepository.save(products);
    }
}
