/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testes;
import logica.Board;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nilton
 */
public class BoardTest {
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test

    @Test
    public void setPositionTest(){
        int [] attempt = {1,2};
        
        Board board = new Board();
        board.setPosition(attempt, 2);
        
        assertEquals(board.getPosition(attempt), 1);
    }
    
    @Test
    public void checkLineTest(){
        /* 3 matrizes
        1  1  1 = 3 // escolhida
        0 -1 -1
       -1  0  1
        
        1 -1  0 = nda
        1  1 -1
       -1  0  1
        
        -1  1  0 = -3
         1  1  0
        -1 -1 -1
        */
        
        Board board = new Board();
        int [] attempt = new int[2];
        attempt[0] = 0;
        attempt[1] = 0;
        board.setPosition(attempt, 2);
        
        attempt[0] = 0;
        attempt[1] = 1;
        board.setPosition(attempt, 2);
        
        attempt[0] =0;
        attempt[1] =2;
        board.setPosition(attempt, 2);
        
        attempt[0] =1;
        attempt[1] =1;
        board.setPosition(attempt, 1);
        
        attempt[0] =1;
        attempt[1] =2;
        board.setPosition(attempt, 1);
        
        attempt[0] =2;
        attempt[1] =0;
        board.setPosition(attempt, 1);
        
        attempt[0] = 2;
        attempt[1] = 2;
        board.setPosition(attempt, 2);
        
        assertEquals(board.checkLines(), 1);
        
    }
    
    @Test
    public void checkColumnsTest(){
        /* 3 matrizes
        1  1   0   //escolhida
        0  1  -1
       -1  1  -1
          = 3
        1 -1  0 = nda
        1  1 -1
       -1  0  1
        
         0  1  -1
         0  1  -1
         1  0  -1
               = -3
        */
        
        
        Board board = new Board();
        int [] attempt = new int[2];
        attempt[0] = 0;
        attempt[1] = 0;
        board.setPosition(attempt, 2);
        
        attempt[0] = 0;
        attempt[1] = 1;
        board.setPosition(attempt, 2);
        
        attempt[0] =1;
        attempt[1] =1;
        board.setPosition(attempt, 2);
        
        attempt[0] =1;
        attempt[1] =2;
        board.setPosition(attempt, 1);
        
        attempt[0] =2;
        attempt[1] =0;
        board.setPosition(attempt, 1);
        
        attempt[0] =2;
        attempt[1] =1;
        board.setPosition(attempt, 2);
        
        attempt[0] = 2;
        attempt[1] = 2;
        board.setPosition(attempt, 1);
        
        assertEquals(board.checkColumns(), 1);
        
    }
    
    @Test
    public void checkDiagonalsTest(){
        
        /* 3 matrizes
        1  1  1 = 3
        0 -1 -1
       -1  0  1
        
        1 -1  0
        1  1 -1  //escolhida
       -1  0  1
               = 3
        
         1   1  -1 = -3
         1  -1   0
        -1   1  -1
        
        */
        
        
        Board board = new Board();
        int [] attempt = new int[2];
        attempt[0] = 0;
        attempt[1] = 0;
        board.setPosition(attempt, 2);
        
        attempt[0] = 0;
        attempt[1] = 1;
        board.setPosition(attempt, 1);
        
        attempt[0] =1;
        attempt[1] =0;
        board.setPosition(attempt, 2);
        
        attempt[0] =1;
        attempt[1] =1;
        board.setPosition(attempt, 2);
        
        attempt[0] =1;
        attempt[1] =2;
        board.setPosition(attempt, 1);
        
        attempt[0] =2;
        attempt[1] =0;
        board.setPosition(attempt, 1);
        
        attempt[0] = 2;
        attempt[1] = 2;
        board.setPosition(attempt, 2);
        
        assertEquals(board.checkDiagonals(), 1);
    }
    
    @Test
    public void antecipaJogadaAdversarioTest(){
        /*3 matrizes
        
        1   0   1
       -1  -1   1
        0  -1   0
        ->deve marcar [0][1]
        
        1  -1   1
       -1  -1   1
        0  -1   0
        ->deve marcar [2][2]
        
        --vez do jogador 1
        1 -1  0
        1  0 -1  //escolhida
       -1  0  1
        ->deve marcar [1][1]
        
        */
        
        Board board = new Board();
        int [] attempt = new int[2];
        attempt[0] = 0;
        attempt[1] = 0;
        board.setPosition(attempt, 2);
        
        attempt[0] = 0;
        attempt[1] = 1;
        board.setPosition(attempt, 1);
        
        attempt[0] =1;
        attempt[1] =0;
        board.setPosition(attempt, 2);
        
        attempt[0] =1;
        attempt[1] =2;
        board.setPosition(attempt, 1);
        
        attempt[0] =2;
        attempt[1] =0;
        board.setPosition(attempt, 1);
        
        attempt[0] = 2;
        attempt[1] = 2;
        board.setPosition(attempt, 2);
        
        attempt = board.antecipaJogadaAdversario(1);
        //O jogador que esta jogando é o 1 logo
        //verifico as possiveis jogadas do jogador 2 e tento neutraliza-las
        
        assertEquals(attempt[0], 1);
        assertEquals(attempt[1], 1);
    }
    
    @Test
    public void verificaEmpateAntecipado(){
        /* independe jogador
        1 -1  1
        0 -1  1//escolhida
        0  1 -1
        
         1 -1  0
        -1  1  1
        -1  1 -1
        
        -1  1  -1
         0  1  -1
         0 -1   1
        */
        
        
        Board board = new Board();
        int [] attempt = new int[2];
        attempt[0] = 0;
        attempt[1] = 0;
        board.setPosition(attempt, 2);
        
        attempt[0] = 0;
        attempt[1] = 1;
        board.setPosition(attempt, 1);

        attempt[0] = 0;
        attempt[1] = 2;
        board.setPosition(attempt, 2);
        
        attempt[0] =1;
        attempt[1] =1;
        board.setPosition(attempt, 1);
        
        attempt[0] =1;
        attempt[1] =2;
        board.setPosition(attempt, 2);
        
        attempt[0] =2;
        attempt[1] =1;
        board.setPosition(attempt, 2);
        
        attempt[0] = 2;
        attempt[1] = 2;
        board.setPosition(attempt, 1);
         board.showBoard();
        assertFalse(board.verificaVelha(2));
    }
}
