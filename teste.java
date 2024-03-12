@Configuration
@Profile("teste")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Autowired
    private ExameRepository exameRepository;

    // Este método é executado quando a aplicação é iniciada
    @Override
    public void run(String... args) throws Exception {
        // Criando uma clínica
        Clinica clinica = new Clinica();
        clinica.setNome("Clinica de Teste");
        clinica.setEndereco("Endereço de Teste");
        clinica.setTelefone("123456789");

        clinicaRepository.save(clinica);

        // Criando um exame
        Exame exame = new Exame();
        exame.setNome("Exame de Teste");
        exame.setDescricao("Descrição do exame de teste");

        exameRepository.save(exame);

        // Criando um atendimento
        Atendimento atendimento = new Atendimento();
        atendimento.setClinica(clinica);
        atendimento.setPaciente("Paciente de Teste");
        atendimento.setDataAtendimento(LocalDateTime.now());
        atendimento.setFormaPagamento(FormaPagamento.DINHEIRO);
        atendimento.setTurno(Turno.MANHA);
        atendimento.setTotalAtendimento(BigDecimal.valueOf(100.0));
        atendimento.setTotalNf(BigDecimal.valueOf(100.0));
        atendimento.setTotalSound(BigDecimal.valueOf(0.0));
        atendimento.setAluguelAparelho(BigDecimal.valueOf(0.0));
        atendimento.setTotalVet(BigDecimal.valueOf(100.0));

        // Adicionando o exame ao atendimento
        List<Exame> exames = new ArrayList<>();
        exames.add(exame);
        atendimento.setExames(exames);

        atendimentoRepository.save(atendimento);
    }
}


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;
    
    // Este método é executado quando a aplicação é iniciada
    @Override
    public void run(String... args) throws Exception {
        // Criando algumas categorias
        Category cat1 = new Category(null, "Eletrônicos");
        Category cat2 = new Category(null, "Livros");
        Category cat3 = new Category(null, "Computadores");
        
        // Criando alguns produtos
        Product p1 = new Product(null, "O Senhor dos Anéis", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails para Leigos", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        // Salvando categorias e produtos no banco de dados
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        // Adicionando categorias aos produtos e salvando-os novamente
        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        // Criando alguns usuários e pedidos
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        // Salvando usuários e pedidos
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        
        // Criando itens de pedido
        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        // Salvando itens de pedido
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));    
        
        // Criando um pagamento e associando-o a um pedido
        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
        o1.setPayment(pay1);

        // Salvando o pedido novamente
        orderRepository.save(o1);
    }
}
