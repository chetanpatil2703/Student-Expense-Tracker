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

public class RegistrationActivity extends AppCompatActivity {

    private EditText etMobileNumber, etEmail, etPassword, etReenterPassword;
    private Button btnRegister;
    private TextView tvExistingMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Initialize UI elements
        etMobileNumber = findViewById(R.id.et_mobile_number);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etReenterPassword = findViewById(R.id.et_reenter_password);
        btnRegister = findViewById(R.id.btn_register);
        tvExistingMember = findViewById(R.id.tv_existing_member);

        // Set Register Button Click Listener
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        // Set Existing Member Click Listener (Navigate to Login)
        tvExistingMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to LoginActivity
                Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    // Backend logic for registration
    private void registerUser() {
        String mobileNumber = etMobileNumber.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String reenterPassword = etReenterPassword.getText().toString().trim();

        // Validate Mobile Number
        if (TextUtils.isEmpty(mobileNumber)) {
            etMobileNumber.setError("Mobile number is required");
            return;
        }

        if (mobileNumber.length() != 10) {
            etMobileNumber.setError("Enter a valid 10-digit mobile number");
            return;
        }

        // Validate Email ID
        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Email is required");
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Enter a valid email");
            return;
        }

        // Validate Password
        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Password is required");
            return;
        }

        // Validate Re-entered Password
        if (TextUtils.isEmpty(reenterPassword)) {
            etReenterPassword.setError("Please re-enter the password");
            return;
        }

        // Check if both passwords match
        if (!password.equals(reenterPassword)) {
            etReenterPassword.setError("Passwords do not match");
            return;
        }

        // Dummy logic to simulate registration (replace with actual authentication logic)
        Toast.makeText(RegistrationActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
        // After successful registration, navigate to login or dashboard
        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
