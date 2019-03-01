package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.beans.Formation;
import com.repository.FormationRepository;

@Service
@Component
public class FormationBusiness {

	@Autowired
	private FormationRepository formationRepository;

	public FormationBusiness(FormationRepository formationRepository) {
		this.formationRepository = formationRepository;
	}

	// method call to get all formations
	public List<Formation> getAllFormation() {
		return formationRepository.findAll();
	}

	// method call to get formation By code formation
	public Optional<Formation> SearchByCodeFormation(String codeFormation) {
		return this.formationRepository.findById(codeFormation);
	}

	// method call to add formation
	public Formation AddFormation(Formation formation) {
		this.formationRepository.save(formation);
		return formation;
	}

	// method call to update formation
	public void UpdateFormation(Formation formation) {
		this.formationRepository.save(formation);
	}

	// method call to delete formation
	public void DeleteFormation(String codeFormation) {
		this.formationRepository.deleteById(codeFormation);
	}

	// method call to delete all formations
	public void deleteAllFormation() {
		formationRepository.deleteAll();
	}

	// method call to get formation By Name
	public Formation SearchFormationByName(String nomFormation) {
		List<Formation> listeFormation = formationRepository.findAll();
		return listeFormation.stream().filter(t -> t.getNomFormation().equals(nomFormation)).findFirst().get();
	}

	// method call to get formation By id
	public Optional<Formation> SearchFormationById(String nomFormation) {
		return this.formationRepository.findById(nomFormation);
	}
}
