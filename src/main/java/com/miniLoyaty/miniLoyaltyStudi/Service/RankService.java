package com.miniLoyaty.miniLoyaltyStudi.Service;

import com.miniLoyaty.miniLoyaltyStudi.Entity.Products;
import com.miniLoyaty.miniLoyaltyStudi.Entity.Rank;
import com.miniLoyaty.miniLoyaltyStudi.Repository.ProductRepository;
import com.miniLoyaty.miniLoyaltyStudi.Repository.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RankService {
    @Autowired
    private RankRepository rankRepository;

    public Rank save(Rank rank){
        return rankRepository.save(rank);
    }

    public Rank findOne(Long idRank){
        Optional<Rank> rank = rankRepository.findById(idRank);
        if(!rank.isPresent()){
            return null;
        }
        return rank.get();
//       return userRepository.findById(idUser).get();
    }

    public List<Rank> findAll(){
        return rankRepository.findAll();
    }

    public void removeOne(Long idRank){
        rankRepository.deleteById(idRank);
    }
}
