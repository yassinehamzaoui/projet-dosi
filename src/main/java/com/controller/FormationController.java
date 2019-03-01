package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beans.Formation;

@RestController
@RequestMapping(path = "/formation")
public class FormationController {

	@Autowired
	private FormationBusiness business;
	
	@Autowired
	public FormationController(FormationBusiness business) {
		this.business = business;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Formation AddFormation(@RequestBody Formation formation) {
		return business.AddFormation(formation);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void UpdateCandidat(@RequestBody Formation formation) {
		this.business.UpdateFormation(formation);
	}
	
	@RequestMapping(value="/SearchFormationById/{idFormation}", method = RequestMethod.GET)
	public Optional<Formation> SearchFormationById(@PathVariable String idFormation) {
		return business.SearchFormationById(idFormation);
	}
	
	@RequestMapping("/SearchFormationByName/{nomFormation}")
  	public Formation SearchFormationByName(@PathVariable String nomFormation) {
		return business.SearchFormationByName(nomFormation);
  	}
	
  	@RequestMapping("/getAllFormation")
  	public List<Formation> getAllFormation(){
  		return business.getAllFormation();
  	}

	@RequestMapping("/deleteAllFormation")
  	public void deleteAllCandidat() {
		 business.deleteAllFormation();
	}
	
	@RequestMapping(value="/delete/{codeFormation}" ,method = RequestMethod.DELETE)
	public void DeleteCandidat(@PathVariable("codeFormation") String codeFormation){
		this.business.DeleteFormation(codeFormation);
	}
}
