package trabalhoJogo;
import java.util.Random;

public class ComputadorA extends Computador{// classe filha de Computador
	
	public ComputadorA(int jogador){//construtor comp.A
        super(jogador);
        System.out.println("'Computador A' diz: ");
        System.out.println("vou ganhar de você, humano!!!");// saudação do computador A
    }
    
	
    public void jogar(Tabuleiro tabuleiro){//metodo para fazer a marçao do computador A, no tabuleiro
    	Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }
    
	@Override
    public void Tentativa(Tabuleiro tabuleiro){// metodo que tenta as jogadas
		do{
            do{                            
                tentativa[0] = (int) Math.floor(Math.random()*(3+1)+1);   //este computador sempre sorteia a linha             
                if( tentativa[0] > 3 ||tentativa[0] < 1)
                    System.out.print("");
                
            }while( tentativa[0] > 3 ||tentativa[0] < 1);
            
            do{             	       
                tentativa[1] = (int) Math.floor(Math.random()*(3+1)+1);   //este computador sempre sorteia a coluna               
                if(tentativa[1] > 3 ||tentativa[1] < 1)
                    System.out.println("computador esta pensado jogadas");
                
            }while(tentativa[1] > 3 ||tentativa[1] < 1);
            
            tentativa[0]--; 
            tentativa[1]--;
            
            if(!checaTentativa(tentativa, tabuleiro))// checa se a tentativa e valida com metodo 'checa tentativa'
                System.out.println("computador A pensando...");
        }while( !checaTentativa(tentativa, tabuleiro) );
	
    
    }

}
