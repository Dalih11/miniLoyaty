package com.miniLoyaty.miniLoyaltyStudi.Service;

import com.miniLoyaty.miniLoyaltyStudi.Entity.Merchant;
import com.miniLoyaty.miniLoyaltyStudi.Entity.OrderCart;
import com.miniLoyaty.miniLoyaltyStudi.Entity.User;
import com.miniLoyaty.miniLoyaltyStudi.Model.Status;
import com.miniLoyaty.miniLoyaltyStudi.Repository.OrderCartRepository;
import com.miniLoyaty.miniLoyaltyStudi.Repository.ProductRepository;
import com.miniLoyaty.miniLoyaltyStudi.Repository.TransaksiRepository;
import com.miniLoyaty.miniLoyaltyStudi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderCartService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderCartRepository orderCartRepository;

    @Autowired
    private TransaksiRepository transaksiRepository;

    public OrderCart save(OrderCart orderCart){
//        orderCart.setStatus(Status.ERROR);
    return orderCartRepository.save(orderCart);
    }

    public OrderCart findOne(Long idOrderCart){
        Optional<OrderCart> orderCart = orderCartRepository.findById(idOrderCart);
        if(!orderCart.isPresent()){
            return null;
        }
        return orderCart.get();
//       return userRepository.findById(idUser).get();
    }

    public List<OrderCart> findAll(){
        return orderCartRepository.findAll();
    }

    public void removeOne(Long idOrderCart){
        orderCartRepository.deleteById(idOrderCart);
    }
}
