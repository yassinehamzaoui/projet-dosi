package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beans.Promotion;
import com.beans.PromotionPK;

@CrossOrigin
@RestController
@RequestMapping("/promotion")
public class PromotionController {

	@Autowired
	private PromotionBusiness business;
	
	// method to add Promotions
	@RequestMapping("/getAllPromotion")
	public List<Promotion> getAllPromotion() {
		return business.getAllPromotion();
	}
	// method to get Promotions By Lieu
	@RequestMapping("SearchPromotion/lieuRentree/{lieuRentree}")
	public List<Promotion> SearchPromotionByLieu(@PathVariable String lieuRentree) {
		return business.SearchPromotionByLieu(lieuRentree);
	}
	// method to get Promotions By sigle
	@RequestMapping("SearchPromotion/sigle/{siglePromotion}")
	public Promotion SearchPromotionBySigle(@PathVariable String siglePromotion) {
		return business.SearchPromotionBySigle(siglePromotion);
	}
	// method to get Promotions By id(code+annee)
	@RequestMapping("SearchPromotion/{codeFormation}/{anneeUniversitaire}")
    public Optional<Promotion> SearchPromotionById(@PathVariable String codeFormation,@PathVariable String anneeUniversitaire ) {
        PromotionPK promotionPK = new PromotionPK(anneeUniversitaire,codeFormation);
        return business.SearchPromotionById(promotionPK);
    }
	// method to add Promotions
	@RequestMapping(method = RequestMethod.POST)
	public Promotion AddPromotion(@RequestBody Promotion promotion) {
		return business.AddPromotion(promotion);
	}
	// method to delete all Promotions
	@RequestMapping("/deleteAllPromotions")
  	public void deleteAllPromotion() {
		 business.deleteAllPromotion();
	}
	// method to delete Promotion by id(code+annee)
	@RequestMapping(value = "/deletePromotion/{codeFormation}/{anneeUniversitaire}",method = RequestMethod.DELETE)
    public void deletePromotionById(@PathVariable("codeFormation") String codeFormation, @PathVariable("anneeUniversitaire") String anneeUniversitaire){
        PromotionPK promotionPK = new PromotionPK(anneeUniversitaire,codeFormation);
        this.business.deletePromotionById(promotionPK);
    }
}
