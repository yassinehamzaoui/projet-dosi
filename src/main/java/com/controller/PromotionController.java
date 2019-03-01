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
	@RequestMapping("/getAllPromotion")
	public List<Promotion> getAllPromotion() {
		return business.getAllPromotion();
	}

	@RequestMapping("SearchPromotion/lieuRentree/{lieuRentree}")
	public List<Promotion> SearchPromotionByLieu(@PathVariable String lieuRentree) {
		return business.SearchPromotionByLieu(lieuRentree);
	}

	@RequestMapping("SearchPromotion/sigle/{siglePromotion}")
	public Promotion SearchPromotionBySigle(@PathVariable String siglePromotion) {
		return business.SearchPromotionBySigle(siglePromotion);
	}
	
	@RequestMapping("SearchPromotion/{codeFormation}/{anneeUniversitaire}")
    public Optional<Promotion> SearchPromotionById(@PathVariable String codeFormation,@PathVariable String anneeUniversitaire ) {
        PromotionPK promotionPK = new PromotionPK(anneeUniversitaire,codeFormation);
        return business.SearchPromotionById(promotionPK);
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public Promotion AddPromotion(@RequestBody Promotion promotion) {
		return business.AddPromotion(promotion);
	}
	
	@RequestMapping("/deleteAllPromotions")
  	public void deleteAllPromotion() {
		 business.deleteAllPromotion();
	}
	@RequestMapping(value = "/deleteFormation/{codeFormation}/{anneeUniversitaire}",method = RequestMethod.DELETE)
    public void deletePromotionById(@PathVariable("codeFormation") String codeFormation, @PathVariable("anneeUniversitaire") String anneeUniversitaire){
        PromotionPK promotionPK = new PromotionPK(anneeUniversitaire,codeFormation);
        this.business.deletePromotionById(promotionPK);
    }
}
