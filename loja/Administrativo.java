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
public class Administrativo extends Funcionario {
    private double horas;

    public Administrativo(String nome, String cpf, double salario, double horas) {
        super(nome,cpf,salario);
        this.horas = horas;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }
    
    @Override
    public double calculaPagamento(){
        return (super.calculaPagamento()+horas*(getSalario()*0.01));
    }
    
    @Override
    public String toString(){
        return "Administrativo "+getNome()+" ganha "+getSalario()+" reais";
    }
}
