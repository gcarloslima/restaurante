import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    public static void main(String[] args) {
        List<Item> menu = new ArrayList<>();
        menu.add(new Item("Coca-Cola", 5.00));
        menu.add(new Item("Hamburguer", 10.00));
        menu.add(new Item("Batata Frita", 8.00));
        menu.add(new Item("Sorvete", 7.00));
        menu.add(new Item("Suco", 6.00));
        menu.add(new Item("Água", 4.00));
        
        Cliente cliente1 = new Cliente("Sebastião", 10, "123.456.789-00");
        Cliente cliente2 = new Cliente("Ivete Sangalo", 11, "987.654.321-00");

        Pedido pedido1 = new Pedido(cliente1);
        pedido1.adicionarItem(menu.get(0), 2);
        pedido1.adicionarItem(menu.get(1), 1);
        pedido1.adicionarItem(menu.get(2), 1);
        pedido1.adicionarItem(menu.get(3), 1);

        Pedido pedido2 = new Pedido(cliente2);
        pedido2.adicionarItem(menu.get(4), 2);
        pedido2.adicionarItem(menu.get(5), 1);
        
        System.out.println(pedido1.imprimirPedido());
        System.out.println(pedido2.imprimirPedido());
        
        Funcionario funcionario1 = new Funcionario("Coxinha", "Cozinheiro", 5000.0);
        Funcionario funcionario2 = new Funcionario("Doquinha", "Atendente", 2200.0);

    }
}
