public class Funcionario{
    public String nome;
    public String funcao;
    public double salario;

    public Funcionario(String nome, String funcao, double salario){
        this.nome = nome;
        this.funcao = funcao;
        this.salario = salario;
    }

    public String getNome(){
        return this.nome;
    }

    public String getFuncao(){
        return this.funcao;
    }

    public double getSalario(){
        return this.salario;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setFuncao(String funcao){
        this.funcao = funcao;
    }

    public void setSalario(double salario){
        this.salario = salario;
    }

    public String exibeFuncionario(){
        return "Nome: " + this.nome + "\nFunção: " + this.funcao + "\nSalário: " + this.salario;
    }

    public boolean equals(Funcionario f){
        if(this.nome.equals(f.getNome()) && this.funcao.equals(f.getFuncao()) && this.salario == f.getSalario()){
            return true;
        }
        return false;
    }

}