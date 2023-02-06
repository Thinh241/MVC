package com.example.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvc.model.User;

public class MainActivity extends AppCompatActivity {

    EditText edt_email, edt_password;
    TextView tv;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_email = findViewById(R.id.email);
        edt_password = findViewById(R.id.password);
        tv = findViewById(R.id.hienthi);
        bt = findViewById(R.id.login);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicklogin();
            }
        });
    }

    private void clicklogin() {
        String strEmail = edt_email.getText().toString().trim();
        String strPassword = edt_password.getText().toString().trim();

        User user = new User(strEmail, strPassword);
        tv.setVisibility(View.VISIBLE);
        if(user.isValidEmail() && user.isValidPassword()){
            tv.setText("Login Success");
            tv.setTextColor(getResources().getColor(R.color.purple_500));
        }else{
            tv.setText("Login Failed");
            tv.setTextColor(getResources().getColor(R.color.red));
        }
    }
}