import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Restaurante {

    static List<Item> menu = new ArrayList<>();
    static List<Funcionario> funcionarios = new ArrayList<>();
    static List<Cliente> clientes = new ArrayList<>();
    static List<Pedido> pedidos = new ArrayList<>();
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        menu.add(new Item("Smash Burger", 24.90));
        menu.add(new Item("Batata Frita", 18.90));
        menu.add(new Item("Coca-Cola", 4.00));
        menu.add(new Item("Sorvete", 8.00));
        menu.add(new Item("Suco", 6.00));
        menu.add(new Item("Água", 3.50));

        clientes.add(new Cliente("Sebastião", 10, "123.456.789-00"));
        clientes.add(new Cliente("Ivete Sangalo", 11, "987.654.321-00"));

        funcionarios.add(new Funcionario("Coxinha", "Cozinheiro", 2000.00));
        funcionarios.add(new Funcionario("Doquinha", "Atendente", 1200.00));

        pedidos.add(new Pedido(clientes.get(0)));

        pedidos.get(0).adicionarItem(menu.get(0), 2);
        pedidos.get(0).adicionarItem(menu.get(0), 2);
        pedidos.get(0).adicionarItem(menu.get(1), 1);
        pedidos.get(0).adicionarItem(menu.get(2), 1);
        pedidos.get(0).adicionarItem(menu.get(3), 1);

        pedidos.add(new Pedido(clientes.get(1)));
        pedidos.get(1).adicionarItem(menu.get(4), 2);
        pedidos.get(1).adicionarItem(menu.get(5), 1);

        menu();
    }

    public static void menu() {
        int opcao;

        do {
            System.out.println(
                    "\nAdministração Paia Burger and Grill\n\n" +
                            "1 - Exibir Cardápio\n" +
                            "2 - Manejar funcionários\n" +
                            "3 - Manejar itens\n" +
                            "4 - Manejar pedidos\n" +
                            "5 - Manejar clientes\n" +
                            "6 - Sair\n");

            opcao = s.nextInt();
            s.nextLine();

            switch (opcao) {
                case 1:
                    exibirCardapio();
                    break;
                case 2:
                    manejarFuncionarios();
                    break;
                case 3:
                    manejarItens();
                    break;
                case 4:
                    manejarPedidos();
                    break;
                case 5:
                    manejarClientes();
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 6);

    }

    public static void exibirCardapio() {
        String cardapio = "\n========== Paia's Burger ==========\n\n";
        for (Item item : menu) {
            cardapio += String.format("%s .......... R$ %.2f\n", item.nome, item.preco);
        }
        System.out.println(cardapio);
    }

    public static void manejarFuncionarios() {
        int opcao;

        do {
            System.out.println(
                    "\n========= Manejar funcionários =========\n\n" +
                            "1 - Cadastrar funcionário\n" +
                            "2 - Listar funcionários\n" +
                            "3 - Demitir funcionário\n" +
                            "4 - Voltar\n\n" +
                            "========================================\n");
            opcao = s.nextInt();
            s.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    demitirFuncionario();
                    break;
            }

        } while (opcao != 4);
    }

    public static void cadastrarFuncionario() {
        System.out.println("Digite o nome do funcionário");
        String nome = s.nextLine();
        System.out.println("Digite o cargo do funcionário");
        String funcao = s.nextLine();
        System.out.println("Digite o salário do funcionário");
        try {
            double salario = s.nextDouble();
            s.nextLine();
            funcionarios.add(new Funcionario(nome, funcao, salario));
        } catch (Exception e) {
            System.out.println("Erro ao ler salário. Certifique-se de inserir um número válido.");
        }
    }

    public static void listarFuncionarios() {
        String listaFuncionarios = "Relação de funcionários\n\n";
        for (Funcionario funcionario : funcionarios) {
            listaFuncionarios += funcionario.nome + "\n" + funcionario.funcao + "\nR$ " + funcionario.salario
                    + "\n------------------\n";
        }
        System.out.println(listaFuncionarios);
    }

    public static void demitirFuncionario() {
        System.out.println("Digite o nome do funcionário");
        String nome = s.nextLine();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.nome.equals(nome)) {
                funcionarios.remove(funcionario);
                break;
            }
        }
    }

    public static void manejarItens() {

        int opcao;

        do {
            System.out.println(
                    "\n========= Manejar itens =========\n\n" +
                            "1 - Adicionar item\n" +
                            "2 - Remover item\n" +
                            "3 - Alterar preço\n" +
                            "4 - Mostrar itens\n" +
                            "5 - Voltar\n\n" +
                            "==================================\n");
            opcao = s.nextInt();
            s.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do item");
                    String nome = s.nextLine();
                    System.out.println("Digite o preço do item");
                    try {
                        double preco = s.nextDouble();
                        s.nextLine();
                        if (preco <= 0) {
                            throw new Exception("Preço inválido");
                        } else if (preco > 1000) {
                            throw new Exception("Preço muito alto");
                        }
                        
                        menu.add(new Item(nome, preco));

                    } catch(InputMismatchException ime) {
                        System.out.println("Erro ao ler preço. Certifique-se de inserir um número válido.");
                        s.nextLine();
                    }
                    
                    catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    removerItem();
                    break;
                case 3:
                    alterarPreco();
                    break;
                case 4:
                    exibirCardapio();
                    break;
            }

        } while (opcao != 5);
    }

    public static void removerItem() {
        System.out.println("Digite o nome do item");
        String nome = s.nextLine();
        for (Item item : menu) {
            if (item.nome.equals(nome)) {
                menu.remove(item);
                break;
            }
        }
    }

    public static void alterarPreco() {
        System.out.println("Digite o nome do item");
        String nome = s.nextLine();
        boolean itemEncontrado = false;
        int posicaoParaAlterar = 0;
        try {
            for (int i = 0; i < menu.size(); i++) {
                if (menu.get(i).nome.equals(nome)) {
                    posicaoParaAlterar = i;
                    itemEncontrado = true;
                    break;
                }
            }
            if (!itemEncontrado) {
                throw new Exception("Item não encontrado");
            }
            System.out.println("Digite o novo preço do item");
            double novoPreco = s.nextDouble();
            s.nextLine();
            if (novoPreco <= 0) {
                throw new Exception("Preço inválido");
            } else if (novoPreco > 1000) {
                throw new Exception("Preço muito alto");
            }
            menu.get(posicaoParaAlterar).preco = novoPreco;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void manejarPedidos() {
        int opcao;

        do {
            System.out.println(
                    "\n========= Manejar pedidos =========\n\n" +
                            "1 - Cadastrar pedido\n" +
                            "2 - Listar pedidos\n" +
                            "3 - Voltar\n\n" +
                            "===================================\n");
            opcao = s.nextInt();
            s.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarPedido();
                    break;
                case 2:
                    listarPedidos();
                    break;
            }

        } while (opcao != 3);
    }

    public static void cadastrarPedido() {
        System.out.println("Digite o nome do cliente");
        String nome = s.nextLine();
        System.out.println("Digite o número mesa do cliente");
        int numeroMesa = s.nextInt();
        s.nextLine();
        System.out.println("Digite o CPF do cliente");
        String cpf = s.nextLine();
        clientes.add(new Cliente(nome, numeroMesa, cpf));
        pedidos.add(new Pedido(clientes.get(clientes.size() - 1)));
        int opcao;
        do {
            System.out.println(
                    "1 - Adicionar item\n" +
                            "2 - Finalizar pedido\n");
            opcao = s.nextInt();
            s.nextLine();
            switch (opcao) {
                case 1:
                    try {
                        adicionarItem();
                    } catch (ItemNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    break;
            }
        } while (opcao != 2);
    }

    public static void listarPedidos() {
        String listaPedidos = "Lista de pedidos\n\n";
        Double total = 0.0;
        for (Pedido pedido : pedidos) {
            listaPedidos += pedido.imprimirPedido();
            total += pedido.calcularTotal();
        }
        listaPedidos += "Total de vendas: R$ " + total;
        System.out.println(listaPedidos);
    }

    public static void adicionarItem() throws ItemNotFoundException {

        System.out.println("Digite o nome do item");
        String nome = s.nextLine();

        System.out.println("Digite a quantidade do item");
        int quantidade = s.nextInt();
        s.nextLine();
        boolean ItemEncontrado = false;
        for (Item item : menu) {
            if (item.nome.equals(nome)) {
                pedidos.get(pedidos.size() - 1).adicionarItem(item, quantidade);
                ItemEncontrado = true;
            }
        }
        if (!ItemEncontrado) {
            throw new ItemNotFoundException("Item não encontrado");
        }
    }

    public static void manejarClientes() {
        int opcao;

        do {
            System.out.println(
                    "\n========= Manejar clientes =========\n\n" +
                            "1 - Cadastrar cliente\n" +
                            "2 - Listar clientes\n" +
                            "3 - Voltar\n\n" +
                            "====================================\n");
            opcao = s.nextInt();
            s.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
            }

        } while (opcao != 3);
    }

    public static void cadastrarCliente() {
        System.out.println("Digite o nome do cliente");
        String nome = s.nextLine();
        System.out.println("Digite a mesa do cliente");
        int numeroMesa = s.nextInt();
        s.nextLine();
        System.out.println("Digite o CPF do cliente");
        String cpf = s.nextLine();
        clientes.add(new Cliente(nome, numeroMesa, cpf));
    }

    public static void listarClientes() {
        String listaClientes = "Lista de clientes\n\n";
        for (Cliente cliente : clientes) {
            listaClientes += cliente.nome + " - " + cliente.cpf + "\n";
        }
        System.out.println(listaClientes);
    }

}
