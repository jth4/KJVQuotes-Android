package com.jth4.kjvquotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    // create object from QuoteProvider class
    QuoteProvider quotesObj = new QuoteProvider();
    String[] quotes = quotesObj.getQuotes();

    Random rand = new Random();
    int n = rand.nextInt(quotes.length);

    private TextView quoteView;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // hides top bar
        setContentView(R.layout.activity_main);

        nextButton = findViewById(R.id.nextButton);
        quoteView = findViewById(R.id.quoteView);

        // set initial quote randomly
        n = rand.nextInt(quotes.length);
        quoteView.setText(quotes[n]);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                n = rand.nextInt(quotes.length);
                quoteView.setText(quotes[n]);

                // Total quotes:
                // System.out.println(quotes.length);

            }
        });
    }
}