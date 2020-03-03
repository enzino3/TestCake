package com.example.cakeordering;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinner_toppings;
    Spinner spinner_flavor;

    String a,b,c;

    EditText txt_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        rbtn_square = findViewById(R.id.rbtn_square);
//        rbtn_circle = findViewById(R.id.rbtn_circle);
//        rbtn_rectangle = findViewById(R.id.rbtn_rectangle);

        txt_message = findViewById(R.id.txt_message);
        addItemsOnSpinner1();
        addItemsOnSpinner2();

    }

    public void addItemsOnSpinner2() {

        spinner_flavor = (Spinner) findViewById(R.id.spinner_flavor);
        List<String> list1 = new ArrayList<String>();
        list1.add("Chocolate");
        list1.add("Caramel");
        list1.add("Coffee");
        list1.add("Ube");
        list1.add("Black Forest");
        list1.add("Strawberry");
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_flavor.setAdapter(dataAdapter1);
    }

    public void addItemsOnSpinner1() {

        spinner_toppings = (Spinner) findViewById(R.id.spinner_toppings);
        List<String> list1 = new ArrayList<String>();
        list1.add("Kisses");
        list1.add("Oreo");
        list1.add("Crinkles");
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_toppings.setAdapter(dataAdapter1);
    }


    public void submit(View view) {
        spinner_flavor = findViewById(R.id.spinner_flavor);
        spinner_toppings = findViewById(R.id.spinner_toppings);
        txt_message = findViewById(R.id.txt_message);

        a = spinner_flavor.getSelectedItem().toString();
        b = spinner_toppings.getSelectedItem().toString();
        c = txt_message.getText().toString();


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setMessage("Flavor: " + a + "\nToppings: " + b + "\nMessage: " + c + "\n" );
        alertDialogBuilder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
