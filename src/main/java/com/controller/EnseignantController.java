package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beans.Enseignant;

@RestController
@RequestMapping(path = "/enseignant")
public class EnseignantController {

	@Autowired
	private EnseignantBusiness business;
	
	@Autowired
	public EnseignantController(EnseignantBusiness business) {
		this.business = business;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Enseignant AddEnseignant(@RequestBody Enseignant enseignant) {
		return business.AddEnseignant(enseignant);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void UpdateCandidat(@RequestBody Enseignant enseignant) {
		this.business.UpdateEnseignant(enseignant);
	}
	
	@RequestMapping(value="/SearchEnseignantById/{codeEnseignant}", method = RequestMethod.GET)
	public Enseignant SearchEnseignantByNoEnseignant(@PathVariable int codeEnseignant) {
		return business.SearchEnseignantByNoEnseignant(codeEnseignant);
	}
	
	@RequestMapping("/SearchEnseignantByName/{nomEnseignant}")
  	public Enseignant SearchEnseignantByName(@PathVariable String nomEnseignant) {
		return business.SearchEnseignantByName(nomEnseignant);
  	}

	@RequestMapping("/SearchEnseignantByEmail/{emailEnseignant}")
  	public Enseignant SearchEnseignantByEmail(@PathVariable String emailEnseignant) {
		return business.SearchEnseignantByEmail(emailEnseignant);
  	}
	
  	@RequestMapping("/getAllEnseignant")
  	public List<Enseignant> getAllEnseignant(){
  		return business.getAllEnseignant();
  	}
	
}
