package com.miniLoyaty.miniLoyaltyStudi.Repository;

import com.miniLoyaty.miniLoyaltyStudi.Entity.Products;
import com.miniLoyaty.miniLoyaltyStudi.Entity.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankRepository extends JpaRepository<Rank, Long> {
    List<Rank> findByNameRankContains(String nameRank);
}
