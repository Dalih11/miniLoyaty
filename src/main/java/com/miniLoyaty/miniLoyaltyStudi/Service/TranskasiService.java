package com.miniLoyaty.miniLoyaltyStudi.Service;

import com.miniLoyaty.miniLoyaltyStudi.Entity.Products;
import com.miniLoyaty.miniLoyaltyStudi.Entity.Transaksi;
import com.miniLoyaty.miniLoyaltyStudi.Repository.TransaksiRepository;
import com.miniLoyaty.miniLoyaltyStudi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TranskasiService {
    @Autowired
    private TransaksiRepository transaksiRepository;

    @Autowired
    private UserRepository userRepository;

    public Transaksi save(Transaksi transaksi){
        return transaksiRepository.save(transaksi);
    }

    public Transaksi findOne(Long idTranskasi){
        Optional<Transaksi> transaksi = transaksiRepository.findById(idTranskasi);
        if(!transaksi.isPresent()){
            return null;
        }
        return transaksi.get();
//       return userRepository.findById(idUser).get();
    }

    public List<Transaksi> findAll(){
        return transaksiRepository.findAll();
    }

    public void removeOne(Long idTransaksi){
        transaksiRepository.deleteById(idTransaksi);
    }

}
