
package loja;

public class Vendedor extends Funcionario{
    private double vendas;

    public Vendedor(int matricula, String nome, String cpf, double salario, double vendas) {
        super(matricula, salario, nome, cpf);
        this.vendas = vendas;
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas = vendas;
    }

    @Override
    public String toString() {
        return "Vendedor {" + super.toString() + ", vendas: " + vendas + '}';
    }
    
    @Override
    public double calculaPagamento(double s){
        return (super.getSalario()+vendas*0.1);
    }
}
