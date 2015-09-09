/*# Class:   CSCI 680
# Program:   Assignment 3
# Author:    Parthasarathy Krishnamurthy
# Z-number:  z1729253
# Date Due:  04/30/15
# Purpose:   To implement Tic Tac Toe in android application
#	     using MiniMax algorithm
#	     Scores class is used to maintain the scores for each position in 2-d array
# Execution: python3 hw2.py <filename>
*/
package com.example.tic_tac_toe;

public class Scores {

    int score;
    Point points;
    
    public Scores(int score, Point points) {
	this.score=score;
	this.points=points;
    }
}
