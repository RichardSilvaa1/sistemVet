package com.sistem.sisvet.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.sistem.sisvet.Entities.Clinica;
import com.sistem.sisvet.Repositories.ClinicaRepository;

@Service
public class ClinicaService {

    @Autowired
    private ClinicaRepository clinicaRepository;

    public ClinicaService(ClinicaRepository clinicaRepository){
      this.clinicaRepository = clinicaRepository;
    }


    // Método para criar uma nova clínica
    public Clinica criarClinica(Clinica clinica) {
        return clinicaRepository.save(clinica);
    }

    // Método para buscar uma clínica pelo ID
    public Clinica buscarClinicaPorId(Long id) {
        Optional<Clinica> clinicaOptional = clinicaRepository.findById(id);
        if (clinicaOptional.isPresent()) {
            return clinicaOptional.get();
        } else {
            throw new ResourceNotFoundException("Clínica não encontrada com o ID: " + id);
        }
    }

    // Método para atualizar uma clínica existente
    public Clinica atualizarClinica(Long id, Clinica clinicaDetails) {
        Clinica clinica = buscarClinicaPorId(id);
        clinica.setNomeClinica(clinicaDetails.getNomeClinica());
        return clinicaRepository.save(clinica);
    }

    // Método para deletar uma clínica pelo ID
    public void deletarClinica(Long id) {
        Clinica clinica = buscarClinicaPorId(id);
        clinicaRepository.delete(clinica);
    }

    // Método para buscar todas as clínicas
    public List<Clinica> buscarTodasClinicas() {
        return clinicaRepository.findAll();
    }
}
