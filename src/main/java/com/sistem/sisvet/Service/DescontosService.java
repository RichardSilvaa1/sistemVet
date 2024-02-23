package com.sistem.sisvet.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.sistem.sisvet.Entities.Descontos;
import com.sistem.sisvet.Repositories.DescontosRepository;

// Anotação indicando que esta classe é um serviço
@Service
public class DescontosService {
 
    // Declaração de um membro privado que representa o repositório de descontos
    private DescontosRepository descontosRepository;

    // Construtor da classe que recebe um DescontosRepository como argumento
    public DescontosService(DescontosRepository descontosRepository) {
        this.descontosRepository = descontosRepository;
    }

    // Método para criar um novo desconto
    public Descontos criarDesconto(Descontos desconto){
        return descontosRepository.save(desconto);
    }

    // Método para buscar desconto por ID
    public Descontos buscarDescontos(Long id){
        Optional<Descontos> descontosOptional = descontosRepository.findById(id);
        if(descontosOptional.isPresent()) {
            return descontosOptional.get();
        } else {
            // Lança uma exceção caso o desconto não seja encontrado
            throw new ResourceNotFoundException("Desconto nao encontrado");
        }
    }

    // Método para buscar todos os descontos
    public List<Descontos> buscarDescontos(){
        return descontosRepository.findAll();
    }

    // Método para deletar o desconto por ID
    public void deletarDesconto(Long id){
        // Busca o desconto pelo ID
        Descontos desconto = buscarDescontos(id);
        // Deleta o desconto do repositório
        descontosRepository.delete(desconto);
    }

}

