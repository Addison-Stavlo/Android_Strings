package com.example.palindromechecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    static final int RESET      = -1;
    static final int IS_PAL     = 1;
    static final int NOT_PAL    = 0;

    TextView headline;
    EditText userInput;
    Button btnSubmit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        headline = findViewById(R.id.headline);
        btnSubmit = findViewById(R.id.btn_submit);
        userInput = findViewById(R.id.user_input);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(btnSubmit.getText() == getString(R.string.btn_submit)){
                    String inputValue = userInput.getText().toString();
                    render(checkPalindrome(inputValue));
                }
                else{
                    render(RESET);
                }

            }
        });
    }

    private int checkPalindrome(String s){
        s = s.toLowerCase();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return NOT_PAL;
            }
        }
        return IS_PAL;
    }

    private void render(int uiState){
        switch (uiState) {
            case IS_PAL:
                btnSubmit.setText(R.string.btn_reset);
                headline.setText(R.string.is_palindrome);
                break;
            case NOT_PAL:
                btnSubmit.setText(R.string.btn_reset);
                headline.setText(R.string.not_palindrome);
                break;
            case RESET:
                userInput.setText("");
                btnSubmit.setText(R.string.btn_submit);
                headline.setText(R.string.prompt);
                break;
            default:
                System.out.println("ERR- switch case unknown - render in MainActivity.java");
                break;
        }
    }
}
