package com.sistem.sisvet.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.sistem.sisvet.Entities.Enums.Turno;

@Service
public class ComissaoVeterinarioService {

  /**
   * Calcula o valor que o veterinário recebe pelo atendimento,
   * considerando a forma de pagamento e aplicando os descontos
   * da Nota Fiscal, da Sound e do aluguel do aparelho.
   */
  public BigDecimal calcularValorVeterinarioRecebe(
    com.sistem.sisvet.Entities.Atendimento atendimento
  ) {
    BigDecimal valorTotal = atendimento.getTotalAtendimento(); // Obtém o valor total do atendimento.

    // Taxas de desconto
    final double descontoNf = 0.18; // 18%
    final double descontoSound = 0.15; // 15%
    final double descontoAparelhoComercial = 30;
    final double descontoAparelhoPlantao = 48;
    final double descontoAparelhoSabado = 38;
    final double descontoPlantaoSound = 110;

    // Inicializa os valores de desconto.
    BigDecimal descontoNfValor = BigDecimal.ZERO;
    BigDecimal descontoSoundValor = BigDecimal.ZERO;
    BigDecimal descontoAparelhoValor = BigDecimal.ZERO; // Variável para armazenar o desconto do aparelho

    if (atendimento.getTurno() == Turno.PLANTAO) {
      // desconta o valor do plantao de 110.00
      valorTotal =
        valorTotal.subtract(BigDecimal.valueOf(descontoPlantaoSound));
    } else {
      switch (atendimento.getFormaPagamento()) {
        // Caso a forma de pagamento seja CADERNO, PIX_VET ou NO_FARO:
        case CADERNO:
        case PIX_VET:
        case NO_FARO:
          // Calcula o desconto da Nota Fiscal (NF) multiplicando o valor total pelo desconto correspondente e arredondando para duas casas decimais.
          descontoNfValor =
            valorTotal
              .multiply(BigDecimal.valueOf(descontoNf))
              .setScale(2, RoundingMode.HALF_UP);
          // Calcula o desconto da Sound multiplicando o valor total pelo desconto correspondente e arredondando para duas casas decimais.
          descontoSoundValor =
            valorTotal
              .multiply(BigDecimal.valueOf(descontoSound))
              .setScale(2, RoundingMode.HALF_UP);
          // Subtrai o desconto da Nota Fiscal do valor total.
          valorTotal = valorTotal.subtract(descontoNfValor);
          // Subtrai o desconto da Sound do valor total.
          valorTotal = valorTotal.subtract(descontoSoundValor);
          break;
        // Caso a forma de pagamento seja DINHEIRO, CARTAO ou PIX:
        case DINHEIRO:
        case CARTAO:
        case PIX:
          // Calcula o desconto da Sound multiplicando o valor total pelo desconto correspondente e arredondando para duas casas decimais.
          descontoSoundValor =
            valorTotal
              .multiply(BigDecimal.valueOf(descontoSound))
              .setScale(2, RoundingMode.HALF_UP);
          // Subtrai o desconto da Sound do valor total.
          valorTotal = valorTotal.subtract(descontoSoundValor);
          break;
      }
    }

    // Calcula o desconto do aparelho conforme o turno.
    switch (atendimento.getTurno()) {
      case PLANTAO:
      case PLANTAO_MEIA_NOITE:
        // Desconto do aluguel do aparelho para plantão.
        descontoAparelhoValor = BigDecimal.valueOf(descontoAparelhoPlantao);
        valorTotal = valorTotal.subtract(descontoAparelhoValor);
        break;
      case COMERCIAL:
        descontoAparelhoValor = BigDecimal.valueOf(descontoAparelhoComercial);
        valorTotal = valorTotal.subtract(descontoAparelhoValor);
        break;
      case SABADO:
        descontoAparelhoValor = BigDecimal.valueOf(descontoAparelhoSabado);
        valorTotal = valorTotal.subtract(descontoAparelhoValor);
        break;
    }

    // Armazena os valores de desconto no objeto Atendimento.
    atendimento.setTotalNf(descontoNfValor);
    atendimento.setTotalSound(descontoSoundValor);
    atendimento.setAluguelAparelho(descontoAparelhoValor); // Armazena o valor do desconto do aparelho

    // Define o valor total que o veterinário recebe após os descontos.
    atendimento.setTotalVet(valorTotal);

    // Retorna o valor que o veterinário recebe.
    return atendimento.getTotalVet();
  }
}
