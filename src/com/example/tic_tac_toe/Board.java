package com.example.tic_tac_toe;

/*# Class:   CSCI 680
# Program:   Assignment 3
# Author:    Parthasarathy Krishnamurthy
# Z-number:  z1729253
# Date Due:  04/30/15
# Purpose:   To implement Tic Tac Toe in android application
#	     using MiniMax algorithm
#	     Board class is used to initialize a 2-d matrix representing the UI
# Execution: python3 hw2.py <filename>
*/
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.util.Log;

public class Board {
    HashMap<Point, Character> takenPoints;
    List<Point> availablePoints;
    char[][] board = new char[3][3];
    List<Scores> rootScores;
    public Board(HashMap<Point, Character> takenPoints) {
	this.takenPoints=takenPoints;
    }
    
    //Fill the values in 2-d matrix as per UI
    public void initializeBoard(){
	for(java.util.Map.Entry<Point, Character> entry : takenPoints.entrySet()){
	    int x = entry.getKey().x;
	    int y = entry.getKey().y;
	    char val = entry.getValue();
	    board[x][y]=val;
	}
    }
    
    //Check if player won
    public boolean hasXWon() {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 'X') || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 'X')) {
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 'X')
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 'X'))) {
                return true;
            }
        }
        return false;
    }

    //Check if AI won
    public boolean hasOWon() {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 'O') || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 'O')) {
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 'O')
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 'O')) {
                return true;
            }
        }
        return false;
    }
    
    //Get available points in the 2-d array
    public List<Point> getAvailableStates() {
        availablePoints = new ArrayList<Point>();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] == 0) {
                    availablePoints.add(new Point(i, j));
                }
            }
        }
        return availablePoints;
    }
    
    //Place a move for both AI and player
    public void placeAMove(Point point, char play) {
        board[point.x][point.y] = play;
    }

    //Pick the best move from list of moves
    public Point returnBestMove() {
        int MAX = Integer.MIN_VALUE;
        int best = -1;

        for (int i = 0; i < rootScores.size(); ++i) { 
            if (MAX < rootScores.get(i).score) {
                MAX = rootScores.get(i).score;
                best = i;
            }
        }
        return rootScores.get(best).points;
    }
    
    //Get the minimum number from a list
    public int returnMin(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) < min) {
                min = list.get(i);
                index = i;
            }
        }
        return list.get(index);
    }

    //Get maximum number from a list
    public int returnMax(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) > max) {
                max = list.get(i);
                index = i;
            }
        }
        return list.get(index);
    }
    
    //The function to call minimax algorithm and return the best move
    public Point callMiniMax(int depth, int turn){
	initializeBoard();
	rootScores=new ArrayList<Scores>();
	miniMax(depth, turn);
	return returnBestMove();
    }
    
    //The minimax algorithm implementation
    public int miniMax(int depth, int turn){
	if(hasXWon()) return -1;
	if(hasOWon()) return 1;
	
	List<Point> availablePoints = getAvailableStates();
	
	if(availablePoints.isEmpty()) return 0;
	
	List<Integer> scores = new ArrayList<Integer>();
	
	for (int i = 0; i < availablePoints.size(); i++) {
            Point point = availablePoints.get(i);  

            if (turn == 1) {
                placeAMove(point, 'O'); 
                int currentScore = miniMax(depth + 1, 2);
                scores.add(currentScore);

                if (depth == 0) 
                    rootScores.add(new Scores(currentScore, point));
                
            } else if (turn == 2) {
                placeAMove(point, 'X'); 
                scores.add(miniMax(depth + 1, 1));
            }
            board[point.x][point.y] = 0;
        }
        return turn == 1 ? returnMax(scores) : returnMin(scores);
    }
}