package com.sistem.sisvet.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.coyote.BadRequestException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.sistem.sisvet.Entities.Atendimento;
import com.sistem.sisvet.Entities.Exame;
import com.sistem.sisvet.Exceptions.DataInvalidaException;
import com.sistem.sisvet.Repositories.AtendimentoRepository;

@Service
public class AtendimentoService {

  private final AtendimentoRepository atendimentoRepository;

  public AtendimentoService(AtendimentoRepository atendimentoRepository) {
    this.atendimentoRepository = atendimentoRepository;
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

  // Salva um novo atendimento após validar e calcular valores
  public Atendimento saveAtendimento(Atendimento atendimento)
    throws BadRequestException {
    validarAtendimento(atendimento);
    atendimento.setTotalAtendimento(calcularValorTotalAtendimento(atendimento));
    atendimento.setTotalVet(calcularValorVeterinarioRecebe(atendimento));
    return atendimentoRepository.save(atendimento);
  }

  // Atualiza um atendimento existente após validar e calcular valores
  public Atendimento updateAtendimento(Long id, Atendimento atendimentoDetails)
    throws BadRequestException {
    Atendimento atendimento = getAtendimentoById(id);
    validarAtendimento(atendimentoDetails);
    atendimento.setPaciente(atendimentoDetails.getPaciente());
    atendimento.setDataAtendimento(atendimentoDetails.getDataAtendimento());
    atendimento.setClinica(atendimentoDetails.getClinica());
    atendimento.setTurno(atendimentoDetails.getTurno());
    atendimento.setExames(atendimentoDetails.getExames());
    atendimento.setFormaPagamento(atendimentoDetails.getFormaPagamento());
    atendimento.setTotalAtendimento(calcularValorTotalAtendimento(atendimento));
    atendimento.setTotalVet(calcularValorVeterinarioRecebe(atendimento));
    return atendimentoRepository.save(atendimento);
  }

  // Deleta um atendimento pelo ID
  public void deleteAtendimento(Long id) {
    atendimentoRepository.deleteById(id);
  }

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

  public BigDecimal calcularValorTotalAtendimento(Atendimento atendimento) {
    BigDecimal valorTotal = BigDecimal.ZERO;
    for (Exame exame : atendimento.getExames()) {
      valorTotal = valorTotal.add(exame.getValorExame());
    }
    atendimento.setTotalAtendimento(valorTotal);
    return valorTotal;
  }

  public BigDecimal calcularValorVeterinarioRecebe(Atendimento atendimento) {
    BigDecimal valorTotal = BigDecimal.ZERO; // Inicializa o BigDecimal com zero
    for (Exame exame : atendimento.getExames()) {
      valorTotal = valorTotal.add(exame.getValorExameVet()); // Usa o método add para adicionar valores BigDecimal
    }
    atendimento.setTotalVet(valorTotal);
    return valorTotal;
  }

// Filtra os atendimentos por data
  public List<Atendimento> filtrarAtendimentosPorData(LocalDateTime dataInicio, LocalDateTime dataFim) {
    String dataInicioStr = dataInicio.toString(); // Converter LocalDateTime para String
    String dataFimStr = dataFim.toString(); // Converter LocalDateTime para String
    
    List<Atendimento> atendimentosFiltrados = new ArrayList<>();

    // Itera sobre todos os atendimentos do repositório
    for (Atendimento atendimento : atendimentoRepository.findAll()) {
      LocalDateTime dataAtendimento = atendimento.getDataAtendimento();
      // Verifica se a data do atendimento está dentro do intervalo especificado
      if (dataAtendimento.isAfter(dataInicio) && dataAtendimento.isBefore(dataFim)) {
        atendimentosFiltrados.add(atendimento); // Adiciona o atendimento à lista de atendimentos filtrados
      }
    }

    return atendimentosFiltrados; // Retorna a lista de atendimentos filtrados
  }

public Map<String, Long> obterQuantidadeAtendimentosPorCliente() {
        List<Atendimento> atendimentos = atendimentoRepository.findAll();
        Map<String, Long> quantidadePorCliente = new HashMap<>();

        for (Atendimento atendimento : atendimentos) {
            String cliente = atendimento.getPaciente();
            quantidadePorCliente.put(cliente, quantidadePorCliente.getOrDefault(cliente, 0L) + 1);
        }

        return quantidadePorCliente;
    }
}
