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

	// method to add Formation
	@RequestMapping(method = RequestMethod.POST)
	public Formation AddFormation(@RequestBody Formation formation) {
		return business.AddFormation(formation);
	}

	// method to Update Formation
	@RequestMapping(method = RequestMethod.PUT)
	public void UpdateCandidat(@RequestBody Formation formation) {
		this.business.UpdateFormation(formation);
	}

	// method to get Formation By id
	@RequestMapping(value = "/SearchFormationById/{idFormation}", method = RequestMethod.GET)
	public Optional<Formation> SearchFormationById(@PathVariable String idFormation) {
		return business.SearchFormationById(idFormation);
	}

	// method to get Formation By Name
	@RequestMapping("/SearchFormationByName/{nomFormation}")
	public Formation SearchFormationByName(@PathVariable String nomFormation) {
		return business.SearchFormationByName(nomFormation);
	}

	// method to get all Formations
	@RequestMapping("/getAllFormation")
	public List<Formation> getAllFormation() {
		return business.getAllFormation();
	}

	// method to delete all Formations
	@RequestMapping("/deleteAllFormation")
	public void deleteAllFormation() {
		business.deleteAllFormation();
	}

	// method to get Formation By id
	@RequestMapping(value = "/delete/{codeFormation}", method = RequestMethod.DELETE)
	public void DeleteCandidat(@PathVariable("codeFormation") String codeFormation) {
		this.business.DeleteFormation(codeFormation);
	}
}
