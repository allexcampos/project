package trabalhoJogo;

import java.util.Scanner;// metodo para ler entrado no teclado

public class Jogador extends Computador{// e tambem uma  classe filha do computador
	public Scanner teclado = new Scanner(System.in);
	
    public Jogador(int jogador) {//construtor do Jogador
		super(jogador);
		this.jogador=jogador;
		  System.out.println("Jogador 'Humano' criado!");// mensagem do jogador criado
    }

	
    @Override
    public void jogar(Tabuleiro tabuleiro){// metodo para aplicar a jogadas do humano
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }
    
    @Override
    public void Tentativa(Tabuleiro tabuleiro){// metodo para tentar a jogada e testar se e permitida
        do{
            do{ 
            	System.out.print("Linha: ");    //pede o numero da linha que o jogador vai jogar           
                tentativa[0] = teclado.nextInt();// entrada do teclado linha
                
                if( tentativa[0] > 3 ||tentativa[0] < 1) // verifica se o intervalo linha esta dentro de 1,2 ou 3 
                    System.out.println("Linha inválida. É 1, 2 ou 3");//exibe uma mensagem de erro
                
            }while( tentativa[0] > 3 ||tentativa[0] < 1);// enquanto tentativa 0, maior que 3 ou menor 1, mantem o loop
            
            do{ 
            	System.out.print("coluna: ");               
                tentativa[1] = teclado.nextInt();// entrada do teclado coluna
                
                if(tentativa[1] > 3 ||tentativa[1] < 1)//verifica se o intervalo coluna esta dentro de 1,2 ou 3
                    System.out.println("Coluna inválida. É 1, 2 ou 3");
                
            }while(tentativa[1] > 3 ||tentativa[1] < 1);// enquanto tentativa 1, maior que 3 ou menor 1, mantem o loop
            
            tentativa[0]--; 
            tentativa[1]--;
            
            if(!checaTentativa(tentativa, tabuleiro))//metodo testa se a jogada e valida 
                System.out.println("Esse local já foi marcado. Tente outro.");// retorna mensagem
        }while( !checaTentativa(tentativa, tabuleiro) );
    }
}
