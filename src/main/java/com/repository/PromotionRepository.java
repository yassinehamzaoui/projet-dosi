package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.beans.Promotion;
import com.beans.PromotionPK;

public interface PromotionRepository extends JpaRepository<Promotion, PromotionPK> {

}