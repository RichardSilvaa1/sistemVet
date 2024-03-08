package com.sistem.sisvet.Controller;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistem.sisvet.Entities.Clinica;
import com.sistem.sisvet.Service.ClinicaService;

@RestController
@RequestMapping("/clinicas") // Mapeamento da URL base para este controlador
public class clinicaController {

  @Autowired
  private ClinicaService clinicaService;

  // Endpoint para criar uma chamada para uma nova clínica
  @PostMapping // Mapeamento para requisições POST
  public ResponseEntity<Clinica> criarClinica(@RequestBody Clinica clinica)
    throws BadRequestException {
    Clinica novaClinica = clinicaService.criarClinica(clinica);
    return new ResponseEntity<>(novaClinica, HttpStatus.CREATED);
  }

  // Chamada para listar todas as clínicas
  @GetMapping // Mapeamento para requisições GET
  public ResponseEntity<List<Clinica>> listarClinicas() {
    List<Clinica> clinicas = clinicaService.buscarTodasClinicas();
    return new ResponseEntity<>(clinicas, HttpStatus.OK);
  }

  // Chamada para atualizar clínica
  @GetMapping("/{id}") // Mapeamento para requisições GET com parâmetro no URL
  public ResponseEntity<Clinica> atualizarClinica(
    @PathVariable Long id, // Captura o ID da URL
    @RequestBody Clinica clinica // Obtém a clínica do corpo da requisição
  ) throws BadRequestException {
    Clinica clinicaAtualizada = clinicaService.atualizarClinica(id, clinica);
    return new ResponseEntity<>(clinicaAtualizada, HttpStatus.OK);
  }

  // Chamada para excluir uma clínica
  @DeleteMapping("/id") // Mapeamento para requisições DELETE com parâmetro no URL
  public ResponseEntity<Void> excluirClinica(@PathVariable Long id) {
    clinicaService.deletarClinica(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  // Método para buscar uma clínica pelo nome
  @GetMapping("/buscar-por-nome/{nomeClinica}") // Mapeamento para requisições GET com parâmetro no URL
  public ResponseEntity<List<Clinica>> buscarPorNome(
    @PathVariable String nomeClinica // Captura o nome da URL
  ) {
    List<Clinica> clinicasEncontradas = clinicaService.buscarClinicaPorNome(
      nomeClinica
    );
    if (!clinicasEncontradas.isEmpty()) {
      return ResponseEntity.ok(clinicasEncontradas); // Retorna a lista de clínicas encontradas
    } else {
      // Tratamento para quando nenhuma clínica for encontrada
      return ResponseEntity.notFound().build();
    }
  }
}
