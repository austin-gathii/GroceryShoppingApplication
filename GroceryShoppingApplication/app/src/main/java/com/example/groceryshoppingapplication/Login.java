package com.example.groceryshoppingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    DatabaseHelper db ;
    TextView Username;
    TextView Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Username = (TextView) findViewById(R.id.editText5);
        Password = (TextView) findViewById(R.id.editText7);
        db = new DatabaseHelper(this);

    }

    public void logIn(View V)
    {
        if (Username.getText().toString().isEmpty() || Password.getText().toString().isEmpty())
        {
            Toast Empty = Toast.makeText(this,"Fill in both your Username and your Password....",Toast.LENGTH_LONG);
            Empty.show();
        }
        else
        {
            if (db.Authentication(Username.getText().toString(),Password.getText().toString()))
            {
                Toast Login = Toast.makeText(this,"Logged in...",Toast.LENGTH_LONG);
                Login.show();
                System.out.println("Logged In..");

                String UserStatus = db.getStatus(Username.getText().toString());
                Intent intent = new Intent(this,CustomerMainPage.class);
                Bundle bundle = new Bundle();
                bundle.putString("Username",Username.getText().toString());
                switch (UserStatus)
                {
                    case "Administrator":
                        intent = new Intent(this,AdminMainPage.class);
                        break;

                    case "Seller":
                        intent = new Intent(this,SellerMainPage.class);
                        break;

                    case "Customer":
                        intent = new Intent(this,CustomerMainPage.class);
                        break;

                    case "Delivery Personnel":
                        intent = new Intent(this,SellerMainPage.class);
                        break;

                    default:
                        System.out.println("Error");


                }
                intent.putExtra("Username",bundle);
                startActivity(intent);

            }
            else
            {
                Toast Wrong = Toast.makeText(this,"Either your Password or your Username is wrong..\nTry again....",Toast.LENGTH_LONG);
                Wrong.show();
            }
        }

    }
}
