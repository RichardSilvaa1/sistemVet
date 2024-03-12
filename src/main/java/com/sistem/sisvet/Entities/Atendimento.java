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

// Entidade JPA que representa um Atendimento
@Entity
@Table(name = "atendimento")
public class Atendimento implements Serializable {

  // Identificador único do atendimento (chave primária)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // Clínica associada ao atendimento (muitos atendimentos para uma clínica)
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "clinica_id")
  private Clinica clinica;

  // Nome do paciente
  @Column(nullable = true)
  private String paciente;

  // Data e hora do atendimento
  @Column(nullable = false)
  private LocalDateTime dataAtendimento;

  // Exames relacionados ao atendimento (um atendimento pode ter vários exames)
  @OneToMany(mappedBy = "atendimento", cascade = CascadeType.ALL)
  private List<Exame> exames;

  // Forma de pagamento utilizada
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private FormaPagamento formaPagamento;

  // Turno do atendimento (manhã, tarde, noite)
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Turno turno;

  // Valor total do atendimento
  @Column(nullable = false)
  private BigDecimal totalAtendimento;

  // Valor total da nota fiscal
  @Column(nullable = false)
  private BigDecimal totalNf;

  // Valor do desconto Sound
  @Column(nullable = false)
  private BigDecimal totalSound;

  // Valor do desconto do aluguel do aparelho
  @Column(nullable = false)
  private BigDecimal aluguelAparelho;

  // Valor total pago pelo cliente
  @Column(nullable = false)
  private BigDecimal totalVet;
  public Atendimento(){
    
  }


  public Atendimento(Long id, Clinica clinica, String paciente, LocalDateTime dataAtendimento, List<Exame> exames,
      FormaPagamento formaPagamento, Turno turno, BigDecimal totalAtendimento, BigDecimal totalNf,
      BigDecimal totalSound, BigDecimal aluguelAparelho, BigDecimal totalVet) {
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
    this.aluguelAparelho = aluguelAparelho;
    this.totalVet = totalVet;
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



  public BigDecimal getAluguelAparelho() {
    return aluguelAparelho;
  }



  public void setAluguelAparelho(BigDecimal aluguelAparelho) {
    this.aluguelAparelho = aluguelAparelho;
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
