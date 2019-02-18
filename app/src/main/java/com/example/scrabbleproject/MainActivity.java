package com.example.scrabbleproject;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;

import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * External Citation
         * Date: January 31, 2019
         * Problem: Did not understand how to title the spinner for the purpose of having a menu Drop Down
         * Resource: https://android--code.blogspot.com/2015/08/android-spinner-prompt.html
         * Solution: I used the example code from this post in order to have an idea as to how the drop Down would like. 
         * **/

        final Spinner spinner = (Spinner) findViewById(R.id.menuSpinner);

        // Initializing a String Array
        String[] plants = new String[]{
                "Menu",
                "Instructions",
                "Sound On/Off",
                "Quit Game"

        };

        final List<String> plantsList = new ArrayList<>(Arrays.asList(plants));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,plantsList){
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position%2 == 1) {
                    // Set the item background color
                    tv.setBackgroundColor(Color.parseColor("#FFF9A600"));
                }
                else {
                    // Set the alternate item background color
                    tv.setBackgroundColor(Color.parseColor("#FFE49200"));
                }
                return view;
            }
        };

        /*
            public void setPrompt (CharSequence prompt)
                Sets the prompt to display when the dialog is shown.
         */
        spinner.setPrompt("Select an item");

        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(spinnerArrayAdapter);
    }



}
