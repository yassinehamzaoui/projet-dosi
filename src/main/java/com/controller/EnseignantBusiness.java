package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.beans.Enseignant;
import com.repository.EnseignantRepository;

@Service
@Component
public class EnseignantBusiness {

	@Autowired
	private EnseignantRepository enseignantRepository;
	
	public EnseignantBusiness(EnseignantRepository enseignantRepository) {
		this.enseignantRepository = enseignantRepository;
	}
	
	public List<Enseignant> getAllEnseignant() {
		return enseignantRepository.findAll();
	}

	public Optional<Enseignant> SearchByCodeFormation(String codeEnseignant) {
		return this.enseignantRepository.findById(codeEnseignant);
	}

	public Enseignant AddEnseignant(Enseignant enseignant) {
		 this.enseignantRepository.save(enseignant);
	     return enseignant;
	}

	public void UpdateEnseignant(Enseignant enseignant) {
		this.enseignantRepository.save(enseignant);		
	}

	public void DeleteEnseignant(String codeEnseignant) {
        this.enseignantRepository.deleteById(codeEnseignant);		
	}

 	public void deleteAllEnseignant() {
 		enseignantRepository.deleteAll();
	}
	
	public Enseignant SearchEnseignantByName(String nomEnseignant) {
		List<Enseignant> listeEnseignant = enseignantRepository.findAll();
		return listeEnseignant.stream().filter(t -> t.getNom().equals(nomEnseignant)).findFirst().get();
	}
 	
	public Enseignant SearchEnseignantByNoEnseignant(int idEnseignant) {
		return this.enseignantRepository.findBynoEnseignant(idEnseignant);
	}
	
	public Enseignant SearchEnseignantByEmail(String emailEnseignant) {
		List<Enseignant> listeEnseignant = enseignantRepository.findAll();
		return listeEnseignant.stream().filter(t -> t.getEmailUbo().equals(emailEnseignant)).findFirst().get();
	}


}
