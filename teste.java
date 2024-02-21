@Entity // Esta anotação marca a classe como uma entidade JPA, ou seja, ela será mapeada para uma tabela no banco de dados.
@Table(name = "atendimentos") // Esta anotação especifica o nome da tabela no banco de dados. Por padrão, o nome da tabela seria o mesmo que o nome da classe.
public class Atendimento {

    @Id // Esta anotação marca o campo como a chave primária da entidade.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esta anotação especifica a estratégia de geração de valor para a chave primária. Neste caso, estamos usando a identidade do banco de dados para gerar valores automáticos.
    private Long id;

    @Column(nullable = false) // Esta anotação especifica que a coluna no banco de dados não pode ter valores nulos.
    private String paciente;

    @Column(nullable = false) // Esta anotação especifica que a coluna no banco de dados não pode ter valores nulos.
    private LocalDateTime data;

    @ManyToOne(fetch = FetchType.LAZY) // Esta anotação especifica o relacionamento muitos-para-um com a entidade Clinica. O FetchType.LAZY indica que a consulta para esta relação será adiada até que seja acessada.
    @JoinColumn(name = "clinica_id") // Esta anotação especifica a coluna na tabela do banco de dados que mantém a chave estrangeira para a entidade Clinica.
    private Clinica clinica;

    @OneToMany(mappedBy = "atendimento", cascade = CascadeType.ALL) // Esta anotação especifica o relacionamento um-para-muitos com a entidade Exame. O atributo mappedBy indica o nome do atributo na classe Exame que mapeia esta relação. CascadeType.ALL especifica que todas as operações de persistência (persistir, remover, atualizar, mesclar) feitas na entidade Atendimento também devem ser aplicadas na entidade Exame relacionada.
    private List<Exame> exames;

    @Enumerated(EnumType.STRING) // Esta anotação especifica que o campo representa uma enumeração, e o tipo de enumeração é armazenado como uma string no banco de dados.
    @Column(nullable = false) // Esta anotação especifica que a coluna no banco de dados não pode ter valores nulos.
    private FormaPagamento formaPagamento;

    @Column(nullable = false) // Esta anotação especifica que a coluna no banco de dados não pode ter valores nulos.
    private Double valorTotalAtendimento;

    @Column(nullable = false) // Esta anotação especifica que a coluna no banco de dados não pode ter valores nulos.
    private Double valorTotalVeterinarioRecebe;

    // Getters e setters
}



// Anotação que indica que a classe é uma entidade JPA.
@Entity
public class Atendimento {

    // Anotação que indica que o atributo é a chave primária da entidade.
    // Estrategia de geração da chave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Anotação que indica uma relação de muitos para um com a classe Clinica.
    @ManyToOne
    private Clinica clinica;

    // Anotação que indica uma relação de muitos para um com a classe Paciente.
    @ManyToOne
    private Paciente paciente;

    // ...

    // Anotação que indica uma relação de um para muitos com a classe Exame.
    // O atributo "atendimento" em Exame é mapeado por essa anotação.
    @OneToMany(mappedBy = "atendimento")
    private List<Exame> exames;
}
