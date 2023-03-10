package com.miniLoyaty.miniLoyaltyStudi.Repository;

import com.miniLoyaty.miniLoyaltyStudi.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    List<Products> findByNameProductContains(String nameProduct);
}
