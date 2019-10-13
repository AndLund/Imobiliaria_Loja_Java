/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;

/**
 *
 * @author anderson
 */
public class Vendedor extends Funcionario { //extends usa quando vc estiver criando uma classe filha
    private double vendas;

    public Vendedor(String nome, String cpf, double salario, double vendas) {
        super(nome,cpf,salario); //o metodo super chama o método construtor da classe mãe. Se não tiver construtor, ou seja, apenas o padrão não precisa chamar o método super
        this.vendas = vendas;
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas = vendas;
    }

    @Override //pegou um método existente e sobrescreveu
    public double calculaPagamento(){
        return (super.calculaPagamento()+vendas*0.1); //pegou o método da classe mãe e acrescentou o valor.
    }
    
    @Override
    public String toString(){
        return "Vendedor "+getNome()+" ganha "+getSalario()+" reais";
    }
    
}
