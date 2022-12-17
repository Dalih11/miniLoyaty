package com.miniLoyaty.miniLoyaltyStudi.Repository;

import com.miniLoyaty.miniLoyaltyStudi.Entity.Merchant;
import com.miniLoyaty.miniLoyaltyStudi.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
    List<Merchant> findByNameMerchantContains(String nameMerchant);
}
