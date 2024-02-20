// Pacote onde está localizado o repositório
package com.sistem.sisvet.Repositories;

// Importação da interface JpaRepository do Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;

import com.sistem.sisvet.Entities.Enums.FormaPagamento;

// Declaração da interface FormaPagamentoRepository que estende JpaRepository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
    // Nenhum método adicional é necessário aqui, pois JpaRepository fornece métodos CRUD padrão
    // A interface JpaRepository já inclui métodos como save(), findById(), deleteById(), findAll(), etc.
    // A interface JpaRepository é parametrizada com dois tipos:
    // - O primeiro tipo (FormaPagamento) é a entidade que o repositório manipula.
    // - O segundo tipo (Long) é o tipo do identificador da entidade.
}
