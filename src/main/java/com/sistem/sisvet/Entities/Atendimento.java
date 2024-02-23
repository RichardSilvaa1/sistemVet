package com.sistem.sisvet.Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.sistem.sisvet.Entities.Enums.FormaPagamento;
import com.sistem.sisvet.Entities.Enums.Turno;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "atendimentos")
public class Atendimento implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "clinica_id")
  private Clinica clinica;

  @Column(nullable = true)
  private String paciente;

  @Column(nullable = false)
  private LocalDateTime dataAtendimento;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private FormaPagamento formaPagamento;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Turno turno;

  @Column(nullable = false)
  private BigDecimal totalAtendimento;

  @Column(nullable = false)
  private BigDecimal totalVet;

  @OneToMany(mappedBy = "atendimento", cascade = CascadeType.ALL)
  private List<Exame> exames;

  public Atendimento() {}

  public Atendimento(
    Long id,
    Clinica clinica,
    String paciente,
    LocalDateTime dataAtendimento,
    FormaPagamento formaPagamento,
    Turno turno,
    BigDecimal totalAtendimento,
    BigDecimal totalVet,
    List<Exame> exames
  ) {
    this.id = id;
    this.clinica = clinica;
    this.paciente = paciente;
    this.dataAtendimento = dataAtendimento;
    this.formaPagamento = formaPagamento;
    this.turno = turno;
    this.totalAtendimento = totalAtendimento;
    this.totalVet = totalVet;
    this.exames = exames;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Clinica getClinica() {
    return clinica;
  }

  public void setClinica(Clinica clinica) {
    this.clinica = clinica;
  }

  public String getPaciente() {
    return paciente;
  }

  public void setPaciente(String paciente) {
    this.paciente = paciente;
  }

  public LocalDateTime getDataAtendimento() {
    return dataAtendimento;
  }

  public void setDataAtendimento(LocalDateTime dataAtendimento) {
    this.dataAtendimento = dataAtendimento;
  }

  public FormaPagamento getFormaPagamento() {
    return formaPagamento;
  }

  public void setFormaPagamento(FormaPagamento formaPagamento) {
    this.formaPagamento = formaPagamento;
  }

  public Turno getTurno() {
    return turno;
  }

  public void setTurno(Turno turno) {
    this.turno = turno;
  }

  public BigDecimal getTotalAtendimento() {
    return totalAtendimento;
  }

  public void setTotalAtendimento(BigDecimal totalAtendimento) {
    this.totalAtendimento = totalAtendimento;
  }

  public BigDecimal getTotalVet() {
    return totalVet;
  }

  public void setTotalVet(BigDecimal totalVet) {
    this.totalVet = totalVet;
  }

  public List<Exame> getExames() {
    return exames;
  }

  public void setExames(List<Exame> exames) {
    this.exames = exames;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  


  @Override
  public String toString() {
    return "Atendimento [clinica=" + clinica + ", paciente=" + paciente + ", dataAtendimento=" + dataAtendimento
        + ", formaPagamento=" + formaPagamento + ", turno=" + turno + "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Atendimento other = (Atendimento) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    return true;
  }
}
