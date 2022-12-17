package com.miniLoyaty.miniLoyaltyStudi.Repository;

import com.miniLoyaty.miniLoyaltyStudi.Entity.Products;
import com.miniLoyaty.miniLoyaltyStudi.Entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {
    List<Voucher> findByNameVoucherContains(String nameVoucher);
}
