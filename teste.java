/ Verifica se o turno é "plantão":
if (atendimento.getTurno() == Turno.PLANTAO) {
    // Desconto específico para plantão (110 unidades):
    valorTotal = valorTotal.subtract(BigDecimal.valueOf(descontoPlantaoSound));
} else {