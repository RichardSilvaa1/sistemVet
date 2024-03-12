package com.sistem.sisvet.Entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // entidade
@Table(name = "clinica") // nome da tabela
public class Clinica implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // identificando a geraçao de chaves primarias
  private Long id;

  @Column(nullable = false) // cria uma coluna e especifica que nao pode ter valores nulls
  private String nomeClinica;

  public Clinica(){
    
  }

  public Clinica(Long id, String nomeClinica) {
    this.id = id;
    this.nomeClinica = nomeClinica;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNomeClinica() {
    return nomeClinica;
  }

  public void setNomeClinica(String nomeClinica) {
    this.nomeClinica = nomeClinica;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result =
      prime * result + ((nomeClinica == null) ? 0 : nomeClinica.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Clinica other = (Clinica) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    if (nomeClinica == null) {
      if (other.nomeClinica != null) return false;
    } else if (!nomeClinica.equals(other.nomeClinica)) return false;
    return true;
  }
}
