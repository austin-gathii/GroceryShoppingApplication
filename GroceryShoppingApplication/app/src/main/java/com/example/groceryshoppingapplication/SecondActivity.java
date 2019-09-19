package com.example.groceryshoppingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
     DatabaseHelper db ;
     TextView Username;
    TextView Email;
    TextView PhoneNumber;
    TextView Password;
    TextView ConfirmPassword;
    Spinner spinner;


    EditText txt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Username = (TextView) findViewById(R.id.editText);
        Email = (TextView) findViewById(R.id.editText2);
        PhoneNumber = (TextView) findViewById(R.id.editText3);
        Password = (TextView) findViewById(R.id.editText4);
        ConfirmPassword = (TextView) findViewById(R.id.editText6);
        spinner = findViewById(R.id.spinner);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Customer");
        arrayList.add("Seller");
        arrayList.add("Delivery Personnel");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,                         android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        db = new DatabaseHelper(this);
    }

    public void signUp(View V)
    {
        if (Username.getText().toString().isEmpty() || Email.getText().toString().isEmpty() || Password.getText().toString().isEmpty() || PhoneNumber.getText().toString().isEmpty())
        {
            Toast Empty = Toast.makeText(this,"Please fill in every Single Text Box...",Toast.LENGTH_LONG);
            Empty.show();
        }
        else
        {
            if (Password.getText().toString().equals(ConfirmPassword.getText().toString()))
            {
                db.addData(Username.getText().toString(),Email.getText().toString(),Password.getText().toString(),PhoneNumber.getText().toString(),spinner.getSelectedItem().toString());
                //Toast Login = Toast.makeText(this,"Logged in...",Toast.LENGTH_LONG);
                //Login.show();
                Intent intent = new Intent(this,Login.class);
                startActivity(intent);
            }
            else
            {
                Toast Pass = Toast.makeText(this,"Your Password Confirmation does not match your Password..",Toast.LENGTH_LONG);
                Pass.show();

            }
        }
    }

}
