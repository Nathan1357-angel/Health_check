package com.example.login;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText uname, password;
    Button login, signup;
    RequestQueue rq;
    StringRequest request;
    String login_url = "http://192.168.137.148/project/login.php";
    CheckBox remember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname = (EditText) findViewById(R.id.tobit);
        password = (EditText) findViewById(R.id.ezra);
        login = (Button) findViewById(R.id.ingia1);
        signup = (Button) findViewById(R.id.ingia);
        rq = Volley.newRequestQueue(this);

        login.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         if
                                         (uname.getText().toString().equals("") || password.getText().toString().equals("")) {
                                             Toast.makeText(MainActivity.this, "Please Enter all detailes provided", Toast.LENGTH_LONG).show();
                                         } else {
                                             String j = uname.getText().toString();
                                             uname.setText("");
                                             password.setText("");
                                             Toast.makeText(MainActivity.this, "successfully", Toast.LENGTH_LONG).show();

                                         }
                                         login.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View view) {
                                                 LOGIN();
                                             }
                                         });
                                     }

                                     public void LOGIN() {
                                         request = new StringRequest(Request.Method.POST, login_url, new Response.Listener<String>() {
                                             @Override
                                             public void onResponse(String response) {
                                                 JSONObject jo = null;
                                                 try {
                                                     jo = new JSONObject(response);
                                                 } catch (JSONException e) {
                                                     e.printStackTrace();
                                                 }
                                                 String mafanikio = null;
                                                 try {
                                                     mafanikio = jo.getString("success");
                                                 } catch (JSONException e) {
                                                     e.printStackTrace();
                                                 }
                                                 if (mafanikio.equals("1")) {
                                                     Toast.makeText(getApplicationContext(), "Good to Go", Toast.LENGTH_LONG).show();
                                                     Intent nn = new Intent(getApplicationContext(), MainActivity.class);
                                                     startActivity(nn);
                                                 } else if (mafanikio.equals("0")) {
                                                     Toast.makeText(getApplicationContext(), "Not Good to Go", Toast.LENGTH_LONG).show();
                                                 } else {
                                                     Toast.makeText(getApplicationContext(), "Poor Connection", Toast.LENGTH_LONG).show();
                                                 }
                                             }
                                         }, new Response.ErrorListener() {
                                             @Override
                                             public void onErrorResponse(VolleyError error) {

                                             }
                                         }) {
                                             @Override
                                             protected Map<String, String> getParams() {
                                                 Map<String, String> mselle = new HashMap<>();
                                                 mselle.put("username", uname.getText().toString());
                                                 mselle.put("password", password.getText().toString());
                                                 return mselle;
                                             }
                                         };
                                         rq.add(request);
                                     }
                                 }
        );
    }
}