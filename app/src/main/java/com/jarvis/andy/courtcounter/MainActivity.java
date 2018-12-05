package com.jarvis.andy.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    class LastMove{
        private char team;
        private int plusScore;

        public LastMove(char t, int s){
            team = t;
            plusScore = s;
        }
    };
    int scoreA=0;
    int scoreB=0;
    Stack<LastMove> stack = new Stack();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void undo(View view){
        if(stack.empty()){
            Toast.makeText(MainActivity.this, "Nothing To Undo", Toast.LENGTH_SHORT).show();
        }
        else{
            LastMove element = stack.peek();
            if(element.team == 'A'){
                if(element.plusScore == 1){
                    TextView A_Score = (TextView) findViewById(R.id.teamAScore);
                    scoreA--;
                    String s=scoreA+"";
                    A_Score.setText(s);
                }
                else if(element.plusScore == 2){
                    TextView A_Score = (TextView) findViewById(R.id.teamAScore);
                    scoreA-=2;
                    String s=scoreA+"";
                    A_Score.setText(s);
                }
                else if(element.plusScore == 3){
                    TextView A_Score = (TextView) findViewById(R.id.teamAScore);
                    scoreA-=3;
                    String s=scoreA+"";
                    A_Score.setText(s);
                }
            }
            else if(element.team == 'B'){
                if(element.plusScore == 1){
                    TextView B_Score = (TextView) findViewById(R.id.teamBScore);
                    scoreB--;
                    String s=scoreB+"";
                    B_Score.setText(s);
                }
                else if(element.plusScore == 2){
                    TextView B_Score = (TextView) findViewById(R.id.teamBScore);
                    scoreB-=2;
                    String s=scoreB+"";
                    B_Score.setText(s);
                }
                else if(element.plusScore == 3){
                    TextView B_Score = (TextView) findViewById(R.id.teamBScore);
                    scoreB-=3;
                    String s=scoreB+"";
                    B_Score.setText(s);
                }
            }
            stack.pop();
        }
    }
    public void resetGame(View view){
        TextView A_Score = (TextView) findViewById(R.id.teamAScore);
        TextView B_Score = (TextView) findViewById(R.id.teamBScore);
        scoreA = 0;
        scoreB = 0;
        String s = 0 + "";
        stack.clear();
        A_Score.setText(s);
        B_Score.setText(s);
    }
    public void aAdd1(View view){
        TextView A_Score = (TextView) findViewById(R.id.teamAScore);
        scoreA++;
        LastMove element = new LastMove('A', 1);
        stack.push(element);
        String s=scoreA+"";
        A_Score.setText(s);
    }
    public void aAdd2(View view){
        TextView A_Score = (TextView) findViewById(R.id.teamAScore);
        scoreA += 2;
        LastMove element = new LastMove('A', 2);
        stack.push(element);
        String s=scoreA+"";
        A_Score.setText(s);
    }
    public void aAdd3(View view){
        TextView A_Score = (TextView) findViewById(R.id.teamAScore);
        scoreA += 3;
        LastMove element = new LastMove('A', 3);
        stack.push(element);
        String s=scoreA+"";
        A_Score.setText(s);
    }
    public void bAdd1(View view){
        TextView B_Score = (TextView) findViewById(R.id.teamBScore);
        scoreB++;
        LastMove element = new LastMove('B', 1);
        stack.push(element);
        String s=scoreB+"";
        B_Score.setText(s);
    }
    public void bAdd2(View view){
        TextView B_Score = (TextView) findViewById(R.id.teamBScore);
        scoreB += 2;
        LastMove element = new LastMove('B', 2);
        stack.push(element);
        String s=scoreB+"";
        B_Score.setText(s);
    }
    public void bAdd3(View view){
        TextView B_Score = (TextView) findViewById(R.id.teamBScore);
        scoreB += 3;
        LastMove element = new LastMove('B', 3);
        stack.push(element);
        String s=scoreB+"";
        B_Score.setText(s);
    }
}
