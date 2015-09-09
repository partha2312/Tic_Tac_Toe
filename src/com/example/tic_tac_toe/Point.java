/*# Class:   CSCI 680
# Program:   Assignment 3
# Author:    Parthasarathy Krishnamurthy
# Z-number:  z1729253
# Date Due:  04/30/15
# Purpose:   To implement Tic Tac Toe in android application
#	     using MiniMax algorithm
#	     Point class is used to represent each point in Cartesian coordinate system
# Execution: python3 hw2.py <filename>
*/
package com.example.tic_tac_toe;

import java.util.Objects;

public class Point {
    int x,y;
    public Point(int x, int y) {
	this.x=x;
	this.y=y;
    }
    
    @Override
    public String toString(){
	return "[" + x + ", " + y + "]";
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (o.getClass() != Point.class) {
            return false;
        }
        Point other = (Point) o;
        return other.x == this.x && other.y == this.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}