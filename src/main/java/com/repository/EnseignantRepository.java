package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.beans.Enseignant;

public interface EnseignantRepository extends JpaRepository<Enseignant, String> {
	Enseignant findBynoEnseignant(int nom);
}
