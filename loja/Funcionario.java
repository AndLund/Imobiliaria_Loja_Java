package loja;

public abstract class Funcionario extends Pessoa {
    private int matricula;
    private double salario;

    public Funcionario(int matricula, double salario, String nome, String cpf) {
        super(nome, cpf);
        this.matricula = matricula;
        this.salario = salario;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "matricula: " + matricula + super.toString() + ", salario: " + salario;
    }
    
    public abstract double calculaPagamento(double s);
}
