package com.controller;

import com.beans.Candidat;
import com.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class  CandidatBusiness  {

	@Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    public CandidatBusiness(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }
 	//method call to get all candidates
 	public List<Candidat> getAllCandidat() {
		return candidatRepository.findAll();
	}
 	//method call to delete all candidates
 	public void deleteAllCandidat() {
		 candidatRepository.deleteAll();
	}
 	//method call to search candidate by id
	public Optional<Candidat> SearchByCodeCandidat(String noCandidat) {
		return this.candidatRepository.findById(noCandidat);
	}
	//method call to get add candidate
	public Candidat AddCandidat(Candidat candidat) {
		 this.candidatRepository.save(candidat);
	     return candidat;
	}
	//method call to get update candidate
	public void UpdateCandidat(Candidat candidat) {
		this.candidatRepository.save(candidat);		
	}
	//method call to delete candidate by id
	public void DeleteCandidat(String codeCandidat) {
        this.candidatRepository.deleteById(codeCandidat);	
	}
	//method call to get candidate by university
	public Candidat SearchCandidatByUniv(String nomUniv) {
		List<Candidat> listeCandidat = candidatRepository.findAll();
		return listeCandidat.stream().filter(t -> t.getUniversiteOrigine().equals(nomUniv)).findFirst().get();
	}
	//method call to get candidate by name
	public Candidat SearchCandidatByName(String nomCandidat) {
		List<Candidat> listeCandidat = candidatRepository.findAll();
		return listeCandidat.stream().filter(t -> t.getNom().equals(nomCandidat)).findFirst().get();
	}
 	
}
