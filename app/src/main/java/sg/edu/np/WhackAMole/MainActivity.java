package sg.edu.np.WhackAMole;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - The function doCheck() takes in button selected and computes a hit or miss and adjust the score accordingly.
        - The function doCheck() also decides if the user qualifies for the advance level and triggers for a dialog box to ask for user to decide.
        - The function nextLevelQuery() builds the dialog box and shows. It also triggers the nextLevel() if user selects Yes or return to normal state if user select No.
        - The function nextLevel() launches the new advanced page.
        - Feel free to modify the function to suit your program.
    */
    int count = 0;
    int advancedScore = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG, "Finished Pre-Initialisation!");


    }
    @Override
    protected void onStart(){
        super.onStart();
        TextView score = (TextView)findViewById(R.id.score);
        setNewMole();
        score.setText("0");
        gameStart();
        Log.v(TAG, "Starting GUI!");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TAG, "Paused Whack-A-Mole!");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TAG, "Stopped Whack-A-Mole!");
        finish();
    }


    private void nextLevelQuery(){
        /*
        Builds dialog box here.
        Log.v(TAG, "User accepts!");
        Log.v(TAG, "User decline!");
        Log.v(TAG, "Advance option given to user!");
        belongs here*/
        AlertDialog.Builder levelQuery = new AlertDialog.Builder(this);

        levelQuery.setTitle("Warning! Insane Whack-A-Mole incoming!");
        levelQuery.setMessage("Would you like to advance to advanced mode?");
        levelQuery.setCancelable(false);
        levelQuery.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                nextLevel();
            }
        });
        levelQuery.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                gameStart();
                advancedScore += 10;
            }
        });
        levelQuery.show();
    }

    private void nextLevel(){
        /* Launch advanced page */
        Intent startNextLevel = new Intent(getApplicationContext(), Main2Activity.class);
        startNextLevel.putExtra("score",advancedScore);
        startActivity(startNextLevel);
    }

    public void setNewMole()
    {
        Button left = (Button)findViewById(R.id.left);
        left.setText("O");
        Button middle = (Button)findViewById(R.id.middle);
        middle.setText("O");
        Button right = (Button)findViewById(R.id.right);
        right.setText("O");
        TextView score = (TextView)findViewById(R.id.score);

        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        if (randomLocation == 0){
            left.setText("*");
        }
        else if(randomLocation == 1){
            middle.setText("*");
        }
        else{
            right.setText("*");
        }

    }
    public void gameStart()
    {
        final Button left = (Button)findViewById(R.id.left);
        final Button middle = (Button)findViewById(R.id.middle);
        final Button right = (Button)findViewById(R.id.right);
        final TextView score = (TextView)findViewById(R.id.score);



        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "gameStart:button pressed");
                if(left.getText() == "*"){
                    Log.v(TAG, "gameStart: left correct");
                    count += 1;
                }
                else{
                    Log.v(TAG, "gameStart: left wrong");
                    count -= 1;
                }
                score.setText(Integer.toString(count));


                if (count == advancedScore){
                    nextLevelQuery();

                }
                setNewMole();


            }
        });



        middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "gameStart:middle button pressed");
                if(middle.getText() == "*"){
                    Log.v(TAG, "gameStart:middle correct");
                    count += 1;
                }
                else{
                    Log.v(TAG, "gameStart:middle wrong");
                    count -= 1;
                }
                score.setText(Integer.toString(count));


                if (count == advancedScore){
                    nextLevelQuery();

                }

                setNewMole();

            }
        });


        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "gameStart:right pressed");
                if(right.getText() == "*"){
                    Log.v(TAG, "gameStart: right correct");
                    count += 1;
                }
                else{
                    Log.v(TAG, "gameStart:right wrong");
                    count -= 1;
                }


                score.setText(Integer.toString(count));


                if (count == advancedScore){
                    nextLevelQuery();

                }
                setNewMole();

            }
        });

    }

}