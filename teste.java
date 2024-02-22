import com.sistem.sisvet.Entities.Atendimento;
import com.sistem.sisvet.Entities.Exame;

@Service
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;

    public AtendimentoService(AtendimentoRepository atendimentoRepository) {
        this.atendimentoRepository = atendimentoRepository;
    }

    public List<Atendimento> getAllAtendimentos() {
        return atendimentoRepository.findAll();
    }

    public Atendimento getAtendimentoById(Long id) {
        return atendimentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Atendimento não encontrado com o ID: " + id));
    }

    public Atendimento saveAtendimento(Atendimento atendimento) {
        validarAtendimento(atendimento);
        atendimento.setValorTotalAtendimento(calcularValorTotalAtendimento(atendimento));
        atendimento.setValorTotalVeterinarioRecebe(calcularValorVeterinarioRecebe(atendimento));
        return atendimentoRepository.save(atendimento);
    }

    public Atendimento updateAtendimento(Long id, Atendimento atendimentoDetails) {
        Atendimento atendimento = getAtendimentoById(id);
        validarAtendimento(atendimentoDetails);
        atendimento.setPaciente(atendimentoDetails.getPaciente());
        atendimento.setData(atendimentoDetails.getData());
        atendimento.setClinica(atendimentoDetails.getClinica());
        atendimento.setTurno(atendimentoDetails.getTurno());
        atendimento.setExames(atendimentoDetails.getExames());
        atendimento.setFormaPagamento(atendimentoDetails.getFormaPagamento());
        atendimento.setValorTotalAtendimento(calcularValorTotalAtendimento(atendimento));
        atendimento.setValorTotalVeterinarioRecebe(calcularValorVeterinarioRecebe(atendimento));
        return atendimentoRepository.save(atendimento);
    }

    public void deleteAtendimento(Long id) {
        atendimentoRepository.deleteById(id);
    }

    private void validarAtendimento(Atendimento atendimento) {
        if (atendimento.getPaciente() == null || atendimento.getPaciente().isEmpty()) {
            throw new BadRequestException("Paciente não pode ser nulo ou vazio");
        }
        if (atendimento.getData() == null) {
            throw new BadRequestException("Data não pode ser nula");
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

    public double calcularValorTotalAtendimento(Atendimento atendimento) {
        double valorTotal = 0;
        for (Exame exame : atendimento.getExames()) {
            valorTotal += exame.getValorExame();
        }
        atendimento.setValorTotalAtendimento(valorTotal);
        return valorTotal;
    }
    

    public double calcularValorVeterinarioRecebe(Atendimento atendimento) {
        double valorTotal =  0;
        for(Exame exame : atendimento.getExames()){
            valorTotal  += exame.getValorExameVet();
        }
            atendimento.
    }
}
