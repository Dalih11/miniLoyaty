package com.miniLoyaty.miniLoyaltyStudi.Service;

import com.miniLoyaty.miniLoyaltyStudi.Entity.User;
import com.miniLoyaty.miniLoyaltyStudi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService{

    @Autowired
    private UserRepository userRepository;

   public User save(User user){
       return userRepository.save(user);
   }

   public User findOne(Long idUser){
       Optional<User> user = userRepository.findById(idUser);
       if(!user.isPresent()){
           return null;
       }
       return user.get();
//       return userRepository.findById(idUser).get();
   }

   public List<User> findAll(){
       return userRepository.findAll();
   }

   public void removeOne(Long idUser){
       userRepository.deleteById(idUser);
   }
}
