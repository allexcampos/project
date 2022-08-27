package trabalhoJogo;

public class Tabuleiro {// class para os metodos do tabuleiro
private int[][] tabuleiro= new int[3][3];//matriz do tipo inteira, de 3 por 3
    
    public Tabuleiro(){ //construtor Tabuleiro
        zerarTabuleiro();
    }
    
    public void zerarTabuleiro(){//metodo para preenche o tabuleiro com 0", passado 2 'for', um para linha e um para coluna.
        for(int linha=0 ; linha<3 ; linha++)
            for(int coluna=0 ; coluna<3 ; coluna++)
                tabuleiro[linha][coluna]=0;
    }
    
    public void exibeTabuleiro(){// mostra as marcações no tabuleiro, onde tem -1 aparece 'X', onde tem 1 aparece 'O' e 0 e espaço vazio
        System.out.println();
        for(int linha=0 ; linha<3 ; linha++){
        
            for(int coluna=0 ; coluna<3 ; coluna++){
                
                if(tabuleiro[linha][coluna]==-1){
                    System.out.print(" X ");
                }
                if(tabuleiro[linha][coluna]==1){
                    System.out.print(" O ");
                }
                if(tabuleiro[linha][coluna]==0){
                    System.out.print("   ");
                }
                
                if(coluna==0 || coluna==1)
                    System.out.print("|");
            }
            System.out.println();
        }
                
    }

    public int getPosicao(int[] tentativa){// pega a posição de linha e coluna dos jogadores
        return tabuleiro[tentativa[0]][tentativa[1]];
    }
    
    public void setPosicao(int[] tentativa, int jogador){// aplica a jogada de linha e coluna no tabuleiro 
        if(jogador == 1)
            tabuleiro[tentativa[0]][tentativa[1]] = -1;
        else
            tabuleiro[tentativa[0]][tentativa[1]] = 1;
        
        exibeTabuleiro();// por ultimo chama o metodo que mostra as marcaçoes 
    }

    public int verificaLinhas(){// um 'for' que verifica todas as linhas para ver se tem um vencedor
        for(int linha=0 ; linha<3 ; linha++){

            if( (tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == -3)
                return -1;
            if( (tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == 3)
                return 1;
        }
        
        return 0;// continua o jogo
                
    }
    
    public int verificaColunas(){// um 'for' que verifica todas as colunas para ver se tem um vencedor
        for(int coluna=0 ; coluna<3 ; coluna++){

            if( (tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == -3)
                return -1;
            if( (tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == 3)
                return 1;
        }
        
        return 0;// continua o jogo
                
    }
    
    public int verificaDiagonais(){// um metodo que verifica todas as diagonais para ver se tem um vencedor
        if( (tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == -3)
            return -1;
        if( (tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == 3)
            return 1;
        if( (tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == -3)
            return -1;
        if( (tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == 3)
            return 1;
        
        return 0;// continua o jogo
    }

    public boolean tabuleiroCompleto(){// caso complete o tabuleiro e nao tenha vencedor, retorna no 'Jogo' que houve 'EMPATE'
        for(int linha=0 ; linha<3 ; linha++)//verifica linha
            for(int coluna=0 ; coluna<3 ; coluna++)//verifica colunas
                if( tabuleiro[linha][coluna]==0 )// se igual a zero ninguem ganhou
                    return false;
        return true;
    }
	

}
