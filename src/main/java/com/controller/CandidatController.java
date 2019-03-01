package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beans.Candidat;

@RestController
@RequestMapping(path = "/candidat")
public class CandidatController {

	@Autowired
	private CandidatBusiness business;

	@Autowired
	public CandidatController(CandidatBusiness business) {
		this.business = business;
	}

	// method to get all candidate
	@RequestMapping("/getAllCandidat")
	public List<Candidat> getAllCandidat() {
		return business.getAllCandidat();
	}

	// method to get candidate by id
	@RequestMapping(value = "/SearchCandidatByCode/{codeCandidat}", method = RequestMethod.GET)
	public Optional<Candidat> SearchByCodeCandidat(@PathVariable String codeCandidat) {
		return business.SearchByCodeCandidat(codeCandidat);
	}

	// method to add candidate
	@RequestMapping(method = RequestMethod.POST)
	public Candidat AddCandidat(@RequestBody Candidat candidat) {
		return business.AddCandidat(candidat);
	}

	// method to update candidate
	@RequestMapping(method = RequestMethod.PUT)
	public void UpdateCandidat(@RequestBody Candidat candidat) {
		this.business.UpdateCandidat(candidat);
	}

	// method to delete all candidates
	@RequestMapping("/deleteAllCandidat")
	public void deleteAllCandidat() {
		business.deleteAllCandidat();
	}

	// method to get delete candidate by id
	@RequestMapping(value = "/delete/{codeCandidat}", method = RequestMethod.DELETE)
	public void DeleteCandidat(@PathVariable("codeCandidat") String codeCandidat) {
		this.business.DeleteCandidat(codeCandidat);
	}

	// method to get candidate by university
	@RequestMapping(value = "/SearchCandidatByUniv/{nomUniv}", method = RequestMethod.GET)
	public Candidat SearchCandidatByUniv(@PathVariable("nomUniv") String nomUniv) {
		return business.SearchCandidatByUniv(nomUniv);
	}

	// method to get candidate by name
	@RequestMapping(value = "/SearchCandidatByName/{nomCandidat}", method = RequestMethod.GET)
	public Candidat SearchCandidatByName(@PathVariable("nomCandidat") String nomCandidat) {
		return business.SearchCandidatByName(nomCandidat);
	}

}
