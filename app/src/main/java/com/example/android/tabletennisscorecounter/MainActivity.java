package com.example.android.tabletennisscorecounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.android.tabletennisscorecounter.R.id.ScoreA;
import static com.example.android.tabletennisscorecounter.R.id.ScoreB;
import static com.example.android.tabletennisscorecounter.R.id.SetsA;
import static com.example.android.tabletennisscorecounter.R.id.SetsB;
import static com.example.android.tabletennisscorecounter.R.id.WinnerText;
import static com.example.android.tabletennisscorecounter.R.id.badServeTextA;
import static com.example.android.tabletennisscorecounter.R.id.badServeTextB;


public class MainActivity extends AppCompatActivity {
    int scoreA = 0;
    int scoreB = 0;
    int setsA = 0;
    int setsB = 0;
    int badServeA = 0;
    int badServeB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * Increase the score for Player A by 1 point.
     */
    public void addpointPlayerA(View v) {
       AddPointToPlayer(0);
        }


    private void displayForSetsA(int setsA) {
        TextView scoreView = (TextView) findViewById(SetsA);
        scoreView.setText(String.valueOf(setsA));

    }
    private void displayForSetsB(int setsB) {
        TextView scoreView = (TextView) findViewById(SetsB);
        scoreView.setText(String.valueOf(setsB));
    }


    /**
     * Displays the given score for Player A.
     */
    public void displayForPlayerA(int score) {
        TextView scoreView = (TextView) findViewById(ScoreA);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Increase the score for Player B by 1 point.
     */
    public void addpointPlayerB(View v) {
        AddPointToPlayer(1);
    }


    public void displayWinnerText(String text){
        TextView textView = (TextView) findViewById(R.id.WinnerText);
        textView.setText(text);
    }
    public void displayForPlayerB(int score) {
        TextView scoreView = (TextView) findViewById(ScoreB);
        scoreView.setText(String.valueOf(score));
          }


     public void displayForBadServeA(int score) {
         TextView scoreView = (TextView) findViewById(badServeTextA);
         scoreView.setText(String.valueOf(score));

     }
    public void displayForBadServeB(int score) {
        TextView scoreView = (TextView) findViewById(badServeTextB);
        scoreView.setText(String.valueOf(score));
    }
    public void resetTheScores(View v){
        setsA = 0;
        setsB = 0;
        scoreA = 0;
        scoreB = 0;
        badServeA = 0;
        badServeB = 0;


        
        displayWinnerText("");
        displayForSetsA(setsA);
        displayForSetsB(setsB);
        displayForPlayerA(scoreA);
        displayForPlayerB(scoreB);
        displayForBadServeA(badServeA);
        displayForBadServeB(badServeB);
        SetButtonsState(true);

    }
    public void AddPointToPlayer(int player) {

        if(player==0) {
           scoreA += 1;
            displayForPlayerA(scoreA);
            badServeA=0;
            displayForBadServeA(badServeA);
            badServeB=0;
            displayForBadServeB(badServeB);
        }
        else{
            scoreB+=1;
            displayForPlayerB(scoreB);
            badServeB=0;
            displayForBadServeB(badServeB);
            badServeA=0;
            displayForBadServeA(badServeA);
        }
        if ((scoreA >= 11 || scoreB >= 11 ) && Math.abs(scoreA-scoreB)>=2 ) {
            if(scoreA>scoreB){
                setsA++;

            }
            else{
                setsB++;
            }
            scoreA=0;
            scoreB=0;
            displayForPlayerA(scoreA);
            displayForPlayerB(scoreB);
            displayForSetsA(setsA);
            displayForSetsB(setsB);
            if(setsA ==3){
                displayWinnerMessage(0);
                SetButtonsState(false);

            }
            if (setsB==3){
                displayWinnerMessage(1);
                SetButtonsState(false);

            }

        }





    }
    public void displayWinnerMessage(int player) {
        TextView Textwinner;
        String playerName;
        if (player == 0) {
            playerName = "Player A";
            Textwinner = (TextView) findViewById(WinnerText);
        } else {
            playerName = "Player B";
            Textwinner = (TextView) findViewById(WinnerText);
        }

        String WinnerMessage = "The Winner is " + playerName + "!";
        Textwinner.setText(WinnerMessage);


    }
    public void badServesA(View view){ badServePoint(2);}
    public void badServesB(View view) {badServePoint(3);}

    public void badServePoint(int serves){
        if(serves==2){
        badServeA ++;
            displayForBadServeA(badServeA);
        } else{
            badServeB ++;
            displayForBadServeB(badServeB);
        }
        if(badServeA >= 3){
            AddPointToPlayer(1);
            badServeA = 0;
            displayForBadServeA(badServeA);
            badServeB=0;
            displayForBadServeB(badServeB);
        }
        if (badServeB >= 3){
            AddPointToPlayer(0);
            badServeB = 0;
            displayForBadServeB(badServeB);
            badServeA = 0;
            displayForBadServeA(badServeA);
        }


        }





    public void SetButtonsState(boolean state){
        Button buttonA= (Button) findViewById(R.id.buttonA);
        Button buttonB= (Button) findViewById(R.id.buttonB);
        Button badServeButtonA = (Button) findViewById(R.id.badServeButtonA);
        Button badServeButtonB = (Button) findViewById(R.id.badServeButtonB);
        buttonA.setEnabled(state);
        buttonB.setEnabled(state);
        badServeButtonA.setEnabled(state);
        badServeButtonB.setEnabled(state);

    }

}
