package com.miniLoyaty.miniLoyaltyStudi.Service;

import com.miniLoyaty.miniLoyaltyStudi.Entity.Benefit;
import com.miniLoyaty.miniLoyaltyStudi.Entity.User;
import com.miniLoyaty.miniLoyaltyStudi.Repository.BenefitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BenefitService {
    @Autowired
    private BenefitRepository benefitRepository;

    public Benefit save(Benefit benefit){
        return benefitRepository.save(benefit);
    }

    public Benefit findOne(Long idBenefit){
        Optional<Benefit> benefit = benefitRepository.findById(idBenefit);
        if(!benefit.isPresent()){
            return null;
        }
        return benefit.get();
//       return userRepository.findById(idUser).get();
    }

    public List<Benefit> findAll(){
        return benefitRepository.findAll();
    }

    public void removeOne(Long idBenefit){
        benefitRepository.deleteById(idBenefit);
    }
}
