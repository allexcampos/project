package trabalhoJogo;

public class ComputadorC extends Computador {// classe filha de computador
	
	public ComputadorC(int jogador){//construtor comp.C
        super(jogador);
        System.out.println("'Computador C', diz: ");
        System.out.println("hoje to com sorte!!!");//saudação do computador C
    }
    
	
    public void jogar(Tabuleiro tabuleiro){//metodo para fazer a marçao do computador C no tabuleiro
    	Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }
    
	@Override
    public void Tentativa(Tabuleiro tabuleiro){// metodo que tenta as jogadas
		do{
            do{ 
            	tentativa[0] =1; //começa as tentativas na linha 1,2 e 3
            	tentativa[0] =2;
            	tentativa[0] =3;      
            	
            	tentativa[0] =(int) Math.floor(Math.random()*(3+1)+1);// se nao conseguir marcar lança uma linha em posiçao aleatoria!
                
                
            }while( tentativa[0] > 3 ||tentativa[0] < 1);
            
            do{ 
            	tentativa[1] =1;//começa tentando marcar a coluna 1
            	tentativa[1] =1;
            	tentativa[1] =1;
            	
            	tentativa[1]= (int) Math.floor(Math.random()*(3+1)+1); // se nao conseguir marcar lança uma coluna em posiçao aleatoria!
             
                
            }while(tentativa[1] > 3 ||tentativa[1] < 1);
            
            tentativa[1]--; 
            tentativa[0]--;
            
            if(!checaTentativa(tentativa, tabuleiro))// checa se a tentativa e valida com metodo 'checa tentativa'
                System.out.println("computador C pensando..."); // enquanto testa jogadas exibe essa mensagem
        }while( !checaTentativa(tentativa, tabuleiro) );
	
		          
    
    }
}
	 


