
package loja;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja {
    Scanner input = new Scanner(System.in);
    List<Pessoa> pessoas = new ArrayList<>();
    int codC = 0;
    
    public void menu(){
        int opcao;
        do{
            System.out.println("XXXXXXX LOJINHA DO SEU JAVA XXXXXXX");
            System.out.println("1 - CADASTRAR");
            System.out.println("2 - REMOVER");
            System.out.println("3 - BUSCAR");
            System.out.println("4 - LISTAR");
            System.out.println("5 - ADICIONAR PRODUTIVIDADE");
            System.out.println("6 - GERAR FOLHA DE PAGAMENTO");
            System.out.println("0 - SAIR");
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            opcao = input.nextInt();
            input.nextLine();
            System.out.println('\n');
            
            switch(opcao){
                case 0:
                    System.out.println("\nObrigado, volte sempre!\n\n"); 
                    break;
                case 1:
                    cadastrar();
                    break;
                case 2:
                    remover();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    listar();
                    break;
                case 5:
                    adicionarProdutividade();
                    break;
                case 6:
                    gerarFolhaPagamento();
                    break;
                default:
                    System.out.println("Escolha uma opção válida.");
            }
        }while(opcao != 0);
    }
    
    private void cadastrar(){
        boolean verificando = true;
        int opcaoCad;
        do{
            System.out.println("XXXXXXXXXX CADASTRO XXXXXXXXXX");
            System.out.println("1 - Cliente");
            System.out.println("2 - Funcionário: Administrativo");
            System.out.println("3 - Funcionário: Vendedor");
            opcaoCad = input.nextInt();
            input.nextLine();
            
            switch(opcaoCad){
                case 1:
                    //cadastro cliente
                    System.out.println("NOME:");
                    String nomeC = input.nextLine();
                    System.out.println("CPF:");
                    String cpfC = input.nextLine();
                    
                    Cliente c;
                    
                    c = new Cliente(codC,nomeC,cpfC);
                    c.setCodigo(++codC);
                    
                    pessoas.add(c);
                    //Para printar o conteudo da arraylist
                    //System.out.println(pessoas);
                    
                    System.out.println("\nCliente cadastrado com sucesso.");
                    verificando = false;
                    break;
                case 2:
                    //cadastro administrativo
                    System.out.println("MATRICULA: ");
                    int matA = input.nextInt();
                    input.nextLine();
                    System.out.println("NOME:");
                    String nomeA = input.nextLine();
                    System.out.println("CPF:");
                    String cpfA = input.nextLine();
                    System.out.println("SALARIO:");
                    double salA = input.nextDouble();
                    System.out.println("HORAS:");
                    double horas = input.nextDouble();
                    
                    Administrativo a;
                    a = new Administrativo(matA,nomeA,cpfA,salA,horas);
                    
                    pessoas.add(a);
                    
                    System.out.println("\nAdministrativo cadastrado com sucesso.");
                    verificando = false;
                    break;
                case 3:
                    //cadastro vendedor
                    System.out.println("MATRICULA: ");
                    int matV = input.nextInt();
                    input.nextLine();
                    System.out.println("NOME:");
                    String nomeV = input.nextLine();
                    System.out.println("CPF:");
                    String cpfV = input.nextLine();
                    System.out.println("SALARIO:");
                    double salV= input.nextDouble();
                    System.out.println("HORAS:");
                    double vendas = input.nextDouble();
                    
                    Vendedor v;
                    v = new Vendedor(matV,nomeV,cpfV,salV,vendas);
                    
                    pessoas.add(v);
                    
                    System.out.println("\nVendedor cadastrado com sucesso.");
                    verificando = false;
                    break;
                default:
                    System.out.println("Opção Inválida, tente novamente.");
            }
            System.out.println('\n');
            System.out.println("Deseja realizar um novo cadastro(s/n)?");
            
            if(input.next().charAt(0) == 's'){
                verificando = true;
            }
            System.out.println('\n');
        }while(verificando);
    }
    
    private void remover(){
        System.out.println("\nXXXXXXX REMOVENDO CLIENTE XXXXXXX");
        int indice=0;
        if(pessoas.isEmpty()){
            System.out.println("Até o momento nenhum registro foi realizado.\n");
        }else{
            System.out.println("\nEscolha o numero do registro que você deseja remover:\n");

            for(Pessoa p: pessoas){
                System.out.println(indice++ + " - " + p + '\n');
            }
            int escolha = input.nextInt();
            pessoas.remove(escolha);
            System.out.println('\n');
        }
    }
    
    private void buscar(){
        System.out.println("XXXXXXX BUSCAR REGISTRO XXXXXXX");
        System.out.println("\nINFORME O CPF:");
        Pessoa busca = buscar(input.nextLine());
        if(busca == null){
            System.out.println("\nO CPF não foi encontrado.\n");
        }else{
            System.out.println("Foi encontrado o seguinte registro:");
            System.out.println(busca + "\n");
        }
    }
    
    private Pessoa buscar(String cpf){
        for(Pessoa p : pessoas){
            if(p.getCpf().equals(cpf))
                return p;
        }
        return null;
        
        /*
        for(int i = 0; i < pessoas.size();i++){
            if(pessoas.get(i).getCpf().contains(cpf)){ //KKKKKKKKKKKKKKKKKKKKKK
                return pessoas.get(i);
            }
        }
        return null;*/
    }
    
    private void listar(){
        System.out.println("XXXXXXX LISTA DE REGISTROS XXXXXXX\n");
        int indice=0;
        if(pessoas.isEmpty()){
            System.out.println("Até o momento nenhum registro foi realizado.\n");
        }else{
            for(Pessoa p: pessoas){
                System.out.println(indice++ + " - " + p + '\n');
                //indice++;
            }
        }
    }
    
    private void adicionarProdutividade(){
        System.out.println("XXXXXXX ADIÇÃO DE PRODUTIVIDADE XXXXXXX");
        System.out.println("\nINFORME O CPF:");
        Pessoa adc = buscar(input.nextLine());
        if(adc == null){
            System.out.println("\nO CPF não foi encontrado.\n");
        }else{
            System.out.println("Foi encontrado o seguinte registro:");
            System.out.println(adc + "\n");
            System.out.println("Informe a produtividade do funcionário: ");
            double valor = input.nextDouble();
            if(adc instanceof Administrativo){
                ((Administrativo)adc).setHoras(valor);
            }else{
                ((Vendedor)adc).setVendas(valor);
            }
            System.out.println('\n');
        }
    }
    
    private void gerarFolhaPagamento(){
        double valor = 0;
        for(Pessoa p: pessoas){
            if(p instanceof Administrativo){
                valor = ((Administrativo)p).calculaPagamento(valor);
            }else if(p instanceof Vendedor){
                valor = ((Vendedor)p).calculaPagamento(valor);
            }
            System.out.println(p +", valor: " + valor );
        }
        System.out.println("\n");
    }
    
    public static void main(String[] args) {
        Loja l = new Loja();
        l.menu();
    }
}
