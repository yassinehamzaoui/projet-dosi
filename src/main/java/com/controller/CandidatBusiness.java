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

 	public Optional<Candidat> getCandidat(String id) {
 		return candidatRepository.findById(id);
 	}
 	public List<Candidat> getAllCandidat() {
		return candidatRepository.findAll();
	}
 	public void deleteAllCandidat() {
		 candidatRepository.deleteAll();
	}

	public Optional<Candidat> SearchByCodeCandidat(String noCandidat) {
		return this.candidatRepository.findById(noCandidat);
	}

	public Candidat AddCandidat(Candidat candidat) {
		 this.candidatRepository.save(candidat);
	     return candidat;
	}

	public void UpdateCandidat(Candidat candidat) {
		this.candidatRepository.save(candidat);		
	}

	public void DeleteCandidat(String codeCandidat) {
        this.candidatRepository.deleteById(codeCandidat);	
	}

	public Candidat SearchCandidatByUniv(String nomUniv) {
		List<Candidat> listeCandidat = candidatRepository.findAll();
		return listeCandidat.stream().filter(t -> t.getUniversiteOrigine().equals(nomUniv)).findFirst().get();
	}

	public Candidat SearchCandidatByName(String nomCandidat) {
		List<Candidat> listeCandidat = candidatRepository.findAll();
		return listeCandidat.stream().filter(t -> t.getNom().equals(nomCandidat)).findFirst().get();
	}
 	
}
