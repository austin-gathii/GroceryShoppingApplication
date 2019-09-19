package com.example.groceryshoppingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SellerMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_main_page);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Username");
        String Username = bundle.getString("Username");
        TextView welcome = (TextView) findViewById(R.id.textView8);
        welcome.setText("Welcome "+Username+" .....");
    }
}
