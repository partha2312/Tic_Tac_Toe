package com.example.tic_tac_toe;
/*# Class:   CSCI 680
# Program:   Assignment 3
# Author:    Parthasarathy Krishnamurthy
# Z-number:  z1729253
# Date Due:  04/30/15
# Purpose:   To implement Tic Tac Toe in android application
#	     using MiniMax algorithm
# Execution: python3 hw2.py <filename>
*/
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    //Initializing form components
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btnRefresh;
    Button btnExit;
    
    public static List<Button> btnList;
    public static HashMap<Button, Point> buttonPoint;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	
	//Handling all button click events
	
	btnRefresh=(Button)findViewById(R.id.btnRefresh);
	btnRefresh.setOnClickListener(new View.OnClickListener() {
	    
	    @Override
	    public void onClick(View v) {
		// TODO Auto-generated method stub
		refresh();
	    }
	});
	
	btnExit=(Button)findViewById(R.id.btnExit);
	btnExit.setOnClickListener(new View.OnClickListener() {
	    
	    @Override
	    public void onClick(View v) {
		// TODO Auto-generated method stub
		finish();
		System.exit(0);
	    }
	});
	
	btn0=(Button)findViewById(R.id.button0);
	btn0.setOnClickListener(new View.OnClickListener() {
	    
	    @Override
	    public void onClick(View v) {
		// TODO Auto-generated method stub
		if(btn0.getText().equals("")){
		    btn0.setText("X");
		    playAI();
		}
	    }
	});
	btn1=(Button)findViewById(R.id.button1);
	btn1.setOnClickListener(new View.OnClickListener() {
	    
	    @Override
	    public void onClick(View v) {
		// TODO Auto-generated method stub
		if(btn1.getText().equals("")){
		    btn1.setText("X");
		    playAI();
		}
	    }
	});
	btn2=(Button)findViewById(R.id.button2);
	btn2.setOnClickListener(new View.OnClickListener() {
	    
	    @Override
	    public void onClick(View v) {
		// TODO Auto-generated method stub
		if(btn2.getText().equals("")){
		    btn2.setText("X");
		    playAI();
		}
	    }
	});
	btn3=(Button)findViewById(R.id.button3);
	btn3.setOnClickListener(new View.OnClickListener() {
	    
	    @Override
	    public void onClick(View v) {
		// TODO Auto-generated method stub
		if(btn3.getText().equals("")){
		    btn3.setText("X");
		    playAI();
		}
	    }
	});
	btn4=(Button)findViewById(R.id.button4);
	btn4.setOnClickListener(new View.OnClickListener() {
	    
	    @Override
	    public void onClick(View v) {
		// TODO Auto-generated method stub
		if(btn4.getText().equals("")){
		    btn4.setText("X");
		    playAI();
		}
	    }
	});
	btn5=(Button)findViewById(R.id.button5);
	btn5.setOnClickListener(new View.OnClickListener() {
	    
	    @Override
	    public void onClick(View v) {
		// TODO Auto-generated method stub
		if(btn5.getText().equals("")){
		    btn5.setText("X");
		    playAI();
		}
	    }
	});
	btn6=(Button)findViewById(R.id.button6);
	btn6.setOnClickListener(new View.OnClickListener() {
	    
	    @Override
	    public void onClick(View v) {
		// TODO Auto-generated method stub
		if(btn6.getText().equals("")){
		    btn6.setText("X");
		    playAI();
		}
	    }
	});
	btn7=(Button)findViewById(R.id.button7);
	btn7.setOnClickListener(new View.OnClickListener() {
	    
	    @Override
	    public void onClick(View v) {
		// TODO Auto-generated method stub
		if(btn7.getText().equals("")){
		    btn7.setText("X");
		    playAI();
		}
	    }
	});
	btn8=(Button)findViewById(R.id.button8);
	btn8.setOnClickListener(new View.OnClickListener() {
	    
	    @Override
	    public void onClick(View v) {
		// TODO Auto-generated method stub
		if(btn8.getText().equals("")){
		    btn8.setText("X");
		    playAI();
		    }
	    }
	});
	
	initialize();
    }
    
    //Initialize the collections used
    public void initialize(){
	btnList = new ArrayList<Button>();
	btnList.add(btn0);
	btnList.add(btn1);
	btnList.add(btn2);
	btnList.add(btn3);
	btnList.add(btn4);
	btnList.add(btn5);
	btnList.add(btn6);
	btnList.add(btn7);
	btnList.add(btn8);
	
	buttonPoint = new HashMap<Button, Point>();
	buttonPoint.put(btn0, new Point(0,0));
	buttonPoint.put(btn1, new Point(0,1));
	buttonPoint.put(btn2, new Point(0,2));
	buttonPoint.put(btn3, new Point(1,0));
	buttonPoint.put(btn4, new Point(1,1));
	buttonPoint.put(btn5, new Point(1,2));
	buttonPoint.put(btn6, new Point(2,0));
	buttonPoint.put(btn7, new Point(2,1));
	buttonPoint.put(btn8, new Point(2,2));
    }
    
    //Check for winner row wise
    public char checkRows(){
	if(btn0.getText().equals(btn1.getText()) && btn0.getText().equals(btn2.getText())){
	    if(!btn0.getText().equals(""))
		return btn0.getText().charAt(0);
	}
	if(btn3.getText().equals(btn4.getText()) && btn3.getText().equals(btn5.getText())){
	    if(!btn3.getText().equals(""))
		return btn3.getText().charAt(0);
	}
	if(btn6.getText().equals(btn7.getText()) && btn6.getText().equals(btn8.getText())){
	    if(!btn6.getText().equals(""))
		return btn6.getText().charAt(0);
	}
	return 'z';
    }
    
    //Check for winner column wise
    public char checkColumns(){
	if(btn0.getText().equals(btn3.getText()) && btn0.getText().equals(btn6.getText())){
	    if(!btn0.getText().equals(""))
		return btn0.getText().charAt(0);
	}
	if(btn1.getText().equals(btn4.getText()) && btn1.getText().equals(btn7.getText())){
	    if(!btn1.getText().equals(""))
		return btn1.getText().charAt(0);
	}
	if(btn2.getText().equals(btn5.getText()) && btn2.getText().equals(btn8.getText())){
	    if(!btn2.getText().equals(""))
		return btn2.getText().charAt(0);
	}
	return 'z';
    }
    
    //Check for winner diagnol wise
    public char checkDiagnols(){
	if(btn0.getText().equals(btn4.getText()) && btn0.getText().equals(btn8.getText())){
	    if(!btn0.getText().equals(""))
		return btn0.getText().charAt(0);
	}
	if(btn2.getText().equals(btn4.getText()) && btn2.getText().equals(btn6.getText())){
	    if(!btn2.getText().equals(""))
		return btn2.getText().charAt(0);
	}
	return 'z';
    }
    
    //Check if the game is over
    public char isGameOver(){
	char row = checkRows();
	char column = checkColumns();
	char diagnol = checkDiagnols();
	if(row != 'z'){
	    return row; 
	}
	if(column != 'z'){
	    return column;
	}
	if(diagnol != 'z'){
	    return diagnol;
	}
	for(Button btn : btnList){
	    if(btn.getText().equals("")){
		return 'c';
	    }
	}
	return 's';
    }
    
    //Diable all buttons after game is over
    public void disableButtons(){
	btn0.setEnabled(false);
	btn1.setEnabled(false);
	btn2.setEnabled(false);
	btn3.setEnabled(false);
	btn4.setEnabled(false);
	btn5.setEnabled(false);
	btn6.setEnabled(false);
	btn7.setEnabled(false);
	btn8.setEnabled(false);
    }
    
    //Get buttons which are not yet used
    public List<Button> getTakenButton(){
	List<Button> takenButton = new ArrayList<Button>();
	for(Button btn : btnList){
	    if(!btn.getText().equals("")){
		takenButton.add(btn);
	    }
	}
	return takenButton;
    }
    
    //Call MiniMax algorithm and place a move
    public void playAI(){
	char isGameOver = isGameOver();
	if(isGameOver == 'c'){
	    boolean isTaken = true;
	    List<Button> takenButtons = getTakenButton();
	    HashMap<Point, Character> takenPoints = new HashMap<Point, Character>();
	    for(Button btn : takenButtons){
		takenPoints.put(buttonPoint.get(btn), btn.getText().charAt(0));
	    }
	    Board boardObj = new Board(takenPoints);
	    Point selectedPoint = boardObj.callMiniMax(0, 1);
	    Button selectedButton = null;
	    for(java.util.Map.Entry<Button, Point> entry : buttonPoint.entrySet()){
		if(Objects.equals(selectedPoint, entry.getValue())){
		    selectedButton=entry.getKey();
		    break;
		}
	    }
	    selectedButton.setText("O");
	    isGameOver=isGameOver();
	}
	if(isGameOver == 's'){
	    Toast.makeText(getBaseContext(), "It's a tie !!!", Toast.LENGTH_SHORT).show();
	    disableButtons();
	}
	else if(isGameOver == 'X' || isGameOver == 'O'){
	    String message="";
	    if(isGameOver=='X'){
		message="You win !!!";
	    }
	    else if(isGameOver=='O'){
		message="You lost !!!";
	    }
	    Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
	    disableButtons();
	}
    }
    
    //Start a new game
    public void refresh(){
	initialize();
	btn0.setText("");
	btn1.setText("");
	btn2.setText("");
	btn3.setText("");
	btn4.setText("");
	btn5.setText("");
	btn6.setText("");
	btn7.setText("");
	btn8.setText("");
	btn0.setEnabled(true);
	btn1.setEnabled(true);
	btn2.setEnabled(true);
	btn3.setEnabled(true);
	btn4.setEnabled(true);
	btn5.setEnabled(true);
	btn6.setEnabled(true);
	btn7.setEnabled(true);
	btn8.setEnabled(true);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
	// Handle action bar item clicks here. The action bar will
	// automatically handle clicks on the Home/Up button, so long
	// as you specify a parent activity in AndroidManifest.xml.
	return super.onOptionsItemSelected(item);
    }
}