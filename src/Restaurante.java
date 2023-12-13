import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurante {

    static List<Item> menu = new ArrayList<>();
    static List<Funcionario> funcionarios = new ArrayList<>();
    static List<Cliente> clientes = new ArrayList<>();
    static List<Pedido> pedidos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        menu.add(new Item("Coca-Cola", 5.00));
        menu.add(new Item("Hamburguer", 10.00));
        menu.add(new Item("Batata Frita", 8.00));
        menu.add(new Item("Sorvete", 7.00));
        menu.add(new Item("Suco", 6.00));
        menu.add(new Item("Água", 4.00));

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
                            "2 - Cadastrar funcionário\n" +
                            "3 - Cadastrar item\n" +
                            "4 - Cadastrar pedido\n" +
                            "5 - Listar funcionários\n" +
                            "6 - Listar clientes\n" +
                            "7 - Listar itens\n" +
                            "8 - Listar pedidos\n" +
                            "9 - Demitir funcionário\n" +
                            "10 - Sair\n");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    exibirCardapio();
                    break;
                case 2:
                    cadastrarFuncionario();
                    break;
                case 3:
                    cadastrarItem();
                    break;
                case 4:
                    cadastrarPedido();
                    break;
                case 5:
                    listarFuncionarios();
                    break;
                case 6:
                    listarClientes();
                    break;
                case 7:
                    listarItens();
                    break;
                case 8:
                    listarPedidos();
                    break;
                case 9:
                    demitirFuncionario();
                    break;
            }
        } while (opcao != 10);

    }

    public static void exibirCardapio() {
        String cardapio = "\nCardápio\n\n";
        for (Item item : menu) {
            cardapio += item.nome + " - R$ " + item.preco + "\n";
        }
        System.out.println(cardapio);
    }

    public static void cadastrarFuncionario() {
        System.out.println("Digite o nome do funcionário");
        String nome = scanner.next();
        System.out.println("Digite o cargo do funcionário");
        String cargo = scanner.next();
        System.out.println("Digite o salário do funcionário");
        try {
            double salario = scanner.nextDouble();
            funcionarios.add(new Funcionario(nome, cargo, salario));
        } catch (Exception e) {
            System.out.println("Erro ao ler salário. Certifique-se de inserir um número válido.");
            scanner.nextLine();
        }
    }

    public static void cadastrarItem() {
        System.out.println("Digite o nome do item");
        String nome = scanner.next();
        System.out.println("Digite o preço do item");
        try {
            double preco = scanner.nextDouble();
            menu.add(new Item(nome, preco));
        } catch (Exception e) {
            System.out.println("Erro ao ler preço. Certifique-se de inserir um número válido.");
            scanner.nextLine();
        }
    }

    public static void cadastrarPedido() {
        System.out.println("Digite o nome do cliente");
        String nome = scanner.next();
        System.out.println("Digite a mesa do cliente");
        int numeroMesa = scanner.nextInt();
        System.out.println("Digite o CPF do cliente");
        String cpf = scanner.next();
        clientes.add(new Cliente(nome, numeroMesa, cpf));
        pedidos.add(new Pedido(clientes.get(clientes.size() - 1)));
        int opcao;
        do {
            System.out.println(
                    "1 - Adicionar item\n" +
                            "2 - Finalizar pedido\n");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    adicionarItem();
                    break;
                case 2:
                    break;
            }
        } while (opcao != 2);
    }

    public static void adicionarItem() {
        System.out.println("Digite o nome do item");
        String nome = scanner.next();
        System.out.println("Digite a quantidade do item");
        int quantidade = scanner.nextInt();
        for (Item item : menu) {
            if (item.nome.equals(nome)) {
                pedidos.get(pedidos.size() - 1).adicionarItem(item, quantidade);
            }
        }
    }

    public static void listarFuncionarios() {
        String listaFuncionarios = "Lista de funcionários\n\n";
        for (Funcionario funcionario : funcionarios) {
            listaFuncionarios += funcionario.nome + " - " + funcionario.funcao + " - R$ " + funcionario.salario + "\n";
        }
        System.out.println(listaFuncionarios);
    }

    public static void listarClientes() {
        String listaClientes = "Lista de clientes\n\n";
        for (Cliente cliente : clientes) {
            listaClientes += cliente.nome + " - " + cliente.cpf + "\n";
        }
        System.out.println(listaClientes);
    }

    public static void listarItens() {
        String listaItens = "Lista de itens\n\n";
        for (Item item : menu) {
            listaItens += item.nome + " - R$ " + item.preco + "\n";
        }
        System.out.println(listaItens);
    }

    public static void listarPedidos() {
        String listaPedidos = "Lista de pedidos\n\n";
        for (Pedido pedido : pedidos) {
            listaPedidos += pedido.imprimirPedido();
        }
        System.out.println(listaPedidos);
    }

    public static void demitirFuncionario() {
        System.out.println("Digite o nome do funcionário");
        String nome = scanner.next();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.nome.equals(nome)) {
                funcionarios.remove(funcionario);
                break;
            }
        }
    }
}
