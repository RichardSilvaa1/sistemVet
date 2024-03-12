package com.sistem.sisvet.Config;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sistem.sisvet.Entities.Atendimento;
import com.sistem.sisvet.Entities.Clinica;
import com.sistem.sisvet.Entities.Exame;
import com.sistem.sisvet.Entities.Enums.FormaPagamento;
import com.sistem.sisvet.Entities.Enums.Turno;
import com.sistem.sisvet.Repositories.AtendimentoRepository;
import com.sistem.sisvet.Repositories.ClinicaRepository;
import com.sistem.sisvet.Repositories.ExameRepository;
import com.sistem.sisvet.Service.AtendimentoService;
import com.sistem.sisvet.Service.ComissaoVeterinarioService;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Autowired
    private ExameRepository exameRepository;

    @Autowired
    private AtendimentoService atendimentoService;

    @Autowired
    private ComissaoVeterinarioService comissaoVeterinarioService;

    @Override
    public void run(String... args) throws Exception {
        // Criando uma clínica...
        Clinica clinica = new Clinica(null, "Volpe");
        clinicaRepository.save(clinica);

        // Criando um exame...
        Exame exame = new Exame(null, "Us abdominal", BigDecimal.valueOf(170.0), null);
        exameRepository.save(exame);

        // Criando um atendimento...
        Atendimento atendimento = new Atendimento();
        atendimento.setId(null);
        atendimento.setClinica(clinica);
        atendimento.setPaciente("Paciente teste");
        atendimento.setDataAtendimento(LocalDateTime.now());
        atendimento.setTurno(Turno.COMERCIAL);
        atendimento.setFormaPagamento(FormaPagamento.CADERNO);

        // **Inicializando a lista de exames**
        atendimento.setExames(new ArrayList<>());

        // Associando o exame ao atendimento
        List<Exame> exames = atendimento.getExames();
        exames.add(exame);

        // Calculando o valor total do atendimento
        BigDecimal valorTotalAtendimento = atendimentoService.calcularValorTotalAtendimento(atendimento);
        atendimento.setTotalAtendimento(valorTotalAtendimento);

        // Calculando os valores relacionados à comissão do veterinário
        BigDecimal totalVet = comissaoVeterinarioService.calcularValorVeterinarioRecebe(atendimento);

        // Definindo os valores no objeto Atendimento
        atendimento.setTotalNf(atendimento.getTotalNf());
        atendimento.setTotalSound(atendimento.getTotalSound());
        atendimento.setAluguelAparelho(atendimento.getAluguelAparelho());
        atendimento.setTotalVet(totalVet);

        // Salvando o atendimento no banco de dados
        atendimentoRepository.save(atendimento);
    }
}