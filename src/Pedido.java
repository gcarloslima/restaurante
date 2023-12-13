import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Pedido {
    private Map<Item, Integer> itens; // Item e quantidade
    private Cliente cliente;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new HashMap<Item, Integer>();
    }

    public void adicionarItem(Item item, int quantidade) {
        if (itens.containsKey(item)) {
            itens.put(item, itens.get(item) + quantidade);
        } else {
            itens.put(item, quantidade);
        }
    }

    // calcularTotal. Retorna o valor total do pedido.
    public double calcularTotal() {
        double total = 0;
        for (Item item : itens.keySet()) {
            total += item.preco * itens.get(item);
        }
        return total;
    }

    // imprimirPedido. Imprime todos os itens do pedido.
    public String imprimirPedido() {
        StringJoiner listaPedidos = new StringJoiner("\n");

        listaPedidos.add("Cliente: " + cliente.nome);
        listaPedidos.add("Mesa: " + cliente.numeroMesa);
        listaPedidos.add("CPF: " + cliente.cpf);
        for (Item item : itens.keySet()) {
            listaPedidos.add(item.nome + " - " + itens.get(item) + " - " + item.preco);
        }
        listaPedidos.add("Total: " + calcularTotal());
        return listaPedidos.toString();
    }

}




//     private int codigo;
//     private String descricao;
//     private int quantidade;
//     private double valorUnitario;
//     private double valorTotal;

//     public Pedido(int codigo, String descricao, int quantidade, double valorUnitario, double valorTotal) {
//         this.codigo = codigo;
//         this.descricao = descricao;
//         this.quantidade = quantidade;
//         this.valorUnitario = valorUnitario;
//         this.valorTotal = valorTotal;
//     }

//     public void imprimirPedido(){
//         System.out.println("Código: " + this.codigo);
//         System.out.println("Descrição: " + this.descricao);
//         System.out.println("Quantidade: " + this.quantidade);
//         System.out.println("Valor Unitário: " + this.valorUnitario);
//         System.out.println("Valor Total: " + this.valorTotal);
//     }

//     public double calcularTotal(){
//         return this.quantidade * this.valorUnitario;
//     }

//     public void imprimirTotal(){
//         System.out.println("Valor Total: " + this.calcularTotal());
//     }

//     public void imprimirResumo(){
//         System.out.println("Código: " + this.codigo);
//         System.out.println("Descrição: " + this.descricao);
//         System.out.println("Valor Total: " + this.calcularTotal());
//     }

//     public void alterarQuantidade(int novaQuantidade){
//         this.quantidade = novaQuantidade;
//     }

//     public void alterarValorUnitario(double novoValor){
//         this.valorUnitario = novoValor;
//     }

//     public void alterarDescricao(String novaDescricao){
//         this.descricao = novaDescricao;
//     }

//     public void alterarCodigo(int novoCodigo){
//         this.codigo = novoCodigo;
//     }

//     public void alterarPedido(int novoCodigo, String novaDescricao, int novaQuantidade, double novoValor){
//         this.codigo = novoCodigo;
//         this.descricao = novaDescricao;
//         this.quantidade = novaQuantidade;
//         this.valorUnitario = novoValor;
//     }

//     public void incluirImposto(double taxaImposto){
//         this.valorTotal = this.valorTotal + (this.valorTotal * taxaImposto);
//     }

//     public double calcularImposto(){
//         return this.valorTotal * 0.1;
//     }