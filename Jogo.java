package trabalhoJogo;

import java.util.Scanner;

public class Jogo {// classe principal onde esta a ordem do jogo
	private Tabuleiro tabuleiro;
    private int rodada=1, vez=1;// atributos privados
    private Computador jogador1;
    private Computador jogador2;
    public Scanner teclado = new Scanner(System.in);
    
    
   	 public static void main(String[] args) {//metodo para ligar o jogo
   	        Jogo jogo = new Jogo();        
   	     
   	    }

    public Jogo(){//iniciando um tabuleiro e chma o metodo de iniciar jogadores jogadores
        tabuleiro = new Tabuleiro();
        iniciarJogadores();
        
        while( Jogar() );
    }
    
    public void iniciarJogadores(){// apresenta a mensagem de inicio
    	int op=0;
    	System.out.println("# BEM VIMDO AO JOGO DA VELHA #");       
    	System.out.println("#Para jogar digite o numero da linha e depois o numero da coluna.#\n");
        System.out.println("O jogador Humano vai jogar com 'X' e o computador com 'O'!");        
        System.out.println("vamos começar...\n");
        this.jogador1= new Jogador(1);// e ja inicia o jogador1 como Humano, chamando a classe Jogador
        System.out.println();
        System.out.println("Escolha qual computador deseja enfrentar"); // pergunta qual computador deseja enfrentar      
        System.out.println("1 - Computador A");
        System.out.println("2 - Computador B");
        System.out.println("3 - Computador C\n");
        System.out.println("Digite um numero: ");//espaço para digitar a opção 1, 2, 3
        op= teclado.nextInt();
        
        if(op==1)// caso op igual a 1, inicia o computador A, como jogador 2
        	this.jogador2 = new ComputadorA(2);
        else if(op==2)// caso op igual a 2, inicia o computador B, como jogador 2
        	this.jogador2 = new ComputadorB(2);
        else if(op==3)// caso op igual a 3, inicia o computador C, como jogador 2
        	this.jogador2 = new ComputadorC(2);
        else
        	System.out.println("opcão invalida, digite 1, 2 ou 3! ");// caso algo digitado diferente de 1,2,3, exibe mensagem de erro
           
        
    }
    
    
    public boolean Jogar(){// metodo boleano jogar, enquanto recebe 0 mantem as rodadas e chama o proximo jogador
        if(ganhou() == 0 ){
            System.out.println("----------------------");
            System.out.println("\nRodada "+rodada);
            System.out.println("O proximo a jogar é o jogador " + vez() );
            
            if(vez()==1)// se a vez for igual a 1 e a vez do humano
                jogador1.jogar(tabuleiro);
            else// se nao, e a vez do computador
                jogador2.jogar(tabuleiro);
            
            
            if(tabuleiro.tabuleiroCompleto()){// se caso o tabuleiro completo, avisa que o jogo empatou
                System.out.println("FIM DE JOGO, O JOGO EMPATOU!");
                return false;
            }
            vez++;
            rodada++;

            return true;
        } else{
            if(ganhou() == -1 )// se ganhou retornar -1 o jogador humano ganhou
                System.out.println("PARABÉNS, O HUMANO GANHOU !");
            else// se ganhou retornar 1 o computador ganhou
                System.out.println("PARABÉNS, O COMPUTADOR GANHOU !");
            
            return false;
        }
            
    }
    
    public int vez(){// organiza as vezes entre o jogador 1 e o jogador 2
        if(vez%2 == 1)
            return 1;
        else
            return 2;
    }
    
    public int ganhou(){// usa os metodos , verifica, linha, coluna e diagonal, para saber se alguem ganhou ganhou.
        if(tabuleiro.verificaLinhas() == 1)
            return 1;// o computador venceu
        if(tabuleiro.verificaColunas() == 1)
            return 1;// o computador venceu
        if(tabuleiro.verificaDiagonais() == 1)
            return 1;// o computador venceu
        
        if(tabuleiro.verificaLinhas() == -1)
            return -1;// o humano venceu
        if(tabuleiro.verificaColunas() == -1)
            return -1; // o humano venceu
        if(tabuleiro.verificaDiagonais() == -1)
            return -1; // o humano venceu
        
        return 0;// continua o jogo
    }
      

}


