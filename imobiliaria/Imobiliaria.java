
package imobiliaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Imobiliaria {
    Scanner input = new Scanner(System.in);
    List<Imovel> lista = new ArrayList<>();
    int codCad = 0; //ta errado isso
            
    public void menu(){
        boolean teste = true;
        do{
            System.out.println("------- MENU IMOBILIÁRIA -------");
            System.out.println("1 - CADASTRAR IMÓVEL");
            System.out.println("2 - ALUGAR IMÓVEL");
            System.out.println("3 - SAIR");
            int opcao = input.nextInt();
            input.nextLine();

            switch(opcao){
                case 1:
                    cadastrarImoveis();
                    break;
                case 2:
                    alugarImovel();
                    break;
                case 3:
                    teste = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(teste);
        
        System.out.println("\nPrograma finalizado com sucesso.\n");
    }
    
    public void cadastrarImoveis(){
        boolean teste2 = true;
        Imovel i  = new Imovel();
        do{
            System.out.println("------- CADASTRAR IMÓVEL -------");
            System.out.println("1 - RESIDENCIAL");
            System.out.println("2 - COMERCIAL");
            System.out.println("--------------------------------");
            int opcao2 = input.nextInt();
            input.nextLine();

            switch(opcao2){
                case 1:
                    System.out.println("Qual a regiao do imovel:");
                    String regiao1 = input.nextLine();
                    System.out.println("Qual o valor do imovel:");
                    double valor1 = input.nextDouble();
                    System.out.println("Quantos quartos:");
                    int quartos = input.nextInt();
                    input.nextLine();
                    Residencial res = new Residencial(codCad++, regiao1, valor1, true, quartos);
                    lista.add(res);
                    teste2 = false;
                    break;
                case 2:
                    System.out.println("Qual a regiao do imovel:");
                    String regiao2 = input.nextLine();
                    System.out.println("Qual o valor do imovel:");
                    double valor2 = input.nextDouble();
                    System.out.println("Area útil:");
                    double area = input.nextDouble();
                    input.nextLine();
                    Comercial com = new Comercial(codCad++, regiao2, valor2, true, area);
                    lista.add(com);
                    teste2 = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(teste2);
    }
    
    public void alugarImovel(){
        boolean flag = true;
        System.out.println("Lista de imóveis:");
        listarImoveis();
        System.out.println("\nInforme o código do imóvel desejado:");
        int cod = input.nextInt();
        input.nextLine();
        
        for(int i = 0; i < lista.size();i++){
            if(lista.get(i).getCodigo() == cod){
                if(lista.get(i).isDisponivel()){
                    lista.get(i).setDisponivel(false);
                    System.out.println("Imóvel alugado com sucesso.");
                }else{
                    System.out.println("O Imóvel não está disponível.");
                }
                flag = false;
                break;
            }
        }
        if(flag){
                System.out.println("O código informado não está presente na lista.\n");
        }
    }
    
    public void listarImoveis(){
        if(lista.isEmpty()){
            System.out.println("Até o momento nenhum imovel foi cadastrado.\n");
        }else{
            for(Imovel l: lista){
                System.out.println(l);
            }
        }
    }
}
