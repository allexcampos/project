package trabalhoJogo;

public class ComputadorB extends Computador{// classe filha de Computador

	public ComputadorB(int jogador){//construtor comp. B
        super(jogador);
        System.out.println("'Computador B' diz: ");
        System.out.println("sou o melhor!!!!");// saudação do computador B
    }
    
	
    public void jogar(Tabuleiro tabuleiro){ //metodo para fazer a marçao do computador B no tabuleiro
    	Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }
    
	@Override
    public void Tentativa(Tabuleiro tabuleiro){// metodo que tenta as jogadas
		do{
            do{ 
            	tentativa[0] =1;// as tentativas na linha 1
            	tentativa[0] =1;
            	tentativa[0] =1;           	
            	tentativa[0] =(int) Math.floor(Math.random()*(3+1)+1); // se nao conseguir marcar lança uma linha em posiçao aleatoria!
                
            }while( tentativa[0] > 3 ||tentativa[0] < 1);// 
            
            do{ 
            	tentativa[1] =1;// seguencia de colunas pra tentar ganhar na  1
            	tentativa[1] =2;
            	tentativa[1] =3;            	
            	tentativa[1]= (int) Math.floor(Math.random()*(3+1)+1); // se nao conseguir marcar lança uma coluna em posiçao aleatoria!
             
            }while(tentativa[1] > 3 ||tentativa[1] < 1);
            
            tentativa[0]--; 
            tentativa[1]--;
            
            if(!checaTentativa(tentativa, tabuleiro))// checa se a tentativa e valida com metodo 'checa tentativa'
                System.out.println("computador C pensando..."); //enquanto testa jogadas exibe essa mensagem
        }while( !checaTentativa(tentativa, tabuleiro) );
	
		          
    
    }
}	