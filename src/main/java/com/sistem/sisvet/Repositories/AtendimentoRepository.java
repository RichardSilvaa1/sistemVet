package com.sistem.sisvet.Repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sistem.sisvet.Entities.Atendimento;

@RepositoryRestResource(path = "atendimento")
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>{
    List<Atendimento> findByClinicaNomeClinica(String nomeClinica);

    List<Atendimento> findByPaciente(String paciente);

    
} 
