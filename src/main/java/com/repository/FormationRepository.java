package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.beans.Formation;

public interface FormationRepository extends JpaRepository<Formation, String> {

}