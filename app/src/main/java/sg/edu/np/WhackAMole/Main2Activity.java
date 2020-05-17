package sg.edu.np.WhackAMole;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.BatchUpdateException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static android.content.ContentValues.TAG;

public class Main2Activity extends AppCompatActivity {
    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 8.
        - The function doCheck() takes in button selected and computes a hit or miss and adjust the score accordingly.
        - The functions readTimer() and placeMoleTimer() are to inform the user X seconds before starting and loading new mole.
        - Feel free to modify the function to suit your program.
    */




    int advCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*Hint:
            This starts the countdown timers one at a time and prepares the user.
            This also prepares the existing score brought over.
            It also prepares the button listeners to each button.
            You may wish to use the for loop to populate all 9 buttons with listeners.
         */

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        Intent receivingEnd = getIntent();
        int count = receivingEnd.getIntExtra("score",0);

        advCount = count ;

        Log.v(TAG, "Current User Score: " + count);

        Log.v(TAG, "Finished Pre-Initialisation!");
    }

    @Override
    protected void onStart(){
        super.onStart();
        readyTimer();

        Log.v(TAG, "Starting GUI!");
    }

    private void readyTimer(){
     /*  HINT:
            The "Get Ready" Timer.
            Log.v(TAG, "Ready CountDown!" + millisUntilFinished/ 1000);
            Toast message -"Get Ready In X seconds"
            Log.v(TAG, "Ready CountDown Complete!");
            Toast message - "GO!"
            belongs here.
            This timer countdown from 10 seconds to 0 seconds and stops after "GO!" is shown.
         */
        final int[] countDownTime = {10};
        final CountDownTimer assist;

        final CountDownTimer countDownTimer = new CountDownTimer(20000, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {

                Toast.makeText(getApplicationContext(), "Game starts in " + (countDownTime[0]--),Toast.LENGTH_SHORT).show();
                Log.v(TAG, "Ready CountDown!" + millisUntilFinished/ 1000);
                if (countDownTime[0] == 0){
                    Toast.makeText(getApplicationContext(), "GO",Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFinish() {
                Log.v(TAG, "Ready CountDown Complete!");

                TextView advScore = (TextView)findViewById(R.id.advScore);
                advScore.setText(Integer.toString(advCount));
                setNewMole();
                doCheck();

            }
        };


        countDownTimer.start();





    }
    /*private void placeMoleTimer(){
         HINT:
           Creates new mole location each second.
           Log.v(TAG, "New Mole Location!");
           setNewMole();
           belongs here.
           This is an infinite countdown timer.
    }
    */


    private void doCheck()
    {
        final Button topLeft = (Button)findViewById(R.id.topLeft);
        final Button topMiddle = (Button)findViewById(R.id.topMiddle);
        final Button topRight = (Button)findViewById(R.id.topRight);
        final Button centerLeft = (Button)findViewById(R.id.centerLeft);
        final Button center = (Button)findViewById(R.id.center);
        final Button centerRight = (Button)findViewById(R.id.centerRight);
        final Button bottomLeft = (Button)findViewById(R.id.bottomLeft);
        final Button bottomMiddle = (Button)findViewById(R.id.middleBottom);
        final Button bottomRight = (Button)findViewById(R.id.bottomRight);
        final TextView advScore = (TextView)findViewById(R.id.advScore);

        topLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "gameStart:button pressed");
                if (topLeft.getText() == "*") {
                    Log.v(TAG, "gameStart: topleft correct");
                    advCount += 1; }
                else {
                    Log.v(TAG, "gameStart: topleft wrong");
                    advCount -= 1;
                }
                advScore.setText(Integer.toString(advCount));
                setNewMole();
            }
        });

        topMiddle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v(TAG,"gameStart:button pressed");
                if(topMiddle.getText() == "*") {
                    Log.v(TAG, "gameStart: topMiddle correct");
                    advCount += 1;
                }
                else {
                    Log.v(TAG, "gameStart: topMiddle wrong");
                }
                advScore.setText(Integer.toString(advCount));
                setNewMole();
            }
        });

        topRight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v(TAG,"gameStart:button pressed");
                if(topRight.getText() == "*") {
                    Log.v(TAG, "gameStart: topRight correct");
                    advCount += 1;
                }
                else {
                    Log.v(TAG, "gameStart: topRight wrong");
                }
                advScore.setText(Integer.toString(advCount));
                setNewMole();
            }
        });

        centerLeft.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v(TAG,"gameStart:button pressed");
                if(centerLeft.getText() == "*") {
                    Log.v(TAG, "gameStart: centerLeft correct");
                    advCount += 1;
                }
                else {
                    Log.v(TAG, "gameStart: centerLeft wrong");
                }
                advScore.setText(Integer.toString(advCount));
                setNewMole();
            }

        });

        center.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v(TAG,"gameStart:button pressed");
                if(center.getText() == "*") {
                    Log.v(TAG, "gameStart: center correct");
                    advCount += 1;
                }
                else {
                    Log.v(TAG, "gameStart: center wrong");
                }
                advScore.setText(Integer.toString(advCount));
                setNewMole();
            }

        });

        centerRight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v(TAG,"gameStart:button pressed");
                if(centerRight.getText() == "*") {
                    Log.v(TAG, "gameStart: centerRight correct");
                    advCount += 1;
                }
                else {
                    Log.v(TAG, "gameStart: centerRight wrong");
                }
                advScore.setText(Integer.toString(advCount));
                setNewMole();
            }

        });

        bottomLeft.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v(TAG,"gameStart:button pressed");
                if(bottomLeft.getText() == "*") {
                    Log.v(TAG, "gameStart: bottomLeft correct");
                    advCount += 1;
                }
                else {
                    Log.v(TAG, "gameStart: bottomLeft wrong");
                }
                advScore.setText(Integer.toString(advCount));
                setNewMole();
            }

        });

        bottomMiddle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v(TAG,"gameStart:button pressed");
                if(bottomMiddle.getText() == "*") {
                    Log.v(TAG, "gameStart: bottomMiddle correct");
                    advCount += 1;
                }
                else {
                    Log.v(TAG, "gameStart: bottomMiddle wrong");
                }
                advScore.setText(Integer.toString(advCount));
                setNewMole();
            }

        });

        bottomRight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v(TAG,"gameStart:button pressed");
                if(bottomRight.getText() == "*") {
                    Log.v(TAG, "gameStart: bottomRight correct");
                    advCount += 1;
                }
                else {
                    Log.v(TAG, "gameStart: bottomRight wrong");
                }
                advScore.setText(Integer.toString(advCount));
                setNewMole();
            }

        });



    };




    public void setNewMole()
    {


        /* Hint:
            Clears the previous mole location and gets a new random location of the next mole location.
            Sets the new location of the mole.
         */

        //Identifications of buttons

        Button topLeft = (Button)findViewById(R.id.topLeft);
        topLeft.setText("O");
        Button topMiddle = (Button)findViewById(R.id.topMiddle);
        topMiddle.setText("O");
        Button topRight = (Button)findViewById(R.id.topRight);
        topRight.setText("O");
        Button centerLeft = (Button)findViewById(R.id.centerLeft);
        centerLeft.setText("O");
        Button center = (Button)findViewById(R.id.center);
        center.setText("O");
        Button centerRight = (Button)findViewById(R.id.centerRight);
        centerRight.setText("O");
        Button bottomLeft = (Button)findViewById(R.id.bottomLeft);
        bottomLeft.setText("O");
        Button bottomMiddle = (Button)findViewById(R.id.middleBottom);
        bottomMiddle.setText("O");
        Button bottomRight = (Button)findViewById(R.id.bottomRight);
        bottomRight.setText("O");


        Random ran = new Random();
        int randomLocation = ran.nextInt(9);
        if (randomLocation == 0){
            topLeft.setText("*");
        }
        else if(randomLocation == 1){
            topMiddle.setText("*");
        }
        else if(randomLocation == 2){
            topRight.setText("*");
        }
        else if(randomLocation == 3){
            centerLeft.setText("*");
        }
        else if(randomLocation == 4){
            center.setText("*");
        }
        else if(randomLocation == 5){
            centerRight.setText("*");
        }
        else if(randomLocation == 6){
            bottomLeft.setText("*");
        }
        else if(randomLocation == 7){
            bottomMiddle.setText("*");
        }
        else{
            bottomRight.setText("*");
        }
    }
}

