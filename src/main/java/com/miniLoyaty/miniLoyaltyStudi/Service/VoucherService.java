package com.miniLoyaty.miniLoyaltyStudi.Service;

import com.miniLoyaty.miniLoyaltyStudi.Entity.Products;
import com.miniLoyaty.miniLoyaltyStudi.Entity.Voucher;
import com.miniLoyaty.miniLoyaltyStudi.Repository.ProductRepository;
import com.miniLoyaty.miniLoyaltyStudi.Repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;

    public Voucher save(Voucher voucher){
        return voucherRepository.save(voucher);
    }

    public Voucher findOne(Long idVoucher){
        Optional<Voucher> voucher = voucherRepository.findById(idVoucher);
        if(!voucher.isPresent()){
            return null;
        }
        return voucher.get();
//       return userRepository.findById(idUser).get();
    }

    public List<Voucher> findAll(){
        return voucherRepository.findAll();
    }

    public void removeOne(Long idVoucher){
        voucherRepository.deleteById(idVoucher);
    }
}
