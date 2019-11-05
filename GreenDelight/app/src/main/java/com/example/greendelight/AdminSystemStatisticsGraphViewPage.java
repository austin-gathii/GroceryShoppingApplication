package com.example.greendelight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AdminSystemStatisticsViewPage extends AppCompatActivity {
    TextView Username,ActiveUsers,Customers,Sellers,DeliveryPersonnel,Administrators,AvailableProducts,SoldOutProducts,AvailableOrders,InProgressOrders,CompletedOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_system_statistics_view_page);
        Username = findViewById(R.id.textView83);
        ActiveUsers = findViewById(R.id.textView89);
        Customers = findViewById(R.id.textView91);
        Sellers = findViewById(R.id.textView92);
        DeliveryPersonnel = findViewById(R.id.textView93);
        Administrators = findViewById(R.id.textView99);
        AvailableProducts = findViewById(R.id.textView97);
        SoldOutProducts = findViewById(R.id.textView98);
        AvailableOrders = findViewById(R.id.textView94);
        InProgressOrders = findViewById(R.id.textView95);
        CompletedOrders = findViewById(R.id.textView96);

        Username.setText(getSharedPreferences("UserInfo",MODE_PRIVATE).getString("Username","Nameless"));
        populateData();

    }

    void populateData()
    {
        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, Constants.GET_STATS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println(response.substring(response.indexOf("{"),response.lastIndexOf("}")));
                        try
                        {
                            JSONObject jresponse = new JSONObject(response.substring(response.indexOf("{"),response.lastIndexOf("}")+1));
                            ActiveUsers.setText("Active Users : "+Integer.toString(jresponse.getInt("users")));
                            Customers.setText("No. of Customers : "+Integer.toString(jresponse.getInt("cus")));
                            Sellers.setText("No. of Sellers : "+Integer.toString(jresponse.getInt("sell")));
                            DeliveryPersonnel.setText("No. of Delivery Personnel : "+Integer.toString(jresponse.getInt("del")));
                            Administrators.setText("No. of Administrators : "+Integer.toString(jresponse.getInt("admins")));
                            AvailableProducts.setText("No. of Available Products : "+Integer.toString(jresponse.getInt("products")));
                            SoldOutProducts.setText("No. of Sold Out Products : "+Integer.toString(jresponse.getInt("soldout")));
                            AvailableOrders.setText("No. of Available Orders : "+Integer.toString(jresponse.getInt("order")));
                            InProgressOrders.setText("No. of Orders In Progress : "+Integer.toString(jresponse.getInt("inprogress")));
                            CompletedOrders.setText("No. of Completed Orders : "+Integer.toString(jresponse.getInt("completed")));






                        }
                        catch (JSONException e)
                        {
                            Toast.makeText(getApplicationContext(),"an error has occured...",Toast.LENGTH_LONG).show();
                            System.out.println(e.getMessage());
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"an error has occured...",Toast.LENGTH_LONG);

                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
