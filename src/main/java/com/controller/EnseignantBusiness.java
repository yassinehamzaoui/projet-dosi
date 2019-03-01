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

	// method call to get all Enseignants
	public List<Enseignant> getAllEnseignant() {
		return enseignantRepository.findAll();
	}

	// method call to get Enseignant By id
	public Optional<Enseignant> SearchByCodeFormation(String codeEnseignant) {
		return this.enseignantRepository.findById(codeEnseignant);
	}

	// method call to add Enseignant
	public Enseignant AddEnseignant(Enseignant enseignant) {
		this.enseignantRepository.save(enseignant);
		return enseignant;
	}

	// method call to update Enseignant
	public void UpdateEnseignant(Enseignant enseignant) {
		this.enseignantRepository.save(enseignant);
	}

	// method call to delete Enseignant By id
	public void DeleteEnseignant(String codeEnseignant) {
		this.enseignantRepository.deleteById(codeEnseignant);
	}

	// method call to delete all Enseignants
	public void deleteAllEnseignant() {
		enseignantRepository.deleteAll();
	}

	// method call to get Enseignant By name
	public Enseignant SearchEnseignantByName(String nomEnseignant) {
		List<Enseignant> listeEnseignant = enseignantRepository.findAll();
		return listeEnseignant.stream().filter(t -> t.getNom().equals(nomEnseignant)).findFirst().get();
	}

	// method call to get Enseignant By No Enseignant
	public Enseignant SearchEnseignantByNoEnseignant(int idEnseignant) {
		return this.enseignantRepository.findBynoEnseignant(idEnseignant);
	}

	// method call to get Enseignant By email
	public Enseignant SearchEnseignantByEmail(String emailEnseignant) {
		List<Enseignant> listeEnseignant = enseignantRepository.findAll();
		return listeEnseignant.stream().filter(t -> t.getEmailUbo().equals(emailEnseignant)).findFirst().get();
	}

}
