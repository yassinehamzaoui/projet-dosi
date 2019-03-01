package com.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.beans.Promotion;
import com.beans.PromotionPK;
import com.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionBusiness {
	
	@Autowired
	PromotionRepository promotionrepository;

	public List<Promotion> getAllPromotion() {
		return promotionrepository.findAll();
	}
	
	public Promotion AddPromotion(Promotion promotion) {
		 this.promotionrepository.save(promotion);
	     return promotion;
	}

	public List<Promotion> SearchPromotionByLieu(String lieuRentree) {
		List<Promotion> listeDesPromotion = promotionrepository.findAll();
		return listeDesPromotion.stream().filter(t -> t.getLieuRentree().equals(lieuRentree)).collect(Collectors.toList());
	}
	
	public Promotion SearchPromotionBySigle(String sigle) {
		List<Promotion> listeDesPromotion = promotionrepository.findAll();
		return listeDesPromotion.stream().filter(t -> t.getSiglePromotion().equals(sigle)).findFirst().get();
	}
	
    public Optional<Promotion> SearchPromotionById(PromotionPK promotionPK) {
        return this.promotionrepository.findById(promotionPK);
    }
	
	public void deleteAllPromotion() {
		 promotionrepository.deleteAll();
	}

	public void deletePromotionById(PromotionPK promotionPK) {
        this.promotionrepository.deleteById(promotionPK);		
	}

	
	
}
