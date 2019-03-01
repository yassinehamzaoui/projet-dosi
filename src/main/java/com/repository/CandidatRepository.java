package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beans.Candidat;

public interface CandidatRepository extends JpaRepository<Candidat, String> {

}