package com.sistem.sisvet.Repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistem.sisvet.Entities.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>{
    List<Atendimento> findByClinicaNomeClinica(String nomeClinica);

    List<Atendimento> findByPaciente(String paciente);

    
} 
