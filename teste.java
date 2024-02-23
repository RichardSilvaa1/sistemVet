// Calcula o valor que o veterinário recebe
public BigDecimal calcularValorVeterinarioRecebe(Atendimento atendimento) {
    BigDecimal valorTotal = atendimento.getTotalAtendimento();
    for (Exame exame : atendimento.getExames()) {
      valorTotal = valorTotal.add(exame.getValorExameVet());
    }
    atendimento.setTotalVet(valorTotal);
    return valorTotal;
  }