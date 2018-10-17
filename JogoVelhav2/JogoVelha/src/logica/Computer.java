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
public class Computer extends Player{
    
    public Computer(int player){
        super(player);
        this.player=player;
        System.out.println("Player 'Computer' created: "+this.player);
    }
    
    @Override
    public void play(Board board){
        Try(board);
        board.setPosition(attempt, player);
    }
    
    @Override
    public void Try(Board board){
        
        do{
        attempt = board.antecipaJogadaAdversario(this.player);
        
        if(attempt[0]!=-1 && attempt[1]!=-1){
            if(checkTry(attempt, board)){
            board.setPosition(attempt, player);
            return;
            }
        }else break;
        }while(!checkTry(attempt, board));
        
        //se o adversario nao esta prestes a ganhar, escolhe randomicamente    
        Random r = new Random();
        
        do{
        attempt[0]= r.nextInt(3);
        attempt[1]= r.nextInt(3);
        }while(!checkTry(attempt, board));
        
        board.setPosition(attempt, player);
    }
    
}

/*

 x  |    |   
   |    |
   |    |


*/
