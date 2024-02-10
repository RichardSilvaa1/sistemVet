// Pacote onde está localizado o repositório
package com.sistem.sisvet.Repositories;

// Importação da interface JpaRepository do Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;

// Importação da entidade Exame
import com.sistem.sisvet.Entities.Exame;

// Declaração da interface ExameRepository que estende JpaRepository
public interface ExameRepository extends JpaRepository<Exame, Long> {
    // Nenhum método adicional é necessário aqui, pois JpaRepository fornece métodos CRUD padrão
    // A interface JpaRepository já inclui métodos como save(), findById(), deleteById(), findAll(), etc.
    // A interface JpaRepository é parametrizada com dois tipos:
    // - O primeiro tipo (Exame) é a entidade que o repositório manipula.
    // - O segundo tipo (Long) é o tipo do identificador da entidade.
}
