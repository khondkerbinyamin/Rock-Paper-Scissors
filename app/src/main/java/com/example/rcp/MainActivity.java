package com.example.rcp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button bRock,bPaper,bScissors;
    TextView tvScore;
    ImageView computerChoice,humanChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bRock = (Button)findViewById(R.id.button_rock);
        bPaper = (Button)findViewById(R.id.button_paper);
        bScissors = (Button)findViewById(R.id.button_scissors);

        computerChoice = (ImageView)findViewById(R.id.computer_choice);
        humanChoice = (ImageView)findViewById(R.id.human_choice);

        tvScore = (TextView)findViewById(R.id.scoreboard);


        bRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                humanChoice.setImageResource(R.drawable.rock);
                String result = play("rock");
                tvScore.setText(result);
            }
        });

        bPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                humanChoice.setImageResource(R.drawable.paper);
                String result = play("paper");
                tvScore.setText(result);
            }
        });

        bScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                humanChoice.setImageResource(R.drawable.scisssor);
                String result = play("scissors");
                tvScore.setText(result);
            }
        });


    }
    public String play(String choice){
        String computerChoiceString = "";
        Random r = new Random();
        int computeChoiceNumber = r.nextInt(3) + 1;

        if(computeChoiceNumber == 1){
            computerChoiceString = "rock";
            computerChoice.setImageResource(R.drawable.rock);
        }
        else if(computeChoiceNumber == 2){
            computerChoiceString = "paper";
            computerChoice.setImageResource(R.drawable.paper);
        }
        else if(computeChoiceNumber == 3){
            computerChoiceString = "scissors";
            computerChoice.setImageResource(R.drawable.scisssor);
        }

        if(computerChoiceString == choice){
            return "DRAW";
        }
        else if(computerChoiceString == "rock" && choice == "paper"){
            return "YOU WON";
        }
        else if(computerChoiceString == "paper" && choice == "scissors"){
            return "YOU WON";
        }
        else if(computerChoiceString == "scissors" && choice == "rock"){
            return "YOU WON";
        }
        else{
            return "YOU LOST";
        }
    }
}
