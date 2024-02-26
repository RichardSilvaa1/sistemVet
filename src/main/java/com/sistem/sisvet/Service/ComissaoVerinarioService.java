package com.sistem.sisvet.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.sistem.sisvet.Entities.Atendimento;
import com.sistem.sisvet.Entities.Enums.FormaPagamento;

@Service
public class ComissaoVerinarioService {

    public BigDecimal calcularValorVeterinarioRecebe(Atendimento atendimento) {
        BigDecimal valorTotal = atendimento.getTotalAtendimento();
        double descontoNf = 0.18;
        double descontoSound = 0.15;
        BigDecimal descontoNfValor = BigDecimal.ZERO;
        BigDecimal descontoSoundValor = BigDecimal.ZERO;

        if (atendimento.getFormaPagamento() == FormaPagamento.CADERNO ||
            atendimento.getFormaPagamento() == FormaPagamento.PIX_VET ||
            atendimento.getFormaPagamento() == FormaPagamento.NO_FARO) {
            descontoNfValor = valorTotal.multiply(BigDecimal.valueOf(descontoNf)).setScale(2, RoundingMode.HALF_UP);
            descontoSoundValor = valorTotal.multiply(BigDecimal.valueOf(descontoSound)).setScale(2, RoundingMode.HALF_UP);
            valorTotal = valorTotal.subtract(descontoNfValor);
            valorTotal = valorTotal.subtract(descontoSoundValor);
        } else if (atendimento.getFormaPagamento() == FormaPagamento.DINHEIRO ||
                   atendimento.getFormaPagamento() == FormaPagamento.CARTAO) {
            descontoSoundValor = valorTotal.multiply(BigDecimal.valueOf(descontoSound)).setScale(2, RoundingMode.HALF_UP);
            valorTotal = valorTotal.subtract(descontoSoundValor);
        } else {
            valorTotal = valorTotal.multiply(BigDecimal.valueOf(1 - (descontoNf + descontoSound))).setScale(2, RoundingMode.HALF_UP);
        }

        atendimento.setTotalNf(descontoNfValor);
        atendimento.setTotalSound(descontoSoundValor);
        atendimento.setTotalVet(valorTotal);

        return atendimento.getTotalVet();
    }
}
