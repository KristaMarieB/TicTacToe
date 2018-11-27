package com.example.kbetcher.tictactoe;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public String currentPlayer;
    public TextView turnTxtVw;
    private String winner;

    private Button topL;
    private Button topM;
    private Button topR;
    private Button midL;
    private Button midM;
    private Button midR;
    private Button botL;
    private Button botM;
    private Button botR;

    private String choice;

    private String[][] input;
    private Button[][] buttonsXO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentPlayer = "Player X";

        topL = findViewById(R.id.topL);
        topM = findViewById(R.id.topM);
        topR = findViewById(R.id.topR);
        midL = findViewById(R.id.midL);
        midM = findViewById(R.id.midM);
        midR = findViewById(R.id.midR);
        botL = findViewById(R.id.botL);
        botM = findViewById(R.id.botM);
        botR = findViewById(R.id.botR);

        turnTxtVw = findViewById(R.id.txtVwTurn);
        winner = "";
        choice = "";

        input = new String[][] {    {"", "", ""},
                                    {"", "", ""},
                                    {"", "", ""}  };

        buttonsXO = new Button[][]{ {topL, topM, topR},
                                    {midL, midM, midR},
                                    {botL, botM, botR}};
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_preferences, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        // response to selection
        switch(item.getItemId()){
            case R.id.about:
                AlertDialog.Builder aboutBuilder = new AlertDialog.Builder(this);
                aboutBuilder.setTitle("About this Game")
                        .setMessage("This is tic-tac-toe. Get 3 in a row. You win.")
                        .show();
                return true;
            case R.id.playerSwitch:
                createAlertDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

        // Look at preferences, it has methods like putString, getString
        // Have to save whoever the starting player is there
    }

    public void createAlertDialog() {
        final AlertDialog.Builder switchBuilder = new AlertDialog.Builder(this);
        switchBuilder.setTitle("Switch Starting Player")
                .setPositiveButton("O", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        choice = "Player O";
                        newGame();
                    }
                })
                .setNegativeButton("X", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        choice = "Player X";
                        newGame();
                    }
                })
                .show();

    }


    public void onClick(View v) {

        if(currentPlayer.equals("Player X")) {
            if(v == topL) {
                topL.setText("X");
                input[0][0] = "X";
                check();
                if(winner.equals("")) {
                    if(checkForTie()){
                        turnTxtVw.setText("We have a tie!");
                    } else {
                        currentPlayer = "Player O";
                        turnTxtVw.setText("Player O's turn");

                    }
                }
                topL.setEnabled(false);

            } else if (v == topM) {
                topM.setText("X");
                input[0][1] = "X";
                check();
                if(winner.equals("")) {
                    if(checkForTie()){
                        turnTxtVw.setText("We have a tie!");
                    } else {
                        currentPlayer = "Player O";
                        turnTxtVw.setText("Player O's turn");

                    }
                }
                topM.setEnabled(false);
            } else if (v == topR) {
                topR.setText("X");
                input[0][2] = "X";
                check();
                //Toast.makeText(getApplicationContext(), Arrays.deepToString(input), Toast.LENGTH_LONG).show();
                if(winner.equals("")) {
                    if(checkForTie()){
                        turnTxtVw.setText("We have a tie!");
                    } else {
                        currentPlayer = "Player O";
                        turnTxtVw.setText("Player O's turn");

                    }
                }
                topR.setEnabled(false);
            } else if (v == midL) {
                midL.setText("X");
                input[1][0] = "X";
                check();
                if(winner.equals("")) {
                    if(checkForTie()){
                        turnTxtVw.setText("We have a tie!");
                    } else {
                        currentPlayer = "Player O";
                        turnTxtVw.setText("Player O's turn");

                    }
                }
                midL.setEnabled(false);
            } else if (v == midM) {
                midM.setText("X");
                input[1][1] = "X";
                check();
                if(winner.equals("")) {
                    if(checkForTie()){
                        turnTxtVw.setText("We have a tie!");
                    } else {
                        currentPlayer = "Player O";
                        turnTxtVw.setText("Player O's turn");

                    }
                }
                midM.setEnabled(false);
            } else if (v == midR) {
                midR.setText("X");
                input[1][2] = "X";
                check();
                if(winner.equals("")) {
                    if(checkForTie()){
                        turnTxtVw.setText("We have a tie!");
                    } else {
                        currentPlayer = "Player O";
                        turnTxtVw.setText("Player O's turn");

                    }
                }
                midR.setEnabled(false);
            } else if (v == botL) {
                botL.setText("X");
                input[2][0] = "X";
                check();
                if(winner.equals("")) {
                    if(checkForTie()){
                        turnTxtVw.setText("We have a tie!");
                    } else {
                        currentPlayer = "Player O";
                        turnTxtVw.setText("Player O's turn");

                    }
                }
                botL.setEnabled(false);
            } else if (v == botM) {
                botM.setText("X");
                input[2][1] = "X";
                check();
                if(winner.equals("")) {
                    if(checkForTie()){
                        turnTxtVw.setText("We have a tie!");
                    } else {
                        currentPlayer = "Player O";
                        turnTxtVw.setText("Player O's turn");

                    }
                }
                botM.setEnabled(false);
            } else if (v == botR) {
                botR.setText("X");
                input[2][2] = "X";
                check();
                if(winner.equals("")) {
                    if(checkForTie()){
                        turnTxtVw.setText("We have a tie!");
                    } else {
                        currentPlayer = "Player O";
                        turnTxtVw.setText("Player O's turn");

                    }
                }
                botR.setEnabled(false);
            }
        }

        else {
            if(v == topL){
                topL.setText("O");
                input[0][0] = "O";
                check();
                if(winner.equals("")) {
                    if(checkForTie()){
                        turnTxtVw.setText("We have a tie!");
                    } else {
                        currentPlayer = "Player X";
                        turnTxtVw.setText("Player X's turn");

                    }
                }
                topL.setEnabled(false);
            } else if (v == topM) {
                topM.setText("O");
                input[0][1] = "O";
                check();
                if(winner.equals("")) {
                    if(checkForTie()){
                        turnTxtVw.setText("We have a tie!");
                    } else {
                        currentPlayer = "Player X";
                        turnTxtVw.setText("Player X's turn");

                    }
                }
                topM.setEnabled(false);
            } else if (v == topR) {
                topR.setText("O");
                input[0][2] = "O";
                check();
                if(winner.equals("")) {
                    if(checkForTie()){
                        turnTxtVw.setText("We have a tie!");
                    } else {
                        currentPlayer = "Player X";
                        turnTxtVw.setText("Player X's turn");

                    }
                }
                topR.setEnabled(false);
            } else if (v == midL) {
                midL.setText("O");
                input[1][0] = "O";
                check();
                if(winner.equals("")) {
                    if(checkForTie()){
                        turnTxtVw.setText("We have a tie!");
                    } else {
                        currentPlayer = "Player X";
                        turnTxtVw.setText("Player X's turn");

                    }
                }
                midL.setEnabled(false);
            } else if (v == midM) {
                midM.setText("O");
                input[1][1] = "O";
                check();
                if(winner.equals("")) {
                    if(checkForTie()){
                        turnTxtVw.setText("We have a tie!");
                    } else {
                        currentPlayer = "Player X";
                        turnTxtVw.setText("Player X's turn");

                    }
                }
                midM.setEnabled(false);
            } else if (v == midR) {
                midR.setText("O");
                input[1][2] = "O";
                check();
                if(winner.equals("")) {
                    if(checkForTie()){
                        turnTxtVw.setText("We have a tie!");
                    } else {
                        currentPlayer = "Player X";
                        turnTxtVw.setText("Player X's turn");

                    }
                }
                midR.setEnabled(false);
            } else if (v == botL) {
                botL.setText("O");
                input[2][0] = "O";
                check();
                if(winner.equals("")) {
                    if(checkForTie()){
                        turnTxtVw.setText("We have a tie!");
                    } else {
                        currentPlayer = "Player X";
                        turnTxtVw.setText("Player X's turn");

                    }
                }
                botL.setEnabled(false);
            } else if (v == botM) {
                botM.setText("O");
                input[2][1] = "O";
                check();
                if(winner.equals("")) {
                    if(checkForTie()){
                        turnTxtVw.setText("We have a tie!");
                    } else {
                        currentPlayer = "Player X";
                        turnTxtVw.setText("Player X's turn");
                    }
                }
                botM.setEnabled(false);
            } else if (v == botR) {
                botR.setText("O");
                input[2][2] = "O";
                check();
                if(winner.equals("")) {
                    if(checkForTie()){
                        turnTxtVw.setText("We have a tie!");
                    } else {
                        currentPlayer = "Player X";
                        turnTxtVw.setText("Player X's turn");
                    }
                }
                botR.setEnabled(false);
            }
        }

        /*
            for(int i = 0; i < input.length; i++) {
                for(int j = 0; j < input[i].length; j++){
                    if(v.toString().equals(input[i][j])){
                        input[i][j] = v.toString();
                    }
                }
            }
            */

        // I would like to refactor with a switch statement
        // or find some other way to refactor like create a method that I call
/*        if(currentPlayer == "playerX"){
            switch (v.getId()) {
                case R.id.topL:
                    topL.setText("O");
                    currentPlayer = "playerX";
                    turnTxtVw.setText("Player X's turn");

            }
        }*/

    }

    public void newGameClick(View v){
        newGame();
    }

    public void newGame(){
        topL.setText("");
        topM.setText("");
        topR.setText("");
        midL.setText("");
        midM.setText("");
        midR.setText("");
        botL.setText("");
        botM.setText("");
        botR.setText("");

        topL.setEnabled(true);
        topM.setEnabled(true);
        topR.setEnabled(true);
        midL.setEnabled(true);
        midM.setEnabled(true);
        midR.setEnabled(true);
        botL.setEnabled(true);
        botM.setEnabled(true);
        botR.setEnabled(true);

        if(choice.equals("")){
            currentPlayer = "Player X";
        }
        else {
            currentPlayer = choice;
        }

        turnTxtVw.setText(currentPlayer + "'s turn");

        winner = "";

        input = new String[][] {    {"", "", ""},
                                    {"", "", ""},
                                    {"", "", ""}  };

        buttonsXO = new Button[][]{ {topL, topM, topR},
                                    {midL, midM, midR},
                                    {botL, botM, botR}};
    }

    public boolean checkForTie(){
        for(int i = 0; i < input.length; i++){
            for(int j = 0; j <input[i].length; j++){
                if(input[i][j].equals("")){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * When called, checks if either player has won the game
     * with their newest move
     */
    public void check() {
        if(checkHorizontal() || checkVertical() || checkDiagonal()) {
            turnTxtVw.setText(winner + " wins!");

            for(int i = 0; i < buttonsXO.length; i++) {
                for(int j = 0; j < buttonsXO[i].length; j++) {
                    buttonsXO[i][j].setEnabled(false);
                }
            }
        }
    }

    public boolean checkHorizontal() {
        if( topL.getText().equals("X") && topM.getText().equals("X") && topR.getText().equals("X") ||
            midL.getText().equals("X") && midM.getText().equals("X") && midR.getText().equals("X") ||
            botL.getText().equals("X") && botM.getText().equals("X") && botR.getText().equals("X") ){
            winner = "Player X";
            return true;
        }
        if( topL.getText().equals("O") && topM.getText().equals("O") && topR.getText().equals("O") ||
            midL.getText().equals("O") && midM.getText().equals("O") && midR.getText().equals("O") ||
            botL.getText().equals("O") && botM.getText().equals("O") && botR.getText().equals("O") ){
            winner = "Player O";
            return true;
        }
        return false;
    }

    public boolean checkVertical() {
        if( topL.getText().equals("X") && midL.getText().equals("X") && botL.getText().equals("X") ||
            topM.getText().equals("X") && midM.getText().equals("X") && botM.getText().equals("X") ||
            topR.getText().equals("X") && midR.getText().equals("X") && botR.getText().equals("X") ){
            winner = "Player X";
            return true;
        }
        if( topL.getText().equals("O") && midL.getText().equals("O") && botL.getText().equals("O") ||
            topM.getText().equals("O") && midM.getText().equals("O") && botM.getText().equals("O") ||
            topR.getText().equals("O") && midR.getText().equals("O") && botR.getText().equals("O") ){
            winner = "Player O";
            return true;
        }
        return false;
    }

    public boolean checkDiagonal(){
        if( topL.getText().equals("X") && midM.getText().equals("X") && botR.getText().equals("X") ||
            topR.getText().equals("X") && midM.getText().equals("X") && botL.getText().equals("X") ){
            winner = "Player X";
            return true;
        }
        if( topL.getText().equals("O") && midM.getText().equals("O") && botR.getText().equals("O") ||
                topR.getText().equals("O") && midM.getText().equals("O") && botL.getText().equals("O") ){
            winner = "Player O";
            return true;
        }
        return false;
    }
}
