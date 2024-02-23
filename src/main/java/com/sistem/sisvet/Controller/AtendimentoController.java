package com.sistem.sisvet.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistem.sisvet.Entities.Atendimento;
import com.sistem.sisvet.Service.AtendimentoService;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService;

    // Endpoint para criar um novo atendimento
    @PostMapping
    public ResponseEntity<Atendimento> criarAtendimento(@RequestBody Atendimento atendimento) throws BadRequestException {
        // Salva um novo atendimento usando o serviço e retorna a resposta HTTP adequada
        Atendimento novoAtendimento = atendimentoService.saveAtendimento(atendimento);
        return new ResponseEntity<>(novoAtendimento, HttpStatus.CREATED);
    }

    // Endpoint para buscar todos os atendimentos
    @GetMapping
    public ResponseEntity<List<Atendimento>> listarAtendimentos() {
        // Obtém todos os atendimentos usando o serviço e retorna a resposta HTTP adequada
        List<Atendimento> atendimentos = atendimentoService.getAllAtendimentos();
        return new ResponseEntity<>(atendimentos, HttpStatus.OK);
    }

    // Endpoint para buscar um atendimento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Atendimento> buscarAtendimentoPorId(@PathVariable Long id) {
        // Obtém um atendimento por ID usando o serviço e retorna a resposta HTTP adequada
        Atendimento atendimento = atendimentoService.getAtendimentoById(id);
        return new ResponseEntity<>(atendimento, HttpStatus.OK);
    }

    // Endpoint para atualizar um atendimento
    @PutMapping("/{id}")
    public ResponseEntity<Atendimento> atualizarAtendimento(@PathVariable Long id, @RequestBody Atendimento atendimento) throws BadRequestException {
        // Atualiza um atendimento usando o serviço e retorna a resposta HTTP adequada
        Atendimento atendimentoAtualizado = atendimentoService.updateAtendimento(id, atendimento);
        return new ResponseEntity<>(atendimentoAtualizado, HttpStatus.OK);
    }

    // Endpoint para excluir um atendimento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAtendimento(@PathVariable Long id) {
        // Exclui um atendimento usando o serviço e retorna a resposta HTTP adequada
        atendimentoService.deleteAtendimento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Método para obter a quantidade de atendimentos por cliente
    @GetMapping("/quantidade-por-cliente")
    public ResponseEntity<Map<String, Long>> obterQuantidadeAtendimentosPorCliente() {
        // Obtém a quantidade de atendimentos por cliente usando o serviço e retorna a resposta HTTP adequada
        Map<String, Long> quantidadePorCliente = atendimentoService.obterQuantidadeAtendimentosPorCliente();
        return new ResponseEntity<>(quantidadePorCliente, HttpStatus.OK);
    }

    // Método para filtrar atendimentos por data
    @GetMapping("/filtrar-por-data")
    public ResponseEntity<List<Atendimento>> filtrarAtendimentosPorData(
            @RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal) {
        // Filtra os atendimentos por data usando o serviço e retorna a resposta HTTP adequada
        List<Atendimento> atendimentosFiltrados = atendimentoService.filtrarAtendimentosPorData(dataInicial, dataFinal);
        return new ResponseEntity<>(atendimentosFiltrados, HttpStatus.OK);
    }
}



