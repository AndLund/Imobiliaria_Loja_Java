
package loja;

public class Administrativo extends Funcionario {
    private double horas;

    public Administrativo(int matricula,  String nome, String cpf, double salario, double horas) {
        super(matricula, salario, nome, cpf);
        this.horas = horas;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Administrativo{" + super.toString() + ", horas: " + horas + '}';
    }

    @Override
    public double calculaPagamento(double s){
        return (super.getSalario()+horas*(super.getSalario()*0.01));
    }
}
