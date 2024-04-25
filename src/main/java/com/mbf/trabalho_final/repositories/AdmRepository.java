package com.mbf.trabalho_final.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbf.trabalho_final.entities.Adm;

@Repository
public interface AdmRepository extends JpaRepository<Adm, Long>{

} 