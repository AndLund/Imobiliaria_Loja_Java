
package loja;

public class Cliente extends Pessoa {
    
    private int codigo;

    public Cliente() {
        
    }

    public Cliente(int codigo, String nome, String cpf) {
        super(nome, cpf);
        this.codigo = codigo;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Cliente {codigo: " + codigo + super.toString() + '}';
    }
}
