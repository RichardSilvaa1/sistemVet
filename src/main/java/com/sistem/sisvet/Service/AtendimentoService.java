package com.sistem.sisvet.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.sistem.sisvet.Entities.Atendimento;
import com.sistem.sisvet.Entities.Exame;
import com.sistem.sisvet.Exceptions.DataInvalidaException;
import com.sistem.sisvet.Repositories.AtendimentoRepository;
import com.sistem.sisvet.Repositories.ExameRepository;

@Service
public class AtendimentoService {

  @Autowired
    private final AtendimentoRepository atendimentoRepository;

    @Autowired
    private final ComissaoVeterinarioService comissaoVerinarioService;

    @Autowired
    private ExameRepository exameRepository;

    
public AtendimentoService(AtendimentoRepository atendimentoRepository,
        ComissaoVeterinarioService comissaoVerinarioService, ExameRepository exameRepository) {
      this.atendimentoRepository = atendimentoRepository;
      this.comissaoVerinarioService = comissaoVerinarioService;
      this.exameRepository = exameRepository;
    }

// Salva um novo atendimento após validar e calcular valores
public Atendimento saveAtendimento(Atendimento atendimento) throws BadRequestException {
  validarAtendimento(atendimento);
  atendimento.setTotalAtendimento(calcularValorTotalAtendimento(atendimento));
  atendimento.setTotalAtendimento(comissaoVerinarioService.calcularValorVeterinarioRecebe(atendimento));
  
  // Verifica se existem exames associados ao atendimento
  if (atendimento.getExames() != null && !atendimento.getExames().isEmpty()) {
      // Salva cada exame associado ao atendimento
      for (Exame exame : atendimento.getExames()) {
          exame.setAtendimento(atendimento);
          exameRepository.save(exame);
      }
  }
  
  return atendimentoRepository.save(atendimento);
}

  // Retorna todos os atendimentos
  public List<Atendimento> getAllAtendimentos() {
    return atendimentoRepository.findAll();
  }

  // Retorna um atendimento pelo ID; lança uma exceção se não encontrado
  public Atendimento getAtendimentoById(Long id) {
    return atendimentoRepository
      .findById(id)
      .orElseThrow(() ->
        new ResourceNotFoundException(
          "Atendimento não encontrado com o ID: " + id
        )
      );
  }

// Atualiza um atendimento existente após validar e calcular valores
public Atendimento updateAtendimento(Long id, Atendimento atendimentoDetails) throws BadRequestException {
  Atendimento atendimento = getAtendimentoById(id);
  validarAtendimento(atendimentoDetails);
  atendimento.setPaciente(atendimentoDetails.getPaciente());
  atendimento.setDataAtendimento(atendimentoDetails.getDataAtendimento());
  atendimento.setClinica(atendimentoDetails.getClinica());
  atendimento.setTurno(atendimentoDetails.getTurno());
  atendimento.setExames(atendimentoDetails.getExames());
  atendimento.setFormaPagamento(atendimentoDetails.getFormaPagamento());
  atendimento.setTotalAtendimento(calcularValorTotalAtendimento(atendimento));
  atendimento.setAluguelAparelho(atendimento.getAluguelAparelho());
  atendimento.setTotalVet(comissaoVerinarioService.calcularValorVeterinarioRecebe(atendimento)); // Atualização do valor veterinário recebido // Atualização do valor veterinário recebido
  return atendimentoRepository.save(atendimento);
}

  // Deleta um atendimento pelo ID
  public void deleteAtendimento(Long id) {
    Atendimento atendimento = getAtendimentoById(id);
    atendimentoRepository.delete(atendimento);
  }

  // Valida um atendimento
  private void validarAtendimento(Atendimento atendimento)
    throws BadRequestException {
    if (
      atendimento.getPaciente() == null || atendimento.getPaciente().isEmpty()
    ) {
      throw new BadRequestException("Paciente não pode ser nulo ou vazio");
    }
    if (atendimento.getDataAtendimento() == null) {
      throw new DataInvalidaException("Data não pode ser nula");
    }
    if (atendimento.getDataAtendimento().isAfter(LocalDateTime.now())) {
      throw new DataInvalidaException(
        "Data de atendimento não pode ser no futuro"
      );
    }
    if (atendimento.getClinica() == null) {
      throw new BadRequestException("Clínica não pode ser nula");
    }
    if (atendimento.getTurno() == null) {
      throw new BadRequestException("Turno não pode ser nulo");
    }
    if (atendimento.getExames() == null || atendimento.getExames().isEmpty()) {
      throw new BadRequestException("Exames não podem ser nulos ou vazios");
    }
    if (atendimento.getFormaPagamento() == null) {
      throw new BadRequestException("Forma de pagamento não pode ser nula");
    }
  }

  // Calcula o valor total do atendimento
  public BigDecimal calcularValorTotalAtendimento(Atendimento atendimento) {
    BigDecimal valorTotal = BigDecimal.ZERO;
    for (Exame exame : atendimento.getExames()) {
      valorTotal = valorTotal.add(exame.getValorExame());
    }
    atendimento.setTotalAtendimento(valorTotal);
    return valorTotal;
  }


  // Filtra os atendimentos por data
  public List<Atendimento> filtrarAtendimentosPorData(
    LocalDateTime dataInicio,
    LocalDateTime dataFim
  ) {
    List<Atendimento> atendimentosFiltrados = new ArrayList<>();
    for (Atendimento atendimento : atendimentoRepository.findAll()) {
      LocalDateTime dataAtendimento = atendimento.getDataAtendimento();
      if (
        dataAtendimento.isAfter(dataInicio) && dataAtendimento.isBefore(dataFim)
      ) {
        atendimentosFiltrados.add(atendimento);
      }
    }
    return atendimentosFiltrados;
  }

  // Obtém a quantidade de atendimentos por cliente
  public Map<String, Long> obterQuantidadeAtendimentosPorCliente() {
    List<Atendimento> atendimentos = atendimentoRepository.findAll();
    Map<String, Long> quantidadePorCliente = new HashMap<>();
    for (Atendimento atendimento : atendimentos) {
      String cliente = atendimento.getPaciente();
      quantidadePorCliente.put(
        cliente,
        quantidadePorCliente.getOrDefault(cliente, 0L) + 1
      );
    }
    return quantidadePorCliente;
  }

  // Busca atendimentos pelo nome do paciente
  public List<Atendimento> buscarAtendimentoPorPaciente(String nomePaciente) {
    if (nomePaciente == null || nomePaciente.isEmpty()) {
      throw new IllegalArgumentException(
        "O nome do paciente deve ser informado."
      );
    }
    return atendimentoRepository.findByPaciente(nomePaciente);
  }

  // Busca atendimentos pelo nome da clínica
  public List<Atendimento> buscarPorClinica(String nomeClinica) {
    if (nomeClinica == null || nomeClinica.isEmpty()) {
      throw new IllegalArgumentException(
        "O nome da clínica deve ser informado."
      );
    }
    return atendimentoRepository.findByClinicaNomeClinica(nomeClinica);
  }
}
