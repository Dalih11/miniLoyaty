package com.miniLoyaty.miniLoyaltyStudi.Repository;

import com.miniLoyaty.miniLoyaltyStudi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    boolean exitsUserByPhone(String phone);
//    boolean exitsUserByEmail(String email);
}
