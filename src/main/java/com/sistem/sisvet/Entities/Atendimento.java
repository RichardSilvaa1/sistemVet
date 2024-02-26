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

  @OneToMany(mappedBy = "atendimento", cascade = CascadeType.ALL)
  private List<Exame> exames;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private FormaPagamento formaPagamento;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Turno turno;

  @Column(nullable = false)
  private BigDecimal totalAtendimento;

  @Column(nullable = false)
  private BigDecimal totalNf; // Novo campo para armazenar o valor do descontoNF

  @Column(nullable = false)
  private BigDecimal totalSound; // Novo campo para armazenar o valor do descontoSound

  @Column(nullable = false)
  private BigDecimal totalVet;

  public Atendimento(
    Long id,
    Clinica clinica,
    String paciente,
    LocalDateTime dataAtendimento,
    List<Exame> exames,
    FormaPagamento formaPagamento,
    Turno turno,
    BigDecimal totalAtendimento,
    BigDecimal totalNf,
    BigDecimal totalSound,
    BigDecimal totalVet
  ) {
    this.id = id;
    this.clinica = clinica;
    this.paciente = paciente;
    this.dataAtendimento = dataAtendimento;
    this.exames = exames;
    this.formaPagamento = formaPagamento;
    this.turno = turno;
    this.totalAtendimento = totalAtendimento;
    this.totalNf = totalNf;
    this.totalSound = totalSound;
    this.totalVet = totalVet;
  }

  public Atendimento() {}

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

  public List<Exame> getExames() {
    return exames;
  }

  public void setExames(List<Exame> exames) {
    this.exames = exames;
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

  public BigDecimal getTotalNf() {
    return totalNf;
  }

  public void setTotalNf(BigDecimal totalNf) {
    this.totalNf = totalNf;
  }

  public BigDecimal getTotalSound() {
    return totalSound;
  }

  public void setTotalSound(BigDecimal totalSound) {
    this.totalSound = totalSound;
  }

  public BigDecimal getTotalVet() {
    return totalVet;
  }

  public void setTotalVet(BigDecimal totalVet) {
    this.totalVet = totalVet;
  }

  @Override
  public String toString() {
    return (
      "Atendimento [clinica=" +
      clinica +
      ", paciente=" +
      paciente +
      ", dataAtendimento=" +
      dataAtendimento +
      ", formaPagamento=" +
      formaPagamento +
      ", turno=" +
      turno +
      "]"
    );
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
