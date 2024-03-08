package com.sistem.sisvet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistem.sisvet.Entities.Exame;
import com.sistem.sisvet.Service.ExameService;

@RestController
@RequestMapping("/exames")
public class ExamesController {

    // Injeção de dependência do serviço ExameService
    private final ExameService exameService;

    @Autowired
    public ExamesController(ExameService exameService) {
        this.exameService = exameService;
    }

    // Endpoint para criar um novo exame
    @PostMapping
    public ResponseEntity<Exame> criarExame(@RequestBody Exame exame) {
        Exame novoExame = exameService.criarExame(exame);
        return new ResponseEntity<>(novoExame, HttpStatus.CREATED);
    }

    // Endpoint para buscar um exame pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Exame> buscarExame(@PathVariable Long id) {
        Exame exame = exameService.buscarExame(id);
        return new ResponseEntity<>(exame, HttpStatus.OK);
    }

    // Endpoint para listar todos os exames
    @GetMapping
    public ResponseEntity<List<Exame>> listarExames() {
        List<Exame> exames = exameService.buscarExame();
        return new ResponseEntity<>(exames, HttpStatus.OK);
    }

    // Endpoint para atualizar um exame existente
    @PutMapping("/{id}")
    public ResponseEntity<Exame> atualizarExame(@PathVariable Long id, @RequestBody Exame exameDetalhes) {
        Exame exameAtualizado = exameService.atualizaExame(id, exameDetalhes);
        return new ResponseEntity<>(exameAtualizado, HttpStatus.OK);
    }

    // Endpoint para deletar um exame pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarExame(@PathVariable Long id) {
        exameService.deletarExame(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint para buscar exames por tipo
    @GetMapping("/tipo/{tipoExame}")
    public ResponseEntity<List<Exame>> buscarExamesPorTipo(@PathVariable String tipoExame) {
        List<Exame> examesPorTipo = exameService.buscarTipoExame(tipoExame);
        return new ResponseEntity<>(examesPorTipo, HttpStatus.OK);
    }
}