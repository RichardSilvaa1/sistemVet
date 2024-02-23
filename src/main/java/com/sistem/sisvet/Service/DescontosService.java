package com.sistem.sisvet.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.sistem.sisvet.Entities.Descontos;
import com.sistem.sisvet.Repositories.DescontosRepository;

@Service
public class DescontosService {
 
    private DescontosRepository descontosRepository;

    // Construtor para injetar o DescontosRepository
    public DescontosService(DescontosRepository descontosRepository) {
        this.descontosRepository = descontosRepository;
    }

    // Método para criar um novo desconto
    public Descontos criarDesconto(Descontos desconto) {
        return descontosRepository.save(desconto);
    }

    // Método para buscar um desconto pelo ID
    public Descontos buscarDescontos(Long id) {
        Optional<Descontos> descontosOptional = descontosRepository.findById(id);
        if (descontosOptional.isPresent()) {
            return descontosOptional.get();
        } else {
            throw new ResourceNotFoundException("Desconto não encontrado");
        }
    }

    // Método para recuperar todos os descontos
    public List<Descontos> buscarDescontos() {
        return descontosRepository.findAll();
    }

    // Método para excluir um desconto
    public void deletarDesconto(Long id) {
        Descontos desconto = buscarDescontos(id);
        descontosRepository.delete(desconto);
    }
}

