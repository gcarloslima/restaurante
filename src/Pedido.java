import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Pedido {
    private int numPedido;
    private Map<Item, Integer> itens;
    private Cliente cliente;
    private static int qtdPedidos = 0;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new HashMap<Item, Integer>();
        this.numPedido = ++qtdPedidos;
    }

    public void adicionarItem(Item item, int quantidade) {
        if (itens.containsKey(item)) {
            itens.put(item, itens.get(item) + quantidade);
        } else {
            itens.put(item, quantidade);
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Item item : itens.keySet()) {
            total += item.preco * itens.get(item);
        }
        return total;
    }

    public String imprimirPedido() {
        StringJoiner listaPedidos = new StringJoiner("\n");
        listaPedidos.add(
                String.format("======================= PEDIDO %d =======================\n", numPedido) +
                        "Cliente: " + cliente.nome +
                        "\nMesa: " + cliente.numeroMesa +
                        "\nCPF: " + cliente.cpf +
                        "\n--------------------------------------------------------");

        for (Item item : itens.keySet()) {
            listaPedidos.add(String.format("%s - R$ %.2f x %d ................... R$ %.2f", item.nome, item.preco, itens.get(item),
                    itens.get(item) * item.preco));
        }
        listaPedidos.add(
                "--------------------------------------------------------" +
                        String.format("\nTotal: R$ %.2f", calcularTotal()) +
                        "\n========================================================\n\n");

        return listaPedidos.toString();
    }
}
