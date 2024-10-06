package com.example.studentexpensetracker;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etMobileNumber, etPassword;
    private Button btnLogin;
    private TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        etMobileNumber = findViewById(R.id.et_mobile_number);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        tvRegister = findViewById(R.id.tv_register);

        // Set Login Button Click Listener
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        // Set Registration Click Listener
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to RegistrationActivity
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

    // Backend logic for login
    private void loginUser() {
        String mobileNumber = etMobileNumber.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // Validate Mobile Number
        if (TextUtils.isEmpty(mobileNumber)) {
            etMobileNumber.setError("Mobile number is required");
            return;
        }

        if (mobileNumber.length() != 10) {
            etMobileNumber.setError("Enter a valid 10-digit mobile number");
            return;
        }

        // Validate Password
        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Password is required");
            return;
        }

        // Assuming here that you are validating against a predefined username and password
        // For a real-world scenario, use Firebase, SQLite, or an API call to validate the credentials.
        if (mobileNumber.equals("1234567890") && password.equals("123")) {
            // Navigate to the main page or dashboard
            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(MainActivity.this, "Invalid Mobile Number or Password", Toast.LENGTH_SHORT).show();
        }

    }
}