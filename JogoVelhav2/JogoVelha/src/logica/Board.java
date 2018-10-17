package logica;


import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
public class Board {

    private int[][] Board = new int[3][3];

    public Board() {
        clearBoard();
    }

    public void clearBoard() {
        for (int line = 0; line < 3; line++) {
            for (int column = 0; column < 3; column++) {
                Board[line][column] = 0;
            }
        }
    }

    public void showBoard() {
        System.out.println();
        for (int line = 0; line < 3; line++) {

            for (int column = 0; column < 3; column++) {

                if (Board[line][column] == -1) {
                    System.out.print(" X ");
                }
                if (Board[line][column] == 1) {
                    System.out.print(" O ");
                }
                if (Board[line][column] == 0) {
                    System.out.print("   ");
                }

                if (column == 0 || column == 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }

    }

    public int[] antecipaJogadaAdversario(int computador) {
        //int computador identifica o id do computador, ou seja, o jogador adversario é o outro valor, definido em jogador    
        //computador ==1 marca -1

        int jogador = 1;
        if (computador == 2) {
            jogador = -1;
        }

        int jogada[] = {-1, -1};

        //verifico se o jogador esta prestes a ganhar em alguma linha, e jogo na sua decisao
        for (int linha = 0; linha < 3; linha++) {
            if (Board[linha][0] + Board[linha][1] + Board[linha][2] == 2 * jogador) {
                jogada[0] = linha;
                jogada[1] = escolheJogadaLinha(linha);
                return jogada;
            }
        }

        //verifico se o jogador esta prestes a ganhar em alguma coluna, e jogo na sua decisao
        for (int coluna = 0; coluna < 3; coluna++) {
            if (Board[0][coluna] + Board[1][coluna] + Board[2][coluna] == 2 * jogador) {
                jogada[1] = coluna;
                jogada[0] = escolheJogadaColuna(coluna);
                return jogada;
            }
        }

        //fazer para as diagonais
        //diag 1
        if (Board[0][0] + Board[1][1] + Board[2][2] == 2 * jogador) {
            jogada = escolheJogadaDiagonal(1);
            return jogada;
        }

        //diag 2
        if (Board[0][2] + Board[1][1] + Board[2][0] == 2 * jogador) {
            jogada = escolheJogadaDiagonal(2);
            return jogada;
        }

        return jogada;
    }

    private int escolheJogadaLinha(int linha) {
        for (int i = 0; i < 3; i++) {
            if (Board[linha][i] == 0) {
                return i;
            }
        }

        return 0;
    }

    private int escolheJogadaColuna(int coluna) {
        for (int i = 0; i < 3; i++) {
            if (Board[i][coluna] == 0) {
                return i;
            }
        }

        return 0;
    }

    private int[] escolheJogadaDiagonal(int qual) {
        //qual identifica qual diagonal, qual=0  diagonal comecando em 1, qual=2 diagonal comecando em 2

        int jogada[] = {-1, -1};
        if (qual == 1) {
            for (int i = 0; i < 3; i++) {
                if (Board[i][i] == 0) {
                    jogada[0] = i;
                    jogada[1] = i;
                    return jogada;
                }
            }
        }

        if (qual == 2) {
            for (int i = 0, j = 2; i < 3; i++, j--) {
                if (Board[i][j] == 0) {
                    jogada[0] = i;
                    jogada[1] = j;
                    return jogada;
                }
            }
        }

        return jogada;
    }

    /*
    -1 1 0= -1
      0 0 0
    -1 0 -1
    =-2   =-1
    
     */
    public int getPosition(int[] attempt) {
        return Board[attempt[0]][attempt[1]];
    }

    public void setPosition(int[] attempt, int player) {
        if (player == 1) {
            Board[attempt[0]][attempt[1]] = -1;
        } else {
            Board[attempt[0]][attempt[1]] = 1;
        }
    }

    public int checkLines() {
        for (int line = 0; line < 3; line++) {

            if ((Board[line][0] + Board[line][1] + Board[line][2]) == -3) {
                return -1;
            }
            if ((Board[line][0] + Board[line][1] + Board[line][2]) == 3) {
                return 1;
            }
        }

        return 0;

    }

    public int checkColumns() {
        for (int column = 0; column < 3; column++) {

            if ((Board[0][column] + Board[1][column] + Board[2][column]) == -3) {
                return -1;
            }
            if ((Board[0][column] + Board[1][column] + Board[2][column]) == 3) {
                return 1;
            }
        }

        return 0;

    }

    public int checkDiagonals() {
        if ((Board[0][0] + Board[1][1] + Board[2][2]) == -3) {
            return -1;
        }
        if ((Board[0][0] + Board[1][1] + Board[2][2]) == 3) {
            return 1;
        }
        if ((Board[0][2] + Board[1][1] + Board[2][0]) == -3) {
            return -1;
        }
        if ((Board[0][2] + Board[1][1] + Board[2][0]) == 3) {
            return 1;
        }

        return 0;
    }

//    public boolean fullBoard(){
//        for(int line=0 ; line<3 ; line++)
//            for(int column=0 ; column<3 ; column++)
//                if( Board[line][column]==0 )
//                    return false;
//        return true;
//    }
    public boolean verificaVelha(int who) {

        int[] jogada = antecipaJogadaAdversario(1);
if(who==2)
        if (jogada[0] != -1 && jogada[1] != -1) {
            return true;
        } else {
            jogada = antecipaJogadaAdversario(2);

            if (jogada[0] != -1 && jogada[1] != -1) {
                return true;
            }
        }

        return false;
    }
}
