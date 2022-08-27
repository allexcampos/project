package trabalhoJogo;

public abstract class Computador { //classe abstrata mae dos computadores e do Jogador
    
    protected int[] tentativa = new int[2];//atributos protegidos
    protected int jogador;
    

    
    public Computador(int jogador){//construtor
        this.jogador = jogador;
    }
    
    
	public abstract void jogar(Tabuleiro tabuleiro);//metodo abstrado de jogar no tabuleiro
    
    public abstract void Tentativa(Tabuleiro tabuleiro);//metodo abstrado de tentar e testar jogadas

    public boolean checaTentativa(int[] tentativa, Tabuleiro tabuleiro){// testas a tentativa para ver se a posiçao no tabuleiro e valiada, retornando um booleano
        if(tabuleiro.getPosicao(tentativa) == 0)
            return true;
        else
            return false;
            
    }
    
}
