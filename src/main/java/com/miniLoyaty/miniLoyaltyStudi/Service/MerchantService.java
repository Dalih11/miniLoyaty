package com.miniLoyaty.miniLoyaltyStudi.Service;

import com.miniLoyaty.miniLoyaltyStudi.Entity.Benefit;
import com.miniLoyaty.miniLoyaltyStudi.Entity.Merchant;
import com.miniLoyaty.miniLoyaltyStudi.Repository.BenefitRepository;
import com.miniLoyaty.miniLoyaltyStudi.Repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MerchantService {
    @Autowired
    private MerchantRepository merchantRepository;

    public Merchant save(Merchant merchant){
        return merchantRepository.save(merchant);
    }

    public Merchant findOne(Long idMerchant){
        Optional<Merchant> merchant = merchantRepository.findById(idMerchant);
        if(!merchant.isPresent()){
            return null;
        }
        return merchant.get();
//       return userRepository.findById(idUser).get();
    }

    public List<Merchant> findAll(){
        return merchantRepository.findAll();
    }

    public void removeOne(Long idMerchant){
        merchantRepository.deleteById(idMerchant);
    }
}
