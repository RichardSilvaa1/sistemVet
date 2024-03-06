package com.sistem.sisvet.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistem.sisvet.Entities.Clinica;

public interface ClinicaRepository extends JpaRepository <Clinica, Long> {

    List<Clinica> findByNomeClinica(String nomeClinica);
    
}
