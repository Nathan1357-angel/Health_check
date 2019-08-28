package com.example.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    EditText fname;
    EditText lname;
    EditText dob;
    EditText password;
    EditText pass;
    RadioGroup gender;
    RadioButton male;
    RadioButton female;
    Button submit;

    private static final String url = "jdbc:mysql://192.168.0.192:3306/myDB";
    private static final String user = "Nathan John";
    private static final String passw = "1357";
    Button btnFetch,btnClear;
    TextView txtData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        txtData = (TextView)this.findViewById(R.id.ingia1);
        fname=(EditText) findViewById(R.id.tobit);
        lname=(EditText) findViewById(R.id.ezra);
        dob=(EditText) findViewById(R.id.mordecai);
        gender=(RadioGroup) findViewById(R.id.rachel);
        male=(RadioButton) findViewById(R.id.mom);
        female=(RadioButton) findViewById(R.id.dad);
        password=(EditText) findViewById(R.id.nathan);
        pass=(EditText) findViewById(R.id.jj);
        submit=(Button) findViewById(R.id.asa);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if
                (fname.getText().toString().equals("") || lname.getText().toString().equals("") || dob.getText().toString().equals("") || password.getText().toString().equals("") || gender.isClickable()){
                    Toast.makeText(Registration.this, "Please Enter all detailes provided", Toast.LENGTH_LONG).show();
                }
                else{
                    String j=fname.getText().toString();
                    fname.setText("");
                    lname.setText("");
                    dob.setText("");
                    password.setText("");
                    gender.clearCheck();
                    Toast.makeText(Registration.this, "successfully", Toast.LENGTH_LONG).show();

                }

            }
        });




    }
}
