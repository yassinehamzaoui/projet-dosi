package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beans.Enseignant;

@CrossOrigin
@RestController
@RequestMapping(path = "/enseignant")
public class EnseignantController {

	@Autowired
	private EnseignantBusiness business;

	@Autowired
	public EnseignantController(EnseignantBusiness business) {
		this.business = business;
	}

	// method to get add Enseignant
	@RequestMapping(method = RequestMethod.POST)
	public Enseignant AddEnseignant(@RequestBody Enseignant enseignant) {
		return business.AddEnseignant(enseignant);
	}

	// method to get update Enseignant
	@RequestMapping(method = RequestMethod.PUT)
	public void UpdateCandidat(@RequestBody Enseignant enseignant) {
		this.business.UpdateEnseignant(enseignant);
	}

	// method to get Enseignant By No Enseignant
	@RequestMapping(value = "/SearchEnseignantById/{codeEnseignant}", method = RequestMethod.GET)
	public Enseignant SearchEnseignantByNoEnseignant(@PathVariable int codeEnseignant) {
		return business.SearchEnseignantByNoEnseignant(codeEnseignant);
	}

	// method to get Enseignant By name
	@RequestMapping("/SearchEnseignantByName/{nomEnseignant}")
	public Enseignant SearchEnseignantByName(@PathVariable String nomEnseignant) {
		return business.SearchEnseignantByName(nomEnseignant);
	}

	// method to get Enseignant By email
	@RequestMapping("/SearchEnseignantByEmail/{emailEnseignant}")
	public Enseignant SearchEnseignantByEmail(@PathVariable String emailEnseignant) {
		return business.SearchEnseignantByEmail(emailEnseignant);
	}

	// method to get all Enseignants
	@RequestMapping("/getAllEnseignant")
	public List<Enseignant> getAllEnseignant() {
		return business.getAllEnseignant();
	}

}
