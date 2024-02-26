package com.sistem.sisvet.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.sistem.sisvet.Entities.Atendimento;

@Service
public class ComissaoVerinarioService {

    /**
     * Calcula o valor que o veterinário recebe pelo atendimento,
     * considerando a forma de pagamento e aplicando os descontos
     * da Nota Fiscal e da Sound.
     *
     * @param atendimento O atendimento realizado.
     * @return O valor que o veterinário recebe.
     */
    public BigDecimal calcularValorVeterinarioRecebe(Atendimento atendimento) {

        // Obtém o valor total do atendimento.
        BigDecimal valorTotal = atendimento.getTotalAtendimento();

        // Define as taxas de desconto.
        double descontoNf = 0.18; // 18%
        double descontoSound = 0.15; // 15%

        // Inicializa os valores de desconto.
        BigDecimal descontoNfValor = BigDecimal.ZERO;
        BigDecimal descontoSoundValor = BigDecimal.ZERO;

        // Calcula os descontos de acordo com a forma de pagamento.
        switch (atendimento.getFormaPagamento()) {
            case CADERNO:
            case PIX_VET:
            case NO_FARO:
                // Desconto da Nota Fiscal e Sound.
                descontoNfValor = valorTotal.multiply(BigDecimal.valueOf(descontoNf)).setScale(2, RoundingMode.HALF_UP);
                descontoSoundValor = valorTotal.multiply(BigDecimal.valueOf(descontoSound)).setScale(2, RoundingMode.HALF_UP);
                valorTotal = valorTotal.subtract(descontoNfValor);
                valorTotal = valorTotal.subtract(descontoSoundValor);
                break;
            case DINHEIRO:
            case CARTAO:
            case PIX:
                // Desconto apenas da Sound.
                descontoSoundValor = valorTotal.multiply(BigDecimal.valueOf(descontoSound)).setScale(2, RoundingMode.HALF_UP);
                valorTotal = valorTotal.subtract(descontoSoundValor);
                break;
        }

        // Armazena os valores de desconto no atendimento.
        atendimento.setTotalNf(descontoNfValor);
        atendimento.setTotalSound(descontoSoundValor);
        atendimento.setTotalVet(valorTotal);

        // Retorna o valor que o veterinário recebe.
        return atendimento.getTotalVet();
    }
}
