package com.miniLoyaty.miniLoyaltyStudi.Service;

import com.miniLoyaty.miniLoyaltyStudi.Entity.Transaksi;
import com.miniLoyaty.miniLoyaltyStudi.Entity.TransaksiVoucher;
import com.miniLoyaty.miniLoyaltyStudi.Repository.TransaksiVoucherRepository;
import com.miniLoyaty.miniLoyaltyStudi.Repository.UserRepository;
import com.miniLoyaty.miniLoyaltyStudi.Repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TransaksiVoucherService {
    @Autowired
    private TransaksiVoucherRepository transaksiVoucherRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VoucherRepository voucherRepository;

    public TransaksiVoucher save(TransaksiVoucher transaksiVoucher){
        return transaksiVoucherRepository.save(transaksiVoucher);
    }

    public TransaksiVoucher findOne(Long idtV){
        Optional<TransaksiVoucher> transaksiVoucher = transaksiVoucherRepository.findById(idtV);
        if(!transaksiVoucher.isPresent()){
            return null;
        }
        return transaksiVoucher.get();
//       return userRepository.findById(idUser).get();
    }

    public List<TransaksiVoucher> findAll(){
        return transaksiVoucherRepository.findAll();
    }

    public void removeOne(Long idtV){
        transaksiVoucherRepository.deleteById(idtV);
    }

}
