package com.sistem.sisvet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.sistem.sisvet.Entities.Exame;
import com.sistem.sisvet.Repositories.ExameRepository;

@Service
public class ExameService {

    @Autowired
    private ExameRepository exameRepository;

    public ExameService(ExameRepository exameRepository) {
        this.exameRepository = exameRepository;
    }

    // metedo para criar u exame
    public Exame criarExame(Exame exame) {
        return exameRepository.save(exame);
    }

    //metedo para buscar u exae
    public Exame buscarExame(Long id) {
        return exameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exame nao encontrado" + id));
    }

    //metodo para listar todos exames
    public List<Exame> buscarExame(){
        return exameRepository.findAll();
    }


    //meteodo para atualizar um exame
    public Exame atualizaExame(Long id, Exame exameDetalhes){
        Exame exame = buscarExame(id);
        exame.setTipoExame(exame.getTipoExame());
        return exameRepository.save(exame);
    }

    //metodo para delear um exame pelo id
    public void deletarExame(Long id){
        Exame exame = buscarExame(id);
        exameRepository.delete(exame);
    }

    //buscar exame pelo tipo
public List<Exame> buscarTipoExame(String tipoExame) {
    if (tipoExame == null || tipoExame.isEmpty()) {
        throw new IllegalArgumentException("Tipo exame deve ser informado");
    }

    // Utilize o método findByTipoExame do seu repositório (caso exista)
    return exameRepository.findByTipoExame(tipoExame);
}
}